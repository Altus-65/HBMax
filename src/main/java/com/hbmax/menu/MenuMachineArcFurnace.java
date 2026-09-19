package com.hbmax.menu;

import com.hbmax.blockentity.BlockEntityArcFurnace;
import com.hbmax.registry.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;

public class MenuMachineArcFurnace extends AbstractContainerMenu {

    private final BlockEntityArcFurnace blockEntity;
    private final ContainerData data;

    // Серверный конструктор
    public MenuMachineArcFurnace(int id, Inventory inv, BlockEntityArcFurnace be, ContainerData data) {
        super(ModMenuTypes.MACHINE_ARC_FURNACE.get(), id);

        this.blockEntity = be;
        this.data = data;

        // Слоты машины
        this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
            // Слот 0: левый электрод
            this.addSlot(new SlotItemHandler(handler, 0, 38, 53));
            // Слот 1: центр электрод
            this.addSlot(new SlotItemHandler(handler, 1, 56, 53));
            // Слот 2: правый электрод
            this.addSlot(new SlotItemHandler(handler, 2, 74, 53));
            // Слот 3: вход (плавимый предмет)
            this.addSlot(new SlotItemHandler(handler, 3, 56, 17));
            // Слот 4: выход
            this.addSlot(new SlotItemHandler(handler, 4, 116, 35));
            // Слот 5: батарейка
            this.addSlot(new SlotItemHandler(handler, 5, 8, 53));
        });

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        addDataSlots(data);
    }

    // Клиентский конструктор
    public MenuMachineArcFurnace(int id, Inventory inv, FriendlyByteBuf buf) {
        this(id, inv, getBlockEntity(inv, buf), new SimpleContainerData(4));
    }

    private static BlockEntityArcFurnace getBlockEntity(Inventory inv, FriendlyByteBuf buf) {
        BlockEntity be = inv.player.level().getBlockEntity(buf.readBlockPos());
        if (be instanceof BlockEntityArcFurnace furnace) {
            return furnace;
        }
        throw new IllegalStateException("BlockEntity is not ArcFurnace!");
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack result = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot.hasItem()) {
            ItemStack stack = slot.getItem();
            result = stack.copy();

            // machine → player (индексы 0-3)
            if (index < 4) {
                if (!this.moveItemStackTo(stack, 4, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            }
            // player → machine
            else {
                // Пытаемся положить в слот электродов (0-1) или вход (2)
                if (!this.moveItemStackTo(stack, 0, 2, false)) {
                    if (!this.moveItemStackTo(stack, 2, 3, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            }

            if (stack.isEmpty()) slot.set(ItemStack.EMPTY);
            else slot.setChanged();
        }

        return result;
    }

    public int getProgress() {
        return data.get(0);
    }

    public int getMaxProgress() {
        return data.get(1);
    }

    public long getEnergy() {
        return data.get(2);
    }

    public long getMaxEnergy() {
        return data.get(3);
    }

    public float getProgressPercent() {
        return getMaxProgress() == 0 ? 0 : (float) getProgress() / getMaxProgress();
    }

    public float getEnergyPercent() {
        return getMaxEnergy() == 0 ? 0 : (float) getEnergy() / getMaxEnergy();
    }

    private void addPlayerInventory(Inventory inv) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(inv, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }
    }

    public BlockEntityArcFurnace getBlockEntity() {
        return blockEntity;
    }

    private void addPlayerHotbar(Inventory inv) {
        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(inv, col, 8 + col * 18, 142));
        }
    }

    public long getPowerDelta() {
        return blockEntity.getPowerDelta();
    }
}
