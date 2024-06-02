package com.desx.rebornworld.entity.client;

import com.desx.rebornworld.entity.ocean.Bubble;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.desx.rebornworld.RebornWorld.MODID;

public class turtleRenderer extends MobRenderer<Bubble, turtle<Bubble>> {
    public turtleRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new turtle<>(pContext.bakeLayer(OceanModelLayer.TURTLE_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(Bubble pEntity) {
        return new ResourceLocation(MODID, "textures/entity/turtle.png");
    }

    @Override
    public void render(Bubble pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}