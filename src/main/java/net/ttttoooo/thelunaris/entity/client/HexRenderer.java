package net.ttttoooo.thelunaris.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.entity.custom.HexEntity;
import net.ttttoooo.thelunaris.entity.custom.LunarsleeperEntity;

public class HexRenderer extends MobRenderer<HexEntity, HexModel<HexEntity>> {
    public HexRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new HexModel<>(pContext.bakeLayer(ModModelLayers.HEX_LAYER)), 0.9f);
    }

	@Override
    public ResourceLocation getTextureLocation(HexEntity pEntity) {
        return new ResourceLocation(TheLunaris.MODID, "textures/entity/hex.png");
    }

    @Override
    public void render(HexEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}