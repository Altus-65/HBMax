package com.hbmax.recipe;

import com.hbmax.registry.ModItems;
import com.hbmax.registry.ModRecipes;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

public class RareEarthCrushingRecipe extends CustomRecipe {

    public RareEarthCrushingRecipe(ResourceLocation id, CraftingBookCategory category) {
        super(id, category);
    }

    @Override
    public boolean matches(CraftingContainer container, Level level) {
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

            } else if (isValidPickaxe(stack)) {
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

    public static boolean isValidPickaxe(ItemStack stack) {
        return stack.getItem() instanceof PickaxeItem pickaxe
                && pickaxe.getTier().getLevel() >= Tiers.IRON.getLevel();
    }

    @Override
    public ItemStack assemble(
            CraftingContainer container,
            RegistryAccess registryAccess) {

        return new ItemStack(ModItems.FRAGMENT_BORON.get());
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return new ItemStack(ModItems.FRAGMENT_BORON.get());
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(CraftingContainer container) {
        NonNullList<ItemStack> remaining =
                NonNullList.withSize(
                        container.getContainerSize(),
                        ItemStack.EMPTY
                );

        for (int i = 0; i < container.getContainerSize(); i++) {
            ItemStack stack = container.getItem(i);

            if (isValidPickaxe(stack)) {
                remaining.set(i, stack.copy());
            }
        }

        return remaining;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.RARE_EARTH_CRUSHING_SERIALIZER.get();
    }
}
