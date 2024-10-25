package net.ttttoooo.thelunaris.datagen.builders;

import net.minecraft.core.HolderGetter;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.ttttoooo.thelunaris.worldgen.ModPlacedFeatures;


public class LunarisBiomeBuilder {
    public static Biome azureocean(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        return makeOceanBiome(new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CELEST_PLACED_KEY));
    }

    public static Biome lunarforest(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        return makeForestBiome(new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CELEST_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.STELLAR_PLACED_KEY));
    }

    public static Biome sleepingsands(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        return makeDesertBiome(new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers));
    }

    public static Biome skymountain(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        return makeMountainBiome(new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SKYOAK_PLACED_KEY));
    }

    public static Biome makeOceanBiome(BiomeGenerationSettings.Builder builder) {
        return fullDefinition(
                false,
                0.8F,
                0.0F,
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
                        .build(),
                        builder 
                        .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LUNARITE_ORE_PLACED_KEY)
                        .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_MOONSTEEL_ORE_PLACED_KEY)
                        .build(),
                Biome.TemperatureModifier.NONE
        );
    }
    
    public static Biome makeForestBiome(BiomeGenerationSettings.Builder builder) {
        return fullDefinition(
                false,
                0.8F,
                0.0F,
                new BiomeSpecialEffects.Builder()
                	.waterColor(0x000077)
                	.waterFogColor(0x000077)
                	.fogColor(0x124266)
                	.skyColor(0x124266)
                	.grassColorOverride(0x2986cc)
                	.foliageColorOverride(0x156DAF)
                    .grassColorModifier(BiomeSpecialEffects.GrassColorModifier.NONE)
                    .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST))
                    .build(),
                new MobSpawnSettings.Builder()
                        .build(),
                        builder 
                        .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LUNARITE_ORE_PLACED_KEY)
                        .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_MOONSTEEL_ORE_PLACED_KEY)
                        .build(),
                Biome.TemperatureModifier.NONE
        );
    }
    
    public static Biome makeDesertBiome(BiomeGenerationSettings.Builder builder) {
        return fullDefinition(
                false,
                0.8F,
                0.0F,
                new BiomeSpecialEffects.Builder()
                	.waterColor(0x000077)
                	.waterFogColor(0x000077)
                	.fogColor(0x124266)
                	.skyColor(0x124266)
                	.grassColorOverride(0x2986cc)
                	.foliageColorOverride(0x156DAF)
                    .grassColorModifier(BiomeSpecialEffects.GrassColorModifier.NONE)
                    .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DESERT))
                    .build(),
                new MobSpawnSettings.Builder()
                        .build(),
                        builder 
                        .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LUNARITE_ORE_PLACED_KEY)
                        .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_MOONSTEEL_ORE_PLACED_KEY)
                        .build(),
                Biome.TemperatureModifier.NONE
        );
    }
    
    public static Biome makeMountainBiome(BiomeGenerationSettings.Builder builder) {
        return fullDefinition(
                false,
                0.8F,
                0.0F,
                new BiomeSpecialEffects.Builder()
                	.waterColor(0x000077)
                	.waterFogColor(0x000077)
                	.fogColor(0x124266)
                	.skyColor(0x124266)
                	.grassColorOverride(0x2986cc)
                	.foliageColorOverride(0x156DAF)
                    .grassColorModifier(BiomeSpecialEffects.GrassColorModifier.NONE)
                    .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SNOWY_SLOPES))
                    .build(),
                new MobSpawnSettings.Builder()
                        .build(),
                        builder 
                        .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LUNARITE_ORE_PLACED_KEY)
                        .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_MOONSTEEL_ORE_PLACED_KEY)
                        .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LABRADORITE_ORE_PLACED_KEY)
                        .build(),
                Biome.TemperatureModifier.NONE
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