package net.ttttoooo.thelunaris.block.custom.portal;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.ttttoooo.thelunaris.worldgen.dimension.ModDimensions;

public class ModPortalBlock extends NetherPortalBlock {
    public ModPortalBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!level.isClientSide && entity instanceof ServerPlayer serverPlayer) {
            handleLunarisPortal(serverPlayer, pos);
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
