package com.hbmax.gun;

import com.hbmax.item.ammo.AmmoItem;
import com.hbmax.network.HitscanEffectPacket;
import com.hbmax.network.ModMessages;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PacketDistributor;

/**
 * GunShootLogic — логика выстрела.
 * ВАЖНО: shooterPos для трассера теперь берётся из той же точки дула,
 * что и в HitscanShot — иначе трассер визуально стартует не оттуда,
 * откуда реально летела пуля (из глаз вместо ствола).
 */
public class GunShootLogic {

    private static final float DEFAULT_RANGE = 100.0f;
    private static final int DEFAULT_PENETRATION = 1;

    public static void execute(Player player, ItemStack stack, AmmoItem ammoItem) {
        if (!(player.level() instanceof ServerLevel serverLevel)) return;

        boolean isAiming = stack.getOrCreateTag().getBoolean("Zooming");
        float spreadMultiplier = isAiming ? 0.3f : 1.0f;

        // Та же точка дула, что использует HitscanShot.fire() внутри —
        // получаем её отдельно, чтобы трассер совпадал визуально с реальным лучом.
        Vec3 muzzlePos = HitscanShot.getMuzzlePositionPublic(player);

        HitscanResult result = HitscanShot.fire(
                player,
                ammoItem,
                DEFAULT_RANGE,
                DEFAULT_PENETRATION,
                spreadMultiplier
        );

        if (result.hasEntityHits()) {
            for (HitscanResult.EntityHit hit : result.getEntityHits()) {
                HitscanEffectPacket packet = new HitscanEffectPacket(
                        muzzlePos,
                        hit.hitPosition(),
                        HitscanEffectPacket.HIT_ENTITY,
                        hit.headshot(),
                        hit.damage(),
                        player.getId()
                );
                sendToNearby(serverLevel, player, packet);
            }
        } else if (result.hasBlockHit()) {
            BlockHitResult blockHit = result.getBlockHit();
            HitscanEffectPacket packet = new HitscanEffectPacket(
                    muzzlePos,
                    blockHit.getLocation(),
                    HitscanEffectPacket.HIT_BLOCK,
                    false,
                    0,
                    player.getId()
            );
            sendToNearby(serverLevel, player, packet);
        } else {
            // Промах — трассер до эффективной (возможно обрезанной водой) дальности.
            // result хранит итоговую точку через getEffectiveEndPoint().
            Vec3 missPos = result.getEffectiveEndPoint() != null
                    ? result.getEffectiveEndPoint()
                    : muzzlePos.add(player.getLookAngle().scale(DEFAULT_RANGE));

            HitscanEffectPacket packet = new HitscanEffectPacket(
                    muzzlePos,
                    missPos,
                    HitscanEffectPacket.HIT_MISS,
                    false,
                    0,
                    player.getId()
            );
            sendToNearby(serverLevel, player, packet);
        }
    }

    private static void sendToNearby(ServerLevel level, Player shooter,
                                     HitscanEffectPacket packet) {
        ModMessages.getChannel().send(
                PacketDistributor.NEAR.with(() ->
                        new PacketDistributor.TargetPoint(
                                shooter.getX(),
                                shooter.getY(),
                                shooter.getZ(),
                                64.0,
                                level.dimension()
                        )
                ),
                packet
        );
    }
}