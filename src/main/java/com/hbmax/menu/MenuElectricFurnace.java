package com.hbmax.menu;

import com.hbmax.blockentity.BlockEntityElectricFurnace;
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

public class MenuElectricFurnace extends AbstractContainerMenu {

    private final BlockEntityElectricFurnace blockEntity;
    private final ContainerData data;

    // ───────── SERVER CONSTRUCTOR ─────────
    public MenuElectricFurnace(int id, Inventory inv,
                               BlockEntityElectricFurnace be,
                               ContainerData data) {

        super(ModMenuTypes.ELECTRIC_FURNACE.get(), id);

        this.blockEntity = be;
        this.data = data;

        // слоты машины
        this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
            this.addSlot(new SlotItemHandler(handler, 0, 56, 17));  // input
            this.addSlot(new SlotItemHandler(handler, 1, 116, 35)); // output
            this.addSlot(new SlotItemHandler(handler, 2, 56, 53));  // батарея снизу
        });

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        addDataSlots(data);
    }

    // ───────── CLIENT CONSTRUCTOR ─────────
    public MenuElectricFurnace(int id, Inventory inv, FriendlyByteBuf buf) {
        this(id, inv,
                getBlockEntity(inv, buf),
                new SimpleContainerData(4)
        );
    }

    private static BlockEntityElectricFurnace getBlockEntity(Inventory inv,
                                                             FriendlyByteBuf buf) {

        BlockEntity be = inv.player.level().getBlockEntity(buf.readBlockPos());

        if (be instanceof BlockEntityElectricFurnace furnace) {
            return furnace;
        }

        throw new IllegalStateException("BlockEntity is not ElectricFurnace!");
    }

    // ───────── VALID ─────────
    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    // ───────── SHIFT CLICK ─────────
    @Override
    public ItemStack quickMoveStack(Player player, int index) {

        ItemStack result = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot.hasItem()) {
            ItemStack stack = slot.getItem();
            result = stack.copy();

            // machine → player
            if (index < 3) {
                if (!this.moveItemStackTo(stack, 3, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            }
            // player → machine (только в слот 0 или 2)
            else {
                if (!this.moveItemStackTo(stack, 0, 1, false)) {
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

    // ───────── GETTERS FOR GUI ─────────
    public int getProgress() {
        return data.get(0);
    }

    public int getMaxProgress() {
        return data.get(1);
    }

    public long getEnergy() {
        return (long) data.get(2);
    }

    public long getPowerDelta() {
        return blockEntity.getPowerDelta();
    }

    public long getMaxEnergy() {
        return (long) data.get(3);
    }

    public float getProgressPercent() {
        return getMaxProgress() == 0 ? 0 :
                (float) getProgress() / getMaxProgress();
    }

    public float getEnergyPercent() {
        return getMaxEnergy() == 0 ? 0 :
                (float) getEnergy() / getMaxEnergy();
    }

    // ───────── PLAYER INVENTORY ─────────
    private void addPlayerInventory(Inventory inv) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(inv,
                        col + row * 9 + 9,
                        8 + col * 18,
                        84 + row * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory inv) {
        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(inv,
                    col,
                    8 + col * 18,
                    142));
        }
    }
}
