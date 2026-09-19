package com.hbmax.network;

import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkEvent;
import org.joml.Vector3f;

import java.util.function.Supplier;

/**
 * HitscanEffectPacket — сервер отправляет клиенту результат выстрела
 * для отображения партиклов, трассера и звука.
 *
 * shooterPos теперь приходит из точки дула (см. GunShootLogic),
 * а не из глаз — трассер визуально совпадает с реальным лучом.
 */
public class HitscanEffectPacket {

    public static final byte HIT_ENTITY = 0;
    public static final byte HIT_BLOCK  = 1;
    public static final byte HIT_MISS   = 2;

    private final Vec3 shooterPos;
    private final Vec3 hitPos;
    private final byte hitType;
    private final boolean headshot;
    private final float damage;
    private final int shooterId;

    public HitscanEffectPacket(Vec3 shooterPos, Vec3 hitPos,
                               byte hitType, boolean headshot,
                               float damage, int shooterId) {
        this.shooterPos = shooterPos;
        this.hitPos = hitPos;
        this.hitType = hitType;
        this.headshot = headshot;
        this.damage = damage;
        this.shooterId = shooterId;
    }

    public void encode(FriendlyByteBuf buf) {
        buf.writeDouble(shooterPos.x);
        buf.writeDouble(shooterPos.y);
        buf.writeDouble(shooterPos.z);
        buf.writeDouble(hitPos.x);
        buf.writeDouble(hitPos.y);
        buf.writeDouble(hitPos.z);
        buf.writeByte(hitType);
        buf.writeBoolean(headshot);
        buf.writeFloat(damage);
        buf.writeInt(shooterId);
    }

    public HitscanEffectPacket(FriendlyByteBuf buf) {
        this.shooterPos = new Vec3(buf.readDouble(), buf.readDouble(), buf.readDouble());
        this.hitPos     = new Vec3(buf.readDouble(), buf.readDouble(), buf.readDouble());
        this.hitType    = buf.readByte();
        this.headshot   = buf.readBoolean();
        this.damage     = buf.readFloat();
        this.shooterId  = buf.readInt();
    }

    public static void handle(HitscanEffectPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> handleClient(msg));
        ctx.get().setPacketHandled(true);
    }

    @OnlyIn(Dist.CLIENT)
    private static void handleClient(HitscanEffectPacket msg) {
        Minecraft mc = Minecraft.getInstance();
        Level level = mc.level;
        if (level == null) return;

        spawnTracer(level, msg.shooterPos, msg.hitPos);

        switch (msg.hitType) {
            case HIT_ENTITY -> spawnBloodParticles(level, msg.hitPos, msg.headshot);
            case HIT_BLOCK  -> spawnImpactParticles(level, msg.hitPos);
            case HIT_MISS   -> {}
        }

        if (msg.hitType == HIT_ENTITY && msg.damage > 0) {
            spawnDamageIndicator(level, msg.hitPos, msg.damage, msg.headshot);
        }
    }

    // ── Трассер — плотная линия партиклов вдоль реального луча ──────────────
    // Используем DUST с маленьким шагом — выглядит как сплошная линия,
    // а не редкие отдельные точки CRIT.

    @OnlyIn(Dist.CLIENT)
    private static void spawnTracer(Level level, Vec3 from, Vec3 to) {
        Vec3 dir = to.subtract(from);
        double length = dir.length();
        if (length < 0.01) return;

        Vec3 normalized = dir.normalize();

        // Шаг 0.15 блока — плотная "линия", не редкие точки
        double step = 0.15;
        int count = (int) (length / step);

        DustParticleOptions tracerColor = new DustParticleOptions(
                new Vector3f(1.0f, 0.9f, 0.5f), // тёплый жёлто-белый цвет трассера
                0.6f // размер
        );

        for (int i = 0; i < count; i++) {
            Vec3 pos = from.add(normalized.scale(i * step));
            level.addParticle(tracerColor, pos.x, pos.y, pos.z, 0, 0, 0);
        }
    }

    // ── Партиклы попадания по сущности ────────────────────────────────────

    @OnlyIn(Dist.CLIENT)
    private static void spawnBloodParticles(Level level, Vec3 pos, boolean headshot) {
        int count = headshot ? 14 : 7;
        for (int i = 0; i < count; i++) {
            level.addParticle(
                    ParticleTypes.DAMAGE_INDICATOR,
                    pos.x, pos.y, pos.z,
                    (Math.random() - 0.5) * 0.35,
                    (Math.random() - 0.5) * 0.35,
                    (Math.random() - 0.5) * 0.35
            );
        }

        // Дополнительная вспышка крита на хедшоте
        if (headshot) {
            for (int i = 0; i < 6; i++) {
                level.addParticle(
                        ParticleTypes.CRIT,
                        pos.x, pos.y + 0.1, pos.z,
                        (Math.random() - 0.5) * 0.2,
                        0.1,
                        (Math.random() - 0.5) * 0.2
                );
            }
        }
    }

    // ── Партиклы попадания в блок ──────────────────────────────────────────

    @OnlyIn(Dist.CLIENT)
    private static void spawnImpactParticles(Level level, Vec3 pos) {
        for (int i = 0; i < 5; i++) {
            level.addParticle(
                    ParticleTypes.SMOKE,
                    pos.x, pos.y, pos.z,
                    (Math.random() - 0.5) * 0.12,
                    0.06,
                    (Math.random() - 0.5) * 0.12
            );
        }

        for (int i = 0; i < 3; i++) {
            level.addParticle(
                    ParticleTypes.CRIT,
                    pos.x, pos.y, pos.z,
                    (Math.random() - 0.5) * 0.15,
                    (Math.random() - 0.5) * 0.15,
                    (Math.random() - 0.5) * 0.15
            );
        }
    }

    // ── Индикатор урона ───────────────────────────────────────────────────

    @OnlyIn(Dist.CLIENT)
    private static void spawnDamageIndicator(Level level, Vec3 pos,
                                             float damage, boolean headshot) {
        int count = headshot ? 4 : 1;
        for (int i = 0; i < count; i++) {
            level.addParticle(
                    ParticleTypes.ENCHANTED_HIT,
                    pos.x, pos.y + 0.5, pos.z,
                    0, 0.12, 0
            );
        }
    }
}
