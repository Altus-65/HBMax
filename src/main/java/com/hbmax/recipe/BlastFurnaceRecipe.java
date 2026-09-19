package com.hbmax.recipe;

import com.google.gson.JsonObject;
import com.hbmax.registry.ModRecipes;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class BlastFurnaceRecipe implements Recipe<BlastFurnaceContainer> {
    private final ResourceLocation id;
    private final Ingredient input1;
    private final Ingredient input2;
    private final ItemStack output;
    private final int requiredHeat;
    private final int processingTime;

    public BlastFurnaceRecipe(ResourceLocation id, Ingredient input1, Ingredient input2,
                              ItemStack output, int requiredHeat, int processingTime) {
        this.id = id;
        this.input1 = input1;
        this.input2 = input2;
        this.output = output;
        this.requiredHeat = requiredHeat;
        this.processingTime = processingTime;
    }

    @Override
    public boolean matches(BlastFurnaceContainer container, Level level) {
        return input1.test(container.getItem(0)) && input2.test(container.getItem(1));
    }

    @Override
    public ItemStack assemble(BlastFurnaceContainer container, RegistryAccess registryAccess) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return output;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(input1);
        list.add(input2);
        return list;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.BLAST_FURNACE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.BLAST_FURNACE_TYPE.get();
    }

    public int getRequiredHeat() { return requiredHeat; }
    public int getProcessingTime() { return processingTime; }

    public static class Serializer implements RecipeSerializer<BlastFurnaceRecipe> {
        @Override
        public BlastFurnaceRecipe fromJson(ResourceLocation id, JsonObject json) {
            Ingredient input1 = Ingredient.fromJson(json.get("input1"));
            Ingredient input2 = Ingredient.fromJson(json.get("input2"));
            ItemStack output = ShapedRecipe.itemStackFromJson(json.getAsJsonObject("output"));
            int requiredHeat = json.has("requiredHeat") ? json.get("requiredHeat").getAsInt() : 2000;
            int processingTime = json.has("processingTime") ? json.get("processingTime").getAsInt() : 200;
            return new BlastFurnaceRecipe(id, input1, input2, output, requiredHeat, processingTime);
        }

        @Override
        public @Nullable BlastFurnaceRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buffer) {
            Ingredient input1 = Ingredient.fromNetwork(buffer);
            Ingredient input2 = Ingredient.fromNetwork(buffer);
            ItemStack output = buffer.readItem();
            int requiredHeat = buffer.readInt();
            int processingTime = buffer.readInt();
            return new BlastFurnaceRecipe(id, input1, input2, output, requiredHeat, processingTime);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, BlastFurnaceRecipe recipe) {
            recipe.input1.toNetwork(buffer);
            recipe.input2.toNetwork(buffer);
            buffer.writeItem(recipe.output);
            buffer.writeInt(recipe.requiredHeat);
            buffer.writeInt(recipe.processingTime);
        }
    }
}