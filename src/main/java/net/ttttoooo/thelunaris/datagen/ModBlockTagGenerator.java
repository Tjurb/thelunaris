package net.ttttoooo.thelunaris.datagen;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.block.ModBlocks;
import net.ttttoooo.thelunaris.util.ModTags;

public class ModBlockTagGenerator extends BlockTagsProvider{
	
	public ModBlockTagGenerator(PackOutput output, CompletableFuture<Provider> lookupProvider,
			@Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, TheLunaris.MODID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider pProvider) {
		this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
			.add(ModBlocks.VAILSTONE.get(),
					ModBlocks.VAILSTONEBRICK.get(),
					ModBlocks.VAILSTONEBRICK_STAIRS.get(),
					ModBlocks.VAILSTONEBRICK_SLAB.get(),
					ModBlocks.VAILSTONEBRICK_WALL.get(),
					ModBlocks.COBBLED_VAILSTONE.get(),
					ModBlocks.COBBLED_VAILSTONE_STAIRS.get(),
					ModBlocks.COBBLED_VAILSTONE_SLAB.get(),
					ModBlocks.COBBLED_VAILSTONE_WALL.get(),
					ModBlocks.LUNARSHALE.get(),
					ModBlocks.LUNARSLATE.get(),
					ModBlocks.SMOOTHLUNARSLATE.get(),
					ModBlocks.SMOOTHLUNARSLATE_STAIRS.get(),
					ModBlocks.SMOOTHLUNARSLATE_SLAB.get(),
					ModBlocks.SMOOTHLUNARSLATE_WALL.get(),
					ModBlocks.GNEISS.get(),
					ModBlocks.SMOOTHGNEISS.get(),
					ModBlocks.SMOOTHGNEISS_STAIRS.get(),
					ModBlocks.SMOOTHGNEISS_SLAB.get(),
					ModBlocks.SMOOTHGNEISS_WALL.get(),
					ModBlocks.MARBLE.get(),
					ModBlocks.SMOOTHMARBLE.get(),
					ModBlocks.SMOOTHMARBLE_STAIRS.get(),
					ModBlocks.SMOOTHMARBLE_SLAB.get(),
					ModBlocks.SMOOTHMARBLE_WALL.get(),
					ModBlocks.LUNSANDSTONE.get(),
					ModBlocks.LUNSANDSTONE_STAIRS.get(),
					ModBlocks.LUNSANDSTONE_SLAB.get(),
					ModBlocks.LUNSANDSTONE_WALL.get(),
					ModBlocks.LUNCLAY_BRICK_BLOCK.get(),
					ModBlocks.LUNCLAY_BRICK_BLOCK_STAIRS.get(),
					ModBlocks.LUNCLAY_BRICK_BLOCK_SLAB.get(),
					ModBlocks.LUNCLAY_BRICK_BLOCK_WALL.get(),
					
					ModBlocks.MOONDIALBLOCK.get(),
					ModBlocks.VAILSTONE_FURNACE.get(),
					ModBlocks.LUNARITE_BLOCK.get(),
					ModBlocks.LABRADORITE_BLOCK.get(),
					ModBlocks.EMOONSTEEL_BLOCK.get(),
					ModBlocks.MOONSTEEL_BLOCK.get(),
					ModBlocks.RAW_MOONSTEEL_BLOCK.get(),

					ModBlocks.LABRADORITE_ORE.get(),
					ModBlocks.MOONSTEEL_ORE.get(),
					ModBlocks.LUNARITE_ORE.get(),
					ModBlocks.LUNARIS_COAL_ORE.get(),
					
					ModBlocks.DEEP_LABRADORITE_ORE.get(),
					ModBlocks.DEEP_MOONSTEEL_ORE.get(),
					ModBlocks.DEEP_LUNARITE_ORE.get(),
					ModBlocks.DEEP_LUNARIS_COAL_ORE.get(),
					
					ModBlocks.LUNGLASS.get(),
					ModBlocks.LUNGLASS_PANE.get(),
					
					ModBlocks.VAILSTONE_FURNACE.get());
		
		this.tag(BlockTags.IMPERMEABLE)
			.add(ModBlocks.LUNGLASS.get());
		
		this.tag(Tags.Blocks.GLASS_COLORLESS)
			.add(ModBlocks.LUNGLASS.get());
		
		this.tag(Tags.Blocks.GLASS_PANES_COLORLESS)
			.add(ModBlocks.LUNGLASS_PANE.get());
		
		this.tag(BlockTags.DIRT)
			.add(ModBlocks.LUNDIRT.get(),
					ModBlocks.LUNGRASS_BLOCK.get(),
					ModBlocks.CRIMSON_LUNGRASS_BLOCK.get(),
					ModBlocks.DUSKLIGHT_LUNGRASS_BLOCK.get());
		
		this.tag(ModTags.Blocks.LUNAR_DIRTS)
			.add(ModBlocks.LUNDIRT.get(),
					ModBlocks.LUNGRASS_BLOCK.get(),
					ModBlocks.CRIMSON_LUNGRASS_BLOCK.get(),
					ModBlocks.DUSKLIGHT_LUNGRASS_BLOCK.get());
		
		this.tag(BlockTags.SAND)
			.add(ModBlocks.LUNSAND.get());
		
		this.tag(ModTags.Blocks.LUNAR_PORTAL_BLOCKS)
			.add(Blocks.CHISELED_STONE_BRICKS);

		this.tag(ModTags.Blocks.VAILSTONE_ORE_REPLACEABLES)
			.add(ModBlocks.VAILSTONE.get());

		this.tag(ModTags.Blocks.GNEISS_ORE_REPLACEABLES)
			.add(ModBlocks.GNEISS.get());
		
		this.tag(ModTags.Blocks.SANDDIRT_REPLACEABLES)
			.add(ModBlocks.LUNDIRT.get(),
					ModBlocks.LUNSAND.get());
		
		this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
			.add(ModBlocks.LUNDIRT.get(),
					ModBlocks.LUNSAND.get(),
					ModBlocks.LUNCLAY_BLOCK.get(),
					ModBlocks.LUNGRASS_BLOCK.get(),
					ModBlocks.CRIMSON_LUNGRASS_BLOCK.get(),
					ModBlocks.DUSKLIGHT_LUNGRASS_BLOCK.get());
		
		this.tag(ModTags.Blocks.NEEDS_VAILSTONE_TOOL)
		.add(ModBlocks.MOONSTEEL_ORE.get());
		
		this.tag(ModTags.Blocks.NEEDS_MOONSTEEL_TOOL)
			.add(ModBlocks.MOONDIALBLOCK.get(),
					ModBlocks.LABRADORITE_ORE.get());
		
		this.tag(ModTags.Blocks.NEEDS_EMOONSTEEL_TOOL)
			.add(ModBlocks.LUNARITE_ORE.get());
		
		this.tag(BlockTags.WALLS)
			.add(ModBlocks.VAILSTONEBRICK_WALL.get(),
					ModBlocks.COBBLED_VAILSTONE_WALL.get(),
					ModBlocks.LUNCLAY_BRICK_BLOCK_WALL.get(),
					ModBlocks.LUNSANDSTONE_WALL.get(),
					ModBlocks.SMOOTHLUNARSLATE_WALL.get(),
					ModBlocks.SMOOTHGNEISS_WALL.get(),
					ModBlocks.SMOOTHMARBLE_WALL.get());
		
		this.tag(BlockTags.FENCES)
			.add(ModBlocks.CELEST_FENCE.get(),
					ModBlocks.STELLAR_FENCE.get(),
					ModBlocks.SKYOAK_FENCE.get());

		this.tag(BlockTags.FENCE_GATES)
			.add(ModBlocks.CELEST_FENCE_GATE.get(),
					ModBlocks.STELLAR_FENCE_GATE.get(),
					ModBlocks.SKYOAK_FENCE_GATE.get());
		
		this.tag(BlockTags.MINEABLE_WITH_AXE)
			.add(ModBlocks.CELEST_LOG.get(),
					ModBlocks.CELEST_WOOD.get(),
					ModBlocks.STRIPPED_CELEST_LOG.get(),
					ModBlocks.STRIPPED_CELEST_WOOD.get(),
					ModBlocks.CELEST_PLANKS.get(),
					ModBlocks.CELEST_STAIRS.get(),
					ModBlocks.CELEST_SLAB.get(),
					ModBlocks.CELEST_BUTTON.get(),
					ModBlocks.CELEST_PRESSURE_PLATE.get(),
					ModBlocks.CELEST_FENCE.get(),
					ModBlocks.CELEST_FENCE_GATE.get(),
					ModBlocks.CELEST_DOOR.get(),
					ModBlocks.CELEST_TRAPDOOR.get(),
				
					ModBlocks.STELLAR_LOG.get(),
					ModBlocks.STELLAR_WOOD.get(),
					ModBlocks.STRIPPED_STELLAR_LOG.get(),
					ModBlocks.STRIPPED_STELLAR_WOOD.get(),
					ModBlocks.STELLAR_PLANKS.get(),
					ModBlocks.STELLAR_STAIRS.get(),
					ModBlocks.STELLAR_SLAB.get(),
					ModBlocks.STELLAR_BUTTON.get(),
					ModBlocks.STELLAR_PRESSURE_PLATE.get(),
					ModBlocks.STELLAR_FENCE.get(),
					ModBlocks.STELLAR_FENCE_GATE.get(),
					ModBlocks.STELLAR_DOOR.get(),
					ModBlocks.STELLAR_TRAPDOOR.get(),
				
					ModBlocks.SKYOAK_LOG.get(),
					ModBlocks.SKYOAK_WOOD.get(),
					ModBlocks.STRIPPED_SKYOAK_LOG.get(),
					ModBlocks.STRIPPED_SKYOAK_WOOD.get(),
					ModBlocks.SKYOAK_PLANKS.get(),
					ModBlocks.SKYOAK_STAIRS.get(),
					ModBlocks.SKYOAK_SLAB.get(),
					ModBlocks.SKYOAK_BUTTON.get(),
					ModBlocks.SKYOAK_PRESSURE_PLATE.get(),
					ModBlocks.SKYOAK_FENCE.get(),
					ModBlocks.SKYOAK_FENCE_GATE.get(),
					ModBlocks.SKYOAK_DOOR.get(),
					ModBlocks.SKYOAK_TRAPDOOR.get(),
					
					ModBlocks.LUNAR_CRAFTER.get(),
					ModBlocks.LUNARIS_CRAFTING_TABLE.get());
		
		this.tag(BlockTags.LOGS_THAT_BURN)
			.add(ModBlocks.CELEST_LOG.get(),
					ModBlocks.CELEST_WOOD.get(),
					ModBlocks.STRIPPED_CELEST_LOG.get(),
					ModBlocks.STRIPPED_CELEST_WOOD.get(),
					
					ModBlocks.STELLAR_LOG.get(),
					ModBlocks.STELLAR_WOOD.get(),
					ModBlocks.STRIPPED_STELLAR_LOG.get(),
					ModBlocks.STRIPPED_STELLAR_WOOD.get(),
					
					ModBlocks.SKYOAK_LOG.get(),
					ModBlocks.SKYOAK_WOOD.get(),
					ModBlocks.STRIPPED_SKYOAK_LOG.get(),
					ModBlocks.STRIPPED_SKYOAK_WOOD.get());
		
		this.tag(ModTags.Blocks.LUNAR_LOGS)
			.add(ModBlocks.CELEST_LOG.get(),
					ModBlocks.STRIPPED_CELEST_LOG.get(),
					ModBlocks.CELEST_WOOD.get(),
					ModBlocks.STRIPPED_CELEST_WOOD.get(),
					
					ModBlocks.SKYOAK_LOG.get(),
					ModBlocks.STRIPPED_SKYOAK_LOG.get(),
					ModBlocks.SKYOAK_WOOD.get(),
					ModBlocks.STRIPPED_SKYOAK_WOOD.get(),
					
					ModBlocks.STELLAR_LOG.get(),
					ModBlocks.STRIPPED_STELLAR_LOG.get(),
					ModBlocks.STELLAR_WOOD.get(),
					ModBlocks.STRIPPED_STELLAR_WOOD.get());
	}
}
