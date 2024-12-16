package net.ttttoooo.thelunaris.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MoondialBlock extends Block{
    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 12, 16, 12);

	public MoondialBlock(Properties p_49224_) {
		super(p_49224_);
	    this.registerDefaultState(this.stateDefinition.any());
	}
	
	@Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }
}
