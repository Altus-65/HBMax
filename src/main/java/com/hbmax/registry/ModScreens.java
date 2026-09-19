package com.hbmax.registry;

import com.hbmax.screen.HBlastFurnaceScreen;
import com.hbmax.screen.ElectricFurnaceScreen;
import com.hbmax.screen.MachineArcFurnaceScreen;
import com.hbmax.screen.MachineBatteryScreen;
import net.minecraft.client.gui.screens.MenuScreens;

public class ModScreens {

    public static void register() {
        MenuScreens.register(ModMenuTypes.ELECTRIC_FURNACE.get(),
                ElectricFurnaceScreen::new);

        MenuScreens.register(ModMenuTypes.MACHINE_ARC_FURNACE.get(),
                MachineArcFurnaceScreen::new);

        MenuScreens.register(ModMenuTypes.MACHINE_BATTERY.get(),
                MachineBatteryScreen::new);

        MenuScreens.register(ModMenuTypes.BLAST_FURNACE_MENU.get(),
                HBlastFurnaceScreen::new);
    }
}
