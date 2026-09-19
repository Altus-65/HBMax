package com.hbmax.blockentity;

import com.hbmax.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BlockEntityCable extends BlockEntity {

    private int buffer = 0;

    private final IEnergyStorage energyHandler = new IEnergyStorage() {
        @Override
        public int receiveEnergy(int maxReceive, boolean simulate) {
            if (maxReceive <= 0) return 0;
            if (!simulate) {
                buffer += maxReceive;
                setChanged();
            }
            return maxReceive;
        }

        @Override
        public int extractEnergy(int maxExtract, boolean simulate) { return 0; }
        @Override
        public int getEnergyStored() { return 0; }
        @Override
        public int getMaxEnergyStored() { return 0; }
        @Override
        public boolean canExtract() { return false; }
        @Override
        public boolean canReceive() { return true; }
    };

    private LazyOptional<IEnergyStorage> lazyEnergy = LazyOptional.empty();

    public BlockEntityCable(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CABLE.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, BlockEntityCable cable) {
        if (level.isClientSide) return;
        if (cable.buffer <= 0) return;

        int remaining = cable.buffer;

        for (Direction dir : Direction.values()) {
            if (remaining <= 0) break;
            BlockEntity neighbor = level.getBlockEntity(pos.relative(dir));
            if (neighbor == null) continue;

            var opt = neighbor.getCapability(ForgeCapabilities.ENERGY, dir.getOpposite());
            if (opt.isPresent()) {
                IEnergyStorage storage = opt.orElse(null);
                if (storage != null && storage.canReceive()) {
                    int accepted = storage.receiveEnergy(remaining, false);
                    remaining -= accepted;
                }
            }
        }

        cable.buffer = remaining;
        cable.setChanged();
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyEnergy = LazyOptional.of(() -> energyHandler);
    }

    @Override
    public void setRemoved() {
        lazyEnergy.invalidate();
        super.setRemoved();
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull net.minecraftforge.common.capabilities.Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ENERGY) return lazyEnergy.cast();
        return super.getCapability(cap, side);
    }
}