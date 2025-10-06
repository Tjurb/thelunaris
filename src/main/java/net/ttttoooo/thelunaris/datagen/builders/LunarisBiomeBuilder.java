package net.ttttoooo.thelunaris.datagen.builders;

import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.ttttoooo.thelunaris.entity.ModEntities;
import net.ttttoooo.thelunaris.worldgen.ModPlacedFeatures;


public class LunarisBiomeBuilder {
	public static Biome barrendeep(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
		return makeBarrenBiome(new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LABRADORITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SLATE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNAR_CLAY_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SLATE_PLACED_KEY)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CANYON));
    }

	//New Biome
	public static Biome frozencaves(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
		return makeFrozenCaveBiome(new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers)
				.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.DEEP_ICEWOOD_PLACED_KEY)
				.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.DEEP_STELLAR_PLACED_KEY)
				.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LABRADORITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SLATE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNAR_CLAY_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SLATE_PLACED_KEY)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CANYON));
    }

	//New Biome
	public static Biome forestedcaves(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
		return makeForestCaveBiome(new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers)
				.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.DEEP_STELLAR_PLACED_KEY)
				.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.DEEP_CELEST_PLACED_KEY)
				.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.TWISTED_VINEWOOD_PLACED_KEY)
				.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.TALL_LUNARIS_GRASS_PATCH_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LUNARIS_GRASS_PATCH_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LABRADORITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SLATE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNAR_CLAY_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SLATE_PLACED_KEY)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CANYON));
    }
	
	//New Biome
	public static Biome grassycaves(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
		return makeGrassyCaveBiome(new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers)
				.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SMALL_VINEWOOD_PLACED_KEY)
				.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.TALL_LUNARIS_GRASS_PATCH_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LUNARIS_GRASS_PATCH_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LABRADORITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SLATE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNAR_CLAY_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SLATE_PLACED_KEY)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CANYON));
    }
	
	public static Biome crimsonshelf(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
		return makeCrimsonBiome(new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.DEEP_STELLAR_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.STELLAR_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CRIMSON_GRASS_PATCH_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LABRADORITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SLATE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNAR_CLAY_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SLATE_PLACED_KEY)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CANYON));
    }
	
	public static Biome dusklightcave(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
    	return makeDuskBiome(new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.DEEP_CELEST_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CELEST_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.DUSKLIGHT_GRASS_PATCH_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LABRADORITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SLATE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNAR_CLAY_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SLATE_PLACED_KEY)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CANYON));
    }
	
	public static Biome shimmeringcoast(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
    	return makeCoastBiome(new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CELEST_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LUNAR_FLOWER_DESERT_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LABRADORITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SLATE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNAR_CLAY_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SLATE_PLACED_KEY)
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
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LABRADORITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SLATE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNAR_CLAY_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SLATE_PLACED_KEY)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CANYON));
    }
	
    public static Biome azureocean(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
    	return makeOceanBiome(new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CELEST_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LUNAR_FLOWER_DESERT_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LABRADORITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SLATE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNAR_CLAY_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SLATE_PLACED_KEY)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CANYON));
    }

    public static Biome lunarplains(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        return makePlainsBiome(new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.TALL_LUNARIS_GRASS_PATCH_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LUNARIS_GRASS_PATCH_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LUNARIS_SARROT_PATCH_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LUNARIS_BERRY_PATCH_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LUNAR_FLOWER_DEFAULT_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LABRADORITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SLATE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SLATE_PLACED_KEY)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CANYON));
    }
    
    public static Biome lunarforest(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        return makeForestBiome(new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CELEST_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.STELLAR_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LARGE_CELEST_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LARGE_STELLAR_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LUNARIS_GRASS_PATCH_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LUNARIS_SARROT_PATCH_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LUNAR_FLOWER_DEFAULT_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LABRADORITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SLATE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SLATE_PLACED_KEY)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CANYON));
    }

	//New Biome
    public static Biome hightopjungle(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        return makeJungleBiome(new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.VINEWOOD_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.TWISTED_VINEWOOD_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SMALL_VINEWOOD_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.STELLAR_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LUNARIS_GRASS_PATCH_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LUNARIS_SARROT_PATCH_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LUNAR_FLOWER_DEFAULT_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LABRADORITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SLATE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SLATE_PLACED_KEY)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CANYON));
    }

	//New Biome
    public static Biome frozencover(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        return makeFrozenBiome(new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.FROZEN_SKYOAK_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.ICEWOOD_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.TALL_ICEWOOD_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SKYOAK_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LUNARIS_GRASS_PATCH_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LUNAR_FLOWER_DEFAULT_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LABRADORITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SLATE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SLATE_PLACED_KEY)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CANYON));
    }

    public static Biome sleepingsands(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        return makeDesertBiome(new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LUNAR_FLOWER_DESERT_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LABRADORITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SLATE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SLATE_PLACED_KEY)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CANYON));
    }

    public static Biome skymountain(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        return makeMountainBiome(new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SKYOAK_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LARGE_SKYOAK_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LUNARIS_GRASS_PATCH_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LUNARIS_BERRY_PATCH_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LUNAR_FLOWER_DEFAULT_PLACED_KEY)
        		.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LUNAR_FLOWER_MOUNTAIN_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LABRADORITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_LABRADORITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LABRADORITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_LABRADORITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_MOONSTEEL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_LUNARITE_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LUNARIS_DEEP_LARGE_COAL_ORE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SLATE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_MARBLE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SHALE_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_SLATE_PLACED_KEY)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CANYON));
    }  

    public static Biome makeBarrenBiome(BiomeGenerationSettings.Builder builder) {
        return fullDefinition(
                false,
                0.7F,
                0.8F,
                new BiomeSpecialEffects.Builder()
                	.waterColor(0x260656)
                	.waterFogColor(0x260656)
                	.fogColor(0x260656)
                	.skyColor(0x260656)
                	.grassColorOverride(0x260656)
                	.foliageColorOverride(0x260656)
                    .grassColorModifier(BiomeSpecialEffects.GrassColorModifier.NONE)
                    .ambientLoopSound(SoundEvents.AMBIENT_NETHER_WASTES_LOOP)
                    .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_NETHER_WASTES))
                    .build(),
                new MobSpawnSettings.Builder()
                	.creatureGenerationProbability(0.25F)
                	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.ARCHFISH.get(), 40, 3, 5))
                	.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.PHYREX.get(), 5, 1, 1))
                	.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.HEX.get(), 5, 1, 1))
                	
	                	.build(),
                        builder 
                        .build(),
                Biome.TemperatureModifier.NONE
        );
    }
    
    //new Builder
    public static Biome makeFrozenCaveBiome(BiomeGenerationSettings.Builder builder) {
        return fullDefinition(
                false,
                0.7F,
                0.8F,
                new BiomeSpecialEffects.Builder()
                	.waterColor(0x260656)
                	.waterFogColor(0x260656)
                	.fogColor(0x260656)
                	.skyColor(0x260656)
                	.grassColorOverride(0x260656)
                	.foliageColorOverride(0x260656)
                    .grassColorModifier(BiomeSpecialEffects.GrassColorModifier.NONE)
                    .ambientLoopSound(SoundEvents.AMBIENT_NETHER_WASTES_LOOP)
                    .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FROZEN_PEAKS))
                    .build(),
                new MobSpawnSettings.Builder()
                	.creatureGenerationProbability(0.25F)
                	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.ARCHFISH.get(), 40, 3, 5))
                	.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.PHYREX.get(), 5, 1, 1))
                	.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.HEX.get(), 5, 1, 1))
                	
	                	.build(),
                        builder 
                        .build(),
                Biome.TemperatureModifier.FROZEN
        );
    }

    //new Builder
    public static Biome makeForestCaveBiome(BiomeGenerationSettings.Builder builder) {
        return fullDefinition(
                false,
                0.7F,
                0.8F,
                new BiomeSpecialEffects.Builder()
                	.waterColor(0x260656)
                	.waterFogColor(0x260656)
                	.fogColor(0x260656)
                	.skyColor(0x260656)
                	.grassColorOverride(0x260656)
                	.foliageColorOverride(0x260656)
                    .grassColorModifier(BiomeSpecialEffects.GrassColorModifier.NONE)
                    .ambientLoopSound(SoundEvents.AMBIENT_NETHER_WASTES_LOOP)
                    .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_LUSH_CAVES))
                    .build(),
                new MobSpawnSettings.Builder()
                	.creatureGenerationProbability(0.25F)
                	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.ARCHFISH.get(), 40, 3, 5))
                	.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.PHYREX.get(), 5, 1, 1))
                	.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.HEX.get(), 5, 1, 1))
                	
	                	.build(),
                        builder 
                        .build(),
                Biome.TemperatureModifier.NONE
        );
    }

    //new Builder
    public static Biome makeGrassyCaveBiome(BiomeGenerationSettings.Builder builder) {
        return fullDefinition(
                false,
                0.7F,
                0.8F,
                new BiomeSpecialEffects.Builder()
                	.waterColor(0x260656)
                	.waterFogColor(0x260656)
                	.fogColor(0x260656)
                	.skyColor(0x260656)
                	.grassColorOverride(0x260656)
                	.foliageColorOverride(0x260656)
                    .grassColorModifier(BiomeSpecialEffects.GrassColorModifier.NONE)
                    .ambientLoopSound(SoundEvents.AMBIENT_NETHER_WASTES_LOOP)
                    .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_LUSH_CAVES))
                    .build(),
                new MobSpawnSettings.Builder()
                	.creatureGenerationProbability(0.25F)
                	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.ARCHFISH.get(), 40, 3, 5))
                	.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.PHYREX.get(), 5, 1, 1))
                	.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.HEX.get(), 5, 1, 1))
                	
	                	.build(),
                        builder 
                        .build(),
                Biome.TemperatureModifier.NONE
        );
    }
    
    public static Biome makeCrimsonBiome(BiomeGenerationSettings.Builder builder) {
        return fullDefinition(
                false,
                0.7F,
                0.8F,
                new BiomeSpecialEffects.Builder()
                	.waterColor(0x260656)
                	.waterFogColor(0x260656)
                	.fogColor(0x260656)
                	.skyColor(0x260656)
                	.grassColorOverride(0xDC143C)
                	.foliageColorOverride(0xDC143C)
                    .grassColorModifier(BiomeSpecialEffects.GrassColorModifier.NONE)
                    .ambientLoopSound(SoundEvents.AMBIENT_CRIMSON_FOREST_LOOP)
                    .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_CRIMSON_FOREST))
                    .build(),
                new MobSpawnSettings.Builder()
                	.creatureGenerationProbability(0.25F)
                	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.ARCHFISH.get(), 40, 3, 5))
                	.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.PHYREX.get(), 5, 1, 2))
                	.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.HEX.get(), 10, 2, 3))
                	
                		.build(),
                        builder 
                        .build(),
                Biome.TemperatureModifier.NONE
        );
    }
    
    public static Biome makeDuskBiome(BiomeGenerationSettings.Builder builder) {
        return fullDefinition(
                false,
                0.7F,
                0.8F,
                new BiomeSpecialEffects.Builder()
                	.waterColor(0x260656)
                	.waterFogColor(0x260656)
                	.fogColor(0x260656)
                	.skyColor(0x260656)
                	.grassColorOverride(0x260656)
                	.foliageColorOverride(0x260656)
                    .grassColorModifier(BiomeSpecialEffects.GrassColorModifier.NONE)
                    .ambientLoopSound(SoundEvents.AMBIENT_WARPED_FOREST_LOOP)
                    .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DEEP_DARK))
                    .build(),
                new MobSpawnSettings.Builder()
                	.creatureGenerationProbability(0.25F)
                	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.ARCHFISH.get(), 40, 3, 5))
                	.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.PHYREX.get(), 5, 1, 2))
                	.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.HEX.get(), 20, 2, 3))
                
                		.build(),
                        builder 
                        .build(),
                Biome.TemperatureModifier.NONE
        );
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
            		.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.ARCHFISH.get(), 40, 2, 3))
            		.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.MOONSNAIL.get(), 10, 2, 3))
            
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
            	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.ARCHFISH.get(), 40, 3, 5))
            	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.MOONSNAIL.get(), 2, 2, 3))
            
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
            	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.ARCHFISH.get(), 80, 3, 5))
            	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.MOONSNAIL.get(), 40, 2, 3))
            
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
                	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.MOONCOW.get(), 80, 2, 4))
                	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.MOONSNAIL.get(), 20, 1, 2))
                	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.ARCHFISH.get(), 40, 3, 5))
                	.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.PHYREX.get(), 10, 1, 2))
                	.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.HEX.get(), 5, 2, 3))
                
                		.build(),
                        builder 
                        .build(),
                Biome.TemperatureModifier.NONE
        );
    }
    
    //new builder
    public static Biome makeJungleBiome(BiomeGenerationSettings.Builder builder) {
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
                    .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE))
                    .build(),
                new MobSpawnSettings.Builder()
                	.creatureGenerationProbability(0.25F)
                	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.MOONSNAIL.get(), 20, 1, 2))
                	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.ARCHFISH.get(), 40, 3, 5))
                	.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.PHYREX.get(), 10, 1, 2))
                	.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.HEX.get(), 5, 2, 3))
                
                		.build(),
                        builder 
                        .build(),
                Biome.TemperatureModifier.NONE
        );
    }
    
    //new builder
    public static Biome makeFrozenBiome(BiomeGenerationSettings.Builder builder) {
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
                    .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FROZEN_PEAKS))
                    .build(),
                new MobSpawnSettings.Builder()
                	.creatureGenerationProbability(0.25F)
                	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.MOONCOW.get(), 80, 2, 4))
                	.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.PHYREX.get(), 10, 1, 2))
                	.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.HEX.get(), 5, 2, 3))
                
                		.build(),
                        builder 
                        .build(),
                Biome.TemperatureModifier.FROZEN
        );
    }

    public static Biome makePlainsBiome(BiomeGenerationSettings.Builder builder) {
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
                    .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_GAME))
                    .build(),
                new MobSpawnSettings.Builder()
            	.creatureGenerationProbability(0.25F)
            	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.MOONCOW.get(), 40, 1, 2))
            	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.ARCHFISH.get(), 10, 3, 5))
            	.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.PHYREX.get(), 10, 1, 1))
            	.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.LUNARSLEEPER.get(), 5, 1, 1))
            
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
            	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.MOONCOW.get(), 10, 1, 2))
            	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.ARCHFISH.get(), 40, 3, 5))
            	.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.LUNARSLEEPER.get(), 10, 1, 1))
            
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
            	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.MOONCOW.get(), 50, 2, 3))
            	.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.ARCHFISH.get(), 40, 3, 5))
            	.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.HEX.get(), 10, 2, 3))
            
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