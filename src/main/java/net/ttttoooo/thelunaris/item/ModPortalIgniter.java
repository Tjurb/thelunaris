package net.ttttoooo.thelunaris.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.ttttoooo.thelunaris.block.ModBlocks;

public class ModPortalIgniter extends Item{

	public ModPortalIgniter(Properties properties) {
		super(properties);
	}
	
	@Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState blockState = level.getBlockState(pos);
        
        if (isValidFrame(blockState)) {
            level.setBlock(pos.above(), ModBlocks.LUNARPORTAL_BLOCK.get().defaultBlockState(), 2);
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.FAIL;
    }

    private boolean isValidFrame(BlockState blockState) {
        return blockState.getBlock() == Blocks.CHISELED_STONE_BRICKS;
    }

}
