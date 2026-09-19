package com.hbmax.blockentity;

import com.hbmax.block.BlockElectricFurnace;
import com.hbmax.energy.CustomEnergyStorage;
import com.hbmax.item.ItemBattery;
import com.hbmax.item.ItemBatteryGen;
import com.hbmax.menu.MenuElectricFurnace;
import com.hbmax.network.FurnaceEnergySyncPacket;
import com.hbmax.registry.ModBlockEntities;
import com.hbmax.network.EnergySyncPacket;
import com.hbmax.network.ModMessages;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class BlockEntityElectricFurnace extends BlockEntity implements MenuProvider {

    private final ItemStackHandler itemHandler = new ItemStackHandler(3) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            if (slot == 2) {
                return stack.getItem() instanceof ItemBattery ||
                        stack.getItem() instanceof ItemBatteryGen;
            }
            if (slot == 1) return false;
            return true;
        }
    };
    private int syncTimer = 0;

    private final CustomEnergyStorage energyStorage = new CustomEnergyStorage(100_000L, 2000L, 2000L);
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    private LazyOptional<CustomEnergyStorage> lazyEnergyStorage = LazyOptional.empty();

    private int progress = 0;
    private int maxProgress = 200;
    private static final int ENERGY_PER_TICK = 30;

    // Для расчёта скорости
    public long powerDelta = 0;
    private long[] powerLog = new long[20];
    private long lastPower = 0;

    protected final ContainerData data = new ContainerData() {
        @Override
        public int get(int index) {
            return switch (index) {
                case 0 -> progress;
                case 1 -> maxProgress;
                case 2 -> (int) Math.min(Integer.MAX_VALUE, energyStorage.getEnergyStoredLong());
                case 3 -> (int) Math.min(Integer.MAX_VALUE, energyStorage.getMaxEnergyStoredLong());
                default -> 0;
            };
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case 0 -> progress = value;
                case 1 -> maxProgress = value;
            }
        }

        @Override
        public int getCount() { return 4; }
    };

    public BlockEntityElectricFurnace(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ELECTRIC_FURNACE.get(), pos, state);
        this.lastPower = energyStorage.getEnergyStoredLong();
        for (int i = 0; i < powerLog.length; i++) {
            powerLog[i] = 0;
        }
    }

    public long getPowerDelta() { return powerDelta; }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.hbmax.electric_furnace");
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return new MenuElectricFurnace(id, inv, this, data);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
        lazyEnergyStorage = LazyOptional.of(() -> energyStorage);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
        lazyEnergyStorage.invalidate();
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap,
                                                      @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) return lazyItemHandler.cast();
        if (cap == ForgeCapabilities.ENERGY) return lazyEnergyStorage.cast();
        return super.getCapability(cap, side);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("progress", progress);
        tag.putLong("energy", energyStorage.getEnergyStoredLong());
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
        progress = tag.getInt("progress");
        energyStorage.forceSetEnergy(tag.getLong("energy"));
        lastPower = energyStorage.getEnergyStoredLong();
    }

    public void syncToClient() {
        if (level == null || level.isClientSide) return;

        ModMessages.getChannel().send(
                net.minecraftforge.network.PacketDistributor.TRACKING_CHUNK.with(() -> level.getChunkAt(worldPosition)),
                new FurnaceEnergySyncPacket(worldPosition, energyStorage.getEnergyStoredLong(), energyStorage.getMaxEnergyStoredLong(), powerDelta)
        );
    }

    public static void tick(Level level, BlockPos pos, BlockState state, BlockEntityElectricFurnace be) {
        if (level.isClientSide) return;

        long prevPower = be.energyStorage.getEnergyStoredLong();

        // 1. Зарядка от батарейки в слоте 2
        chargeFromBattery(be);

        // 2. Плавка
        Optional<SmeltingRecipe> recipe = getCurrentRecipe(be, level);
        boolean working = false;

        if (recipe.isPresent() && be.canProcess(recipe.get()) && be.hasEnoughEnergy()) {
            be.energyStorage.extractEnergy(ENERGY_PER_TICK, false);
            be.progress++;
            working = true;

            if (be.progress >= be.maxProgress) {
                be.processItem(recipe.get());
                be.progress = 0;
            }
        } else {
            if (be.progress > 0) be.progress = 0;
        }

        // 3. Обновить состояние блока (LIT)
        if (state.hasProperty(BlockElectricFurnace.LIT)) {
            if (state.getValue(BlockElectricFurnace.LIT) != working) {
                level.setBlock(pos, state.setValue(BlockElectricFurnace.LIT, working), 3);
            }
        }

        // 4. Расчёт дельты
        long currentPower = be.energyStorage.getEnergyStoredLong();
        long delta = currentPower - prevPower;

        for (int i = 0; i < be.powerLog.length - 1; i++) {
            be.powerLog[i] = be.powerLog[i + 1];
        }
        be.powerLog[be.powerLog.length - 1] = delta;

        long sum = 0;
        for (int i = 0; i < be.powerLog.length; i++) {
            sum += be.powerLog[i];
        }
        be.powerDelta = sum / be.powerLog.length;

        // 5. Синхронизация раз в 20 тиков
        be.syncTimer++;
        if (be.syncTimer >= 20) {
            be.syncTimer = 0;
            be.syncToClient();
        }

        setChanged(level, pos, state);
    }

    private static void chargeFromBattery(BlockEntityElectricFurnace be) {
        ItemStack batteryStack = be.itemHandler.getStackInSlot(2);
        if (batteryStack.isEmpty()) return;

        long space = be.energyStorage.getMaxEnergyStoredLong() - be.energyStorage.getEnergyStoredLong();
        if (space <= 0) return;

        batteryStack.getCapability(ForgeCapabilities.ENERGY).ifPresent(batteryCap -> {
            long dischargeRate = getDischargeRateFromItem(batteryStack);
            long toExtract = Math.min(dischargeRate, space);

            if (toExtract > 0) {
                int extracted = batteryCap.extractEnergy((int) Math.min(toExtract, Integer.MAX_VALUE), false);
                if (extracted > 0) {
                    be.energyStorage.receiveEnergy(extracted, false);
                }
            }
        });
    }

    private static long getDischargeRateFromItem(ItemStack stack) {
        if (stack.getItem() instanceof ItemBattery battery) {
            return battery.getDischargeRate();
        }
        if (stack.getItem() instanceof ItemBatteryGen generator) {
            return generator.getDischargeRate();
        }
        return 2000;
    }

    private static Optional<SmeltingRecipe> getCurrentRecipe(BlockEntityElectricFurnace be,
                                                             Level level) {
        SimpleContainer inv = new SimpleContainer(be.itemHandler.getStackInSlot(0));
        return level.getRecipeManager().getRecipeFor(RecipeType.SMELTING, inv, level);
    }

    private boolean canProcess(SmeltingRecipe recipe) {
        ItemStack result = recipe.getResultItem(level.registryAccess());
        ItemStack output = itemHandler.getStackInSlot(1);
        if (output.isEmpty()) return true;
        if (!output.is(result.getItem())) return false;
        return output.getCount() + result.getCount() <= output.getMaxStackSize();
    }

    private boolean hasEnoughEnergy() {
        return energyStorage.getEnergyStoredLong() >= ENERGY_PER_TICK;
    }

    private void processItem(SmeltingRecipe recipe) {
        ItemStack result = recipe.getResultItem(level.registryAccess());
        ItemStack output = itemHandler.getStackInSlot(1);
        if (output.isEmpty()) {
            itemHandler.setStackInSlot(1, result.copy());
        } else {
            output.grow(result.getCount());
        }
        itemHandler.getStackInSlot(0).shrink(1);
    }

    public void drops() {
        SimpleContainer inv = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inv.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(level, worldPosition, inv);
    }

    public ItemStackHandler getItemHandler() { return itemHandler; }
    public CustomEnergyStorage getEnergyStorage() { return energyStorage; }
    public int getProgress() { return progress; }
    public int getMaxProgress() { return maxProgress; }
}