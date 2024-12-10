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
import net.minecraft.util.valueproviders.UniformInt;
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
                OptionalLong.empty(), // day/night cycle
                true, // hasSkylight
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
                0.0f, // ambientLight
                new DimensionType.MonsterSettings(true, false, UniformInt.of(0, 7), 0)));
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
                        		//Lunaris Ocean Biomes
                        		//Only Determined by Continentalness
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-1F, 1F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(-1.05F, -0.19F), //Continentalness
                                        		Climate.Parameter.span(-1F, 1F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.AZUREITE_OCEAN)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-1F, 1F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(-1.05F, -0.19F), //Continentalness
                                        		Climate.Parameter.span(-1F, 1F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.AZUREITE_OCEAN)),
                                
                                //Lunaris River Biomes 
                                //Continentalness -0.19 ~ 1
                                //Erosion  -1 ~ 1
                                //Weirdness -1 ~ -0.85
                                //Finalized
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-1F, 1F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(-0.19F, 1F), //Continentalness
                                        		Climate.Parameter.span(-1F, 1F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-1F, -0.85F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.SAPPHIRE_RIVER)),
                                
                                //Lunaris Beach Biomes 
                                //Continentalness -0.19 ~ -0.11
                                //Erosion  -0.2225 ~ 1
                                //Determined by Temp
                                //Finalized
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-1F, 0.55F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(-0.19F, -0.11F), //Continentalness
                                        		Climate.Parameter.span(-0.2225F, 1F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.SHIMMERING_COAST)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(0.55F, 1F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(-0.19F, -0.11F), //Continentalness
                                        		Climate.Parameter.span(-0.2225F, 1F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.SLEEPING_SANDS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-1F, 0.55F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(-0.19F, -0.11F), //Continentalness
                                        		Climate.Parameter.span(-0.2225F, 1F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.SHIMMERING_COAST)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(0.55F, 1F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(-0.19F, -0.11F), //Continentalness
                                        		Climate.Parameter.span(-0.2225F, 1F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.SLEEPING_SANDS)),
                               
                                //Lunaris Shattered Biomes 
                                //Continentalness 0.03 ~ 1
                                //Erosion 0.55 ~ 1
                                //Determined by Temp, Humidity, and Weirdness
                                //Placeholders
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-1F, 0.2F), //Temp
                                        		Climate.Parameter.span(-1F, 0.1F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.55F, 1F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_PLAINS)),//WINDSWEPT PLACEHOLDER
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-1F, 0.55F), //Temp
                                        		Climate.Parameter.span(0.1F, 1F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.55F, 1F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_FORESTS)),//WINDSWEPT FOREST & JUNGLE PLACEHOLER
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(0.2F, 0.55F), //Temp
                                        		Climate.Parameter.span(-1F, -0.1F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.55F, 1F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_PLAINS)),//SAVANNA PLACEHOLDER
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-1F, 0.2F), //Temp
                                        		Climate.Parameter.span(-1F, 0.1F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.55F, 1F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_PLAINS)),//WINDSWEPT PLACEHOLDER
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-1F, 0.55F), //Temp
                                        		Climate.Parameter.span(0.1F, 1F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.55F, 1F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_FORESTS)),//WINDSWEPT FOREST & JUNGLE PLACEHOLER
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(0.2F, 0.55F), //Temp
                                        		Climate.Parameter.span(-1F, -0.1F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.55F, 1F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_PLAINS)),//SAVANNA PLACEHOLDER
                                
                                //Finalized
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(0.2F, 0.55F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.1F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.55F, 1F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(0F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_PLAINS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(0.2F, 0.55F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.1F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.55F, 1F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-1F, 0F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_FORESTS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(0.55F, 1F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.55F, 1F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.SLEEPING_SANDS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(0.2F, 0.55F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.1F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.55F, 1F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(0F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_PLAINS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(0.2F, 0.55F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.1F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.55F, 1F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-1F, 0F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_FORESTS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(0.55F, 1F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.55F, 1F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.SLEEPING_SANDS)),
                                
                                //Lunaris Plateau Biomes 
                                //Continentalness 0.03 ~ 0.3 & 0.3 ~ 1
                                //Erosion 0.45 ~ 0.55
                                //Determined by Temp, Humidity, and Weirdness
                                //Placeholders
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(0.55F, 1F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.45F, 0.55F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.SLEEPING_SANDS)),//BADLANDS PLACEHOLDER
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-1F, -0.45F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.45F, 0.55F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_PLAINS)),//SNOWY PLACEHOLDER
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-0.15F, 0.2F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.1F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.45F, 0.55F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_FORESTS)),//JUNGLE PLACEHOLDER
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-0.45F, -0.15F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.1F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.45F, 0.55F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_FORESTS)),//TIAGA PLACEHOLDER
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(0.55F, 1F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.45F, 0.55F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.SLEEPING_SANDS)),//BADLANDS PLACEHOLDER
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-1F, -0.45F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.45F, 0.55F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_PLAINS)),//SNOWY PLACEHOLDER
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-0.15F, 0.2F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.1F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.45F, 0.55F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_FORESTS)),//JUNGLE PLACEHOLDER
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-0.45F, -0.15F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.1F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.45F, 0.55F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_FORESTS)),//TIAGA PLACEHOLDER
                                
                                //Finalized
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-0.45F, 0.55F), //Temp
                                        		Climate.Parameter.span(-1F, -0.1F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.45F, 0.55F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-1F, 1), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_PLAINS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-0.45F, -0.15F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.3F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.45F, 0.55F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(0F, 1), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_PLAINS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-0.15F, 0.2F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.3F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.45F, 0.55F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-1F, 0F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_PLAINS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-0.45F, -0.15F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.3F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.45F, 0.55F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-1F, 0F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_FORESTS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-0.15F, 0.2F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.3F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.45F, 0.55F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(0F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_FORESTS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(0.2F, 0.55F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.3F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.45F, 0.55F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_FORESTS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-0.45F, 0.55F), //Temp
                                        		Climate.Parameter.span(-1F, -0.1F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.45F, 0.55F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-1F, 1), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_PLAINS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-0.45F, -0.15F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.3F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.45F, 0.55F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(0F, 1), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_PLAINS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-0.15F, 0.2F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.3F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.45F, 0.55F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-1F, 0F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_PLAINS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-0.45F, -0.15F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.3F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.45F, 0.55F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-1F, 0F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_FORESTS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-0.15F, 0.2F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.3F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.45F, 0.55F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(0F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_FORESTS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(0.2F, 0.55F), //Temp
                                        		Climate.Parameter.span(-0.1F, 0.3F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(0.45F, 0.55F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_FORESTS)),
                        		
                                //Lunaris Middle Biomes 
                                //Continentalness -0.11 ~ 1
                                //Erosion -0.2225 ~ 0.05
                                //Determined by Temp, Humidity, and Weirdness
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-0.45F, 0.55F), //Temp
                                        		Climate.Parameter.span(-0.35F, 1F), //Humidity
                                        		Climate.Parameter.span(-0.11F, 1F), //Continentalness
                                        		Climate.Parameter.span(-0.2225F, 0.05F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_FORESTS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(0.55F, 1F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(-0.11F, 1F), //Continentalness
                                        		Climate.Parameter.span(-0.2225F, 0.05F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.SLEEPING_SANDS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-0.45F, 0.55F), //Temp
                                        		Climate.Parameter.span(-1F, -0.35F), //Humidity
                                        		Climate.Parameter.span(-0.11F, 1F), //Continentalness
                                        		Climate.Parameter.span(-0.2225F, 0.05F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_PLAINS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-1F, -0.45F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(-0.11F, 1F), //Continentalness
                                        		Climate.Parameter.span(-0.2225F, 0.05F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_PLAINS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-0.45F, 0.55F), //Temp
                                        		Climate.Parameter.span(-0.35F, 1F), //Humidity
                                        		Climate.Parameter.span(-0.11F, 1F), //Continentalness
                                        		Climate.Parameter.span(-0.2225F, 0.05F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_FORESTS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(0.55F, 1F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(-0.11F, 1F), //Continentalness
                                        		Climate.Parameter.span(-0.2225F, 0.05F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.SLEEPING_SANDS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-0.45F, 0.55F), //Temp
                                        		Climate.Parameter.span(-1F, -0.35F), //Humidity
                                        		Climate.Parameter.span(-0.11F, 1F), //Continentalness
                                        		Climate.Parameter.span(-0.2225F, 0.05F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_PLAINS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-1F, -0.45F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(-0.11F, 1F), //Continentalness
                                        		Climate.Parameter.span(-0.2225F, 0.05F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.LUNAR_PLAINS)),
                                
                                
                                //Lunaris Coastal Peaks Biomes 
                                //Continentalness -0.19 ~ 1
                                //Erosion -1 ~ -0.78
                                //Weirdness 0.7 ~ 1
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-1F, 1F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(-0.19F, 1F), //Continentalness
                                        		Climate.Parameter.span(-1F, -0.78F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(0.7F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.SKYWORD_MOUNTAINS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-1F, 1F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(-0.19F, 1F), //Continentalness
                                        		Climate.Parameter.span(-1F, -0.78F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(0.7F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.SKYWORD_MOUNTAINS)),

                                //Lunaris Near Inland Peaks Biomes 
                                //Continentalness -0.11 ~ 1
                                //Erosion -1 ~ -0.78
                                //Weirdness 0.2 ~ 0.7
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-1F, 1F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(-0.11F, 1F), //Continentalness
                                        		Climate.Parameter.span(-1F, -0.78F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(0.2F, 0.7F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.SKYWORD_MOUNTAINS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-1F, 1F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(-0.11F, 1F), //Continentalness
                                        		Climate.Parameter.span(-1F, -0.78F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(0.2F, 0.7F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.SKYWORD_MOUNTAINS)),

                                //Lunaris Mid-Far Inland Peaks Biomes 
                                //Continentalness 0.03 ~ 1
                                //Erosion -1 ~ -0.78
                                //Weirdness -0.6 ~ 0.2
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-1F, 1F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(-1F, -0.78F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-0.6F, 0.2F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.SKYWORD_MOUNTAINS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-1F, 1F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(0.03F, 1F), //Continentalness
                                        		Climate.Parameter.span(-1F, -0.78F), //Erosion
                                        		Climate.Parameter.span(1F, 1F), //Depth
                                        		Climate.Parameter.span(-0.6F, 0.2F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.SKYWORD_MOUNTAINS)),                                
                                
                                //Lunaris Badland Biomes 
                                //Continentalness 0.3 ~ 1
                                //Erosion -0.375~-0.2225
                                //Determined by Temp, Humidity, and Weirdness
                                //Placeholders
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(0.55F, 1F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(0.3F, 1F), //Continentalness
                                        		Climate.Parameter.span(-0.375F, -0.2225F), //Erosion
                                        		Climate.Parameter.span(0F, 0F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.SLEEPING_SANDS)),//BADLANDS PLACEHOLDER
                                
                                //Finalized
                                
                                //Underground Biomes
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-1F, 1F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(-1F, 1F), //Continentalness
                                        		Climate.Parameter.span(-1F, -0.1F), //Erosion
                                        		Climate.Parameter.span(0.2F, 0.9F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.CRIMSON_SHELFS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-1F, 1F), //Temp
                                        		Climate.Parameter.span(0.6F, 1F), //Humidity
                                        		Climate.Parameter.span(-1F, 1F), //Continentalness
                                        		Climate.Parameter.span(-1F, -0.1F), //Erosion
                                        		Climate.Parameter.span(0.2F, 0.9F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.CRIMSON_SHELFS)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-1F, 1F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(-1F, 1F), //Continentalness
                                        		Climate.Parameter.span(-1F, -0.1F), //Erosion
                                        		Climate.Parameter.span(0.2F, 0.9F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.BARREN_DEEP)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-1F, 1F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(0.6F, 1F), //Continentalness
                                        		Climate.Parameter.span(-1F, 0.2F), //Erosion
                                        		Climate.Parameter.span(0.2F, 0.9F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.BARREN_DEEP)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-1F, 1F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(-1F, 1F), //Continentalness
                                        		Climate.Parameter.span(-1F, -0.1F), //Erosion
                                        		Climate.Parameter.span(1F, 1.1F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.DUSKLIGHT_CAVES)),
                                Pair.of(
                                        Climate.parameters(
                                        		Climate.Parameter.span(-1F, 1F), //Temp
                                        		Climate.Parameter.span(-1F, 1F), //Humidity
                                        		Climate.Parameter.span(-1F, 1F), //Continentalness
                                        		Climate.Parameter.span(-1F, -0.3F), //Erosion
                                        		Climate.Parameter.span(1F, 1.1F), //Depth
                                        		Climate.Parameter.span(-1F, 1F), //Weirdness
                                        		0.0F), biomeRegistry.getOrThrow(ModBiomes.DUSKLIGHT_CAVES))
                                
                        ))),
                noiseGenSettings.getOrThrow(LunarisNoiseSettings.LUNA));
        

        LevelStem stem = new LevelStem(dimTypes.getOrThrow(ModDimensions.LUNARIS_DIM_TYPE), noiseBasedChunkGenerator);

        context.register(LUNARIS_KEY, stem);
    }
}
