package net.ttttoooo.thelunaris.datagen;

import java.util.Locale;
import java.util.function.Function;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
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
import net.ttttoooo.thelunaris.block.custom.SarrotCropBlock;

public class ModBlockStateProvider extends BlockStateProvider{
	public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
		super(output, TheLunaris.MODID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		//special blocks
		blockWithItem(ModBlocks.MOONDIALBLOCK);
        simpleBlockWithItem(ModBlocks.LUNAR_CRAFTER.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/lunarcrafter")));
        //simpleBlockWithItem(ModBlocks.VAILSTONE_FURNACE.get(),
        horizontalBlock(ModBlocks.VAILSTONE_FURNACE.get(), 
                new ModelFile.UncheckedModelFile(modLoc("block/vailstonefurnace")));
		blockWithItem(ModBlocks.LUNARIS_BEDROCK);
		blockWithItem(ModBlocks.LUNARPORTAL_BLOCK);
        simpleBlockWithItem(ModBlocks.LUNARIS_CRAFTING_TABLE.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/lunaris_crafting_table")));


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
        simpleBlockWithItem(ModBlocks.LUNGRASS_BLOCK.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/lungrass_block")));
		blockWithItem(ModBlocks.LUNSAND);
		blockWithItem(ModBlocks.LUNSANDSTONE);
		stairsBlock(((StairBlock) ModBlocks.LUNSANDSTONE_STAIRS.get()), blockTexture(ModBlocks.LUNSANDSTONE.get()));
		slabBlock(((SlabBlock) ModBlocks.LUNSANDSTONE_SLAB.get()), blockTexture(ModBlocks.LUNSANDSTONE.get()), blockTexture(ModBlocks.LUNSANDSTONE.get()));
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
		blockWithItem(ModBlocks.CELEST_PLANKS);
		stairsBlock(((StairBlock) ModBlocks.CELEST_STAIRS.get()), blockTexture(ModBlocks.CELEST_PLANKS.get()));
		slabBlock(((SlabBlock) ModBlocks.CELEST_SLAB.get()), blockTexture(ModBlocks.CELEST_PLANKS.get()), blockTexture(ModBlocks.CELEST_PLANKS.get()));

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
		blockWithItem(ModBlocks.STELLAR_PLANKS);
		stairsBlock(((StairBlock) ModBlocks.STELLAR_STAIRS.get()), blockTexture(ModBlocks.STELLAR_PLANKS.get()));
		slabBlock(((SlabBlock) ModBlocks.STELLAR_SLAB.get()), blockTexture(ModBlocks.STELLAR_PLANKS.get()), blockTexture(ModBlocks.STELLAR_PLANKS.get()));

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
		blockWithItem(ModBlocks.SKYOAK_PLANKS);
		stairsBlock(((StairBlock) ModBlocks.SKYOAK_STAIRS.get()), blockTexture(ModBlocks.SKYOAK_PLANKS.get()));
		slabBlock(((SlabBlock) ModBlocks.SKYOAK_SLAB.get()), blockTexture(ModBlocks.SKYOAK_PLANKS.get()), blockTexture(ModBlocks.SKYOAK_PLANKS.get()));
		
		//stone blocks
		blockWithItem(ModBlocks.VAILSTONE);
		blockWithItem(ModBlocks.VAILSTONEBRICK);
		stairsBlock(((StairBlock) ModBlocks.VAILSTONEBRICK_STAIRS.get()), blockTexture(ModBlocks.VAILSTONEBRICK.get()));
		slabBlock(((SlabBlock) ModBlocks.VAILSTONEBRICK_SLAB.get()), blockTexture(ModBlocks.VAILSTONEBRICK.get()), blockTexture(ModBlocks.VAILSTONEBRICK.get()));
		wallBlock(((WallBlock) ModBlocks.VAILSTONEBRICK_WALL.get()), blockTexture(ModBlocks.VAILSTONEBRICK.get()));

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

		blockWithItem(ModBlocks.GNEISS);
		blockWithItem(ModBlocks.SMOOTHGNEISS);
		stairsBlock(((StairBlock) ModBlocks.SMOOTHGNEISS_STAIRS.get()), blockTexture(ModBlocks.SMOOTHGNEISS.get()));
		slabBlock(((SlabBlock) ModBlocks.SMOOTHGNEISS_SLAB.get()), blockTexture(ModBlocks.SMOOTHGNEISS.get()), blockTexture(ModBlocks.SMOOTHGNEISS.get()));
		wallBlock(((WallBlock) ModBlocks.SMOOTHGNEISS_WALL.get()), blockTexture(ModBlocks.SMOOTHGNEISS.get()));

		blockWithItem(ModBlocks.MARBLE);
		blockWithItem(ModBlocks.SMOOTHMARBLE);
		stairsBlock(((StairBlock) ModBlocks.SMOOTHMARBLE_STAIRS.get()), blockTexture(ModBlocks.SMOOTHMARBLE.get()));
		slabBlock(((SlabBlock) ModBlocks.SMOOTHMARBLE_SLAB.get()), blockTexture(ModBlocks.SMOOTHMARBLE.get()), blockTexture(ModBlocks.SMOOTHMARBLE.get()));
		wallBlock(((WallBlock) ModBlocks.SMOOTHMARBLE_WALL.get()), blockTexture(ModBlocks.SMOOTHMARBLE.get()));
		
		//ore blocks
		blockWithItem(ModBlocks.LUNARITE_ORE);
		blockWithItem(ModBlocks.MOONSTEEL_ORE);
		blockWithItem(ModBlocks.LABRADORITE_ORE);
		
		//nature blocks
		saplingBlock(ModBlocks.LUNGRASS);
		saplingBlock(ModBlocks.WILD_LOONBERRY);
		saplingBlock(ModBlocks.WILD_SARROT);
		
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
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
	
	private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
		simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
	}
	
	private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(TheLunaris.MODID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
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
	
	protected ResourceLocation key(Block block) {
		return ForgeRegistries.BLOCKS.getKey(block);
	}
	
	protected String name(Block block) {
		return key(block).getPath();
	}
	
}
