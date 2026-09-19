package com.hbmax.jei;

import com.hbmax.registry.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;

import java.util.List;

public class RareEarthCrushingJeiRecipe {

    private final ItemStack pickaxe;
    private final List<ItemStack> outputs;

    public RareEarthCrushingJeiRecipe() {
        this.pickaxe = new ItemStack(
                net.minecraft.world.item.Items.IRON_PICKAXE
        );

        this.outputs = List.of(
                new ItemStack(ModItems.FRAGMENT_BORON.get()),
                new ItemStack(ModItems.FRAGMENT_COBALT.get()),
                new ItemStack(ModItems.FRAGMENT_NEODYMIUM.get()),
                new ItemStack(ModItems.FRAGMENT_NIOBIUM.get()),
                new ItemStack(ModItems.FRAGMENT_CERIUM.get()),
                new ItemStack(ModItems.FRAGMENT_LANTHANIUM.get()),
                new ItemStack(ModItems.FRAGMENT_ACTINIUM.get())
        );
    }

    public ItemStack getPickaxe() {
        return pickaxe;
    }

    public List<ItemStack> getOutputs() {
        return outputs;
    }
}
