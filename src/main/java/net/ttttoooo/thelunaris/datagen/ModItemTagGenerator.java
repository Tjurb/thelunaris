package net.ttttoooo.thelunaris.datagen;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
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
		//Vanilla & Forge Tags
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
				ModBlocks.STRIPPED_SKYOAK_WOOD.get().asItem(),
				
				ModBlocks.VINEWOOD_LOG.get().asItem(),
				ModBlocks.VINEWOOD_WOOD.get().asItem(),
				ModBlocks.STRIPPED_VINEWOOD_LOG.get().asItem(),
				ModBlocks.STRIPPED_VINEWOOD_WOOD.get().asItem());
		
		this.tag(ModTags.Items.MOONCOW_TEMP_ITEMS)
			.add(ModItems.LUNAR_WHEAT.get());
		
		this.tag(ModTags.Items.ENRICHER_FUEL)
			.add(ModItems.LABRADORITE.get());		
		
		this.tag(ModTags.Items.LUNAR_PLANKS)
			.add(ModBlocks.CELEST_PLANKS.get().asItem(),
					ModBlocks.STELLAR_PLANKS.get().asItem(),
					ModBlocks.SKYOAK_PLANKS.get().asItem(),
					ModBlocks.VINEWOOD_PLANKS.get().asItem(),
					ModBlocks.ICEWOOD_PLANKS.get().asItem());

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
		
		this.tag(ModTags.Items.VINEWOOD_WOODS)
			.add(ModBlocks.VINEWOOD_LOG.get().asItem(),
					ModBlocks.VINEWOOD_WOOD.get().asItem(),
					ModBlocks.STRIPPED_VINEWOOD_LOG.get().asItem(),
					ModBlocks.STRIPPED_VINEWOOD_WOOD.get().asItem());
		
		this.tag(ModTags.Items.ICEWOOD_WOODS)
			.add(ModBlocks.ICEWOOD_LOG.get().asItem(),
					ModBlocks.ICEWOOD_WOOD.get().asItem(),
					ModBlocks.STRIPPED_ICEWOOD_LOG.get().asItem(),
					ModBlocks.STRIPPED_ICEWOOD_WOOD.get().asItem());
	
		this.tag(ModTags.Items.LUNAR_LOGS_ITEM)
			.add(ModBlocks.CELEST_LOG.get().asItem(),
					ModBlocks.CELEST_WOOD.get().asItem(),
					ModBlocks.STELLAR_LOG.get().asItem(),
					ModBlocks.STELLAR_WOOD.get().asItem(),
					ModBlocks.SKYOAK_LOG.get().asItem(),
					ModBlocks.SKYOAK_WOOD.get().asItem(),
					ModBlocks.VINEWOOD_LOG.get().asItem(),
					ModBlocks.VINEWOOD_WOOD.get().asItem(),
					ModBlocks.ICEWOOD_LOG.get().asItem(),
					ModBlocks.ICEWOOD_WOOD.get().asItem());
		
		this.tag(ModTags.Items.LUNAR_GRASS)
			.add(ModBlocks.LUNGRASS.get().asItem(),
					ModBlocks.CRIMSON_LUNGRASS.get().asItem(),
					ModBlocks.DUSKLIGHT_LUNGRASS.get().asItem());
		
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
		
		this.tag(Tags.Items.SEEDS)
			.add(ModItems.LUNAR_WHEAT_SEEDS.get(),
					ModItems.LOONBERRY.get(),
					ModItems.SARROT.get());
		
		this.tag(Tags.Items.CROPS)
			.add(ModItems.LUNAR_WHEAT.get(),
					ModItems.LOONBERRY.get(),
					ModItems.SARROT.get());
		
		this.tag(ItemTags.SAPLINGS)
			.add(ModBlocks.CELEST_SAPLING.get().asItem(),
					ModBlocks.SKYOAK_SAPLING.get().asItem(),
					ModBlocks.STELLAR_SAPLING.get().asItem(),
					ModBlocks.VINEWOOD_SAPLING.get().asItem());
		
		this.tag(ItemTags.LEAVES)
			.add(ModBlocks.CELEST_LEAVES.get().asItem(),
					ModBlocks.GLOWING_CELEST_LEAVES.get().asItem(),
					ModBlocks.SKYOAK_LEAVES.get().asItem(),
					ModBlocks.GLOWING_SKYOAK_LEAVES.get().asItem(),
					ModBlocks.STELLAR_LEAVES.get().asItem(),
					ModBlocks.GLOWING_STELLAR_LEAVES.get().asItem(),
					ModBlocks.VINEWOOD_LEAVES.get().asItem(),
					ModBlocks.ICEWOOD_LEAVES.get().asItem());
		
		this.tag(ItemTags.LOGS).addTag(ModTags.Items.LUNAR_LOGS_ITEM);
		
		//Forge Tags
		this.tag(forge("dusts"))
			.add(ModItems.HEXDUST.get());
		
		this.tag(forge("gems"))
			.add(ModItems.LABRADORITE.get(),
					ModItems.LUNARITE.get());
		
		this.tag(forge("ingots"))
			.add(ModItems.EMOONSTEEL.get(),
					ModItems.MOONSTEEL.get());
		
		this.tag(forge("nuggets"))
			.add(ModItems.EMOONSTEEL_NUGGET.get(),
					ModItems.MOONSTEEL_NUGGET.get());
		
		//Tool & Armor Tags
		this.tag(ItemTags.SWORDS)
			.add(ModItems.VAILSTONE_SWORD.get(),
					ModItems.MOONSTEEL_SWORD.get(),
					ModItems.EMOONSTEEL_SWORD.get(),
					ModItems.LUNARITE_SWORD.get());

		this.tag(ItemTags.PICKAXES)
			.add(ModItems.VAILSTONE_PICKAXE.get(),
					ModItems.MOONSTEEL_PICKAXE.get(),
					ModItems.EMOONSTEEL_PICKAXE.get(),
					ModItems.LUNARITE_PICKAXE.get());
		
		this.tag(ItemTags.AXES)
			.add(ModItems.VAILSTONE_AXE.get(),
					ModItems.MOONSTEEL_AXE.get(),
					ModItems.EMOONSTEEL_AXE.get(),
					ModItems.LUNARITE_AXE.get());
		
		this.tag(ItemTags.SHOVELS)
			.add(ModItems.VAILSTONE_SHOVEL.get(),
					ModItems.MOONSTEEL_SHOVEL.get(),
					ModItems.EMOONSTEEL_SHOVEL.get(),
					ModItems.LUNARITE_SHOVEL.get());
		
		this.tag(ItemTags.HOES)
			.add(ModItems.VAILSTONE_HOE.get(),
					ModItems.MOONSTEEL_HOE.get(),
					ModItems.EMOONSTEEL_HOE.get(),
					ModItems.LUNARITE_HOE.get());
	}
	
	private static TagKey<Item> forge(String name){
		return ItemTags.create(new ResourceLocation("forge", name));
	}
}
