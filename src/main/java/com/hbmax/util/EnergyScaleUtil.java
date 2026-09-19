package com.hbmax.util;

public class EnergyScaleUtil {

    private static final long[] DIVISORS = {
            1L,                    // 0: < 1M
            100L,                  // 1: < 100M
            1_000L,                // 2: < 1T
            1_000_000L,            // 3: < 1Q
            1_000_000_000L,        // 4: < 1_000Q
            1_000_000_000_000L     // 5: макс
    };

    private static final long[] THRESHOLDS = {
            1_000_000L,                    // 1M
            100_000_000L,                  // 100M
            1_000_000_000_000L,            // 1T
            1_000_000_000_000_000L,        // 1Q
            Long.MAX_VALUE / 1_000_000_000L // макс
    };

    private static int getScaleLevel(long value) {
        for (int i = 0; i < THRESHOLDS.length; i++) {
            if (value < THRESHOLDS[i]) {
                return i;
            }
        }
        return THRESHOLDS.length;
    }

    public static int scaleDownWithLevel(long value) {
        if (value < 0) return 0;

        int level = getScaleLevel(value);
        long divisor = DIVISORS[level];
        long scaled = value / divisor;

        // Упаковываем: уровень в старшие 4 бита, значение в остальные 28 бит
        // 4 бита достаточно для уровней 0-15
        return ((level & 0xF) << 28) | ((int) scaled & 0xFFFFFFF);
    }

    public static long scaleUpFromPacked(int packed) {
        int level = (packed >> 28) & 0xF;
        int value = packed & 0xFFFFFFF;

        if (level >= DIVISORS.length) {
            return value;
        }

        return (long) value * DIVISORS[level];
    }

    // Для отладки
    public static void testScale(long value) {
        int packed = scaleDownWithLevel(value);
        long unpacked = scaleUpFromPacked(packed);
        System.out.println("Original: " + value);
        System.out.println("Packed: " + packed + " (0x" + Integer.toHexString(packed) + ")");
        System.out.println("Unpacked: " + unpacked);
        System.out.println("Match: " + (value == unpacked));
        System.out.println("---");
    }
}