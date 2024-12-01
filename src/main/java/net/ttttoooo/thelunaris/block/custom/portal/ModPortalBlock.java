package net.ttttoooo.thelunaris.block.custom.portal;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.level.BlockEvent;
import net.ttttoooo.thelunaris.worldgen.dimension.ModDimensions;

import javax.annotation.Nullable;


public class ModPortalBlock extends Block {
	public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
	protected static final VoxelShape X_AXIS_AABB = Block.box(0.0, 0.0, 6.0, 16.0, 16.0, 10.0);
	protected static final VoxelShape Z_AXIS_AABB = Block.box(6.0, 0.0, 0.0, 10.0, 16.0, 16.0);

	public ModPortalBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(stateDefinition.any().setValue(AXIS, Direction.Axis.X));
	}
	
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
    	switch (state.getValue(AXIS)) {
			case Z:
				return Z_AXIS_AABB;
			case X:
			default:
				return X_AXIS_AABB;
    	}
    }
    

	public boolean trySpawnPortal(LevelAccessor level, BlockPos pos) {
		ModPortalFrame size = this.isPortal(level, pos);
		System.out.println(level);
		System.out.println(pos);
		System.out.println(size);
		if (size != null && !onTrySpawnPortal(level, pos, size)) {
			System.out.println("trySpawnPortal true");
			size.createPortalBlocks();
			return true;
		} else {
			System.out.println("trySpawnPortal false");
			return false;
		}
	}

	public static boolean onTrySpawnPortal(LevelAccessor world, BlockPos pos, ModPortalFrame size) {
		System.out.println("onTrySpawnPortal");
		return MinecraftForge.EVENT_BUS.post(new BlockEvent.PortalSpawnEvent(world, pos, world.getBlockState(pos), size));
	}

	@Nullable
	public ModPortalFrame isPortal(LevelAccessor level, BlockPos pos) {
		ModPortalFrame ModPortalBlock$size = new ModPortalFrame(level, pos, Direction.Axis.X);
		System.out.println(ModPortalBlock$size);
		System.out.println(ModPortalBlock$size.isValid());
		System.out.println(ModPortalBlock$size.numPortalBlocks);
		if (ModPortalBlock$size.isValid() && ModPortalBlock$size.numPortalBlocks == 0) {
			System.out.println("isPortal Size test");
			return ModPortalBlock$size;
		} else {
			ModPortalFrame ModPortalBlock$size1 = new ModPortalFrame(level, pos, Direction.Axis.Z);
			System.out.println("isPortal Size1 test");
			return ModPortalBlock$size1.isValid() && ModPortalBlock$size1.numPortalBlocks == 0 ? ModPortalBlock$size1 : null;
		}
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(AXIS);
	}

	@Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!level.isClientSide && entity instanceof ServerPlayer serverPlayer) {
        	if(entity.isOnPortalCooldown()) {
        		entity.setPortalCooldown();      		
        	}
        	else {
                handleLunarisPortal(entity, pos);        		
        	}
        }
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
    				entity.level().getProfiler().push("lunar_portal");
    				entity.setPortalCooldown();
    				entity.changeDimension(destinationLevel, new ModPortalTeleporter(destinationLevel, true));
    				entity.level().getProfiler().pop();
                } else {
                	entity.level().getProfiler().push("lunar_portal");
    				entity.setPortalCooldown();
    				entity.changeDimension(destinationLevel, new ModPortalTeleporter(destinationLevel, true));
    				entity.level().getProfiler().pop();
                }
            }
        }
    }
	
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

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        Direction.Axis directionAxis = direction.getAxis();
        Direction.Axis blockAxis = state.getValue(AXIS);
        boolean flag = blockAxis != directionAxis && directionAxis.isHorizontal();
        return !flag && !facingState.is(this) && !(new ModPortalFrame(level, currentPos, blockAxis).isComplete()) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, facingState, level, currentPos, facingPos);
    }
    
    public void animateTick(BlockState p_221794_, Level p_221795_, BlockPos p_221796_, RandomSource p_221797_) {
        if (p_221797_.nextInt(100) == 0) {
           p_221795_.playLocalSound((double)p_221796_.getX() + 0.5D, (double)p_221796_.getY() + 0.5D, (double)p_221796_.getZ() + 0.5D, SoundEvents.PORTAL_AMBIENT, SoundSource.BLOCKS, 0.5F, p_221797_.nextFloat() * 0.4F + 0.8F, false);
        }

        for(int i = 0; i < 4; ++i) {
           double d0 = (double)p_221796_.getX() + p_221797_.nextDouble();
           double d1 = (double)p_221796_.getY() + p_221797_.nextDouble();
           double d2 = (double)p_221796_.getZ() + p_221797_.nextDouble();
           double d3 = ((double)p_221797_.nextFloat() - 0.5D) * 0.5D;
           double d4 = ((double)p_221797_.nextFloat() - 0.5D) * 0.5D;
           double d5 = ((double)p_221797_.nextFloat() - 0.5D) * 0.5D;
           int j = p_221797_.nextInt(2) * 2 - 1;
           if (!p_221795_.getBlockState(p_221796_.west()).is(this) && !p_221795_.getBlockState(p_221796_.east()).is(this)) {
              d0 = (double)p_221796_.getX() + 0.5D + 0.25D * (double)j;
              d3 = (double)(p_221797_.nextFloat() * 2.0F * (float)j);
           } else {
              d2 = (double)p_221796_.getZ() + 0.5D + 0.25D * (double)j;
              d5 = (double)(p_221797_.nextFloat() * 2.0F * (float)j);
           }

           p_221795_.addParticle(ParticleTypes.PORTAL, d0, d1, d2, d3, d4, d5);
        }

     }
}