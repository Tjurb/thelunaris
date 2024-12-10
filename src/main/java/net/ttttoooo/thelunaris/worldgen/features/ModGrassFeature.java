package net.ttttoooo.thelunaris.worldgen.features;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class ModGrassFeature extends Feature<NoneFeatureConfiguration> {
    public ModGrassFeature() {
        super(NoneFeatureConfiguration.CODEC);
    }

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> p_159749_) {
		return false;
	}
}
