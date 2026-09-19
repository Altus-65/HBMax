package com.hbmax.network;

import com.hbmax.blockentity.BlockEntityBattery;
import com.hbmax.energy.BatteryPriority;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

import static java.time.chrono.JapaneseEra.values;

public class BatteryPriorityPacket {

    private final BlockPos pos;
    private final int priority;

    public BatteryPriorityPacket(BlockPos pos, int priority) {
        this.pos = pos;
        this.priority = priority;
    }

    public BatteryPriorityPacket(FriendlyByteBuf buf) {
        this.pos = buf.readBlockPos();
        this.priority = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBlockPos(pos);
        buf.writeInt(priority);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player == null) return;
            BlockEntity be = player.level().getBlockEntity(pos);
            if (be instanceof BlockEntityBattery battery) {
                battery.setPriority(BatteryPriority.values()[priority]);
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
