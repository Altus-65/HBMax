package com.hbmax.bridge;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = "hbmax", bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {

    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.BooleanValue DEBUG_MODE = BUILDER
            .comment("Enable debug logs")
            .define("debugMode", true);

    public static final ForgeConfigSpec.IntValue TSAR_BOMB_POWER = BUILDER
            .comment("Default Tsar Bomb power")
            .defineInRange("tsarBombPower", 5000, 1, 1000000);

    public static final ForgeConfigSpec.BooleanValue ENABLE_RADIATION = BUILDER
            .comment("Enable radiation system")
            .define("enableRadiation", true);

    public static final ForgeConfigSpec SPEC = BUILDER.build();

    /* runtime values */
    public static boolean debugMode;
    public static int tsarBombPower;
    public static boolean enableRadiation;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        debugMode = DEBUG_MODE.get();
        tsarBombPower = TSAR_BOMB_POWER.get();
        enableRadiation = ENABLE_RADIATION.get();
    }
}

