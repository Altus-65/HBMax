package com.hbmax.item.armors;

import com.hbmax.registry.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {

    STEEL("hbmax:steel", 22, new int[]{2, 4, 5, 4}, 12,
            SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.0F,
            () -> Ingredient.of(ModItems.INGOT_STEEL.get())),
    TITANIUM("hbmax:titanium", 38, new int[]{3, 6, 8, 7}, 15,
            SoundEvents.ARMOR_EQUIP_IRON, 3.0F, 0.0F,
            () -> Ingredient.of(ModItems.INGOT_TITANIUM.get())),
    ALLOY("hbmax:alloy", 33, new int[]{3, 6, 8, 3}, 10,
            SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.0F,
            () -> Ingredient.of(ModItems.INGOT_ADVANCED_ALLOY.get())),
    COBALT("hbmax:cobalt", 42, new int[]{3, 6, 9, 8}, 15,
            SoundEvents.ARMOR_EQUIP_IRON, 3.5F, 0.0F,
            () -> Ingredient.of(ModItems.INGOT_COBALT.get())),
    STARMETAL("hbmax:starmetal", 50, new int[]{3, 6, 8, 7}, 100,
            SoundEvents.ARMOR_EQUIP_IRON, 4.0F, 0.0F,
            () -> Ingredient.of(ModItems.INGOT_STARMETAL.get())),
    CMB("hbmax:cmb", 75, new int[]{4, 7, 10, 9}, 25,
            SoundEvents.ARMOR_EQUIP_IRON, 5.0F, 0.2F,
            () -> Ingredient.of(ModItems.INGOT_COMBINE_STEEL.get())),
    SCHRABIDIUM("hbmax:schrabidium", 100, new int[]{5, 9, 12, 10}, 200,
            SoundEvents.ARMOR_EQUIP_IRON, 6.0F, 0.4F,
            () -> Ingredient.of(ModItems.INGOT_SCHRABIDIUM.get()));

    private static final int[] BASE_DURABILITY = new int[]{0, 0, 0, 0}; // Ботинки, штаны, нагрудник, шлем

    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    ModArmorMaterials(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue,
                      SoundEvent equipSound, float toughness, float knockbackResistance,
                      Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.slotProtections = slotProtections;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.slotProtections[type.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
