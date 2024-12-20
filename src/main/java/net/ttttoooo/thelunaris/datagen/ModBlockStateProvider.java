package net.ttttoooo.thelunaris.datagen;

import java.util.Locale;
import java.util.function.Function;

import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.block.ModBlocks;
import net.ttttoooo.thelunaris.block.custom.LoonBerryCropBlock;
import net.ttttoooo.thelunaris.block.custom.LunWheatCropBlock;
import net.ttttoooo.thelunaris.block.custom.LundirtFarmlandBlock;
import net.ttttoooo.thelunaris.block.custom.SarrotCropBlock;

public class ModBlockStateProvider extends BlockStateProvider{
	public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
		super(output, TheLunaris.MODID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		//special blocks
		simpleBlockWithItem(ModBlocks.MOONDIALBLOCK.get(),
        	new ModelFile.UncheckedModelFile(modLoc("block/moondialblock")));
		blockItem(ModBlocks.MOONDIALBLOCK);
		portal(ModBlocks.LUNARPORTAL_BLOCK.get());
        simpleBlockWithItem(ModBlocks.LUNAR_CRAFTER.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/lunarcrafter")));
        horizontalBlock(ModBlocks.VAILSTONE_FURNACE.get(),
        		new ModelFile.UncheckedModelFile(modLoc("block/vailstone_furnace")));
        blockItem(ModBlocks.VAILSTONE_FURNACE);
		blockWithItem(ModBlocks.LUNARIS_BEDROCK);
        simpleBlockWithItem(ModBlocks.LUNARIS_CRAFTING_TABLE.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/lunaris_crafting_table")));
        
        //transparent blocks
        translucentBlockWithItem(ModBlocks.LUNGLASS);
        paneBlockWithRenderType((IronBarsBlock) ModBlocks.LUNGLASS_PANE.get(), 
        		new ResourceLocation(TheLunaris.MODID, "block/lunglass"),
        		new ResourceLocation(TheLunaris.MODID, "block/lunglass_pane"), "translucent");
        
        //solid resources
        simpleBlockWithItem(ModBlocks.LUNARITE_BLOCK.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/lunarite_block")));
		blockWithItem(ModBlocks.EMOONSTEEL_BLOCK);
		blockWithItem(ModBlocks.MOONSTEEL_BLOCK);
		blockWithItem(ModBlocks.RAW_MOONSTEEL_BLOCK);
		blockWithItem(ModBlocks.LABRADORITE_BLOCK);
		
		//crops
		makeLunWheatCrop((CropBlock) ModBlocks.LUNWHEAT_CROP.get(), "lunar_wheat_stage", "lunar_wheat_stage");
		makeSarrotCrop((CropBlock) ModBlocks.SARROT_CROP.get(), "sarrot_stage", "sarrot_stage");
		makeLoonBerryCrop((CropBlock) ModBlocks.LOONBERRY_CROP.get(), "loonberry_stage", "loonberry_stage");
		
		//terrain blocks
		blockWithItem(ModBlocks.LUNDIRT);
		grassBlockWithItem(ModBlocks.LUNGRASS_BLOCK.get());
		grassBlockWithItem(ModBlocks.CRIMSON_LUNGRASS_BLOCK.get());
		grassBlockWithItem(ModBlocks.DUSKLIGHT_LUNGRASS_BLOCK.get());
		farmland(ModBlocks.LUNDIRT_FARMLAND.get(),ModBlocks.LUNDIRT.get());
		blockWithItem(ModBlocks.LUNCLAY_BLOCK);
		blockWithItem(ModBlocks.LUNCLAY_BRICK_BLOCK);
		stairsBlock(((StairBlock) ModBlocks.LUNCLAY_BRICK_BLOCK_STAIRS.get()), blockTexture(ModBlocks.LUNCLAY_BRICK_BLOCK.get()));
		slabBlock(((SlabBlock) ModBlocks.LUNCLAY_BRICK_BLOCK_SLAB.get()), blockTexture(ModBlocks.LUNCLAY_BRICK_BLOCK.get()),
				blockTexture(ModBlocks.LUNCLAY_BRICK_BLOCK.get()));
		wallBlock(((WallBlock) ModBlocks.LUNCLAY_BRICK_BLOCK_WALL.get()), blockTexture(ModBlocks.LUNCLAY_BRICK_BLOCK.get()));
		blockWithItem(ModBlocks.LUNSAND);
		blockWithItem(ModBlocks.LUNSANDSTONE);
		stairsBlock(((StairBlock) ModBlocks.LUNSANDSTONE_STAIRS.get()), blockTexture(ModBlocks.LUNSANDSTONE.get()));
		slabBlock(((SlabBlock) ModBlocks.LUNSANDSTONE_SLAB.get()), blockTexture(ModBlocks.LUNSANDSTONE.get()),
				blockTexture(ModBlocks.LUNSANDSTONE.get()));
		wallBlock(((WallBlock) ModBlocks.LUNSANDSTONE_WALL.get()), blockTexture(ModBlocks.LUNSANDSTONE.get()));
		
		//tree blocks
		logBlock(((RotatedPillarBlock)ModBlocks.CELEST_LOG.get()));
		saplingBlock(ModBlocks.CELEST_SAPLING);
		axisBlock(((RotatedPillarBlock)ModBlocks.CELEST_WOOD.get()),
				blockTexture(ModBlocks.CELEST_LOG.get()),blockTexture(ModBlocks.CELEST_LOG.get()));
		axisBlock(((RotatedPillarBlock)ModBlocks.STRIPPED_CELEST_LOG.get()),blockTexture(ModBlocks.STRIPPED_CELEST_LOG.get()),
				new ResourceLocation(TheLunaris.MODID, "block/stripped_celest_top"));
		axisBlock(((RotatedPillarBlock)ModBlocks.STRIPPED_CELEST_WOOD.get()),
				blockTexture(ModBlocks.STRIPPED_CELEST_LOG.get()),blockTexture(ModBlocks.STRIPPED_CELEST_LOG.get()));
		blockItem(ModBlocks.CELEST_LOG);
		blockItem(ModBlocks.CELEST_WOOD);
		blockItem(ModBlocks.STRIPPED_CELEST_LOG);
		blockItem(ModBlocks.STRIPPED_CELEST_WOOD);
		blockWithItem(ModBlocks.CELEST_LEAVES);
		blockWithItem(ModBlocks.GLOWING_CELEST_LEAVES);
		blockWithItem(ModBlocks.CELEST_PLANKS);
		stairsBlock(((StairBlock) ModBlocks.CELEST_STAIRS.get()), blockTexture(ModBlocks.CELEST_PLANKS.get()));
		slabBlock(((SlabBlock) ModBlocks.CELEST_SLAB.get()), blockTexture(ModBlocks.CELEST_PLANKS.get()), blockTexture(ModBlocks.CELEST_PLANKS.get()));
		buttonBlock(((ButtonBlock) ModBlocks.CELEST_BUTTON.get()), blockTexture(ModBlocks.CELEST_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.CELEST_PRESSURE_PLATE.get()), blockTexture(ModBlocks.CELEST_PLANKS.get()));
        fenceBlock(((FenceBlock) ModBlocks.CELEST_FENCE.get()), blockTexture(ModBlocks.CELEST_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.CELEST_FENCE_GATE.get()), blockTexture(ModBlocks.CELEST_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.CELEST_DOOR.get()), modLoc("block/celest_door_bottom"), modLoc("block/celest_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.CELEST_TRAPDOOR.get()), modLoc("block/celest_trapdoor"), true, "cutout");
        
		logBlock(((RotatedPillarBlock)ModBlocks.STELLAR_LOG.get()));
		saplingBlock(ModBlocks.STELLAR_SAPLING);
		axisBlock(((RotatedPillarBlock)ModBlocks.STELLAR_WOOD.get()),
				blockTexture(ModBlocks.STELLAR_LOG.get()),blockTexture(ModBlocks.STELLAR_LOG.get()));
		axisBlock(((RotatedPillarBlock)ModBlocks.STRIPPED_STELLAR_LOG.get()),blockTexture(ModBlocks.STRIPPED_STELLAR_LOG.get()),
				new ResourceLocation(TheLunaris.MODID, "block/stripped_stellar_top"));
		axisBlock(((RotatedPillarBlock)ModBlocks.STRIPPED_STELLAR_WOOD.get()),
				blockTexture(ModBlocks.STRIPPED_STELLAR_LOG.get()),blockTexture(ModBlocks.STRIPPED_STELLAR_LOG.get()));
		blockItem(ModBlocks.STELLAR_LOG);
		blockItem(ModBlocks.STELLAR_WOOD);
		blockItem(ModBlocks.STRIPPED_STELLAR_LOG);
		blockItem(ModBlocks.STRIPPED_STELLAR_WOOD);
		blockWithItem(ModBlocks.STELLAR_LEAVES);
		blockWithItem(ModBlocks.GLOWING_STELLAR_LEAVES);
		blockWithItem(ModBlocks.STELLAR_PLANKS);
		stairsBlock(((StairBlock) ModBlocks.STELLAR_STAIRS.get()), blockTexture(ModBlocks.STELLAR_PLANKS.get()));
		slabBlock(((SlabBlock) ModBlocks.STELLAR_SLAB.get()), blockTexture(ModBlocks.STELLAR_PLANKS.get()), blockTexture(ModBlocks.STELLAR_PLANKS.get()));
		buttonBlock(((ButtonBlock) ModBlocks.STELLAR_BUTTON.get()), blockTexture(ModBlocks.STELLAR_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.STELLAR_PRESSURE_PLATE.get()), blockTexture(ModBlocks.STELLAR_PLANKS.get()));
        fenceBlock(((FenceBlock) ModBlocks.STELLAR_FENCE.get()), blockTexture(ModBlocks.STELLAR_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.STELLAR_FENCE_GATE.get()), blockTexture(ModBlocks.STELLAR_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.STELLAR_DOOR.get()), modLoc("block/stellar_door_bottom"), modLoc("block/stellar_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.STELLAR_TRAPDOOR.get()), modLoc("block/stellar_trapdoor"), true, "cutout");
        
		logBlock(((RotatedPillarBlock)ModBlocks.SKYOAK_LOG.get()));
		saplingBlock(ModBlocks.SKYOAK_SAPLING);
		axisBlock(((RotatedPillarBlock)ModBlocks.SKYOAK_WOOD.get()),
				blockTexture(ModBlocks.SKYOAK_LOG.get()),blockTexture(ModBlocks.SKYOAK_LOG.get()));
		axisBlock(((RotatedPillarBlock)ModBlocks.STRIPPED_SKYOAK_LOG.get()),blockTexture(ModBlocks.STRIPPED_SKYOAK_LOG.get()),
				new ResourceLocation(TheLunaris.MODID, "block/stripped_skyoak_top"));
		axisBlock(((RotatedPillarBlock)ModBlocks.STRIPPED_SKYOAK_WOOD.get()),
				blockTexture(ModBlocks.STRIPPED_SKYOAK_LOG.get()),blockTexture(ModBlocks.STRIPPED_SKYOAK_LOG.get()));
		blockItem(ModBlocks.SKYOAK_LOG);
		blockItem(ModBlocks.SKYOAK_WOOD);
		blockItem(ModBlocks.STRIPPED_SKYOAK_LOG);
		blockItem(ModBlocks.STRIPPED_SKYOAK_WOOD);
		blockWithItem(ModBlocks.SKYOAK_LEAVES);
		blockWithItem(ModBlocks.GLOWING_SKYOAK_LEAVES);
		blockWithItem(ModBlocks.SKYOAK_PLANKS);
		stairsBlock(((StairBlock) ModBlocks.SKYOAK_STAIRS.get()), blockTexture(ModBlocks.SKYOAK_PLANKS.get()));
		slabBlock(((SlabBlock) ModBlocks.SKYOAK_SLAB.get()), blockTexture(ModBlocks.SKYOAK_PLANKS.get()), blockTexture(ModBlocks.SKYOAK_PLANKS.get()));
		buttonBlock(((ButtonBlock) ModBlocks.SKYOAK_BUTTON.get()), blockTexture(ModBlocks.SKYOAK_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.SKYOAK_PRESSURE_PLATE.get()), blockTexture(ModBlocks.SKYOAK_PLANKS.get()));
        fenceBlock(((FenceBlock) ModBlocks.SKYOAK_FENCE.get()), blockTexture(ModBlocks.SKYOAK_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.SKYOAK_FENCE_GATE.get()), blockTexture(ModBlocks.SKYOAK_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.SKYOAK_DOOR.get()), modLoc("block/skyoak_door_bottom"), modLoc("block/skyoak_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.SKYOAK_TRAPDOOR.get()), modLoc("block/skyoak_trapdoor"), true, "cutout");
        
		//stone blocks
		blockWithItem(ModBlocks.VAILSTONE);
		blockWithItem(ModBlocks.VAILSTONEBRICK);
		stairsBlock(((StairBlock) ModBlocks.VAILSTONEBRICK_STAIRS.get()), blockTexture(ModBlocks.VAILSTONEBRICK.get()));
		slabBlock(((SlabBlock) ModBlocks.VAILSTONEBRICK_SLAB.get()), blockTexture(ModBlocks.VAILSTONEBRICK.get()), blockTexture(ModBlocks.VAILSTONEBRICK.get()));
		wallBlock(((WallBlock) ModBlocks.VAILSTONEBRICK_WALL.get()), blockTexture(ModBlocks.VAILSTONEBRICK.get()));
		blockWithItem(ModBlocks.CHISELED_VAILSTONEBRICK);

		blockWithItem(ModBlocks.COBBLED_VAILSTONE);
		stairsBlock(((StairBlock) ModBlocks.COBBLED_VAILSTONE_STAIRS.get()), blockTexture(ModBlocks.COBBLED_VAILSTONE.get()));
		slabBlock(((SlabBlock) ModBlocks.COBBLED_VAILSTONE_SLAB.get()), blockTexture(ModBlocks.COBBLED_VAILSTONE.get()), blockTexture(ModBlocks.COBBLED_VAILSTONE.get()));
		wallBlock(((WallBlock) ModBlocks.COBBLED_VAILSTONE_WALL.get()), blockTexture(ModBlocks.COBBLED_VAILSTONE.get()));
		
		blockWithItem(ModBlocks.LUNARSHALE);
		blockWithItem(ModBlocks.LUNARSLATE);
		blockWithItem(ModBlocks.SMOOTHLUNARSLATE);
		stairsBlock(((StairBlock) ModBlocks.SMOOTHLUNARSLATE_STAIRS.get()), blockTexture(ModBlocks.SMOOTHLUNARSLATE.get()));
		slabBlock(((SlabBlock) ModBlocks.SMOOTHLUNARSLATE_SLAB.get()), blockTexture(ModBlocks.SMOOTHLUNARSLATE.get()), blockTexture(ModBlocks.SMOOTHLUNARSLATE.get()));
		wallBlock(((WallBlock) ModBlocks.SMOOTHLUNARSLATE_WALL.get()), blockTexture(ModBlocks.SMOOTHLUNARSLATE.get()));
		blockWithItem(ModBlocks.CHISELED_SMOOTHLUNARSLATE);

		blockWithItem(ModBlocks.GNEISS);
		blockWithItem(ModBlocks.SMOOTHGNEISS);
		stairsBlock(((StairBlock) ModBlocks.SMOOTHGNEISS_STAIRS.get()), blockTexture(ModBlocks.SMOOTHGNEISS.get()));
		slabBlock(((SlabBlock) ModBlocks.SMOOTHGNEISS_SLAB.get()), blockTexture(ModBlocks.SMOOTHGNEISS.get()), blockTexture(ModBlocks.SMOOTHGNEISS.get()));
		wallBlock(((WallBlock) ModBlocks.SMOOTHGNEISS_WALL.get()), blockTexture(ModBlocks.SMOOTHGNEISS.get()));
		blockWithItem(ModBlocks.CHISELED_SMOOTHGNEISS);

		blockWithItem(ModBlocks.MARBLE);
		blockWithItem(ModBlocks.SMOOTHMARBLE);
		stairsBlock(((StairBlock) ModBlocks.SMOOTHMARBLE_STAIRS.get()), blockTexture(ModBlocks.SMOOTHMARBLE.get()));
		slabBlock(((SlabBlock) ModBlocks.SMOOTHMARBLE_SLAB.get()), blockTexture(ModBlocks.SMOOTHMARBLE.get()), blockTexture(ModBlocks.SMOOTHMARBLE.get()));
		wallBlock(((WallBlock) ModBlocks.SMOOTHMARBLE_WALL.get()), blockTexture(ModBlocks.SMOOTHMARBLE.get()));
		blockWithItem(ModBlocks.CHISELED_SMOOTHMARBLE);
		
		//ore blocks
		blockWithItem(ModBlocks.LUNARITE_ORE);
		blockWithItem(ModBlocks.MOONSTEEL_ORE);
		blockWithItem(ModBlocks.LABRADORITE_ORE);
		blockWithItem(ModBlocks.LUNARIS_COAL_ORE);

		blockWithItem(ModBlocks.DEEP_LUNARITE_ORE);
		blockWithItem(ModBlocks.DEEP_MOONSTEEL_ORE);
		blockWithItem(ModBlocks.DEEP_LABRADORITE_ORE);
		blockWithItem(ModBlocks.DEEP_LUNARIS_COAL_ORE);
		
		//nature blocks
		saplingBlock(ModBlocks.LUNGRASS);
		saplingBlock(ModBlocks.CRIMSON_LUNGRASS);
		saplingBlock(ModBlocks.DUSKLIGHT_LUNGRASS);
		generateTallLungrassVariants("tall_lungrass", ModBlocks.TALL_LUNGRASS);
		generateTallLungrassVariants("tall_crimson_lungrass", ModBlocks.TALL_CRIMSON_LUNGRASS);
		generateTallLungrassVariants("tall_dusklight_lungrass", ModBlocks.TALL_DUSKLIGHT_LUNGRASS);
		saplingBlock(ModBlocks.CRIMSON_GLOWBUSH);
		saplingBlock(ModBlocks.DUSKLIGHT_GLOWBUSH);
		saplingBlock(ModBlocks.WILD_LOONBERRY);
		saplingBlock(ModBlocks.WILD_SARROT);
		
		//flower blocks
		saplingBlock(ModBlocks.ORANGEYE);
		saplingBlock(ModBlocks.CYANEYE);
		saplingBlock(ModBlocks.MAGENTEYE);
		saplingBlock(ModBlocks.LUN_CLOVER);
		saplingBlock(ModBlocks.BRAMBLE);
		
		//potted flowers
		simpleBlockWithItem(ModBlocks.POTTED_ORANGEYE.get(), models().singleTexture("potted_orangeye", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.ORANGEYE.get())).renderType("cutout"));
		simpleBlockWithItem(ModBlocks.POTTED_CYANEYE.get(), models().singleTexture("potted_cyaneye", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.CYANEYE.get())).renderType("cutout"));
		simpleBlockWithItem(ModBlocks.POTTED_MAGENTEYE.get(), models().singleTexture("potted_magenteye", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.MAGENTEYE.get())).renderType("cutout"));
		simpleBlockWithItem(ModBlocks.POTTED_LUN_CLOVER.get(), models().singleTexture("potted_lun_clover", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.LUN_CLOVER.get())).renderType("cutout"));
		simpleBlockWithItem(ModBlocks.POTTED_BRAMBLE.get(), models().singleTexture("potted_bramble", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.BRAMBLE.get())).renderType("cutout"));
		
	}

	protected void simpleBlockExisting(Block b) {
		simpleBlock(b, new ConfiguredModel(models().getExistingFile(prefix(name(b)))));
	}
	
	protected void horizontalBlockWithItem(Block b) {
		simpleBlock(b, new ConfiguredModel(models().getExistingFile(prefix(name(b)))));
	}
	
	public static ResourceLocation prefix(String name) {
		return new ResourceLocation(TheLunaris.MODID, name.toLowerCase(Locale.ROOT));
	}
	
	private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), 
                		blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
	
	private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
		simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
	}
	
	private void grassBlockWithItem(Block block) {
		simpleBlockWithItem(block, models().cubeBottomTop(name(block), 
        		new ResourceLocation(TheLunaris.MODID, "block/" + this.name(block) + "_side"),
				blockTexture(ModBlocks.LUNDIRT.get()),
        		new ResourceLocation(TheLunaris.MODID, "block/" + this.name(block))));
	}
	
	private void generateTallLungrassVariants(String variantName, RegistryObject<Block> block) {
	    // Define texture locations based on the variant name
	    ResourceLocation bottomTexture = new ResourceLocation(TheLunaris.MODID, "block/" + variantName + "_bottom");
	    ResourceLocation topTexture = new ResourceLocation(TheLunaris.MODID, "block/" + variantName + "_top");

	    // Generate models for the top and bottom halves
	    ModelFile bottomModel = 
                models().cross(ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom", 
                		bottomTexture).renderType("cutout");
	    ModelFile topModel = 
                models().cross(ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_top", 
                		topTexture).renderType("cutout");

	    // Generate blockstate with top and bottom parts
	    getVariantBuilder(block.get()).forAllStates(state -> {
	        boolean isTop = state.getValue(DoublePlantBlock.HALF) == DoubleBlockHalf.UPPER;
	        return ConfiguredModel.builder()
	                .modelFile(isTop ? topModel : bottomModel)
	                .build();
	    });
	}

	
	private void translucentBlockWithItem(RegistryObject<Block> blockRegistryObject) {
		simpleBlockWithItem(blockRegistryObject.get(), 
				models().cubeAll(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), 
						blockTexture(blockRegistryObject.get())).renderType("translucent"));
	}
	
	private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(TheLunaris.MODID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }
	
	public void portal(Block block) {
        ModelFile portal_ew = this.models().withExistingParent(this.name(block) + "_ew", this.mcLoc("block/nether_portal_ew"))
                .texture("particle", this.modLoc("block/misc/" + this.name(block)))
                .texture("portal", this.modLoc("block/misc/" + this.name(block)))
                .renderType(new ResourceLocation("translucent"));
        ModelFile portal_ns = this.models().withExistingParent(this.name(block) + "_ns", this.mcLoc("block/nether_portal_ns"))
                .texture("particle", this.modLoc("block/misc/" + this.name(block)))
                .texture("portal", this.modLoc("block/misc/" + this.name(block)))
                .renderType(new ResourceLocation("translucent"));
        this.getVariantBuilder(block).forAllStates(state -> {
            Direction.Axis axis = state.getValue(NetherPortalBlock.AXIS);
            return ConfiguredModel.builder()
                    .modelFile(axis == Direction.Axis.Z ? portal_ew : portal_ns)
                    .build();
        });
    }
	
    public void makeLunWheatCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> lunWheatStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] lunWheatStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((LunWheatCropBlock) block).getAgeProperty()),
                new ResourceLocation(TheLunaris.MODID, "block/" + textureName + state.getValue(((LunWheatCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
    
    public void makeLoonBerryCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> loonBerryStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] loonBerryStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((LoonBerryCropBlock) block).getAgeProperty()),
                new ResourceLocation(TheLunaris.MODID, "block/" + textureName + state.getValue(((LoonBerryCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
    
    public void makeSarrotCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> sarrotStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] sarrotStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((SarrotCropBlock) block).getAgeProperty()),
                new ResourceLocation(TheLunaris.MODID, "block/" + textureName + state.getValue(((SarrotCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
    
    public void farmland(Block block, Block dirtBlock) {
        ModelFile farmland = this.models().withExistingParent(this.name(block), this.mcLoc("block/template_farmland"))
                .texture("dirt", this.modLoc("block/" + this.name(dirtBlock)))
                .texture("top", this.modLoc("block/" + this.name(block)));
        ModelFile moist = this.models().withExistingParent(this.name(block) + "_moist", mcLoc("block/template_farmland"))
                .texture("dirt", this.modLoc("block/" + this.name(dirtBlock)))
                .texture("top", this.modLoc("block/" + this.name(block) + "_moist"));
        this.getVariantBuilder(block).forAllStatesExcept(state -> {
            int moisture = state.getValue(LundirtFarmlandBlock.MOISTURE);
            return ConfiguredModel.builder()
                    .modelFile(moisture < LundirtFarmlandBlock.MAX_MOISTURE ? farmland : moist)
                    .build();
        });
        simpleBlockItem(block, farmland);
    }
	
	protected ResourceLocation key(Block block) {
		return ForgeRegistries.BLOCKS.getKey(block);
	}
	
	protected String name(Block block) {
		return key(block).getPath();
	}
	
}
