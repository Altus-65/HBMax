package com.hbmax.energy;

public enum BatteryPriority {
    NORMAL,  // обычный приоритет
    HIGH,    // вся энергия идёт только в эту батарею
    LOW;     // заряжается не мешая механизмам

    public BatteryPriority next() {
        return switch (this) {
            case NORMAL -> HIGH;
            case HIGH -> LOW;
            case LOW -> NORMAL;
        };
    }
}