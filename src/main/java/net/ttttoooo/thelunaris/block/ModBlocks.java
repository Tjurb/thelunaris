package net.ttttoooo.thelunaris.block;

import net.minecraft.world.item.Item;

import java.util.function.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.item.ModItems;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS =
			DeferredRegister.create(ForgeRegistries.BLOCKS, TheLunaris.MODID);
	
//Special Blocks
	public static final RegistryObject<Block> MOONDIALBLOCK = registerBlock("moondialblock", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.ANCIENT_DEBRIS)));
	
//Tree Blocks
	public static final RegistryObject<Block> CELEST_WOOD = registerBlock("celest_wood", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> CELEST_LEAVES = registerBlock("celest_leaves", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> STELLAR_WOOD = registerBlock("stellar_wood", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STELLAR_LEAVES = registerBlock("stellar_leaves", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> SKYOAK_WOOD = registerBlock("skyoak_wood", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> SKYOAK_LEAVES = registerBlock("skyoak_leaves", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).sound(SoundType.GRASS)));
	
//Vailstone Blocks
	public static final RegistryObject<Block> VAILSTONE = registerBlock("vailstone", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
	public static final RegistryObject<Block> VAILSTONEBRICK = registerBlock("vailstonebrick", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).sound(SoundType.STONE)));
	public static final RegistryObject<Block> VAILSTONEBRICK_STAIRS = registerBlock("vailstonebrick_stairs", 
			() -> new StairBlock(() -> ModBlocks.VAILSTONEBRICK.get().defaultBlockState(),
			BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).sound(SoundType.STONE)));
	public static final RegistryObject<Block> VAILSTONEBRICK_SLAB = registerBlock("vailstonebrick_slab", 
			() -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).sound(SoundType.STONE)));
	public static final RegistryObject<Block> VAILSTONEBRICK_WALL = registerBlock("vailstonebrick_wall", 
			() -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).sound(SoundType.STONE)));
	
//Additional Stone Blocks
	public static final RegistryObject<Block> LUNARSHALE = registerBlock("lunarshale", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
	public static final RegistryObject<Block> LUNARSLATE = registerBlock("lunarslate", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SMOOTHLUNARSLATE = registerBlock("smoothlunarslate", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SMOOTHLUNARSLATE_STAIRS = registerBlock("smoothlunarslate_stairs", 
			() -> new StairBlock(() -> ModBlocks.SMOOTHLUNARSLATE.get().defaultBlockState(),
			BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SMOOTHLUNARSLATE_SLAB = registerBlock("smoothlunarslate_slab", 
			() -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SMOOTHLUNARSLATE_WALL = registerBlock("smoothlunarslate_wall", 
			() -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> GNEISS = registerBlock("gneiss", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SMOOTHGNEISS = registerBlock("smoothgneiss", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SMOOTHGNEISS_STAIRS = registerBlock("smoothgneiss_stairs", 
			() -> new StairBlock(() -> ModBlocks.SMOOTHGNEISS.get().defaultBlockState(),
			BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SMOOTHGNEISS_SLAB = registerBlock("smoothgneiss_slab", 
			() -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SMOOTHGNEISS_WALL = registerBlock("smoothgneiss_wall", 
			() -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> MARBLE = registerBlock("marble", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SMOOTHMARBLE = registerBlock("smoothmarble", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SMOOTHMARBLE_STAIRS = registerBlock("smoothmarble_stairs", 
			() -> new StairBlock(() -> ModBlocks.SMOOTHMARBLE.get().defaultBlockState(),
			BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SMOOTHMARBLE_SLAB = registerBlock("smoothmarble_slab", 
			() -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SMOOTHMARBLE_WALL = registerBlock("smoothmarble_wall", 
			() -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
	
//Ore Blocks
	public static final RegistryObject<Block> LUNARITE_ORE = registerBlock("lunarite_ore", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
	
	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn);
		return toReturn;
	}
	
	private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
		return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
	}
	
	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
}
