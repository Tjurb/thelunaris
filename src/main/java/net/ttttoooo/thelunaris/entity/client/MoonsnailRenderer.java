package net.ttttoooo.thelunaris.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.entity.custom.MoonsnailEntity;

public class MoonsnailRenderer extends MobRenderer<MoonsnailEntity, MoonsnailModel<MoonsnailEntity>> {
    public MoonsnailRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new MoonsnailModel<>(pContext.bakeLayer(ModModelLayers.MOONSNAIL_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(MoonsnailEntity pEntity) {
        return new ResourceLocation(TheLunaris.MODID, "textures/entity/moonsnail.png");
    }

    @Override
    public void render(MoonsnailEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
