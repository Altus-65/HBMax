package com.hbmax.item.ammo;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AmmoItem extends Item {

    private final float damage;
    private final AmmoType ammoType;
    private final AmmoEffect primaryEffect;
    private final AmmoEffect secondaryEffect;
    private final float speed;
    private final float inaccuracy;
    private final int color;
    private final boolean hasTracer;

    public AmmoItem(Properties properties, float damage, AmmoType ammoType,
                    AmmoEffect primaryEffect, AmmoEffect secondaryEffect,
                    float speed, float inaccuracy, int color, boolean hasTracer) {
        super(properties);
        this.damage = damage;
        this.ammoType = ammoType;
        this.primaryEffect = primaryEffect;
        this.secondaryEffect = secondaryEffect;
        this.speed = speed;
        this.inaccuracy = inaccuracy;
        this.color = color;
        this.hasTracer = hasTracer;
    }

    // Геттеры
    public float getDamage() { return damage; }
    public AmmoType getAmmoType() { return ammoType; }
    public AmmoEffect getPrimaryEffect() { return primaryEffect; }
    public AmmoEffect getSecondaryEffect() { return secondaryEffect; }
    public float getSpeed() { return speed; }
    public float getInaccuracy() { return inaccuracy; }
    public int getColor() { return color; }
    public boolean hasTracer() { return hasTracer; }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level,
                                List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.literal("§7Урон: §c" + damage));
        tooltip.add(Component.literal("§7Тип: §e" + ammoType.getId()));
        if (primaryEffect != AmmoEffect.NONE) {
            tooltip.add(Component.literal("§7Эффект: §5" + primaryEffect.name().toLowerCase()));
        }
        super.appendHoverText(stack, level, tooltip, flag);
    }
}
