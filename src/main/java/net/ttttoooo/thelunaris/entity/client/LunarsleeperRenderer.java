package net.ttttoooo.thelunaris.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.entity.custom.LunarsleeperEntity;

public class LunarsleeperRenderer extends MobRenderer<LunarsleeperEntity, LunarsleeperModel<LunarsleeperEntity>> {
    public LunarsleeperRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new LunarsleeperModel<>(pContext.bakeLayer(ModModelLayers.LUNARSLEEPER_LAYER)), 0.5f);
    }

	@Override
    public ResourceLocation getTextureLocation(LunarsleeperEntity pEntity) {
        return new ResourceLocation(TheLunaris.MODID, "textures/entity/lunarsleeper.png");
    }

    @Override
    public void render(LunarsleeperEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}