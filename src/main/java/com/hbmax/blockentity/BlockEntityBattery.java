package com.hbmax.blockentity;

import com.hbmax.energy.BatteryPriority;
import com.hbmax.energy.BatteryMode;
import com.hbmax.energy.CustomEnergyStorage;
import com.hbmax.item.ItemBattery;
import com.hbmax.item.ItemBatteryGen;
import com.hbmax.menu.MenuMachineBattery;
import com.hbmax.network.EnergySyncPacket;
import com.hbmax.network.ModMessages;
import com.hbmax.registry.ModBlockEntities;
import com.hbmax.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class BlockEntityBattery extends BlockEntity implements MenuProvider {

    private final long capacity;
    private final CustomEnergyStorage energy;

    public final ItemStackHandler inventory = new ItemStackHandler(4);

    public long powerDelta = 0;
    private long[] powerLog = new long[20];
    private int syncTimer = 0;

    private BatteryMode mode = BatteryMode.NEUTRAL;
    private BatteryMode redstoneMode = BatteryMode.NEUTRAL;
    private BatteryPriority priority = BatteryPriority.NORMAL;

    private LazyOptional<IEnergyStorage> lazyEnergy;
    private LazyOptional<IItemHandler> lazyInventory;

    public BlockEntityBattery(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MACHINE_BATTERY.get(), pos, state);

        this.capacity = getCapacityFromBlock(state.getBlock());
        this.energy = new CustomEnergyStorage(capacity, Long.MAX_VALUE, 100_000);

        // Инициализируем лог нулями
        this.powerLog = new long[20];
        for (int i = 0; i < this.powerLog.length; i++) {
            this.powerLog[i] = 0;
        }

        lazyEnergy = LazyOptional.of(() -> energy);
        lazyInventory = LazyOptional.of(() -> inventory);
    }

    private long getCapacityFromBlock(Block block) {
        if (block == ModBlocks.MACHINE_POTATO_BATTERY.get()) return 100_000L;
        if (block == ModBlocks.MACHINE_BATTERY.get()) return 10_000_000L;
        if (block == ModBlocks.MACHINE_LITHIUM_BATTERY.get()) return 100_000_000L;
        if (block == ModBlocks.MACHINE_SCHRABIDIUM_BATTERY.get()) return 100_000_000_000L;
        if (block == ModBlocks.MACHINE_DESH_BATTERY.get()) return 1_000_000_000L;
        if (block == ModBlocks.MACHINE_SATURNITE_BATTERY.get()) return 10_000_000_000L;
        if (block == ModBlocks.MACHINE_EUPHEMIUM_BATTERY.get()) return 1_000_000_000_000L;
        if (block == ModBlocks.MACHINE_RADSPICE_BATTERY.get()) return 10_000_000_000_000L;
        if (block == ModBlocks.MACHINE_DINEUTRONIUM_BATTERY.get()) return 100_000_000_000_000L;
        if (block == ModBlocks.MACHINE_ELECTRONIUM_BATTERY.get()) return 1_000_000_000_000_000L;
        return 10_000_000L;
    }

    public CustomEnergyStorage getEnergy() { return energy; }
    public BatteryMode getMode() { return mode; }
    public BatteryMode getRedstoneMode() { return redstoneMode; }
    public BatteryPriority getPriority() { return priority; }
    public long getPowerDelta() { return powerDelta; }

    public void setMode(BatteryMode mode) { this.mode = mode; setChanged(); }
    public void setRedstoneMode(BatteryMode mode) { this.redstoneMode = mode; setChanged(); }
    public void setPriority(BatteryPriority priority) { this.priority = priority; setChanged(); }

    public BatteryMode getActiveMode() {
        if (level == null) return mode;
        return level.hasNeighborSignal(worldPosition) ? redstoneMode : mode;
    }

    public void syncToClient() {
        if (level == null || level.isClientSide) return;

        ModMessages.sendToAllTracking(
                new EnergySyncPacket(worldPosition, energy.getEnergyStoredLong(), capacity, powerDelta),
                this
        );
    }

    public final ContainerData data = new ContainerData() {
        @Override
        public int get(int index) {
            return switch (index) {
                case 0 -> mode.ordinal();
                case 1 -> redstoneMode.ordinal();
                case 2 -> priority.ordinal();
                default -> 0;
            };
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case 0 -> mode = BatteryMode.values()[value];
                case 1 -> redstoneMode = BatteryMode.values()[value];
                case 2 -> priority = BatteryPriority.values()[value];
            }
        }

        @Override
        public int getCount() { return 3; }
    };

    public static void tick(Level level, BlockPos pos, BlockState state, BlockEntityBattery be) {
        if (level.isClientSide) return;

        long prevPower = be.energy.getEnergyStoredLong();

        BatteryMode active = be.getActiveMode();

        // Зарядка блока из батарейки-предмета (слот 0)
        ItemStack inputBattery = be.inventory.getStackInSlot(0);
        if (!inputBattery.isEmpty() && active != BatteryMode.OFF) {
            if (inputBattery.getItem() instanceof ItemBattery battery) {
                long space = be.energy.getMaxEnergyStoredLong() - be.energy.getEnergyStoredLong();
                if (space > 0 && battery.getCharge(inputBattery) > 0) {
                    long rate = battery.getDischargeRate();
                    long available = battery.getCharge(inputBattery);
                    long toExtract = Math.min(rate, Math.min(available, space));
                    if (toExtract > 0) {
                        battery.removeCharge(inputBattery, toExtract);
                        be.energy.receiveEnergyLong(toExtract, false);
                        be.setChanged();
                    }
                }
                if (battery.getCharge(inputBattery) <= 0) {
                    ItemStack emptySlot = be.inventory.getStackInSlot(1);
                    if (emptySlot.isEmpty()) {
                        be.inventory.setStackInSlot(1, inputBattery.copy());
                        be.inventory.setStackInSlot(0, ItemStack.EMPTY);
                        be.setChanged();
                    }
                }
            }
            else if (inputBattery.getItem() instanceof ItemBatteryGen generator) {
                long space = be.energy.getMaxEnergyStoredLong() - be.energy.getEnergyStoredLong();
                if (space > 0) {
                    long rate = generator.getDischargeRate();
                    long toExtract = Math.min(rate, space);
                    if (toExtract > 0) {
                        be.energy.receiveEnergyLong(toExtract, false);
                        be.setChanged();
                    }
                }
            }
        }

        // Зарядка батарейки-предмета из блока (слот 2)
        ItemStack outputBattery = be.inventory.getStackInSlot(2);
        if (!outputBattery.isEmpty() && active != BatteryMode.OFF) {
            if (outputBattery.getItem() instanceof ItemBattery battery) {
                long available = be.energy.getEnergyStoredLong();
                if (available > 0 && battery.getCharge(outputBattery) < battery.getMaxCharge()) {
                    long rate = battery.getChargeRate();
                    long need = battery.getMaxCharge() - battery.getCharge(outputBattery);
                    long toAdd = Math.min(rate, Math.min(need, available));
                    if (toAdd > 0) {
                        battery.addCharge(outputBattery, toAdd);
                        be.energy.extractEnergyLong(toAdd, false);
                        be.setChanged();
                    }
                }
                if (battery.getCharge(outputBattery) >= battery.getMaxCharge()) {
                    ItemStack fullSlot = be.inventory.getStackInSlot(3);
                    if (fullSlot.isEmpty()) {
                        be.inventory.setStackInSlot(3, outputBattery.copy());
                        be.inventory.setStackInSlot(2, ItemStack.EMPTY);
                        be.setChanged();
                    }
                }
            }
        }

        // Выдача энергии соседним блокам (только в режиме OUTPUT)
        if (active == BatteryMode.OUTPUT) {
            long canSend = Math.min(be.energy.getMaxExtract(), be.energy.getEnergyStoredLong());
            if (canSend > 0) {
                for (Direction dir : Direction.values()) {
                    BlockEntity neighbor = level.getBlockEntity(pos.relative(dir));
                    if (neighbor == null) continue;

                    neighbor.getCapability(ForgeCapabilities.ENERGY, dir.getOpposite())
                            .ifPresent(storage -> {
                                if (storage.canReceive()) {
                                    int accepted = storage.receiveEnergy((int) Math.min(canSend, Integer.MAX_VALUE), false);
                                    if (accepted > 0) {
                                        be.energy.extractEnergyLong(accepted, false);
                                        be.setChanged();
                                    }
                                }
                            });
                }
            }
        }

        // Расчёт дельты энергии
        long currentPower = be.energy.getEnergyStoredLong();
        long delta = currentPower - prevPower;  // ← ЭТА СТРОКА БЫЛА ПРОПУЩЕНА

        // Сдвигаем лог
        for (int i = 0; i < be.powerLog.length - 1; i++) {
            be.powerLog[i] = be.powerLog[i + 1];
        }
        be.powerLog[be.powerLog.length - 1] = delta;

        // Считаем среднюю дельту за последние 20 тиков (1 секунда)
        long sum = 0;
        for (int i = 0; i < be.powerLog.length; i++) {
            sum += be.powerLog[i];
        }
        be.powerDelta = sum / be.powerLog.length;  // HE/тик

        // Синхронизация
        be.syncToClient();

        be.setChanged();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putLong("energy", energy.getEnergyStoredLong());
        tag.put("inventory", inventory.serializeNBT());
        tag.putInt("mode", mode.ordinal());
        tag.putInt("redstoneMode", redstoneMode.ordinal());
        tag.putInt("priority", priority.ordinal());
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        energy.forceSetEnergy(tag.getLong("energy"));
        inventory.deserializeNBT(tag.getCompound("inventory"));
        mode = BatteryMode.values()[tag.getInt("mode")];
        redstoneMode = BatteryMode.values()[tag.getInt("redstoneMode")];
        priority = BatteryPriority.values()[tag.getInt("priority")];
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ENERGY) return lazyEnergy.cast();
        if (cap == ForgeCapabilities.ITEM_HANDLER) return lazyInventory.cast();
        return super.getCapability(cap, side);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyEnergy.invalidate();
        lazyInventory.invalidate();
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.hbmax.battery");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return new MenuMachineBattery(id, inv, this);
    }
}