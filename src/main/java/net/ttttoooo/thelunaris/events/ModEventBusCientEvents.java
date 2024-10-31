package net.ttttoooo.thelunaris.events;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.entity.ModEntities;
import net.ttttoooo.thelunaris.entity.client.ModModelLayers;
import net.ttttoooo.thelunaris.entity.client.MooncowModel;
import net.ttttoooo.thelunaris.entity.custom.MooncowEntity;

@Mod.EventBusSubscriber(modid = TheLunaris.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusCientEvents {
	@SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.MOONCOW_LAYER, MooncowModel::createBodyLayer);
    }
}
