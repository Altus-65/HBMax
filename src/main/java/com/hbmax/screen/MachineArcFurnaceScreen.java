package com.hbmax.screen;

import com.hbmax.menu.MenuMachineArcFurnace;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.util.List;
import java.util.Optional;

public class MachineArcFurnaceScreen extends AbstractContainerScreen<MenuMachineArcFurnace> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation("hbmax", "textures/gui/gui_arc.png");

    public MachineArcFurnaceScreen(MenuMachineArcFurnace menu, Inventory inv, Component title) {
        super(menu, inv, title);
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void renderBg(GuiGraphics g, float pt, int mx, int my) {
        // Фон
        g.blit(TEXTURE, leftPos, topPos, 0, 0, imageWidth, imageHeight);

        // Шкала энергии (U: 176-192, V: 33-66, размер 16x34)
        int energyHeight = (int) (34 * menu.getEnergyPercent());
        g.blit(TEXTURE,
                leftPos + 8,                    // X на экране
                topPos + 51 - energyHeight,     // Y на экране (растёт вверх)
                176,                            // U (начало шкалы на текстуре)
                33 + (34 - energyHeight),       // V (смещение по текстуре)
                16,                             // ширина
                energyHeight                    // высота
        );

        // Индикатор работы
        if (menu.getProgress() > 0) {
            g.blit(TEXTURE, leftPos + 56, topPos + 36, 177, 1, 15, 13);
        }

        // Стрелка прогресса плавки
        if (menu.getProgress() > 0 && menu.getBlockEntity().hasElectrodes()) {
            int progress = (int) (24 * menu.getProgressPercent());
            g.blit(TEXTURE, leftPos + 79, topPos + 35, 176, 16, progress, 17);
        }
    }

    @Override
    public void render(GuiGraphics g, int mx, int my, float pt) {

        renderBackground(g);

        super.render(g, mx, my, pt);

        // Energy tooltip (только при наведении на шкалу)
        if (mx >= leftPos + 8 && mx <= leftPos + 24 &&
                my >= topPos + 17 && my <= topPos + 51) {

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

    private boolean isMouseOverEnergy(int mx, int my) {
        int x = leftPos + 8;
        int y = topPos + 17;
        int w = 16;
        int h = 34;
        return mx >= x && mx <= x + w && my >= y && my <= y + h;
    }

    private String formatEnergy(long value) {
        if (value >= 1_000_000_000L) return String.format("%.2f GHE", value / 1_000_000_000.0);
        if (value >= 1_000_000L) return String.format("%.2f MHE", value / 1_000_000.0);
        if (value >= 1_000L) return String.format("%.2f kHE", value / 1_000.0);
        return value + " HE";
    }

    private String formatDelta(long delta) {
        if (delta > 0) return "§a+" + formatEnergy(delta) + "/s";
        if (delta < 0) return "§c-" + formatEnergy(-delta) + "/s";
        return "§e0 HE/s";
    }
}