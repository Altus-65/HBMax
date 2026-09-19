package com.hbmax.gun;

import com.hbmax.item.ammo.AmmoItem;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.Optional;

/**
 * HitscanShot — мгновенный raycast выстрел.
 *
 * Точка старта — дуло оружия (смещена от глаз вперёд и вниз),
 * не глаза напрямую, чтобы трассер и попадания смотрелись реалистично.
 *
 * Под водой пуля теряет дальность и урон — расчёт идёт по шагам вдоль луча,
 * на каждом шаге проверяется погружена ли точка в жидкость; если да,
 * взводится коэффициент затухания.
 */
public class HitscanShot {

    // Смещение точки старта относительно глаз игрока:
    // вперёд (по направлению взгляда) и немного вниз/вбок под руку с оружием.
    private static final double MUZZLE_FORWARD = 0.4;
    private static final double MUZZLE_DOWN    = 0.12;
    private static final double MUZZLE_RIGHT   = 0.15;

    // Затухание в воде
    private static final float WATER_DAMAGE_FALLOFF_PER_BLOCK = 0.15f; // -15% урона за блок воды
    private static final float WATER_RANGE_FALLOFF_PER_BLOCK  = 0.30f; // дальность сокращается быстрее урона
    private static final double STEP_LENGTH = 0.25; // шаг проверки воды вдоль луча

    public static HitscanResult fire(Player player, AmmoItem ammo,
                                     float range, int penetration,
                                     float spreadMultiplier) {
        Level level = player.level();

        Vec3 start = getMuzzlePosition(player);
        Vec3 direction = player.getLookAngle();
        direction = applySpread(direction, ammo.getInaccuracy() * spreadMultiplier, player.getRandom());

        // Считаем сколько блоков воды на пути и где обрывается эффективная дальность
        WaterPath waterPath = traceWaterPath(level, start, direction, range);
        float effectiveRange = waterPath.clampedRange();
        float damageMultiplier = waterPath.damageMultiplier();

        Vec3 end = start.add(direction.scale(effectiveRange));

        HitscanResult result = new HitscanResult();
        result.setEffectiveEndPoint(end);
        Vec3 rayStart = start;
        int hits = 0;

        while (hits < penetration) {
            EntityHitResult entityHit = findEntity(level, player, rayStart, end);

            BlockHitResult blockHit = level.clip(new ClipContext(
                    rayStart, end,
                    ClipContext.Block.COLLIDER,
                    ClipContext.Fluid.NONE,
                    player
            ));

            double entityDist = entityHit != null
                    ? entityHit.getLocation().distanceTo(rayStart)
                    : Double.MAX_VALUE;
            double blockDist = blockHit.getType() != HitResult.Type.MISS
                    ? blockHit.getLocation().distanceTo(rayStart)
                    : Double.MAX_VALUE;

            if (entityDist < blockDist && entityHit != null) {
                Entity target = entityHit.getEntity();
                if (target instanceof LivingEntity living) {
                    float damage = ammo.getDamage() * damageMultiplier;

                    if (isHeadshot(entityHit, living)) {
                        damage *= 2.0f;
                        result.addHit(living, damage, true);
                    } else {
                        result.addHit(living, damage, false);
                    }

                    // Сбрасываем invulnerableTime — иначе быстрые повторные выстрелы
                    // (hitscan, не как ванильные мечи) будут поглощаться без урона.
                    living.invulnerableTime = 0;

                    living.hurt(player.damageSources().playerAttack(player), damage);

                    if (ammo.getPrimaryEffect() != null)
                        ammo.getPrimaryEffect().apply(living);
                    if (ammo.getSecondaryEffect() != null)
                        ammo.getSecondaryEffect().apply(living);

                    applyAmmoTypeEffects(level, player, living, ammo, entityHit.getLocation());
                }

                hits++;
                rayStart = entityHit.getLocation().add(direction.scale(0.1));

            } else if (blockDist < Double.MAX_VALUE) {
                result.setBlockHit(blockHit);
                break;
            } else {
                break;
            }
        }

        return result;
    }

    // ── Точка дула оружия (публичный доступ для эффектов) ─────────────────

    public static Vec3 getMuzzlePositionPublic(Player player) {
        return getMuzzlePosition(player);
    }

    private static Vec3 getMuzzlePosition(Player player) {
        Vec3 eye = player.getEyePosition();
        Vec3 look = player.getLookAngle();

        // Вектор "вправо" относительно направления взгляда (для смещения дула под руку)
        Vec3 right = look.cross(new Vec3(0, 1, 0)).normalize();

        return eye
                .add(look.scale(MUZZLE_FORWARD))
                .add(right.scale(MUZZLE_RIGHT))
                .add(0, -MUZZLE_DOWN, 0);
    }

