package net.ttttoooo.thelunaris.block;

import net.minecraft.world.item.Item;

import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.block.custom.LoonBerryCropBlock;
import net.ttttoooo.thelunaris.block.custom.LunGrassBlock;
import net.ttttoooo.thelunaris.block.custom.LunWheatCropBlock;
import net.ttttoooo.thelunaris.block.custom.LunarCrafter;
import net.ttttoooo.thelunaris.block.custom.LunarisCraftingTable;
import net.ttttoooo.thelunaris.block.custom.LundirtFarmlandBlock;
import net.ttttoooo.thelunaris.block.custom.ModFlammableRotatedPillarBlock;
import net.ttttoooo.thelunaris.block.custom.SarrotCropBlock;
import net.ttttoooo.thelunaris.block.custom.VailstoneFurnace;
import net.ttttoooo.thelunaris.block.custom.portal.ModPortalBlock;
import net.ttttoooo.thelunaris.item.ModItems;
import net.ttttoooo.thelunaris.worldgen.tree.CelestTreeGrower;
import net.ttttoooo.thelunaris.worldgen.tree.SkyoakTreeGrower;
import net.ttttoooo.thelunaris.worldgen.tree.StellarTreeGrower;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS =
			DeferredRegister.create(ForgeRegistries.BLOCKS, TheLunaris.MODID);
	
	//Portal Block
	public static final RegistryObject<Block> LUNARPORTAL_BLOCK = registerBlock("lunarportal_block", 
			() -> new ModPortalBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.GLASS)
					.noLootTable().noOcclusion().noCollission().pushReaction(PushReaction.BLOCK)
					.strength(-1F).lightLevel((state) -> 10)));
	
	//Special Blocks
	public static final RegistryObject<Block> MOONDIALBLOCK = registerBlock("moondialblock", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.ANCIENT_DEBRIS)));
	public static final RegistryObject<Block> LUNAR_CRAFTER = registerBlock("lunar_crafter", 
			() -> new LunarCrafter(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).noOcclusion()));
	public static final RegistryObject<Block> VAILSTONE_FURNACE = registerBlock("vailstone_furnace", 
			() -> new VailstoneFurnace(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE).noOcclusion()));
	public static final RegistryObject<Block> LUNARIS_BEDROCK = registerBlock("lunaris_bedrock", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.BEDROCK).sound(SoundType.ANCIENT_DEBRIS).noLootTable()));
	public static final RegistryObject<Block> LUNARIS_CRAFTING_TABLE = registerBlock("lunaris_crafting_table", 
			() -> new LunarisCraftingTable(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
	
	//Crop Blocks
    public static final RegistryObject<Block> LUNWHEAT_CROP = BLOCKS.register("lunwheat_crop",
            () -> new LunWheatCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));
    public static final RegistryObject<Block> SARROT_CROP = BLOCKS.register("sarrot_crop",
            () -> new SarrotCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));
    public static final RegistryObject<Block> LOONBERRY_CROP = BLOCKS.register("loonberry_crop",
            () -> new LoonBerryCropBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH).noOcclusion().noCollission()));
	
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
	public static final RegistryObject<Block> LUNDIRT_FARMLAND = registerBlock("lundirt_farmland", 
			() -> new LundirtFarmlandBlock(BlockBehaviour.Properties.copy(Blocks.DIRT).sound(SoundType.GRAVEL)));
	public static final RegistryObject<Block> LUNGRASS_BLOCK = registerBlock("lungrass_block", 
			() -> new LunGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK).sound(SoundType.GRASS)));
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
	
	//Transparent Blocks
	public static final RegistryObject<Block> LUNGLASS = registerBlock("lunglass",
			() -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()));
	public static final RegistryObject<Block> LUNGLASS_PANE = registerBlock("lunglass_pane",
			() -> new IronBarsBlock(BlockBehaviour.Properties.copy(Blocks.GLASS_PANE).noOcclusion()));
	
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
    public static final RegistryObject<Block> CELEST_BUTTON = registerBlock("celest_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).sound(SoundType.WOOD),
                    BlockSetType.OAK, 10, true));
    public static final RegistryObject<Block> CELEST_PRESSURE_PLATE = registerBlock("celest_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
            		.sound(SoundType.WOOD),BlockSetType.OAK));
    public static final RegistryObject<Block> CELEST_FENCE = registerBlock("celest_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CELEST_FENCE_GATE = registerBlock("celest_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD),
            		SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> CELEST_DOOR = registerBlock("celest_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)
            		.noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Block> CELEST_TRAPDOOR = registerBlock("celest_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)
            		.noOcclusion(), BlockSetType.OAK));

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
    public static final RegistryObject<Block> STELLAR_BUTTON = registerBlock("stellar_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).sound(SoundType.WOOD),
                    BlockSetType.OAK, 10, true));
    public static final RegistryObject<Block> STELLAR_PRESSURE_PLATE = registerBlock("stellar_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
            		.sound(SoundType.WOOD),BlockSetType.OAK));
    public static final RegistryObject<Block> STELLAR_FENCE = registerBlock("stellar_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STELLAR_FENCE_GATE = registerBlock("stellar_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD),
            		SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> STELLAR_DOOR = registerBlock("stellar_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)
            		.noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Block> STELLAR_TRAPDOOR = registerBlock("stellar_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)
            		.noOcclusion(), BlockSetType.OAK));

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
    public static final RegistryObject<Block> SKYOAK_BUTTON = registerBlock("skyoak_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).sound(SoundType.WOOD),
                    BlockSetType.OAK, 10, true));
    public static final RegistryObject<Block> SKYOAK_PRESSURE_PLATE = registerBlock("skyoak_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
            		.sound(SoundType.WOOD),BlockSetType.OAK));
    public static final RegistryObject<Block> SKYOAK_FENCE = registerBlock("skyoak_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> SKYOAK_FENCE_GATE = registerBlock("skyoak_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD),
            		SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> SKYOAK_DOOR = registerBlock("skyoak_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)
            		.noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Block> SKYOAK_TRAPDOOR = registerBlock("skyoak_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)
            		.noOcclusion(), BlockSetType.OAK));
	
	//Sapling Blocks
	public static final RegistryObject<Block> CELEST_SAPLING = registerBlock("celest_sapling", 
			() -> new SaplingBlock(new CelestTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> STELLAR_SAPLING = registerBlock("stellar_sapling", 
			() -> new SaplingBlock(new StellarTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> SKYOAK_SAPLING = registerBlock("skyoak_sapling", 
			() -> new SaplingBlock(new SkyoakTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
	
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
	
	//Cobbled Vailstone Blocks
	public static final RegistryObject<Block> COBBLED_VAILSTONE = registerBlock("cobbled_vailstone", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).sound(SoundType.STONE)));
	public static final RegistryObject<Block> COBBLED_VAILSTONE_STAIRS = registerBlock("cobbled_vailstone_stairs", 
			() -> new StairBlock(() -> ModBlocks.COBBLED_VAILSTONE.get().defaultBlockState(),
			BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).sound(SoundType.STONE)));
	public static final RegistryObject<Block> COBBLED_VAILSTONE_SLAB = registerBlock("cobbled_vailstone_slab", 
			() -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).sound(SoundType.STONE)));
	public static final RegistryObject<Block> COBBLED_VAILSTONE_WALL = registerBlock("cobbled_vailstone_wall", 
			() -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).sound(SoundType.STONE)));
	
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
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(SoundType.DEEPSLATE)));
	public static final RegistryObject<Block> SMOOTHGNEISS = registerBlock("smoothgneiss", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(SoundType.DEEPSLATE)));
	public static final RegistryObject<Block> SMOOTHGNEISS_STAIRS = registerBlock("smoothgneiss_stairs", 
			() -> new StairBlock(() -> ModBlocks.SMOOTHGNEISS.get().defaultBlockState(),
			BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(SoundType.DEEPSLATE_TILES)));
	public static final RegistryObject<Block> SMOOTHGNEISS_SLAB = registerBlock("smoothgneiss_slab", 
			() -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(SoundType.DEEPSLATE_TILES)));
	public static final RegistryObject<Block> SMOOTHGNEISS_WALL = registerBlock("smoothgneiss_wall", 
			() -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(SoundType.DEEPSLATE_TILES)));
	
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
	public static final RegistryObject<Block> DEEP_LUNARITE_ORE = registerBlock("deep_lunarite_ore", 
			() -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(3f)
					.requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
	public static final RegistryObject<Block> MOONSTEEL_ORE = registerBlock("moonsteel_ore", 
			() -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f)
					.requiresCorrectToolForDrops(), UniformInt.of(1, 4)));
	public static final RegistryObject<Block> DEEP_MOONSTEEL_ORE = registerBlock("deep_moonsteel_ore", 
			() -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2f)
					.requiresCorrectToolForDrops(), UniformInt.of(1, 4)));
	public static final RegistryObject<Block> LABRADORITE_ORE = registerBlock("labradorite_ore", 
			() -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f)
					.requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
	public static final RegistryObject<Block> DEEP_LABRADORITE_ORE = registerBlock("deep_labradorite_ore", 
			() -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2f)
					.requiresCorrectToolForDrops(), UniformInt.of(2, 5)));

	//Vanilla Ore in Lunaris
	public static final RegistryObject<Block> LUNARIS_COAL_ORE = registerBlock("lunaris_coal_ore", 
			() -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.COAL_ORE).strength(1f)
					.requiresCorrectToolForDrops(), UniformInt.of(0, 2)));
	public static final RegistryObject<Block> DEEP_LUNARIS_COAL_ORE = registerBlock("deep_lunaris_coal_ore", 
			() -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_COAL_ORE).strength(3f)
					.requiresCorrectToolForDrops(), UniformInt.of(0, 2)));
	
	//vegetation blocks
	public static final RegistryObject<Block> LUNGRASS = registerBlock("lungrass",
            () -> new TallGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS)));
	public static final RegistryObject<Block> WILD_LOONBERRY = registerBlock("wild_loonberry",
            () -> new TallGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS)));
	public static final RegistryObject<Block> WILD_SARROT = registerBlock("wild_sarrot",
            () -> new TallGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS)));
	
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
