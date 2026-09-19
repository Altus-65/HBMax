package com.hbmax.registry;

import com.hbmax.block.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, "hbmax");

    public static final RegistryObject<Block> URANIUM_ORE = BLOCKS.register("uranium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> ALUMINIUM_ORE = BLOCKS.register("aluminium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> ASBESTOS_ORE = BLOCKS.register("asbestos_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> AUSTRALIUM_ORE = BLOCKS.register("australium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BERYLLIUM_ORE = BLOCKS.register("beryllium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> CINNEBAR_ORE = BLOCKS.register("cinnebar_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> COBALT_ORE = BLOCKS.register("cobalt_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> COLTAN_ORE = BLOCKS.register("coltan_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> COAL_OIL_BURNING_ORE = BLOCKS.register("coal_oil_burning_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> COAL_OIL_ORE = BLOCKS.register("coal_oil_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> FLUORITE_ORE = BLOCKS.register("fluorite_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> LEAD_ORE = BLOCKS.register("lead_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> DAFFERGON_ORE = BLOCKS.register("daffergon_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> DAFFGON_ORE = BLOCKS.register("daffgon_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> LITHIUM_ORE = BLOCKS.register("lithium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> NITER_ORE = BLOCKS.register("niter_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> RARE_ORE = BLOCKS.register("rare_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> REIIUM_ORE = BLOCKS.register("reiium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> SCHRABIDIUM_ORE = BLOCKS.register("schrabidium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> SULFUR_ORE = BLOCKS.register("sulfur_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> THORIUM_ORE = BLOCKS.register("thorium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> TITANIUM_ORE = BLOCKS.register("titanium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> TUNGSTEN_ORE = BLOCKS.register("tungsten_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> UNOBTAINIUM_ORE = BLOCKS.register("unobtainium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> VERTICIUM_ORE = BLOCKS.register("verticium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> WAIDANIUM_ORE = BLOCKS.register("waidanium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> SALPETER_ORE = BLOCKS.register("salpeter_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> MALACHITE_ORE = BLOCKS.register("malachite_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> LIGNITE_ORE = BLOCKS.register("lignite_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BEDROCK_BLOCK_ORE = BLOCKS.register("bedrock_block_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BEDROCK_COLTAN_ORE = BLOCKS.register("bedrock_coltan_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> NETHER_COBALT_ORE = BLOCKS.register("nether_cobalt_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> NETHER_FIRE_ORE = BLOCKS.register("nether_fire_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> NETHER_COAL_ORE = BLOCKS.register("nether_coal_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> NETHER_PLUTONIUM_ORE = BLOCKS.register("nether_plutonium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> NETHER_SCHRABIDIUM_ORE = BLOCKS.register("nether_schrabidium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> NETHER_SMOLDERING_ORE = BLOCKS.register("nether_smoldering_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> NETHER_SULFUR_ORE = BLOCKS.register("nether_sulfur_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> NETHER_TUNGSTEN_ORE = BLOCKS.register("nether_tungsten_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> NETHER_URANIUM_ORE = BLOCKS.register("nether_uranium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> ENDER_TIKITE_ORE = BLOCKS.register("ender_tikite_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> ENDER_TIKITE_ALT_ORE = BLOCKS.register("ender_tikite_alt_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    // entity
    public static final RegistryObject<Block> MACHINE_TRANSFORMER = BLOCKS.register("machine_transformer",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> ELECTRIC_FURNACE =
            BLOCKS.register("electric_furnace",
                    () -> new BlockElectricFurnace(
                            BlockBehaviour.Properties.of()
                                    .strength(3.0f)
                                    .requiresCorrectToolForDrops()
                    ));
    public static final RegistryObject<Block> BLAST_FURNACE_BLOCK = BLOCKS.register("machine_blast_furnace",
            () -> new HBlastFurnaceBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(5.0f, 6.0f)
                    .requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(com.hbmax.block.HBlastFurnaceBlock.LIT) ? 13 : 0)
            ));
    public static final RegistryObject<Block> MACHINE_ARC_FURNACE_OFF = BLOCKS.register("machine_arc_furnace_off",
            () -> new BlockArcFurnace(BlockBehaviour.Properties.of().strength(3.5f).requiresCorrectToolForDrops(), false));

    public static final RegistryObject<Block> MACHINE_ARC_FURNACE_ON = BLOCKS.register("machine_arc_furnace_on",
            () -> new BlockArcFurnace(BlockBehaviour.Properties.of().strength(3.5f).requiresCorrectToolForDrops().lightLevel(state -> 13), true));
    public static final RegistryObject<Block> CABLE = BLOCKS.register("red_cable",
            () -> new BlockCable(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .strength(1.0f, 1.0f)
                    .noOcclusion()
            ));
    public static final RegistryObject<Block> MACHINE_SCHRABIDIUM_BATTERY =
            BLOCKS.register("machine_schrabidium_battery",
                    () -> new BlockBattery(
                            BlockBehaviour.Properties.of().strength(3f),
                            100_000_000_000L
                    ));
    public static final RegistryObject<Block> MACHINE_POTATO_BATTERY =
            BLOCKS.register("machine_battery_potato",
                    () -> new BlockBattery(
                            BlockBehaviour.Properties.of().strength(3f),
                            100_000L
                    ));
    public static final RegistryObject<Block> MACHINE_BATTERY =
            BLOCKS.register("machine_battery",
                    () -> new BlockBattery(
                            BlockBehaviour.Properties.of().strength(3f),
                            10_000_000L
                    ));
    public static final RegistryObject<Block> MACHINE_LITHIUM_BATTERY =
            BLOCKS.register("machine_lithium_battery",
                    () -> new BlockBattery(
                            BlockBehaviour.Properties.of().strength(3f),
                            100_000_000L
                    ));
    public static final RegistryObject<Block> MACHINE_DESH_BATTERY =
            BLOCKS.register("machine_desh_battery",
                    () -> new BlockBattery(
                            BlockBehaviour.Properties.of().strength(3f),
                            1_000_000_000L
                    ));
    public static final RegistryObject<Block> MACHINE_SATURNITE_BATTERY =
            BLOCKS.register("machine_saturnite_battery",
                    () -> new BlockBattery(
                            BlockBehaviour.Properties.of().strength(3f),
                            10_000_000_000L
                    ));
    public static final RegistryObject<Block> MACHINE_EUPHEMIUM_BATTERY =
            BLOCKS.register("machine_euphemium_battery",
                    () -> new BlockBattery(
                            BlockBehaviour.Properties.of().strength(3f),
                            1_000_000_000_000L
                    ));
    public static final RegistryObject<Block> MACHINE_RADSPICE_BATTERY =
            BLOCKS.register("machine_radspice_battery",
                    () -> new BlockBattery(
                            BlockBehaviour.Properties.of().strength(3f),
                            10_000_000_000_000L
                    ));
    public static final RegistryObject<Block> MACHINE_DINEUTRONIUM_BATTERY =
            BLOCKS.register("machine_dineutronium_battery",
                    () -> new BlockBattery(
                            BlockBehaviour.Properties.of().strength(3f),
                            100_000_000_000_000L
                    ));
    public static final RegistryObject<Block> MACHINE_ELECTRONIUM_BATTERY =
            BLOCKS.register("machine_electronium_battery",
                    () -> new BlockBattery(
                            BlockBehaviour.Properties.of().strength(3f),
                            1_000_000_000_000_000L
                    ));
    // blocks
    public static final RegistryObject<Block> ASPHALT = BLOCKS.register("asphalt",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> ABSORBER = BLOCKS.register("absorber",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> ABSORBER_GREEN = BLOCKS.register("absorber_green",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> ABSORBER_PINK = BLOCKS.register("absorber_pink",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> ABSORBER_RED = BLOCKS.register("absorber_red",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> AMS_BASE = BLOCKS.register("ams_base",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
            ));
    public static final RegistryObject<Block> AMS_LIMITER = BLOCKS.register("ams_limiter",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
            ));
    public static final RegistryObject<Block> AMS_EMITTER = BLOCKS.register("ams_emitter",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
            ));
    public static final RegistryObject<Block> ANCIENT_SCRAP = BLOCKS.register("ancient_scrap",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> ASH_DIGAMMA = BLOCKS.register("ash_digamma",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BALEONITITE_0 = BLOCKS.register("baleonitite_0",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BALEONITITE_1 = BLOCKS.register("baleonitite_1",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BALEONITITE_2 = BLOCKS.register("baleonitite_2",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BALEONITITE_3 = BLOCKS.register("baleonitite_3",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BALEONITITE_4 = BLOCKS.register("baleonitite_4",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BALEONITITE_CORE = BLOCKS.register("baleonitite_core",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BALEONITITE_SLAKED = BLOCKS.register("baleonitite_slaked",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BARRICADE = BLOCKS.register("barricade",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BASALT = BLOCKS.register("basalt",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BASALT_ASBESTOS = BLOCKS.register("basalt_asbestos",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BASALT_BRICK = BLOCKS.register("basalt_brick",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BASALT_FLUORITE = BLOCKS.register("basalt_fluorite",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BASALT_GEM = BLOCKS.register("basalt_gem",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BASALT_POLISHED = BLOCKS.register("basalt_polished",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BASALT_SMOOTH = BLOCKS.register("basalt_smooth",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BASALT_SULFUR = BLOCKS.register("basalt_sulfur",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BASALT_TILES = BLOCKS.register("basalt_tiles",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLAST_DOOR = BLOCKS.register("blast_door",
            () -> new HorizontalDirectionalBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ) {
                @Override
                public BlockState getStateForPlacement(BlockPlaceContext ctx) {
                    return this.defaultBlockState()
                            .setValue(FACING, ctx.getHorizontalDirection().getOpposite());
                }

                @Override
                protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
                    builder.add(FACING);
                }
            });
    public static final RegistryObject<Block> BLAST_ACTINIUM = BLOCKS.register("blast_actinium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_ACTINIUM = BLOCKS.register("block_actinium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_ADVANCED_ALLOY = BLOCKS.register("block_advanced_alloy",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_ALUMINIUM = BLOCKS.register("block_aluminium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_ASBESTOS = BLOCKS.register("block_asbestos",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_AU198 = BLOCKS.register("block_au198",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_AUSTRALIUM = BLOCKS.register("block_australium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_BAKELITE = BLOCKS.register("block_bakelite",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_BERYLLIUM = BLOCKS.register("block_beryllium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_BISMUTH= BLOCKS.register("block_bismuth",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_BORON= BLOCKS.register("block_boron",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_CADMIUM= BLOCKS.register("block_cadmium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_CAP_FRITZ = BLOCKS.register("block_cap_fritz",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_CAP_KORL= BLOCKS.register("block_cap_korl",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_CAP_NUKA= BLOCKS.register("block_cap_nuka",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_CAP_QUANTUM= BLOCKS.register("block_cap_quantum",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_CAP_RAD= BLOCKS.register("block_cap_rad",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_CAP_SPARK= BLOCKS.register("block_cap_sparkle",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_CAP_STAR= BLOCKS.register("block_cap_star",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_CAP_SUNSET= BLOCKS.register("block_cap_sunset",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_COAL_INFERNAL= BLOCKS.register("block_coal_infernal",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_COBALT= BLOCKS.register("block_cobalt",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_COKE = BLOCKS.register("block_coke",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_COLTAN = BLOCKS.register("block_coltan",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_COMBINE_STEEL = BLOCKS.register("block_combine_steel",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_CORIUM = BLOCKS.register("block_corium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_CORIUM_COBBLE = BLOCKS.register("block_corium_cobble",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_DAFFERGON = BLOCKS.register("block_daffergon",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_DESH = BLOCKS.register("block_desh",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_DINEUTRONIUM = BLOCKS.register("block_dineutronium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_DURA_STEEL = BLOCKS.register("block_dura_steel",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_ELECTRICAL_SCRAP = BLOCKS.register("block_electrical_scrap",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_EUPHEMIUM = BLOCKS.register("block_euphemium",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_EUPHEMIUM_CLUSTER = BLOCKS.register("block_euphemium_cluster",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_FALLOUT = BLOCKS.register("block_fallout",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_FIBERGLASS = BLOCKS.register("block_fiberglass",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_FLUORITE = BLOCKS.register("block_fluorite",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_FOAM = BLOCKS.register("block_foam",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_GRAPHITE = BLOCKS.register("block_graphite",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_GRAPHITE_DRILLED = BLOCKS.register("block_graphite_drilled",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLACK)
                    .strength(3.0f)
                    .requiresCorrectToolForDrops()
            )
    );
    public static final RegistryObject<Block> BLOCK_GRAPHITE_FUEL = BLOCKS.register("block_graphite_fuel",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_GRAPHITE_PLUTONIUM = BLOCKS.register("block_graphite_plutonium",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_GRAPHITE_ROD = BLOCKS.register("block_graphite_rod",
            () -> new GraphiteRodBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            )
    );
    public static final RegistryObject<Block> BLOCK_GRAPHITE_SOURCE = BLOCKS.register("block_graphite_source",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_INSULATOR = BLOCKS.register("block_insulator",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_LANTHANIUM = BLOCKS.register("block_lanthanium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_LEAD = BLOCKS.register("block_lead",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_LIGNITE = BLOCKS.register("block_lignite",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_LITHIUM = BLOCKS.register("block_lithium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_MAGNETIZED_TUNGSTEN = BLOCKS.register("block_magnetized_tungsten",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_METEOR = BLOCKS.register("block_meteor",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_METEOR_BROKEN = BLOCKS.register("block_meteor_broken",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_METEOR_COBBLE = BLOCKS.register("block_meteor_cobble",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_METEOR_MOLTEN = BLOCKS.register("block_meteor_molten",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_METEOR_TREASURE = BLOCKS.register("block_meteor_treasure",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_MOX_FUEL = BLOCKS.register("block_mox_fuel",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_NEPTUNIUM = BLOCKS.register("block_neptunium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_NIOBIUM = BLOCKS.register("block_niobium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_NITER = BLOCKS.register("block_niter",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_NITER_REINFORCED = BLOCKS.register("block_niter_reinforced",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_PLUTONIUM = BLOCKS.register("block_plutonium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_PLUTONIUM_FUEL = BLOCKS.register("block_plutonium_fuel",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_POLONIUM = BLOCKS.register("block_polonium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_POLYMER = BLOCKS.register("block_polymer",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_PU238 = BLOCKS.register("block_pu238",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_PU239 = BLOCKS.register("block_pu239",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_PU240 = BLOCKS.register("block_pu240",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_PU_MIX = BLOCKS.register("block_pu_mix",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_RA226 = BLOCKS.register("block_ra226",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_RADSPICE = BLOCKS.register("block_radspice",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_RED_COPPER = BLOCKS.register("block_red_copper",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_RED_PHOSPHORUS = BLOCKS.register("block_red_phosphorus",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_REIIUM = BLOCKS.register("block_reiium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_RUBBER = BLOCKS.register("block_rubber",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_SATURNITE = BLOCKS.register("block_saturnite",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_SCHRABIDATE = BLOCKS.register("block_schrabidate",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_SCHRABIDIUM = BLOCKS.register("block_schrabidium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_SCHRABIDIUM_CLUSTER = BLOCKS.register("block_schrabidium_cluster",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_SCHRABIDIUM_FUEL = BLOCKS.register("block_schrabidium_fuel",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_SCHRARANIUM = BLOCKS.register("block_schraranium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_SCRAP = BLOCKS.register("block_scrap",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_SEMTEX = BLOCKS.register("block_semtex",
            () -> new SemtexBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            )
    );
    public static final RegistryObject<Block> BLOCK_SLAG = BLOCKS.register("block_slag",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_SMORE = BLOCKS.register("block_smore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_SOLID_FUEL = BLOCKS.register("block_solid_fuel",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_SOLID_FUEL_BF = BLOCKS.register("block_solid_fuel_bf",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_SOLID_FUEL_PRESTO = BLOCKS.register("block_solid_fuel_presto",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_SOLID_FUEL_PRESTO_BF = BLOCKS.register("block_solid_fuel_presto_bf",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_SOLID_FUEL_PRESTO_TRIPLET = BLOCKS.register("block_solid_fuel_presto_triplet",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_SOLID_FUEL_PRESTO_TRIPLET_BF = BLOCKS.register("block_solid_fuel_presto_triplet_bf",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_SOLINIUM = BLOCKS.register("block_solinium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_STARMETAL = BLOCKS.register("block_starmetal",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_STEEL = BLOCKS.register("block_steel",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_SULFUR = BLOCKS.register("block_sulfur",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_TANTALIUM = BLOCKS.register("block_tantalium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_THORIUM = BLOCKS.register("block_thorium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_THORIUM_FUEL = BLOCKS.register("block_thorium_fuel",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_TITANIUM = BLOCKS.register("block_titanium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_TRINITITE = BLOCKS.register("block_trinitite",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_TRITIUM = BLOCKS.register("block_tritium",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            )
    );
    public static final RegistryObject<Block> BLOCK_TUNGSTEN = BLOCKS.register("block_tungsten",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_U233 = BLOCKS.register("block_u233",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_U235 = BLOCKS.register("block_u235",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_U238 = BLOCKS.register("block_u238",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_UNOBTAINIUM = BLOCKS.register("block_unobtainium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_URANIUM = BLOCKS.register("block_uranium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_URANIUM_FUEL = BLOCKS.register("block_uranium_fuel",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_VERTICIUM = BLOCKS.register("block_verticium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_WEIDANIUM = BLOCKS.register("block_weidanium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_WHITE_PHOSPHORUS = BLOCKS.register("block_white_phosphorus",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_YELLOWCAKE = BLOCKS.register("block_yellowcake",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> BLOCK_ZIRCONIUM = BLOCKS.register("block_zirconium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ));
    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
