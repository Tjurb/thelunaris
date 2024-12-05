package net.ttttoooo.thelunaris.entity;

import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.AbstractSchoolingFish;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.ttttoooo.thelunaris.TheLunaris;

@Mod.EventBusSubscriber(modid = TheLunaris.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntitySpawnRules {

    @SubscribeEvent
	public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        // Passive Mobs
        event.register(ModEntities.MOONCOW.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
        		Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(ModEntities.MOONSNAIL.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
        		WaterAnimal::checkSurfaceWaterAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(ModEntities.ARCHFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
        		AbstractSchoolingFish::checkSurfaceWaterAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        
        // Hostile Mobs
        event.register(ModEntities.PHYREX.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
        		Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        event.register(ModEntities.LUNARSLEEPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
        		Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        event.register(ModEntities.HEX.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
        		Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        }
}
