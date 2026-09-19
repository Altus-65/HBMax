package com.hbmax.jei;

import com.hbmax.registry.ModBlocks;
import com.hbmax.registry.ModItems;
import com.hbmax.registry.ModRecipes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.List;

@JeiPlugin
public class HbmaxJeiPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation("hbmax", "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(
                new BlastFurnaceCategory(
                        registration.getJeiHelpers().getGuiHelper()
                ),
                new RareEarthCrushingCategory(
                        registration.getJeiHelpers().getGuiHelper()
                )

        );
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        var level = Minecraft.getInstance().level;
        if (level == null) return;

        List<com.hbmax.recipe.BlastFurnaceRecipe> blastRecipes =
                level.getRecipeManager()
                        .getAllRecipesFor(ModRecipes.BLAST_FURNACE_TYPE.get());

        registration.addRecipes(
                BlastFurnaceCategory.TYPE,
                blastRecipes
        );

        registration.addRecipes(
                RareEarthCrushingCategory.TYPE,
                List.of(new RareEarthCrushingJeiRecipe())
        );
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.BLAST_FURNACE_BLOCK.get()), BlastFurnaceCategory.TYPE);

        registration.addRecipeCatalyst(new ItemStack(ModBlocks.ELECTRIC_FURNACE.get()), RecipeTypes.SMELTING);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.MACHINE_ARC_FURNACE_OFF.get()), RecipeTypes.SMELTING);
    }
}