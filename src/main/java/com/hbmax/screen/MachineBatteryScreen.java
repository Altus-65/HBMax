package com.hbmax.screen;

import com.hbmax.energy.BatteryMode;
import com.hbmax.energy.BatteryPriority;
import com.hbmax.menu.MenuMachineBattery;
import com.hbmax.network.BatteryModePacket;
import com.hbmax.network.BatteryPriorityPacket;
import com.hbmax.network.ModMessages;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.util.List;
import java.util.Optional;

public class MachineBatteryScreen extends AbstractContainerScreen<MenuMachineBattery> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation("hbmax", "textures/gui/storage/gui_battery.png");

    public MachineBatteryScreen(MenuMachineBattery menu, Inventory inv, Component title) {
        super(menu, inv, title);
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void renderBg(GuiGraphics g, float pt, int mx, int my) {
        // background
        g.blit(TEXTURE, leftPos, topPos, 0, 0, imageWidth, imageHeight);

        // ENERGY BAR
        int energyHeight = (int)(51f * menu.getEnergyPercent());
        g.blit(TEXTURE, leftPos + 71, topPos + 17 + (51 - energyHeight), 176, 51 - energyHeight, 33, energyHeight);

        // PRIORITY BUTTON
        BatteryPriority priority = menu.getPriority();
        int priorityY = switch (priority) {
            case LOW -> 52;
            case NORMAL -> 68;
            case HIGH -> 84;
        };
        g.blit(TEXTURE, leftPos + 152, topPos + 17, 194, priorityY, 16, 16);

        // REDSTONE MODE BUTTON
        BatteryMode rsMode = menu.getRedstoneMode();
        int rsModeY = switch (rsMode) {
            case INPUT -> 52;
            case NEUTRAL -> 70;
            case OUTPUT -> 88;
            case OFF -> 106;
        };
        g.blit(TEXTURE, leftPos + 151, topPos + 34, 176, rsModeY, 18, 18);

        // MAIN MODE BUTTON
        BatteryMode mode = menu.getMode();
        int modeY = switch (mode) {
            case INPUT -> 52;
            case NEUTRAL -> 70;
            case OUTPUT -> 88;
            case OFF -> 106;
        };
        g.blit(TEXTURE, leftPos + 7, topPos + 34, 176, modeY, 18, 18);
    }

    private String formatEnergy(long value) {
        if (value >= 1_000_000_000_000_000L)
            return String.format("%.2f PHE", value / 1_000_000_000_000_000.0);
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

    private String formatDeltaShort(long delta) {
        long absDelta = Math.abs(delta);
        String sign = delta > 0 ? "+" : "-";

        if (absDelta >= 1_000_000_000_000L)
            return String.format("%s%.1f THE/s", sign, absDelta / 1_000_000_000_000.0);
        if (absDelta >= 1_000_000_000L)
            return String.format("%s%.1f GHE/s", sign, absDelta / 1_000_000_000.0);
        if (absDelta >= 1_000_000L)
            return String.format("%s%.1f MHE/s", sign, absDelta / 1_000_000.0);
        if (absDelta >= 1_000L)
            return String.format("%s%.1f kHE/s", sign, absDelta / 1_000.0);
        return String.format("%s%d HE/s", sign, absDelta);
    }

    @Override
    public void render(GuiGraphics g, int mx, int my, float pt) {

        renderBackground(g);

        super.render(g, mx, my, pt);

        // Energy tooltip (только при наведении на шкалу)
        if (mx >= leftPos + 71 && mx <= leftPos + 104 &&
                my >= topPos + 17 && my <= topPos + 68) {

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

        // Priority tooltip
        if (mx >= leftPos + 152 && mx <= leftPos + 168 &&
                my >= topPos + 17 && my <= topPos + 33) {

            List<Component> tooltip =
                    switch (menu.getPriority()) {

                        case LOW -> List.of(
                                Component.literal("Приоритет зарядки: низкий"),
                                Component.literal(""),
                                Component.literal("Описание режима:"),
                                Component.literal("Наиболее используемый режим, когда энергия"),
                                Component.literal("должна пойти в батареи без влияния на"),
                                Component.literal("производительность механизмов")
                        );

                        case NORMAL -> List.of(
                                Component.literal("Приоритет зарядки: нормальный"),
                                Component.literal(""),
                                Component.literal("Описание режима:"),
                                Component.literal("Рекомендован для маленьких батареек"),
                                Component.literal("(т.е. приоритет не важен)")
                        );

                        case HIGH -> List.of(
                                Component.literal("Приоритет зарядки: высокий"),
                                Component.literal(""),
                                Component.literal("Описание режима:"),
                                Component.literal("В экстренном порядке заполняет батареи,"),
                                Component.literal("которые всегда должны быть заполнены")
                        );
                    };

            g.renderTooltip(
                    font,
                    tooltip,
                    Optional.empty(),
                    mx,
                    my
            );
        }

    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {

        BlockPos pos = menu.getBlockEntity().getBlockPos();

        // PRIORITY BUTTON
        if (mx >= leftPos + 152 && mx <= leftPos + 168 &&
                my >= topPos + 17 && my <= topPos + 33) {

            BatteryPriority next = menu.getPriority().next();

            ModMessages.sendToServer(
                    new BatteryPriorityPacket(
                            pos,
                            next.ordinal()
                    )
            );

            super.mouseClicked(mx, my, button);
            return true;
        }

        // REDSTONE MODE BUTTON
        if (mx >= leftPos + 151 && mx <= leftPos + 169 &&
                my >= topPos + 34 && my <= topPos + 52) {

            BatteryMode next = menu.getRedstoneMode().next();

            ModMessages.sendToServer(
                    new BatteryModePacket(
                            pos,
                            next.ordinal(),
                            true
                    )
            );

            super.mouseClicked(mx, my, button);
            return true;
        }

        // MAIN MODE BUTTON
        if (mx >= leftPos + 7 && mx <= leftPos + 25 &&
                my >= topPos + 34 && my <= topPos + 52) {

            BatteryMode next = menu.getMode().next();

            ModMessages.sendToServer(
                    new BatteryModePacket(
                            pos,
                            next.ordinal(),
                            false
                    )
            );

            super.mouseClicked(mx, my, button);
            return true;
        }

        return super.mouseClicked(mx, my, button);
    }

}

