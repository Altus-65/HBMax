package com.hbmax.item;

import com.hbmax.registry.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemElectrode extends Item {

    private final int maxDurability;
    private final boolean isInfinite;

    public ItemElectrode(int maxDurability) {
        super(new Item.Properties().stacksTo(1).durability(maxDurability));
        this.maxDurability = maxDurability;
        this.isInfinite = maxDurability == 0;
    }

    public boolean isInfinite() {
        return isInfinite;
    }

    public int getDurabilityLeft(ItemStack stack) {
        if (isInfinite) return Integer.MAX_VALUE;
        return stack.getMaxDamage() - stack.getDamageValue();
    }

    public boolean useDurability(ItemStack stack, int amount) {
        if (isInfinite) return false;

        int newDamage = stack.getDamageValue() + amount;
        if (newDamage >= stack.getMaxDamage()) {
            // Электрод сгорел
            return true; // пора заменить на сгоревший
        }
        stack.setDamageValue(newDamage);
        return false;
    }

    // Получить сгоревший электрод
    public static ItemStack getBurntElectrode() {
        return new ItemStack(ModItems.ARC_ELECTRODE_BURNT.get());
    }


    @Override
    public boolean isBarVisible(ItemStack stack) {
        return !isInfinite;
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        if (isInfinite) return 13;
        return Math.round(13.0f * (stack.getMaxDamage() - stack.getDamageValue()) / stack.getMaxDamage());
    }

    @Override
    public int getBarColor(ItemStack stack) {
        if (isInfinite) return 0xFF55FF;
        float percent = (float) (stack.getMaxDamage() - stack.getDamageValue()) / stack.getMaxDamage();
        int r = (int) (255 * (1 - percent));
        int g = (int) (255 * percent);
        return (r << 16) | (g << 8);
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return isInfinite ? Rarity.EPIC : Rarity.UNCOMMON;
    }
}
