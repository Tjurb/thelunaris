package net.ttttoooo.thelunaris.datagen.builders;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.block.ModBlocks;
import net.ttttoooo.thelunaris.datagen.builders.noises.LunarisDensityFunctions;
import net.ttttoooo.thelunaris.datagen.builders.noises.LunarisNoise;
import net.ttttoooo.thelunaris.worldgen.dimension.ModSurfaceRules;

import java.util.List;
import java.util.stream.Stream;

public class LunarisNoiseBuilder {

    public static NoiseGeneratorSettings lunaNoiseSettings(BootstapContext<NoiseGeneratorSettings> context, HolderGetter<DensityFunction> densityFunctions, HolderGetter<NormalNoise.NoiseParameters> noise) {
        BlockState vailstone = ModBlocks.VAILSTONE.get().defaultBlockState();
        return new NoiseGeneratorSettings(
                new NoiseSettings(-64, 384, 2, 1), // noiseSettings
                vailstone, // defaultBlock
                Blocks.WATER.defaultBlockState(), // defaultFluid
                makeNoiseRouter(context, densityFunctions, noise), // noiseRouter
                ModSurfaceRules.makeRules(), // surfaceRule
                List.of(), // spawnTarget
                63, // seaLevel
                false, // disableMobGeneration
                true, // aquifersEnabled
                true, // oreVeinsEnabled
                false  // useLegacyRandomSource
        );
    }

    private static NoiseRouter makeNoiseRouter(BootstapContext<NoiseGeneratorSettings> context, HolderGetter<DensityFunction> densityFunctions, HolderGetter<NormalNoise.NoiseParameters> noise) {
        return createNoiseRouter(densityFunctions, noise);
    }
    
    private static DensityFunction buildFinalDensity(DensityFunction p_224493_) {
       DensityFunction densityfunction = DensityFunctions.blendDensity(p_224493_);
       return DensityFunctions.mul(DensityFunctions.interpolated(densityfunction), DensityFunctions.constant(0.64D)).squeeze();
    }
    
    //[CODE COPY] - {@link NoiseRouterData#overworld(HolderGetter, HolderGetter, DensityFunction)}.<br><br>
    //Logic that called {@link NoiseRouterData#postProcess(DensityFunction)} has been moved to {@link NoisesBuilder#buildFinalDensity(HolderGetter)}.
    private static NoiseRouter createNoiseRouter(HolderGetter<DensityFunction> densityFunctions, HolderGetter<NormalNoise.NoiseParameters> noise) {

    	//Disable for testing
        DensityFunction aquiferbarrier = DensityFunctions.noise(noise.getOrThrow(LunarisNoise.AQUIFERBARRIER), 0.5);
    	DensityFunction aquiferflood = DensityFunctions.noise(noise.getOrThrow(LunarisNoise.AQUIFERFLOOD), 0.67D);
    	DensityFunction aquiferspread = DensityFunctions.noise(noise.getOrThrow(LunarisNoise.AQUIFERSPREAD), 0.7142857142857143D);
    	DensityFunction aquiferlava = DensityFunctions.noise(noise.getOrThrow(LunarisNoise.AQUIFERLAVA));
        
    	DensityFunction shiftX = getFunction(densityFunctions, LunarisDensityFunctions.SHIFT_X);
        DensityFunction shiftZ = getFunction(densityFunctions, LunarisDensityFunctions.SHIFT_Z);
       
        DensityFunction temperature = DensityFunctions.shiftedNoise2d(shiftX, shiftZ, 0.25, noise.getOrThrow(Noises.TEMPERATURE));
        DensityFunction vegetation = DensityFunctions.shiftedNoise2d(shiftX, shiftZ, 0.25, noise.getOrThrow(Noises.VEGETATION));

        DensityFunction factor = getFunction(densityFunctions, NoiseRouterData.FACTOR);
        DensityFunction depth = getFunction(densityFunctions, NoiseRouterData.DEPTH);
        
        DensityFunction continentalness = getFunction(densityFunctions, NoiseRouterData.CONTINENTS);
        DensityFunction erosion = getFunction(densityFunctions, NoiseRouterData.EROSION);
        DensityFunction ridges = getFunction(densityFunctions, NoiseRouterData.RIDGES);
        
        DensityFunction densityfunction10 = LunarisDensityFunctions.noiseGradientDensity(DensityFunctions.cache2d(factor), depth);
        
        DensityFunction slopedcheese = getFunction(densityFunctions, LunarisDensityFunctions.SLOPED_CHEESE);
        DensityFunction entrances = DensityFunctions.min(slopedcheese, DensityFunctions.mul(DensityFunctions.constant(5.0D), getFunction(densityFunctions, LunarisDensityFunctions.ENTRANCES)));
        DensityFunction underground = DensityFunctions.rangeChoice(slopedcheese, -1000000.0D, 1.5625D, entrances, LunarisDensityFunctions.underground(densityFunctions, noise, slopedcheese));
        DensityFunction finaldensity = DensityFunctions.min(buildFinalDensity(LunarisDensityFunctions.slideLunaris(underground)), getFunction(densityFunctions, LunarisDensityFunctions.NOODLE));

        int i = 192;
        int j = -60;
        
        DensityFunction oreveins = DensityFunctions.zero();
        float f = 4.0F;
        DensityFunction oreveinAB = DensityFunctions.zero();
        DensityFunction oregap = DensityFunctions.zero();
        
        return new NoiseRouter(
        		aquiferbarrier, // barrier noise
        		aquiferflood, // fluid level floodedness noise
                aquiferspread, // fluid level spread noise
                aquiferlava, // lava noise
                temperature, // temperature
                vegetation, // vegetation
                continentalness, // continentalness noise
                erosion, // erosion noise
                depth, // depth
                ridges, // ridges
                LunarisDensityFunctions.slideLunaris(DensityFunctions.add(densityfunction10, DensityFunctions.constant(-0.703125D)).clamp(-64.0D, 64.0D)),
                // initial density without jaggedness, not sure if this is needed. Some vanilla dimensions use this while others don't.
                finaldensity, // finaldensity
                oreveins, // veinToggle
                oreveinAB, // veinRidged
                oregap); // veinGap
    }

    private static DensityFunction getFunction(HolderGetter<DensityFunction> densityFunctions, ResourceKey<DensityFunction> key) {
        return new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(key));
    }
}