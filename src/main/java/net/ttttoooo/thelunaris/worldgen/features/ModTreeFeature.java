package net.ttttoooo.thelunaris.worldgen.features;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class ModTreeFeature extends Feature<NoneFeatureConfiguration> {
    public ModTreeFeature() {
        super(NoneFeatureConfiguration.CODEC);
    }

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> p_159749_) {
		return false;
	}
}
