package net.ttttoooo.thelunaris.worldgen;

import java.util.List;
import java.util.OptionalInt;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.HugeFungusConfiguration;
import net.minecraft.world.level.levelgen.feature.HugeFungusFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NetherForestVegetationConfig;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.DarkOakFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.DarkOakTrunkPlacer;
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
	public static final ResourceKey<ConfiguredFeature<?,?>> LUNARIS_COAL_ORE_KEY = registerKey("lunaris_coal_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> LUNARIS_LARGE_MOONSTEEL_ORE_KEY = registerKey("large_moonsteel_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> LUNARIS_LARGE_LABRADORITE_ORE_KEY = registerKey("large_labradorite_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> LUNARIS_LARGE_LUNARITE_ORE_KEY = registerKey("large_lunarite_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> LUNARIS_LARGE_COAL_ORE_KEY = registerKey("large_lunaris_coal_ore");
	
	//deep ore keys
	public static final ResourceKey<ConfiguredFeature<?,?>> LUNARIS_DEEP_MOONSTEEL_ORE_KEY = registerKey("deep_moonsteel_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> LUNARIS_DEEP_LABRADORITE_ORE_KEY = registerKey("deep_labradorite_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> LUNARIS_DEEP_LUNARITE_ORE_KEY = registerKey("deep_lunarite_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> LUNARIS_DEEP_COAL_ORE_KEY = registerKey("deep_lunaris_coal_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> LUNARIS_DEEP_LARGE_MOONSTEEL_ORE_KEY = registerKey("large_deep_moonsteel_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> LUNARIS_DEEP_LARGE_LABRADORITE_ORE_KEY = registerKey("large_deep_labradorite_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> LUNARIS_DEEP_LARGE_LUNARITE_ORE_KEY = registerKey("large_deep_lunarite_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> LUNARIS_DEEP_LARGE_COAL_ORE_KEY = registerKey("large_deep_lunaris_coal_ore");
	
	//misc stone generation
	public static final ResourceKey<ConfiguredFeature<?,?>> MARBLE_KEY = registerKey("marble");
	public static final ResourceKey<ConfiguredFeature<?,?>> LUNARSHALE_KEY = registerKey("lunarshale");
	public static final ResourceKey<ConfiguredFeature<?,?>> LUNARSLATE_KEY = registerKey("lunarslate");
	public static final ResourceKey<ConfiguredFeature<?,?>> LUNAR_CLAY_KEY = registerKey("lunarclay");

	public static final ResourceKey<ConfiguredFeature<?,?>> DEEP_MARBLE_KEY = registerKey("deep_marble");
	public static final ResourceKey<ConfiguredFeature<?,?>> DEEP_LUNARSHALE_KEY = registerKey("deep_lunarshale");
	public static final ResourceKey<ConfiguredFeature<?,?>> DEEP_LUNARSLATE_KEY = registerKey("deep_lunarslate");
	
	//tree keys
	public static final ResourceKey<ConfiguredFeature<?, ?>> CELEST_KEY = registerKey("celest");
	public static final ResourceKey<ConfiguredFeature<?, ?>> STELLAR_KEY = registerKey("stellar");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SKYOAK_KEY = registerKey("skyoak");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_CELEST_KEY = registerKey("large_celest");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_STELLAR_KEY = registerKey("large_stellar");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_SKYOAK_KEY = registerKey("large_skyoak");
	
	//deep keys
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEEP_CELEST_KEY = registerKey("deep_celest");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEEP_STELLAR_KEY = registerKey("deep_stellar");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CRIMSONGRASS_PATCH_KEY = registerKey("crimson_lungrass_patch");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DUSKLIGHTGRASS_PATCH_KEY = registerKey("dusklight_lungrass_patch");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SINGLE_PIECE_OF_CRIMSON = registerKey("crimson_lungrass_single");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SINGLE_PIECE_OF_DUSKLIGHT = registerKey("dusklight_lungrass_single");
	
	//vegetation keys
	public static final ResourceKey<ConfiguredFeature<?, ?>> LUNARIS_GRASS_PATCH_KEY = registerKey("lunaris_lungrass_patch");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_LUNARIS_GRASS_PATCH_KEY = registerKey("tall_lungrass_patch");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LUNARIS_SARROT_PATCH_KEY = registerKey("lunaris_sarrot_patch");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LUNARIS_BERRY_PATCH_KEY = registerKey("lunaris_berry_patch");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SINGLE_PIECE_OF_LUNGRASS = registerKey("lunaris_lungrass_single");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SINGLE_PIECE_OF_SARROT = registerKey("lunaris_sarrot_single");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SINGLE_PIECE_OF_BERRY = registerKey("lunaris_berry_single");
	
	//flower key
	public static final ResourceKey<ConfiguredFeature<?, ?>> LUNARIS_FLOWER_DEFAULT_KEY = registerKey("lunaris_flower_defaulte");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LUNARIS_FLOWER_DESERT_KEY = registerKey("lunaris_flower_desert");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LUNARIS_FLOWER_MOUNTAIN_KEY = registerKey("lunaris_flower_moiuntain");
	
	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
		//ore register
		RuleTest vstoneReplaceable = new TagMatchTest(ModTags.Blocks.VAILSTONE_ORE_REPLACEABLES);
		RuleTest gneissReplaceable = new TagMatchTest(ModTags.Blocks.GNEISS_ORE_REPLACEABLES);
		RuleTest sandDirtReplaceable = new TagMatchTest(ModTags.Blocks.SANDDIRT_REPLACEABLES);
		
		//ores
        List<OreConfiguration.TargetBlockState> lunarismoonsteelore = List.of(OreConfiguration.target(vstoneReplaceable,
                ModBlocks.MOONSTEEL_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> lunarislabradoriteore = List.of(OreConfiguration.target(vstoneReplaceable,
                ModBlocks.LABRADORITE_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> lunarislunariteore = List.of(OreConfiguration.target(vstoneReplaceable,
                ModBlocks.LUNARITE_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> lunariscoalore = List.of(OreConfiguration.target(vstoneReplaceable,
                ModBlocks.LUNARIS_COAL_ORE.get().defaultBlockState()));
        
        register(context, LUNARIS_MOONSTEEL_ORE_KEY, Feature.ORE, new OreConfiguration(lunarismoonsteelore, 9));
        register(context, LUNARIS_LABRADORITE_ORE_KEY, Feature.ORE, new OreConfiguration(lunarislabradoriteore, 9));
        register(context, LUNARIS_LUNARITE_ORE_KEY, Feature.ORE, new OreConfiguration(lunarislunariteore, 9));
        register(context, LUNARIS_COAL_ORE_KEY, Feature.ORE, new OreConfiguration(lunariscoalore, 9));
        register(context, LUNARIS_LARGE_MOONSTEEL_ORE_KEY, Feature.ORE, new OreConfiguration(lunarismoonsteelore, 9));
        register(context, LUNARIS_LARGE_LABRADORITE_ORE_KEY, Feature.ORE, new OreConfiguration(lunarislabradoriteore, 9));
        register(context, LUNARIS_LARGE_LUNARITE_ORE_KEY, Feature.ORE, new OreConfiguration(lunarislunariteore, 9));
        register(context, LUNARIS_LARGE_COAL_ORE_KEY, Feature.ORE, new OreConfiguration(lunariscoalore, 9));
        
		//deep ores
        List<OreConfiguration.TargetBlockState> deeplunarismoonsteelore = List.of(OreConfiguration.target(gneissReplaceable,
                ModBlocks.DEEP_MOONSTEEL_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> deeplunarislabradoriteore = List.of(OreConfiguration.target(gneissReplaceable,
                ModBlocks.DEEP_LABRADORITE_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> deeplunarislunariteore = List.of(OreConfiguration.target(gneissReplaceable,
                ModBlocks.DEEP_LUNARITE_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> deeplunariscoalore = List.of(OreConfiguration.target(gneissReplaceable,
                ModBlocks.DEEP_LUNARIS_COAL_ORE.get().defaultBlockState()));
        
        register(context, LUNARIS_DEEP_MOONSTEEL_ORE_KEY, Feature.ORE, new OreConfiguration(deeplunarismoonsteelore, 9));
        register(context, LUNARIS_DEEP_LABRADORITE_ORE_KEY, Feature.ORE, new OreConfiguration(deeplunarislabradoriteore, 9));
        register(context, LUNARIS_DEEP_LUNARITE_ORE_KEY, Feature.ORE, new OreConfiguration(deeplunarislunariteore, 9));
        register(context, LUNARIS_DEEP_COAL_ORE_KEY, Feature.ORE, new OreConfiguration(deeplunariscoalore, 9));
        register(context, LUNARIS_DEEP_LARGE_MOONSTEEL_ORE_KEY, Feature.ORE, new OreConfiguration(deeplunarismoonsteelore, 9));
        register(context, LUNARIS_DEEP_LARGE_LABRADORITE_ORE_KEY, Feature.ORE, new OreConfiguration(deeplunarislabradoriteore, 9));
        register(context, LUNARIS_DEEP_LARGE_LUNARITE_ORE_KEY, Feature.ORE, new OreConfiguration(deeplunarislunariteore, 9));
        register(context, LUNARIS_DEEP_LARGE_COAL_ORE_KEY, Feature.ORE, new OreConfiguration(deeplunariscoalore, 9));

        //misc Stone register
        List<OreConfiguration.TargetBlockState> marble = List.of(OreConfiguration.target(vstoneReplaceable,
                ModBlocks.MARBLE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> shale = List.of(OreConfiguration.target(vstoneReplaceable,
                ModBlocks.LUNARSHALE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> slate = List.of(OreConfiguration.target(vstoneReplaceable,
                ModBlocks.LUNARSLATE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> deepMarble = List.of(OreConfiguration.target(gneissReplaceable,
                ModBlocks.MARBLE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> deepShale = List.of(OreConfiguration.target(gneissReplaceable,
                ModBlocks.LUNARSHALE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> deepSlate = List.of(OreConfiguration.target(gneissReplaceable,
                ModBlocks.LUNARSLATE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> clay = List.of(OreConfiguration.target(sandDirtReplaceable,
                ModBlocks.LUNCLAY_BLOCK.get().defaultBlockState()));
        
        register(context, MARBLE_KEY, Feature.ORE, new OreConfiguration(marble, 16));
        register(context, LUNARSHALE_KEY, Feature.ORE, new OreConfiguration(shale, 32));
        register(context, LUNARSLATE_KEY, Feature.ORE, new OreConfiguration(slate, 16));
        register(context, LUNAR_CLAY_KEY, Feature.ORE, new OreConfiguration(clay, 16));

        register(context, DEEP_MARBLE_KEY, Feature.ORE, new OreConfiguration(deepMarble, 32));
        register(context, DEEP_LUNARSHALE_KEY, Feature.ORE, new OreConfiguration(deepShale, 8));
        register(context, DEEP_LUNARSLATE_KEY, Feature.ORE, new OreConfiguration(deepSlate, 16));
		
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

        register(context, DEEP_CELEST_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
        		BlockStateProvider.simple(ModBlocks.CELEST_LOG.get()),
        		new StraightTrunkPlacer(2, 2, 3),
        		new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
        				.add(ModBlocks.CELEST_LEAVES.get().defaultBlockState(), 3)
        				.add(ModBlocks.GLOWING_CELEST_LEAVES.get().defaultBlockState(), 1)),
        		new BlobFoliagePlacer(ConstantInt.of(4), ConstantInt.of(2), 2),
        		new TwoLayersFeatureSize(2, 0, 2)).build());

        register(context, DEEP_STELLAR_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
        		BlockStateProvider.simple(ModBlocks.STELLAR_LOG.get()),
        		new StraightTrunkPlacer(2, 2, 3),
        		new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
        				.add(ModBlocks.STELLAR_LEAVES.get().defaultBlockState(), 3)
        				.add(ModBlocks.GLOWING_STELLAR_LEAVES.get().defaultBlockState(), 1)),
        		new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),
        		new TwoLayersFeatureSize(2, 0, 2)).build());
        

        register(context, LARGE_CELEST_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
        		BlockStateProvider.simple(ModBlocks.CELEST_LOG.get()),
        		new DarkOakTrunkPlacer(5, 2, 2),
        		BlockStateProvider.simple(ModBlocks.CELEST_LEAVES.get()),
        		new DarkOakFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)),
        		new ThreeLayersFeatureSize(2, 2, 0, 2, 2, OptionalInt.empty())).build());
        
        register(context, LARGE_STELLAR_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
        		BlockStateProvider.simple(ModBlocks.STELLAR_LOG.get()),
        		new DarkOakTrunkPlacer(4, 2, 2),
        		BlockStateProvider.simple(ModBlocks.STELLAR_LEAVES.get()),
        		new DarkOakFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)),
        		new ThreeLayersFeatureSize(2, 2, 0, 2, 2, OptionalInt.empty())).build());
        
        register(context, LARGE_SKYOAK_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
        		BlockStateProvider.simple(ModBlocks.SKYOAK_LOG.get()),
        		new DarkOakTrunkPlacer(7, 2, 3),
        		new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
        				.add(ModBlocks.SKYOAK_LEAVES.get().defaultBlockState(), 3)
        				.add(ModBlocks.GLOWING_SKYOAK_LEAVES.get().defaultBlockState(), 1)),
        		new DarkOakFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)),
        		new ThreeLayersFeatureSize(2, 2, 0, 2, 2, OptionalInt.empty())).build());
        
        //vegetation register
        register(context, LUNARIS_GRASS_PATCH_KEY, Feature.RANDOM_PATCH,
        		grassPatch(BlockStateProvider.simple(ModBlocks.LUNGRASS.get()), 32));
        register(context, TALL_LUNARIS_GRASS_PATCH_KEY, Feature.RANDOM_PATCH,
        		grassPatch(BlockStateProvider.simple(ModBlocks.TALL_LUNGRASS.get()), 32));
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
        
        //deep vegetation register
        register(context, CRIMSONGRASS_PATCH_KEY, Feature.RANDOM_PATCH, 
        		grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
        				.add(ModBlocks.CRIMSON_LUNGRASS.get().defaultBlockState(), 85)
        				.add(ModBlocks.TALL_CRIMSON_LUNGRASS.get().defaultBlockState(), 15)
        				.add(ModBlocks.CRIMSON_GLOWBUSH.get().defaultBlockState(), 40)
        				.add(ModBlocks.DUSKLIGHT_GLOWBUSH.get().defaultBlockState(), 5)), 64));
        register(context, DUSKLIGHTGRASS_PATCH_KEY, Feature.RANDOM_PATCH,
        		grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
        				.add(ModBlocks.DUSKLIGHT_LUNGRASS.get().defaultBlockState(), 85)
        				.add(ModBlocks.TALL_DUSKLIGHT_LUNGRASS.get().defaultBlockState(), 15)
        				.add(ModBlocks.DUSKLIGHT_GLOWBUSH.get().defaultBlockState(), 40)
        				.add(ModBlocks.CRIMSON_GLOWBUSH.get().defaultBlockState(), 5)), 64));

        register(context, SINGLE_PIECE_OF_CRIMSON, Feature.SIMPLE_BLOCK, 
        		new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CRIMSON_LUNGRASS.get().defaultBlockState())));
        register(context, SINGLE_PIECE_OF_DUSKLIGHT, Feature.SIMPLE_BLOCK, 
        		new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.DUSKLIGHT_LUNGRASS.get().defaultBlockState())));
        
        //flower register
        register(context, LUNARIS_FLOWER_DEFAULT_KEY, Feature.FLOWER, 
        		grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
        				.add(ModBlocks.ORANGEYE.get().defaultBlockState(), 2)
        				.add(ModBlocks.CYANEYE.get().defaultBlockState(), 2)
        				.add(ModBlocks.MAGENTEYE.get().defaultBlockState(), 2)
        				.add(ModBlocks.WILD_LOONBERRY.get().defaultBlockState(), 1)), 64));
        register(context, LUNARIS_FLOWER_DESERT_KEY, Feature.FLOWER, 
        		grassPatch(BlockStateProvider.simple(ModBlocks.BRAMBLE.get()), 4));
        register(context, LUNARIS_FLOWER_MOUNTAIN_KEY, Feature.FLOWER, 
        		grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
        				.add(ModBlocks.LUN_CLOVER.get().defaultBlockState(), 3)
        				.add(ModBlocks.WILD_SARROT.get().defaultBlockState(), 1)), 64));
        
        //ocean register
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
