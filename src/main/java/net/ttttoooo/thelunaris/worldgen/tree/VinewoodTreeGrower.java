package net.ttttoooo.thelunaris.worldgen.tree;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import org.jetbrains.annotations.Nullable;

import net.ttttoooo.thelunaris.worldgen.ModConfiguredFeatures;

public class VinewoodTreeGrower extends AbstractTreeGrower{
	@Nullable
	@Override
	protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pHasFlowers) {
		if (pRandom.nextInt(10) == 0) {
	         return pHasFlowers ? ModConfiguredFeatures.VINEWOOD_KEY : ModConfiguredFeatures.SMALL_VINEWOOD_KEY;
	      } else {
	         return pHasFlowers ? ModConfiguredFeatures.DEEP_VINEWOOD_KEY : ModConfiguredFeatures.TWISTED_VINEWOOD_KEY;
	      }
	}
}
