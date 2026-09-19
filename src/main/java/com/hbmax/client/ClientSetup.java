package com.hbmax.client;

import com.hbmax.client.render.CableRenderer;
import com.hbmax.registry.ModBlockEntities;
import com.hbmax.registry.ModEntities;
import com.hbmax.registry.ModMenuTypes;
import com.hbmax.screen.HBlastFurnaceScreen;
import com.hbmax.screen.ElectricFurnaceScreen;
import com.hbmax.screen.MachineArcFurnaceScreen;
import com.hbmax.screen.MachineBatteryScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(
        modid = "hbmax",
        bus = Mod.EventBusSubscriber.Bus.MOD,
        value = Dist.CLIENT
)
public class ClientSetup {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(ModMenuTypes.ELECTRIC_FURNACE.get(), ElectricFurnaceScreen::new);
            MenuScreens.register(ModMenuTypes.MACHINE_ARC_FURNACE.get(), MachineArcFurnaceScreen::new);
            MenuScreens.register(ModMenuTypes.MACHINE_BATTERY.get(), MachineBatteryScreen::new);
            try {
                MenuScreens.register(ModMenuTypes.BLAST_FURNACE_MENU.get(), HBlastFurnaceScreen::new);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @SubscribeEvent
    public static void registerModels(ModelEvent.RegisterAdditional event) {
        // Регистрация дополнительных моделей, если нужно
    }

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.CABLE.get(), CableRenderer::new);

        event.registerEntityRenderer(ModEntities.BULLET.get(),
                (context) -> new ThrownItemRenderer<>(context, 0.3F, true));
    }

    @SubscribeEvent
    public static void onRegisterReloadListeners(RegisterClientReloadListenersEvent event) {
        // Сброс кеша OBJ-моделей при F3+T

    }
}