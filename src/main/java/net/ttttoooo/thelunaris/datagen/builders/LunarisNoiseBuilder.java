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
                false, // aquifersEnabled
                true, // oreVeinsEnabled
                false  // useLegacyRandomSource
        );
    }

    private static NoiseRouter makeNoiseRouter(BootstapContext<NoiseGeneratorSettings> context, HolderGetter<DensityFunction> densityFunctions, HolderGetter<NormalNoise.NoiseParameters> noise) {
        return createNoiseRouter(densityFunctions, noise);
    }

    private static DensityFunction buildFinalDensity(HolderGetter<DensityFunction> densityFunctions, DensityFunction densityFunction) {
        DensityFunction density = getFunction(densityFunctions, ResourceKey.create(Registries.DENSITY_FUNCTION, new ResourceLocation(TheLunaris.MODID,"base_3d_noise_lunaris")));
        density = DensityFunctions.add(densityFunction, density);
        return density = DensityFunctions.mul(DensityFunctions.interpolated(density),
        		DensityFunctions.constant(0.62D)).squeeze();
    }
    
    //[CODE COPY] - {@link NoiseRouterData#overworld(HolderGetter, HolderGetter, DensityFunction)}.<br><br>
    //Logic that called {@link NoiseRouterData#postProcess(DensityFunction)} has been moved to {@link LunarisNoiseBuilder#buildFinalDensity(HolderGetter)}.
    private static NoiseRouter createNoiseRouter(HolderGetter<DensityFunction> densityFunctions, HolderGetter<NormalNoise.NoiseParameters> noise) {

    	//Disable for testing
        DensityFunction aquiferbarrier = DensityFunctions.noise(noise.getOrThrow(LunarisNoise.AQUIFERBARRIER), 0.5);
    	DensityFunction aquiferflood = DensityFunctions.noise(noise.getOrThrow(LunarisNoise.AQUIFERFLOOD), 0.67D);
    	DensityFunction aquiferspread = DensityFunctions.noise(noise.getOrThrow(LunarisNoise.AQUIFERSPREAD), 0.7142857142857143D);
    	DensityFunction aquiferlava = DensityFunctions.noise(noise.getOrThrow(LunarisNoise.AQUIFERLAVA));
        
    	DensityFunction shiftX = getFunction(densityFunctions, ResourceKey.create(Registries.DENSITY_FUNCTION, new ResourceLocation("shift_x")));
        DensityFunction shiftZ = getFunction(densityFunctions, ResourceKey.create(Registries.DENSITY_FUNCTION, new ResourceLocation("shift_z")));
       
        DensityFunction temperature = DensityFunctions.shiftedNoise2d(shiftX, shiftZ, 0.25, noise.getOrThrow(LunarisNoise.TEMPERATURE));
        DensityFunction vegetation = DensityFunctions.shiftedNoise2d(shiftX, shiftZ, 0.25, noise.getOrThrow(LunarisNoise.VEGETATION));

        DensityFunction factor = DensityFunctions.noise(noise.getOrThrow(LunarisNoise.FACTOR));
        DensityFunction depth = DensityFunctions.noise(noise.getOrThrow(LunarisNoise.DEPTH));
        
        DensityFunction continentalness = DensityFunctions.noise(noise.getOrThrow(LunarisNoise.CONTINENTALNESS));
        DensityFunction erosion = DensityFunctions.noise( noise.getOrThrow(LunarisNoise.EROSION));
        DensityFunction ridges = DensityFunctions.noise(noise.getOrThrow(LunarisNoise.RIDGE));
        
        DensityFunction densityfunction10 = LunarisDensityFunctions.noiseGradientDensity(DensityFunctions.cache2d(factor), depth);
        
        DensityFunction slopedcheese = getFunction(densityFunctions, LunarisDensityFunctions.SLOPED_CHEESE);
        DensityFunction densityfunction12 = DensityFunctions.min(slopedcheese, DensityFunctions.mul(DensityFunctions.constant(5.0D), getFunction(densityFunctions, LunarisDensityFunctions.ENTRANCES)));
        DensityFunction densityfunction13 = DensityFunctions.rangeChoice(slopedcheese, -1000000.0D, 1.5625D, densityfunction12, LunarisDensityFunctions.underground(densityFunctions, noise, slopedcheese));
        DensityFunction finaldensity = DensityFunctions.min(buildFinalDensity(densityFunctions ,LunarisDensityFunctions.slideLunaris(densityfunction13)), getFunction(densityFunctions, LunarisDensityFunctions.NOODLE));
        
        DensityFunction densityfunction15 = getFunction(densityFunctions, LunarisDensityFunctions.Y);

        int i = 192;
        int j = -60;
        
        DensityFunction oreveins = LunarisDensityFunctions.yLimitedInterpolatable(densityfunction15, DensityFunctions.noise(noise.getOrThrow(Noises.ORE_VEININESS), 1.5D, 1.5D), i, j, 0);
        float f = 4.0F;
        DensityFunction oreveinA = LunarisDensityFunctions.yLimitedInterpolatable(densityfunction15, DensityFunctions.noise(noise.getOrThrow(Noises.ORE_VEIN_A), 4.0D, 4.0D), i, j, 0).abs();
        DensityFunction oreveinB = LunarisDensityFunctions.yLimitedInterpolatable(densityfunction15, DensityFunctions.noise(noise.getOrThrow(Noises.ORE_VEIN_B), 4.0D, 4.0D), i, j, 0).abs();
        DensityFunction oreveinAB = DensityFunctions.add(DensityFunctions.constant((double)-0.08F), DensityFunctions.max(oreveinA, oreveinB));
        DensityFunction oregap = DensityFunctions.noise(noise.getOrThrow(Noises.ORE_GAP));
        
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