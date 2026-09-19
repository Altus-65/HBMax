package com.hbmax.screen;

import com.hbmax.menu.MenuElectricFurnace;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.util.List;
import java.util.Optional;

public class ElectricFurnaceScreen extends AbstractContainerScreen<MenuElectricFurnace> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation("hbmax", "textures/gui/guielectricfurnace.png");

    public ElectricFurnaceScreen(MenuElectricFurnace menu, Inventory inv, Component title) {
        super(menu, inv, title);
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        graphics.blit(TEXTURE, leftPos, topPos, 0, 0, imageWidth, imageHeight);

        int progress = (int) (24 * menu.getProgressPercent());
        graphics.blit(TEXTURE, leftPos + 79, topPos + 34, 176, 14, progress, 16);

        if (menu.getProgress() > 0) {
            graphics.blit(TEXTURE, leftPos + 55, topPos + 35, 176, 31, 17, 17);
        }

        int energyHeight = (int) (52 * menu.getEnergyPercent());
        graphics.blit(TEXTURE,
                leftPos + 20,
                topPos + 17 + (52 - energyHeight),
                200,
                52 - energyHeight,
                16,
                energyHeight
        );
    }

    @Override
    public void render(GuiGraphics g, int mx, int my, float pt) {

        renderBackground(g);

        super.render(g, mx, my, pt);

        // Energy tooltip (только при наведении на шкалу)
        if (mx >= leftPos + 20 && mx <= leftPos + 36 &&
                my >= topPos + 17 && my <= topPos + 69) {

            String energyText =
                    formatEnergy(menu.getEnergy()) +
                            " / " +
                            formatEnergy(menu.getMaxEnergy());

            String deltaText =
                    formatDelta(menu.getPowerDelta());

            g.renderTooltip(
                    font,
                    List.of(
                            Component.literal(energyText),
                            Component.literal(deltaText)
                    ),
                    Optional.empty(),
                    mx,
                    my
            );
        }

        renderTooltip(g, mx, my);
    }

    private boolean isMouseOverEnergy(int mouseX, int mouseY) {
        int x = leftPos + 20;
        int y = topPos + 17;
        int w = 16;
        int h = 52;
        return mouseX >= x && mouseX <= x + w && mouseY >= y && mouseY <= y + h;
    }

    private String formatEnergy(long value) {
        if (value >= 1_000_000_000_000L)
            return String.format("%.2f THE", value / 1_000_000_000_000.0);
        if (value >= 1_000_000_000L)
            return String.format("%.2f GHE", value / 1_000_000_000.0);
        if (value >= 1_000_000L)
            return String.format("%.2f MHE", value / 1_000_000.0);
        if (value >= 1_000L)
            return String.format("%.2f kHE", value / 1_000.0);
        return value + " HE";
    }

    private String formatDelta(long delta) {
        if (delta > 0) return "§a+" + formatEnergy(delta) + "/s";
        if (delta < 0) return "§c-" + formatEnergy(-delta) + "/s";
        return "§e0 HE/s";
    }
}
