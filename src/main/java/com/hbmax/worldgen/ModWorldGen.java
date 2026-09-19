package com.hbmax.worldgen;

import com.hbmax.registry.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModWorldGen {

    // ── Configured Feature Keys ────────────────────────────────────────────────

    public static final ResourceKey<ConfiguredFeature<?, ?>> URANIUM_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "uranium_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALUMINIUM_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "aluminium_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASBESTOS_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "asbestos_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> AUSTRALIUM_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "australium_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> BERYLLIUM_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "beryllium_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CINNEBAR_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "cinnebar_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> COBALT_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "cobalt_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> COLTAN_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "coltan_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> COAL_OIL_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "coal_oil_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLUORITE_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "fluorite_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEAD_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "lead_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> DAFFERGON_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "daffergon_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> DAFFGON_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "daffgon_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> LITHIUM_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "lithium_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> NITER_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "niter_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> RARE_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "rare_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> REIIUM_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "reiium_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SULFUR_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "sulfur_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> THORIUM_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "thorium_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> TITANIUM_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "titanium_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> TUNGSTEN_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "tungsten_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> UNOBTAINIUM_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "unobtainium_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> VERTICIUM_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "verticium_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> WAIDANIUM_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "waidanium_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SALPETER_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "salpeter_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> MALACHITE_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "malachite_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIGNITE_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "lignite_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> BEDROCK_BLOCK_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "bedrock_block_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> BEDROCK_COLTAN_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "bedrock_coltan_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_COBALT_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "nether_cobalt_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_FIRE_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "nether_fire_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_COAL_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "nether_coal_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_PLUTONIUM_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "nether_plutonium_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_SMOLDERING_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "nether_smoldering_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_SULFUR_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "nether_sulfur_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_SALPETER_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "nether_salpeter_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_TUNGSTEN_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "nether_tungsten_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_URANIUM_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "nether_uranium_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ENDER_TIKITE_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "ender_tikite_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ENDER_TIKITE_ALT_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("hbmax", "ender_tikite_alt_ore"));

    // ── Placed Feature Keys ───────────────────────────────────────────────────

    public static final ResourceKey<PlacedFeature> URANIUM_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "uranium_ore"));
    public static final ResourceKey<PlacedFeature> ALUMINIUM_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "aluminium_ore"));
    public static final ResourceKey<PlacedFeature> ASBESTOS_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "asbestos_ore"));
    public static final ResourceKey<PlacedFeature> AUSTRALIUM_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "australium_ore"));
    public static final ResourceKey<PlacedFeature> BERYLLIUM_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "beryllium_ore"));
    public static final ResourceKey<PlacedFeature> CINNEBAR_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "cinnebar_ore"));
    public static final ResourceKey<PlacedFeature> COBALT_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "cobalt_ore"));
    public static final ResourceKey<PlacedFeature> COLTAN_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "coltan_ore"));
    public static final ResourceKey<PlacedFeature> COAL_OIL_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "coal_oil_ore"));
    public static final ResourceKey<PlacedFeature> FLUORITE_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "fluorite_ore"));
    public static final ResourceKey<PlacedFeature> LEAD_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "lead_ore"));
    public static final ResourceKey<PlacedFeature> DAFFERGON_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "daffergon_ore"));
    public static final ResourceKey<PlacedFeature> DAFFGON_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "daffgon_ore"));
    public static final ResourceKey<PlacedFeature> LITHIUM_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "lithium_ore"));
    public static final ResourceKey<PlacedFeature> NITER_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "niter_ore"));
    public static final ResourceKey<PlacedFeature> RARE_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "rare_ore"));
    public static final ResourceKey<PlacedFeature> REIIUM_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "reiium_ore"));
    public static final ResourceKey<PlacedFeature> SULFUR_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "sulfur_ore"));
    public static final ResourceKey<PlacedFeature> THORIUM_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "thorium_ore"));
    public static final ResourceKey<PlacedFeature> TITANIUM_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "titanium_ore"));
    public static final ResourceKey<PlacedFeature> TUNGSTEN_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "tungsten_ore"));
    public static final ResourceKey<PlacedFeature> UNOBTAINIUM_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "unobtainium_ore"));
    public static final ResourceKey<PlacedFeature> VERTICIUM_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "verticium_ore"));
    public static final ResourceKey<PlacedFeature> WAIDANIUM_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "waidanium_ore"));
    public static final ResourceKey<PlacedFeature> SALPETER_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "salpeter_ore"));
    public static final ResourceKey<PlacedFeature> MALACHITE_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "malachite_ore"));
    public static final ResourceKey<PlacedFeature> LIGNITE_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "lignite_ore"));
    public static final ResourceKey<PlacedFeature> BEDROCK_BLOCK_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "bedrock_block_ore"));
    public static final ResourceKey<PlacedFeature> BEDROCK_COLTAN_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "bedrock_coltan_ore"));
    public static final ResourceKey<PlacedFeature> NETHER_COBALT_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "nether_cobalt_ore"));
    public static final ResourceKey<PlacedFeature> NETHER_FIRE_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "nether_fire_ore"));
    public static final ResourceKey<PlacedFeature> NETHER_COAL_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "nether_coal_ore"));
    public static final ResourceKey<PlacedFeature> NETHER_PLUTONIUM_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "nether_plutonium_ore"));
    public static final ResourceKey<PlacedFeature> NETHER_SMOLDERING_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "nether_smoldering_ore"));
    public static final ResourceKey<PlacedFeature> NETHER_SULFUR_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "nether_sulfur_ore"));
    public static final ResourceKey<PlacedFeature> NETHER_TUNGSTEN_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "nether_tungsten_ore"));
    public static final ResourceKey<PlacedFeature> NETHER_URANIUM_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "nether_uranium_ore"));
    public static final ResourceKey<PlacedFeature> ENDER_TIKITE_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "ender_tikite_ore"));
    public static final ResourceKey<PlacedFeature> ENDER_TIKITE_ALT_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("hbmax", "ender_tikite_alt_ore"));

    // ── Bootstrap Configured ──────────────────────────────────────────────────

    public static void bootstrapConfigured(BootstapContext<ConfiguredFeature<?, ?>> ctx) {
        registerOverworld(ctx, URANIUM_ORE_KEY, ModBlocks.URANIUM_ORE);
        registerOverworld(ctx, ALUMINIUM_ORE_KEY, ModBlocks.ALUMINIUM_ORE);
        registerOverworld(ctx, ASBESTOS_ORE_KEY, ModBlocks.ASBESTOS_ORE);
        registerOverworld(ctx, AUSTRALIUM_ORE_KEY, ModBlocks.AUSTRALIUM_ORE);
        registerOverworld(ctx, BERYLLIUM_ORE_KEY, ModBlocks.BERYLLIUM_ORE);
        registerOverworld(ctx, CINNEBAR_ORE_KEY, ModBlocks.CINNEBAR_ORE);
        registerOverworld(ctx, COBALT_ORE_KEY, ModBlocks.COBALT_ORE);
        registerOverworld(ctx, COLTAN_ORE_KEY, ModBlocks.COLTAN_ORE);
        registerOverworld(ctx, COAL_OIL_ORE_KEY, ModBlocks.COAL_OIL_ORE);
        registerOverworld(ctx, FLUORITE_ORE_KEY, ModBlocks.FLUORITE_ORE);
        registerOverworld(ctx, LEAD_ORE_KEY, ModBlocks.LEAD_ORE);
        registerOverworld(ctx, DAFFERGON_ORE_KEY, ModBlocks.DAFFERGON_ORE);
        registerOverworld(ctx, DAFFGON_ORE_KEY, ModBlocks.DAFFGON_ORE);
        registerOverworld(ctx, LITHIUM_ORE_KEY, ModBlocks.LITHIUM_ORE);
        registerOverworld(ctx, NITER_ORE_KEY, ModBlocks.NITER_ORE);
        registerOverworld(ctx, RARE_ORE_KEY, ModBlocks.RARE_ORE);
        registerOverworld(ctx, REIIUM_ORE_KEY, ModBlocks.REIIUM_ORE);
        registerOverworld(ctx, SULFUR_ORE_KEY, ModBlocks.SULFUR_ORE);
        registerOverworld(ctx, THORIUM_ORE_KEY, ModBlocks.THORIUM_ORE);
        registerOverworld(ctx, TITANIUM_ORE_KEY, ModBlocks.TITANIUM_ORE);
        registerOverworld(ctx, TUNGSTEN_ORE_KEY, ModBlocks.TUNGSTEN_ORE);
        registerOverworld(ctx, UNOBTAINIUM_ORE_KEY, ModBlocks.UNOBTAINIUM_ORE);
        registerOverworld(ctx, VERTICIUM_ORE_KEY, ModBlocks.VERTICIUM_ORE);
        registerOverworld(ctx, WAIDANIUM_ORE_KEY, ModBlocks.WAIDANIUM_ORE);
        registerOverworld(ctx, SALPETER_ORE_KEY, ModBlocks.SALPETER_ORE);
        registerOverworld(ctx, MALACHITE_ORE_KEY, ModBlocks.MALACHITE_ORE);
        registerOverworld(ctx, LIGNITE_ORE_KEY, ModBlocks.LIGNITE_ORE);
        registerBedrock(ctx, BEDROCK_BLOCK_ORE_KEY, ModBlocks.BEDROCK_BLOCK_ORE);
        registerBedrock(ctx, BEDROCK_COLTAN_ORE_KEY, ModBlocks.BEDROCK_COLTAN_ORE);
        registerNether(ctx, NETHER_COBALT_ORE_KEY, ModBlocks.NETHER_COBALT_ORE);
        registerNether(ctx, NETHER_FIRE_ORE_KEY, ModBlocks.NETHER_FIRE_ORE);
        registerNether(ctx, NETHER_COAL_ORE_KEY, ModBlocks.NETHER_COAL_ORE);
        registerNether(ctx, NETHER_PLUTONIUM_ORE_KEY, ModBlocks.NETHER_PLUTONIUM_ORE);
        registerNether(ctx, NETHER_SMOLDERING_ORE_KEY, ModBlocks.NETHER_SMOLDERING_ORE);
        registerNether(ctx, NETHER_SULFUR_ORE_KEY, ModBlocks.NETHER_SULFUR_ORE);
        registerNether(ctx, NETHER_TUNGSTEN_ORE_KEY, ModBlocks.NETHER_TUNGSTEN_ORE);
        registerNether(ctx, NETHER_URANIUM_ORE_KEY, ModBlocks.NETHER_URANIUM_ORE);
        registerEnder(ctx, ENDER_TIKITE_ORE_KEY, ModBlocks.ENDER_TIKITE_ORE);
        registerEnder(ctx, ENDER_TIKITE_ALT_ORE_KEY, ModBlocks.ENDER_TIKITE_ALT_ORE);
    }

    // Регистрирует руду в камне И в сланце
    private static void registerOverworld(
            BootstapContext<ConfiguredFeature<?, ?>> ctx,
            ResourceKey<ConfiguredFeature<?, ?>> key,
            net.minecraftforge.registries.RegistryObject<net.minecraft.world.level.block.Block> block) {
        ctx.register(key, new ConfiguredFeature<>(Feature.ORE,
                new OreConfiguration(
                        List.of(
                                OreConfiguration.target(
                                        new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES),
                                        block.get().defaultBlockState()
                                ),
                                OreConfiguration.target(
                                        new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES),
                                        block.get().defaultBlockState()
                                )
                        ),
                        6 // размер жилы
                )));
    }

    private static void registerBedrock(
            BootstapContext<ConfiguredFeature<?, ?>> ctx,
            ResourceKey<ConfiguredFeature<?, ?>> key,
            net.minecraftforge.registries.RegistryObject<net.minecraft.world.level.block.Block> block) {

        ctx.register(key, new ConfiguredFeature<>(Feature.ORE,
                new OreConfiguration(
                        List.of(
                                OreConfiguration.target(
                                        new net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest(
                                                net.minecraft.world.level.block.Blocks.BEDROCK
                                        ),
                                        block.get().defaultBlockState()
                                )
                        ),
                        6 // размер жилы
                )));
    }

    private static void registerNether(
            BootstapContext<ConfiguredFeature<?, ?>> ctx,
            ResourceKey<ConfiguredFeature<?, ?>> key,
            net.minecraftforge.registries.RegistryObject<net.minecraft.world.level.block.Block> block) {

        ctx.register(key, new ConfiguredFeature<>(Feature.ORE,
                new OreConfiguration(
                        List.of(
                                OreConfiguration.target(
                                        new TagMatchTest(BlockTags.BASE_STONE_NETHER),
                                        block.get().defaultBlockState()
                                )
                        ),
                        6 // размер жилы
                )));
    }

    private static void registerEnder(
            BootstapContext<ConfiguredFeature<?, ?>> ctx,
            ResourceKey<ConfiguredFeature<?, ?>> key,
            net.minecraftforge.registries.RegistryObject<net.minecraft.world.level.block.Block> block) {

        ctx.register(key, new ConfiguredFeature<>(Feature.ORE,
                new OreConfiguration(
                        List.of(
                                OreConfiguration.target(
                                        new net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest(
                                                net.minecraft.world.level.block.Blocks.END_STONE
                                        ),
                                        block.get().defaultBlockState()
                                )
                        ),
                        6 // размер жилы
                )));
    }

    // ── Bootstrap Placed ──────────────────────────────────────────────────────

    public static void bootstrapPlaced(BootstapContext<PlacedFeature> ctx) {
        var configured = ctx.lookup(Registries.CONFIGURED_FEATURE);

        registerPlaced(ctx, configured, URANIUM_ORE_PLACED_KEY, URANIUM_ORE_KEY, 8, -64, 150);
        registerPlaced(ctx, configured, ALUMINIUM_ORE_PLACED_KEY, ALUMINIUM_ORE_KEY, 8, -64, 150);
        registerPlaced(ctx, configured, ASBESTOS_ORE_PLACED_KEY, ASBESTOS_ORE_KEY, 6, -64, 150);
        registerPlaced(ctx, configured, AUSTRALIUM_ORE_PLACED_KEY, AUSTRALIUM_ORE_KEY, 2, -64, -20);
        registerPlaced(ctx, configured, BERYLLIUM_ORE_PLACED_KEY, BERYLLIUM_ORE_KEY, 6, -64, 150);
        registerPlaced(ctx, configured, CINNEBAR_ORE_PLACED_KEY, CINNEBAR_ORE_KEY, 6, -64, 20);
        registerPlaced(ctx, configured, COBALT_ORE_PLACED_KEY, COBALT_ORE_KEY, 6, -64, 20);
        registerPlaced(ctx, configured, COLTAN_ORE_PLACED_KEY, COLTAN_ORE_KEY, 6, -64, 20);
        registerPlaced(ctx, configured, COAL_OIL_ORE_PLACED_KEY, COAL_OIL_ORE_KEY, 4, -64, 150);
        registerPlaced(ctx, configured, FLUORITE_ORE_PLACED_KEY, FLUORITE_ORE_KEY, 4, -64, 150);
        registerPlaced(ctx, configured, LEAD_ORE_PLACED_KEY, LEAD_ORE_KEY, 4, -64, 150);
        registerPlaced(ctx, configured, DAFFERGON_ORE_PLACED_KEY, DAFFERGON_ORE_KEY, 4, -64, 40);
        registerPlaced(ctx, configured, DAFFGON_ORE_PLACED_KEY, DAFFGON_ORE_KEY, 4, -64, 40);
        registerPlaced(ctx, configured, LITHIUM_ORE_PLACED_KEY, LITHIUM_ORE_KEY, 4, -64, 40);
        registerPlaced(ctx, configured, NITER_ORE_PLACED_KEY, NITER_ORE_KEY, 4, -64, 40);
        registerPlaced(ctx, configured, RARE_ORE_PLACED_KEY, RARE_ORE_KEY, 4, -64, 150);
        registerPlaced(ctx, configured, REIIUM_ORE_PLACED_KEY, REIIUM_ORE_KEY, 4, -64, 40);
        registerPlaced(ctx, configured, SULFUR_ORE_PLACED_KEY, SULFUR_ORE_KEY, 4, -64, 150);
        registerPlaced(ctx, configured, THORIUM_ORE_PLACED_KEY, THORIUM_ORE_KEY, 4, -64, 150);
        registerPlaced(ctx, configured, TITANIUM_ORE_PLACED_KEY, TITANIUM_ORE_KEY, 4, -64, 150);
        registerPlaced(ctx, configured, TUNGSTEN_ORE_PLACED_KEY, TUNGSTEN_ORE_KEY, 4, -64, 150);
        registerPlaced(ctx, configured, UNOBTAINIUM_ORE_PLACED_KEY, UNOBTAINIUM_ORE_KEY, 4, -64, 40);
        registerPlaced(ctx, configured, VERTICIUM_ORE_PLACED_KEY, VERTICIUM_ORE_KEY, 4, -64, 40);
        registerPlaced(ctx, configured, WAIDANIUM_ORE_PLACED_KEY, WAIDANIUM_ORE_KEY, 4, -64, 40);
        registerPlaced(ctx, configured, SALPETER_ORE_PLACED_KEY, SALPETER_ORE_KEY, 4, -64, 40);
        registerPlaced(ctx, configured, MALACHITE_ORE_PLACED_KEY, MALACHITE_ORE_KEY, 10, -10, 50);
        registerPlaced(ctx, configured, LIGNITE_ORE_PLACED_KEY, LIGNITE_ORE_KEY, 35, -10, 150);
        registerPlaced(ctx, configured, BEDROCK_BLOCK_ORE_PLACED_KEY, BEDROCK_BLOCK_ORE_KEY, 4, -64, -55);
        registerPlaced(ctx, configured, BEDROCK_COLTAN_ORE_PLACED_KEY, BEDROCK_COLTAN_ORE_KEY, 4, -64, -55);
        registerPlaced(ctx, configured, NETHER_COBALT_ORE_PLACED_KEY, NETHER_COBALT_ORE_KEY, 4, 0, 128);
        registerPlaced(ctx, configured, NETHER_FIRE_ORE_PLACED_KEY, NETHER_FIRE_ORE_KEY, 4, 0, 128);
        registerPlaced(ctx, configured, NETHER_COAL_ORE_PLACED_KEY, NETHER_COAL_ORE_KEY, 4, 0, 128);
        registerPlaced(ctx, configured, NETHER_PLUTONIUM_ORE_PLACED_KEY, NETHER_PLUTONIUM_ORE_KEY, 4, 0, 128);
        registerPlaced(ctx, configured, NETHER_SMOLDERING_ORE_PLACED_KEY, NETHER_SMOLDERING_ORE_KEY, 4, 0, 128);
        registerPlaced(ctx, configured, NETHER_SULFUR_ORE_PLACED_KEY, NETHER_SULFUR_ORE_KEY, 4, 0, 128);
        registerPlaced(ctx, configured, NETHER_TUNGSTEN_ORE_PLACED_KEY, NETHER_TUNGSTEN_ORE_KEY, 4, 0, 128);
        registerPlaced(ctx, configured, NETHER_URANIUM_ORE_PLACED_KEY, NETHER_URANIUM_ORE_KEY, 4, 0, 128);
        registerPlaced(ctx, configured, ENDER_TIKITE_ORE_PLACED_KEY, ENDER_TIKITE_ORE_KEY, 4, -128, 128);
        registerPlaced(ctx, configured, ENDER_TIKITE_ALT_ORE_PLACED_KEY, ENDER_TIKITE_ALT_ORE_KEY, 4, -128, 128);
    }

    private static void registerPlaced(
            BootstapContext<PlacedFeature> ctx,
            net.minecraft.core.HolderGetter<ConfiguredFeature<?, ?>> configured,
            ResourceKey<PlacedFeature> placedKey,
            ResourceKey<ConfiguredFeature<?, ?>> configuredKey,
            int count, int minY, int maxY) {
        ctx.register(placedKey, new PlacedFeature(
                configured.getOrThrow(configuredKey),
                List.of(
                        CountPlacement.of(count),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(
                                net.minecraft.world.level.levelgen.VerticalAnchor.absolute(minY),
                                net.minecraft.world.level.levelgen.VerticalAnchor.absolute(maxY)
                        ),
                        BiomeFilter.biome()
                )
        ));
    }
}
