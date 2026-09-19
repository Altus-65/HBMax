package com.hbmax.network;

import com.hbmax.blockentity.BlockEntityArcFurnace;
import com.hbmax.blockentity.BlockEntityElectricFurnace;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class FurnaceEnergySyncPacket {
    private final BlockPos pos;
    private final long energy;
    private final long maxEnergy;
    private final long powerDelta;

    public FurnaceEnergySyncPacket(BlockPos pos, long energy, long maxEnergy, long powerDelta) {
        this.pos = pos;
        this.energy = energy;
        this.maxEnergy = maxEnergy;
        this.powerDelta = powerDelta;
    }

    public FurnaceEnergySyncPacket(FriendlyByteBuf buf) {
        this.pos = buf.readBlockPos();
        this.energy = buf.readLong();
        this.maxEnergy = buf.readLong();
        this.powerDelta = buf.readLong();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBlockPos(pos);
        buf.writeLong(energy);
        buf.writeLong(maxEnergy);
        buf.writeLong(powerDelta);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            var level = ctx.get().getSender() != null ?
                    ctx.get().getSender().level() :
                    net.minecraft.client.Minecraft.getInstance().level;

            if (level == null) return;

            BlockEntity be = level.getBlockEntity(pos);

            // Обычная печь
            if (be instanceof BlockEntityElectricFurnace furnace) {
                furnace.getEnergyStorage().forceSetEnergy(energy);
                furnace.powerDelta = powerDelta;
            }
            // Дуговая печь
            else if (be instanceof BlockEntityArcFurnace arcFurnace) {
                arcFurnace.getEnergy().forceSetEnergy(energy);
                arcFurnace.powerDelta = powerDelta;
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
