package com.hbmax.client;

import com.hbmax.item.GunItem;
import com.hbmax.network.ModMessages;
import com.hbmax.network.ReloadPacket;
import com.hbmax.network.ShootPacket;
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
public class GunClientHandler {

    // ── Кейбинды ──────────────────────────────────────────────────────────

    public static final KeyMapping KEY_RELOAD = new KeyMapping(
            "key.hbmax.reload",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_R,
            "key.category.hbmax"
    );

    // Удерживать ЛКМ для автоматической стрельбы
    private static boolean wasMouseDown = false;
    private static int shootCooldown = 0;

    // ── Регистрация кейбиндов (MOD шина) ─────────────────────────────────

    @Mod.EventBusSubscriber(modid = "hbmax", value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegisterKeys {
        @SubscribeEvent
        public static void onRegisterKeys(RegisterKeyMappingsEvent event) {
            event.register(KEY_RELOAD);
        }
    }

    // ── Обработка клавиш ──────────────────────────────────────────────────

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null || mc.screen != null) return;

        // R — перезарядка
        if (KEY_RELOAD.consumeClick()) {
            ItemStack stack = player.getMainHandItem();
            if (stack.getItem() instanceof GunItem) {
                ModMessages.sendToServer(new ReloadPacket());
            }
        }
    }

    // ── Обработка мыши (стрельба по ЛКМ) ─────────────────────────────────

    @SubscribeEvent
    public static void onMouseButton(InputEvent.MouseButton.Pre event) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null || mc.screen != null) return;

        ItemStack stack = player.getMainHandItem();
        if (!(stack.getItem() instanceof GunItem gun)) return;

        // ЛКМ нажата
        boolean isLeftClick = event.getButton() == GLFW.GLFW_MOUSE_BUTTON_LEFT;
        boolean isPress = event.getAction() == GLFW.GLFW_PRESS
                || event.getAction() == GLFW.GLFW_REPEAT;

        if (isLeftClick && isPress) {
            // Отменяем стандартный удар кулаком
            event.setCanceled(true);

            if (shootCooldown <= 0) {
                // Отправляем текущий угол взгляда для точности
                ModMessages.sendToServer(new ShootPacket(
                        player.getYRot(),
                        player.getXRot()
                ));
                shootCooldown = gun.getShootCooldown();
            }
        }

        if (isLeftClick && event.getAction() == GLFW.GLFW_RELEASE) {
            wasMouseDown = false;
        }
    }

    // ── Тик кулдауна на клиенте ───────────────────────────────────────────

    @SubscribeEvent
    public static void onClientTick(net.minecraftforge.event.TickEvent.ClientTickEvent event) {
        if (event.phase != net.minecraftforge.event.TickEvent.Phase.END) return;
        if (shootCooldown > 0) shootCooldown--;
    }
}
