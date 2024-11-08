package net.ttttoooo.thelunaris.events;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.entity.ModEntities;
import net.ttttoooo.thelunaris.entity.client.ArchfishModel;
import net.ttttoooo.thelunaris.entity.client.HexModel;
import net.ttttoooo.thelunaris.entity.client.LunarsleeperModel;
import net.ttttoooo.thelunaris.entity.client.ModModelLayers;
import net.ttttoooo.thelunaris.entity.client.MooncowModel;
import net.ttttoooo.thelunaris.entity.client.MoonsnailModel;
import net.ttttoooo.thelunaris.entity.client.PhyrexModel;
import net.ttttoooo.thelunaris.entity.custom.MooncowEntity;

@Mod.EventBusSubscriber(modid = TheLunaris.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusCientEvents {
	@SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.MOONCOW_LAYER, MooncowModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.ARCHFISH_LAYER, ArchfishModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.MOONSNAIL_LAYER, MoonsnailModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.PHYREX_LAYER, PhyrexModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.LUNARSLEEPER_LAYER, LunarsleeperModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.HEX_LAYER, HexModel::createBodyLayer);
    }
}
