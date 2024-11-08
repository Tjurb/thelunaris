package net.ttttoooo.thelunaris.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.ttttoooo.thelunaris.entity.animations.ModAnimationDefinitions;
import net.ttttoooo.thelunaris.entity.custom.LunarsleeperEntity;

public class LunarsleeperModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart LunarSleeper;
	private final ModelPart head;

	public LunarsleeperModel(ModelPart root) {
		this.LunarSleeper = root.getChild("LunarSleeper");
		this.head = LunarSleeper.getChild("body").getChild("torso").getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition LunarSleeper = partdefinition.addOrReplaceChild("LunarSleeper", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = LunarSleeper.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(15, 0).addBox(-5.0F, -17.0F, -2.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-2.0F, -9.0F, -1.0F, 4.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -5.0F));

		PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(40, 0).addBox(-3.0F, -19.0F, -12.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 5.0F));

		PartDefinition seg1 = body.addOrReplaceChild("seg1", CubeListBuilder.create().texOffs(0, 13).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -5.0F));

		PartDefinition seg2 = seg1.addOrReplaceChild("seg2", CubeListBuilder.create().texOffs(0, 13).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));

		PartDefinition seg3 = seg2.addOrReplaceChild("seg3", CubeListBuilder.create().texOffs(0, 13).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));

		PartDefinition seg4 = seg3.addOrReplaceChild("seg4", CubeListBuilder.create().texOffs(0, 13).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));

		PartDefinition seg5 = seg4.addOrReplaceChild("seg5", CubeListBuilder.create().texOffs(0, 13).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));

		PartDefinition seg6 = seg5.addOrReplaceChild("seg6", CubeListBuilder.create().texOffs(0, 13).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));

		PartDefinition seg7 = seg6.addOrReplaceChild("seg7", CubeListBuilder.create().texOffs(0, 13).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));

		PartDefinition seg8 = seg7.addOrReplaceChild("seg8", CubeListBuilder.create().texOffs(0, 13).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));

		PartDefinition seg9 = seg8.addOrReplaceChild("seg9", CubeListBuilder.create().texOffs(0, 13).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));

		PartDefinition tail = seg9.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 4.0F));

		PartDefinition tail_r1 = tail.addOrReplaceChild("tail_r1", CubeListBuilder.create().texOffs(17, 13).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.7854F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationDefinitions.LUNARSLEEPER_WALKING, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((LunarsleeperEntity) entity).idleAnimationState, ModAnimationDefinitions.LUNARSLEEPER_IDLE, ageInTicks, 1f);
		this.animate(((LunarsleeperEntity) entity).attackAnimationState, ModAnimationDefinitions.LUNARSLEEPER_ATTACKING, ageInTicks, 1f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		LunarSleeper.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return LunarSleeper;
	}
}