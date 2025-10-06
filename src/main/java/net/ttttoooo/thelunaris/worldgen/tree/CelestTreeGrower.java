package net.ttttoooo.thelunaris.worldgen.tree;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import org.jetbrains.annotations.Nullable;

import net.ttttoooo.thelunaris.worldgen.ModConfiguredFeatures;

public class CelestTreeGrower extends AbstractTreeGrower {
	@Nullable
	@Override
	protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pHasFlowers) {
		if (pRandom.nextInt(10) == 0) {
	         return pHasFlowers ? ModConfiguredFeatures.CELEST_KEY : ModConfiguredFeatures.LARGE_CELEST_KEY;
	      } else {
	         return pHasFlowers ? ModConfiguredFeatures.DEEP_CELEST_KEY : ModConfiguredFeatures.DEEP_CELEST_KEY;
	      }
	}
}
