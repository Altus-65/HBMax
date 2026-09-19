package com.hbmax.registry;

import com.hbmax.recipe.BlastFurnaceRecipe;
import com.hbmax.recipe.RareEarthCrushingRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    private static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, "hbmax");
    private static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, "hbmax");

    // ===== BLAST FURNACE =====
    public static final RegistryObject<RecipeSerializer<BlastFurnaceRecipe>> BLAST_FURNACE_SERIALIZER =
            SERIALIZERS.register("blast_furnace", BlastFurnaceRecipe.Serializer::new);

    public static final RegistryObject<RecipeType<BlastFurnaceRecipe>> BLAST_FURNACE_TYPE =
            TYPES.register("blast_furnace", () -> RecipeType.simple(new ResourceLocation("hbmax", "blast_furnace")));

    // ===== RARE EARTH CRUSHING =====
    public static final RegistryObject<RecipeSerializer<RareEarthCrushingRecipe>> RARE_EARTH_CRUSHING_SERIALIZER =
            SERIALIZERS.register("rare_earth_crushing",
                    () -> new SimpleCraftingRecipeSerializer<>(RareEarthCrushingRecipe::new));

    public static void register(IEventBus bus) {
        SERIALIZERS.register(bus);
        TYPES.register(bus);
    }
}