package net.ttttoooo.thelunaris.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.ttttoooo.thelunaris.block.ModBlocks;
import net.ttttoooo.thelunaris.worldgen.ModPlacedFeatures;

import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

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
                if (nearbyState.is(ModBlocks.LUNDIRT.get()) && level.getMaxLocalRawBrightness(nearbyPos.above()) >= 9) {
                    // Replace the dirt block with LunGrass
                    level.setBlock(nearbyPos, this.defaultBlockState(), 3);
                }
            }
        }
    }
    
    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        BlockPos abovePos = pos.above();
        Block grass = ModBlocks.LUNGRASS_BLOCK.get();
        Optional<Holder.Reference<PlacedFeature>> grassFeatureOptional = level.registryAccess().registryOrThrow(Registries.PLACED_FEATURE).getHolder(ModPlacedFeatures.LUNARIS_BONEMEAL_KEY);

        start:
        for (int i = 0; i < 128; ++i) {
            BlockPos blockPos = abovePos;

            for (int j = 0; j < i / 16; ++j) {
                blockPos = blockPos.offset(random.nextInt(3) - 1, (random.nextInt(3) - 1) * random.nextInt(3) / 2, random.nextInt(3) - 1);
                if (!level.getBlockState(blockPos.below()).is(this) || level.getBlockState(blockPos).isCollisionShapeFullBlock(level, blockPos)) {
                    continue start;
                }
            }

            BlockState blockState = level.getBlockState(blockPos);
            if (blockState.is(grass) && random.nextInt(10) == 0) {
                ((BonemealableBlock) grass).performBonemeal(level, random, blockPos, blockState);
            }

            if (blockState.isAir()) {
                Holder<PlacedFeature> featureHolder;
                if (random.nextInt(8) == 0) {
                    List<ConfiguredFeature<?, ?>> list = level.getBiome(blockPos).value().getGenerationSettings().getFlowerFeatures();
                    if (list.isEmpty()) {
                        continue;
                    }
                    featureHolder = ((RandomPatchConfiguration) list.get(random.nextInt(list.size())).config()).feature();
                } else {
                    if (grassFeatureOptional.isEmpty()) {
                        continue;
                    }
                    featureHolder = grassFeatureOptional.get();
                }
                featureHolder.value().place(level, level.getChunkSource().getGenerator(), random, blockPos);
            }
        }
    }
}
