package net.ttttoooo.thelunaris.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.entity.custom.MooncowEntity;

public class MooncowRenderer extends MobRenderer<MooncowEntity, MooncowModel<MooncowEntity>> {
    public MooncowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new MooncowModel<>(pContext.bakeLayer(ModModelLayers.MOONCOW_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(MooncowEntity pEntity) {
        return new ResourceLocation(TheLunaris.MODID, "textures/entity/mooncow.png");
    }

    @Override
    public void render(MooncowEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
