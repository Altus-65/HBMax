package com.hbmax.network;

import com.hbmax.blockentity.BlockEntityBattery;
import com.hbmax.blockentity.BlockEntityElectricFurnace;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModMessages {
    private static SimpleChannel INSTANCE;
    private static int id = 0;

    public static void register() {
        if (INSTANCE != null) return;

        INSTANCE = NetworkRegistry.newSimpleChannel(
                new ResourceLocation("hbmax", "main"),
                () -> "1.0",
                s -> true,
                s -> true
        );

        INSTANCE.registerMessage(id++, BatteryModePacket.class,
                BatteryModePacket::toBytes,
                BatteryModePacket::new,
                BatteryModePacket::handle);

        INSTANCE.registerMessage(id++, BatteryPriorityPacket.class,
                BatteryPriorityPacket::toBytes,
                BatteryPriorityPacket::new,
                BatteryPriorityPacket::handle);

        INSTANCE.registerMessage(id++, EnergySyncPacket.class,
                EnergySyncPacket::toBytes,
                EnergySyncPacket::new,
                EnergySyncPacket::handle);

        INSTANCE.registerMessage(id++, FurnaceEnergySyncPacket.class,
                FurnaceEnergySyncPacket::toBytes,
                FurnaceEnergySyncPacket::new,
                FurnaceEnergySyncPacket::handle);

        INSTANCE.registerMessage(id++, ShootPacket.class,
                ShootPacket::encode,
                ShootPacket::new,
                ShootPacket::handle);

        INSTANCE.registerMessage(id++, ReloadPacket.class,
                ReloadPacket::encode,
                ReloadPacket::new,
                ReloadPacket::handle);

        INSTANCE.registerMessage(id++, HitscanEffectPacket.class,
                HitscanEffectPacket::encode,
                HitscanEffectPacket::new,
                HitscanEffectPacket::handle);

        INSTANCE.registerMessage(id++, AmmoSyncPacket.class,
                AmmoSyncPacket::encode,
                AmmoSyncPacket::new,
                AmmoSyncPacket::handle);
    }

    public static SimpleChannel getChannel() {
        return INSTANCE;
    }

    public static <MSG> void sendToServer(MSG msg) {
        INSTANCE.sendToServer(msg);
    }

    public static <MSG> void sendToAllTrackingFurnace(MSG msg, BlockEntityElectricFurnace furnace) {
        if (furnace.getLevel() == null) return;
        INSTANCE.send(PacketDistributor.TRACKING_CHUNK.with(() -> furnace.getLevel().getChunkAt(furnace.getBlockPos())), msg);
    }

    public static <MSG> void sendToAllTracking(MSG msg, BlockEntityBattery be) {
        if (be.getLevel() == null) return;
        INSTANCE.send(PacketDistributor.TRACKING_CHUNK.with(() -> be.getLevel().getChunkAt(be.getBlockPos())), msg);
    }
}