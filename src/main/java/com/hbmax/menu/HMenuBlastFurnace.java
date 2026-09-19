package com.hbmax.menu;

import com.hbmax.blockentity.HBlastFurnaceBlockEntity;
import com.hbmax.registry.ModBlocks;
import com.hbmax.registry.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class HMenuBlastFurnace extends AbstractContainerMenu {
    public final HBlastFurnaceBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    private static final int INPUT1_SLOT = 0;
    private static final int INPUT2_SLOT = 1;
    private static final int FUEL_SLOT = 2;
    private static final int OUTPUT_SLOT = 3;

    public int getFuel() {
        return data.get(5);  // если добавишь в ContainerData
    }

    // Конструктор для сети (из буфера)
    public HMenuBlastFurnace(int id, Inventory inv, FriendlyByteBuf extraData) {
        this(id, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(7));
    }

    // Основной конструктор
    public HMenuBlastFurnace(int id, Inventory inv, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.BLAST_FURNACE_MENU.get(), id);
        this.blockEntity = (HBlastFurnaceBlockEntity) entity;
        this.level = inv.player.level();
        this.data = data;

        // Инвентарь игрока
        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        // Слоты печи
        IItemHandler handler = blockEntity
                .getCapability(ForgeCapabilities.ITEM_HANDLER)
                .orElseThrow(() -> new IllegalStateException("No item handler"));

        // Оригинальные координаты как в HBM
        this.addSlot(new SlotItemHandler(handler, INPUT1_SLOT, 80, 18));   // Вход 1
        this.addSlot(new SlotItemHandler(handler, INPUT2_SLOT, 80, 54));   // Вход 2
        this.addSlot(new SlotItemHandler(handler, FUEL_SLOT, 8, 36));     // Топливо
        this.addSlot(new SlotItemHandler(handler, OUTPUT_SLOT, 134, 36));  // Выход

        addDataSlots(data);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot.hasItem()) {
            ItemStack stack = slot.getItem();
            itemstack = stack.copy();
            if (index < 4) {
                if (!this.moveItemStackTo(stack, 4, 40, true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                // Проверка, можно ли положить в топливо
                if (HBlastFurnaceBlockEntity.isItemFuel(stack)) {
                    if (!this.moveItemStackTo(stack, FUEL_SLOT, FUEL_SLOT + 1, false)) {
                        return ItemStack.EMPTY;
                    }
                }
                // Или в обычные входы
                else if (!this.moveItemStackTo(stack, INPUT1_SLOT, INPUT2_SLOT + 1, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (stack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return itemstack;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                player, ModBlocks.BLAST_FURNACE_BLOCK.get());
    }

    // Геттеры для GUI
    public int getCookTime() { return data.get(0); }
    public int getCookTimeTotal() { return data.get(1); }
    public int getFuelAmount() { return data.get(2); }
    public int getMaxFuel() { return data.get(3); }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}