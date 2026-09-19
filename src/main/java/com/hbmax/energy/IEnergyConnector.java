package com.hbmax.energy;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public interface IEnergyConnector {
    long transferPower(long power);
    boolean canConnect(ForgeDirection dir);
    long getTransferWeight();
    ConnectionPriority getPriority();
    boolean isStorage();
    boolean isLoaded();
    BlockPos getPosition();
    Level getWorld();

    enum ConnectionPriority {
        LOW, NORMAL, HIGH
    }
}