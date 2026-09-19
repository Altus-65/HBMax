package com.hbmax.client.render;

import com.hbmax.block.BlockCable;
import com.hbmax.blockentity.BlockEntityCable;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;

public class CableRenderer implements BlockEntityRenderer<BlockEntityCable> {

    public CableRenderer(BlockEntityRendererProvider.Context ctx) {}

    @Override
    public void render(
            BlockEntityCable cable,
            float pt,
            PoseStack pose,
            MultiBufferSource buffer,
            int light,
            int overlay
    ) {
        // ВАЖНО: проверяем, что BlockEntity существует и имеет уровень
        if (cable == null || !cable.hasLevel()) {
            return;
        }

        BlockState state = cable.getBlockState();

        // ВАЖНО: проверяем, что блок существует и является нашим кабелем
        if (state == null || !(state.getBlock() instanceof BlockCable)) {
            return;
        }

        // Получаем спрайт с обработкой ошибок
        TextureAtlasSprite sprite;
        try {
            sprite = Minecraft.getInstance()
                    .getTextureAtlas(TextureAtlas.LOCATION_BLOCKS)
                    .apply(new ResourceLocation("hbmax:block/cable_neo"));
        } catch (Exception e) {
            return; // Если текстура не найдена - выходим
        }

        VertexConsumer consumer = buffer.getBuffer(RenderType.cutout());

        pose.pushPose();

        try {
            float p = 1f / 16f;
            float min = 5.5f * p;
            float max = 1f - min;

            // Рисуем центр
            drawCenter(pose, consumer, min, min, min, max, max, max, light, sprite);

            // Рисуем "руки" (соединения)
            if (state.getValue(BlockCable.NORTH)) {
                drawArm(pose, consumer, min, min, 0, max, max, min, light, sprite);
            }

            if (state.getValue(BlockCable.SOUTH)) {
                drawArm(pose, consumer, min, min, max, max, max, 1, light, sprite);
            }

            if (state.getValue(BlockCable.WEST)) {
                drawArm(pose, consumer, 0, min, min, min, max, max, light, sprite);
            }

            if (state.getValue(BlockCable.EAST)) {
                drawArm(pose, consumer, max, min, min, 1, max, max, light, sprite);
            }

            if (state.getValue(BlockCable.DOWN)) {
                drawArm(pose, consumer, min, 0, min, max, min, max, light, sprite);
            }

            if (state.getValue(BlockCable.UP)) {
                drawArm(pose, consumer, min, max, min, max, 1, max, light, sprite);
            }
        } catch (Exception e) {
            // Логируем ошибку, но не даём ей упасть
            System.err.println("Error rendering cable: " + e.getMessage());
            e.printStackTrace();
        } finally {
            pose.popPose();
        }
    }

    // =====================================================
    // CENTER UV
    // 4,11 -> 8,15
    // =====================================================

    private void drawCenter(
            PoseStack pose,
            VertexConsumer consumer,
            float x1,
            float y1,
            float z1,
            float x2,
            float y2,
            float z2,
            int light,
            TextureAtlasSprite sprite
    ) {

        drawBox(
                pose,
                consumer,
                x1, y1, z1,
                x2, y2, z2,

                sprite.getU(4),
                sprite.getV(11),

                sprite.getU(9),
                sprite.getV(16),

                light
        );
    }

    // =====================================================
    // ARM UV
    // 0,0 -> 4,10
    // =====================================================

    private void drawArm(
            PoseStack pose,
            VertexConsumer consumer,
            float x1,
            float y1,
            float z1,
            float x2,
            float y2,
            float z2,
            int light,
            TextureAtlasSprite sprite
    ) {

        drawBox(
                pose,
                consumer,
                x1, y1, z1,
                x2, y2, z2,

                sprite.getU(0),
                sprite.getV(0),

                sprite.getU(5),
                sprite.getV(11),

                light
        );
    }

    // =====================================================
    // BOX
    // =====================================================

    private void drawBox(
            PoseStack pose,
            VertexConsumer consumer,

            float x1,
            float y1,
            float z1,

            float x2,
            float y2,
            float z2,

            float u1,
            float v1,

            float u2,
            float v2,

            int light
    ) {

        // NORTH (-Z)

        quad(
                pose,
                consumer,

                x2, y1, z1,
                x1, y1, z1,
                x1, y2, z1,
                x2, y2, z1,

                u1, v1, u2, v2,

                light,

                0, 0, -1
        );

        // SOUTH (+Z)

        quad(
                pose,
                consumer,

                x1, y1, z2,
                x2, y1, z2,
                x2, y2, z2,
                x1, y2, z2,

                u1, v1, u2, v2,

                light,

                0, 0, 1
        );

        // WEST (-X)

        quad(
                pose,
                consumer,

                x1, y1, z1,
                x1, y1, z2,
                x1, y2, z2,
                x1, y2, z1,

                u1, v1, u2, v2,

                light,

                -1, 0, 0
        );

        // EAST (+X)

        quad(
                pose,
                consumer,

                x2, y1, z2,
                x2, y1, z1,
                x2, y2, z1,
                x2, y2, z2,

                u1, v1, u2, v2,

                light,

                1, 0, 0
        );

        // DOWN (-Y)

        quad(
                pose,
                consumer,

                x1, y1, z1,
                x2, y1, z1,
                x2, y1, z2,
                x1, y1, z2,

                u1, v1, u2, v2,

                light,

                0, -1, 0
        );

        // UP (+Y)

        quad(
                pose,
                consumer,

                x1, y2, z2,
                x2, y2, z2,
                x2, y2, z1,
                x1, y2, z1,

                u1, v1, u2, v2,

                light,

                0, 1, 0
        );
    }

    // =====================================================
    // QUAD
    // =====================================================

    private void quad(
            PoseStack pose,
            VertexConsumer consumer,

            float x1, float y1, float z1,
            float x2, float y2, float z2,
            float x3, float y3, float z3,
            float x4, float y4, float z4,

            float u1,
            float v1,
            float u2,
            float v2,

            int light,

            float nx,
            float ny,
            float nz
    ) {

        vertex(pose, consumer, x1, y1, z1, u1, v1, light, nx, ny, nz);
        vertex(pose, consumer, x2, y2, z2, u2, v1, light, nx, ny, nz);
        vertex(pose, consumer, x3, y3, z3, u2, v2, light, nx, ny, nz);
        vertex(pose, consumer, x4, y4, z4, u1, v2, light, nx, ny, nz);
    }

    // =========================================================
// VERTEX
// =========================================================

    private void vertex(
            PoseStack pose,
            VertexConsumer consumer,
            float x,
            float y,
            float z,
            float u,
            float v,
            int light,
            float nx,
            float ny,
            float nz
    ) {

        consumer.vertex(pose.last().pose(), x, y, z)
                .color(255, 255, 255, 255)
                .uv(u, v)
                .overlayCoords(0)
                .uv2(light)
                .normal(nx, ny, nz)
                .endVertex();
    }
}