package com.hbmax.registry;

import com.hbmax.menu.HMenuBlastFurnace;
import com.hbmax.menu.MenuMachineArcFurnace;
import com.hbmax.menu.MenuElectricFurnace;
import com.hbmax.menu.MenuMachineBattery;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {

    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, "hbmax");

    public static final RegistryObject<MenuType<MenuElectricFurnace>> ELECTRIC_FURNACE =
            MENUS.register("electric_furnace",
                    () -> IForgeMenuType.create(MenuElectricFurnace::new));

    public static final RegistryObject<MenuType<MenuMachineArcFurnace>> MACHINE_ARC_FURNACE =
            MENUS.register("machine_arc_furnace", () -> IForgeMenuType.create(MenuMachineArcFurnace::new));

    public static final RegistryObject<MenuType<MenuMachineBattery>> MACHINE_BATTERY =
            MENUS.register("machine_battery",
                    () -> IForgeMenuType.create(MenuMachineBattery::new));
    public static final RegistryObject<MenuType<HMenuBlastFurnace>> BLAST_FURNACE_MENU =
            MENUS.register("blast_furnace",
                    () -> IForgeMenuType.create(HMenuBlastFurnace::new));

    public static void register(IEventBus bus) {
        MENUS.register(bus);
    }
}
