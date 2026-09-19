package com.hbmax.energy;

import net.minecraftforge.energy.IEnergyStorage;

public class CustomEnergyStorage implements IEnergyStorage {

    protected long energy;
    protected long capacity;
    protected long maxReceive;
    protected long maxExtract;

    public CustomEnergyStorage(long capacity, long maxReceive, long maxExtract) {
        this.capacity = capacity;
        this.maxReceive = maxReceive;
        this.maxExtract = maxExtract;
    }

    public void forceSetEnergy(long energy) {
        this.energy = Math.min(energy, capacity);
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        long received = Math.min(
                capacity - energy,
                Math.min(this.maxReceive, maxReceive)
        );
        if (!simulate) energy += received;
        return (int) received;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        long extracted = Math.min(
                energy,
                Math.min(this.maxExtract, maxExtract)
        );
        if (!simulate) energy -= extracted;
        return (int) extracted;
    }

    // Добавьте эти методы для работы с long
    public long receiveEnergyLong(long maxReceive, boolean simulate) {
        long space = capacity - energy;
        long received = Math.min(space, Math.min(this.maxReceive, maxReceive));



        if (!simulate) {
            energy += received;
        }
        return received;
    }

    public long extractEnergyLong(long maxExtract, boolean simulate) {
        long extracted = Math.min(
                energy,
                Math.min(this.maxExtract, maxExtract)
        );
        if (!simulate) energy -= extracted;
        return extracted;
    }

    @Override
    public int getEnergyStored() {
        return (int) Math.min(Integer.MAX_VALUE, energy);
    }

    public long getEnergyStoredLong() {
        return energy;
    }

    @Override
    public int getMaxEnergyStored() {
        return (int) Math.min(Integer.MAX_VALUE, capacity);
    }

    public long getMaxEnergyStoredLong() {
        return capacity;
    }

    public long getMaxReceive() {
        return maxReceive;
    }

    public long getMaxExtract() {
        return maxExtract;
    }

    @Override
    public boolean canExtract() {
        return true;
    }

    @Override
    public boolean canReceive() {
        return true;
    }
}