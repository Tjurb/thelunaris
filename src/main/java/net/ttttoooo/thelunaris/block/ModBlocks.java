package net.ttttoooo.thelunaris.block;

import net.minecraft.world.item.Item;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.block.custom.ModFlammableRotatedPillarBlock;
import net.ttttoooo.thelunaris.item.ModItems;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS =
			DeferredRegister.create(ForgeRegistries.BLOCKS, TheLunaris.MODID);
	
//Special Blocks
	public static final RegistryObject<Block> MOONDIALBLOCK = registerBlock("moondialblock", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.ANCIENT_DEBRIS)));
	public static final RegistryObject<Block> LUNAR_CRAFTER = registerBlock("lunar_crafter", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.ANCIENT_DEBRIS)));
	
//Condensed Blocks	
	public static final RegistryObject<Block> RAW_MOONSTEEL_BLOCK = registerBlock("raw_moonsteel_block", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).sound(SoundType.METAL)));
	public static final RegistryObject<Block> MOONSTEEL_BLOCK = registerBlock("moonsteel_block", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL)));
	public static final RegistryObject<Block> EMOONSTEEL_BLOCK = registerBlock("emoonsteel_block", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL)));
	public static final RegistryObject<Block> LUNARITE_BLOCK = registerBlock("lunarite_block", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).sound(SoundType.AMETHYST)));
	public static final RegistryObject<Block> LABRADORITE_BLOCK = registerBlock("labradorite_block", 
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
	public static final RegistryObject<Block> CELEST_LOG = registerBlock("celest_log", 
			() -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).sound(SoundType.WOOD).strength(3f)));
	public static final RegistryObject<Block> CELEST_WOOD = registerBlock("celest_wood", 
			() -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD).strength(3f)));
	public static final RegistryObject<Block> CELEST_LEAVES = registerBlock("celest_leaves", 
			() -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).sound(SoundType.GRASS)) {
				@Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
			});
	public static final RegistryObject<Block> CELEST_PLANKS = registerBlock("celest_planks", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)) {
				@Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
			});
	public static final RegistryObject<Block> CELEST_STAIRS = registerBlock("celest_stairs", 
			() -> new StairBlock(() -> ModBlocks.CELEST_PLANKS.get().defaultBlockState(),
			BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)) {
				@Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
			});
	public static final RegistryObject<Block> CELEST_SLAB = registerBlock("celest_slab", 
			() -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)) {
				@Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
			});

	public static final RegistryObject<Block> STELLAR_LOG = registerBlock("stellar_log", 
			() -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).sound(SoundType.WOOD).strength(3f)));
	public static final RegistryObject<Block> STELLAR_WOOD = registerBlock("stellar_wood", 
			() -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD).strength(3f)));
	public static final RegistryObject<Block> STELLAR_LEAVES = registerBlock("stellar_leaves", 
			() -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).sound(SoundType.GRASS)) {
				@Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
			});
	public static final RegistryObject<Block> STELLAR_PLANKS = registerBlock("stellar_planks", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)) {
				@Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
			});
	public static final RegistryObject<Block> STELLAR_STAIRS = registerBlock("stellar_stairs", 
			() -> new StairBlock(() -> ModBlocks.STELLAR_PLANKS.get().defaultBlockState(),
			BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)) {
				@Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
			});
	public static final RegistryObject<Block> STELLAR_SLAB = registerBlock("stellar_slab", 
			() -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)) {
				@Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
			});

	public static final RegistryObject<Block> SKYOAK_LOG = registerBlock("skyoak_log", 
			() -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).sound(SoundType.WOOD).strength(3f)));
	public static final RegistryObject<Block> SKYOAK_WOOD = registerBlock("skyoak_wood", 
			() -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD).strength(3f)));
	public static final RegistryObject<Block> SKYOAK_LEAVES = registerBlock("skyoak_leaves", 
			() -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).sound(SoundType.GRASS)) {
				@Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
			});
	public static final RegistryObject<Block> SKYOAK_PLANKS = registerBlock("skyoak_planks", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)) {
				@Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
			});
	public static final RegistryObject<Block> SKYOAK_STAIRS = registerBlock("skyoak_stairs", 
			() -> new StairBlock(() -> ModBlocks.SKYOAK_PLANKS.get().defaultBlockState(),
			BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)) {
				@Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
			});
	public static final RegistryObject<Block> SKYOAK_SLAB = registerBlock("skyoak_slab", 
			() -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)) {
				@Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
			});
	
//Stripped Logs
	public static final RegistryObject<Block> STRIPPED_CELEST_LOG = registerBlock("stripped_celest_log", 
			() -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).sound(SoundType.WOOD).strength(3f)));
	public static final RegistryObject<Block> STRIPPED_CELEST_WOOD = registerBlock("stripped_celest_wood", 
			() -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD).strength(3f)));

	public static final RegistryObject<Block> STRIPPED_STELLAR_LOG = registerBlock("stripped_stellar_log", 
			() -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).sound(SoundType.WOOD).strength(3f)));
	public static final RegistryObject<Block> STRIPPED_STELLAR_WOOD = registerBlock("stripped_stellar_wood", 
			() -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD).strength(3f)));

	public static final RegistryObject<Block> STRIPPED_SKYOAK_LOG = registerBlock("stripped_skyoak_log", 
			() -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).sound(SoundType.WOOD).strength(3f)));
	public static final RegistryObject<Block> STRIPPED_SKYOAK_WOOD = registerBlock("stripped_skyoak_wood", 
			() -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD).strength(3f)));
	
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
	public static final RegistryObject<Block> LABRADORITE_ORE = registerBlock("labradorite_ore", 
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
