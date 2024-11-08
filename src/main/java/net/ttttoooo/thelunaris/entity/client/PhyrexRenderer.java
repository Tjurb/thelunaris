package net.ttttoooo.thelunaris.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.entity.custom.PhyrexEntity;

public class PhyrexRenderer extends MobRenderer<PhyrexEntity, PhyrexModel<PhyrexEntity>> {
    public PhyrexRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PhyrexModel<>(pContext.bakeLayer(ModModelLayers.PHYREX_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(PhyrexEntity pEntity) {
        return new ResourceLocation(TheLunaris.MODID, "textures/entity/phyrex.png");
    }

    @Override
    public void render(PhyrexEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}