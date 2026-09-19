package com.hbmax.network;

import com.hbmax.blockentity.BlockEntityBattery;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class EnergySyncPacket {
    private final BlockPos pos;
    private final long energy;
    private final long maxEnergy;
    private final long powerDelta;  // ← объявили поле

    public EnergySyncPacket(BlockPos pos, long energy, long maxEnergy, long powerDelta) {
        this.pos = pos;
        this.energy = energy;
        this.maxEnergy = maxEnergy;
        this.powerDelta = powerDelta;  // ← сохраняем
    }

    // Конструктор для чтения из буфера
    public EnergySyncPacket(FriendlyByteBuf buf) {
        this.pos = buf.readBlockPos();
        this.energy = buf.readLong();
        this.maxEnergy = buf.readLong();
        this.powerDelta = buf.readLong();  // ← читаем
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBlockPos(pos);
        buf.writeLong(energy);
        buf.writeLong(maxEnergy);
        buf.writeLong(powerDelta);  // ← записываем
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            var level = ctx.get().getSender() != null ?
                    ctx.get().getSender().level() :
                    net.minecraft.client.Minecraft.getInstance().level;

            if (level == null) return;

            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof BlockEntityBattery battery) {
                battery.getEnergy().forceSetEnergy(energy);
                battery.powerDelta = powerDelta;
            }
        });
        ctx.get().setPacketHandled(true);
    }
}