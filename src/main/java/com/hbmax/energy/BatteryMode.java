package com.hbmax.energy;

public enum BatteryMode {

    INPUT,
    NEUTRAL,
    OUTPUT,
    OFF;

    public BatteryMode next() {

        return switch (this) {

            case INPUT -> NEUTRAL;
            case NEUTRAL -> OUTPUT;
            case OUTPUT -> OFF;
            case OFF -> INPUT;
        };
    }
}