package com.hbmax.item.tools;

import com.hbmax.registry.ModItems;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModToolTiers implements Tier {
    // Параметры: уровень добычи, прочность, скорость, урон, зачаровываемость, материал для ремонта
    TITANIUM(3, 1000, 1.0f, 2.5f, 15,
            () -> Ingredient.of(ModItems.INGOT_TITANIUM.get())),
    STEEL(2, 250, 1.5f, 2.0f, 14,
            () -> Ingredient.of(ModItems.INGOT_STEEL.get())),
    ADVANCED_ALLOY(3, 1000, 1.5f, 3.0f, 10,
            () -> Ingredient.of(ModItems.INGOT_ADVANCED_ALLOY.get())),
    DESH(2, 20000, 1.5f, 2.0f, 5,
            () -> Ingredient.of(ModItems.INGOT_DESH.get())),
    COBALT(3, 750, 1.0f, 3.0f, 6,
                 () -> Ingredient.of(ModItems.INGOT_COBALT.get())),
    COBALT_DECORATED(3, 2500, 1.0f, 3.0f, 75,
                   () -> Ingredient.of(ModItems.INGOT_COBALT.get())),
    STARMETAL(3, 3000, 1.0f, 3.0f, 100,
                             () -> Ingredient.of(ModItems.INGOT_STARMETAL.get())),
    CMB(4, 5000, 1.0f, 4.0f, 25,
                      () -> Ingredient.of(ModItems.INGOT_COMBINE_STEEL.get())),
    BISMUTH(5, 7500, 1.0f, 6.0f, 35,
                () -> Ingredient.of(ModItems.INGOT_BISMUTH.get())),
    VOLCANIC(5, 5000, 1.0f, 5.0f, 15,
                    () -> Ingredient.of(ModItems.INGOT_METEORITE.get())),
    CHLOROPHYTE(5, 20000, 1.0f, 10.0f, 200,
                     () -> Ingredient.of(ModItems.INGOT_FIBERGLASS.get())),
    MESE(5, 20000, 1.0f, 42.0f, 500,
                        () -> Ingredient.of(ModItems.PLATE_PAA.get())),
    SCHRABIDIUM(3, 10000, 1.0f, 10.0f, 200,
                 () -> Ingredient.of(ModItems.INGOT_SCHRABIDIUM.get()));

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final Supplier<Ingredient> repairIngredient;

    ModToolTiers(int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = repairIngredient;
    }

    // Далее идут @Override методы для всех полей (getUses, getSpeed и т.д.)
    // Пример из статьи [citation:4]:
    @Override public int getUses() { return uses; }
    @Override public float getSpeed() { return speed; }
    @Override public float getAttackDamageBonus() { return damage; }
    @Override public int getLevel() { return level; }
    @Override public int getEnchantmentValue() { return enchantmentValue; }
    @Override public Ingredient getRepairIngredient() { return repairIngredient.get(); }
}
