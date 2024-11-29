package net.ttttoooo.thelunaris.block.custom.portal;

import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.TicketType;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraftforge.common.util.ITeleporter;

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.Optional;

import net.ttttoooo.thelunaris.block.ModBlocks;
import net.ttttoooo.thelunaris.worldgen.dimension.ModDimensions;
import net.ttttoooo.thelunaris.worldgen.dimension.ModPoi;

public class ModPortalTeleporter implements ITeleporter {
    private final ServerLevel level;
    private final boolean hasFrame; // Whether to generate a portal frame or not.

    public ModPortalTeleporter(ServerLevel level, boolean hasFrame) {
        this.level = level;
        this.hasFrame = hasFrame;
    }

    private Optional<BlockUtil.FoundRectangle> findPortalAround(BlockPos pos, WorldBorder worldBorder) {
        PoiManager poiManager = this.level.getPoiManager();
        poiManager.ensureLoadedAndValid(this.level, pos, 128);
        Optional<PoiRecord> optionalPoi = poiManager.getInSquare((poiType) -> poiType.is(ModPoi.LUNAR_PORTAL.getKey()), pos, 128, PoiManager.Occupancy.ANY)
                .filter((poiRecord) -> worldBorder.isWithinBounds(poiRecord.getPos()))
                .sorted(Comparator.<PoiRecord>comparingDouble((poiRecord) -> poiRecord.getPos().distSqr(pos)).thenComparingInt((poiRecord) -> poiRecord.getPos().getY()))
                .filter((poiRecord) -> this.level.getBlockState(poiRecord.getPos()).hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
                .findFirst();
        return optionalPoi.map((poiRecord) -> {
            BlockPos poiPos = poiRecord.getPos();
            this.level.getChunkSource().addRegionTicket(TicketType.PORTAL, new ChunkPos(poiPos), 3, poiPos);
            BlockState blockstate = this.level.getBlockState(poiPos);
            return BlockUtil.getLargestRectangleAround(poiPos, blockstate.getValue(BlockStateProperties.HORIZONTAL_AXIS), 21, Direction.Axis.Y, 21, (blockPos) -> this.level.getBlockState(blockPos) == blockstate);
        });
    }

    public Optional<BlockUtil.FoundRectangle> createPortal(BlockPos pos, Direction.Axis axis) {
        Direction direction = Direction.get(Direction.AxisDirection.POSITIVE, axis);
        double d0 = -1.0;
        BlockPos blockPos = null;
        double d1 = -1.0;
        BlockPos blockPos1 = null;
        WorldBorder worldBorder = this.level.getWorldBorder();
        int i = Math.min(this.level.getMaxBuildHeight(), this.level.getMinBuildHeight() + this.level.getLogicalHeight()) - 1;
        BlockPos.MutableBlockPos mutablePos = pos.mutable();

        for (BlockPos.MutableBlockPos mutablePos1 : BlockPos.spiralAround(pos, 16, Direction.EAST, Direction.SOUTH)) {
            int j = Math.min(i, this.level.getHeight(Heightmap.Types.MOTION_BLOCKING, mutablePos1.getX(), mutablePos1.getZ()));
            if (worldBorder.isWithinBounds(mutablePos1) && worldBorder.isWithinBounds(mutablePos1.move(direction, 1))) {
                mutablePos1.move(direction.getOpposite(), 1);

                for (int l = j; l >= this.level.getMinBuildHeight(); --l) {
                    mutablePos1.setY(l);
                    if (this.level.isEmptyBlock(mutablePos1)) {
                        int i1;
                        for (i1 = l; l > this.level.getMinBuildHeight() && this.level.isEmptyBlock(mutablePos1.move(Direction.DOWN)); --l) { }

                        if (l + 4 <= i) {
                            int j1 = i1 - l;
                            if (j1 <= 0 || j1 >= 3) {
                                mutablePos1.setY(l);
                                if (this.canHostFrame(mutablePos1, mutablePos, direction, 0)) {
                                    double d2 = pos.distSqr(mutablePos1);
                                    if (this.canHostFrame(mutablePos1, mutablePos, direction, -1) && this.canHostFrame(mutablePos1, mutablePos, direction, 1) && (d0 == -1.0 || d0 > d2)) {
                                        d0 = d2;
                                        blockPos = mutablePos1.immutable();
                                    }
                                    if (d0 == -1.0 && (d1 == -1.0 || d1 > d2)) {
                                        d1 = d2;
                                        blockPos1 = mutablePos1.immutable();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (d0 == -1.0 && d1 != -1.0) {
            blockPos = blockPos1;
            d0 = d1;
        }

        if (d0 == -1.0) {
            int k1 = Math.max(this.level.getMinBuildHeight() + 1, 70);
            int i2 = i - 9;
            if (i2 < k1) {
                return Optional.empty();
            }

            blockPos = new BlockPos(pos.getX(), Mth.clamp(pos.getY(), k1, i2), pos.getZ()).immutable();
            Direction direction1 = direction.getClockWise();
            if (!worldBorder.isWithinBounds(blockPos)) {
                return Optional.empty();
            }

            for (int i3 = -1; i3 < 2; ++i3) {
                for (int j3 = 0; j3 < 2; ++j3) {
                    for (int k3 = -1; k3 < 3; ++k3) {
                        BlockState blockState1 = k3 < 0 ? Blocks.CHISELED_STONE_BRICKS.defaultBlockState() : Blocks.AIR.defaultBlockState();
                        mutablePos.setWithOffset(blockPos, j3 * direction.getStepX() + i3 * direction1.getStepX(), k3, j3 * direction.getStepZ() + i3 * direction1.getStepZ());
                        this.level.setBlockAndUpdate(mutablePos, blockState1);
                    }
                }
            }
        }

        for (int l1 = -1; l1 < 3; ++l1) {
            for (int j2 = -1; j2 < 4; ++j2) {
                if (l1 == -1 || l1 == 2 || j2 == -1 || j2 == 3) {
                    mutablePos.setWithOffset(blockPos, l1 * direction.getStepX(), j2, l1 * direction.getStepZ());
                    this.level.setBlock(mutablePos, Blocks.CHISELED_STONE_BRICKS.defaultBlockState(), 1 | 2);
                }
            }
        }

        BlockState blockState = ModBlocks.LUNARPORTAL_BLOCK.get().defaultBlockState().setValue(ModPortalBlock.AXIS, axis);
        for (int k2 = 0; k2 < 2; ++k2) {
            for (int l2 = 0; l2 < 3; ++l2) {
                mutablePos.setWithOffset(blockPos, k2 * direction.getStepX(), l2, k2 * direction.getStepZ());
                this.level.setBlock(mutablePos, blockState, 2 | 16);
            }
        }

        return Optional.of(new BlockUtil.FoundRectangle(blockPos.immutable(), 2, 3));
    }


    private boolean canPortalReplaceBlock(BlockPos.MutableBlockPos p_248971_) {
       BlockState blockstate = this.level.getBlockState(p_248971_);
       return blockstate.canBeReplaced() && blockstate.getFluidState().isEmpty();
    }

    private boolean canHostFrame(BlockPos p_77662_, BlockPos.MutableBlockPos p_77663_, Direction p_77664_, int p_77665_) {
       Direction direction = p_77664_.getClockWise();

       for(int i = -1; i < 3; ++i) {
          for(int j = -1; j < 4; ++j) {
             p_77663_.setWithOffset(p_77662_, p_77664_.getStepX() * i + direction.getStepX() * p_77665_, j, p_77664_.getStepZ() * i + direction.getStepZ() * p_77665_);
             if (j < 0 && !this.level.getBlockState(p_77663_).isSolid()) {
                return false;
             }

             if (j >= 0 && !this.canPortalReplaceBlock(p_77663_)) {
                return false;
             }
          }
       }

       return true;
    }
}