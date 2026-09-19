package com.hbmax.gun;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * HitscanResult — результат выстрела.
 * Содержит список попаданий по сущностям и попадание в блок.
 * Отправляется клиенту для отображения эффектов.
 */
public class HitscanResult {

    private final List<EntityHit> entityHits = new ArrayList<>();
    private BlockHitResult blockHit = null;
    private boolean missed = true;
    private Vec3 effectiveEndPoint = null; // конечная точка луча с учётом затухания в воде

    public void setEffectiveEndPoint(Vec3 point) {
        this.effectiveEndPoint = point;
    }

    public Vec3 getEffectiveEndPoint() {
        return effectiveEndPoint;
    }

    // ── Попадание по сущности ──────────────────────────────────────────────

    public void addHit(LivingEntity entity, float damage, boolean headshot) {
        entityHits.add(new EntityHit(
                entity.getId(),
                entity.position().add(0, entity.getBbHeight() / 2, 0),
                damage,
                headshot
        ));
        missed = false;
    }

    // ── Попадание в блок ───────────────────────────────────────────────────

    public void setBlockHit(BlockHitResult hit) {
        this.blockHit = hit;
        missed = false;
    }

    // ── Геттеры ────────────────────────────────────────────────────────────

    public List<EntityHit> getEntityHits() {
        return Collections.unmodifiableList(entityHits);
    }

    public BlockHitResult getBlockHit() { return blockHit; }
    public boolean isMissed() { return missed; }
    public boolean hasEntityHits() { return !entityHits.isEmpty(); }
    public boolean hasBlockHit() { return blockHit != null; }

    // ── Внутренний класс попадания ─────────────────────────────────────────

    public record EntityHit(
            int entityId,
            Vec3 hitPosition,
            float damage,
            boolean headshot
    ) {}
}