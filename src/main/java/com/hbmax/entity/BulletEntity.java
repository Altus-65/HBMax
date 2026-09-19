package com.hbmax.entity;

import com.hbmax.item.ammo.AmmoItem;
import com.hbmax.registry.ModEntities;
import com.hbmax.registry.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class BulletEntity extends ThrowableItemProjectile {

    private float damage = 10.0f;
    private String ammoType = "kinetic";

    // Ссылка на патрон для применения эффектов
    // Не сохраняется в NBT — только для текущей сессии
    private AmmoItem ammoItem = null;

    // ── Конструктор для регистрации ────────────────────────────────────────

    public BulletEntity(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
    }

    // ── Конструктор для создания пули от GunItem ───────────────────────────

    public BulletEntity(Level level, Player shooter, float damage, String ammoType) {
        super(ModEntities.BULLET.get(), level);
        this.damage = damage;
        this.ammoType = ammoType;
        this.setOwner(shooter);
    }

    // ── Установка патрона для применения эффектов ──────────────────────────

    public void setAmmoItem(AmmoItem ammoItem) {
        this.ammoItem = ammoItem;
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.BULLET_ITEM.get();
    }

    // ── Попадание ──────────────────────────────────────────────────────────

    @Override
    protected void onHit(HitResult result) {
        if (level().isClientSide) return;

        if (result.getType() == HitResult.Type.ENTITY) {
            EntityHitResult entityHit = (EntityHitResult) result;

            if (entityHit.getEntity() instanceof LivingEntity target
                    && target != this.getOwner()) {

                // Наносим урон
                target.hurt(this.damageSources().generic(), this.damage);

                // Применяем эффекты от патрона если есть
                if (ammoItem != null) {
                    // Основной эффект
                    if (ammoItem.getPrimaryEffect() != null) {
                        ammoItem.getPrimaryEffect().apply(target);
                    }
                    // Вторичный эффект
                    if (ammoItem.getSecondaryEffect() != null) {
                        ammoItem.getSecondaryEffect().apply(target);
                    }
                }

                // Старая логика по типу патрона (для GunItem)
                if ("incendiary".equals(ammoType)) {
                    target.setSecondsOnFire(5);
                }
                if ("explosive".equals(ammoType)) {
                    level().explode(
                            this.getOwner(),
                            this.getX(), this.getY(), this.getZ(),
                            2.0F, false,
                            Level.ExplosionInteraction.TNT
                    );
                }
            }
        }

        // При попадании в блок — взрыв для взрывных патронов
        if (result.getType() == HitResult.Type.BLOCK && "explosive".equals(ammoType)) {
            level().explode(
                    this.getOwner(),
                    this.getX(), this.getY(), this.getZ(),
                    2.0F, false,
                    Level.ExplosionInteraction.TNT
            );
        }

        this.discard();
    }

    // ── NBT (сохраняем damage и ammoType) ─────────────────────────────────

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putFloat("damage", damage);
        tag.putString("ammoType", ammoType);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("damage")) damage = tag.getFloat("damage");
        if (tag.contains("ammoType")) ammoType = tag.getString("ammoType");
    }

    @Override
    public boolean isNoGravity() {
        return true;
    }

    @Override
    public void tick() {
        super.tick();

        if (tickCount > 100) {
            discard();
        }
    }

    // ── Геттеры ────────────────────────────────────────────────────────────

    public float getDamage() { return damage; }
    public String getAmmoType() { return ammoType; }
}