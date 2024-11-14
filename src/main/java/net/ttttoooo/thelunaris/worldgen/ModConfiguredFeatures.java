package net.ttttoooo.thelunaris.worldgen;

import java.util.List;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.block.ModBlocks;
import net.ttttoooo.thelunaris.util.ModTags;

public class ModConfiguredFeatures {
	//ore keys
	public static final ResourceKey<ConfiguredFeature<?,?>> LUNARIS_MOONSTEEL_ORE_KEY = registerKey("moonsteel_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> LUNARIS_LABRADORITE_ORE_KEY = registerKey("labradorite_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> LUNARIS_LUNARITE_ORE_KEY = registerKey("lunarite_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> LUNARIS_LARGE_MOONSTEEL_ORE_KEY = registerKey("large_moonsteel_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> LUNARIS_LARGE_LABRADORITE_ORE_KEY = registerKey("large_labradorite_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> LUNARIS_LARGE_LUNARITE_ORE_KEY = registerKey("large_lunarite_ore");
	
	//tree keys
	public static final ResourceKey<ConfiguredFeature<?, ?>> CELEST_KEY = registerKey("celest");
	public static final ResourceKey<ConfiguredFeature<?, ?>> STELLAR_KEY = registerKey("stellar");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SKYOAK_KEY = registerKey("skyoak");
	
	//vegetation keys
	public static final ResourceKey<ConfiguredFeature<?, ?>> LUNARIS_GRASS_PATCH_KEY = registerKey("lunaris_lungrass_patch");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LUNARIS_SARROT_PATCH_KEY = registerKey("lunaris_sarrot_patch");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LUNARIS_BERRY_PATCH_KEY = registerKey("lunaris_berry_patch");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SINGLE_PIECE_OF_LUNGRASS = registerKey("lunaris_lungrass_single");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SINGLE_PIECE_OF_SARROT = registerKey("lunaris_sarrot_single");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SINGLE_PIECE_OF_BERRY = registerKey("lunaris_berry_single");
	
	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
		//ore register
		RuleTest vstoneReplaceable = new TagMatchTest(ModTags.Blocks.VAILSTONE_ORE_REPLACEABLES);
		
        List<OreConfiguration.TargetBlockState> lunarismoonsteelore = List.of(OreConfiguration.target(vstoneReplaceable,
                ModBlocks.MOONSTEEL_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> lunarislabradoriteore = List.of(OreConfiguration.target(vstoneReplaceable,
                ModBlocks.LABRADORITE_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> lunarislunariteore = List.of(OreConfiguration.target(vstoneReplaceable,
                ModBlocks.LUNARITE_ORE.get().defaultBlockState()));
        
        register(context, LUNARIS_MOONSTEEL_ORE_KEY, Feature.ORE, new OreConfiguration(lunarismoonsteelore, 9));
        register(context, LUNARIS_LABRADORITE_ORE_KEY, Feature.ORE, new OreConfiguration(lunarislabradoriteore, 9));
        register(context, LUNARIS_LUNARITE_ORE_KEY, Feature.ORE, new OreConfiguration(lunarislunariteore, 9));
        register(context, LUNARIS_LARGE_MOONSTEEL_ORE_KEY, Feature.ORE, new OreConfiguration(lunarismoonsteelore, 9));
        register(context, LUNARIS_LARGE_LABRADORITE_ORE_KEY, Feature.ORE, new OreConfiguration(lunarislabradoriteore, 9));
        register(context, LUNARIS_LARGE_LUNARITE_ORE_KEY, Feature.ORE, new OreConfiguration(lunarislunariteore, 9));

		
        //tree register
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
        
        //vegetation register
        register(context, LUNARIS_GRASS_PATCH_KEY, Feature.RANDOM_PATCH,
        		grassPatch(BlockStateProvider.simple(ModBlocks.LUNGRASS.get()), 32));
        register(context, LUNARIS_SARROT_PATCH_KEY, Feature.RANDOM_PATCH,
        		grassPatch(BlockStateProvider.simple(ModBlocks.WILD_SARROT.get()), 32));
        register(context, LUNARIS_BERRY_PATCH_KEY, Feature.RANDOM_PATCH,
        		grassPatch(BlockStateProvider.simple(ModBlocks.WILD_LOONBERRY.get()), 32));

        register(context, SINGLE_PIECE_OF_LUNGRASS, Feature.SIMPLE_BLOCK, 
        		new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.LUNGRASS.get().defaultBlockState())));
        register(context, SINGLE_PIECE_OF_SARROT, Feature.SIMPLE_BLOCK, 
        		new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WILD_SARROT.get().defaultBlockState())));
        register(context, SINGLE_PIECE_OF_BERRY, Feature.SIMPLE_BLOCK, 
        		new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WILD_LOONBERRY.get().defaultBlockState())));
        }

	public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(TheLunaris.MODID, name));
	}

	private static RandomPatchConfiguration grassPatch(BlockStateProvider p_195203_, int p_195204_) {
	      return FeatureUtils.simpleRandomPatchConfiguration(p_195204_, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(p_195203_)));
	}
	   
	private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
			ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
		context.register(key, new ConfiguredFeature<>(feature, configuration));
	}
}
