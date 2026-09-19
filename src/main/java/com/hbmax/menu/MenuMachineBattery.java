package com.hbmax.menu;

import com.hbmax.blockentity.BlockEntityBattery;
import com.hbmax.energy.BatteryMode;
import com.hbmax.energy.BatteryPriority;
import com.hbmax.registry.ModMenuTypes;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import net.minecraftforge.items.SlotItemHandler;

public class MenuMachineBattery extends AbstractContainerMenu {

    private final BlockEntityBattery blockEntity;
    private final ContainerData data;

    public MenuMachineBattery(int id, Inventory inv, FriendlyByteBuf buf) {
        this(id, inv, (BlockEntityBattery) inv.player.level().getBlockEntity(buf.readBlockPos()));
    }

    @Override
    public void broadcastChanges() {
        super.broadcastChanges();
    }

    public MenuMachineBattery(int id, Inventory inv, BlockEntityBattery be) {

        super(ModMenuTypes.MACHINE_BATTERY.get(), id);

        this.blockEntity = be;
        this.data = be.data;

        addDataSlots(data);

        // battery slots
        addSlot(new SlotItemHandler(be.inventory, 0, 35, 17));
        addSlot(new SlotItemHandler(be.inventory, 1, 35, 53));
        addSlot(new SlotItemHandler(be.inventory, 2, 125, 17));
        addSlot(new SlotItemHandler(be.inventory, 3, 125, 53));

        // player inventory
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                addSlot(new Slot(
                        inv,
                        col + row * 9 + 9,
                        8 + col * 18,
                        84 + row * 18
                ));
            }
        }

        // hotbar
        for (int col = 0; col < 9; ++col) {
            addSlot(new Slot(
                    inv,
                    col,
                    8 + col * 18,
                    142
            ));
        }
    }

    public long getPowerDelta() {
        return blockEntity.getPowerDelta();
    }

    public long getEnergy() {
        return blockEntity.getEnergy().getEnergyStoredLong();
    }

    public long getMaxEnergy() {
        return blockEntity.getEnergy().getMaxEnergyStoredLong();
    }

    public float getEnergyPercent() {
        long max = getMaxEnergy();
        return max == 0 ? 0 : (float) getEnergy() / max;
    }

    public BatteryMode getMode() {

        int mode = data.get(0);

        if (mode < 0 || mode >= BatteryMode.values().length)
            return BatteryMode.NEUTRAL;

        return BatteryMode.values()[mode];
    }

    public BatteryMode getRedstoneMode() {

        int mode = data.get(1);

        if (mode < 0 || mode >= BatteryMode.values().length)
            return BatteryMode.NEUTRAL;

        return BatteryMode.values()[mode];
    }

    public BatteryPriority getPriority() {

        int p = data.get(2);

        if (p < 0 || p >= BatteryPriority.values().length)
            return BatteryPriority.NORMAL;

        return BatteryPriority.values()[p];
    }

    public BlockEntityBattery getBlockEntity() {
        return blockEntity;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return ItemStack.EMPTY;
    }
}

