package net.ttttoooo.thelunaris.datagen.builders.noises;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.minecraft.world.level.levelgen.synth.NormalNoise.NoiseParameters;
import net.ttttoooo.thelunaris.TheLunaris;

public class LunarisNoise {
	public static final ResourceKey<NoiseParameters> AQUIFERBARRIER = createKey("aquiferbarrier");
	public static final ResourceKey<NoiseParameters> AQUIFERFLOOD = createKey("aquiferflood");
	public static final ResourceKey<NoiseParameters> AQUIFERSPREAD = createKey("aquiferspread");
	public static final ResourceKey<NoiseParameters> AQUIFERLAVA = createKey("aquiferlava");
	public static final ResourceKey<NoiseParameters> TEMPERATURE = createKey("temperature");
	public static final ResourceKey<NoiseParameters> VEGETATION = createKey("vegetation");
	public static final ResourceKey<NoiseParameters> CONTINENTALNESS = createKey("continentalness");
	public static final ResourceKey<NoiseParameters> EROSION = createKey("erosion");
	public static final ResourceKey<NoiseParameters> DEPTH = createKey("depth");
	public static final ResourceKey<NoiseParameters> RIDGE = createKey("ridge");
	public static final ResourceKey<NoiseParameters> FACTOR = createKey("factor");
	public static final ResourceKey<NoiseParameters> JAGGED = createKey("jagged");
	
	private static ResourceKey<NoiseParameters> createKey(String name) {
        return ResourceKey.create(Registries.NOISE, new ResourceLocation(TheLunaris.MODID, name));
    }
	
	public static void bootstrap(BootstapContext<NoiseParameters> context) {
		register(context, AQUIFERBARRIER, -3, 1);
		register(context, AQUIFERFLOOD, -7, 1);
		register(context, AQUIFERSPREAD, -5, 1);
		register(context, AQUIFERLAVA, -1, 1);
		register(context, TEMPERATURE, -8, 5.0, 4.0, 4.0, 9.0, 20.0, 17.0);
		register(context, VEGETATION, -7, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
		register(context, CONTINENTALNESS, -6, -5.0, 4.0, -4.0, 9.0, 0.0, -17.0);
		register(context, EROSION, -4, -10.0, 9.0, -5.0, 4.0, 0.0, 0.0);
		register(context, DEPTH, -4, 5.0, 4.0, 4.0, 9.0, 4.0, 4.0);
		register(context, RIDGE, -7, -1.0, 5.0, 4.0, -4.0, 5.0, 6.0);
		register(context, FACTOR, -7, -1.0, 5.0, 4.0, -4.0, 5.0, 6.0);
		register(context, JAGGED, -16, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0);
    }
	
	public static void register(BootstapContext<NoiseParameters> context, ResourceKey<NormalNoise.NoiseParameters> key, int firstOctave, double firstAmplitude, double... amplitudes) {
		context.register(key, new NormalNoise.NoiseParameters(firstOctave, firstAmplitude, amplitudes));
	}
}