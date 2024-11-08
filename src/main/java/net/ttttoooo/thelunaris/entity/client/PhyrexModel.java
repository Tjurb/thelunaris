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
import net.ttttoooo.thelunaris.entity.custom.PhyrexEntity;


public class PhyrexModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart body;
	private final ModelPart head;

	public PhyrexModel(ModelPart root) {
		this.body = root.getChild("body");
		this.head = body.getChild("torso").getChild("neckbone").getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 48).addBox(-4.0F, -20.0F, -3.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(38, 32).addBox(-3.0F, -23.0F, -8.0F, 6.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(8, 40).addBox(-2.0F, -17.0F, 5.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition neckbone = torso.addOrReplaceChild("neckbone", CubeListBuilder.create(), PartPose.offset(0.0F, -21.0F, -8.0F));

		PartDefinition neck_r1 = neckbone.addOrReplaceChild("neck_r1", CubeListBuilder.create().texOffs(25, 44).addBox(-1.5F, -9.0F, -1.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head = neckbone.addOrReplaceChild("head", CubeListBuilder.create().texOffs(34, 50).addBox(-3.0F, -5.0F, -6.0F, 6.0F, 5.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(22, 4).addBox(0.0F, -8.0F, 0.0F, 0.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 1.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(9, 32).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 9.0F));

		PartDefinition tailcube2_r1 = tail.addOrReplaceChild("tailcube2_r1", CubeListBuilder.create().texOffs(9, 32).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition leftlegbone = body.addOrReplaceChild("leftlegbone", CubeListBuilder.create().texOffs(0, 32).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -14.0F, 0.0F));

		PartDefinition rightlegbone = body.addOrReplaceChild("rightlegbone", CubeListBuilder.create().texOffs(0, 32).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -14.0F, 0.0F));

		PartDefinition leftwing = body.addOrReplaceChild("leftwing", CubeListBuilder.create().texOffs(32, 0).addBox(0.0F, 0.0F, -2.0F, 8.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -21.0F, -6.0F, 0.0F, 0.0F, 1.3963F));

		PartDefinition innerwingleftbone = leftwing.addOrReplaceChild("innerwingleftbone", CubeListBuilder.create().texOffs(18, 0).addBox(0.0F, 0.0F, -2.0F, 8.0F, 0.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(12, 35).addBox(6.0F, -1.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.9671F));

		PartDefinition outerwingleftbone = innerwingleftbone.addOrReplaceChild("outerwingleftbone", CubeListBuilder.create().texOffs(20, 20).addBox(0.0F, 0.0F, -1.0F, 16.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -1.0F, 0.0F, 0.0F, 2.9671F));

		PartDefinition rightwing = body.addOrReplaceChild("rightwing", CubeListBuilder.create().texOffs(-16, 0).addBox(-8.0F, 0.0F, -2.0F, 8.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -21.0F, -6.0F, 0.0F, 0.0F, -1.3963F));

		PartDefinition innerwingrightbone = rightwing.addOrReplaceChild("innerwingrightbone", CubeListBuilder.create().texOffs(2, 0).addBox(-8.0F, 0.0F, -1.0F, 8.0F, 0.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(12, 35).addBox(-8.0F, -1.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 0.0F, -1.0F, 0.0F, 0.0F, 2.9671F));

		PartDefinition outerwingrightbone = innerwingrightbone.addOrReplaceChild("outerwingrightbone", CubeListBuilder.create(), PartPose.offset(-8.0F, 0.0F, 0.0F));

		PartDefinition outerwingright_r1 = outerwingrightbone.addOrReplaceChild("outerwingright_r1", CubeListBuilder.create().texOffs(-12, 20).addBox(-16.0F, 0.0F, -1.0F, 16.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.9671F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationDefinitions.PHYREX_WALKING, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((PhyrexEntity) entity).idleAnimationState, ModAnimationDefinitions.PHYREX_IDLE, ageInTicks, 1f);
		this.animate(((PhyrexEntity) entity).attackAnimationState, ModAnimationDefinitions.PHYREX_ATTACKING, ageInTicks, 1f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return body;
	}
}