package com.desx.rebornworld.entity.client;// Made with Blockbench 4.10.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.desx.rebornworld.entity.Animations.OceanAnimationDefinitions;
import com.desx.rebornworld.entity.ocean.Bubble;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;

import java.util.Objects;


public class turtle<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart turtle;


    public turtle(ModelPart turtle) {
        this.turtle = turtle;

    }

    public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition all = partdefinition.addOrReplaceChild("all", CubeListBuilder.create(), PartPose.offset(3.0F, 25.0F, 0.0F));

		PartDefinition head = all.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 152).addBox(-5.5F, -7.0F, -13.0F, 11.0F, 9.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.0F, -13.0F, -10.0F, 0.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -6.0F, -9.0F));

		PartDefinition body = all.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(-3.0F, -7.0F, -5.0F));

		PartDefinition body_rotation = body.addOrReplaceChild("body_rotation", CubeListBuilder.create().texOffs(0, 53).addBox(-17.0F, -9.0F, -10.0F, 34.0F, 13.0F, 40.0F, new CubeDeformation(0.0F))
		.texOffs(0, 106).addBox(0.0F, -15.0F, -7.0F, 0.0F, 6.0F, 40.0F, new CubeDeformation(0.0F))
		.texOffs(134, 89).addBox(-22.4F, -3.0F, -7.0F, 6.0F, 0.0F, 40.0F, new CubeDeformation(0.0F))
		.texOffs(122, 89).addBox(16.6F, -3.0F, -7.0F, 6.0F, 0.0F, 40.0F, new CubeDeformation(0.0F))
		.texOffs(108, 0).addBox(-13.0F, 4.0F, -7.0F, 26.0F, 5.0F, 35.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 3.0F));

		PartDefinition body2 = body_rotation.addOrReplaceChild("body2", CubeListBuilder.create(), PartPose.offset(3.0F, -3.0F, -8.0F));

		PartDefinition body2_rotation = body2.addOrReplaceChild("body2_rotation", CubeListBuilder.create().texOffs(87, 111).addBox(-13.0F, 12.0F, 1.0F, 20.0F, 1.0F, 35.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg1 = all.addOrReplaceChild("leg1", CubeListBuilder.create(), PartPose.offset(-11.5F, -3.0F, 26.0F));

		PartDefinition cube_r1 = leg1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(125, 159).addBox(-44.0F, -4.0F, -16.0F, 18.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.5F, 3.0F, -26.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition leg2 = all.addOrReplaceChild("leg2", CubeListBuilder.create(), PartPose.offset(5.5F, -3.0F, 26.0F));

		PartDefinition cube_r2 = leg2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(162, 129).addBox(26.0F, -4.0F, -10.0F, 18.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, 3.0F, -26.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition leg3 = all.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(104, 147).addBox(-22.0F, -2.0F, -6.0F, 22.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-16.0F, -4.0F, 0.0F));

		PartDefinition leg4 = all.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(148, 40).addBox(0.0F, -2.0F, -6.0F, 22.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(10.0F, -4.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}


	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(OceanAnimationDefinitions.FLOATSNORMALLY, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((Bubble) entity).idleAnimationState, OceanAnimationDefinitions.IDLE, ageInTicks, 1f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.turtle.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.turtle.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		turtle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return turtle;
	}
}