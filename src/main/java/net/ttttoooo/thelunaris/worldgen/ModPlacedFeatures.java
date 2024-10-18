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
	public static final ResourceKey<PlacedFeature> CELEST_PLACED_KEY = registerKey("celest_placed");
	public static final ResourceKey<PlacedFeature> STELLAR_PLACED_KEY = registerKey("stellar_placed");
	public static final ResourceKey<PlacedFeature> SKYOAK_PLACED_KEY = registerKey("skyoak_placed");

	public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        
        register(context, CELEST_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CELEST_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        ModBlocks.CELEST_SAPLING.get()));
        register(context, STELLAR_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STELLAR_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        ModBlocks.STELLAR_SAPLING.get()));
        register(context, SKYOAK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SKYOAK_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
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