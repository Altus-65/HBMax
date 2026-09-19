package com.hbmax.item.tools;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;

public class UnbreakableAxeItem extends AxeItem {
    public UnbreakableAxeItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false; // Инструмент никогда не теряет прочность
    }
}
