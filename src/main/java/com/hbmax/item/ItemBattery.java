package com.hbmax.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemBattery extends Item {

    private final long maxCharge;
    private final long chargeRate;
    private final long dischargeRate;

    public ItemBattery(long maxCharge, long chargeRate, long dischargeRate) {
        super(new Item.Properties().stacksTo(1));
        this.maxCharge = maxCharge;
        this.chargeRate = chargeRate;
        this.dischargeRate = dischargeRate;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level,
                                List<Component> tooltip, TooltipFlag flag) {
        long charge = getCharge(stack);

        // Информация о заряде
        tooltip.add(Component.literal("§eХранится энергии: " + formatEnergy(charge) + " §7/ §e" + formatEnergy(maxCharge)));

        // Скорости
        tooltip.add(Component.literal("§aСкорость зарядки: " + formatEnergy(chargeRate) + "/с"));
        tooltip.add(Component.literal("§cСкорость разрядки: " + formatEnergy(dischargeRate) + "/с"));
    }

    private String formatEnergy(long value) {
        if (value >= 1_000_000_000_000_000L) return String.format("%.2f PHE", value / 1_000_000_000_000_000.0);
        if (value >= 1_000_000_000_000L) return String.format("%.2f THE", value / 1_000_000_000_000.0);
        if (value >= 1_000_000_000L) return String.format("%.2f GHE", value / 1_000_000_000.0);
        if (value >= 1_000_000L) return String.format("%.2f MHE", value / 1_000_000.0);
        if (value >= 1_000L) return String.format("%.2f kHE", value / 1_000.0);
        return value + " HE";
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return true;
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        return (int) Math.round(13.0f * getCharge(stack) / maxCharge);
    }

    @Override
    public int getBarColor(ItemStack stack) {
        float percent = (float) getCharge(stack) / maxCharge;
        int r = (int) (255 * (1 - percent));
        int g = (int) (255 * percent);
        return (r << 16) | (g << 8);
    }

    public long getCharge(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        if (!tag.contains("charge")) tag.putLong("charge", 0);
        return tag.getLong("charge");
    }

    public void setCharge(ItemStack stack, long value) {
        stack.getOrCreateTag().putLong("charge", Math.max(0, Math.min(value, maxCharge)));
    }

    public void addCharge(ItemStack stack, long amount) {
        setCharge(stack, getCharge(stack) + amount);
    }

    public void removeCharge(ItemStack stack, long amount) {
        setCharge(stack, getCharge(stack) - amount);
    }

    public long getMaxCharge() { return maxCharge; }
    public long getChargeRate() { return chargeRate; }
    public long getDischargeRate() { return dischargeRate; }

    @Override
    public @Nullable ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return new BatteryCapabilityProvider(stack, this);
    }

    public static class BatteryCapabilityProvider implements ICapabilityProvider, IEnergyStorage {

        private final ItemStack stack;
        private final ItemBattery battery;

        public BatteryCapabilityProvider(ItemStack stack, ItemBattery battery) {
            this.stack = stack;
            this.battery = battery;
        }

        @Override
        public <T> LazyOptional<T> getCapability(
                net.minecraftforge.common.capabilities.Capability<T> cap,
                @Nullable net.minecraft.core.Direction side) {
            if (cap == ForgeCapabilities.ENERGY)
                return LazyOptional.of(() -> this).cast();
            return LazyOptional.empty();
        }

        @Override
        public int receiveEnergy(int maxReceive, boolean simulate) {
            long current = battery.getCharge(stack);
            long space = battery.maxCharge - current;
            long toReceive = Math.min(Math.min(maxReceive, space), battery.chargeRate);
            if (!simulate) battery.setCharge(stack, current + toReceive);
            return (int) toReceive;
        }

        @Override
        public int extractEnergy(int maxExtract, boolean simulate) {
            long current = battery.getCharge(stack);
            long toExtract = Math.min(Math.min(maxExtract, current), battery.dischargeRate);
            if (!simulate) battery.setCharge(stack, current - toExtract);
            return (int) toExtract;
        }

        @Override
        public int getEnergyStored() {
            return (int) Math.min(Integer.MAX_VALUE, battery.getCharge(stack));
        }

        @Override
        public int getMaxEnergyStored() {
            return (int) Math.min(Integer.MAX_VALUE, battery.maxCharge);
        }

        @Override
        public boolean canExtract() { return true; }
        @Override
        public boolean canReceive() { return true; }
    }
}