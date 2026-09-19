package com.hbmax.jei;

import com.hbmax.registry.ModItems;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.helpers.IGuiHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import mezz.jei.api.recipe.IFocusGroup;

public class RareEarthCrushingCategory implements IRecipeCategory<RareEarthCrushingJeiRecipe> {

    public static final RecipeType<RareEarthCrushingJeiRecipe> TYPE =
            RecipeType.create(
                    "hbmax",
                    "rare_earth_crushing",
                    RareEarthCrushingJeiRecipe.class
            );

    private final IDrawable background;
    private final IDrawable icon;

    public RareEarthCrushingCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.createBlankDrawable(140, 80);

        this.icon = guiHelper.createDrawableItemStack(
                new ItemStack(ModItems.RARE_EARTH_CHUNK.get())
        );
    }

    @Override
    public RecipeType<RareEarthCrushingJeiRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("jei.hbmax.rare_earth_crushing");
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(
            IRecipeLayoutBuilder builder,
            RareEarthCrushingJeiRecipe recipe,
            IFocusGroup focuses) {

        builder.addSlot(RecipeIngredientRole.INPUT, 25, 25)
                .addItemStack(new ItemStack(ModItems.RARE_EARTH_CHUNK.get()));

        builder.addSlot(RecipeIngredientRole.INPUT, 55, 25)
                .addItemStack(recipe.getPickaxe());

        int x = 100;

        for (ItemStack output : recipe.getOutputs()) {
            builder.addSlot(RecipeIngredientRole.OUTPUT, x, 25)
                    .addItemStack(output);

            x += 18;
        }
    }
}
