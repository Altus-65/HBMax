package com.hbmax.event;

import com.hbmax.recipe.RareEarthCrushingRecipe;
import com.hbmax.registry.ModItems;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "hbmax")
public class RareEarthCrushingEvents {

    @SubscribeEvent
    public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
        Player player = event.getEntity();
        Level level = player.level();

        if (level.isClientSide || !(player instanceof ServerPlayer serverPlayer)) {
            return;
        }

        Container container = event.getInventory();

        // Проверяем, что это именно наша комбинация:
        // 1 Rare Earth Chunk + 1 подходящая кирка
        boolean isOurRecipe = isRareEarthCrushingRecipe(container);

        if (!isOurRecipe) {
            return;
        }

        // Найти кирку в сетке
        ItemStack pickaxeStack = ItemStack.EMPTY;

        for (int i = 0; i < container.getContainerSize(); i++) {
            ItemStack stack = container.getItem(i);

            if (stack.getItem() instanceof PickaxeItem) {
                pickaxeStack = stack;
                break;
            }
        }

        // Гарантированный кобальт
        giveOrDrop(player, new ItemStack(ModItems.FRAGMENT_COBALT.get()));

        // Независимые шансы
        rollAndGive(player, ModItems.FRAGMENT_BORON.get(), 0.5f);
        rollAndGive(player, ModItems.FRAGMENT_COBALT.get(), 0.5f);
        rollAndGive(player, ModItems.FRAGMENT_NEODYMIUM.get(), 0.5f);
        rollAndGive(player, ModItems.FRAGMENT_NIOBIUM.get(), 0.5f);
        rollAndGive(player, ModItems.FRAGMENT_CERIUM.get(), 0.4f);
        rollAndGive(player, ModItems.FRAGMENT_LANTHANIUM.get(), 0.3f);
        rollAndGive(player, ModItems.FRAGMENT_ACTINIUM.get(), 0.3f);

        // Урон кирке
        if (!pickaxeStack.isEmpty()) {
            pickaxeStack.hurtAndBreak(
                    1,
                    serverPlayer,
                    p -> p.broadcastBreakEvent(EquipmentSlot.MAINHAND)
            );
        }
    }

    private static boolean isRareEarthCrushingRecipe(Container container) {
        boolean foundChunk = false;
        boolean foundPickaxe = false;

        for (int i = 0; i < container.getContainerSize(); i++) {
            ItemStack stack = container.getItem(i);

            if (stack.isEmpty()) {
                continue;
            }

            if (stack.is(ModItems.RARE_EARTH_CHUNK.get())) {
                if (foundChunk) {
                    return false;
                }

                foundChunk = true;

            } else if (RareEarthCrushingRecipe.isValidPickaxe(stack)) {
                if (foundPickaxe) {
                    return false;
                }

                foundPickaxe = true;

            } else {
                return false;
            }
        }

        return foundChunk && foundPickaxe;
    }

    private static void rollAndGive(Player player, Item item, float chance) {
        if (player.getRandom().nextFloat() < chance) {
            giveOrDrop(player, new ItemStack(item));
        }
    }

    private static void giveOrDrop(Player player, ItemStack stack) {
        if (!player.getInventory().add(stack)) {
            player.drop(stack, false);
        }
    }
}