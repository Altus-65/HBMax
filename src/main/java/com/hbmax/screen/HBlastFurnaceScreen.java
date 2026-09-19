package com.hbmax.screen;

import com.hbmax.menu.HMenuBlastFurnace;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class HBlastFurnaceScreen extends AbstractContainerScreen<HMenuBlastFurnace> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation("hbmax", "textures/gui/guidifurnace.png");

    public HBlastFurnaceScreen(HMenuBlastFurnace menu, Inventory inventory, Component component) {
        super(menu, inventory, component);

        this.imageWidth = 176;
        this.imageHeight = 166;

        this.inventoryLabelY = this.imageHeight - 94;
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShaderTexture(0, TEXTURE);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        // Фон GUI
        graphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        // === ШКАЛА ТОПЛИВА ===
        int fuel = menu.getFuelAmount() / 100;
        int maxFuel = menu.getMaxFuel() / 100;
        if (maxFuel > 0 && fuel > 0) {
            int fuelHeight = (fuel * 53) / maxFuel;
            graphics.blit(TEXTURE, x + 43, y + 17 + (53 - fuelHeight), 200, 53 - fuelHeight, 17, fuelHeight);
        }

        // === ИНДИКАТОР РАБОТЫ (горит когда печь работает) ===
        int cookTime = menu.getCookTime();
        int cookTimeTotal = menu.getCookTimeTotal();
        if (cookTimeTotal > 0 && cookTime > 0) {
            // Индикатор работы (статический, просто показывает что печь работает)
            graphics.blit(TEXTURE, x + 63, y + 38, 176, 0, 13, 14);
        }

        // === ПРОГРЕСС ПЛАВКИ (заполняется) ===
        if (cookTimeTotal > 0 && cookTime > 0) {
            int progressWidth = (cookTime * 24) / cookTimeTotal;  // 24 = ширина прогресс-бара
            graphics.blit(TEXTURE, x + 100, y + 35, 176, 14, progressWidth, 17);
        }
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {

        renderBackground(graphics);

        super.render(graphics, mouseX, mouseY, partialTick);

        // TOOLTIP
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        int fuelX = x + 43;
        int fuelY = y + 17;

        if (mouseX >= fuelX && mouseX <= fuelX + 17
                && mouseY >= fuelY && mouseY <= fuelY + 53) {

            int fuel = menu.getFuelAmount();
            int maxFuel = menu.getMaxFuel();

            int percent = maxFuel > 0 ? (fuel * 100) / maxFuel : 0;

            graphics.renderTooltip(
                    this.font,
                    Component.literal(percent + "%"),
                    mouseX,
                    mouseY
            );
        }

        renderTooltip(graphics, mouseX, mouseY);
    }
}