package net.ttttoooo.thelunaris.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.ttttoooo.thelunaris.entity.animations.ModAnimationDefinitions;
import net.ttttoooo.thelunaris.entity.custom.MooncowEntity;

// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class MooncowModel <T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart mooncow;
	private final ModelPart head;

	public MooncowModel (ModelPart root) {
		this.mooncow = root.getChild("mooncow");
		this.head = mooncow.getChild("body").getChild("torso").getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition mooncow = partdefinition.addOrReplaceChild("mooncow", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = mooncow.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 32).addBox(-6.0F, -6.1583F, -5.9167F, 12.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(10, 44).addBox(-5.0F, -4.1583F, 10.0833F, 10.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 10).mirror().addBox(-3.0F, 5.8417F, 10.0833F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -17.8417F, -8.0833F));

		PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(24, 0).addBox(-11.0F, -2.0F, -4.0F, 10.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(33, 13).mirror().addBox(-9.0F, 4.0F, -5.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).addBox(-13.0F, -5.0F, -1.0F, 14.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -6.1583F, -7.9167F));

		PartDefinition left_back_leg = body.addOrReplaceChild("left_back_leg", CubeListBuilder.create().texOffs(48, 18).addBox(-2.0F, -2.5F, -2.0F, 4.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -15.5F, 10.0F));

		PartDefinition right_back_leg = body.addOrReplaceChild("right_back_leg", CubeListBuilder.create().texOffs(48, 18).addBox(-2.0F, -2.5F, -2.0F, 4.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -15.5F, 10.0F));

		PartDefinition right_front_leg = body.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(48, 18).addBox(-2.0F, -2.5F, -2.0F, 4.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -15.5F, -10.0F));

		PartDefinition left_front_leg = body.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(48, 18).addBox(-2.0F, -2.5F, -2.0F, 4.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -15.5F, -10.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationDefinitions.MOONCOW_WALKING, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((MooncowEntity) entity).idleAnimationState, ModAnimationDefinitions.MOONCOW_IDLE, ageInTicks, 1f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		mooncow.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return mooncow;
	}
}