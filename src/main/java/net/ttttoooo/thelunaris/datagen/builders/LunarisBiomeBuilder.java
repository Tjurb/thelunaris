package net.ttttoooo.thelunaris.datagen.builders;

import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.ttttoooo.thelunaris.entity.ModEntities;
import net.ttttoooo.thelunaris.worldgen.ModPlacedFeatures;


public class LunarisBiomeBuilder {
	public static Biome shimmeringcoast(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
    	return makeCoastBiome(new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CELEST_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CANYON));
    }
	
	public static Biome sapphireriver(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
    	return makeRiverBiome(new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CANYON));
    }
	
    public static Biome azureocean(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
    	return makeOceanBiome(new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CELEST_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CANYON));
    }

    public static Biome lunarforest(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        return makeForestBiome(new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CELEST_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.STELLAR_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LUNARIS_GRASS_PATCH_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LUNARIS_SARROT_PATCH_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CANYON));
    }

    public static Biome sleepingsands(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        return makeDesertBiome(new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CANYON));
    }

    public static Biome skymountain(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        return makeMountainBiome(new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SKYOAK_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LUNARIS_GRASS_PATCH_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LUNARIS_BERRY_PATCH_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LABRADORITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_LABRADORITE_ORE_PLACED_KEY)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CANYON));
    }
    
    public static Biome makeRiverBiome(BiomeGenerationSettings.Builder builder) {
        return fullDefinition(
                false,
                0.5F,
                0.5F,
                new BiomeSpecialEffects.Builder()
                	.waterColor(0x000077)
                	.waterFogColor(0x000077)
                	.fogColor(0x124266)
                	.skyColor(0x124266)
                	.grassColorOverride(0x2986cc)
                	.foliageColorOverride(0x156DAF)
                    .grassColorModifier(BiomeSpecialEffects.GrassColorModifier.NONE)
                    .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_GAME))
                    .build(),
                new MobSpawnSettings.Builder()
            	.creatureGenerationProbability(0.25F)
            	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.ARCHFISH.get(), 4, 2, 3))
            	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.MOONSNAIL.get(), 4, 2, 3))
            
                        .build(),
                        builder 
                        .build(),
                Biome.TemperatureModifier.NONE
        );
    }

    public static Biome makeCoastBiome(BiomeGenerationSettings.Builder builder) {
        return fullDefinition(
                false,
                0.5F,
                0.5F,
                new BiomeSpecialEffects.Builder()
                	.waterColor(0x000077)
                	.waterFogColor(0x000077)
                	.fogColor(0x124266)
                	.skyColor(0x124266)
                	.grassColorOverride(0x2986cc)
                	.foliageColorOverride(0x156DAF)
                    .grassColorModifier(BiomeSpecialEffects.GrassColorModifier.NONE)
                    .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_GAME))
                    .build(),
                new MobSpawnSettings.Builder()
            	.creatureGenerationProbability(0.25F)
            	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.MOONSNAIL.get(), 4, 2, 3))
            
                        .build(),
                        builder 
                        .build(),
                Biome.TemperatureModifier.NONE
        );
    }
    
    public static Biome makeOceanBiome(BiomeGenerationSettings.Builder builder) {
        return fullDefinition(
                false,
                0.5F,
                0.5F,
                new BiomeSpecialEffects.Builder()
                	.waterColor(0x000077)
                	.waterFogColor(0x000077)
                	.fogColor(0x124266)
                	.skyColor(0x124266)
                	.grassColorOverride(0x2986cc)
                	.foliageColorOverride(0x156DAF)
                    .grassColorModifier(BiomeSpecialEffects.GrassColorModifier.NONE)
                    .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_GAME))
                    .build(),
                new MobSpawnSettings.Builder()
            	.creatureGenerationProbability(0.25F)
            	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.ARCHFISH.get(), 10, 3, 5))
            	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.MOONSNAIL.get(), 4, 2, 3))
            
                        .build(),
                        builder 
                        .build(),
                Biome.TemperatureModifier.NONE
        );
    }
    
    public static Biome makeForestBiome(BiomeGenerationSettings.Builder builder) {
        return fullDefinition(
                false,
                0.7F,
                0.8F,
                new BiomeSpecialEffects.Builder()
                	.waterColor(0x111155)
                	.waterFogColor(0x111155)
                	.fogColor(0x124266)
                	.skyColor(0x124266)
                	.grassColorOverride(0x2986cc)
                	.foliageColorOverride(0x156DAF)
                    .grassColorModifier(BiomeSpecialEffects.GrassColorModifier.NONE)
                    .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST))
                    .build(),
                new MobSpawnSettings.Builder()
                	.creatureGenerationProbability(0.25F)
                	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.MOONCOW.get(), 10, 2, 4))
                	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.MOONSNAIL.get(), 4, 1, 2))
                	.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.PHYREX.get(), 1, 1, 2))
                
                	.build(),
                        builder 
                        .build(),
                Biome.TemperatureModifier.NONE
        );
    }
    
    public static Biome makeDesertBiome(BiomeGenerationSettings.Builder builder) {
        return fullDefinition(
                false,
                2.0F,
                0.0F,
                new BiomeSpecialEffects.Builder()
                	.waterColor(0x110066)
                	.waterFogColor(0x110066)
                	.fogColor(0x124266)
                	.skyColor(0x124266)
                	.grassColorOverride(0x2986cc)
                	.foliageColorOverride(0x156DAF)
                    .grassColorModifier(BiomeSpecialEffects.GrassColorModifier.NONE)
                    .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DESERT))
                    .build(),
                new MobSpawnSettings.Builder()
            	.creatureGenerationProbability(0.25F)
            	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.MOONCOW.get(), 5, 1, 2))
            	.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.LUNARSLEEPER.get(), 1, 1, 1))
            
                        .build(),
                        builder 
                        .build(),
                Biome.TemperatureModifier.NONE
        );
    }
    
    public static Biome makeMountainBiome(BiomeGenerationSettings.Builder builder) {
        return fullDefinition(
                false,
                1.0F,
                0.3F,
                new BiomeSpecialEffects.Builder()
                	.waterColor(0x001166)
                	.waterFogColor(0x001166)
                	.fogColor(0x124266)
                	.skyColor(0x124266)
                	.grassColorOverride(0x2986cc)
                	.foliageColorOverride(0x156DAF)
                    .grassColorModifier(BiomeSpecialEffects.GrassColorModifier.NONE)
                    .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SNOWY_SLOPES))
                    .build(),
                new MobSpawnSettings.Builder()
            	.creatureGenerationProbability(0.25F)
            	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.MOONCOW.get(), 8, 2, 3))
            	.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.HEX.get(), 8, 2, 3))
            
                        .build(),
                        builder 
                        .build(),
                Biome.TemperatureModifier.FROZEN
        );
    }

    public static Biome fullDefinition(boolean precipitation, float temperature, float downfall, BiomeSpecialEffects effects, MobSpawnSettings spawnSettings, BiomeGenerationSettings generationSettings, Biome.TemperatureModifier temperatureModifier) {
        return new Biome.BiomeBuilder()
                .hasPrecipitation(precipitation)
                .temperature(temperature)
                .downfall(downfall)
                .specialEffects(effects)
                .mobSpawnSettings(spawnSettings)
                .generationSettings(generationSettings)
                .temperatureAdjustment(temperatureModifier)
                .build();
    }
}