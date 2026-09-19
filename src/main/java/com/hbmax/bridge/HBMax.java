package com.hbmax.bridge;

import com.hbmax.event.GunTickHandler;
import com.hbmax.network.ModMessages;
import com.hbmax.registry.*;
import com.hbmax.registry.ModRecipes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("hbmax")
public class HBMax {

    public HBMax() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.register(bus);
        ModItems.register(bus);
        ModTabs.register(bus);
        ModBlockEntities.register(bus);
        ModMenuTypes.register(bus);
        ModRecipes.register(bus);
        ModMessages.register();
        ModEntities.ENTITY_TYPES.register(bus);  // регистрация сущностей

        bus.addListener(this::onCommonSetup);

        MinecraftForge.EVENT_BUS.register(new GunTickHandler());
    }

    private void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModMessages.register();
        });
    }
}

