package com.hbmax.recipe;

import com.hbmax.registry.ModRecipes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import java.util.HashMap;
import java.util.Map;

public class BlastFurnaceRecipeManager {
    private static final Map<Item, Integer> FUEL_HEAT = new HashMap<>();

    static {
        // ДЕФОЛТНОЕ ТОПЛИВО
        addFuel(Items.COAL, 400);
        addFuel(Items.CHARCOAL, 300);
        addFuel(Items.LAVA_BUCKET, 2000);
        addFuel(net.minecraft.world.level.block.Blocks.COAL_BLOCK.asItem(), 1600);
    }

    public static void addFuel(Item item, int heat) {
        if (heat < 1) heat = 1;
        if (heat > 12800) heat = 12800;
        FUEL_HEAT.put(item, heat);
    }

    public static void removeFuel(Item item) {
        FUEL_HEAT.remove(item);
    }

    public static int getFuelHeat(ItemStack stack) {
        if (stack.isEmpty()) return 0;
        return FUEL_HEAT.getOrDefault(stack.getItem(), 0);
    }

    public static BlastFurnaceRecipe getRecipe(Level level, ItemStack input1, ItemStack input2) {
        if (level == null) return null;

        // ✅ ПРОВЕРКА: если рецепты еще не загружены, возвращаем null
        var recipeType = ModRecipes.BLAST_FURNACE_TYPE.get();
        if (recipeType == null) {
            return null;
        }

        BlastFurnaceContainer container = new BlastFurnaceContainer() {
            private final ItemStack[] items = {input1, input2, ItemStack.EMPTY, ItemStack.EMPTY};

            @Override
            public ItemStack getItem(int slot) {
                return slot < items.length ? items[slot] : ItemStack.EMPTY;
            }

            @Override
            public int getContainerSize() {
                return 2;
            }

            @Override
            public boolean isEmpty() {
                return input1.isEmpty() && input2.isEmpty();
            }

            @Override
            public void setItem(int slot, ItemStack stack) {}

            @Override
            public ItemStack removeItem(int slot, int amount) {
                return ItemStack.EMPTY;
            }

            @Override
            public ItemStack removeItemNoUpdate(int slot) {
                return ItemStack.EMPTY;
            }

            @Override
            public void setChanged() {}

            @Override
            public boolean stillValid(net.minecraft.world.entity.player.Player player) {
                return true;
            }

            @Override
            public void clearContent() {}
        };

        var recipes = level.getRecipeManager().getAllRecipesFor(recipeType);
        if (recipes == null || recipes.isEmpty()) {
            return null;
        }

        return recipes.stream()
                .filter(recipe -> recipe.matches(container, level))
                .findFirst()
                .orElse(null);
    }
}