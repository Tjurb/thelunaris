package net.ttttoooo.thelunaris.block.custom;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

import net.ttttoooo.thelunaris.block.ModBlocks;

public class LundirtFarmlandBlock extends FarmBlock {

	public LundirtFarmlandBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(MOISTURE, 0));
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return !this.defaultBlockState().canSurvive(context.getLevel(), 
				context.getClickedPos()) ? ModBlocks.LUNDIRT.get().defaultBlockState() : super.getStateForPlacement(context);
	}

	@Override
	public boolean canSustainPlant(BlockState state, BlockGetter getter, BlockPos pos, Direction direction, IPlantable plantable) {
		PlantType type = plantable.getPlantType(getter, pos.relative(direction));
		return type == PlantType.CROP || type == PlantType.PLAINS;
	}

	public static void turntoLunDirt(@Nullable Entity entity, BlockState state, Level level, BlockPos pos) {
	    BlockState blockstate = pushEntitiesUp(state, ModBlocks.LUNDIRT.get().defaultBlockState(), level, pos);
	    level.setBlockAndUpdate(pos, blockstate);
	    level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(entity, blockstate));
	}

	
	private static boolean isNearWater(LevelReader p_53259_, BlockPos p_53260_) {
	      BlockState state = p_53259_.getBlockState(p_53260_);
	      for(BlockPos blockpos : BlockPos.betweenClosed(p_53260_.offset(-4, 0, -4), p_53260_.offset(4, 1, 4))) {
	         if (state.canBeHydrated(p_53259_, p_53260_, p_53259_.getFluidState(blockpos), blockpos)) {
	            return true;
	         }
	      }

	      return net.minecraftforge.common.FarmlandWaterManager.hasBlockWaterTicket(p_53259_, p_53260_);
	   }

	private static boolean shouldMaintainFarmland(BlockGetter p_279219_, BlockPos p_279209_) {
		BlockState plant = p_279219_.getBlockState(p_279209_.above());
	    BlockState state = p_279219_.getBlockState(p_279209_);
	    return plant.getBlock() instanceof net.minecraftforge.common.IPlantable && state.canSustainPlant(p_279219_, p_279209_, Direction.UP, (net.minecraftforge.common.IPlantable)plant.getBlock());
	}

	@Override
	public void tick(BlockState p_221134_, ServerLevel p_221135_, BlockPos p_221136_, RandomSource p_221137_) {
	      if (!p_221134_.canSurvive(p_221135_, p_221136_)) {
	    	  turntoLunDirt((Entity)null, p_221134_, p_221135_, p_221136_);
	      }
	}

	@Override
	public void randomTick(BlockState p_221139_, ServerLevel p_221140_, BlockPos p_221141_, RandomSource p_221142_) {
	      int i = p_221139_.getValue(MOISTURE);
	      if (!isNearWater(p_221140_, p_221141_) && !p_221140_.isRainingAt(p_221141_.above())) {
	         if (i > 0) {
	            p_221140_.setBlock(p_221141_, p_221139_.setValue(MOISTURE, Integer.valueOf(i - 1)), 2);
	         } else if (!shouldMaintainFarmland(p_221140_, p_221141_)) {
	        	 turntoLunDirt((Entity)null, p_221139_, p_221140_, p_221141_);
	         }
	      } else if (i < 7) {
	         p_221140_.setBlock(p_221141_, p_221139_.setValue(MOISTURE, Integer.valueOf(7)), 2);
	      }

	   }

	@Override
	public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDamage) {
		if (!level.isClientSide() && ForgeHooks.onFarmlandTrample(level, pos, ModBlocks.LUNDIRT.get().defaultBlockState(), fallDamage, entity)) {
			turntoLunDirt(entity, state, level, pos);
		}

		entity.causeFallDamage(fallDamage, 1.0F, level.damageSources().fall());
	}
}
