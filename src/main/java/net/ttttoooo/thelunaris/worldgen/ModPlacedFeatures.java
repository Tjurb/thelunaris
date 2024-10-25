package net.ttttoooo.thelunaris.worldgen;

import java.util.List;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.block.ModBlocks;

public class ModPlacedFeatures {
	//orekeys
	public static final ResourceKey<PlacedFeature> LUNARIS_MOONSTEEL_ORE_PLACED_KEY = registerKey("moonsteel_ore_placed");
	public static final ResourceKey<PlacedFeature> LUNARIS_LABRADORITE_ORE_PLACED_KEY = registerKey("labradorite_ore_placed");
	public static final ResourceKey<PlacedFeature> LUNARIS_LUNARITE_ORE_PLACED_KEY = registerKey("lunarite_ore_placed");
	
	//tree keys
	public static final ResourceKey<PlacedFeature> CELEST_PLACED_KEY = registerKey("celest_placed");
	public static final ResourceKey<PlacedFeature> STELLAR_PLACED_KEY = registerKey("stellar_placed");
	public static final ResourceKey<PlacedFeature> SKYOAK_PLACED_KEY = registerKey("skyoak_placed");

	public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        //ore register
        register(context, LUNARIS_MOONSTEEL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LUNARIS_MOONSTEEL_ORE_KEY),
                ModOrePlacement.commonOrePlacement(15,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, LUNARIS_LABRADORITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LUNARIS_LABRADORITE_ORE_KEY),
                ModOrePlacement.rareOrePlacement(5,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, LUNARIS_LUNARITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LUNARIS_LUNARITE_ORE_KEY),
                ModOrePlacement.rareOrePlacement(5,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        
        //tree register
        register(context, CELEST_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CELEST_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 3),
                        ModBlocks.CELEST_SAPLING.get()));
        register(context, STELLAR_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STELLAR_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.2f, 2),
                        ModBlocks.STELLAR_SAPLING.get()));
        register(context, SKYOAK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SKYOAK_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.2f, 4),
                        ModBlocks.SKYOAK_SAPLING.get()));
    }
	
    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(TheLunaris.MODID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}