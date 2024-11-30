package net.ttttoooo.thelunaris.block.custom.portal;

import java.util.Optional;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.portal.PortalShape;
import net.ttttoooo.thelunaris.block.ModBlocks;
import net.ttttoooo.thelunaris.util.ModTags;

public class ModPortalFrame extends PortalShape{
	private static final int MIN_WIDTH = 2;
	public static final int MAX_WIDTH = 21;
	private static final int MIN_HEIGHT = 3;
	public static final int MAX_HEIGHT = 21;
	private static final BlockBehaviour.StatePredicate FRAME = (state, level, pos) -> state.is(ModTags.Blocks.LUNAR_PORTAL_BLOCKS);
	private final LevelAccessor level;
	private final Direction.Axis axis;
	private final Direction rightDir;
	public int numPortalBlocks;
	private BlockPos bottomLeft;
	private int height;
	private final int width;

    public ModPortalFrame(LevelAccessor level, BlockPos bottomLeftPos, Direction.Axis axis) {
		super(level, bottomLeftPos, axis);
		this.level = level;
		this.axis = axis;
		this.rightDir = axis == Direction.Axis.X ? Direction.WEST : Direction.SOUTH;
		this.bottomLeft = this.calculateBottomLeft(bottomLeftPos);
		if (this.bottomLeft == null) {
			this.bottomLeft = bottomLeftPos;
			this.width = 1;
			this.height = 1;
		} else {
			this.width = this.calculateWidth();
			if (this.width > 0) {
				this.height = this.calculateHeight();
			}
		}

	}
	@Nullable
	private BlockPos calculateBottomLeft(BlockPos pos) {
		for (int i = Math.max(this.level.getMinBuildHeight(), pos.getY() - MAX_HEIGHT); pos.getY() > i && isEmpty(this.level.getBlockState(pos.below())); pos = pos.below()) {
		}

		Direction direction = this.rightDir.getOpposite();
		int j = this.getDistanceUntilEdgeAboveFrame(pos, direction) - 1;
		return j < 0 ? null : pos.relative(direction, j);
	}

	private int calculateWidth() {
		int i = this.getDistanceUntilEdgeAboveFrame(this.bottomLeft, this.rightDir);
		return i >= MIN_WIDTH && i <= MAX_WIDTH ? i : 0;
	}

	private int getDistanceUntilEdgeAboveFrame(BlockPos pos, Direction direction) {
		BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

		for (int i = 0; i <= MAX_WIDTH; ++i) {
			mutablePos.set(pos).move(direction, i);
			BlockState blockstate = this.level.getBlockState(mutablePos);
			if (!isEmpty(blockstate)) {
				if (FRAME.test(blockstate, this.level, mutablePos)) {
					return i;
				}
				break;
			}

			BlockState blockstate1 = this.level.getBlockState(mutablePos.move(Direction.DOWN));
			if (!FRAME.test(blockstate1, this.level, mutablePos)) {
				break;
			}
		}

		return 0;
	}

	private int calculateHeight() {
		BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();
		int i = this.getDistanceUntilTop(mutablePos);
		return i >= MIN_HEIGHT && i <= MAX_HEIGHT && this.hasTopFrame(mutablePos, i) ? i : 0;
	}

	private boolean hasTopFrame(BlockPos.MutableBlockPos pos, int height) {
		for (int i = 0; i < this.width; ++i) {
			BlockPos.MutableBlockPos mutablePos = pos.set(this.bottomLeft).move(Direction.UP, height).move(this.rightDir, i);
			if (!FRAME.test(this.level.getBlockState(mutablePos), this.level, mutablePos)) {
				return false;
			}
		}

		return true;
	}

	private int getDistanceUntilTop(BlockPos.MutableBlockPos pos) {
		for (int i = 0; i < MAX_HEIGHT; ++i) {
			pos.set(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, -1);
			if (!FRAME.test(this.level.getBlockState(pos), this.level, pos)) {
				return i;
			}

			pos.set(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, this.width);
			if (!FRAME.test(this.level.getBlockState(pos), this.level, pos)) {
				return i;
			}

			for (int j = 0; j < this.width; ++j) {
				pos.set(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, j);
				BlockState blockstate = this.level.getBlockState(pos);
				if (!isEmpty(blockstate)) {
					return i;
				}

				if (blockstate.is(ModBlocks.LUNARPORTAL_BLOCK.get())) {
					++this.numPortalBlocks;
				}
			}
		}

		return MAX_HEIGHT;
	}

	private static boolean isEmpty(BlockState state) {
		return state.isAir() || state.is(ModBlocks.LUNARPORTAL_BLOCK.get());
	}

	public boolean isValid() {
		return this.bottomLeft != null && this.width >= MIN_WIDTH && this.width <= MAX_WIDTH && this.height >= MIN_HEIGHT && this.height <= MAX_HEIGHT;
	}

	public void createPortalBlocks() {
		BlockState blockstate = ModBlocks.LUNARPORTAL_BLOCK.get().defaultBlockState().setValue(NetherPortalBlock.AXIS, this.axis);
		BlockPos.betweenClosed(this.bottomLeft, this.bottomLeft.relative(Direction.UP, this.height - 1).relative(this.rightDir, this.width - 1)).forEach(pos -> this.level.setBlock(pos, blockstate, 18));
	}

	public boolean isComplete() {
		return this.isValid() && this.numPortalBlocks == this.width * this.height;
	}
}