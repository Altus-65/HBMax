package com.hbmax.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemBatteryGen extends Item {

    private final long generatePerTick;
    private final long maxExtractPerTick;
    private final boolean isCreative;
    private final boolean isInfiniteGen;

    // Обычный генератор
    public ItemBatteryGen(long generatePerTick) {
        this(generatePerTick, generatePerTick, false, false);
    }

    // Генератор с разной скоростью
    public ItemBatteryGen(long generatePerTick, long maxExtractPerTick) {
        this(generatePerTick, maxExtractPerTick, false, false);
    }

    // Бесконечный генератор
    public ItemBatteryGen(long generatePerTick, boolean isInfiniteGen) {
        this(generatePerTick, generatePerTick, false, isInfiniteGen);
    }

    // Креативная батарейка
    public ItemBatteryGen(boolean isCreative) {
        this(0, 0, isCreative, false);
    }

    private ItemBatteryGen(long generatePerTick, long maxExtractPerTick, boolean isCreative, boolean isInfiniteGen) {
        super(new Item.Properties().stacksTo(1));
        this.generatePerTick = generatePerTick;
        this.maxExtractPerTick = maxExtractPerTick;
        this.isCreative = isCreative;
        this.isInfiniteGen = isInfiniteGen;
    }

    public long getGeneratePerTick() { return generatePerTick; }
    public long getMaxExtractPerTick() { return maxExtractPerTick; }
    public boolean isCreative() { return isCreative; }
    public boolean isInfiniteGen() { return isInfiniteGen; }

    public long getCharge(ItemStack stack) { return Long.MAX_VALUE; }
    public long getMaxCharge() { return Long.MAX_VALUE; }

    public long getDischargeRate() {
        if (isCreative) return Long.MAX_VALUE;
        return maxExtractPerTick;
    }

    public void removeCharge(ItemStack stack, long amount) {}
    public void addCharge(ItemStack stack, long amount) {}

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level,
                                List<Component> tooltip, TooltipFlag flag) {
        if (isCreative) {
            tooltip.add(Component.literal("§e∞ HE/s"));
        } else if (isInfiniteGen) {
            tooltip.add(Component.literal("§e" + formatEnergy(generatePerTick) + "/s"));
        } else {
            tooltip.add(Component.literal("§e" + formatEnergy(generatePerTick) + "/s"));
        }
    }

    private String formatEnergy(long value) {
        if (value >= 1_000_000_000_000L) return (value / 1_000_000_000_000L) + " THE";
        if (value >= 1_000_000_000L) return (value / 1_000_000_000L) + " GHE";
        if (value >= 1_000_000L) return (value / 1_000_000L) + " MHE";
        if (value >= 1_000L) return (value / 1_000L) + " kHE";
        return value + " HE";
    }

    @Override
    public boolean isBarVisible(ItemStack stack) { return false; }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return isCreative ? Rarity.EPIC : Rarity.RARE;
    }

    @Override
    public @Nullable ICapabilityProvider initCapabilities(ItemStack stack, @Nullable net.minecraft.nbt.CompoundTag nbt) {
        return new ICapabilityProvider() {
            private final LazyOptional<IEnergyStorage> lazy = LazyOptional.of(() -> new IEnergyStorage() {
                @Override
                public int receiveEnergy(int max, boolean sim) { return 0; }

                @Override
                public int extractEnergy(int maxExtract, boolean simulate) {
                    long toExtract;
                    if (isCreative) {
                        toExtract = maxExtract;
                    } else if (isInfiniteGen) {
                        toExtract = Math.min(maxExtract, generatePerTick);
                    } else {
                        toExtract = Math.min(maxExtract, maxExtractPerTick);
                    }
                    return (int) Math.min(toExtract, Integer.MAX_VALUE);
                }

                @Override
                public int getEnergyStored() { return Integer.MAX_VALUE; }

                @Override
                public int getMaxEnergyStored() { return Integer.MAX_VALUE; }

                @Override
                public boolean canExtract() { return true; }

                @Override
                public boolean canReceive() { return false; }
            });

            @Override
            public <T> LazyOptional<T> getCapability(
                    net.minecraftforge.common.capabilities.Capability<T> cap,
                    @Nullable net.minecraft.core.Direction side) {
                if (cap == ForgeCapabilities.ENERGY) return lazy.cast();
                return LazyOptional.empty();
            }
        };
    }
}