package com.hbmax.registry;

import com.hbmax.blockentity.*;

import net.minecraft.world.level.block.entity.BlastFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, "hbmax");

    // ================= ПЕЧКА =================
    public static final RegistryObject<BlockEntityType<BlockEntityElectricFurnace>> ELECTRIC_FURNACE =
            BLOCK_ENTITIES.register("electric_furnace", () ->
                    BlockEntityType.Builder.of(
                            BlockEntityElectricFurnace::new,
                            ModBlocks.ELECTRIC_FURNACE.get()
                    ).build(null)
            );
    // ARC furnace
    public static final RegistryObject<BlockEntityType<BlockEntityArcFurnace>> MACHINE_ARC_FURNACE =
            BLOCK_ENTITIES.register("machine_arc_furnace", () ->
                    BlockEntityType.Builder.of(
                            BlockEntityArcFurnace::new,
                            ModBlocks.MACHINE_ARC_FURNACE_OFF.get(),
                            ModBlocks.MACHINE_ARC_FURNACE_ON.get()
                    ).build(null));

    // ================= КАБЕЛЬ =================
    public static final RegistryObject<BlockEntityType<BlockEntityCable>> CABLE =
            BLOCK_ENTITIES.register("cable", () ->
                    BlockEntityType.Builder.of(
                            BlockEntityCable::new,
                            ModBlocks.CABLE.get()
                    ).build(null)
            );

    public static final RegistryObject<BlockEntityType<HBlastFurnaceBlockEntity>> BLAST_FURNACE_BE =
            BLOCK_ENTITIES.register("machine_blast_furnace", () ->
                    BlockEntityType.Builder.of(
                            HBlastFurnaceBlockEntity::new,  // ← ТВОЙ КЛАСС!
                            ModBlocks.BLAST_FURNACE_BLOCK.get()
                    ).build(null));

    // батарея
    public static final RegistryObject<BlockEntityType<BlockEntityBattery>> MACHINE_BATTERY =
            BLOCK_ENTITIES.register("machine_battery", () ->
                    BlockEntityType.Builder.of(
                            BlockEntityBattery::new,
                            ModBlocks.MACHINE_POTATO_BATTERY.get(),
                            ModBlocks.MACHINE_BATTERY.get(),
                            ModBlocks.MACHINE_LITHIUM_BATTERY.get(),
                            ModBlocks.MACHINE_SCHRABIDIUM_BATTERY.get(),
                            ModBlocks.MACHINE_DESH_BATTERY.get(),
                            ModBlocks.MACHINE_SATURNITE_BATTERY.get(),
                            ModBlocks.MACHINE_EUPHEMIUM_BATTERY.get(),
                            ModBlocks.MACHINE_RADSPICE_BATTERY.get(),
                            ModBlocks.MACHINE_DINEUTRONIUM_BATTERY.get(),
                            ModBlocks.MACHINE_ELECTRONIUM_BATTERY.get()
                    ).build(null));



    // ================= REGISTER =================
    public static void register(IEventBus bus) {
        BLOCK_ENTITIES.register(bus);
    }
}
