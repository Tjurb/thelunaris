package net.ttttoooo.thelunaris.datagen.builders.noises;


import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import it.unimi.dsi.fastutil.doubles.Double2DoubleFunction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.TerrainProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.synth.BlendedNoise;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.ttttoooo.thelunaris.TheLunaris;

public class LunarisDensityFunctions {
	   public static final float GLOBAL_OFFSET = -0.50375F;
	   public static final int ISLAND_CHUNK_DISTANCE = 64;
	   public static final long ISLAND_CHUNK_DISTANCE_SQR = 4096L;
	private static final DensityFunction BLENDING_FACTOR = DensityFunctions.constant(10.0D);
	private static final DensityFunction BLENDING_JAGGEDNESS = DensityFunctions.zero();
	private static final ResourceKey<DensityFunction> ZERO = createKey("lunaris_zero");
	private static final ResourceKey<DensityFunction> SHIFT_X = createKey("lunaris_shift_x");
	private static final ResourceKey<DensityFunction> SHIFT_Z = createKey("lunaris_shift_z");
    public static final ResourceKey<DensityFunction> BASE_3D_NOISE_LUNARIS = createKey("base_3d_noise_lunaris");
    public static final ResourceKey<DensityFunction> Y = createKey("lunaris_y");
    public static final ResourceKey<DensityFunction> CONTINENTS = createKey("lunaris_continents");
    public static final ResourceKey<DensityFunction> EROSION = createKey("lunaris_erosion");
    public static final ResourceKey<DensityFunction> DEPTH = createKey("lunaris_depth");
    public static final ResourceKey<DensityFunction> FACTOR = createKey("lunaris_factor");
    public static final ResourceKey<DensityFunction> RIDGES = createKey("lunaris_ridges");
    public static final ResourceKey<DensityFunction> RIDGES_FOLDED = createKey("lunaris_ridges_folded");
    public static final ResourceKey<DensityFunction> OFFSET = createKey("lunaris_offset");
    public static final ResourceKey<DensityFunction> JAGGEDNESS = createKey("lunaris_jaggedness");
    public static final ResourceKey<DensityFunction> SLOPED_CHEESE = createKey("lunaris_sloped_cheese");
    public static final ResourceKey<DensityFunction> SPAGHETTI_ROUGHNESS_FUNCTION = createKey("lunaris_spaghetti_roughness_function");
    public static final ResourceKey<DensityFunction> ENTRANCES = createKey("lunaris_entrances");
    public static final ResourceKey<DensityFunction> NOODLE = createKey("lunaris_noodle");
    public static final ResourceKey<DensityFunction> PILLARS = createKey("lunaris_pillars");
    public static final ResourceKey<DensityFunction> SPAGHETTI_2D_THICKNESS_MODULATOR = createKey("lunaris_spaghetti_2d_thickness_modulator");
    public static final ResourceKey<DensityFunction> SPAGHETTI_2D = createKey("lunaris_spaghetti_2d");


    private static ResourceKey<DensityFunction> createKey(String name) {
        return ResourceKey.create(Registries.DENSITY_FUNCTION, new ResourceLocation(TheLunaris.MODID, name));
    }

