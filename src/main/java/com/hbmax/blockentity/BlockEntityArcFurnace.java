package com.hbmax.blockentity;

import com.hbmax.block.BlockArcFurnace;
import com.hbmax.energy.CustomEnergyStorage;
import com.hbmax.item.ItemBattery;
import com.hbmax.item.ItemBatteryGen;
import com.hbmax.item.ItemElectrode;
import com.hbmax.network.FurnaceEnergySyncPacket;
import com.hbmax.network.ModMessages;
import com.hbmax.registry.ModItems;
import com.hbmax.menu.MenuMachineArcFurnace;
import com.hbmax.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
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
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class BlockEntityArcFurnace extends BlockEntity implements MenuProvider {

    // Слоты: 0 - электрод левый, 1 - электрод правый, 2 - вход, 3 - выход
    public final ItemStackHandler inventory = new ItemStackHandler(6) {  // 6 слотов!
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            // Слоты 0,1,2: электроды
            if (slot >= 0 && slot <= 2) {
                return stack.getItem() instanceof ItemElectrode;
            }
            // Слот 3: вход (любой предмет)
            if (slot == 3) return true;
            // Слот 4: выход (нельзя класть)
            if (slot == 4) return false;
            // Слот 5: батарейка
            if (slot == 5) {
                return stack.getItem() instanceof ItemBattery ||
                        stack.getItem() instanceof ItemBatteryGen;
            }
            return true;
        }
    };

    private final CustomEnergyStorage energy = new CustomEnergyStorage(50000, 5000, 2000);

    private int progress = 0;
    private int maxProgress = 20;
    private static final int ENERGY_PER_TICK = 100;

    public long powerDelta = 0;
    public long[] powerLog = new long[20];
    private int syncTimer = 0;

    private LazyOptional<IItemHandler> lazyInventory = LazyOptional.empty();
    private LazyOptional<CustomEnergyStorage> lazyEnergy = LazyOptional.empty();

    public BlockEntityArcFurnace(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MACHINE_ARC_FURNACE.get(), pos, state);
        for (int i = 0; i < powerLog.length; i++) {
            powerLog[i] = 0;
        }
    }

    private void useElectrodes() {
        useElectrodeInSlot(0);
        useElectrodeInSlot(1);
        useElectrodeInSlot(2);
    }

    public void syncToClient() {
        if (level == null || level.isClientSide) return;

        ModMessages.getChannel().send(
                net.minecraftforge.network.PacketDistributor.TRACKING_CHUNK.with(() -> level.getChunkAt(worldPosition)),
                new FurnaceEnergySyncPacket(worldPosition, energy.getEnergyStoredLong(), energy.getMaxEnergyStoredLong(), powerDelta)
        );
    }

    private void useElectrodeInSlot(int slot) {
        ItemStack electrodeStack = inventory.getStackInSlot(slot);
        if (electrodeStack.isEmpty()) return;

        if (electrodeStack.getItem() instanceof ItemElectrode electrode) {
            // Уменьшаем прочность на 1
            boolean shouldBreak = electrode.useDurability(electrodeStack, 1);
            if (shouldBreak) {
                // Электрод сломался - заменяем на сгоревший
                ItemStack burnt = new ItemStack(ModItems.ARC_ELECTRODE_BURNT.get());
                inventory.setStackInSlot(slot, burnt);
            }
            setChanged();
        }
    }

    public void resetPowerLog() {
        for (int i = 0; i < powerLog.length; i++) {
            powerLog[i] = 0;
        }
        powerDelta = 0;
    }

    private boolean canProcess() {
        // Проверка наличия всех 3 электродов
        if (!hasElectrodes()) return false;

        if (energy.getEnergyStoredLong() < ENERGY_PER_TICK) return false;

        Optional<SmeltingRecipe> recipe = getCurrentRecipe();
        if (recipe.isEmpty()) return false;

        ItemStack result = recipe.get().getResultItem(level.registryAccess());
        ItemStack output = inventory.getStackInSlot(4);

        if (output.isEmpty()) return true;
        if (!ItemStack.isSameItemSameTags(output, result)) return false;
        return output.getCount() + result.getCount() <= output.getMaxStackSize();
    }

    private void process() {
        if (!canProcess()) return;

        energy.extractEnergy(ENERGY_PER_TICK, false);
        progress++;

        if (progress >= maxProgress) {
            progress = 0;
            Optional<SmeltingRecipe> recipe = getCurrentRecipe();
            if (recipe.isPresent()) {
                ItemStack result = recipe.get().getResultItem(level.registryAccess());
                ItemStack output = inventory.getStackInSlot(4);

                // Уменьшаем входной предмет
                ItemStack input = inventory.getStackInSlot(3);
                input.shrink(1);

                // Добавляем результат
                if (output.isEmpty()) {
                    inventory.setStackInSlot(4, result.copy());
                } else {
                    output.grow(result.getCount());
                }

                useElectrodeInSlot(0);  // левый электрод
                useElectrodeInSlot(1);  // центр электрод
                useElectrodeInSlot(2);  // правый электрод
            }
        }

        setChanged();
    }

    private Optional<SmeltingRecipe> getCurrentRecipe() {
        ItemStack input = inventory.getStackInSlot(3);
        if (input.isEmpty()) return Optional.empty();
        return level.getRecipeManager().getRecipeFor(RecipeType.SMELTING,
                new SimpleContainer(input), level);
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, BlockEntityArcFurnace be) {
        if (level.isClientSide) return;

        long prevPower = be.energy.getEnergyStoredLong();

        // Зарядка от батарейки в слоте 5
        ItemStack batteryStack = be.inventory.getStackInSlot(5);
        if (!batteryStack.isEmpty()) {
            long space = be.energy.getMaxEnergyStoredLong() - be.energy.getEnergyStoredLong();
            if (space > 0) {
                batteryStack.getCapability(ForgeCapabilities.ENERGY).ifPresent(batteryCap -> {
                    long dischargeRate = getDischargeRateFromItem(batteryStack);
                    long toExtract = Math.min(dischargeRate, space);
                    if (toExtract > 0) {
                        int extracted = batteryCap.extractEnergy((int) Math.min(toExtract, Integer.MAX_VALUE), false);
                        if (extracted > 0) {
                            be.energy.receiveEnergyLong(extracted, false);
                        }
                    }
                });
            }
        }

        // Проверка наличия электродов
        boolean hasElectrodes = be.hasElectrodes();
        boolean wasProcessing = be.progress > 0;

        // Плавка
        if (hasElectrodes && be.canProcess()) {
            be.process();
        } else {
            if (be.progress > 0) be.progress = 0;
        }

        boolean isProcessing = be.progress > 0;
        if (wasProcessing != isProcessing || hasElectrodes != state.getValue(BlockArcFurnace.HAS_RODS)) {
            BlockArcFurnace.updateBlockState(isProcessing, hasElectrodes, level, pos);
        }

        // Расчёт дельты и синхронизация
        long currentPower = be.energy.getEnergyStoredLong();
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

        be.data.set(4, (int) be.powerDelta);

        be.syncTimer++;
        if (be.syncTimer >= 20) {
            be.syncTimer = 0;
            be.syncToClient();
        }

        be.setChanged();
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

    public static void clientTick(Level level, BlockPos pos, BlockState state, BlockEntityArcFurnace be) {
        // Партиклы для работающей печи
        if (state.getValue(BlockArcFurnace.LIT)) {
            // Добавим партиклы позже
        }
    }

    public CustomEnergyStorage getEnergy() { return energy; }
    public int getProgress() { return progress; }
    public int getMaxProgress() { return maxProgress; }
    public boolean hasElectrodes() {
        ItemStack left = inventory.getStackInSlot(0);
        ItemStack center = inventory.getStackInSlot(1);
        ItemStack right = inventory.getStackInSlot(2);

        if (left.isEmpty() || center.isEmpty() || right.isEmpty()) return false;

        if (!(left.getItem() instanceof ItemElectrode) ||
                !(center.getItem() instanceof ItemElectrode) ||
                !(right.getItem() instanceof ItemElectrode)) return false;

        // Проверяем что электроды не сгоревшие
        if (left.getItem() == ModItems.ARC_ELECTRODE_BURNT.get() ||
                center.getItem() == ModItems.ARC_ELECTRODE_BURNT.get() ||
                right.getItem() == ModItems.ARC_ELECTRODE_BURNT.get()) return false;

        return true;
    }

    public float getProgressPercent() {
        return maxProgress == 0 ? 0 : (float) progress / maxProgress;
    }

    public float getEnergyPercent() {
        return (float) energy.getEnergyStoredLong() / energy.getMaxEnergyStoredLong();
    }

    public final ContainerData data = new ContainerData() {
        @Override
        public int get(int index) {
            return switch (index) {
                case 0 -> progress;
                case 1 -> maxProgress;
                case 2 -> (int) Math.min(Integer.MAX_VALUE, energy.getEnergyStoredLong());
                case 3 -> (int) Math.min(Integer.MAX_VALUE, energy.getMaxEnergyStoredLong());
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

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.hbmax.arc_furnace");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return new MenuMachineArcFurnace(id, inv, this, data);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyInventory = LazyOptional.of(() -> inventory);
        lazyEnergy = LazyOptional.of(() -> energy);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyInventory.invalidate();
        lazyEnergy.invalidate();
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull net.minecraftforge.common.capabilities.Capability<T> cap,
                                                      @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) return lazyInventory.cast();
        if (cap == ForgeCapabilities.ENERGY) return lazyEnergy.cast();
        return super.getCapability(cap, side);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("inventory", inventory.serializeNBT());
        tag.putInt("progress", progress);
        tag.putLong("energy", energy.getEnergyStoredLong());
        tag.putLong("powerDelta", powerDelta);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        inventory.deserializeNBT(tag.getCompound("inventory"));
        progress = tag.getInt("progress");
        energy.forceSetEnergy(tag.getLong("energy"));
        powerDelta = tag.getLong("powerDelta");
    }

    public long getPowerDelta() {
        return powerDelta;
    }
}
