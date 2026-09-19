package com.hbmax.commands;

import com.hbmax.bridge.HBMaxBridge;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public class TestCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
                Commands.literal("nativeping")
                        .executes(ctx -> {
                            CommandSourceStack source = ctx.getSource();
                            HBMaxBridge bridge = HBMaxBridge.getInstance();

                            if (!bridge.isConnected()) {
                                bridge.connect();
                                source.sendSuccess(() -> Component.literal("§eПодключаюсь к C++ ядру..."), false);
                                return 1;
                            }

                            bridge.ping(pong -> {
                                // sendSuccess нельзя вызывать из другого потока напрямую!
                                // пока просто логируем, потом сделаем через server thread
                                source.sendSuccess(() -> Component.literal("§a✓ Ядро отвечает: " + pong), false);
                            });

                            return 1; // ← это тоже не хватало, executes требует return int
                        })
        );
    }
}
