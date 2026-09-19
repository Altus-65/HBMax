package com.hbmax.energy;

import net.minecraft.core.Direction;

public enum ForgeDirection {
    DOWN(0, -1, 0, Direction.DOWN),
    UP(0, 1, 0, Direction.UP),
    NORTH(0, 0, -1, Direction.NORTH),
    SOUTH(0, 0, 1, Direction.SOUTH),
    WEST(-1, 0, 0, Direction.WEST),
    EAST(1, 0, 0, Direction.EAST);

    public final int offsetX;
    public final int offsetY;
    public final int offsetZ;
    public final Direction direction;

    ForgeDirection(int x, int y, int z, Direction dir) {
        this.offsetX = x;
        this.offsetY = y;
        this.offsetZ = z;
        this.direction = dir;
    }

    public ForgeDirection getOpposite() {
        switch (this) {
            case DOWN: return UP;
            case UP: return DOWN;
            case NORTH: return SOUTH;
            case SOUTH: return NORTH;
            case WEST: return EAST;
            case EAST: return WEST;
            default: return this;
        }
    }

    public static final ForgeDirection[] VALID_DIRECTIONS = {DOWN, UP, NORTH, SOUTH, WEST, EAST};
}