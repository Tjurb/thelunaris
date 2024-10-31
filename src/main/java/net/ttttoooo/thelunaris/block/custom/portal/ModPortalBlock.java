package net.ttttoooo.thelunaris.block.custom.portal;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.ttttoooo.thelunaris.worldgen.dimension.ModDimensions;

public class ModPortalBlock extends NetherPortalBlock {
	public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
	protected static final VoxelShape X_AXIS_AABB = Block.box(0.0, 0.0, 6.0, 16.0, 16.0, 10.0);
	protected static final VoxelShape Z_AXIS_AABB = Block.box(6.0, 0.0, 0.0, 10.0, 16.0, 16.0);

    public ModPortalBlock(Properties properties) {
    	super(properties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(AXIS, Direction.Axis.X));
	}
    
    @Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(AXIS);
	}

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!level.isClientSide && entity instanceof ServerPlayer serverPlayer) {
            handleLunarisPortal(serverPlayer, pos);
        }
    }
    
    @SuppressWarnings("deprecation")
    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return switch (rotation) {
            case COUNTERCLOCKWISE_90, CLOCKWISE_90 -> switch (state.getValue(AXIS)) {
                case Z -> state.setValue(AXIS, Direction.Axis.X);
                case X -> state.setValue(AXIS, Direction.Axis.Z);
                default -> state;
            };
            default -> state;
        };
    }
    
    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        if (state.getValue(AXIS) == Direction.Axis.Z) {
            return Z_AXIS_AABB;
        } else {
            return X_AXIS_AABB;
        }
    }
    
    @SuppressWarnings("deprecation")
    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        Direction.Axis directionAxis = direction.getAxis();
        Direction.Axis blockAxis = state.getValue(AXIS);
        boolean flag = blockAxis != directionAxis && directionAxis.isHorizontal();
        return !flag && !facingState.is(this) && !(new ModPortalFrame(level, currentPos, blockAxis).isComplete()) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, facingState, level, currentPos, facingPos);
    }

    // Custom teleportation handler for the Lunaris portal
    private void handleLunarisPortal(Entity entity, BlockPos pos) {
        if (entity.level() instanceof ServerLevel serverLevel) {
            MinecraftServer minecraftServer = serverLevel.getServer();

            // Check if the player is in the custom dimension and toggle between dimensions
            ResourceKey<Level> targetDimension = entity.level().dimension() == ModDimensions.LUNARIS_LEVEL_KEY ?
                    Level.OVERWORLD : ModDimensions.LUNARIS_LEVEL_KEY;

            // Get the dimension to teleport to
            ServerLevel destinationLevel = minecraftServer.getLevel(targetDimension);

            if (destinationLevel != null && !entity.isPassenger()) {
                if (targetDimension == ModDimensions.LUNARIS_LEVEL_KEY) {
                    // Teleport to custom dimension (Lunaris)
                    entity.changeDimension(destinationLevel, new ModPortalTeleporter(destinationLevel, new BlockPos(0, 80, 0)));
                } else {
                    // Teleport to Overworld
                    entity.changeDimension(destinationLevel, new ModPortalTeleporter(destinationLevel, new BlockPos(pos.getX(), pos.getY(), pos.getZ())));
                }
            }
        }
    }
}
