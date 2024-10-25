package net.ttttoooo.thelunaris.block.custom.portal;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.ITeleporter;
import net.ttttoooo.thelunaris.worldgen.dimension.ModDimensions;

public class ModPortalTeleporter implements ITeleporter {
    private final ServerLevel level;
    private final BlockPos destination;

    public ModPortalTeleporter(ServerLevel level, BlockPos destination) {
        this.level = level;
        this.destination = destination;
    }
    
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!level.isClientSide && entity instanceof ServerPlayer serverPlayer) {
            ServerLevel destinationLevel = serverPlayer.getServer().getLevel(ModDimensions.LUNARIS_LEVEL_KEY);
            if (destinationLevel != null) {
                serverPlayer.changeDimension(destinationLevel, new ModPortalTeleporter(destinationLevel, new BlockPos(1, 80, 1)));
            }
        }
    }

    
}