    public static void bootstrap(BootstapContext<DensityFunction> context) {
        HolderGetter<NormalNoise.NoiseParameters> holdergetter = context.lookup(Registries.NOISE);
        HolderGetter<DensityFunction> holdergetter1 = context.lookup(Registries.DENSITY_FUNCTION);
        context.register(ZERO, DensityFunctions.zero());
    		int i = DimensionType.MIN_Y * 2;
	    	int j = DimensionType.MAX_Y * 2;
	        context.register(Y, DensityFunctions.yClampedGradient(i, j, (double)i, (double)j));
	        DensityFunction densityfunction = registerAndWrap(context, SHIFT_X, DensityFunctions.flatCache(DensityFunctions.cache2d(DensityFunctions.shiftA(holdergetter.getOrThrow(Noises.SHIFT)))));
	        DensityFunction densityfunction1 = registerAndWrap(context, SHIFT_Z, DensityFunctions.flatCache(DensityFunctions.cache2d(DensityFunctions.shiftB(holdergetter.getOrThrow(Noises.SHIFT)))));
	        context.register(BASE_3D_NOISE_LUNARIS, BlendedNoise.createUnseeded(0.25D, 0.125D, 80.0D, 160.0D, 8.0D));
	        Holder<DensityFunction> holder = context.register(CONTINENTS, DensityFunctions.flatCache(DensityFunctions.shiftedNoise2d(densityfunction, densityfunction1, 0.25D, holdergetter.getOrThrow(Noises.CONTINENTALNESS))));
	        Holder<DensityFunction> holder1 = context.register(EROSION, DensityFunctions.flatCache(DensityFunctions.shiftedNoise2d(densityfunction, densityfunction1, 0.25D, holdergetter.getOrThrow(Noises.EROSION))));
	        DensityFunction densityfunction2 = registerAndWrap(context, RIDGES, DensityFunctions.flatCache(DensityFunctions.shiftedNoise2d(densityfunction, densityfunction1, 0.25D, holdergetter.getOrThrow(Noises.RIDGE))));
	        context.register(RIDGES_FOLDED, peaksAndValleys(densityfunction2));
	        DensityFunction densityfunction3 = DensityFunctions.noise(holdergetter.getOrThrow(Noises.JAGGED), 1500.0D, 0.0D);
	        registerTerrainNoises(context, holdergetter1, densityfunction3, holder, holder1, OFFSET, FACTOR, JAGGEDNESS, DEPTH, SLOPED_CHEESE, false);
	        context.register(SPAGHETTI_ROUGHNESS_FUNCTION, spaghettiRoughnessFunction(holdergetter));
	        context.register(SPAGHETTI_2D_THICKNESS_MODULATOR, DensityFunctions.cacheOnce(DensityFunctions.mappedNoise(holdergetter.getOrThrow(Noises.SPAGHETTI_2D_THICKNESS), 2.0D, 1.0D, -0.6D, -1.3D)));
	        context.register(SPAGHETTI_2D, spaghetti2D(holdergetter1, holdergetter));
	        context.register(ENTRANCES, entrances(holdergetter1, holdergetter));
	        context.register(NOODLE, noodle(holdergetter1, holdergetter));
	        context.register(PILLARS, pillars(holdergetter));
	}
    
    private static void registerTerrainNoises(BootstapContext<DensityFunction> p_256336_, HolderGetter<DensityFunction> p_256393_, DensityFunction p_224476_, Holder<DensityFunction> p_224477_, Holder<DensityFunction> p_224478_, ResourceKey<DensityFunction> p_224479_, ResourceKey<DensityFunction> p_224480_, ResourceKey<DensityFunction> p_224481_, ResourceKey<DensityFunction> p_224482_, ResourceKey<DensityFunction> p_224483_, boolean p_224484_) {
        DensityFunctions.Spline.Coordinate densityfunctions$spline$coordinate = new DensityFunctions.Spline.Coordinate(p_224477_);
        DensityFunctions.Spline.Coordinate densityfunctions$spline$coordinate1 = new DensityFunctions.Spline.Coordinate(p_224478_);
        DensityFunctions.Spline.Coordinate densityfunctions$spline$coordinate2 = new DensityFunctions.Spline.Coordinate(p_256393_.getOrThrow(RIDGES));
        DensityFunctions.Spline.Coordinate densityfunctions$spline$coordinate3 = new DensityFunctions.Spline.Coordinate(p_256393_.getOrThrow(RIDGES_FOLDED));
        DensityFunction densityfunction = registerAndWrap(p_256336_, p_224479_, splineWithBlending(DensityFunctions.add(DensityFunctions.constant((double)-0.50375F), DensityFunctions.spline(TerrainProvider.overworldOffset(densityfunctions$spline$coordinate, densityfunctions$spline$coordinate1, densityfunctions$spline$coordinate3, p_224484_))), DensityFunctions.blendOffset()));
        DensityFunction densityfunction1 = registerAndWrap(p_256336_, p_224480_, splineWithBlending(DensityFunctions.spline(TerrainProvider.overworldFactor(densityfunctions$spline$coordinate, densityfunctions$spline$coordinate1, densityfunctions$spline$coordinate2, densityfunctions$spline$coordinate3, p_224484_)), BLENDING_FACTOR));
        DensityFunction densityfunction2 = registerAndWrap(p_256336_, p_224482_, DensityFunctions.add(DensityFunctions.yClampedGradient(-64, 320, 1.5D, -1.5D), densityfunction));
        DensityFunction densityfunction3 = registerAndWrap(p_256336_, p_224481_, splineWithBlending(DensityFunctions.spline(TerrainProvider.overworldJaggedness(densityfunctions$spline$coordinate, densityfunctions$spline$coordinate1, densityfunctions$spline$coordinate2, densityfunctions$spline$coordinate3, p_224484_)), BLENDING_JAGGEDNESS));
        DensityFunction densityfunction4 = DensityFunctions.mul(densityfunction3, p_224476_.halfNegative());
        DensityFunction densityfunction5 = noiseGradientDensity(densityfunction1, DensityFunctions.add(densityfunction2, densityfunction4));
        p_256336_.register(p_224483_, DensityFunctions.add(densityfunction5, getFunction(p_256393_, BASE_3D_NOISE_LUNARIS)));
    }
    
