package com.hbmax.network;

import com.hbmax.gun.HitscanShot;
import com.hbmax.gun.HitscanResult;
import com.hbmax.item.GunItem;
import com.hbmax.item.ammo.AmmoItem;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

/**
 * ShootPacket — клиент отправляет на сервер запрос на выстрел.
 * Сервер выполняет hitscan и отправляет эффекты обратно.
 */
public class ShootPacket {

    private final float yRot;
    private final float xRot;

    public ShootPacket(float yRot, float xRot) {
        this.yRot = yRot;
        this.xRot = xRot;
    }

    public ShootPacket(FriendlyByteBuf buf) {
        this.yRot = buf.readFloat();
        this.xRot = buf.readFloat();
    }

    public void encode(FriendlyByteBuf buf) {
        buf.writeFloat(yRot);
        buf.writeFloat(xRot);
    }

    public static void handle(ShootPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player == null) return;

            ItemStack stack = player.getMainHandItem();
            if (!(stack.getItem() instanceof GunItem gun)) return;

            // Применяем угол взгляда с клиента для точности
            player.setYRot(msg.yRot);
            player.setXRot(msg.xRot);

            gun.shoot(player.level(), player, stack);
        });
        ctx.get().setPacketHandled(true);
    }
}