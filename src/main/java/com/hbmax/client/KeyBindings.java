package com.hbmax.client;

import com.hbmax.item.GunItem;
import com.hbmax.network.ModMessages;
import com.hbmax.network.ReloadPacket;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = "hbmax", value = Dist.CLIENT)
public class KeyBindings {

    public static final String KEY_CATEGORY = "key.category.hbmax";
    public static final String KEY_RELOAD = "key.hbmax.reload";

    public static KeyMapping reloadKey = new KeyMapping(
            KEY_RELOAD,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_R,
            KEY_CATEGORY
    );

    @Mod.EventBusSubscriber(modid = "hbmax", value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Register {
        @SubscribeEvent
        public static void registerKeys(RegisterKeyMappingsEvent event) {
            event.register(reloadKey);
        }
    }

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        if (reloadKey.consumeClick()) {
            Minecraft mc = Minecraft.getInstance();
            Player player = mc.player;
            if (player != null) {
                ItemStack stack = player.getMainHandItem();
                if (stack.getItem() instanceof GunItem) {
                    ModMessages.sendToServer(new ReloadPacket());
                }
            }
        }
    }
}