    private static DensityFunction registerAndWrap(BootstapContext<DensityFunction> p_256149_, ResourceKey<DensityFunction> p_255905_, DensityFunction p_255856_) {
       return new DensityFunctions.HolderHolder(p_256149_.register(p_255905_, p_255856_));
    }

    private static DensityFunction getFunction(HolderGetter<DensityFunction> p_256312_, ResourceKey<DensityFunction> p_256077_) {
       return new DensityFunctions.HolderHolder(p_256312_.getOrThrow(p_256077_));
    }

    private static DensityFunction peaksAndValleys(DensityFunction p_224438_) {
       return DensityFunctions.mul(DensityFunctions.add(DensityFunctions.add(p_224438_.abs(), DensityFunctions.constant(-0.6666666666666666D)).abs(), DensityFunctions.constant(-0.3333333333333333D)), DensityFunctions.constant(-3.0D));
    }

    private static DensityFunction spaghettiRoughnessFunction(HolderGetter<NormalNoise.NoiseParameters> p_255763_) {
       DensityFunction densityfunction = DensityFunctions.noise(p_255763_.getOrThrow(Noises.SPAGHETTI_ROUGHNESS));
       DensityFunction densityfunction1 = DensityFunctions.mappedNoise(p_255763_.getOrThrow(Noises.SPAGHETTI_ROUGHNESS_MODULATOR), 0.0D, -0.1D);
       return DensityFunctions.cacheOnce(DensityFunctions.mul(densityfunction1, DensityFunctions.add(densityfunction.abs(), DensityFunctions.constant(-0.4D))));
    }

    private static DensityFunction entrances(HolderGetter<DensityFunction> p_256511_, HolderGetter<NormalNoise.NoiseParameters> p_255899_) {
       DensityFunction densityfunction = DensityFunctions.cacheOnce(DensityFunctions.noise(p_255899_.getOrThrow(Noises.SPAGHETTI_3D_RARITY), 2.0D, 1.0D));
       DensityFunction densityfunction1 = DensityFunctions.mappedNoise(p_255899_.getOrThrow(Noises.SPAGHETTI_3D_THICKNESS), -0.065D, -0.088D);
       DensityFunction densityfunction2 = LunarisDensityFunctions.weirdScaledSampler(densityfunction, p_255899_.getOrThrow(Noises.SPAGHETTI_3D_1), LunarisDensityFunctions.WeirdScaledSampler.RarityValueMapper.TYPE1);
       DensityFunction densityfunction3 = LunarisDensityFunctions.weirdScaledSampler(densityfunction, p_255899_.getOrThrow(Noises.SPAGHETTI_3D_2), LunarisDensityFunctions.WeirdScaledSampler.RarityValueMapper.TYPE1);
       DensityFunction densityfunction4 = DensityFunctions.add(DensityFunctions.max(densityfunction2, densityfunction3), densityfunction1).clamp(-1.0D, 1.0D);
       DensityFunction densityfunction5 = getFunction(p_256511_, SPAGHETTI_ROUGHNESS_FUNCTION);
       DensityFunction densityfunction6 = DensityFunctions.noise(p_255899_.getOrThrow(Noises.CAVE_ENTRANCE), 0.75D, 0.5D);
       DensityFunction densityfunction7 = DensityFunctions.add(DensityFunctions.add(densityfunction6, DensityFunctions.constant(0.37D)), DensityFunctions.yClampedGradient(-10, 30, 0.3D, 0.0D));
       return DensityFunctions.cacheOnce(DensityFunctions.min(densityfunction7, DensityFunctions.add(densityfunction5, densityfunction4)));
    }

