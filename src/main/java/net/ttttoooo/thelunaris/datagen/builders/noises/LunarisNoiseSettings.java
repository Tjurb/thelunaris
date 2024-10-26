package net.ttttoooo.thelunaris.datagen.builders.noises;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.datagen.builders.LunarisNoiseBuilder;

public class LunarisNoiseSettings {
    public static final ResourceKey<NoiseGeneratorSettings> LUNA = createKey("luna");

    private static ResourceKey<NoiseGeneratorSettings> createKey(String name) {
        return ResourceKey.create(Registries.NOISE_SETTINGS, new ResourceLocation(TheLunaris.MODID, name));
    }

    public static void bootstrap(BootstapContext<NoiseGeneratorSettings> context) {
        HolderGetter<DensityFunction> densityFunctions = context.lookup(Registries.DENSITY_FUNCTION);
        HolderGetter<NormalNoise.NoiseParameters> noise = context.lookup(Registries.NOISE);
        
        context.register(LUNA, LunarisNoiseBuilder.lunaNoiseSettings(context, densityFunctions, noise));
    }
}