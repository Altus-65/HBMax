package com.hbmax.event;

import com.hbmax.item.GunItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class GunTickHandler {

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        Player player = event.player;

        tick(player.getMainHandItem(), player);
        tick(player.getOffhandItem(), player);
    }

    private void tick(ItemStack stack, Player player) {
        if (stack.getItem() instanceof GunItem gun) {
            gun.tick(stack, player);
        }
    }
}