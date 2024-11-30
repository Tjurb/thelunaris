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
		simpleItem(ModItems.RAW_MOONSTEEL);
		simpleItem(ModItems.LABRADORITE);
		simpleItem(ModItems.EMOONSTEEL);
		simpleItem(ModItems.LUNARITE);
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
		
		//walls
		wallItem(ModBlocks.COBBLED_VAILSTONE_WALL, ModBlocks.COBBLED_VAILSTONE);
		wallItem(ModBlocks.VAILSTONEBRICK_WALL, ModBlocks.VAILSTONEBRICK);
		wallItem(ModBlocks.SMOOTHGNEISS_WALL, ModBlocks.SMOOTHGNEISS);
		wallItem(ModBlocks.SMOOTHLUNARSLATE_WALL, ModBlocks.SMOOTHLUNARSLATE);
		wallItem(ModBlocks.SMOOTHMARBLE_WALL, ModBlocks.SMOOTHMARBLE);
		wallItem(ModBlocks.LUNSANDSTONE_WALL, ModBlocks.LUNSANDSTONE);
		
		//stairs
		evenSimplerBlockItem(ModBlocks.COBBLED_VAILSTONE_STAIRS);
		evenSimplerBlockItem(ModBlocks.VAILSTONEBRICK_STAIRS);
		evenSimplerBlockItem(ModBlocks.SMOOTHGNEISS_STAIRS);
		evenSimplerBlockItem(ModBlocks.SMOOTHLUNARSLATE_STAIRS);
		evenSimplerBlockItem(ModBlocks.SMOOTHMARBLE_STAIRS);
		evenSimplerBlockItem(ModBlocks.CELEST_STAIRS);
		evenSimplerBlockItem(ModBlocks.STELLAR_STAIRS);
		evenSimplerBlockItem(ModBlocks.SKYOAK_STAIRS);
		evenSimplerBlockItem(ModBlocks.LUNSANDSTONE_STAIRS);
		
		//slabs
		evenSimplerBlockItem(ModBlocks.COBBLED_VAILSTONE_SLAB);
		evenSimplerBlockItem(ModBlocks.VAILSTONEBRICK_SLAB);
		evenSimplerBlockItem(ModBlocks.SMOOTHGNEISS_SLAB);
		evenSimplerBlockItem(ModBlocks.SMOOTHLUNARSLATE_SLAB);
		evenSimplerBlockItem(ModBlocks.SMOOTHMARBLE_SLAB);
		evenSimplerBlockItem(ModBlocks.CELEST_SLAB);
		evenSimplerBlockItem(ModBlocks.STELLAR_SLAB);
		evenSimplerBlockItem(ModBlocks.SKYOAK_SLAB);
		evenSimplerBlockItem(ModBlocks.LUNSANDSTONE_SLAB);

		//saplings
		saplingItem(ModBlocks.CELEST_SAPLING);
		saplingItem(ModBlocks.STELLAR_SAPLING);
		saplingItem(ModBlocks.SKYOAK_SAPLING);
		
		//nature
		saplingItem(ModBlocks.LUNGRASS);
		saplingItem(ModBlocks.WILD_LOONBERRY);
		saplingItem(ModBlocks.WILD_SARROT);
	}
	
	private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TheLunaris.MODID,"block/" + item.getId().getPath()));
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
