package net.ttttoooo.thelunaris.block;

import net.minecraft.world.item.Item;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
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
	public static final RegistryObject<Block> RAW_MOONSTEEL_BLOCK = registerBlock("raw_moonsteel_block", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).sound(SoundType.METAL)));
	public static final RegistryObject<Block> MOONSTEEL_BLOCK = registerBlock("moonsteel_block", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL)));
	public static final RegistryObject<Block> EMOONSTEEL_BLOCK = registerBlock("emoonsteel_block", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL)));
	public static final RegistryObject<Block> LUNARITE_BLOCK = registerBlock("lunarite_block", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).sound(SoundType.AMETHYST)));
	public static final RegistryObject<Block> TEKTITE_BLOCK = registerBlock("tektite_block", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.STONE)));
	
//Dirt and Sand Blocks	
	public static final RegistryObject<Block> LUNDIRT = registerBlock("lundirt", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT).sound(SoundType.GRAVEL)));
	public static final RegistryObject<Block> LUNGRASS = registerBlock("lungrass", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> LUNSAND = registerBlock("lunsand", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.SAND).sound(SoundType.SAND)));
	public static final RegistryObject<Block> LUNSANDSTONE = registerBlock("lunsandstone", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).sound(SoundType.STONE)));
	public static final RegistryObject<Block> LUNSANDSTONE_STAIRS = registerBlock("lunsandstone_stairs", 
			() -> new StairBlock(() -> ModBlocks.LUNSANDSTONE.get().defaultBlockState(),
			BlockBehaviour.Properties.copy(Blocks.SANDSTONE).sound(SoundType.STONE)));
	public static final RegistryObject<Block> LUNSANDSTONE_SLAB = registerBlock("lunsandstone_slab", 
			() -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).sound(SoundType.STONE)));
	public static final RegistryObject<Block> LUNSANDSTONE_WALL = registerBlock("lunsandstone_wall", 
			() -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).sound(SoundType.STONE)));

	//Tree Blocks
	public static final RegistryObject<Block> CELEST_WOOD = registerBlock("celest_wood", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> CELEST_LEAVES = registerBlock("celest_leaves", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> CELEST_PLANKS = registerBlock("celest_planks", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> CELEST_STAIRS = registerBlock("celest_stairs", 
			() -> new StairBlock(() -> ModBlocks.CELEST_PLANKS.get().defaultBlockState(),
			BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> CELEST_SLAB = registerBlock("celest_slab", 
			() -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
	
	public static final RegistryObject<Block> STELLAR_WOOD = registerBlock("stellar_wood", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STELLAR_LEAVES = registerBlock("stellar_leaves", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> STELLAR_PLANKS = registerBlock("stellar_planks", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STELLAR_STAIRS = registerBlock("stellar_stairs", 
			() -> new StairBlock(() -> ModBlocks.STELLAR_PLANKS.get().defaultBlockState(),
			BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STELLAR_SLAB = registerBlock("stellar_slab", 
			() -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
	
	public static final RegistryObject<Block> SKYOAK_WOOD = registerBlock("skyoak_wood", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> SKYOAK_LEAVES = registerBlock("skyoak_leaves", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> SKYOAK_PLANKS = registerBlock("skyoak_planks", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> SKYOAK_STAIRS = registerBlock("skyoak_stairs", 
			() -> new StairBlock(() -> ModBlocks.SKYOAK_PLANKS.get().defaultBlockState(),
			BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> SKYOAK_SLAB = registerBlock("skyoak_slab", 
			() -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
	
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
			() -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(3f)
					.requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
	public static final RegistryObject<Block> MOONSTEEL_ORE = registerBlock("moonsteel_ore", 
			() -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f)
					.requiresCorrectToolForDrops(), UniformInt.of(1, 4)));
	public static final RegistryObject<Block> TEKTITE_ORE = registerBlock("tektite_ore", 
			() -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f)
					.requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
	
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
