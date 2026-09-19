package com.hbmax.network;

import com.hbmax.blockentity.BlockEntityBattery;
import com.hbmax.energy.BatteryMode;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

import static java.time.chrono.JapaneseEra.values;

public class BatteryModePacket {

    private final BlockPos pos;
    private final int mode;

    private final boolean isRedstone;

    public BatteryModePacket(BlockPos pos, int mode, boolean isRedstone) {
        this.pos = pos;
        this.mode = mode;
        this.isRedstone = isRedstone;
    }

    public BatteryModePacket(FriendlyByteBuf buf) {
        this.pos = buf.readBlockPos();
        this.mode = buf.readInt();
        this.isRedstone = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBlockPos(pos);
        buf.writeInt(mode);
        buf.writeBoolean(isRedstone);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player == null) return;
            BlockEntity be = player.level().getBlockEntity(pos);
            if (be instanceof BlockEntityBattery battery) {
                if (isRedstone)
                    battery.setRedstoneMode(BatteryMode.values()[mode]);
                else
                    battery.setMode(BatteryMode.values()[mode]);
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
