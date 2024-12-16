package net.ttttoooo.thelunaris.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.features.NetherFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.ttttoooo.thelunaris.block.ModBlocks;
import net.ttttoooo.thelunaris.worldgen.ModConfiguredFeatures;
import net.ttttoooo.thelunaris.worldgen.ModPlacedFeatures;

import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

import javax.annotation.Nullable;

public class LunGrassBlock extends GrassBlock {
    public LunGrassBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
    }

    @Override
    public boolean onTreeGrow(BlockState state, LevelReader level, BiConsumer<BlockPos, BlockState> placeFunction, RandomSource randomSource, BlockPos pos, TreeConfiguration config) {
        placeFunction.accept(pos, ModBlocks.LUNDIRT.get().defaultBlockState());
        return true;
    }
    
    public static void turntoLunDirt(@Nullable Entity entity, BlockState state, Level level, BlockPos pos) {
	    BlockState blockstate = pushEntitiesUp(state, ModBlocks.LUNDIRT.get().defaultBlockState(), level, pos);
	    level.setBlockAndUpdate(pos, blockstate);
	    level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(entity, blockstate));
	}

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        // Ensure the block is loaded
        if (!level.isAreaLoaded(pos, 3)) return;
        // Check for light level to allow spreading
        if (level.getMaxLocalRawBrightness(pos.above()) >= 9) {
            for (int i = 0; i < 4; ++i) {
                // Generate a nearby position
                BlockPos nearbyPos = pos.offset(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                BlockState nearbyState = level.getBlockState(nearbyPos);

                // Check if the nearby block is dirt (or your custom dirt block)
                if (nearbyState.is(ModBlocks.LUNDIRT.get()) && level.getMaxLocalRawBrightness(nearbyPos.above()) >= 9
                		&& !level.getFluidState(nearbyPos.above()).is(FluidTags.WATER)) {
                    // Replace the dirt block with LunGrass
                    level.setBlock(nearbyPos, this.defaultBlockState(), 3);
                } else if(level.getFluidState(pos.above()).is(FluidTags.WATER)) {
                	level.setBlock(pos, ModBlocks.LUNDIRT.get().defaultBlockState(), 3);
                }
            }
        }
    }

    public boolean isValidBonemealTarget(LevelReader p_256194_, BlockPos p_256152_, BlockState p_256389_, boolean p_255846_) {
       return p_256194_.getBlockState(p_256152_.above()).isAir();
    }

    public boolean isBonemealSuccess(Level p_221830_, RandomSource p_221831_, BlockPos p_221832_, BlockState p_221833_) {
       return true;
    }

    @Override
    public void performBonemeal(ServerLevel p_221825_, RandomSource p_221826_, BlockPos p_221827_, BlockState p_221828_) {
       BlockState blockstate = p_221825_.getBlockState(p_221827_);
       BlockPos blockpos = p_221827_.above();
       ChunkGenerator chunkgenerator = p_221825_.getChunkSource().getGenerator();
       Registry<ConfiguredFeature<?, ?>> registry = p_221825_.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE);
       if (blockstate.is(ModBlocks.LUNGRASS_BLOCK.get())) {
           this.place(registry, ModConfiguredFeatures.LUNARIS_GRASS_PATCH_KEY, p_221825_, chunkgenerator, p_221826_, blockpos);
       } else if (blockstate.is(ModBlocks.CRIMSON_LUNGRASS_BLOCK.get())) {
          this.place(registry, ModConfiguredFeatures.CRIMSONGRASS_PATCH_KEY, p_221825_, chunkgenerator, p_221826_, blockpos);
       } else if (blockstate.is(ModBlocks.DUSKLIGHT_LUNGRASS_BLOCK.get())) {
          this.place(registry, ModConfiguredFeatures.DUSKLIGHTGRASS_PATCH_KEY, p_221825_, chunkgenerator, p_221826_, blockpos);
       }
    }
    
    private void place(Registry<ConfiguredFeature<?, ?>> p_255879_, ResourceKey<ConfiguredFeature<?, ?>> p_256032_, ServerLevel p_255631_, ChunkGenerator p_256445_, RandomSource p_255709_, BlockPos p_256019_) {
       p_255879_.getHolder(p_256032_).ifPresent((p_255920_) -> {
          p_255920_.value().place(p_255631_, p_256445_, p_255709_, p_256019_);
       });
    }
}
