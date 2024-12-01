package net.ttttoooo.thelunaris.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.ttttoooo.thelunaris.block.ModBlocks;
import net.ttttoooo.thelunaris.block.custom.portal.ModPortalBlock;
import net.ttttoooo.thelunaris.worldgen.dimension.ModDimensions;

public class ModPortalIgniter extends Item{

	public ModPortalIgniter(Properties properties) {
		super(properties);
	}
	
	@Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState blockState = level.getBlockState(pos);
        
        if(isValidFrame(blockState)) {
        	if (context.getPlayer() != null) {
        		if (context.getPlayer().level().dimension() == ModDimensions.LUNARIS_LEVEL_KEY || context.getPlayer().level().dimension() == Level.OVERWORLD) {
					for (Direction direction : Direction.Plane.VERTICAL) {
						BlockPos framePos = context.getClickedPos().relative(direction);
						if (((ModPortalBlock) ModBlocks.LUNARPORTAL_BLOCK.get()).trySpawnPortal(context.getLevel(), framePos)) {
							return InteractionResult.SUCCESS;
						} else return InteractionResult.FAIL;
					}
				}
        	}
		}
		return InteractionResult.FAIL;
    }

    private boolean isValidFrame(BlockState blockState) {
        return blockState.getBlock() == Blocks.CHISELED_STONE_BRICKS;
    }

}
