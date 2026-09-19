package com.hbmax.network;

import com.hbmax.item.GunItem;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ReloadPacket {

    public ReloadPacket() {}

    public ReloadPacket(FriendlyByteBuf buf) {}

    public void encode(FriendlyByteBuf buf) {}

    public static void handle(ReloadPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();

            if (player == null) return;

            ItemStack stack = player.getMainHandItem();

            if (stack.getItem() instanceof GunItem gun) {
                gun.reload(player, stack);
            }
        });

        ctx.get().setPacketHandled(true);
    }
}