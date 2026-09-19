package com.hbmax.client.render;

import com.hbmax.item.GunItem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.model.GeoModel;

/**
 * GunGeoModel — модель оружия для GeckoLib 4.4.4.
 *
 * Структура файлов (пример для "vortex"):
 *   assets/hbmax/geo/item/vortex.geo.json      ← экспорт из Blockbench (GeckoLib Animated Model)
 *   assets/hbmax/textures/item/vortex.png      ← текстура
 *   assets/hbmax/animations/item/vortex.json   ← анимации (опционально)
 */
public class GunGeoModel extends GeoModel<GunItem> {

    private final String modelName;

    public GunGeoModel(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public ResourceLocation getModelResource(GunItem animatable) {
        return new ResourceLocation("hbmax", "geo/item/" + modelName + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GunItem animatable) {
        return new ResourceLocation("hbmax", "textures/item/" + modelName + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(GunItem animatable) {
        return new ResourceLocation("hbmax", "animations/item/" + modelName + ".animation.json");
    }
}