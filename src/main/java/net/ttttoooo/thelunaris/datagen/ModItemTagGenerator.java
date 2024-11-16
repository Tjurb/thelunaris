package net.ttttoooo.thelunaris.datagen;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.block.ModBlocks;
import net.ttttoooo.thelunaris.item.ModItems;
import net.ttttoooo.thelunaris.util.ModTags;

public class ModItemTagGenerator extends ItemTagsProvider {

	public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<Provider> p_275729_,
			CompletableFuture<TagLookup<Block>> p_275322_,
			@Nullable ExistingFileHelper existingFileHelper) {
		super(p_275343_, p_275729_, p_275322_, TheLunaris.MODID, existingFileHelper);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void addTags(Provider p_256380_) {
		this.tag(ItemTags.LOGS_THAT_BURN)
		.add(ModBlocks.CELEST_LOG.get().asItem(),
				ModBlocks.CELEST_WOOD.get().asItem(),
				ModBlocks.STRIPPED_CELEST_LOG.get().asItem(),
				ModBlocks.STRIPPED_CELEST_WOOD.get().asItem(),
				
				ModBlocks.STELLAR_LOG.get().asItem(),
				ModBlocks.STELLAR_WOOD.get().asItem(),
				ModBlocks.STRIPPED_STELLAR_LOG.get().asItem(),
				ModBlocks.STRIPPED_STELLAR_WOOD.get().asItem(),
				
				ModBlocks.SKYOAK_LOG.get().asItem(),
				ModBlocks.SKYOAK_WOOD.get().asItem(),
				ModBlocks.STRIPPED_SKYOAK_LOG.get().asItem(),
				ModBlocks.STRIPPED_SKYOAK_WOOD.get().asItem());
		
		this.tag(ModTags.Items.MOONCOW_TEMP_ITEMS)
		.add(ModItems.LUNAR_WHEAT.get());
		
		this.tag(ModTags.Items.ENRICHER_FUEL)
		.add(ModItems.LABRADORITE.get());
	}

}
