package com.hbmax.worldgen;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Set;

@Mod.EventBusSubscriber(modid = "hbmax", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDatapackRegistries {

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        var gen = event.getGenerator();
        var output = gen.getPackOutput();
        var lookupProvider = event.getLookupProvider();

        gen.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(
                output, lookupProvider,
                new RegistrySetBuilder()
                        .add(Registries.PLACED_FEATURE, ModWorldGen::bootstrapPlaced)
                        .add(Registries.CONFIGURED_FEATURE, ModWorldGen::bootstrapConfigured),
                Set.of("hbmax")
        ));
    }
}