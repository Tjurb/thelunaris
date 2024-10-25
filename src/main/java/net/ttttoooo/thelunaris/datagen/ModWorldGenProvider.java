package net.ttttoooo.thelunaris.datagen;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.datagen.builders.noises.LunarisDensityFunctions;
import net.ttttoooo.thelunaris.datagen.builders.noises.LunarisNoise;
import net.ttttoooo.thelunaris.datagen.builders.noises.LunarisNoiseSettings;
import net.ttttoooo.thelunaris.worldgen.ModConfiguredFeatures;
import net.ttttoooo.thelunaris.worldgen.ModPlacedFeatures;
import net.ttttoooo.thelunaris.worldgen.biomes.ModBiomes;
import net.ttttoooo.thelunaris.worldgen.dimension.ModDimensions;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
    		.add(Registries.CONFIGURED_FEATURE, context -> ModConfiguredFeatures.bootstrap(context))
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(Registries.BIOME, ModBiomes::boostrap)
            .add(Registries.DENSITY_FUNCTION, LunarisDensityFunctions::bootstrap)
            .add(Registries.NOISE, LunarisNoise::bootstrap)
            .add(Registries.NOISE_SETTINGS, LunarisNoiseSettings::bootstrap)
            .add(Registries.DIMENSION_TYPE, ModDimensions::bootstrapType)
            .add(Registries.LEVEL_STEM, ModDimensions::bootstrapStem);

    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(TheLunaris.MODID));
    }
}