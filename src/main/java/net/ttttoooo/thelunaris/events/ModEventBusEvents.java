package net.ttttoooo.thelunaris.events;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.entity.ModEntities;
import net.ttttoooo.thelunaris.entity.custom.ArchfishEntity;
import net.ttttoooo.thelunaris.entity.custom.HexEntity;
import net.ttttoooo.thelunaris.entity.custom.HexProjectile;
import net.ttttoooo.thelunaris.entity.custom.LunarsleeperEntity;
import net.ttttoooo.thelunaris.entity.custom.MooncowEntity;
import net.ttttoooo.thelunaris.entity.custom.MoonsnailEntity;
import net.ttttoooo.thelunaris.entity.custom.PhyrexEntity;

@Mod.EventBusSubscriber(modid = TheLunaris.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.MOONCOW.get(), MooncowEntity.createAttributes().build());
        event.put(ModEntities.ARCHFISH.get(), ArchfishEntity.createAttributes().build());
        event.put(ModEntities.MOONSNAIL.get(), MoonsnailEntity.createAttributes().build());
        event.put(ModEntities.PHYREX.get(), PhyrexEntity.createAttributes().build());
        event.put(ModEntities.LUNARSLEEPER.get(), LunarsleeperEntity.createAttributes().build());
        event.put(ModEntities.HEX.get(), HexEntity.createAttributes().build());
    }

}
