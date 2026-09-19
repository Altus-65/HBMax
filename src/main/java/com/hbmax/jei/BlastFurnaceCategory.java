package com.hbmax.jei;

import com.hbmax.recipe.BlastFurnaceRecipe;
import com.hbmax.registry.ModBlocks;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class BlastFurnaceCategory implements IRecipeCategory<BlastFurnaceRecipe> {
    // Ванильная текстура печи — используем только для стрелки прогресса
    private static final ResourceLocation VANILLA_FURNACE_TEXTURE =
            new ResourceLocation("minecraft", "textures/gui/container/furnace.png");

    public static final RecipeType<BlastFurnaceRecipe> TYPE =
            RecipeType.create("hbmax", "blast_furnace", BlastFurnaceRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;
    private final IDrawableAnimated arrow;

    public BlastFurnaceCategory(IGuiHelper helper) {
        // Пустой фон нужного размера — без своей текстуры
        this.background = helper.createBlankDrawable(150, 60);

        this.icon = helper.createDrawableItemStack(new ItemStack(ModBlocks.BLAST_FURNACE_BLOCK.get()));

        // Стоковая стрелка прогресса из ванильной печи (24x17, растёт слева направо)
        IDrawableStatic arrowStatic = helper.createDrawable(VANILLA_FURNACE_TEXTURE, 176, 14, 24, 17);
        this.arrow = helper.createAnimatedDrawable(arrowStatic, 100, IDrawableAnimated.StartDirection.LEFT, false);
    }

    @Override
    public RecipeType<BlastFurnaceRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.hbmax.blast_furnace");
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
    public void setRecipe(IRecipeLayoutBuilder builder, BlastFurnaceRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 10, 5)
                .addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.INPUT, 10, 35)
                .addIngredients(recipe.getIngredients().get(1));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 110, 20)
                .addItemStack(recipe.getResultItem(null));
    }

    @Override
    public void draw(BlastFurnaceRecipe recipe, IRecipeSlotsView slotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        arrow.draw(guiGraphics, 60, 20);
    }
}
