package com.hbmax.item.ammo;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public enum AmmoEffect {
    NONE(null, 0, 0),
    WITHER(MobEffects.WITHER, 100, 1),
    POISON(MobEffects.POISON, 80, 1),
    HUNGER(MobEffects.HUNGER, 200, 2),
    SLOWNESS(MobEffects.MOVEMENT_SLOWDOWN, 60, 2),
    WEAKNESS(MobEffects.WEAKNESS, 100, 1),
    BLINDNESS(MobEffects.BLINDNESS, 40, 0),
    LEVITATION(MobEffects.LEVITATION, 40, 0),
    GLOWING(MobEffects.GLOWING, 100, 0),
    CONFUSION(MobEffects.CONFUSION, 100, 0),
    HARM(MobEffects.HARM, 1, 1),
    REGENERATION(MobEffects.REGENERATION, 60, 0);  // негативный эффект для врага

    private final MobEffect effect;
    private final int duration;
    private final int amplifier;

    AmmoEffect(MobEffect effect, int duration, int amplifier) {
        this.effect = effect;
        this.duration = duration;
        this.amplifier = amplifier;
    }

    public void apply(LivingEntity target) {
        if (effect != null) {
            target.addEffect(new net.minecraft.world.effect.MobEffectInstance(effect, duration, amplifier));
        }
    }
}