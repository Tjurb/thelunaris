package net.ttttoooo.thelunaris.worldgen;

import java.util.List;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.block.ModBlocks;
import net.ttttoooo.thelunaris.util.ModTags;

public class ModConfiguredFeatures {
	public static final ResourceKey<ConfiguredFeature<?,?>> LUNARIS_MOONSTEEL_ORE_KEY = registerKey("moonsteel_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> LUNARIS_LABRADORITE_ORE_KEY = registerKey("labradorite_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> LUNARIS_LUNARITE_ORE_KEY = registerKey("lunarite_ore");
	
	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
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
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(TheLunaris.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
