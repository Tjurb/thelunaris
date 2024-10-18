package net.ttttoooo.thelunaris.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.block.ModBlocks;

public class ModConfiguredFeatures {
	public static final ResourceKey<ConfiguredFeature<?, ?>> CELEST_KEY = registerKey("celest");
	public static final ResourceKey<ConfiguredFeature<?, ?>> STELLAR_KEY = registerKey("stellar");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SKYOAK_KEY = registerKey("skyoak");
	
	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        register(context, CELEST_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
        		BlockStateProvider.simple(ModBlocks.CELEST_LOG.get()),
        		new StraightTrunkPlacer(5, 1, 2),
        		BlockStateProvider.simple(ModBlocks.CELEST_LEAVES.get()),
        		new BlobFoliagePlacer(ConstantInt.of(4), ConstantInt.of(2), 2),
        		new TwoLayersFeatureSize(2, 0, 2)).build());
        
        register(context, STELLAR_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
        		BlockStateProvider.simple(ModBlocks.STELLAR_LOG.get()),
        		new StraightTrunkPlacer(3, 1, 2),
        		BlockStateProvider.simple(ModBlocks.STELLAR_LEAVES.get()),
        		new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),
        		new TwoLayersFeatureSize(2, 0, 2)).build());
        
        register(context, SKYOAK_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
        		BlockStateProvider.simple(ModBlocks.SKYOAK_LOG.get()),
        		new StraightTrunkPlacer(4, 1, 3),
        		BlockStateProvider.simple(ModBlocks.SKYOAK_LEAVES.get()),
        		new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 4),
        		new TwoLayersFeatureSize(2, 0, 2)).build());
    }

	public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(TheLunaris.MODID, name));
	}
	   
	private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
			ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
		context.register(key, new ConfiguredFeature<>(feature, configuration));
	}
}