    private static DensityFunction noodle(HolderGetter<DensityFunction> p_256402_, HolderGetter<NormalNoise.NoiseParameters> p_255632_) {
       DensityFunction densityfunction = getFunction(p_256402_, Y);
        DensityFunction densityfunction1 = yLimitedInterpolatable(densityfunction, DensityFunctions.noise(p_255632_.getOrThrow(Noises.NOODLE), 1.0D, 1.0D), -60, 320, -1);
       DensityFunction densityfunction2 = yLimitedInterpolatable(densityfunction, DensityFunctions.mappedNoise(p_255632_.getOrThrow(Noises.NOODLE_THICKNESS), 1.0D, 1.0D, -0.05D, -0.1D), -60, 320, 0);
       DensityFunction densityfunction3 = yLimitedInterpolatable(densityfunction, DensityFunctions.noise(p_255632_.getOrThrow(Noises.NOODLE_RIDGE_A), 2.6666666666666665D, 2.6666666666666665D), -60, 320, 0);
       DensityFunction densityfunction4 = yLimitedInterpolatable(densityfunction, DensityFunctions.noise(p_255632_.getOrThrow(Noises.NOODLE_RIDGE_B), 2.6666666666666665D, 2.6666666666666665D), -60, 320, 0);
       DensityFunction densityfunction5 = DensityFunctions.mul(DensityFunctions.constant(1.5D), DensityFunctions.max(densityfunction3.abs(), densityfunction4.abs()));
       return DensityFunctions.rangeChoice(densityfunction1, -1000000.0D, 0.0D, DensityFunctions.constant(64.0D), DensityFunctions.add(densityfunction2, densityfunction5));
    }

    private static DensityFunction pillars(HolderGetter<NormalNoise.NoiseParameters> p_255985_) {
       DensityFunction densityfunction = DensityFunctions.noise(p_255985_.getOrThrow(Noises.PILLAR), 25.0D, 0.3D);
       DensityFunction densityfunction1 = DensityFunctions.mappedNoise(p_255985_.getOrThrow(Noises.PILLAR_RARENESS), 0.0D, -2.0D);
       DensityFunction densityfunction2 = DensityFunctions.mappedNoise(p_255985_.getOrThrow(Noises.PILLAR_THICKNESS), 0.0D, 1.1D);
       DensityFunction densityfunction3 = DensityFunctions.add(DensityFunctions.mul(densityfunction, DensityFunctions.constant(2.0D)), densityfunction1);
       return DensityFunctions.cacheOnce(DensityFunctions.mul(densityfunction3, densityfunction2.cube()));
    }

    private static DensityFunction spaghetti2D(HolderGetter<DensityFunction> p_256535_, HolderGetter<NormalNoise.NoiseParameters> p_255650_) {
       DensityFunction densityfunction = DensityFunctions.noise(p_255650_.getOrThrow(Noises.SPAGHETTI_2D_MODULATOR), 2.0D, 1.0D);
       DensityFunction densityfunction1 = LunarisDensityFunctions.weirdScaledSampler(densityfunction, p_255650_.getOrThrow(Noises.SPAGHETTI_2D), LunarisDensityFunctions.WeirdScaledSampler.RarityValueMapper.TYPE2);
       DensityFunction densityfunction2 = DensityFunctions.mappedNoise(p_255650_.getOrThrow(Noises.SPAGHETTI_2D_ELEVATION), 0.0D, (double)Math.floorDiv(-64, 8), 8.0D);
       DensityFunction densityfunction3 = getFunction(p_256535_, SPAGHETTI_2D_THICKNESS_MODULATOR);
       DensityFunction densityfunction4 = DensityFunctions.add(densityfunction2, DensityFunctions.yClampedGradient(-64, 320, 8.0D, -40.0D)).abs();
       DensityFunction densityfunction5 = DensityFunctions.add(densityfunction4, densityfunction3).cube();
       DensityFunction densityfunction6 = DensityFunctions.add(densityfunction1, DensityFunctions.mul(DensityFunctions.constant(0.083D), densityfunction3));
       return DensityFunctions.max(densityfunction6, densityfunction5).clamp(-1.0D, 1.0D);
    }

