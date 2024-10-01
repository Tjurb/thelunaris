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
		simpleItem(ModItems.RAW_MOONSTEEL);
		simpleItem(ModItems.EMOONSTEEL);
		simpleItem(ModItems.LUNARITE);
		simpleItem(ModItems.LOONBERRY);
		
		//tools
		handheldItem(ModItems.MOONSTEEL_SWORD);
		handheldItem(ModItems.MOONSTEEL_PICKAXE);
		handheldItem(ModItems.MOONSTEEL_AXE);
		handheldItem(ModItems.MOONSTEEL_SHOVEL);
		handheldItem(ModItems.MOONSTEEL_HOE);
		
		handheldItem(ModItems.EMOONSTEEL_SWORD);
		handheldItem(ModItems.EMOONSTEEL_PICKAXE);
		handheldItem(ModItems.EMOONSTEEL_AXE);
		handheldItem(ModItems.EMOONSTEEL_SHOVEL);
		handheldItem(ModItems.EMOONSTEEL_HOE);

		handheldItem(ModItems.LUNARITE_SWORD);
		handheldItem(ModItems.LUNARITE_PICKAXE);
		handheldItem(ModItems.LUNARITE_AXE);
		handheldItem(ModItems.LUNARITE_SHOVEL);
		handheldItem(ModItems.LUNARITE_HOE);
		
		//walls
		wallItem(ModBlocks.VAILSTONEBRICK_WALL, ModBlocks.VAILSTONEBRICK);
		wallItem(ModBlocks.SMOOTHGNEISS_WALL, ModBlocks.SMOOTHGNEISS);
		wallItem(ModBlocks.SMOOTHLUNARSLATE_WALL, ModBlocks.SMOOTHLUNARSLATE);
		wallItem(ModBlocks.SMOOTHMARBLE_WALL, ModBlocks.SMOOTHMARBLE);
		
		//stairs
		evenSimplerBlockItem(ModBlocks.VAILSTONEBRICK_STAIRS);
		evenSimplerBlockItem(ModBlocks.SMOOTHGNEISS_STAIRS);
		evenSimplerBlockItem(ModBlocks.SMOOTHLUNARSLATE_STAIRS);
		evenSimplerBlockItem(ModBlocks.SMOOTHMARBLE_STAIRS);
		evenSimplerBlockItem(ModBlocks.CELEST_STAIRS);
		evenSimplerBlockItem(ModBlocks.STELLAR_STAIRS);
		evenSimplerBlockItem(ModBlocks.SKYOAK_STAIRS);
		
		//slabs
		evenSimplerBlockItem(ModBlocks.VAILSTONEBRICK_SLAB);
		evenSimplerBlockItem(ModBlocks.SMOOTHGNEISS_SLAB);
		evenSimplerBlockItem(ModBlocks.SMOOTHLUNARSLATE_SLAB);
		evenSimplerBlockItem(ModBlocks.SMOOTHMARBLE_SLAB);
		evenSimplerBlockItem(ModBlocks.CELEST_SLAB);
		evenSimplerBlockItem(ModBlocks.STELLAR_SLAB);
		evenSimplerBlockItem(ModBlocks.SKYOAK_SLAB);

	}
	
	private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
		return withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/generated")).texture("layer0",
				new ResourceLocation(TheLunaris.MODID, "item/" + item.getId().getPath()));
	}
	
	private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
		return withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/handheld")).texture("layer0",
				new ResourceLocation(TheLunaris.MODID, "item/" + item.getId().getPath()));
	}
	
	public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(TheLunaris.MODID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }
	
	public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
		this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
				.texture("wall", new ResourceLocation(TheLunaris.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
	}
	
}
