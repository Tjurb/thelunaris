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
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.worldgen.biomes.ModBiomes;

public class ModDimensions {
	public static final ResourceKey<LevelStem> LUNARIS_KEY = ResourceKey.create(Registries.LEVEL_STEM, 
			new ResourceLocation(TheLunaris.MODID, "lunarisdim"));
	public static final ResourceKey<Level> LUNARIS_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION, 
			new ResourceLocation(TheLunaris.MODID, "lunarisdim"));
	public static final ResourceKey<DimensionType> LUNARIS_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, 
			new ResourceLocation(TheLunaris.MODID, "lunarisdim_type"));
	
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
                0, // minY
                256, // height
                256, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                BuiltinDimensionTypes.OVERWORLD_EFFECTS, // effectsLocation
                1.0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)));
    }
}