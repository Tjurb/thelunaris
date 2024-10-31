package net.ttttoooo.thelunaris.events;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.entity.ModEntities;
import net.ttttoooo.thelunaris.entity.custom.MooncowEntity;

@Mod.EventBusSubscriber(modid = TheLunaris.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.MOONCOW.get(), MooncowEntity.createAttributes().build());
    }

}
