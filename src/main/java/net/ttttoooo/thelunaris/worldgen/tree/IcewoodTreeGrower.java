package net.ttttoooo.thelunaris.worldgen.tree;

import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import org.jetbrains.annotations.Nullable;

import net.ttttoooo.thelunaris.worldgen.ModConfiguredFeatures;

public class IcewoodTreeGrower extends AbstractMegaTreeGrower{
	@Nullable
	@Override
	protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pHasFlowers) {
		if (pRandom.nextInt(10) == 0) {
	         return pHasFlowers ? ModConfiguredFeatures.ICEWOOD_KEY : ModConfiguredFeatures.ICEWOOD_KEY;
	      } else {
	         return pHasFlowers ? ModConfiguredFeatures.DEEP_ICEWOOD_KEY : ModConfiguredFeatures.DEEP_ICEWOOD_KEY;
	      }
	}
	
	@Override
	protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource p_222904_) {
		return ModConfiguredFeatures.TALL_ICEWOOD_KEY;
	}
}
