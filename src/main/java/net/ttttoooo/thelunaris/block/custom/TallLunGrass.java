package net.ttttoooo.thelunaris.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.ttttoooo.thelunaris.block.ModBlocks;
import net.ttttoooo.thelunaris.worldgen.ModConfiguredFeatures;

public class TallLunGrass extends TallGrassBlock{

	public TallLunGrass(Properties p_57318_) {
		super(p_57318_);
	}
	
	public boolean isValidBonemealTarget(LevelReader p_255692_, BlockPos p_57326_, BlockState p_57327_, boolean p_57328_) {
	      return true;
	}

	public boolean isBonemealSuccess(Level p_222583_, RandomSource p_222584_, BlockPos p_222585_, BlockState p_222586_) {
	      return true;
	}

	@Override
	public void performBonemeal(ServerLevel level, RandomSource p_222579_, BlockPos pos, BlockState p_222581_) {
	    BlockState blockstate = level.getBlockState(pos);
		if (blockstate.is(ModBlocks.CRIMSON_GLOWBUSH.get())) {
		      popResource(level, pos, new ItemStack(this));
		} else if (blockstate.is(ModBlocks.DUSKLIGHT_GLOWBUSH.get())) {
		      popResource(level, pos, new ItemStack(this));
		} else if (blockstate.is(ModBlocks.LUNGRASS.get())) {
		      DoublePlantBlock doubleplantblock = (DoublePlantBlock)(ModBlocks.TALL_LUNGRASS.get());
			if (doubleplantblock.defaultBlockState().canSurvive(level, pos) && level.isEmptyBlock(pos.above())) {
				DoublePlantBlock.placeAt(level, doubleplantblock.defaultBlockState(), pos, 2);
			}
		} else if (blockstate.is(ModBlocks.CRIMSON_LUNGRASS.get())) {
		      DoublePlantBlock doubleplantblock = (DoublePlantBlock)(ModBlocks.TALL_CRIMSON_LUNGRASS.get());
			if (doubleplantblock.defaultBlockState().canSurvive(level, pos) && level.isEmptyBlock(pos.above())) {
		        DoublePlantBlock.placeAt(level, doubleplantblock.defaultBlockState(), pos, 2);
		    }
		} else if (blockstate.is(ModBlocks.DUSKLIGHT_LUNGRASS.get())) {
		      DoublePlantBlock doubleplantblock = (DoublePlantBlock)(ModBlocks.TALL_DUSKLIGHT_LUNGRASS.get());
			if (doubleplantblock.defaultBlockState().canSurvive(level, pos) && level.isEmptyBlock(pos.above())) {
		        DoublePlantBlock.placeAt(level, doubleplantblock.defaultBlockState(), pos, 2);
		    }
		}
	}

}
