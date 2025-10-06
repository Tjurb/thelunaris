package net.ttttoooo.thelunaris.datagen;

import java.util.LinkedHashMap;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.block.ModBlocks;
import net.ttttoooo.thelunaris.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider{

	private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }
	
	public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, TheLunaris.MODID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		simpleItem(ModItems.MOONDIAL);
		
		simpleItem(ModItems.LUNAR_STICK);
		simpleItem(ModItems.MOONSTEEL);
		simpleItem(ModItems.MOONSTEEL_NUGGET);
		simpleItem(ModItems.RAW_MOONSTEEL);
		simpleItem(ModItems.LABRADORITE);
		simpleItem(ModItems.EMOONSTEEL);
		simpleItem(ModItems.EMOONSTEEL_NUGGET);
		simpleItem(ModItems.LUNARITE);
		simpleItem(ModItems.LUNAR_CLAY);
		simpleItem(ModItems.LUNAR_CLAY_BRICK);
		
		simpleItem(ModItems.LUNAR_WHEAT);
		simpleItem(ModItems.LUNAR_WHEAT_SEEDS);
		simpleItem(ModItems.HEXDUST);
		simpleItem(ModItems.HEXCHARGE);
		
		simpleItem(ModItems.LOONBERRY);
		simpleItem(ModItems.ARCHFISH);
		simpleItem(ModItems.SARROT);
		simpleItem(ModItems.COOKED_ARCHFISH);
		simpleItem(ModItems.LOONBERRY_PIE);
		simpleItem(ModItems.SPICY_ARCHFISH);
		simpleItem(ModItems.LUN_BREAD);
		
		//Spawn Eggs
		withExistingParent(ModItems.MOONCOW_SPANW_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
		withExistingParent(ModItems.ARCHFISH_SPANW_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
		withExistingParent(ModItems.MOONSNAIL_SPANW_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
		withExistingParent(ModItems.PHYREX_SPANW_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
		withExistingParent(ModItems.LUNARSLEEPER_SPANW_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
		withExistingParent(ModItems.HEX_SPANW_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
		
		//tools
		handheldItem(ModItems.VAILSTONE_SWORD);
		handheldItem(ModItems.VAILSTONE_PICKAXE);
		handheldItem(ModItems.VAILSTONE_AXE);
		handheldItem(ModItems.VAILSTONE_SHOVEL);
		handheldItem(ModItems.VAILSTONE_HOE);
		
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
		
		//Armor
		trimmedArmorItem(ModItems.MOONSTEEL_HELMET);
		trimmedArmorItem(ModItems.MOONSTEEL_CHESTPLATE);
		trimmedArmorItem(ModItems.MOONSTEEL_LEGGINGS);
		trimmedArmorItem(ModItems.MOONSTEEL_BOOTS);

		trimmedArmorItem(ModItems.EMOONSTEEL_HELMET);
		trimmedArmorItem(ModItems.EMOONSTEEL_CHESTPLATE);
		trimmedArmorItem(ModItems.EMOONSTEEL_LEGGINGS);
		trimmedArmorItem(ModItems.EMOONSTEEL_BOOTS);

		trimmedArmorItem(ModItems.LUNARITE_HELMET);
		trimmedArmorItem(ModItems.LUNARITE_CHESTPLATE);
		trimmedArmorItem(ModItems.LUNARITE_LEGGINGS);
		trimmedArmorItem(ModItems.LUNARITE_BOOTS);
		
		//panes
		panesimpleItem(ModBlocks.LUNGLASS_PANE, ModBlocks.LUNGLASS);
		
		//walls
		wallItem(ModBlocks.COBBLED_VAILSTONE_WALL, ModBlocks.COBBLED_VAILSTONE);
		wallItem(ModBlocks.VAILSTONEBRICK_WALL, ModBlocks.VAILSTONEBRICK);
		wallItem(ModBlocks.SMOOTHGNEISS_WALL, ModBlocks.SMOOTHGNEISS);
		wallItem(ModBlocks.SMOOTHLUNARSLATE_WALL, ModBlocks.SMOOTHLUNARSLATE);
		wallItem(ModBlocks.SMOOTHMARBLE_WALL, ModBlocks.SMOOTHMARBLE);
		wallItem(ModBlocks.LUNSANDSTONE_WALL, ModBlocks.LUNSANDSTONE);
		wallItem(ModBlocks.LUNCLAY_BRICK_BLOCK_WALL, ModBlocks.LUNCLAY_BRICK_BLOCK);
		
		//stairs
		evenSimplerBlockItem(ModBlocks.COBBLED_VAILSTONE_STAIRS);
		evenSimplerBlockItem(ModBlocks.VAILSTONEBRICK_STAIRS);
		evenSimplerBlockItem(ModBlocks.SMOOTHGNEISS_STAIRS);
		evenSimplerBlockItem(ModBlocks.SMOOTHLUNARSLATE_STAIRS);
		evenSimplerBlockItem(ModBlocks.SMOOTHMARBLE_STAIRS);
		evenSimplerBlockItem(ModBlocks.CELEST_STAIRS);
		evenSimplerBlockItem(ModBlocks.STELLAR_STAIRS);
		evenSimplerBlockItem(ModBlocks.SKYOAK_STAIRS);
		evenSimplerBlockItem(ModBlocks.VINEWOOD_STAIRS);
		evenSimplerBlockItem(ModBlocks.ICEWOOD_STAIRS);
		evenSimplerBlockItem(ModBlocks.LUNSANDSTONE_STAIRS);
		evenSimplerBlockItem(ModBlocks.LUNCLAY_BRICK_BLOCK_STAIRS);
		
		//slabs
		evenSimplerBlockItem(ModBlocks.COBBLED_VAILSTONE_SLAB);
		evenSimplerBlockItem(ModBlocks.VAILSTONEBRICK_SLAB);
		evenSimplerBlockItem(ModBlocks.SMOOTHGNEISS_SLAB);
		evenSimplerBlockItem(ModBlocks.SMOOTHLUNARSLATE_SLAB);
		evenSimplerBlockItem(ModBlocks.SMOOTHMARBLE_SLAB);
		evenSimplerBlockItem(ModBlocks.CELEST_SLAB);
		evenSimplerBlockItem(ModBlocks.STELLAR_SLAB);
		evenSimplerBlockItem(ModBlocks.SKYOAK_SLAB);
		evenSimplerBlockItem(ModBlocks.VINEWOOD_SLAB);
		evenSimplerBlockItem(ModBlocks.ICEWOOD_SLAB);
		evenSimplerBlockItem(ModBlocks.LUNSANDSTONE_SLAB);
		evenSimplerBlockItem(ModBlocks.LUNCLAY_BRICK_BLOCK_SLAB);
		
		//fences
		fenceItem(ModBlocks.CELEST_FENCE, ModBlocks.CELEST_PLANKS);
        evenSimplerBlockItem(ModBlocks.CELEST_FENCE_GATE);
		fenceItem(ModBlocks.STELLAR_FENCE, ModBlocks.STELLAR_PLANKS);
        evenSimplerBlockItem(ModBlocks.STELLAR_FENCE_GATE);
		fenceItem(ModBlocks.SKYOAK_FENCE, ModBlocks.SKYOAK_PLANKS);
        evenSimplerBlockItem(ModBlocks.SKYOAK_FENCE_GATE);
		fenceItem(ModBlocks.VINEWOOD_FENCE, ModBlocks.VINEWOOD_PLANKS);
        evenSimplerBlockItem(ModBlocks.VINEWOOD_FENCE_GATE);
		fenceItem(ModBlocks.ICEWOOD_FENCE, ModBlocks.ICEWOOD_PLANKS);
        evenSimplerBlockItem(ModBlocks.ICEWOOD_FENCE_GATE);
		
		//pressureplates
        evenSimplerBlockItem(ModBlocks.CELEST_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.STELLAR_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.SKYOAK_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.VINEWOOD_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.ICEWOOD_PRESSURE_PLATE);
        
        //buttons
        buttonItem(ModBlocks.CELEST_BUTTON, ModBlocks.CELEST_PLANKS);
        buttonItem(ModBlocks.STELLAR_BUTTON, ModBlocks.STELLAR_PLANKS);
        buttonItem(ModBlocks.SKYOAK_BUTTON, ModBlocks.SKYOAK_PLANKS);
        buttonItem(ModBlocks.VINEWOOD_BUTTON, ModBlocks.VINEWOOD_PLANKS);
        buttonItem(ModBlocks.ICEWOOD_BUTTON, ModBlocks.ICEWOOD_PLANKS);

        //doors
        simpleBlockItem(ModBlocks.CELEST_DOOR);
        simpleBlockItem(ModBlocks.STELLAR_DOOR);
        simpleBlockItem(ModBlocks.SKYOAK_DOOR);
        simpleBlockItem(ModBlocks.VINEWOOD_DOOR);
        simpleBlockItem(ModBlocks.ICEWOOD_DOOR);
        
        //trapdoors
        trapdoorItem(ModBlocks.CELEST_TRAPDOOR);
        trapdoorItem(ModBlocks.STELLAR_TRAPDOOR);
        trapdoorItem(ModBlocks.SKYOAK_TRAPDOOR);
        trapdoorItem(ModBlocks.VINEWOOD_TRAPDOOR);
        trapdoorItem(ModBlocks.ICEWOOD_TRAPDOOR);
        
		//saplings
		saplingItem(ModBlocks.CELEST_SAPLING);
		saplingItem(ModBlocks.STELLAR_SAPLING);
		saplingItem(ModBlocks.SKYOAK_SAPLING);
		saplingItem(ModBlocks.VINEWOOD_SAPLING);
		saplingItem(ModBlocks.ICEWOOD_SAPLING);
		
		//nature
		saplingItem(ModBlocks.LUNGRASS);
		tallsaplingItem(ModBlocks.TALL_LUNGRASS);
		saplingItem(ModBlocks.CRIMSON_LUNGRASS);
		tallsaplingItem(ModBlocks.TALL_CRIMSON_LUNGRASS);
		saplingItem(ModBlocks.CRIMSON_GLOWBUSH);
		saplingItem(ModBlocks.DUSKLIGHT_LUNGRASS);
		tallsaplingItem(ModBlocks.TALL_DUSKLIGHT_LUNGRASS);
		saplingItem(ModBlocks.DUSKLIGHT_GLOWBUSH);
		saplingItem(ModBlocks.WILD_LOONBERRY);
		saplingItem(ModBlocks.WILD_SARROT);
		
		//flowers
		saplingItem(ModBlocks.ORANGEYE);
		saplingItem(ModBlocks.CYANEYE);
		saplingItem(ModBlocks.MAGENTEYE);
		saplingItem(ModBlocks.LUN_CLOVER);
		saplingItem(ModBlocks.BRAMBLE);
	}
	
	private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TheLunaris.MODID,"block/" + item.getId().getPath()));
    }
	
	private ItemModelBuilder tallsaplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TheLunaris.MODID,"block/" + item.getId().getPath() + "_top"));
    }
	
	// Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = TheLunaris.MODID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }
	
	private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
		return withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/generated")).texture("layer0",
				new ResourceLocation(TheLunaris.MODID, "item/" + item.getId().getPath()));
	}
	
	private ItemModelBuilder panesimpleItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
		return withExistingParent(block.getId().getPath(),
				new ResourceLocation("item/generated")).texture("layer0",
				new ResourceLocation(TheLunaris.MODID, "block/" + baseBlock.getId().getPath())).renderType("translucent");
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
	
	public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(TheLunaris.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(TheLunaris.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TheLunaris.MODID,"item/" + item.getId().getPath()));
    }
}
