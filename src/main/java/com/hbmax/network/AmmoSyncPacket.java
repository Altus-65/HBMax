package com.hbmax.network;

import com.hbmax.item.GunItem;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;

import java.util.function.Supplier;

/**
 * AmmoSyncPacket — сервер отправляет клиенту актуальное количество патронов.
 * Нужен потому что NBT предмета не синхронизируется автоматически
 * при изменении на сервере — только при открытом инвентаре.
 *
 * Отправляй после каждого выстрела и после перезарядки:
 *
 *   AmmoSyncPacket.sendToPlayer(serverPlayer, stack);
 */
public class AmmoSyncPacket {

    private final int slot;       // слот в инвентаре
    private final int ammoCount;  // текущее количество патронов
    private final int reloadTimer; // оставшееся время перезарядки в тиках

    public AmmoSyncPacket(int slot, int ammoCount, int reloadTimer) {
        this.slot = slot;
        this.ammoCount = ammoCount;
        this.reloadTimer = reloadTimer;
    }

    // ── Сериализация ───────────────────────────────────────────────────────

    public void encode(FriendlyByteBuf buf) {
        buf.writeInt(slot);
        buf.writeInt(ammoCount);
        buf.writeInt(reloadTimer);
    }

    public AmmoSyncPacket(FriendlyByteBuf buf) {
        this.slot = buf.readInt();
        this.ammoCount = buf.readInt();
        this.reloadTimer = buf.readInt();
    }

    // ── Обработка на клиенте ───────────────────────────────────────────────

    public static void handle(AmmoSyncPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> handleClient(msg));
        ctx.get().setPacketHandled(true);
    }

    @OnlyIn(Dist.CLIENT)
    private static void handleClient(AmmoSyncPacket msg) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null) return;

        ItemStack stack = player.getInventory().getItem(msg.slot);
        if (!(stack.getItem() instanceof GunItem)) return;

        // Обновляем NBT на клиенте
        var tag = stack.getOrCreateTag();
        tag.putInt("CurrentAmmo", msg.ammoCount);
        tag.putInt("ReloadTimer", msg.reloadTimer);
    }

    // ── Статический метод для отправки с сервера ───────────────────────────

    public static void sendToPlayer(ServerPlayer player, ItemStack stack) {
        int slot = player.getInventory().selected;
        int ammo = stack.getOrCreateTag().getInt("CurrentAmmo");
        int reload = stack.getOrCreateTag().getInt("ReloadTimer");

        ModMessages.getChannel().send(
                PacketDistributor.PLAYER.with(() -> player),
                new AmmoSyncPacket(slot, ammo, reload)
        );
    }
}