package com.hbmax.item.armors;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class UnbreakableArmorItem extends ArmorItem {
    public UnbreakableArmorItem(ArmorMaterial material, Type type, Item.Properties properties) {
        super(material, type, properties);
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }
}