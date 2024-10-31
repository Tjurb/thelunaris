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
import net.minecraft.world.entity.Entity;
import net.ttttoooo.thelunaris.entity.animations.ModAnimationDefinitions;
import net.ttttoooo.thelunaris.entity.custom.ArchfishEntity;

public class ArchfishModel <T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart body;

	public ArchfishModel (ModelPart root) {
		this.body = root.getChild("body");
		}

		public static LayerDefinition createBodyLayer() {
			MeshDefinition meshdefinition = new MeshDefinition();
			PartDefinition partdefinition = meshdefinition.getRoot();

			PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

			PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create(), PartPose.offset(0.0F, -3.0F, -7.0F));

			PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(1, 10).addBox(-1.0F, -2.0F, -4.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 2.0F));

			PartDefinition bodyFront = torso.addOrReplaceChild("bodyFront", CubeListBuilder.create().texOffs(1, 19).addBox(-1.5F, -2.5F, -8.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
			.texOffs(14, 9).addBox(-2.0F, -3.0F, -5.0F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
			.texOffs(15, 2).addBox(0.0F, -5.0F, -2.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 10.0F));

			PartDefinition finleftfront_r1 = bodyFront.addOrReplaceChild("finleftfront_r1", CubeListBuilder.create().texOffs(20, -1).addBox(0.0F, -1.0F, -1.0F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 1.0F, -6.0F, 0.0F, 0.0F, -0.7854F));

			PartDefinition finrightfront_r1 = bodyFront.addOrReplaceChild("finrightfront_r1", CubeListBuilder.create().texOffs(20, -1).addBox(0.0F, -1.0F, -1.0F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 1.0F, -6.0F, 0.0F, 0.0F, 0.7854F));

			PartDefinition bodyBack = torso.addOrReplaceChild("bodyBack", CubeListBuilder.create().texOffs(14, 9).addBox(-2.0F, -3.0F, 0.0F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
			.texOffs(0, 0).addBox(-1.5F, -2.5F, 5.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
			.texOffs(11, -4).addBox(0.0F, -6.0F, 0.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 10.0F));

			PartDefinition tailfin = torso.addOrReplaceChild("tailfin", CubeListBuilder.create().texOffs(20, -6).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 19.0F));

			return LayerDefinition.create(meshdefinition, 32, 32);
		}

		@Override
		public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			this.root().getAllParts().forEach(ModelPart::resetPose);

			this.animateWalk(ModAnimationDefinitions.ARCHFISH_SWIM, limbSwing, limbSwingAmount, 2f, 2.5f);
			this.animate(((ArchfishEntity) entity).idleAnimationState, ModAnimationDefinitions.ARCHFISH_IDLE, ageInTicks, 1f);
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