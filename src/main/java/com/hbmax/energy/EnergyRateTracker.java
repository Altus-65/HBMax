package com.hbmax.energy;

public class EnergyRateTracker {

    private long lastEnergy = -1;
    private long lastTime = -1;
    private long currentRate = 0;
    private long totalDelta = 0;
    private long totalTime = 0;

    public void update(long currentEnergy, long currentTime) {
        if (lastEnergy == -1 || lastTime == -1) {
            lastEnergy = currentEnergy;
            lastTime = currentTime;
            currentRate = 0;
            return;
        }

        long timeDelta = currentTime - lastTime;
        long energyDelta = currentEnergy - lastEnergy;

        // Накопление за несколько тиков для плавности
        totalDelta += energyDelta;
        totalTime += timeDelta;

        if (totalTime >= 20) { // Обновляем раз в секунду (20 тиков)
            currentRate = (totalDelta / totalTime) * 20;
            totalDelta = 0;
            totalTime = 0;
        }

        lastEnergy = currentEnergy;
        lastTime = currentTime;
    }

    public long getCurrentRate() { return currentRate; }

    public String getFormattedRate() {
        if (currentRate == 0) return "";

        String sign = currentRate > 0 ? "+" : "";
        long absRate = Math.abs(currentRate);

        if (absRate >= 1_000_000_000_000L)
            return String.format("%s%.2f THE/s", sign, absRate / 1_000_000_000_000.0);
        if (absRate >= 1_000_000_000L)
            return String.format("%s%.2f GHE/s", sign, absRate / 1_000_000_000.0);
        if (absRate >= 1_000_000L)
            return String.format("%s%.2f MHE/s", sign, absRate / 1_000_000.0);
        if (absRate >= 1_000L)
            return String.format("%s%.2f kHE/s", sign, absRate / 1_000.0);
        return String.format("%s%d HE/s", sign, absRate);
    }
}