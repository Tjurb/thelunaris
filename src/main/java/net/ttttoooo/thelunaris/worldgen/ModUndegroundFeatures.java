package net.ttttoooo.thelunaris.worldgen;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.worldgen.features.ModGrassFeature;
import net.ttttoooo.thelunaris.worldgen.features.ModTreeFeature;

public class ModUndegroundFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, TheLunaris.MODID);

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> UNDERGROUND_GRASS = FEATURES.register("underground_grass", ModGrassFeature::new);
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> UNDERGROUND_TREE = FEATURES.register("underground_tree", ModTreeFeature::new);
}