    public static DensityFunction underground(HolderGetter<DensityFunction> p_256548_, HolderGetter<NormalNoise.NoiseParameters> p_256236_, DensityFunction p_256658_) {
       DensityFunction densityfunction = getFunction(p_256548_, SPAGHETTI_2D);
       DensityFunction densityfunction1 = getFunction(p_256548_, SPAGHETTI_ROUGHNESS_FUNCTION);
       DensityFunction densityfunction2 = DensityFunctions.noise(p_256236_.getOrThrow(Noises.CAVE_LAYER), 8.0D);
       DensityFunction densityfunction3 = DensityFunctions.mul(DensityFunctions.constant(4.0D), densityfunction2.square());
       DensityFunction densityfunction4 = DensityFunctions.noise(p_256236_.getOrThrow(Noises.CAVE_CHEESE), 0.6666666666666666D);
       DensityFunction densityfunction5 = DensityFunctions.add(DensityFunctions.add(DensityFunctions.constant(0.27D), densityfunction4).clamp(-1.0D, 1.0D), DensityFunctions.add(DensityFunctions.constant(1.5D), DensityFunctions.mul(DensityFunctions.constant(-0.64D), p_256658_)).clamp(0.0D, 0.5D));
       DensityFunction densityfunction6 = DensityFunctions.add(densityfunction3, densityfunction5);
       DensityFunction densityfunction7 = DensityFunctions.min(DensityFunctions.min(densityfunction6, getFunction(p_256548_, ENTRANCES)), DensityFunctions.add(densityfunction, densityfunction1));
       DensityFunction densityfunction8 = getFunction(p_256548_, PILLARS);
       DensityFunction densityfunction9 = DensityFunctions.rangeChoice(densityfunction8, -1000000.0D, 0.03D, DensityFunctions.constant(-1000000.0D), densityfunction8);
       return DensityFunctions.max(densityfunction7, densityfunction9);
    }

    public static DensityFunction slideLunaris(DensityFunction p_224491_) {
        return slide(p_224491_, -64, 384, 80, 64, -0.078125D, 0, 24, 0.1171875D);
    }
    
    protected static NoiseRouter none() {
        return new NoiseRouter(DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero());
    }

    private static DensityFunction splineWithBlending(DensityFunction p_224454_, DensityFunction p_224455_) {
        DensityFunction densityfunction = DensityFunctions.lerp(DensityFunctions.blendAlpha(), p_224455_, p_224454_);
        return DensityFunctions.flatCache(DensityFunctions.cache2d(densityfunction));
    }

    public static DensityFunction noiseGradientDensity(DensityFunction p_212272_, DensityFunction p_212273_) {
        DensityFunction densityfunction = DensityFunctions.mul(p_212273_, p_212272_);
        return DensityFunctions.mul(DensityFunctions.constant(4.0D), densityfunction.quarterNegative());
    }

    public static DensityFunction yLimitedInterpolatable(DensityFunction p_209472_, DensityFunction p_209473_, int p_209474_, int p_209475_, int p_209476_) {
        return DensityFunctions.interpolated(DensityFunctions.rangeChoice(p_209472_, (double)p_209474_, (double)(p_209475_ + 1), p_209473_, DensityFunctions.constant((double)p_209476_)));
    }
    
    private static DensityFunction slide(DensityFunction p_224444_, int p_224445_, int p_224446_, int p_224447_, int p_224448_, double p_224449_, int p_224450_, int p_224451_, double p_224452_) {
        DensityFunction densityfunction1 = DensityFunctions.yClampedGradient(p_224445_ + p_224446_ - p_224447_, p_224445_ + p_224446_ - p_224448_, 1.0D, 0.0D);
        DensityFunction $$9 = DensityFunctions.lerp(densityfunction1, p_224449_, p_224444_);
        DensityFunction densityfunction2 = DensityFunctions.yClampedGradient(p_224445_ + p_224450_, p_224445_ + p_224451_, 0.0D, 1.0D);
        return DensityFunctions.lerp(densityfunction2, p_224452_, $$9);
    }
    
    public static DensityFunction weirdScaledSampler(DensityFunction p_208316_,
    		Holder<NormalNoise.NoiseParameters> p_208317_,
    		LunarisDensityFunctions.WeirdScaledSampler.RarityValueMapper p_208318_) {
        return new LunarisDensityFunctions.WeirdScaledSampler(p_208316_, new DensityFunction.NoiseHolder(p_208317_), p_208318_);
     }
    
    interface TransformerWithContext extends DensityFunction {
        DensityFunction input();

        default double compute(DensityFunction.FunctionContext p_209065_) {
           return this.transform(p_209065_, this.input().compute(p_209065_));
        }

