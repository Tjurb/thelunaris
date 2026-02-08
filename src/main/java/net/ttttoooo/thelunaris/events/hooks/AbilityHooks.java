package net.ttttoooo.thelunaris.events.hooks;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.ttttoooo.thelunaris.block.ModBlocks;

import java.util.Map;

public class AbilityHooks {
	
    public static class ToolHooks {
        public static final Map<Block, Block> STRIPPABLES = (new ImmutableMap.Builder<Block, Block>())
                .put(ModBlocks.CELEST_LOG.get(), ModBlocks.STRIPPED_CELEST_LOG.get())
                .put(ModBlocks.STELLAR_LOG.get(), ModBlocks.STRIPPED_STELLAR_LOG.get())
                .put(ModBlocks.SKYOAK_LOG.get(), ModBlocks.STRIPPED_SKYOAK_LOG.get())
                .put(ModBlocks.ICEWOOD_LOG.get(), ModBlocks.STRIPPED_ICEWOOD_LOG.get())
                .put(ModBlocks.VINEWOOD_LOG.get(), ModBlocks.STRIPPED_VINEWOOD_LOG.get())
                .put(ModBlocks.CELEST_WOOD.get(), ModBlocks.STRIPPED_CELEST_WOOD.get())
                .put(ModBlocks.STELLAR_WOOD.get(), ModBlocks.STRIPPED_STELLAR_WOOD.get())
                .put(ModBlocks.SKYOAK_WOOD.get(), ModBlocks.STRIPPED_SKYOAK_WOOD.get())
                .put(ModBlocks.ICEWOOD_WOOD.get(), ModBlocks.STRIPPED_ICEWOOD_WOOD.get())
                .put(ModBlocks.VINEWOOD_WOOD.get(), ModBlocks.STRIPPED_VINEWOOD_WOOD.get())
                .build();

        public static final Map<Block, Block> FLATTENABLES = (new ImmutableMap.Builder<Block, Block>())
                //.put(ModBlocks.LUNDIRT.get(), ModBlocks.LUNDIRT_PATH.get())
                //.put(ModBlocks.LUNGRASS_BLOCK.get(), ModBlocks.LUNDIRT_PATH.get())
                .build();

        public static final Map<Block, Block> TILLABLES = (new ImmutableMap.Builder<Block, Block>())
                .put(ModBlocks.LUNDIRT.get(), ModBlocks.LUNDIRT_FARMLAND.get())
                .put(ModBlocks.LUNGRASS_BLOCK.get(), ModBlocks.LUNDIRT_FARMLAND.get())
                .put(ModBlocks.CRIMSON_LUNGRASS_BLOCK.get(), ModBlocks.LUNDIRT_FARMLAND.get())
                .put(ModBlocks.DUSKLIGHT_LUNGRASS_BLOCK.get(), ModBlocks.LUNDIRT_FARMLAND.get())
                .build();

        public static boolean debuffTools;

        public static BlockState setupToolActions(LevelAccessor accessor, BlockPos pos, BlockState old, ToolAction action) {
            Block oldBlock = old.getBlock();
            if (action == ToolActions.AXE_STRIP) {
                if (STRIPPABLES.containsKey(oldBlock)) {
                    return STRIPPABLES.get(oldBlock).withPropertiesOf(old);
                }
            } else if (action == ToolActions.SHOVEL_FLATTEN) {
                if (FLATTENABLES.containsKey(oldBlock)) {
                    return FLATTENABLES.get(oldBlock).withPropertiesOf(old);
                }
            } else if (action == ToolActions.HOE_TILL) {
                if (accessor.getBlockState(pos.above()).isAir()) {
                    if (TILLABLES.containsKey(oldBlock)) {
                        return TILLABLES.get(oldBlock).withPropertiesOf(old);
                    }
                }
            }
            return old;
        }

        public static boolean blockTooFar(Player player, InteractionHand hand) {
                AttributeInstance reachDistance = player.getAttribute(ForgeMod.BLOCK_REACH.get());
                if (reachDistance != null) {
                    double reach = player.getAttributeValue(ForgeMod.BLOCK_REACH.get());
                    double trueReach = reach == 0 ? 0 : reach + (player.isCreative() ? 0.5 : 0); // [CODE COPY] - IForgePlayer#getReachDistance().
                    return player.pick(trueReach, 0.0F, false).getType() != HitResult.Type.BLOCK;
                }
            
            return false;
        }

        public static boolean entityTooFar(Entity target, Player player, InteractionHand hand) {
                AttributeInstance attackRange = player.getAttribute(ForgeMod.ENTITY_REACH.get());
                if (attackRange != null){
                    double range = player.getAttributeValue(ForgeMod.ENTITY_REACH.get());
                    double trueReach = range == 0 ? 0 : range + (player.isCreative() ? 3 : 0); // [CODE COPY] - IForgePlayer#getAttackRange().
                    return !player.isCloseEnough(target, trueReach);
                    
                }
            
            return false;
        }
    }
}