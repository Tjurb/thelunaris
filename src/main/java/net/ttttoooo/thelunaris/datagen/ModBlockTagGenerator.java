package net.ttttoooo.thelunaris.datagen;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.block.ModBlocks;
import net.ttttoooo.thelunaris.util.ModTags;

public class ModBlockTagGenerator extends BlockTagsProvider{
	
	public ModBlockTagGenerator(PackOutput output, CompletableFuture<Provider> lookupProvider,
			@Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, TheLunaris.MODID, existingFileHelper);
		// TODO Auto-generated constructor stub
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
					
					ModBlocks.VAILSTONE_FURNACE.get());
		
		this.tag(BlockTags.DIRT)
			.add(ModBlocks.LUNDIRT.get(),
					ModBlocks.LUNGRASS_BLOCK.get());
		
		this.tag(BlockTags.SAND)
			.add(ModBlocks.LUNSAND.get());
		
		this.tag(ModTags.Blocks.LUNAR_PORTAL_BLOCKS)
			.add(Blocks.CHISELED_SANDSTONE);

		this.tag(ModTags.Blocks.VAILSTONE_ORE_REPLACEABLES)
			.add(ModBlocks.VAILSTONE.get());

		this.tag(ModTags.Blocks.GNEISS_ORE_REPLACEABLES)
			.add(ModBlocks.GNEISS.get());
		
		this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
			.add(ModBlocks.LUNDIRT.get(),
					ModBlocks.LUNSAND.get(),
					ModBlocks.LUNGRASS_BLOCK.get());
		
		this.tag(ModTags.Blocks.NEEDS_MOONSTEEL_TOOL)
			.add(ModBlocks.MOONDIALBLOCK.get(),
					ModBlocks.MOONSTEEL_ORE.get(),
					ModBlocks.LABRADORITE_ORE.get());
		
		this.tag(ModTags.Blocks.NEEDS_EMOONSTEEL_TOOL)
			.add(ModBlocks.LUNARITE_ORE.get());
		
		this.tag(BlockTags.WALLS)
			.add(ModBlocks.VAILSTONEBRICK_WALL.get(),
					ModBlocks.COBBLED_VAILSTONE_WALL.get(),
					ModBlocks.LUNSANDSTONE_WALL.get(),
					ModBlocks.SMOOTHLUNARSLATE_WALL.get(),
					ModBlocks.SMOOTHGNEISS_WALL.get(),
					ModBlocks.SMOOTHMARBLE_WALL.get());
		
		this.tag(BlockTags.MINEABLE_WITH_AXE)
			.add(ModBlocks.CELEST_LOG.get(),
					ModBlocks.CELEST_WOOD.get(),
					ModBlocks.STRIPPED_CELEST_LOG.get(),
					ModBlocks.STRIPPED_CELEST_WOOD.get(),
					ModBlocks.CELEST_PLANKS.get(),
					ModBlocks.CELEST_STAIRS.get(),
					ModBlocks.CELEST_SLAB.get(),
				
					ModBlocks.STELLAR_LOG.get(),
					ModBlocks.STELLAR_WOOD.get(),
					ModBlocks.STRIPPED_STELLAR_LOG.get(),
					ModBlocks.STRIPPED_STELLAR_WOOD.get(),
					ModBlocks.STELLAR_PLANKS.get(),
					ModBlocks.STELLAR_STAIRS.get(),
					ModBlocks.STELLAR_SLAB.get(),
				
					ModBlocks.SKYOAK_LOG.get(),
					ModBlocks.SKYOAK_WOOD.get(),
					ModBlocks.STRIPPED_SKYOAK_LOG.get(),
					ModBlocks.STRIPPED_SKYOAK_WOOD.get(),
					ModBlocks.SKYOAK_PLANKS.get(),
					ModBlocks.SKYOAK_STAIRS.get(),
					ModBlocks.SKYOAK_SLAB.get(),
					
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
	}
}
