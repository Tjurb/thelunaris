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
		
		this.tag(ModTags.Items.LUNAR_PLANKS)
			.add(ModBlocks.CELEST_PLANKS.get().asItem(),
					ModBlocks.STELLAR_PLANKS.get().asItem(),
					ModBlocks.SKYOAK_PLANKS.get().asItem());

		this.tag(ModTags.Items.CELEST_WOODS)
			.add(ModBlocks.CELEST_LOG.get().asItem(),
					ModBlocks.CELEST_WOOD.get().asItem(),
					ModBlocks.STRIPPED_CELEST_LOG.get().asItem(),
					ModBlocks.STRIPPED_CELEST_WOOD.get().asItem());
		
		this.tag(ModTags.Items.STELLAR_WOODS)
			.add(ModBlocks.STELLAR_LOG.get().asItem(),
					ModBlocks.STELLAR_WOOD.get().asItem(),
					ModBlocks.STRIPPED_STELLAR_LOG.get().asItem(),
					ModBlocks.STRIPPED_STELLAR_WOOD.get().asItem());
		
		this.tag(ModTags.Items.SKYOAK_WOODS)
			.add(ModBlocks.SKYOAK_LOG.get().asItem(),
					ModBlocks.SKYOAK_WOOD.get().asItem(),
					ModBlocks.STRIPPED_SKYOAK_LOG.get().asItem(),
					ModBlocks.STRIPPED_SKYOAK_WOOD.get().asItem());
		
		this.tag(ModTags.Items.LUNAR_LOGS_ITEM)
			.add(ModBlocks.CELEST_LOG.get().asItem(),
					ModBlocks.CELEST_WOOD.get().asItem(),
					ModBlocks.STELLAR_LOG.get().asItem(),
					ModBlocks.STELLAR_WOOD.get().asItem(),
					ModBlocks.SKYOAK_LOG.get().asItem(),
					ModBlocks.SKYOAK_WOOD.get().asItem());
		
		this.tag(ItemTags.TRIMMABLE_ARMOR)
			.add(ModItems.MOONSTEEL_HELMET.get(),
					ModItems.MOONSTEEL_CHESTPLATE.get(),
					ModItems.MOONSTEEL_LEGGINGS.get(),
					ModItems.MOONSTEEL_BOOTS.get(),
					ModItems.EMOONSTEEL_HELMET.get(),
					ModItems.EMOONSTEEL_CHESTPLATE.get(),
					ModItems.EMOONSTEEL_LEGGINGS.get(),
					ModItems.EMOONSTEEL_BOOTS.get(),
					ModItems.LUNARITE_HELMET.get(),
					ModItems.LUNARITE_CHESTPLATE.get(),
					ModItems.LUNARITE_LEGGINGS.get(),
					ModItems.LUNARITE_BOOTS.get());
		
	}
}
