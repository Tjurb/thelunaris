package net.ttttoooo.thelunaris.worldgen.dimension;

import java.util.List;
import java.util.OptionalLong;

import com.mojang.datafixers.util.Pair;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseSettings;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.datagen.builders.noises.LunarisNoiseSettings;
import net.ttttoooo.thelunaris.worldgen.biomes.ModBiomes;

public class ModDimensions {
    public static final ResourceKey<LevelStem> LUNARIS_KEY = ResourceKey.create(Registries.LEVEL_STEM, 
            new ResourceLocation(TheLunaris.MODID, "lunarisdim"));
    public static final ResourceKey<Level> LUNARIS_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION, 
            new ResourceLocation(TheLunaris.MODID, "lunarisdim"));
    public static final ResourceKey<DimensionType> LUNARIS_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, 
            new ResourceLocation(TheLunaris.MODID, "lunarisdim_type"));
    
    // Dimension type registration
    public static void bootstrapType(BootstapContext<DimensionType> context) {
        context.register(LUNARIS_DIM_TYPE, new DimensionType(
                OptionalLong.of(12000), // fixedTime
                false, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                false, // natural
                1.0, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                -64, // minY
                384, // height
                192, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                BuiltinDimensionTypes.OVERWORLD_EFFECTS, // effectsLocation
                1.0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)));
    }

    // Register dimension stem with custom noise settings
    public static void bootstrapStem(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);

        // Define your chunk generator
        NoiseBasedChunkGenerator noiseBasedChunkGenerator = new NoiseBasedChunkGenerator(
                MultiNoiseBiomeSource.createFromList(
                        new Climate.ParameterList<>(List.of(
                        		//Depth = 0
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-0.5F, 0.5F), //Temp
                                        		Climate.Parameter.span(-0.5F, 0.5F), //Humidity
                                        		Climate.Parameter.span(-1.05F, -0.19F), //Continentalness
                                        		Climate.Parameter.span(0F, 0.5F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.AZUREITE_OCEAN)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-0.45F, 0.2F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.1F), //Humidity
                                        		Climate.Parameter.span(0F, 1F), //Continentalness
                                        		Climate.Parameter.span(-1F, 1F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(0F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_FORESTS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(0.2F, 0.55F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.1F), //Humidity
                                        		Climate.Parameter.span(0F, 1F), //Continentalness
                                        		Climate.Parameter.span(-1F, 1F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-1F, 0F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_FORESTS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-0.45F, -0.15F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.1F), //Humidity
                                        		Climate.Parameter.span(0F, 1F), //Continentalness
                                        		Climate.Parameter.span(-1F, 1F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-1F, 0F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_FORESTS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-0.15F, 0.2F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.1F), //Humidity
                                        		Climate.Parameter.span(0F, 1F), //Continentalness
                                        		Climate.Parameter.span(-1F, 1F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(0F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_FORESTS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(0.2F, 0.55F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.3F), //Humidity
                                        		Climate.Parameter.span(0F, 1F), //Continentalness
                                        		Climate.Parameter.span(-1F, 1F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_FORESTS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(0.2F, 0.55F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.1F), //Humidity
                                        		Climate.Parameter.span(0F, 1F), //Continentalness
                                        		Climate.Parameter.span(-1F, 1F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-1F, 0F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_FORESTS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-1F, 1F), //Temp
                                        		Climate.Parameter.span(0F, 1F), //Humidity
                                        		Climate.Parameter.span(0F, 1F), //Continentalness
                                        		Climate.Parameter.span(-1F, -0.375F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(0.7F, 1F), //Weirdness
                                        		0.1F), biomeRegistry.getOrThrow(ModBiomes.SKYWORD_MOUNTAINS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-1F, 1F), //Temp
                                        		Climate.Parameter.span(0F, 1F), //Humidity
                                        		Climate.Parameter.span(-0.15F, 1F), //Continentalness
                                        		Climate.Parameter.span(-1F, -0.375F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-0.6F, 0.7F), //Weirdness
                                        		0.1F), biomeRegistry.getOrThrow(ModBiomes.SKYWORD_MOUNTAINS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(0.55F, 1F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(-0.19F, 1F), //Continentalness
                                        		Climate.Parameter.span(0F, 1F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.SLEEPING_SANDS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(0.55F, 1F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(-0.19F, 1F), //Continentalness
                                        		Climate.Parameter.span(0F, 1F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.SLEEPING_SANDS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(0.55F, 1F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(-0.19F, 1F), //Continentalness
                                        		Climate.Parameter.span(0F, 1F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.SLEEPING_SANDS)),
                                
                                //Depth = 1
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-0.5F, 0.5F), //Temp
                                        		Climate.Parameter.span(-0.5F, 0.5F), //Humidity
                                        		Climate.Parameter.span(-1.05F, -0.19F), //Continentalness
                                        		Climate.Parameter.span(0F, 0.5F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.AZUREITE_OCEAN)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-0.45F, 0.2F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.1F), //Humidity
                                        		Climate.Parameter.span(0F, 1F), //Continentalness
                                        		Climate.Parameter.span(-1F, 1F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(0F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_FORESTS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(0.2F, 0.55F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.1F), //Humidity
                                        		Climate.Parameter.span(0F, 1F), //Continentalness
                                        		Climate.Parameter.span(-1F, 1F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-1F, 0F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_FORESTS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-0.45F, -0.15F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.1F), //Humidity
                                        		Climate.Parameter.span(0F, 1F), //Continentalness
                                        		Climate.Parameter.span(-1F, 1F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-1F, 0F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_FORESTS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-0.15F, 0.2F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.1F), //Humidity
                                        		Climate.Parameter.span(0F, 1F), //Continentalness
                                        		Climate.Parameter.span(-1F, 1F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(0F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_FORESTS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(0.2F, 0.55F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.3F), //Humidity
                                        		Climate.Parameter.span(0F, 1F), //Continentalness
                                        		Climate.Parameter.span(-1F, 1F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_FORESTS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(0.2F, 0.55F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.1F), //Humidity
                                        		Climate.Parameter.span(0F, 1F), //Continentalness
                                        		Climate.Parameter.span(-1F, 1F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-1F, 0F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_FORESTS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-1F, 1F), //Temp
                                        		Climate.Parameter.span(0F, 1F), //Humidity
                                        		Climate.Parameter.span(0F, 1F), //Continentalness
                                        		Climate.Parameter.span(-1F, -0.375F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(0.7F, 1F), //Weirdness
                                        		0.1F), biomeRegistry.getOrThrow(ModBiomes.SKYWORD_MOUNTAINS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-1F, 1F), //Temp
                                        		Climate.Parameter.span(0F, 1F), //Humidity
                                        		Climate.Parameter.span(-0.15F, 1F), //Continentalness
                                        		Climate.Parameter.span(-1F, -0.375F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-0.6F, 0.7F), //Weirdness
                                        		0.1F), biomeRegistry.getOrThrow(ModBiomes.SKYWORD_MOUNTAINS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(0.55F, 1F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(-0.19F, 1F), //Continentalness
                                        		Climate.Parameter.span(0F, 1F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.SLEEPING_SANDS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(0.55F, 1F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(-0.19F, 1F), //Continentalness
                                        		Climate.Parameter.span(0F, 1F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.SLEEPING_SANDS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(0.55F, 1F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(-0.19F, 1F), //Continentalness
                                        		Climate.Parameter.span(0F, 1F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.SLEEPING_SANDS))
                                
                        ))),
                noiseGenSettings.getOrThrow(LunarisNoiseSettings.LUNA));
        

        LevelStem stem = new LevelStem(dimTypes.getOrThrow(ModDimensions.LUNARIS_DIM_TYPE), noiseBasedChunkGenerator);

        context.register(LUNARIS_KEY, stem);
    }
}