        default void fillArray(double[] p_209069_, DensityFunction.ContextProvider p_209070_) {
           this.input().fillArray(p_209069_, p_209070_);

           for(int i = 0; i < p_209069_.length; ++i) {
              p_209069_[i] = this.transform(p_209070_.forIndex(i), p_209069_[i]);
           }

        }

        double transform(DensityFunction.FunctionContext p_209066_, double p_209067_);
     }
    
    static <O> KeyDispatchDataCodec<O> makeCodec(MapCodec<O> p_224029_) {
        return KeyDispatchDataCodec.of(p_224029_);
     }
    
    protected static record WeirdScaledSampler(DensityFunction input, DensityFunction.NoiseHolder noise, LunarisDensityFunctions.WeirdScaledSampler.RarityValueMapper rarityValueMapper) implements LunarisDensityFunctions.TransformerWithContext {
        private static final MapCodec<LunarisDensityFunctions.WeirdScaledSampler> DATA_CODEC = RecordCodecBuilder.mapCodec((p_208438_) -> {
           return p_208438_.group(DensityFunction.HOLDER_HELPER_CODEC.fieldOf("input").forGetter(LunarisDensityFunctions.WeirdScaledSampler::input), DensityFunction.NoiseHolder.CODEC.fieldOf("noise").forGetter(LunarisDensityFunctions.WeirdScaledSampler::noise), LunarisDensityFunctions.WeirdScaledSampler.RarityValueMapper.CODEC.fieldOf("rarity_value_mapper").forGetter(LunarisDensityFunctions.WeirdScaledSampler::rarityValueMapper)).apply(p_208438_, LunarisDensityFunctions.WeirdScaledSampler::new);
        });
        public static final KeyDispatchDataCodec<LunarisDensityFunctions.WeirdScaledSampler> CODEC = LunarisDensityFunctions.makeCodec(DATA_CODEC);

        public double transform(DensityFunction.FunctionContext p_208440_, double p_208441_) {
           double d0 = this.rarityValueMapper.mapper.get(p_208441_);
           return d0 * Math.abs(this.noise.getValue((double)p_208440_.blockX() / d0, (double)p_208440_.blockY() / d0, (double)p_208440_.blockZ() / d0));
        }

        public DensityFunction mapAll(DensityFunction.Visitor p_208443_) {
           return p_208443_.apply(new LunarisDensityFunctions.WeirdScaledSampler(this.input.mapAll(p_208443_), p_208443_.visitNoise(this.noise), this.rarityValueMapper));
        }

        public double minValue() {
           return 0.0D;
        }

        public double maxValue() {
           return this.rarityValueMapper.maxRarity * this.noise.maxValue();
        }

        public KeyDispatchDataCodec<? extends DensityFunction> codec() {
           return CODEC;
        }

        public DensityFunction input() {
           return this.input;
        }

        public static enum RarityValueMapper implements StringRepresentable {
           TYPE1("type_1", QuantizedSpaghettiRarity::getSpaghettiRarity3D, 2.0D),
           TYPE2("type_2", QuantizedSpaghettiRarity::getSphaghettiRarity2D, 3.0D);

           public static final Codec<LunarisDensityFunctions.WeirdScaledSampler.RarityValueMapper> CODEC = StringRepresentable.fromEnum(LunarisDensityFunctions.WeirdScaledSampler.RarityValueMapper::values);
           private final String name;
           final Double2DoubleFunction mapper;
           final double maxRarity;

           private RarityValueMapper(String p_208470_, Double2DoubleFunction p_208471_, double p_208472_) {
              this.name = p_208470_;
              this.mapper = p_208471_;
              this.maxRarity = p_208472_;
           }

           public String getSerializedName() {
              return this.name;
           }
        }
     }

    protected static final class QuantizedSpaghettiRarity {
       protected static double getSphaghettiRarity2D(double p_209564_) {
          if (p_209564_ < -0.75D) {
             return 0.5D;
          } else if (p_209564_ < -0.5D) {
             return 0.75D;
          } else if (p_209564_ < 0.5D) {
             return 1.0D;
          } else {
             return p_209564_ < 0.75D ? 2.0D : 3.0D;
          }
       }

       protected static double getSpaghettiRarity3D(double p_209566_) {
          if (p_209566_ < -0.5D) {
             return 0.75D;
          } else if (p_209566_ < 0.0D) {
             return 1.0D;
          } else {
             return p_209566_ < 0.5D ? 1.5D : 2.0D;
          }
       }
    }
 }