    // ── Трассировка воды вдоль луча ─────────────────────────────────────────

    private record WaterPath(float clampedRange, float damageMultiplier) {}

    private static WaterPath traceWaterPath(Level level, Vec3 start, Vec3 direction, float maxRange) {
        double traveled = 0;
        double waterBlocksPassed = 0;
        float rangeMultiplier = 1.0f;

        while (traveled < maxRange) {
            Vec3 point = start.add(direction.scale(traveled));
            var blockPos = net.minecraft.core.BlockPos.containing(point);
            var fluidState = level.getFluidState(blockPos);

            if (fluidState.is(FluidTags.WATER)) {
                waterBlocksPassed += STEP_LENGTH;
                // Каждый блок воды дополнительно "крадёт" дальность
                rangeMultiplier -= (float) (WATER_RANGE_FALLOFF_PER_BLOCK * STEP_LENGTH);
                if (rangeMultiplier <= 0.05f) {
                    // Пуля гасится почти полностью — обрезаем дальность здесь
                    return new WaterPath((float) traveled, 0.0f);
                }
            }

            traveled += STEP_LENGTH;
        }

        float damageMultiplier = (float) Math.max(0.0,
                1.0 - waterBlocksPassed * WATER_DAMAGE_FALLOFF_PER_BLOCK);

        // Если в воде вообще не была — дальность не трогаем
        float finalRange = waterBlocksPassed > 0
                ? (float) (maxRange * Math.max(0.1, rangeMultiplier))
                : maxRange;

        return new WaterPath(finalRange, damageMultiplier);
    }

    // ── Поиск сущности на пути луча ───────────────────────────────────────

    private static EntityHitResult findEntity(Level level, Player shooter,
                                              Vec3 start, Vec3 end) {
        double closestDist = Double.MAX_VALUE;
        Entity closestEntity = null;
        Vec3 closestHitPos = null;

        AABB searchBox = new AABB(start, end).inflate(1.0);
        List<Entity> candidates = level.getEntities(shooter, searchBox,
                e -> e.isAlive() && e != shooter && e.isPickable());

        for (Entity candidate : candidates) {
            AABB hitBox = candidate.getBoundingBox().inflate(0.1);
            Optional<Vec3> hit = hitBox.clip(start, end);

            if (hit.isPresent()) {
                double dist = start.distanceTo(hit.get());
                if (dist < closestDist) {
                    closestDist = dist;
                    closestEntity = candidate;
                    closestHitPos = hit.get();
                }
            }
        }

        if (closestEntity != null) {
            return new EntityHitResult(closestEntity, closestHitPos);
        }
        return null;
    }

    // ── Определение headshot ───────────────────────────────────────────────

    private static boolean isHeadshot(EntityHitResult hit, LivingEntity target) {
        AABB box = target.getBoundingBox();
        double headY = box.minY + (box.maxY - box.minY) * 0.75;
        return hit.getLocation().y >= headY;
    }

    // ── Применение эффектов по типу патрона ───────────────────────────────

    private static void applyAmmoTypeEffects(Level level, Player shooter,
                                             LivingEntity target, AmmoItem ammo,
                                             Vec3 hitPos) {
//        switch (ammo.getAmmoType()) {
//            case INCENDIARY -> target.setSecondsOnFire(5);
//            case EXPLOSIVE  -> level.explode(shooter,
//                    hitPos.x, hitPos.y, hitPos.z,
//                    1.5f, false, Level.ExplosionInteraction.TNT);
//            case CRYOGENIC  -> target.addEffect(new net.minecraft.world.effect.MobEffectInstance(
//                    net.minecraft.world.effect.MobEffects.MOVEMENT_SLOWDOWN, 60, 3));
//            case ELECTRIC   -> {
//                List<LivingEntity> nearby = level.getEntitiesOfClass(LivingEntity.class,
//                        target.getBoundingBox().inflate(4.0),
//                        e -> e != target && e != shooter);
//                int chainCount = Math.min(3, nearby.size());
//                for (int i = 0; i < chainCount; i++) {
//                    nearby.get(i).hurt(shooter.damageSources().playerAttack(shooter),
//                            ammo.getDamage() * 0.5f);
//                }
//            }
//            default -> {}
//        }
    }

    // ── Разброс пуль ──────────────────────────────────────────────────────

    private static Vec3 applySpread(Vec3 direction, float inaccuracy,
                                    net.minecraft.util.RandomSource random) {
        if (inaccuracy <= 0) return direction;
        double spread = inaccuracy * 0.017453292;
        double dx = (random.nextDouble() - 0.5) * spread;
        double dy = (random.nextDouble() - 0.5) * spread;
        double dz = (random.nextDouble() - 0.5) * spread;
        return direction.add(dx, dy, dz).normalize();
    }
}