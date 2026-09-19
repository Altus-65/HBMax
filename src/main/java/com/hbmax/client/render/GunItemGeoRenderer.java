package com.hbmax.client.render;

import com.hbmax.item.GunItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class GunItemGeoRenderer extends GeoItemRenderer<GunItem> {

    public GunItemGeoRenderer(GunItem gunItem) {
        super(new GunGeoModel(gunItem.getModelName()));
    }
}