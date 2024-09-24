package net.ttttoooo.thelunaris.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.block.ModBlocks;
import net.ttttoooo.thelunaris.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider{

	public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, TheLunaris.MODID, existingFileHelper);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void registerModels() {
		simpleItem(ModItems.MOONDIAL);
		simpleItem(ModItems.MOONSTEEL);
		simpleItem(ModItems.EMOONSTEEL);
		simpleItem(ModItems.LUNARITE);
		
		wallItem(ModBlocks.VAILSTONEBRICK_WALL, ModBlocks.VAILSTONEBRICK);
		wallItem(ModBlocks.SMOOTHGNEISS_WALL, ModBlocks.SMOOTHGNEISS);
		wallItem(ModBlocks.SMOOTHLUNARSLATE_WALL, ModBlocks.SMOOTHLUNARSLATE);
		wallItem(ModBlocks.SMOOTHMARBLE_WALL, ModBlocks.SMOOTHMARBLE);
		
	}
	
	private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
		return withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/generated")).texture("layer0",
				new ResourceLocation(TheLunaris.MODID, "item/" + item.getId().getPath()));
	}
	
	public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
		this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
				.texture("wall", new ResourceLocation(TheLunaris.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
	}
	
}
