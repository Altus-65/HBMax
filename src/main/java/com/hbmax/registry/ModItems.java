package com.hbmax.registry;

import com.hbmax.item.*;
import com.hbmax.item.ammo.AmmoEffect;
import com.hbmax.item.ammo.AmmoItem;
import com.hbmax.item.ammo.AmmoType;
import com.hbmax.item.armors.ModArmorMaterials;
import com.hbmax.item.armors.UnbreakableArmorItem;
import com.hbmax.item.tools.*;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, "hbmax");
    // powder
    public static final RegistryObject<Item> POWDER_AC227 = ITEMS.register("powder_ac227",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_ACTINIUM = ITEMS.register("powder_actinium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_ALUMINIUM = ITEMS.register("powder_aluminium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_ASBESTOS = ITEMS.register("powder_asbestos",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_ASTATINE = ITEMS.register("powder_astatine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_AT209 = ITEMS.register("powder_at209",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_AU198 = ITEMS.register("powder_au198",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_AUSTRALIUM = ITEMS.register("powder_australium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_BAKELITE = ITEMS.register("powder_bakelite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_BALEFIRE = ITEMS.register("powder_balefire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_BERYLLIUM = ITEMS.register("powder_beryllium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_BISMUTH = ITEMS.register("powder_bismuth",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_BORAX = ITEMS.register("powder_borax",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_BORON = ITEMS.register("powder_boron",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_BROMINE = ITEMS.register("powder_bromine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_CADMIUM = ITEMS.register("powder_cadmium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_CAESIUM = ITEMS.register("powder_caesium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_CALCIUM = ITEMS.register("powder_calcium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_CDALLOY = ITEMS.register("powder_cdalloy",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_CERIUM = ITEMS.register("powder_cerium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_CHLOROPHYTE = ITEMS.register("powder_chlorophyte",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_CLOUD = ITEMS.register("powder_cloud",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_CO60 = ITEMS.register("powder_co60",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_COAL = ITEMS.register("powder_coal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_COBALT = ITEMS.register("powder_cobalt",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_COLTAN = ITEMS.register("powder_coltan",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_COLTAN_ORE = ITEMS.register("powder_coltan_ore",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_COMBINE_STEEL = ITEMS.register("powder_combine_steel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_COPPER = ITEMS.register("powder_copper",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_CS137 = ITEMS.register("powder_cs137",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_DAFFERGON = ITEMS.register("powder_daffergon",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_DESH = ITEMS.register("powder_desh",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_DESH_MIX = ITEMS.register("powder_desh_mix",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_DESH_READY = ITEMS.register("powder_desh_ready",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_DIAMOND = ITEMS.register("powder_diamond",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_DINEUTRONIUM = ITEMS.register("powder_dineutronium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_DURA_STEEL = ITEMS.register("powder_dura_steel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_EMERALD = ITEMS.register("powder_emerald",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_EUPHEMIUM = ITEMS.register("powder_euphemium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_FIRE = ITEMS.register("powder_fire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_FLUX = ITEMS.register("powder_flux",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_GOLD = ITEMS.register("powder_gold",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_I131 = ITEMS.register("powder_i131",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_ICE = ITEMS.register("powder_ice",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_IMPURE_OSMIRIDIUM = ITEMS.register("powder_impure_osmiridium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_IODINE = ITEMS.register("powder_iodine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_IRON = ITEMS.register("powder_iron",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_LANTHANIUM = ITEMS.register("powder_lanthanium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_LAPIS = ITEMS.register("powder_lapis",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_LEAD = ITEMS.register("powder_lead",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_LIGNITE = ITEMS.register("powder_lignite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_LITHIUM = ITEMS.register("powder_lithium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_MAGIC = ITEMS.register("powder_magic",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_MAGNETIZED_TUNGSTEN = ITEMS.register("powder_magnetized_tungsten",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_METEORITE = ITEMS.register("powder_meteorite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_NEODYMIUM = ITEMS.register("powder_neodymium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_NEPTUNIUM = ITEMS.register("powder_neptunium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_NIOBIUM = ITEMS.register("powder_niobium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_NITAN_MIX = ITEMS.register("powder_nitan_mix",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_OSMIRIDIUM = ITEMS.register("powder_osmiridium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_PALEOGENITE = ITEMS.register("powder_paleogenite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_PB209 = ITEMS.register("powder_pb209",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_PLUTONIUM = ITEMS.register("powder_plutonium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_POISON = ITEMS.register("powder_poison",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_POLONIUM = ITEMS.register("powder_polonium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_POLYMER = ITEMS.register("powder_polymer",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_POWER = ITEMS.register("powder_power",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_QUARTZ = ITEMS.register("powder_quartz",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_RA226 = ITEMS.register("powder_ra226",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_RADSPICE = ITEMS.register("powder_radspice",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_RED_COPPER = ITEMS.register("powder_red_copper",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_REIIUM = ITEMS.register("powder_reiium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_SCHRABIDATE = ITEMS.register("powder_schrabidate",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_SCHRABIDIUM = ITEMS.register("powder_schrabidium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_SEMTEX_MIX = ITEMS.register("powder_semtex_mix",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_SPARK_MIX = ITEMS.register("powder_spark_mix",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_SR90 = ITEMS.register("powder_sr90",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_STEEL = ITEMS.register("powder_steel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_STRONTIUM = ITEMS.register("powder_strontium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_TANTALIUM = ITEMS.register("powder_tantalium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_TCALLOY = ITEMS.register("powder_tcalloy",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_TEKTITE = ITEMS.register("powder_tektite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_TENNESSINE = ITEMS.register("powder_tennessine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_THERMITE = ITEMS.register("powder_thermite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_THORIUM = ITEMS.register("powder_thorium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_TITANIUM = ITEMS.register("powder_titanium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_TUNGSTEN = ITEMS.register("powder_tungsten",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_UNOBTAINIUM = ITEMS.register("powder_unobtainium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_URANIUM = ITEMS.register("powder_uranium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_VERTICIUM = ITEMS.register("powder_verticium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_WEIDANIUM = ITEMS.register("powder_weidanium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_XE135 = ITEMS.register("powder_xe135",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_YELLOWCAKE = ITEMS.register("powder_yellowcake",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_ZIRCONIUM = ITEMS.register("powder_zirconium",
            () -> new Item(new Item.Properties()));
    // powder tiny
    public static final RegistryObject<Item> POWDER_AC227_TINY = ITEMS.register("powder_ac227_tiny",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_ACTINIUM_TINY = ITEMS.register("powder_actinium_tiny",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_AT209_TINY = ITEMS.register("powder_at209_tiny",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_AU198_TINY = ITEMS.register("powder_au198_tiny",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_BORON_TINY = ITEMS.register("powder_boron_tiny",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_CERIUM_TINY = ITEMS.register("powder_cerium_tiny",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_CO60_TINY = ITEMS.register("powder_co60_tiny",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_COAL_TINY = ITEMS.register("powder_coal_tiny",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_COBALT_TINY = ITEMS.register("powder_cobalt_tiny",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_CS137_TINY = ITEMS.register("powder_cs137_tiny",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_i131_TINY = ITEMS.register("powder_i131_tiny",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_IODINE_TINY = ITEMS.register("powder_iodine_tiny",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_IRON_TINY = ITEMS.register("powder_iron_tiny",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_LANTHANIUM_TINY = ITEMS.register("powder_lanthanium_tiny",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_LITHIUM_TINY = ITEMS.register("powder_lithium_tiny",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_METEORITE_TINY = ITEMS.register("powder_meteorite_tiny",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_NEODYMIUM_TINY = ITEMS.register("powder_neodymium_tiny",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_NIOBIUM_TINY = ITEMS.register("powder_niobium_tiny",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_PALEOGENITE_TINY = ITEMS.register("powder_paleogenite_tiny",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_PB209_TINY = ITEMS.register("powder_pb209_tiny",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_RADSPICE_TINY = ITEMS.register("powder_radspice_tiny",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_SR90_TINY = ITEMS.register("powder_sr90_tiny",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_STEEL_TINY = ITEMS.register("powder_steel_tiny",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWDER_XE135_TINY = ITEMS.register("powder_xe135_tiny",
            () -> new Item(new Item.Properties()));
    // nuggets
    public static final RegistryObject<Item> NUGGET = ITEMS.register("nugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_AC227 = ITEMS.register("nugget_ac227",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_ACTINIUM = ITEMS.register("nugget_actinium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_AM241 = ITEMS.register("nugget_am241",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_AM242 = ITEMS.register("nugget_am242",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_AM_MIX = ITEMS.register("nugget_am_mix",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_AMERICIUM_FUEL = ITEMS.register("nugget_americium_fuel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_ARSENIC = ITEMS.register("nugget_arsenic",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_AU198 = ITEMS.register("nugget_au198",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_AUSTRALIUM = ITEMS.register("nugget_australium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_AUSTRALIUM_GREATER = ITEMS.register("nugget_australium_greater",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_AUSTRALIUM_LESSER = ITEMS.register("nugget_australium_lesser",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_BERYLLIUM = ITEMS.register("nugget_beryllium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_BISMUTH = ITEMS.register("nugget_bismuth",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_CADMIUM = ITEMS.register("nugget_cadmium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_CO60 = ITEMS.register("nugget_co60",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_COBALT = ITEMS.register("nugget_cobalt",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_DAFFERGON = ITEMS.register("nugget_daffergon",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_DESH = ITEMS.register("nugget_desh",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_DINEUTRONIUM = ITEMS.register("nugget_dineutronium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_EUPHEMIUM = ITEMS.register("nugget_euphemium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_GH336 = ITEMS.register("nugget_gh336",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_HES = ITEMS.register("nugget_hes",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_LEAD = ITEMS.register("nugget_lead",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_LES = ITEMS.register("nugget_les",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_MERCURY = ITEMS.register("nugget_mercury",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_MOX_FUEL = ITEMS.register("nugget_mox_fuel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_NEPTUNIUM = ITEMS.register("nugget_neptunium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_NIOBIUM = ITEMS.register("nugget_niobium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_OSMIRIDIUM = ITEMS.register("nugget_osmiridium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_PB209 = ITEMS.register("nugget_pb209",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_PLUTONIUM = ITEMS.register("nugget_plutonium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_PLUTONIUM_FUEL = ITEMS.register("nugget_plutonium_fuel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_POLONIUM = ITEMS.register("nugget_polonium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_PU238 = ITEMS.register("nugget_pu238",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_PU239 = ITEMS.register("nugget_pu239",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_PU240 = ITEMS.register("nugget_pu240",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_PU241 = ITEMS.register("nugget_pu241",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_PU_MIX = ITEMS.register("nugget_pu_mix",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_RA226 = ITEMS.register("nugget_ra226",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_RADSPICE = ITEMS.register("nugget_radspice",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_REIIUM = ITEMS.register("nugget_reiium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_SCHRABIDIUM = ITEMS.register("nugget_schrabidium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_SCHRABIDIUM_FUEL = ITEMS.register("nugget_schrabidium_fuel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_SILICON = ITEMS.register("nugget_silicon",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_SOLINIUM = ITEMS.register("nugget_solinium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_SR90 = ITEMS.register("nugget_sr90",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_STRONTIUM = ITEMS.register("nugget_strontium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_TANTALIUM = ITEMS.register("nugget_tantalium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_TECHNETIUM = ITEMS.register("nugget_technetium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_TH232 = ITEMS.register("nugget_th232",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_THORIUM_FUEL = ITEMS.register("nugget_thorium_fuel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_U233 = ITEMS.register("nugget_u233",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_U235 = ITEMS.register("nugget_u235",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_U238 = ITEMS.register("nugget_u238",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_UNOBTAINIUM = ITEMS.register("nugget_unobtainium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_UNOBTAINIUM_GREATER = ITEMS.register("nugget_unobtainium_greater",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_UNOBTANIUM_LESSER = ITEMS.register("nugget_unobtainium_lesser",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_URANIUM = ITEMS.register("nugget_uranium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_URANIUM_FUEL = ITEMS.register("nugget_uranium_fuel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_VERTICIUM = ITEMS.register("nugget_verticium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_WEIDANIUM = ITEMS.register("nugget_weidanium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_ZIRCONIUM = ITEMS.register("nugget_zirconium",
            () -> new Item(new Item.Properties()));
    // billets
    public static final RegistryObject<Item> BILLET_AC227 = ITEMS.register("billet_ac227",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_AM241 = ITEMS.register("billet_am241",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_AM242 = ITEMS.register("billet_am242",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_AM_MIX = ITEMS.register("billet_am_mix",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_AMERICIUM_FUEL = ITEMS.register("billet_americium_fuel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_AU198 = ITEMS.register("billet_au198",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_AUSTRALIUM = ITEMS.register("billet_australium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_AUSTRALIUM_GREATER = ITEMS.register("billet_australium_greater",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_AUSTRALIUM_LESSER = ITEMS.register("billet_australium_lesser",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_BALEFIRE_GOLD = ITEMS.register("billet_balefire_gold",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_BERYLLIUM = ITEMS.register("billet_beryllium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_BISMUTH = ITEMS.register("billet_bismuth",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_CO60 = ITEMS.register("billet_co60",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_FLASHLEAD = ITEMS.register("billet_flashlead",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_GH336 = ITEMS.register("billet_gh336",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_HES = ITEMS.register("billet_hes",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_LES = ITEMS.register("billet_les",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_MOX_FUEL = ITEMS.register("billet_mox_fuel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_NEPTUNIUM = ITEMS.register("billet_neptunium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_NEPTUNIUM_FUEL = ITEMS.register("billet_neptunium_fuel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_NUCLEAR_WASTE = ITEMS.register("billet_nuclear_waste",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_PB209 = ITEMS.register("billet_pb209",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_PLUTONIUM = ITEMS.register("billet_plutonium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_PLUTONIUM_FUEL = ITEMS.register("billet_plutonium_fuel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_PO210BE = ITEMS.register("billet_po210be",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_POLONIUM = ITEMS.register("billet_polonium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_PU238 = ITEMS.register("billet_pu238",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_PU238BE = ITEMS.register("billet_pu238be",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_PU239 = ITEMS.register("billet_pu239",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_PU240 = ITEMS.register("billet_pu240",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_PU241 = ITEMS.register("billet_pu241",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_PU_MIX = ITEMS.register("billet_pu_mix",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_RA226 = ITEMS.register("billet_ra226",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_RA226BE = ITEMS.register("billet_ra226be",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_SCHRABIDIUM = ITEMS.register("billet_schrabidium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_SCHRABIDIUM_FUEL = ITEMS.register("billet_schrabidium_fuel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_SILICON = ITEMS.register("billet_silicon",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_SOLINIUM = ITEMS.register("billet_solinium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_SR90 = ITEMS.register("billet_sr90",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_TECHNETIUM = ITEMS.register("billet_technetium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_TH232 = ITEMS.register("billet_th232",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_THORIUM_FUEL = ITEMS.register("billet_thorium_fuel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_U233 = ITEMS.register("billet_u233",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_U235 = ITEMS.register("billet_u235",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_U238 = ITEMS.register("billet_u238",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_UNOBTAINIUM = ITEMS.register("billet_unobtainium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_URANIUM = ITEMS.register("billet_uranium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_URANIUM_FUEL = ITEMS.register("billet_uranium_fuel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_YHARONITE = ITEMS.register("billet_yharonite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_ZFB_AM_MIX = ITEMS.register("billet_zfb_am_mix",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_ZFB_BISMUTH = ITEMS.register("billet_zfb_bismuth",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_ZFB_PU241 = ITEMS.register("billet_zfb_pu241",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLET_ZIRCONIUM = ITEMS.register("billet_zirconium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BIO_WAFER = ITEMS.register("bio_wafer",
            () -> new Item(new Item.Properties()));
    // ingots
    public static final RegistryObject<Item> INGOT_RED_COPPER = ITEMS.register("ingot_red_copper",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_AC227 = ITEMS.register("ingot_ac227",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_ACTINIUM = ITEMS.register("ingot_actinium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_ADVANCED_ALLOY = ITEMS.register("ingot_advanced_alloy",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_ALUMINIUM = ITEMS.register("ingot_aluminium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_AM241 = ITEMS.register("ingot_am241",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_AM242 = ITEMS.register("ingot_am242",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_AM_MIX = ITEMS.register("ingot_am_mix",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_AMERICIUM_FUEL = ITEMS.register("ingot_americium_fuel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_ARSENIC = ITEMS.register("ingot_arsenic",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_ASBESTOS= ITEMS.register("ingot_asbestos",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_ASTATINE = ITEMS.register("ingot_astatine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_AU198 = ITEMS.register("ingot_au198",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_AUSTRALIUM = ITEMS.register("ingot_australium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_BAKELITE = ITEMS.register("ingot_bakelite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_BERYLLIUM = ITEMS.register("ingot_beryllium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_BIORUBBER = ITEMS.register("ingot_biorubber",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_BISMUTH = ITEMS.register("ingot_bismuth",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_BORON = ITEMS.register("ingot_boron",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_BROMINE = ITEMS.register("ingot_bromine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_BSCCO = ITEMS.register("ingot_bscco",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_C4 = ITEMS.register("ingot_c4",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_CADMIUM = ITEMS.register("ingot_cadmium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_CAESIUM = ITEMS.register("ingot_caesium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_CALCIUM = ITEMS.register("ingot_calcium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_CDALLOY = ITEMS.register("ingot_cdalloy",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_CERIUM = ITEMS.register("ingot_cerium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_CHAINSTEEL = ITEMS.register("ingot_chainsteel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_CHAINSTEEL_HOT = ITEMS.register("ingot_chainsteel_hot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_CO60 = ITEMS.register("ingot_co60",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_COBALT = ITEMS.register("ingot_cobalt",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_COMBINE_STEEL = ITEMS.register("ingot_combine_steel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_DAFFERGON = ITEMS.register("ingot_daffergon",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_DESH = ITEMS.register("ingot_desh",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_DINEUTRONIUM= ITEMS.register("ingot_dineutronium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_DURA_STEEL = ITEMS.register("ingot_dura_steel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_ELECTRONIUM = ITEMS.register("ingot_electronium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_EUPHEMIUM = ITEMS.register("ingot_euphemium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_FERROURANIUM = ITEMS.register("ingot_ferrouranium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_FIBERGLASS = ITEMS.register("ingot_fiberglass",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_FIREBRICK = ITEMS.register("ingot_firebrick",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_GH336 = ITEMS.register("ingot_gh336",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_GRAPHITE = ITEMS.register("ingot_graphite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_HES = ITEMS.register("ingot_hes",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_I131 = ITEMS.register("ingot_i131",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_IODINE = ITEMS.register("ingot_iodine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_LANTHANIUM = ITEMS.register("ingot_lanthanium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_LEAD = ITEMS.register("ingot_lead",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_LES = ITEMS.register("ingot_les",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_LITHIUM = ITEMS.register("ingot_lithium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_MAGNETIZED_TUNGSTEN = ITEMS.register("ingot_magnetized_tungsten",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_METEORITE = ITEMS.register("ingot_meteorite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_METEORITE_FORGED = ITEMS.register("ingot_meteorite_forged",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_METEORITE_FORGED_HOT = ITEMS.register("ingot_meteorite_forged_hot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_METEORITE_HOT = ITEMS.register("ingot_meteorite_hot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_MOX_FUEL = ITEMS.register("ingot_mox_fuel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_MUD = ITEMS.register("ingot_mud",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_NEODYMIUM = ITEMS.register("ingot_neodymium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_NEPTUNIUM = ITEMS.register("ingot_neptunium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_NEPTUNIUM_FUEL = ITEMS.register("ingot_neptunium_fuel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_NIOBIUM = ITEMS.register("ingot_niobium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_OSMIRIDIUM = ITEMS.register("ingot_osmiridium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_PB209 = ITEMS.register("ingot_pb209",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_PC = ITEMS.register("ingot_pc",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_PHOSPHORUS = ITEMS.register("ingot_phosphorus",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_PLUTONIUM = ITEMS.register("ingot_plutonium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_PLUTONIUM_FUEL = ITEMS.register("ingot_plutonium_fuel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_POLONIUM = ITEMS.register("ingot_polonium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_POLYMER = ITEMS.register("ingot_polymer",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_PU238 = ITEMS.register("ingot_pu238",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_PU239 = ITEMS.register("ingot_pu239",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_PU240 = ITEMS.register("ingot_pu240",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_PU241 = ITEMS.register("ingot_pu241",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_PU_MIX = ITEMS.register("ingot_pu_mix",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_PVC = ITEMS.register("ingot_pvc",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_RA226 = ITEMS.register("ingot_ra226",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_RADSPICE = ITEMS.register("ingot_radspice",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_REIIUM = ITEMS.register("ingot_reiium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_RUBBER = ITEMS.register("ingot_rubber",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_SATURNITE = ITEMS.register("ingot_saturnite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_SCHRABIDATE = ITEMS.register("ingot_schrabidate",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_SCHRABIDIUM = ITEMS.register("ingot_schrabidium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_SCHRABIDIUM_FUEL = ITEMS.register("ingot_schrabidium_fuel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_SCHRARANIUM = ITEMS.register("ingot_schraranium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_SEMTEX = ITEMS.register("ingot_semtex",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_SILICON = ITEMS.register("ingot_silicon",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_SR90 = ITEMS.register("ingot_sr90",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_STARMETAL = ITEMS.register("ingot_starmetal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_SMORE = ITEMS.register("ingot_smore",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_SOLINIUM = ITEMS.register("ingot_solinium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_STEEL = ITEMS.register("ingot_steel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_STEEL_DUSTED = ITEMS.register("ingot_steel_dusted",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_STEEL_DUSTED_HOT = ITEMS.register("ingot_steel_dusted_hot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_STRONTIUM = ITEMS.register("ingot_strontium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_TANTAlIUM = ITEMS.register("ingot_tantalium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_TCALLOY = ITEMS.register("ingot_tcalloy",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_TECHNETIUM = ITEMS.register("ingot_technetium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_TENNESSINE = ITEMS.register("ingot_tennessine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_TH232 = ITEMS.register("ingot_th232",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_THORIUM_FUEL = ITEMS.register("ingot_thorium_fuel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_TITANIUM = ITEMS.register("ingot_titanium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_TUNGSTEN = ITEMS.register("ingot_tungsten",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_U233 = ITEMS.register("ingot_u233",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_U235 = ITEMS.register("ingot_u235",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_U238 = ITEMS.register("ingot_u238",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_U238M2 = ITEMS.register("ingot_u238m2",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_UNOBTAINIUM = ITEMS.register("ingot_unobtainium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_URANIUM = ITEMS.register("ingot_uranium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_URANIUM_FUEL = ITEMS.register("ingot_uranium_fuel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_VERTICIUM = ITEMS.register("ingot_verticium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_WAIDANIUM = ITEMS.register("ingot_waidanium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_ZIRCONIUM = ITEMS.register("ingot_zirconium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLADE_METEORITE = ITEMS.register("blade_meteorite",
            () -> new Item(new Item.Properties()));
    // ore
    public static final RegistryObject<Item> URANIUM_ORE = ITEMS.register("uranium_ore",
            () -> new BlockItem(ModBlocks.URANIUM_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> ALUMINIUM_ORE = ITEMS.register("aluminium_ore",
            () -> new BlockItem(ModBlocks.ALUMINIUM_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> ASBESTOS_ORE = ITEMS.register("asbestos_ore",
            () -> new BlockItem(ModBlocks.ASBESTOS_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> AUSTRALIUM_ORE = ITEMS.register("australium_ore",
            () -> new BlockItem(ModBlocks.AUSTRALIUM_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BERYLLIUM_ORE = ITEMS.register("beryllium_ore",
            () -> new BlockItem(ModBlocks.BERYLLIUM_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> CINNEBAR_ORE = ITEMS.register("cinnebar_ore",
            () -> new BlockItem(ModBlocks.CINNEBAR_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> COBALT_ORE = ITEMS.register("cobalt_ore",
            () -> new BlockItem(ModBlocks.COBALT_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> COLTAN_ORE = ITEMS.register("coltan_ore",
            () -> new BlockItem(ModBlocks.COLTAN_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> COAL_OIL_BURNING_ORE = ITEMS.register("coal_oil_burning_ore",
            () -> new BlockItem(ModBlocks.COAL_OIL_BURNING_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> COAL_OIL_ORE = ITEMS.register("coal_oil_ore",
            () -> new BlockItem(ModBlocks.COAL_OIL_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> FLUORITE_ORE = ITEMS.register("fluorite_ore",
            () -> new BlockItem(ModBlocks.FLUORITE_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> LEAD_ORE = ITEMS.register("lead_ore",
            () -> new BlockItem(ModBlocks.LEAD_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> DAFFERGON_ORE = ITEMS.register("daffergon_ore",
            () -> new BlockItem(ModBlocks.DAFFERGON_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> DAFFGON_ORE = ITEMS.register("daffgon_ore",
            () -> new BlockItem(ModBlocks.DAFFGON_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> LITHIUM_ORE = ITEMS.register("lithium_ore",
            () -> new BlockItem(ModBlocks.LITHIUM_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> NITER_ORE = ITEMS.register("niter_ore",
            () -> new BlockItem(ModBlocks.NITER_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> RARE_ORE = ITEMS.register("rare_ore",
            () -> new BlockItem(ModBlocks.RARE_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> REIIUM_ORE = ITEMS.register("reiium_ore",
            () -> new BlockItem(ModBlocks.REIIUM_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> SCHRABIDIUM_ORE = ITEMS.register("schrabidium_ore",
            () -> new BlockItem(ModBlocks.SCHRABIDIUM_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> SULFUR_ORE = ITEMS.register("sulfur_ore",
            () -> new BlockItem(ModBlocks.SULFUR_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> THORIUM_ORE = ITEMS.register("thorium_ore",
            () -> new BlockItem(ModBlocks.THORIUM_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_ORE = ITEMS.register("titanium_ore",
            () -> new BlockItem(ModBlocks.TITANIUM_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_ORE = ITEMS.register("tungsten_ore",
            () -> new BlockItem(ModBlocks.TUNGSTEN_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> UNOBTAINIUM_ORE = ITEMS.register("unobtainium_ore",
            () -> new BlockItem(ModBlocks.UNOBTAINIUM_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> VERTICIUM_ORE = ITEMS.register("verticium_ore",
            () -> new BlockItem(ModBlocks.VERTICIUM_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> WAIDANIUM_ORE = ITEMS.register("waidanium_ore",
            () -> new BlockItem(ModBlocks.WAIDANIUM_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> SALPETER_ORE = ITEMS.register("salpeter_ore",
            () -> new BlockItem(ModBlocks.SALPETER_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> MALACHITE_ORE = ITEMS.register("malachite_ore",
            () -> new BlockItem(ModBlocks.MALACHITE_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> LIGNITE_ORE = ITEMS.register("lignite_ore",
            () -> new BlockItem(ModBlocks.LIGNITE_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BEDROCK_BLOCK_ORE = ITEMS.register("bedrock_block_ore",
            () -> new BlockItem(ModBlocks.BEDROCK_BLOCK_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BEDROCK_COLTAN_ORE = ITEMS.register("bedrock_coltan_ore",
            () -> new BlockItem(ModBlocks.BEDROCK_COLTAN_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> NETHER_COBALT_ORE = ITEMS.register("nether_cobalt_ore",
            () -> new BlockItem(ModBlocks.NETHER_COBALT_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> NETHER_FIRE_ORE = ITEMS.register("nether_fire_ore",
            () -> new BlockItem(ModBlocks.NETHER_FIRE_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> NETHER_COAL_ORE = ITEMS.register("nether_coal_ore",
            () -> new BlockItem(ModBlocks.NETHER_COAL_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> NETHER_PLUTONIUM_ORE = ITEMS.register("nether_plutonium_ore",
            () -> new BlockItem(ModBlocks.NETHER_PLUTONIUM_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> NETHER_SCHRABIDIUM_ORE = ITEMS.register("nether_schrabidium_ore",
            () -> new BlockItem(ModBlocks.NETHER_SCHRABIDIUM_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> NETHER_SMOLDERING_ORE = ITEMS.register("nether_smoldering_ore",
            () -> new BlockItem(ModBlocks.NETHER_SMOLDERING_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> NETHER_SULFUR_ORE = ITEMS.register("nether_sulfur_ore",
            () -> new BlockItem(ModBlocks.NETHER_SULFUR_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> NETHER_TUNGSTEN_ORE = ITEMS.register("nether_tungsten_ore",
            () -> new BlockItem(ModBlocks.NETHER_TUNGSTEN_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> NETHER_URANIUM_ORE = ITEMS.register("nether_uranium_ore",
            () -> new BlockItem(ModBlocks.NETHER_URANIUM_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> ENDER_TIKITE_ORE = ITEMS.register("ender_tikite_ore",
            () -> new BlockItem(ModBlocks.ENDER_TIKITE_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> ENDER_TIKITE_ALT_ORE = ITEMS.register("ender_tikite_alt_ore",
            () -> new BlockItem(ModBlocks.ENDER_TIKITE_ALT_ORE.get(), new Item.Properties()));
    // entity
    public static final RegistryObject<Item> ELECTRIC_FURNACE = ITEMS.register("electric_furnace",
            () -> new BlockItem(ModBlocks.ELECTRIC_FURNACE.get(), new Item.Properties()));
    public static final RegistryObject<Item> CABLE = ITEMS.register("red_cable",
            () -> new BlockItem(ModBlocks.CABLE.get(), new Item.Properties()));
    public static final RegistryObject<Item> MACHINE_ARC_FURNACE_OFF = ITEMS.register("machine_arc_furnace_off",
            () -> new BlockItem(ModBlocks.MACHINE_ARC_FURNACE_OFF.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLAST_FURNACE_ITEM = ITEMS.register("machine_blast_furnace",
            () -> new BlockItem(ModBlocks.BLAST_FURNACE_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> MACHINE_TRANSFORMER = ITEMS.register("machine_transformer",
            () -> new BlockItem(ModBlocks.MACHINE_TRANSFORMER.get(), new Item.Properties()));
    // battery
    public static final RegistryObject<Item> MACHINE_SCHRABIDIUM_BATTERY = ITEMS.register("machine_schrabidium_battery",
            () -> new BlockItem(ModBlocks.MACHINE_SCHRABIDIUM_BATTERY.get(), new Item.Properties()));
    public static final RegistryObject<Item> MACHINE_POTATO_BATTERY = ITEMS.register("machine_battery_potato",
            () -> new BlockItem(ModBlocks.MACHINE_POTATO_BATTERY.get(), new Item.Properties()));
    public static final RegistryObject<Item> MACHINE_BATTERY = ITEMS.register("machine_battery",
            () -> new BlockItem(ModBlocks.MACHINE_BATTERY.get(), new Item.Properties()));
    public static final RegistryObject<Item> MACHINE_LITHIUM_BATTERY = ITEMS.register("machine_lithium_battery",
            () -> new BlockItem(ModBlocks.MACHINE_LITHIUM_BATTERY.get(), new Item.Properties()));
    public static final RegistryObject<Item> MACHINE_DESH_BATTERY = ITEMS.register("machine_desh_battery",
            () -> new BlockItem(ModBlocks.MACHINE_DESH_BATTERY.get(), new Item.Properties()));
    public static final RegistryObject<Item> MACHINE_SATURNITE_BATTERY = ITEMS.register("machine_saturnite_battery",
            () -> new BlockItem(ModBlocks.MACHINE_SATURNITE_BATTERY.get(), new Item.Properties()));
    public static final RegistryObject<Item> MACHINE_EUPHEMIUM_BATTERY = ITEMS.register("machine_euphemium_battery",
            () -> new BlockItem(ModBlocks.MACHINE_EUPHEMIUM_BATTERY.get(), new Item.Properties()));
    public static final RegistryObject<Item> MACHINE_RADSPICE_BATTERY = ITEMS.register("machine_radspice_battery",
            () -> new BlockItem(ModBlocks.MACHINE_RADSPICE_BATTERY.get(), new Item.Properties()));
    public static final RegistryObject<Item> MACHINE_DINEUTRONIUM_BATTERY = ITEMS.register("machine_dineutronium_battery",
            () -> new BlockItem(ModBlocks.MACHINE_DINEUTRONIUM_BATTERY.get(), new Item.Properties()));
    public static final RegistryObject<Item> MACHINE_ELECTRONIUM_BATTERY = ITEMS.register("machine_electronium_battery",
            () -> new BlockItem(ModBlocks.MACHINE_ELECTRONIUM_BATTERY.get(), new Item.Properties()));
    // Обычные батарейки
    public static final RegistryObject<Item> BATTERY_ADVANCED = ITEMS.register("battery_advanced",
            () -> new ItemBattery(20_000, 10_000, 10_000));
    public static final RegistryObject<Item> BATTERY_SCHRABIDIUM = ITEMS.register("battery_schrabidium",
            () -> new ItemBattery(1_000_000, 100_000, 100_000));
    public static final RegistryObject<Item> BATTERY = ITEMS.register("battery_generic",
            () -> new ItemBattery(5_000, 2_000, 2_000));
    public static final RegistryObject<Item> BATTERY_ADVANCED_CELL = ITEMS.register("battery_advanced_cell",
            () -> new ItemBattery(60_000, 10_000, 10_000));
    public static final RegistryObject<Item> BATTERY_ADVANCED_CELL_4 = ITEMS.register("battery_advanced_cell_4",
            () -> new ItemBattery(240_000, 40_000, 40_000));
    public static final RegistryObject<Item> BATTERY_ADVANCED_CELL_12 = ITEMS.register("battery_advanced_cell_12",
            () -> new ItemBattery(720_000, 120_000, 120_000));
    public static final RegistryObject<Item> BATTERY_RED_CELL = ITEMS.register("battery_red_cell",
            () -> new ItemBattery(15_000, 2_000, 2_000));
    public static final RegistryObject<Item> BATTERY_RED_CELL_6 = ITEMS.register("battery_red_cell_6",
            () -> new ItemBattery(90_000, 12_000, 12_000));
    public static final RegistryObject<Item> BATTERY_RED_CELL_24 = ITEMS.register("battery_red_cell_24",
            () -> new ItemBattery(360_000, 48_000, 48_000));
    public static final RegistryObject<Item> BATTERY_LITHIUM = ITEMS.register("battery_lithium",
            () -> new ItemBattery(250_000, 40_000, 40_000));
    public static final RegistryObject<Item> BATTERY_LITHIUM_CELL = ITEMS.register("battery_lithium_cell",
            () -> new ItemBattery(750_000, 40_000, 40_000));
    public static final RegistryObject<Item> BATTERY_LITHIUM_CELL_3 = ITEMS.register("battery_lithium_cell_3",
            () -> new ItemBattery(2_250_000, 120_000, 120_000));
    public static final RegistryObject<Item> BATTERY_LITHIUM_CELL_6 = ITEMS.register("battery_lithium_cell_6",
            () -> new ItemBattery(4_500_000, 240_000, 240_000));
    public static final RegistryObject<Item> BATTERY_SCHRABIDIUM_CELL = ITEMS.register("battery_schrabidium_cell",
            () -> new ItemBattery(3_000_000, 300_000, 300_000));
    public static final RegistryObject<Item> BATTERY_SCHRABIDIUM_CELL_2 = ITEMS.register("battery_schrabidium_cell_2",
            () -> new ItemBattery(6_000_000, 600_000, 600_000));
    public static final RegistryObject<Item> BATTERY_SCHRABIDIUM_CELL_4 = ITEMS.register("battery_schrabidium_cell_4",
            () -> new ItemBattery(12_000_000, 1_200_000, 1_200_000));
    public static final RegistryObject<Item> BATTERY_SU = ITEMS.register("battery_su",
            () -> new ItemBattery(100, 0, 2_000));
    public static final RegistryObject<Item> BATTERY_POTATO = ITEMS.register("battery_potato",
            () -> new ItemBattery(3_500, 0, 2_000));
    public static final RegistryObject<Item> BATTERY_POTATOS = ITEMS.register("battery_potatos",
            () -> new ItemBattery(5_000, 0, 2_000));
    public static final RegistryObject<Item> BATTERY_SU_L = ITEMS.register("battery_su_l",
            () -> new ItemBattery(3_500, 0, 2_000));
    public static final RegistryObject<Item> BATTERY_STEAM = ITEMS.register("battery_steam",
            () -> new ItemBattery(60_000, 60, 120_000));
    public static final RegistryObject<Item> BATTERY_STEAM_LARGE = ITEMS.register("battery_steam_large",
            () -> new ItemBattery(100_000, 100, 200_000));
    public static final RegistryObject<Item> BATTERY_TRIXITE = ITEMS.register("battery_trixite",
            () -> new ItemBattery(5_000_000, 800_000, 4_000_000));
    public static final RegistryObject<Item> BATTERY_SPARK = ITEMS.register("battery_spark",
            () -> new ItemBattery(100_000_000, 40_000_000, 40_000_000));
    public static final RegistryObject<Item> BATTERY_SPARK_CELL_6 = ITEMS.register("battery_spark_cell_6",
            () -> new ItemBattery(600_000_000, 40_000_000, 40_000_000));
    public static final RegistryObject<Item> BATTERY_SPARK_CELL_25 = ITEMS.register("battery_spark_cell_25",
            () -> new ItemBattery(2_500_000_000L, 40_000_000, 40_000_000));
    public static final RegistryObject<Item> BATTERY_SPARK_CELL_100 = ITEMS.register("battery_spark_cell_100",
            () -> new ItemBattery(10_000_000_000L, 100_000_000, 100_000_000));
    public static final RegistryObject<Item> BATTERY_SPARK_CELL_1000 = ITEMS.register("battery_spark_cell_1000",
            () -> new ItemBattery(100_000_000_000L, 1_000_000_000, 1_000_000_000));
    public static final RegistryObject<Item> BATTERY_SPARK_CELL_2500 = ITEMS.register("battery_spark_cell_2500",
            () -> new ItemBattery(250_000_000_000L, 10_000_000_000L, 10_000_000_000L));
    public static final RegistryObject<Item> BATTERY_SPARK_CELL_10000 = ITEMS.register("battery_spark_cell_10000",
            () -> new ItemBattery(1_000_000_000_000L, 100_000_000_000L, 100_000_000_000L));
    public static final RegistryObject<Item> BATTERY_SPARK_CELL_POWER = ITEMS.register("battery_spark_cell_power",
            () -> new ItemBattery(100_000_000_000_000L, 10_000_000_000_000L, 10_000_000_000_000L));
    // Генераторы-батарейки
    public static final RegistryObject<Item> BATTERY_CREATIVE = ITEMS.register("battery_creative",
            () -> new ItemBatteryGen(true));
    public static final RegistryObject<Item> BATTERY_SC_URANIUM = ITEMS.register("battery_sc_uranium",
            () -> new ItemBatteryGen(100));
    public static final RegistryObject<Item> BATTERY_SC_TECHNETIUM = ITEMS.register("battery_sc_technetium",
            () -> new ItemBatteryGen(500));
    public static final RegistryObject<Item> BATTERY_SC_PLUTONIUM = ITEMS.register("battery_sc_plutonium",
            () -> new ItemBatteryGen(2_000));
    public static final RegistryObject<Item> BATTERY_SC_POLONIUM = ITEMS.register("battery_sc_polonium",
            () -> new ItemBatteryGen(10_000));
    public static final RegistryObject<Item> BATTERY_SC_GOLD = ITEMS.register("battery_sc_gold",
            () -> new ItemBatteryGen(50_000));
    public static final RegistryObject<Item> BATTERY_SC_LEAD = ITEMS.register("battery_sc_lead",
            () -> new ItemBatteryGen(100_000));
    public static final RegistryObject<Item> BATTERY_SC_AMERICIUM = ITEMS.register("battery_sc_americium",
            () -> new ItemBatteryGen(200_000));
    public static final RegistryObject<Item> BATTERY_SC_BALEFIRE = ITEMS.register("battery_sc_balefire",
            () -> new ItemBatteryGen(500_000));
    public static final RegistryObject<Item> BATTERY_SC_SCHRABIDIUM = ITEMS.register("battery_sc_schrabidium",
            () -> new ItemBatteryGen(1_000_000));
    public static final RegistryObject<Item> BATTERY_SC_YHARONITE = ITEMS.register("battery_sc_yharonite",
            () -> new ItemBatteryGen(10_000_000));
    public static final RegistryObject<Item> BATTERY_SC_ELECTRONIUM = ITEMS.register("battery_sc_electronium",
            () -> new ItemBatteryGen(1_000_000_000_000L));
    // Электроды
    public static final RegistryObject<Item> ARC_ELECTRODE = ITEMS.register("arc_electrode",
            () -> new ItemElectrode(250));
    public static final RegistryObject<Item> ARC_ELECTRODE_DESH = ITEMS.register("arc_electrode_desh",
            () -> new ItemElectrode(0));
    public static final RegistryObject<Item> ARC_ELECTRODE_BURNT = ITEMS.register("arc_electrode_burnt",
            () -> new Item(new Item.Properties()));
    // хлам
    public static final RegistryObject<Item> GUN_SUPER_SHOTGUN = ITEMS.register("gun_super_shotgun",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GUN_KIT_1 = ITEMS.register("gun_kit_1",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GUN_KIT_2 = ITEMS.register("gun_kit_2",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GUN_MOIST_NUGGET = ITEMS.register("gun_moist_nugget",
            () -> new Item(new Item.Properties()));
    // боеприпасы
    public static final RegistryObject<Item> AMMO_4GAUGE = ITEMS.register("ammo_4gauge",
            () -> new AmmoItem(new Item.Properties(),
                    50.0f,                           // damage
                    AmmoType.GAUGE4,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_4GAUGE_BALEFIRE = ITEMS.register("ammo_4gauge_balefire",
            () -> new AmmoItem(new Item.Properties(),
                    100.0f,                           // damage
                    AmmoType.GAUGE4,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_4GAUGE_CANISTER = ITEMS.register("ammo_4gauge_canister",
            () -> new AmmoItem(new Item.Properties(),
                    100.0f,                           // damage
                    AmmoType.GAUGE4,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_4GAUGE_CLAW = ITEMS.register("ammo_4gauge_claw",
            () -> new AmmoItem(new Item.Properties(),
                    80.0f,                           // damage
                    AmmoType.GAUGE4,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_4GAUGE_EXPLOSIVE = ITEMS.register("ammo_4gauge_explosive",
            () -> new AmmoItem(new Item.Properties(),
                    50.0f,                           // damage
                    AmmoType.GAUGE4,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_4GAUGE_FLECHETTE = ITEMS.register("ammo_4gauge_flechette",
            () -> new AmmoItem(new Item.Properties(),
                    50.0f,                           // damage
                    AmmoType.GAUGE4,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_4GAUGE_FLECHETTE_PHOSPHORUS = ITEMS.register("ammo_4gauge_flechette_phosphorus",
            () -> new AmmoItem(new Item.Properties(),
                    80.0f,                           // damage
                    AmmoType.GAUGE4,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_4GAUGE_KAMPF = ITEMS.register("ammo_4gauge_kampf",
            () -> new AmmoItem(new Item.Properties(),
                    100.0f,                           // damage
                    AmmoType.GAUGE4,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_4GAUGE_SEMTEX= ITEMS.register("ammo_4gauge_semtex",
            () -> new AmmoItem(new Item.Properties(),
                    100.0f,                           // damage
                    AmmoType.GAUGE4,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_4GAUGE_SLEEK = ITEMS.register("ammo_4gauge_sleek",
            () -> new AmmoItem(new Item.Properties(),
                    100.0f,                           // damage
                    AmmoType.GAUGE4,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_4GAUGE_SLUG = ITEMS.register("ammo_4gauge_slug",
            () -> new AmmoItem(new Item.Properties(),
                    20.0f,                           // damage
                    AmmoType.GAUGE4,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_4GAUGE_VAMPIRE = ITEMS.register("ammo_4gauge_vampire",
            () -> new AmmoItem(new Item.Properties(),
                    100.0f,                           // damage
                    AmmoType.GAUGE4,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_4GAUGE_VOID = ITEMS.register("ammo_4gauge_void",
            () -> new AmmoItem(new Item.Properties(),
                    50.0f,                           // damage
                    AmmoType.GAUGE4,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_5MM = ITEMS.register("ammo_5mm",
            () -> new AmmoItem(new Item.Properties(),
                    4.0f,                           // damage
                    AmmoType.MM5,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_5MM_CHLOROPHYTE = ITEMS.register("ammo_5mm_chlorophyte",
            () -> new AmmoItem(new Item.Properties(),
                    6.0f,                           // damage
                    AmmoType.MM5,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_5MM_DU = ITEMS.register("ammo_5mm_du",
            () -> new AmmoItem(new Item.Properties(),
                    8.0f,                           // damage
                    AmmoType.MM5,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_5MM_EXPLOSIVE = ITEMS.register("ammo_5mm_explosive",
            () -> new AmmoItem(new Item.Properties(),
                    8.0f,                           // damage
                    AmmoType.MM5,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_5MM_STAR = ITEMS.register("ammo_5mm_star",
            () -> new AmmoItem(new Item.Properties(),
                    18.0f,                           // damage
                    AmmoType.MM5,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_9MM = ITEMS.register("ammo_9mm",
            () -> new AmmoItem(new Item.Properties(),
                    13.0f,                           // damage
                    AmmoType.MM9,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_9MM_AP = ITEMS.register("ammo_9mm_ap",
            () -> new AmmoItem(new Item.Properties(),
                    10.0f,                           // damage
                    AmmoType.MM9,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_9MM_CHLOROPHYTE = ITEMS.register("ammo_9mm_chlorophyte",
            () -> new AmmoItem(new Item.Properties(),
                    6.0f,                           // damage
                    AmmoType.MM9,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_9MM_DU = ITEMS.register("ammo_9mm_du",
            () -> new AmmoItem(new Item.Properties(),
                    17.0f,                           // damage
                    AmmoType.MM9,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_9MM_ROCKET = ITEMS.register("ammo_9mm_rocket",
            () -> new AmmoItem(new Item.Properties(),
                    65.0f,                           // damage
                    AmmoType.MM9,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_12GAUGE = ITEMS.register("ammo_12gauge",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.GAUGE12,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_12GAUGE_DU = ITEMS.register("ammo_12gauge_du",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.GAUGE12,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_12GAUGE_INCENDIARY = ITEMS.register("ammo_12gauge_incendiary",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.GAUGE12,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_12GAUGE_MARAUDER = ITEMS.register("ammo_12gauge_marauder",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.GAUGE12,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_12GAUGE_SHRAPNEL = ITEMS.register("ammo_12gauge_shrapnel",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.GAUGE12,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_12GAUGE_SLEEK = ITEMS.register("ammo_12gauge_sleek",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.GAUGE12,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_20GAUGE = ITEMS.register("ammo_20gauge",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.GAUGE20,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_20GAUGE_CAUSTIC = ITEMS.register("ammo_20gauge_caustic",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.GAUGE20,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_20GAUGE_EXPLOSIVE = ITEMS.register("ammo_20gauge_explosive",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.GAUGE20,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_20GAUGE_FLECHETTE = ITEMS.register("ammo_20gauge_flechette",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.GAUGE20,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_20GAUGE_INCENDIARY = ITEMS.register("ammo_20gauge_incendiary",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.GAUGE20,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_20GAUGE_SHOCK = ITEMS.register("ammo_20gauge_shock",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.GAUGE20,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_20GAUGE_SHRAPNEL = ITEMS.register("ammo_20gauge_shrapnel",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.GAUGE20,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_20GAUGE_SLEEK = ITEMS.register("ammo_20gauge_sleek",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.GAUGE20,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_20GAUGE_SLUG = ITEMS.register("ammo_20gauge_slug",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.GAUGE20,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_20GAUGE_WITHER = ITEMS.register("ammo_20gauge_wither",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.GAUGE20,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_22LR = ITEMS.register("ammo_22lr",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.LR22,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_22LR_AP = ITEMS.register("ammo_22lr_ap",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.LR22,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_22LR_CHLOROPHYTE = ITEMS.register("ammo_22lr_chlorophyte",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.LR22,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_44 = ITEMS.register("ammo_44",
            () -> new AmmoItem(new Item.Properties(),
                    6.0f,                           // damage
                    AmmoType.R44,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_44_AP = ITEMS.register("ammo_44_ap",
            () -> new AmmoItem(new Item.Properties(),
                    9.0f,                           // damage
                    AmmoType.R44,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_44_BJ = ITEMS.register("ammo_44_bj",
            () -> new AmmoItem(new Item.Properties(),
                    5.0f,                           // damage
                    AmmoType.R44,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_44_CHLOROPHYTE = ITEMS.register("ammo_44_chlorophyte",
            () -> new AmmoItem(new Item.Properties(),
                    9.5f,                           // damage
                    AmmoType.R44,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_44_DU = ITEMS.register("ammo_44_du",
            () -> new AmmoItem(new Item.Properties(),
                    10.5f,                           // damage
                    AmmoType.R44,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_44_PHOSPHORUS = ITEMS.register("ammo_44_phosphorus",
            () -> new AmmoItem(new Item.Properties(),
                    6.5f,                           // damage
                    AmmoType.R44,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_44_PIP = ITEMS.register("ammo_44_pip",
            () -> new AmmoItem(new Item.Properties(),
                    5.0f,                           // damage
                    AmmoType.R44,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_44_ROCKET = ITEMS.register("ammo_44_rocket",
            () -> new AmmoItem(new Item.Properties(),
                    150.0f,                           // damage
                    AmmoType.R44,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_44_SILVER = ITEMS.register("ammo_44_silver",
            () -> new AmmoItem(new Item.Properties(),
                    5.0f,                           // damage
                    AmmoType.R44,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_44_STAR = ITEMS.register("ammo_44_star",
            () -> new AmmoItem(new Item.Properties(),
                    20.0f,                           // damage
                    AmmoType.R44,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_50AE = ITEMS.register("ammo_50ae",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.AE50,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_50AE_AP = ITEMS.register("ammo_50ae_ap",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.AE50,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_50AE_CHLOROPHYTE = ITEMS.register("ammo_50ae_chlorophyte",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.AE50,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_50AE_DU = ITEMS.register("ammo_50ae_du",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.AE50,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_50AE_STAR = ITEMS.register("ammo_50ae_star",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.AE50,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_50BMG = ITEMS.register("ammo_50bmg",
            () -> new AmmoItem(new Item.Properties(),
                    16.3f,                           // damage
                    AmmoType.BMG50,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_50BMG_AP = ITEMS.register("ammo_50bmg_ap",
            () -> new AmmoItem(new Item.Properties(),
                    30.0f,                           // damage
                    AmmoType.BMG50,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_50BMG_CHLOROPHYTE = ITEMS.register("ammo_50bmg_chlorophyte",
            () -> new AmmoItem(new Item.Properties(),
                    25.5f,                           // damage
                    AmmoType.BMG50,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_50BMG_DU = ITEMS.register("ammo_50bmg_du",
            () -> new AmmoItem(new Item.Properties(),
                    45.0f,                           // damage
                    AmmoType.BMG50,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_50BMG_EXPLOSIVE = ITEMS.register("ammo_50bmg_explosive",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.BMG50,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_50BMG_FLECHETTE = ITEMS.register("ammo_50bmg_flechette",
            () -> new AmmoItem(new Item.Properties(),
                    20.0f,                           // damage
                    AmmoType.BMG50,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_50BMG_FLECHETTE_AM = ITEMS.register("ammo_50bmg_flechette_am",
            () -> new AmmoItem(new Item.Properties(),
                    57.0f,                           // damage
                    AmmoType.BMG50,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_50BMG_FLECHETTE_PO = ITEMS.register("ammo_50bmg_flechette_po",
            () -> new AmmoItem(new Item.Properties(),
                    32.0f,                           // damage
                    AmmoType.BMG50,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_50BMG_INCENDIARY = ITEMS.register("ammo_50bmg_incendiary",
            () -> new AmmoItem(new Item.Properties(),
                    18.0f,                           // damage
                    AmmoType.BMG50,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_50BMG_PHOSPHORUS = ITEMS.register("ammo_50bmg_phosphorus",
            () -> new AmmoItem(new Item.Properties(),
                    18.0f,                           // damage
                    AmmoType.BMG50,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_50BMG_SLEEK = ITEMS.register("ammo_50bmg_sleek",
            () -> new AmmoItem(new Item.Properties(),
                    53.0f,                           // damage
                    AmmoType.BMG50,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_50BMG_STAR = ITEMS.register("ammo_50bmg_star",
            () -> new AmmoItem(new Item.Properties(),
                    55.0f,                           // damage
                    AmmoType.BMG50,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_75BOLT = ITEMS.register("ammo_75bolt",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.BOLT75,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_75BOLT_HE = ITEMS.register("ammo_75bolt_he",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.BOLT75,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_75BOLT_INCENDIARY = ITEMS.register("ammo_75bolt_incendiary",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.BOLT75,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_357_DESH = ITEMS.register("ammo_357_desh",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.D357,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_556 = ITEMS.register("ammo_556",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.M556,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_556_AP = ITEMS.register("ammo_556_ap",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.M556,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_556_CHLOROPHYTE = ITEMS.register("ammo_556_chlorophyte",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.M556,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_556_DU = ITEMS.register("ammo_556_du",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.M556,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_556_FLECHETTE = ITEMS.register("ammo_556_flechette",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.M556,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_556_FLECHETTE_CHLOROPHYTE = ITEMS.register("ammo_556_flechette_chlorophyte",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.M556,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_556_FLECHETTE_DU = ITEMS.register("ammo_556_flechette_du",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.M556,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_556_FLECHETTE_INCENDIARY = ITEMS.register("ammo_556_flechette_incendiary",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.M556,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_556_FLECHETTE_PHOSPHORUS = ITEMS.register("ammo_556_flechette_phosphorus",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.M556,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_556_FLECHETTE_SLEEK = ITEMS.register("ammo_556_flechette_sleek",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.M556,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_556_K = ITEMS.register("ammo_556_k",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.M556,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_556_PHOSPHORUS = ITEMS.register("ammo_556_phosphorus",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.M556,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_556_SLEEK = ITEMS.register("ammo_556_sleek",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.M556,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_556_STAR = ITEMS.register("ammo_556_star",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.M556,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_556_TRACER = ITEMS.register("ammo_556_tracer",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.M556,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_CONTAINER = ITEMS.register("ammo_container",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_DART= ITEMS.register("ammo_dart",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_DGK = ITEMS.register("ammo_dgk",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_FOLLY = ITEMS.register("ammo_folly",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_FOLLY_DU = ITEMS.register("ammo_folly_du",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_FOLLY_NUCLEAR = ITEMS.register("ammo_folly_nuclear",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_FUEL = ITEMS.register("ammo_fuel",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_FUEL_GAS = ITEMS.register("ammo_fuel_gas",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_FUEL_NAPALM = ITEMS.register("ammo_fuel_napalm",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_FUEL_PHOSPHORUS = ITEMS.register("ammo_fuel_phosphorus",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_FUEL_VAPORIZER = ITEMS.register("ammo_fuel_vaporizer",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_GRENADE = ITEMS.register("ammo_grenade",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_GRENADE_CONCUSSION = ITEMS.register("ammo_grenade_concussion",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_GRENADE_FINNED = ITEMS.register("ammo_grenade_finned",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_GRENADE_HE = ITEMS.register("ammo_grenade_he",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_GRENADE_INCENDIARY = ITEMS.register("ammo_grenade_incendiary",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_GRENADE_KAMPF = ITEMS.register("ammo_grenade_kampf",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_GRENADE_NUCLEAR = ITEMS.register("ammo_grenade_nuclear",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_GRENADE_PHOSPHORUS = ITEMS.register("ammo_grenade_phosphorus",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_GRENADE_SLEEK = ITEMS.register("ammo_grenade_sleek",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_GRENADE_TOXIC = ITEMS.register("ammo_grenade_toxic",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_GRENADE_TRACER = ITEMS.register("ammo_grenade_tracer",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_MIRV = ITEMS.register("ammo_mirv",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_MIRV_HIGH = ITEMS.register("ammo_mirv_high",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_MIRV_LOW = ITEMS.register("ammo_mirv_low",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_MIRV_SAFE = ITEMS.register("ammo_mirv_safe",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_MIRV_SPECIAL = ITEMS.register("ammo_mirv_special",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_NUKE = ITEMS.register("ammo_nuke",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_NUKE_HIGH = ITEMS.register("ammo_nuke_high",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_NUKE_LOW = ITEMS.register("ammo_nuke_low",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_NUKE_PUMPKIN = ITEMS.register("ammo_nuke_pumpkin",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_NUKE_SAFE = ITEMS.register("ammo_nuke_safe",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_NUKE_TOTS = ITEMS.register("ammo_nuke_tots",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_ROCKET = ITEMS.register("ammo_rocket",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_ROCKET_CANISTER = ITEMS.register("ammo_rocket_canister",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_ROCKET_EMP = ITEMS.register("ammo_rocket_emp",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_ROCKET_GLARE = ITEMS.register("ammo_rocket_glare",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_ROCKET_HE = ITEMS.register("ammo_rocket_he",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_ROCKET_INCENDIARY = ITEMS.register("ammo_rocket_incendiary",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_ROCKET_NUCLEAR = ITEMS.register("ammo_rocket_nuclear",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_ROCKET_PHOSPHORUS = ITEMS.register("ammo_rocket_phosphorus",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_ROCKET_RPC = ITEMS.register("ammo_rocket_rpc",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_ROCKET_SHRAPNEL = ITEMS.register("ammo_rocket_shrapnel",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_ROCKET_SLEEK = ITEMS.register("ammo_rocket_sleek",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_ROCKET_TOXIC = ITEMS.register("ammo_rocket_toxic",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_SHELL = ITEMS.register("ammo_shell",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_SHELL_APFSDS_DU = ITEMS.register("ammo_shell_apfsds_du",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_SHELL_APFSDS_T = ITEMS.register("ammo_shell_apfsds_t",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_SHELL_EXPLOSIVE = ITEMS.register("ammo_shell_explosive",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> AMMO_SHELL_W9 = ITEMS.register("ammo_shell_w9",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> GUN_XVL1456_AMMO = ITEMS.register("gun_xvl1456_ammo",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> GUN_B92_AMMO = ITEMS.register("gun_b92_ammo",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> GUN_BF_AMMO = ITEMS.register("gun_bf_ammo",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> GUN_CRYOLATOR_AMMO = ITEMS.register("gun_cryolator_ammo",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> GUN_DASH_AMMO = ITEMS.register("gun_dash_ammo",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> GUN_DEFABRICATOR_AMMO = ITEMS.register("gun_defabricator_ammo",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> GUN_EMP_AMMO = ITEMS.register("gun_emp_ammo",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> GUN_EUTHANASIA_AMMO = ITEMS.register("gun_euthanasia_ammo",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> GUN_FATMAN_AMMO = ITEMS.register("gun_fatman_ammo",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> GUN_FLAMER_AMMO = ITEMS.register("gun_flamer_ammo",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> GUN_HP_AMMO = ITEMS.register("gun_hp_ammo",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> GUN_IMMOLATOR_AMMO = ITEMS.register("gun_immolator_ammo",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> GUN_JACK_AMMO = ITEMS.register("gun_jack_ammo",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> GUN_MIRV_AMMO = ITEMS.register("gun_mirv_ammo",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> GUN_MP_AMMO = ITEMS.register("gun_mp_ammo",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> GUN_OSIPR_AMMO = ITEMS.register("gun_osipr_ammo",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> GUN_OSIPR_AMMO2 = ITEMS.register("gun_osipr_ammo2",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> GUN_REVOLVER_AMMO = ITEMS.register("gun_revolver_ammo",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.BULLET,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> GUN_REVOLVER_CURSED_AMMO = ITEMS.register("gun_revolver_cursed_ammo",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.BULLET,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> GUN_REVOLVER_GOLD_AMMO = ITEMS.register("gun_revolver_gold_ammo",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.BULLET,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> GUN_REVOLVER_IRON_AMMO = ITEMS.register("gun_revolver_iron_ammo",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.BULLET,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> GUN_REVOLVER_LEAD_AMMO = ITEMS.register("gun_revolver_lead_ammo",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.BULLET,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> GUN_REVOLVER_NIGHTMARE2_AMMO = ITEMS.register("gun_revolver_nightmare2_ammo",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.BULLET,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> GUN_REVOLVER_NIGHTMARE_AMMO = ITEMS.register("gun_revolver_nightmare_ammo",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.BULLET,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> GUN_REVOLVER_SCHRABIDIUM_AMMO = ITEMS.register("gun_revolver_schrabidium_ammo",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.BULLET,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> GUN_SPARK_AMMO = ITEMS.register("gun_spark_ammo",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> GUN_STINGER_AMMO = ITEMS.register("gun_stinger_ammo",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> GUN_UBOINIK_AMMO = ITEMS.register("gun_uboinik_ammo",
            () -> new AmmoItem(new Item.Properties(),
                    25.0f,                           // damage
                    AmmoType.KINETIC,                // ammoType
                    AmmoEffect.NONE,                 // primaryEffect
                    AmmoEffect.NONE,                 // secondaryEffect
                    3.0f,                            // speed
                    2.5f,                            // inaccuracy
                    0xC0C0C0,                        // color
                    false                            // hasTracer
            ));
    public static final RegistryObject<Item> BULLET_ITEM = ITEMS.register("bullet",
            () -> new Item(new Item.Properties()));
    // оружие
    public static final RegistryObject<Item> GUN_AR15 = ITEMS.register("gun_ar15",
            () -> new GunItem(
                    new Item.Properties(),
                    "50bmg",   // тип патрона
                    50,      // магазин
                    40,      // время перезарядки (тики)
                    2,       // кулдаун выстрела
                    "ar15" // имя модели
            ));
    public static final RegistryObject<Item> GUN_HK69 = ITEMS.register("gun_hk69",
            () -> new GunItem(
                    new Item.Properties(),
                    "kinetic",   // тип патрона
                    30,      // магазин
                    60,      // время перезарядки (тики)
                    2,       // кулдаун выстрела
                    "hk69" // имя модели
            ));
    public static final RegistryObject<Item> GUN_SUPERSHOTGUN = ITEMS.register("gun_supershotgun",
            () -> new GunItem(
                    new Item.Properties(),
                    "556",   // тип патрона
                    30,      // магазин
                    60,      // время перезарядки (тики)
                    2,       // кулдаун выстрела
                    "supershotgun" // имя модели
            ));
    public static final RegistryObject<Item> GUN_THOMPSON = ITEMS.register("gun_thompson",
            () -> new GunItem(
                    new Item.Properties(),
                    "9mm",   // тип патрона
                    30,      // магазин
                    30,      // время перезарядки (тики)
                    1,       // кулдаун выстрела
                    "thompson" // имя модели
            ));
    public static final RegistryObject<Item> GUN_VORTEX = ITEMS.register("gun_vortex",
            () -> new GunItem(
                    new Item.Properties(),
                    "556",   // тип патрона
                    30,      // магазин
                    60,      // время перезарядки (тики)
                    2,       // кулдаун выстрела
                    "vortex" // имя модели
            ));
    public static final RegistryObject<Item> GUN_BRIMSTONE = ITEMS.register("gun_brimstone",
            () -> new GunItem(
                    new Item.Properties(),
                    "556",   // тип патрона
                    30,      // магазин
                    60,      // время перезарядки (тики)
                    2,       // кулдаун выстрела
                    "brimstone" // имя модели
            ));
    public static final RegistryObject<Item> GUN_BOLTER = ITEMS.register("gun_bolter",
            () -> new GunItem(
                    new Item.Properties(),
                    "556",   // тип патрона
                    30,      // магазин
                    60,      // время перезарядки (тики)
                    2,       // кулдаун выстрела
                    "bolter" // имя модели
            ));
    public static final RegistryObject<Item> GUN_FLAMER = ITEMS.register("gun_flamer",
            () -> new GunItem(
                    new Item.Properties(),
                    "556",   // тип патрона
                    30,      // магазин
                    60,      // время перезарядки (тики)
                    2,       // кулдаун выстрела
                    "flamer" // имя модели
            ));
    public static final RegistryObject<Item> GUN_FLECHETTE = ITEMS.register("gun_flechette",
            () -> new GunItem(
                    new Item.Properties(),
                    "556",   // тип патрона
                    30,      // магазин
                    60,      // время перезарядки (тики)
                    2,       // кулдаун выстрела
                    "flechette" // имя модели
            ));
    public static final RegistryObject<Item> GUN_DEAGLE = ITEMS.register("gun_deagle",
            () -> new GunItem(
                    new Item.Properties(),
                    "556",   // тип патрона
                    30,      // магазин
                    60,      // время перезарядки (тики)
                    2,       // кулдаун выстрела
                    "deagle" // имя модели
            ));
    public static final RegistryObject<Item> GUN_B92 = ITEMS.register("gun_b92",
            () -> new GunItem(
                    new Item.Properties(),
                    "556",   // тип патрона
                    30,      // магазин
                    60,      // время перезарядки (тики)
                    2,       // кулдаун выстрела
                    "b92" // имя модели
            ));
    public static final RegistryObject<Item> GUN_EGON = ITEMS.register("gun_egon",
            () -> new GunItem(
                    new Item.Properties(),
                    "556",   // тип патрона
                    30,      // магазин
                    60,      // время перезарядки (тики)
                    2,       // кулдаун выстрела
                    "egon" // имя модели
            ));
    public static final RegistryObject<Item> GUN_CC_PLASMA = ITEMS.register("gun_cc_plasma",
            () -> new GunItem(
                    new Item.Properties(),
                    "556",   // тип патрона
                    30,      // магазин
                    60,      // время перезарядки (тики)
                    2,       // кулдаун выстрела
                    "cc_plasma" // имя модели
            ));
    public static final RegistryObject<Item> GUN_REVOLVER = ITEMS.register("gun_revolver",
            () -> new GunItem(
                    new Item.Properties(),
                    "44",   // тип патрона
                    6,      // магазин
                    50,      // время перезарядки (тики)
                    2,       // кулдаун выстрела
                    "revolver" // имя модели
            ));
    public static final RegistryObject<Item> GUN_AVENGER = ITEMS.register("gun_avenger",
            () -> new GunItem(
                    new Item.Properties(),
                    "556",   // тип патрона
                    30,      // магазин
                    60,      // время перезарядки (тики)
                    2,       // кулдаун выстрела
                    "avenger" // имя модели
            ));
    public static final RegistryObject<Item> GUN_B93 = ITEMS.register("gun_b93",
            () -> new GunItem(
                    new Item.Properties(),
                    "556",   // тип патрона
                    30,      // магазин
                    60,      // время перезарядки (тики)
                    2,       // кулдаун выстрела
                    "b93" // имя модели
            ));
    public static final RegistryObject<Item> GUN_BF = ITEMS.register("gun_bf",
            () -> new GunItem(
                    new Item.Properties(),
                    "556",   // тип патрона
                    30,      // магазин
                    60,      // время перезарядки (тики)
                    2,       // кулдаун выстрела
                    "bf" // имя модели
            ));
    public static final RegistryObject<Item> GUN_BOLT_ACTION = ITEMS.register("gun_bolt_action",
            () -> new GunItem(
                    new Item.Properties(),
                    "556",   // тип патрона
                    30,      // магазин
                    60,      // время перезарядки (тики)
                    2,       // кулдаун выстрела
                    "bolt_action" // имя модели
            ));
    public static final RegistryObject<Item> GUN_BOLT_ACTION_GREEN = ITEMS.register("gun_bolt_action_green",
            () -> new GunItem(
                    new Item.Properties(),
                    "556",   // тип патрона
                    30,      // магазин
                    60,      // время перезарядки (тики)
                    2,       // кулдаун выстрела
                    "bolt_action_green" // имя модели
            ));
    public static final RegistryObject<Item> GUN_BOLT_ACTION_SATURNITE = ITEMS.register("gun_bolt_action_saturnite",
            () -> new GunItem(
                    new Item.Properties(),
                    "556",   // тип патрона
                    30,      // магазин
                    60,      // время перезарядки (тики)
                    2,       // кулдаун выстрела
                    "bolt_action_saturnite" // имя модели
            ));
    public static final RegistryObject<Item> GUN_CALAMITY = ITEMS.register("gun_calamity",
            () -> new GunItem(
                    new Item.Properties(),
                    "556",   // тип патрона
                    30,      // магазин
                    60,      // время перезарядки (тики)
                    2,       // кулдаун выстрела
                    "calamity" // имя модели
            ));
    public static final RegistryObject<Item> GUN_CALAMITY_DUAL = ITEMS.register("gun_calamity_dual",
            () -> new GunItem(
                    new Item.Properties(),
                    "556",   // тип патрона
                    30,      // магазин
                    60,      // время перезарядки (тики)
                    2,       // кулдаун выстрела
                    "calamity_dual" // имя модели
            ));
    public static final RegistryObject<Item> GUN_CRYOLATOR = ITEMS.register("gun_cryolator",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "cryolator" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_DAMPFMASCHINE = ITEMS.register("gun_dampfmaschine",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "dampfmaschine" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_DARTER = ITEMS.register("gun_darter",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "darter" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_DEFABRICATOR = ITEMS.register("gun_defabricator",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "defabricator" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_EMP = ITEMS.register("gun_emp",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "emp" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_EUTHANASIA = ITEMS.register("gun_euthanasia",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "euthanasia" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_FATMAN = ITEMS.register("gun_fatman",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "fatman" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_FOLLY = ITEMS.register("gun_folly",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "folly" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_HP = ITEMS.register("gun_hp",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "hp" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_IMMOLATOR = ITEMS.register("gun_immolator",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "immolator" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_JACK = ITEMS.register("gun_jack",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "jack" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_KARL = ITEMS.register("gun_karl",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "karl" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_KS23 = ITEMS.register("gun_ks23",
            () -> new GunItem(
                            new Item.Properties(),
                            "4gauge",   // тип патрона
                            4,      // магазин
                            35,      // время перезарядки (тики)
                            6,       // кулдаун выстрела
                            "ks23" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_LACUNAE = ITEMS.register("gun_lacunae",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "lacunae" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_LEVER_ACTION = ITEMS.register("gun_lever_action",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "lever_action" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_LEVER_ACTION_DARK = ITEMS.register("gun_lever_action_dark",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "lever_action_dark" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_LEVER_ACTION_SONATA = ITEMS.register("gun_lever_action_sonata",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "lever_action_sonata" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_MINIGUN = ITEMS.register("gun_minigun",
            () -> new GunItem(
                            new Item.Properties(),
                            "5mm",   // тип патрона
                            200,      // магазин
                            60,      // время перезарядки (тики)
                            1,       // кулдаун выстрела
                            "minigun" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_MIRV = ITEMS.register("gun_mirv",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "mirv" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_MP = ITEMS.register("gun_mp",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "mp" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_MP40 = ITEMS.register("gun_mp40",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "mp40" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_OSIPR = ITEMS.register("gun_osipr",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "osipr" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_PANZERSCHRECK = ITEMS.register("gun_panzerschreck",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "panzerschreck" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_PROTO = ITEMS.register("gun_proto",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "proto" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_QUADRO = ITEMS.register("gun_quadro",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "quadro" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_REVOLVER_BLACKJACK = ITEMS.register("gun_revolver_blackjack",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "revolver_blackjack" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_REVOLVER_CURSED = ITEMS.register("gun_revolver_cursed",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "revolver_cursed" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_REVOLVER_GOLD = ITEMS.register("gun_revolver_gold",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "revolver_gold" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_REVOLVER_INVERTED = ITEMS.register("gun_revolver_inverted",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "revolver_inverted" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_REVOLVER_IRON = ITEMS.register("gun_revolver_iron",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "revolver_iron" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_REVOLVER_LEAD = ITEMS.register("gun_revolver_lead",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "revolver_lead" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_REVOLVER_NIGHTMARE = ITEMS.register("gun_revolver_nightmare",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "revolver_nightmare" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_REVOLVER_NIGHTMARE2 = ITEMS.register("gun_revolver_nightmare2",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "revolver_nightmare2" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_REVOLVER_NOPIP = ITEMS.register("gun_revolver_nopip",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "revolver_nopip" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_REVOLVER_PIP = ITEMS.register("gun_revolver_pip",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "revolver_pip" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_REVOLVER_RED = ITEMS.register("gun_revolver_red",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "revolver_red" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_REVOLVER_SATURNITE = ITEMS.register("gun_revolver_saturnite",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "revolver_saturnite" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_REVOLVER_SCHRABIDIUM = ITEMS.register("gun_revolver_schrabidium",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "revolver_schrabidium" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_REVOLVER_SILVER = ITEMS.register("gun_revolver_silver",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "revolver_silver" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_RPG = ITEMS.register("gun_rpg",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "rpg" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_SAUER = ITEMS.register("gun_sauer",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "sauer" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_SKYSTINGER = ITEMS.register("gun_skystinger",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "skystinger" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_SPARK = ITEMS.register("gun_spark",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "spark" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_STINGER = ITEMS.register("gun_stinger",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "stinger" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_UBOINIK = ITEMS.register("gun_uboinik",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "uboinik" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_UZI = ITEMS.register("gun_uzi",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "uzi" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_UZI_SILENCER = ITEMS.register("gun_uzi_silencer",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "uzi_silencer" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_UZI_SATURNITE = ITEMS.register("gun_uzi_saturnite",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "uzi_saturnite" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_UZI_SATURNITE_SILENCER = ITEMS.register("gun_uzi_saturnite_silencer",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "uzi_saturnite_silencer" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_XVL1456 = ITEMS.register("gun_xvl1456",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "xvl1456" // имя модели
                    ));
    public static final RegistryObject<Item> GUN_ZOMG = ITEMS.register("gun_zomg",
            () -> new GunItem(
                            new Item.Properties(),
                            "556",   // тип патрона
                            30,      // магазин
                            60,      // время перезарядки (тики)
                            2,       // кулдаун выстрела
                            "zomg" // имя модели
                    ));
    // блоки
    public static final RegistryObject<Item> ASPHALT = ITEMS.register("asphalt",
            () -> new BlockItem(ModBlocks.ASPHALT.get(), new Item.Properties()));
    public static final RegistryObject<Item> ABSORBER = ITEMS.register("absorber",
            () -> new BlockItem(ModBlocks.ABSORBER.get(), new Item.Properties()));
    public static final RegistryObject<Item> ABSORBER_GREEN = ITEMS.register("absorber_green",
            () -> new BlockItem(ModBlocks.ABSORBER_GREEN.get(), new Item.Properties()));
    public static final RegistryObject<Item> ABSORBER_PINK = ITEMS.register("absorber_pink",
            () -> new BlockItem(ModBlocks.ABSORBER_PINK.get(), new Item.Properties()));
    public static final RegistryObject<Item> ABSORBER_RED = ITEMS.register("absorber_red",
            () -> new BlockItem(ModBlocks.ABSORBER_RED.get(), new Item.Properties()));
    public static final RegistryObject<Item> AMS_BASE = ITEMS.register("ams_base",
            () -> new BlockItem(ModBlocks.AMS_BASE.get(), new Item.Properties()));
    public static final RegistryObject<Item> AMS_LIMITER = ITEMS.register("ams_limiter",
            () -> new BlockItem(ModBlocks.AMS_LIMITER.get(), new Item.Properties()));
    public static final RegistryObject<Item> AMS_EMITTER = ITEMS.register("ams_emitter",
            () -> new BlockItem(ModBlocks.AMS_EMITTER.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_SCRAP = ITEMS.register("ancient_scrap",
            () -> new BlockItem(ModBlocks.ANCIENT_SCRAP.get(), new Item.Properties()));
    public static final RegistryObject<Item> ASH_DIGAMMA = ITEMS.register("ash_digamma",
            () -> new BlockItem(ModBlocks.ASH_DIGAMMA.get(), new Item.Properties()));
    public static final RegistryObject<Item> BALEONITITE_0 = ITEMS.register("baleonitite_0",
            () -> new BlockItem(ModBlocks.BALEONITITE_0.get(), new Item.Properties()));
    public static final RegistryObject<Item> BALEONITITE_1 = ITEMS.register("baleonitite_1",
            () -> new BlockItem(ModBlocks.BALEONITITE_1.get(), new Item.Properties()));
    public static final RegistryObject<Item> BALEONITITE_2 = ITEMS.register("baleonitite_2",
            () -> new BlockItem(ModBlocks.BALEONITITE_2.get(), new Item.Properties()));
    public static final RegistryObject<Item> BALEONITITE_3 = ITEMS.register("baleonitite_3",
            () -> new BlockItem(ModBlocks.BALEONITITE_3.get(), new Item.Properties()));
    public static final RegistryObject<Item> BALEONITITE_4 = ITEMS.register("baleonitite_4",
            () -> new BlockItem(ModBlocks.BALEONITITE_4.get(), new Item.Properties()));
    public static final RegistryObject<Item> BALEONITITE_CORE = ITEMS.register("baleonitite_core",
            () -> new BlockItem(ModBlocks.BALEONITITE_CORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BALEONITITE_SLAKED = ITEMS.register("baleonitite_slaked",
            () -> new BlockItem(ModBlocks.BALEONITITE_SLAKED.get(), new Item.Properties()));
    public static final RegistryObject<Item> BARRICADE = ITEMS.register("barricade",
            () -> new BlockItem(ModBlocks.BARRICADE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BASALT = ITEMS.register("basalt",
            () -> new BlockItem(ModBlocks.BASALT.get(), new Item.Properties()));
    public static final RegistryObject<Item> BASALT_ASBESTOS = ITEMS.register("basalt_asbestos",
            () -> new BlockItem(ModBlocks.BASALT_ASBESTOS.get(), new Item.Properties()));
    public static final RegistryObject<Item> BASALT_BRICK = ITEMS.register("basalt_brick",
            () -> new BlockItem(ModBlocks.BASALT_BRICK.get(), new Item.Properties()));
    public static final RegistryObject<Item> BASALT_FLUORITE = ITEMS.register("basalt_fluorite",
            () -> new BlockItem(ModBlocks.BASALT_FLUORITE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BASALT_GEM = ITEMS.register("basalt_gem",
            () -> new BlockItem(ModBlocks.BASALT_GEM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BASALT_POLISHED = ITEMS.register("basalt_polished",
            () -> new BlockItem(ModBlocks.BASALT_POLISHED.get(), new Item.Properties()));
    public static final RegistryObject<Item> BASALT_SMOOTH = ITEMS.register("basalt_smooth",
            () -> new BlockItem(ModBlocks.BASALT_SMOOTH.get(), new Item.Properties()));
    public static final RegistryObject<Item> BASALT_SULFUR = ITEMS.register("basalt_sulfur",
            () -> new BlockItem(ModBlocks.BASALT_SULFUR.get(), new Item.Properties()));
    public static final RegistryObject<Item> BASALT_TILES = ITEMS.register("basalt_tiles",
            () -> new BlockItem(ModBlocks.BASALT_TILES.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLAST_DOOR= ITEMS.register("blast_door",
            () -> new BlockItem(ModBlocks.BLAST_DOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_ACTINIUM= ITEMS.register("block_actinium",
            () -> new BlockItem(ModBlocks.BLOCK_ACTINIUM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_ADVANCED_ALLOY= ITEMS.register("block_advanced_alloy",
            () -> new BlockItem(ModBlocks.BLOCK_ADVANCED_ALLOY.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_ALUMINIUM= ITEMS.register("block_aluminium",
            () -> new BlockItem(ModBlocks.BLOCK_ALUMINIUM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_ASBESTOS= ITEMS.register("block_asbestos",
            () -> new BlockItem(ModBlocks.BLOCK_ASBESTOS.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_AU198= ITEMS.register("block_au198",
            () -> new BlockItem(ModBlocks.BLOCK_AU198.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_AUSTRALIUM= ITEMS.register("block_australium",
            () -> new BlockItem(ModBlocks.BLOCK_AUSTRALIUM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_BAKELITE= ITEMS.register("block_bakelite",
            () -> new BlockItem(ModBlocks.BLOCK_BAKELITE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_BERYLLIUM= ITEMS.register("block_beryllium",
            () -> new BlockItem(ModBlocks.BLOCK_BERYLLIUM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_BISMUTH= ITEMS.register("block_bismuth",
            () -> new BlockItem(ModBlocks.BLOCK_BISMUTH.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_BORON= ITEMS.register("block_boron",
            () -> new BlockItem(ModBlocks.BLOCK_BORON.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_CADMIUM= ITEMS.register("block_cadmium",
            () -> new BlockItem(ModBlocks.BLOCK_CADMIUM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_CAP_FRITZ= ITEMS.register("block_cap_fritz",
            () -> new BlockItem(ModBlocks.BLOCK_CAP_FRITZ.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_CAP_KORL= ITEMS.register("block_cap_korl",
            () -> new BlockItem(ModBlocks.BLOCK_CAP_KORL.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_CAP_NUKA= ITEMS.register("block_cap_nuka",
            () -> new BlockItem(ModBlocks.BLOCK_CAP_NUKA.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_CAP_QUANTUM= ITEMS.register("block_cap_quantum",
            () -> new BlockItem(ModBlocks.BLOCK_CAP_QUANTUM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_CAP_RAD= ITEMS.register("block_cap_rad",
            () -> new BlockItem(ModBlocks.BLOCK_CAP_RAD.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_CAP_SPARK= ITEMS.register("block_cap_sparkle",
            () -> new BlockItem(ModBlocks.BLOCK_CAP_SPARK.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_CAP_STAR= ITEMS.register("block_cap_star",
            () -> new BlockItem(ModBlocks.BLOCK_CAP_STAR.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_CAP_SUNSET= ITEMS.register("block_cap_sunset",
            () -> new BlockItem(ModBlocks.BLOCK_CAP_SUNSET.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_COAL_INFERNAL= ITEMS.register("block_coal_infernal",
            () -> new BlockItem(ModBlocks.BLOCK_COAL_INFERNAL.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_COBALT = ITEMS.register("block_cobalt",
            () -> new BlockItem(ModBlocks.BLOCK_COBALT.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_COKE = ITEMS.register("block_coke",
            () -> new BlockItem(ModBlocks.BLOCK_COKE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_COLTAN = ITEMS.register("block_coltan",
            () -> new BlockItem(ModBlocks.BLOCK_COLTAN.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_COMBINE_STEEL = ITEMS.register("block_combine_steel",
            () -> new BlockItem(ModBlocks.BLOCK_COMBINE_STEEL.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_CORIUM = ITEMS.register("block_corium",
            () -> new BlockItem(ModBlocks.BLOCK_CORIUM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_CORIUM_COBBLE = ITEMS.register("block_corium_cobble",
            () -> new BlockItem(ModBlocks.BLOCK_CORIUM_COBBLE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_DAFFERGON = ITEMS.register("block_daffergon",
            () -> new BlockItem(ModBlocks.BLOCK_DAFFERGON.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_DESH = ITEMS.register("block_desh",
            () -> new BlockItem(ModBlocks.BLOCK_DESH.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_DINEUTRONIUM = ITEMS.register("block_dineutronium",
            () -> new BlockItem(ModBlocks.BLOCK_DINEUTRONIUM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_DURA_STEEL = ITEMS.register("block_dura_steel",
            () -> new BlockItem(ModBlocks.BLOCK_DURA_STEEL.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_ELECTRICAL_SCRAP = ITEMS.register("block_electrical_scrap",
            () -> new BlockItem(ModBlocks.BLOCK_ELECTRICAL_SCRAP.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_EUPHEMIUM = ITEMS.register("block_euphemium",
            () -> new BlockItem(ModBlocks.BLOCK_EUPHEMIUM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_EUPHEMIUM_CLUSTER = ITEMS.register("block_euphemium_cluster",
            () -> new BlockItem(ModBlocks.BLOCK_EUPHEMIUM_CLUSTER.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_FALLOUT = ITEMS.register("block_fallout",
            () -> new BlockItem(ModBlocks.BLOCK_FALLOUT.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_FIBERGLASS = ITEMS.register("block_fiberglass",
            () -> new BlockItem(ModBlocks.BLOCK_FIBERGLASS.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_FLUORITE = ITEMS.register("block_fluorite",
            () -> new BlockItem(ModBlocks.BLOCK_FLUORITE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_FOAM = ITEMS.register("block_foam",
            () -> new BlockItem(ModBlocks.BLOCK_FOAM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_GRAPHITE = ITEMS.register("block_graphite",
            () -> new BlockItem(ModBlocks.BLOCK_GRAPHITE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_GRAPHITE_DRILLED = ITEMS.register("block_graphite_drilled",
            () -> new BlockItem(ModBlocks.BLOCK_GRAPHITE_DRILLED.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_GRAPHITE_FUEL = ITEMS.register("block_graphite_fuel",
            () -> new BlockItem(ModBlocks.BLOCK_GRAPHITE_FUEL.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_GRAPHITE_PLUTONIUM = ITEMS.register("block_graphite_plutonium",
            () -> new BlockItem(ModBlocks.BLOCK_GRAPHITE_PLUTONIUM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_GRAPHITE_ROD = ITEMS.register("block_graphite_rod",
            () -> new BlockItem(ModBlocks.BLOCK_GRAPHITE_ROD.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_GRAPHITE_SOURCE = ITEMS.register("block_graphite_source",
            () -> new BlockItem(ModBlocks.BLOCK_GRAPHITE_SOURCE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_INSULATOR = ITEMS.register("block_insulator",
            () -> new BlockItem(ModBlocks.BLOCK_INSULATOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_LANTHANIUM = ITEMS.register("block_lanthanium",
            () -> new BlockItem(ModBlocks.BLOCK_LANTHANIUM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_LEAD = ITEMS.register("block_lead",
            () -> new BlockItem(ModBlocks.BLOCK_LEAD.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_LIGNITE = ITEMS.register("block_lignite",
            () -> new BlockItem(ModBlocks.BLOCK_LIGNITE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_LITHIUM = ITEMS.register("block_lithium",
            () -> new BlockItem(ModBlocks.BLOCK_LITHIUM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_MAGNETIZED_TUNGSTEN = ITEMS.register("block_magnetized_tungsten",
            () -> new BlockItem(ModBlocks.BLOCK_MAGNETIZED_TUNGSTEN.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_METEOR = ITEMS.register("block_meteor",
            () -> new BlockItem(ModBlocks.BLOCK_METEOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_METEOR_BROKEN = ITEMS.register("block_meteor_broken",
            () -> new BlockItem(ModBlocks.BLOCK_METEOR_BROKEN.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_METEOR_COBBLE = ITEMS.register("block_meteor_cobble",
            () -> new BlockItem(ModBlocks.BLOCK_METEOR_COBBLE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_METEOR_MOLTEN = ITEMS.register("block_meteor_molten",
            () -> new BlockItem(ModBlocks.BLOCK_METEOR_MOLTEN.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_METEOR_TREASURE = ITEMS.register("block_meteor_treasure",
            () -> new BlockItem(ModBlocks.BLOCK_METEOR_TREASURE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_MOX_FUEL = ITEMS.register("block_mox_fuel",
            () -> new BlockItem(ModBlocks.BLOCK_MOX_FUEL.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_NEPTUNIUM = ITEMS.register("block_neptunium",
            () -> new BlockItem(ModBlocks.BLOCK_NEPTUNIUM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_NIOBIUM = ITEMS.register("block_niobium",
            () -> new BlockItem(ModBlocks.BLOCK_NIOBIUM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_NITER = ITEMS.register("block_niter",
            () -> new BlockItem(ModBlocks.BLOCK_NITER.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_NITER_REINFORCED = ITEMS.register("block_niter_reinforced",
            () -> new BlockItem(ModBlocks.BLOCK_NITER_REINFORCED.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_PLUTONIUM = ITEMS.register("block_plutonium",
            () -> new BlockItem(ModBlocks.BLOCK_PLUTONIUM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_PLUTONIUM_FUEL = ITEMS.register("block_plutonium_fuel",
            () -> new BlockItem(ModBlocks.BLOCK_PLUTONIUM_FUEL.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_POLONIUM = ITEMS.register("block_polonium",
            () -> new BlockItem(ModBlocks.BLOCK_POLONIUM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_POLYMER = ITEMS.register("block_polymer",
            () -> new BlockItem(ModBlocks.BLOCK_POLYMER.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_PU238 = ITEMS.register("block_pu238",
            () -> new BlockItem(ModBlocks.BLOCK_PU238.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_PU239 = ITEMS.register("block_pu239",
            () -> new BlockItem(ModBlocks.BLOCK_PU239.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_PU240 = ITEMS.register("block_pu240",
            () -> new BlockItem(ModBlocks.BLOCK_PU240.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_PU_MIX = ITEMS.register("block_pu_mix",
            () -> new BlockItem(ModBlocks.BLOCK_PU_MIX.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_RA226 = ITEMS.register("block_ra226",
            () -> new BlockItem(ModBlocks.BLOCK_RA226.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_RADSPICE = ITEMS.register("block_radspice",
            () -> new BlockItem(ModBlocks.BLOCK_RADSPICE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_RED_COPPER = ITEMS.register("block_red_copper",
            () -> new BlockItem(ModBlocks.BLOCK_RED_COPPER.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_RED_PHOSPHORUS = ITEMS.register("block_red_phosphorus",
            () -> new BlockItem(ModBlocks.BLOCK_RED_PHOSPHORUS.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_REIIUM = ITEMS.register("block_reiium",
            () -> new BlockItem(ModBlocks.BLOCK_REIIUM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_RUBBER = ITEMS.register("block_rubber",
            () -> new BlockItem(ModBlocks.BLOCK_RUBBER.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_SATURNITE = ITEMS.register("block_saturnite",
            () -> new BlockItem(ModBlocks.BLOCK_SATURNITE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_SCHRABIDATE = ITEMS.register("block_schrabidate",
            () -> new BlockItem(ModBlocks.BLOCK_SCHRABIDATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_SCHRABIDIUM = ITEMS.register("block_schrabidium",
            () -> new BlockItem(ModBlocks.BLOCK_SCHRABIDIUM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_SCHRABIDIUM_CLUSTER = ITEMS.register("block_schrabidium_cluster",
            () -> new BlockItem(ModBlocks.BLOCK_SCHRABIDIUM_CLUSTER.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_SCHRABIDIUM_FUEL = ITEMS.register("block_schrabidium_fuel",
            () -> new BlockItem(ModBlocks.BLOCK_SCHRABIDIUM_FUEL.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_SCHRARANIUM = ITEMS.register("block_schraranium",
            () -> new BlockItem(ModBlocks.BLOCK_SCHRARANIUM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_SCRAP = ITEMS.register("block_scrap",
            () -> new BlockItem(ModBlocks.BLOCK_SCRAP.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_SEMTEX = ITEMS.register("block_semtex",
            () -> new BlockItem(ModBlocks.BLOCK_SEMTEX.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_SLAG = ITEMS.register("block_slag",
            () -> new BlockItem(ModBlocks.BLOCK_SLAG.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_SMORE = ITEMS.register("block_smore",
            () -> new BlockItem(ModBlocks.BLOCK_SMORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_SOLID_FUEL = ITEMS.register("block_solid_fuel",
            () -> new BlockItem(ModBlocks.BLOCK_SOLID_FUEL.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_SOLID_FUEL_BF = ITEMS.register("block_solid_fuel_bf",
            () -> new BlockItem(ModBlocks.BLOCK_SOLID_FUEL_BF.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_SOLID_FUEL_PRESTO = ITEMS.register("block_solid_fuel_presto",
            () -> new BlockItem(ModBlocks.BLOCK_SOLID_FUEL_PRESTO.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_SOLID_FUEL_PRESTO_BF = ITEMS.register("block_solid_fuel_presto_bf",
            () -> new BlockItem(ModBlocks.BLOCK_SOLID_FUEL_PRESTO_BF.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_SOLID_FUEL_PRESTO_TRIPLET = ITEMS.register("block_solid_fuel_presto_triplet",
            () -> new BlockItem(ModBlocks.BLOCK_SOLID_FUEL_PRESTO_TRIPLET.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_SOLID_FUEL_PRESTO_TRIPLET_BF = ITEMS.register("block_solid_fuel_presto_triplet_bf",
            () -> new BlockItem(ModBlocks.BLOCK_SOLID_FUEL_PRESTO_TRIPLET_BF.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_SOLINIUM = ITEMS.register("block_solinium",
            () -> new BlockItem(ModBlocks.BLOCK_SOLINIUM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_STARMETAL = ITEMS.register("block_starmetal",
            () -> new BlockItem(ModBlocks.BLOCK_STARMETAL.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_STEEL = ITEMS.register("block_steel",
            () -> new BlockItem(ModBlocks.BLOCK_STEEL.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_SULFUR = ITEMS.register("block_sulfur",
            () -> new BlockItem(ModBlocks.BLOCK_SULFUR.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_TANTALIUM = ITEMS.register("block_tantalium",
            () -> new BlockItem(ModBlocks.BLOCK_TANTALIUM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_THORIUM = ITEMS.register("block_thorium",
            () -> new BlockItem(ModBlocks.BLOCK_THORIUM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_THORIUM_FUEL = ITEMS.register("block_thorium_fuel",
            () -> new BlockItem(ModBlocks.BLOCK_THORIUM_FUEL.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_TITANIUM = ITEMS.register("block_titanium",
            () -> new BlockItem(ModBlocks.BLOCK_TITANIUM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_TRINITITE = ITEMS.register("block_trinitite",
            () -> new BlockItem(ModBlocks.BLOCK_TRINITITE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_TRITIUM = ITEMS.register("block_tritium",
            () -> new BlockItem(ModBlocks.BLOCK_TRITIUM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_TUNGSTEN = ITEMS.register("block_tungsten",
            () -> new BlockItem(ModBlocks.BLOCK_TUNGSTEN.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_U233 = ITEMS.register("block_u233",
            () -> new BlockItem(ModBlocks.BLOCK_U233.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_U235 = ITEMS.register("block_u235",
            () -> new BlockItem(ModBlocks.BLOCK_U235.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_U238 = ITEMS.register("block_u238",
            () -> new BlockItem(ModBlocks.BLOCK_U238.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_UNOBTAINIUM = ITEMS.register("block_unobtainium",
            () -> new BlockItem(ModBlocks.BLOCK_UNOBTAINIUM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_URANIUM = ITEMS.register("block_uranium",
            () -> new BlockItem(ModBlocks.BLOCK_URANIUM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_URANIUM_FUEL = ITEMS.register("block_uranium_fuel",
            () -> new BlockItem(ModBlocks.BLOCK_URANIUM_FUEL.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_VERTICIUM = ITEMS.register("block_verticium",
            () -> new BlockItem(ModBlocks.BLOCK_VERTICIUM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_WEIDANIUM = ITEMS.register("block_weidanium",
            () -> new BlockItem(ModBlocks.BLOCK_WEIDANIUM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_WHITE_PHOSPHORUS = ITEMS.register("block_white_phosphorus",
            () -> new BlockItem(ModBlocks.BLOCK_WHITE_PHOSPHORUS.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_YELLOWCAKE = ITEMS.register("block_yellowcake",
            () -> new BlockItem(ModBlocks.BLOCK_YELLOWCAKE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_ZIRCONIUM = ITEMS.register("block_zirconium",
            () -> new BlockItem(ModBlocks.BLOCK_ZIRCONIUM.get(), new Item.Properties()));
    // пластины
    public static final RegistryObject<Item> PLATE_POLYMER = ITEMS.register("plate_polymer",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_COPPER = ITEMS.register("plate_copper",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_ADVANCED_ALLOY = ITEMS.register("plate_advanced_alloy",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_ALUMINIUM = ITEMS.register("plate_aluminium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_CAST_ADVANCED_ALLOY = ITEMS.register("plate_cast_advancedalloy",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_CAST_ALUMINIUM = ITEMS.register("plate_cast_aluminium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_CAST_CDALLOY = ITEMS.register("plate_cast_cdalloy",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_CAST_CMBSTEEL = ITEMS.register("plate_cast_cmbsteel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_CAST_COPPER = ITEMS.register("plate_cast_copper",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_CAST_GOLD = ITEMS.register("plate_cast_gold",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_CAST_IRON = ITEMS.register("plate_cast_iron",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_CAST_LEAD = ITEMS.register("plate_cast_lead",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_CAST_OSMIRIDIUM = ITEMS.register("plate_cast_osmiridium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_CAST_SATURNITE = ITEMS.register("plate_cast_saturnite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_CAST_SCHRABIDIUM = ITEMS.register("plate_cast_schrabidium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_CAST_STEEL = ITEMS.register("plate_cast_steel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_CAST_TCALLOY = ITEMS.register("plate_cast_tcalloy",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_CAST_TITANIUM = ITEMS.register("plate_cast_titanium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_CAST_TUNGSTEN = ITEMS.register("plate_cast_tungsten",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_CAST_WORKERSALLOY = ITEMS.register("plate_cast_workersalloy",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_CAST_ZIRCONIUM = ITEMS.register("plate_cast_zirconium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_COMBINE_STEEL = ITEMS.register("plate_combine_steel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_DALEKANIUM = ITEMS.register("plate_dalekanium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_DESH = ITEMS.register("plate_desh",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_DINEUTRONIUM = ITEMS.register("plate_dineutronium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_EUPHEMIUM = ITEMS.register("plate_euphemium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_GOLD = ITEMS.register("plate_gold",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_IRON = ITEMS.register("plate_iron",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_KEVLAR = ITEMS.register("plate_kevlar",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_LEAD = ITEMS.register("plate_lead",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_MIXED = ITEMS.register("plate_mixed",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_PAA = ITEMS.register("plate_paa",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_SATURNITE = ITEMS.register("plate_saturnite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_SCHRABIDIUM = ITEMS.register("plate_schrabidium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_STEEL = ITEMS.register("plate_steel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_TITANIUM = ITEMS.register("plate_titanium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_WELDED_ALUMINIUM = ITEMS.register("plate_welded_aluminium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_WELDED_CDALLOY = ITEMS.register("plate_welded_cdalloy",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_WELDED_CMBSTEEL = ITEMS.register("plate_welded_cmbsteel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_WELDED_COPPER = ITEMS.register("plate_welded_copper",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_WELDED_IRON = ITEMS.register("plate_welded_iron",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_WELDED_OSMIRIDIUM = ITEMS.register("plate_welded_osmiridium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_WELDED_STEEL = ITEMS.register("plate_welded_steel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_WELDED_TCALLOY = ITEMS.register("plate_welded_tcalloy",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_WELDED_TITANIUM = ITEMS.register("plate_welded_titanium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_WELDED_TUNGSTEN = ITEMS.register("plate_welded_tungsten",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE_WELDED_ZIRCONIUM = ITEMS.register("plate_welded_zirconium",
            () -> new Item(new Item.Properties()));
    // катушки
    public static final RegistryObject<Item> COIL_COPPER = ITEMS.register("coil_copper",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COIL_COPPER_TORUS = ITEMS.register("coil_copper_torus",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COIL_ADVANCED_ALLOY = ITEMS.register("coil_advanced_alloy",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COIL_ADVANCED_TORUS = ITEMS.register("coil_advanced_torus",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COIL_GOLD = ITEMS.register("coil_gold",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COIL_GOLD_TORUS = ITEMS.register("coil_gold_torus",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COIL_TUNGSTEN = ITEMS.register("coil_tungsten",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COIL_MAGNETIZED_TUNGSTEN = ITEMS.register("coil_magnetized_tungsten",
            () -> new Item(new Item.Properties()));
    // провода
    public static final RegistryObject<Item> WIRE_ADVANCED_ALLOY = ITEMS.register("wire_advanced_alloy",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WIRE_ALUMINIUM = ITEMS.register("wire_aluminium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WIRE_CARBON = ITEMS.register("wire_carbon",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WIRE_COPPER = ITEMS.register("wire_copper",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WIRE_DENSE_ADVANCED_ALLOY = ITEMS.register("wire_dense_advancedalloy",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WIRE_DENSE_BSCCO= ITEMS.register("wire_dense_bscco",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WIRE_DENSE_DINEUTRONIUM = ITEMS.register("wire_dense_dineutronium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WIRE_DENSE_GOLD = ITEMS.register("wire_dense_gold",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WIRE_DENSE_MAGNETIZED_TUNGSTEN = ITEMS.register("wire_dense_magnetizedtungsten",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WIRE_DENSE_NEODYMIUM = ITEMS.register("wire_dense_neodymium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WIRE_DENSE_SCHRABIDATE = ITEMS.register("wire_dense_schrabidate",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WIRE_DENSE_SCHRABIDIUM = ITEMS.register("wire_dense_schrabidium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WIRE_DENSE_STARMETAL = ITEMS.register("wire_dense_starmetal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WIRE_DENSE_TUNGSTEN = ITEMS.register("wire_dense_tungsten",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WIRE_GOLD = ITEMS.register("wire_gold",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WIRE_LEAD = ITEMS.register("wire_lead",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WIRE_MAGNETIZED_TUNGSTEN = ITEMS.register("wire_magnetizedtungsten",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WIRE_MINGRADE = ITEMS.register("wire_mingrade",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WIRE_SCHRABIDIUM = ITEMS.register("wire_schrabidium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WIRE_STEEL = ITEMS.register("wire_steel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WIRE_TUNGSTEN = ITEMS.register("wire_tungsten",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WIRING_RED_COPPER = ITEMS.register("wiring_red_copper",
            () -> new Item(new Item.Properties()));
    // фрагменты
    public static final RegistryObject<Item> FRAGMENT_COBALT = ITEMS.register("fragment_cobalt",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FRAGMENT_COLTAN = ITEMS.register("fragment_coltan",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FRAGMENT_BORON = ITEMS.register("fragment_boron",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FRAGMENT_NEODYMIUM = ITEMS.register("fragment_neodymium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FRAGMENT_NIOBIUM = ITEMS.register("fragment_niobium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FRAGMENT_CERIUM = ITEMS.register("fragment_cerium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FRAGMENT_LANTHANIUM = ITEMS.register("fragment_lanthanium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FRAGMENT_ACTINIUM = ITEMS.register("fragment_actinium",
            () -> new Item(new Item.Properties()));
    // кирки
    public static final RegistryObject<Item> TITANIUM_PICKAXE = ITEMS.register("titanium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.TITANIUM, 3, 8, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_PICKAXE = ITEMS.register("steel_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STEEL, 3, 6, new Item.Properties()));
    public static final RegistryObject<Item> ALLOY_PICKAXE = ITEMS.register("alloy_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ADVANCED_ALLOY, 4, 6, new Item.Properties()));
    public static final RegistryObject<Item> DESH_PICKAXE = ITEMS.register("desh_pickaxe",
            () -> new UnbreakablePickaxeItem(ModToolTiers.DESH, 4, 6, new Item.Properties()));
    public static final RegistryObject<Item> COBALT_PICKAXE = ITEMS.register("cobalt_pickaxe",
            () -> new PickaxeItem(ModToolTiers.COBALT, 2, 8, new Item.Properties()));
    public static final RegistryObject<Item> COBALT_DECORATED_PICKAXE = ITEMS.register("cobalt_decorated_pickaxe",
            () -> new PickaxeItem(ModToolTiers.COBALT_DECORATED, 4, 9, new Item.Properties()));
    public static final RegistryObject<Item> STARMETAL_PICKAXE = ITEMS.register("starmetal_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STARMETAL, 6, 19, new Item.Properties()));
    public static final RegistryObject<Item> CMB_PICKAXE = ITEMS.register("cmb_pickaxe",
            () -> new PickaxeItem(ModToolTiers.CMB, 7, 14, new Item.Properties()));
    public static final RegistryObject<Item> BISMUTH_PICKAXE = ITEMS.register("bismuth_pickaxe",
            () -> new PickaxeItem(ModToolTiers.BISMUTH, 10, 49, new Item.Properties()));
    public static final RegistryObject<Item> VOLCANIC_PICKAXE = ITEMS.register("volcanic_pickaxe",
            () -> new PickaxeItem(ModToolTiers.VOLCANIC, 11, 34, new Item.Properties()));
    public static final RegistryObject<Item> CHLOROPHYTE_PICKAXE = ITEMS.register("chlorophyte_pickaxe",
            () -> new UnbreakablePickaxeItem(ModToolTiers.CHLOROPHYTE, 11, 75, new Item.Properties()));
    public static final RegistryObject<Item> MESE_PICKAXE = ITEMS.register("mese_pickaxe",
            () -> new UnbreakablePickaxeItem(ModToolTiers.MESE, -6, 99, new Item.Properties()));
    public static final RegistryObject<Item> SCHRABIDIUM_PICKAXE = ITEMS.register("schrabidium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.SCHRABIDIUM, 11, 49, new Item.Properties()));
    // топоры
    public static final RegistryObject<Item> TITANIUM_AXE = ITEMS.register("titanium_axe",
            () -> new AxeItem(ModToolTiers.TITANIUM, 4, 8, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_AXE = ITEMS.register("steel_axe",
            () -> new AxeItem(ModToolTiers.STEEL, 4, 6, new Item.Properties()));
    public static final RegistryObject<Item> ALLOY_AXE = ITEMS.register("alloy_axe",
            () -> new AxeItem(ModToolTiers.ADVANCED_ALLOY, 5, 6, new Item.Properties()));
    public static final RegistryObject<Item> DESH_AXE = ITEMS.register("desh_axe",
            () -> new UnbreakableAxeItem(ModToolTiers.DESH, 6, 6, new Item.Properties()));
    public static final RegistryObject<Item> COBALT_AXE = ITEMS.register("cobalt_axe",
            () -> new AxeItem(ModToolTiers.COBALT, 5, 8, new Item.Properties()));
    public static final RegistryObject<Item> COBALT_DECORATED_AXE = ITEMS.register("cobalt_decorated_axe",
            () -> new AxeItem(ModToolTiers.COBALT_DECORATED, 7, 9, new Item.Properties()));
    public static final RegistryObject<Item> STARMETAL_AXE = ITEMS.register("starmetal_axe",
            () -> new AxeItem(ModToolTiers.STARMETAL, 11, 19, new Item.Properties()));
    public static final RegistryObject<Item> CMB_AXE = ITEMS.register("cmb_axe",
            () -> new AxeItem(ModToolTiers.CMB, 9, 14, new Item.Properties()));
    public static final RegistryObject<Item> SCHRABIDIUM_AXE = ITEMS.register("schrabidium_axe",
            () -> new AxeItem(ModToolTiers.SCHRABIDIUM, 16, 49, new Item.Properties()));
    // мотыги
    public static final RegistryObject<Item> TITANIUM_HOE = ITEMS.register("titanium_hoe",
            () -> new HoeItem(ModToolTiers.TITANIUM, -1, 8, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_HOE = ITEMS.register("steel_hoe",
            () -> new HoeItem(ModToolTiers.STEEL, -1, 6, new Item.Properties()));
    public static final RegistryObject<Item> ALLOY_HOE = ITEMS.register("alloy_hoe",
            () -> new HoeItem(ModToolTiers.ADVANCED_ALLOY, 0, 6, new Item.Properties()));
    public static final RegistryObject<Item> DESH_HOE = ITEMS.register("desh_hoe",
            () -> new UnbreakableHoeItem(ModToolTiers.DESH, -1, 6, new Item.Properties()));
    public static final RegistryObject<Item> COBALT_HOE = ITEMS.register("cobalt_hoe",
            () -> new HoeItem(ModToolTiers.COBALT, -2, 8, new Item.Properties()));
    public static final RegistryObject<Item> COBALT_DECORATED_HOE = ITEMS.register("cobalt_decorated_hoe",
            () -> new HoeItem(ModToolTiers.COBALT_DECORATED, -2, 9, new Item.Properties()));
    public static final RegistryObject<Item> STARMETAL_HOE = ITEMS.register("starmetal_hoe",
            () -> new HoeItem(ModToolTiers.STARMETAL, -2, 19, new Item.Properties()));
    public static final RegistryObject<Item> CMB_HOE = ITEMS.register("cmb_hoe",
            () -> new HoeItem(ModToolTiers.CMB, -3, 14, new Item.Properties()));
    public static final RegistryObject<Item> SCHRABIDIUM_HOE = ITEMS.register("schrabidium_hoe",
            () -> new HoeItem(ModToolTiers.SCHRABIDIUM, -9, 49, new Item.Properties()));
    // лопаты
    public static final RegistryObject<Item> TITANIUM_SHOVEL = ITEMS.register("titanium_shovel",
            () -> new ShovelItem(ModToolTiers.TITANIUM, 2, 8, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_SHOVEL = ITEMS.register("steel_shovel",
            () -> new ShovelItem(ModToolTiers.STEEL, 2, 6, new Item.Properties()));
    public static final RegistryObject<Item> ALLOY_SHOVEL = ITEMS.register("alloy_shovel",
            () -> new ShovelItem(ModToolTiers.ADVANCED_ALLOY, 4, 6, new Item.Properties()));
    public static final RegistryObject<Item> DESH_SHOVEL = ITEMS.register("desh_shovel",
            () -> new UnbreakableShovelItem(ModToolTiers.DESH, 3, 6, new Item.Properties()));
    public static final RegistryObject<Item> COBALT_SHOVEL = ITEMS.register("cobalt_shovel",
            () -> new ShovelItem(ModToolTiers.COBALT, 1, 8, new Item.Properties()));
    public static final RegistryObject<Item> COBALT_DECORATED_SHOVEL = ITEMS.register("cobalt_decorated_shovel",
            () -> new ShovelItem(ModToolTiers.COBALT_DECORATED, 3, 9, new Item.Properties()));
    public static final RegistryObject<Item> STARMETAL_SHOVEL = ITEMS.register("starmetal_shovel",
            () -> new ShovelItem(ModToolTiers.STARMETAL, 5, 19, new Item.Properties()));
    public static final RegistryObject<Item> CMB_SHOVEL = ITEMS.register("cmb_shovel",
            () -> new ShovelItem(ModToolTiers.CMB, 5, 14, new Item.Properties()));
    public static final RegistryObject<Item> SCHRABIDIUM_SHOVEL = ITEMS.register("schrabidium_shovel",
            () -> new ShovelItem(ModToolTiers.SCHRABIDIUM, 6, 49, new Item.Properties()));
    // мечи
    public static final RegistryObject<Item> TITANIUM_SWORD = ITEMS.register("titanium_sword",
            () -> new SwordItem(ModToolTiers.TITANIUM, 5, 1, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_SWORD = ITEMS.register("steel_sword",
            () -> new SwordItem(ModToolTiers.STEEL, 4, 0, new Item.Properties()));
    public static final RegistryObject<Item> ALLOY_SWORD = ITEMS.register("alloy_sword",
            () -> new SwordItem(ModToolTiers.ADVANCED_ALLOY, 5, 1, new Item.Properties()));
    public static final RegistryObject<Item> DESH_SWORD = ITEMS.register("desh_sword",
            () -> new UnbreakableSwordItem(ModToolTiers.DESH, 4, 1, new Item.Properties()));
    public static final RegistryObject<Item> COBALT_SWORD = ITEMS.register("cobalt_sword",
            () -> new SwordItem(ModToolTiers.COBALT, 4, 1, new Item.Properties()));
    public static final RegistryObject<Item> COBALT_DECORATED_SWORD = ITEMS.register("cobalt_decorated_sword",
            () -> new SwordItem(ModToolTiers.COBALT_DECORATED, 5, 1, new Item.Properties()));
    public static final RegistryObject<Item> STARMETAL_SWORD = ITEMS.register("starmetal_sword",
            () -> new SwordItem(ModToolTiers.STARMETAL, 8, 1, new Item.Properties()));
    public static final RegistryObject<Item> CMB_SWORD = ITEMS.register("cmb_sword",
            () -> new SwordItem(ModToolTiers.CMB, 6, 1, new Item.Properties()));
    public static final RegistryObject<Item> SCHRABIDIUM_SWORD = ITEMS.register("schrabidium_sword",
            () -> new SwordItem(ModToolTiers.SCHRABIDIUM, 89, 1, new Item.Properties()));
    // armor steel
    public static final RegistryObject<Item> STEEL_HELMET = ITEMS.register("steel_helmet",
            () -> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_PLATE = ITEMS.register("steel_plate",
            () -> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_LEGS = ITEMS.register("steel_legs",
            () -> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_BOOTS = ITEMS.register("steel_boots",
            () -> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.BOOTS, new Item.Properties()));
    // armor titanium
    public static final RegistryObject<Item> TITANIUM_HELMET = ITEMS.register("titanium_helmet",
            () -> new ArmorItem(ModArmorMaterials.TITANIUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_PLATE = ITEMS.register("titanium_plate",
            () -> new ArmorItem(ModArmorMaterials.TITANIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_LEGS = ITEMS.register("titanium_legs",
            () -> new ArmorItem(ModArmorMaterials.TITANIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_BOOTS = ITEMS.register("titanium_boots",
            () -> new ArmorItem(ModArmorMaterials.TITANIUM, ArmorItem.Type.BOOTS, new Item.Properties()));
    // armor alloy
    public static final RegistryObject<Item> ALLOY_HELMET = ITEMS.register("alloy_helmet",
            () -> new UnbreakableArmorItem(ModArmorMaterials.ALLOY, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ALLOY_PLATE = ITEMS.register("alloy_plate",
            () -> new UnbreakableArmorItem(ModArmorMaterials.ALLOY, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ALLOY_LEGS = ITEMS.register("alloy_legs",
            () -> new UnbreakableArmorItem(ModArmorMaterials.ALLOY, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ALLOY_BOOTS = ITEMS.register("alloy_boots",
            () -> new UnbreakableArmorItem(ModArmorMaterials.ALLOY, ArmorItem.Type.BOOTS, new Item.Properties()));
    // armor cobalt
    public static final RegistryObject<Item> COBALT_HELMET = ITEMS.register("cobalt_helmet",
            () -> new ArmorItem(ModArmorMaterials.COBALT, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> COBALT_PLATE = ITEMS.register("cobalt_plate",
            () -> new ArmorItem(ModArmorMaterials.COBALT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> COBALT_LEGS = ITEMS.register("cobalt_legs",
            () -> new ArmorItem(ModArmorMaterials.COBALT, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> COBALT_BOOTS = ITEMS.register("cobalt_boots",
            () -> new ArmorItem(ModArmorMaterials.COBALT, ArmorItem.Type.BOOTS, new Item.Properties()));
    // armor starmetal
    public static final RegistryObject<Item> STARMETAL_HELMET = ITEMS.register("starmetal_helmet",
            () -> new ArmorItem(ModArmorMaterials.STARMETAL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> STARMETAL_PLATE = ITEMS.register("starmetal_plate",
            () -> new ArmorItem(ModArmorMaterials.STARMETAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> STARMETAL_LEGS = ITEMS.register("starmetal_legs",
            () -> new ArmorItem(ModArmorMaterials.STARMETAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> STARMETAL_BOOTS = ITEMS.register("starmetal_boots",
            () -> new ArmorItem(ModArmorMaterials.STARMETAL, ArmorItem.Type.BOOTS, new Item.Properties()));
    // armor CMB
    public static final RegistryObject<Item> CMB_HELMET = ITEMS.register("cmb_helmet",
            () -> new ArmorItem(ModArmorMaterials.CMB, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> CMB_PLATE = ITEMS.register("cmb_plate",
            () -> new ArmorItem(ModArmorMaterials.CMB, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> CMB_LEGS = ITEMS.register("cmb_legs",
            () -> new ArmorItem(ModArmorMaterials.CMB, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> CMB_BOOTS = ITEMS.register("cmb_boots",
            () -> new ArmorItem(ModArmorMaterials.CMB, ArmorItem.Type.BOOTS, new Item.Properties()));
    // armor schrabidium
    public static final RegistryObject<Item> SCHRABIDIUM_HELMET = ITEMS.register("schrabidium_helmet",
            () -> new ArmorItem(ModArmorMaterials.SCHRABIDIUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SCHRABIDIUM_PLATE = ITEMS.register("schrabidium_plate",
            () -> new ArmorItem(ModArmorMaterials.SCHRABIDIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SCHRABIDIUM_LEGS = ITEMS.register("schrabidium_legs",
            () -> new ArmorItem(ModArmorMaterials.SCHRABIDIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SCHRABIDIUM_BOOTS = ITEMS.register("schrabidium_boots",
            () -> new ArmorItem(ModArmorMaterials.SCHRABIDIUM, ArmorItem.Type.BOOTS, new Item.Properties()));
    // всякое
    public static final RegistryObject<Item> BALL_FIRECLAY = ITEMS.register("ball_fireclay",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BALL_RESIN = ITEMS.register("ball_resin",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CIRCUIT_CAPACITOR = ITEMS.register("circuit_capacitor",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SULFUR = ITEMS.register("sulfur",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LIGNITE = ITEMS.register("lignite",
            () -> new ItemLignit(new Item.Properties()));
    public static final RegistryObject<Item> RARE_EARTH_CHUNK = ITEMS.register("rare_earth_chunk",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COAL_INFERNAL = ITEMS.register("coal_infernal",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FLUORITE = ITEMS.register("fluorite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NITER = ITEMS.register("niter",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CINNEBAR = ITEMS.register("cinnebar",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}