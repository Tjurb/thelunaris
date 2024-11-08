package net.ttttoooo.thelunaris.item;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.entity.ModEntities;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS =
			DeferredRegister.create(ForgeRegistries.ITEMS, TheLunaris.MODID);
	
	public static final RegistryObject<Item> MOONDIAL = ITEMS.register("moondial", 
			() -> new ModPortalIgniter(new Item.Properties().stacksTo(1).durability(100)));
	
	//materials
	public static final RegistryObject<Item> MOONSTEEL = ITEMS.register("moonsteel", 
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> RAW_MOONSTEEL = ITEMS.register("raw_moonsteel", 
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> LABRADORITE = ITEMS.register("labradorite", 
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> EMOONSTEEL = ITEMS.register("emoonsteel", 
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> LUNARITE = ITEMS.register("lunarite", 
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> LUNAR_STICK = ITEMS.register("lunar_stick", 
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> LUNAR_WHEAT = ITEMS.register("lunar_wheat", 
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> LUNAR_WHEAT_SEEDS = ITEMS.register("lunar_wheat_seeds", 
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> HEXDUST = ITEMS.register("hex_dust", 
			() -> new Item(new Item.Properties()));
	
	//foods
	public static final RegistryObject<Item> LOONBERRY = ITEMS.register("loonberry", 
			() -> new Item(new Item.Properties().food(ModFoods.LOONBERRY)));
	public static final RegistryObject<Item> ARCHFISH = ITEMS.register("archfish", 
			() -> new Item(new Item.Properties().food(ModFoods.ARCHFISH)));
	public static final RegistryObject<Item> SARROT = ITEMS.register("sarrot", 
			() -> new Item(new Item.Properties().food(ModFoods.SARROT)));
	public static final RegistryObject<Item> COOKED_ARCHFISH = ITEMS.register("cooked_archfish", 
			() -> new Item(new Item.Properties().food(ModFoods.COOKED_ARCHFISH)));
	public static final RegistryObject<Item> LOONBERRY_PIE = ITEMS.register("loonberry_pie", 
			() -> new Item(new Item.Properties().food(ModFoods.LOONBERRY_PIE)));
	public static final RegistryObject<Item> SPICY_ARCHFISH = ITEMS.register("spicy_archfish", 
			() -> new Item(new Item.Properties().food(ModFoods.SPICY_ARCHFISH)));
	
	//tools
	public static final RegistryObject<Item> VAILSTONE_SWORD = ITEMS.register("vailstone_sword", 
			() -> new SwordItem(ModToolTiers.VAILSTONE, 4, 2, new Item.Properties()));
	public static final RegistryObject<Item> VAILSTONE_PICKAXE = ITEMS.register("vailstone_pickaxe", 
			() -> new PickaxeItem(ModToolTiers.VAILSTONE, 2, 1, new Item.Properties()));
	public static final RegistryObject<Item> VAILSTONE_SHOVEL = ITEMS.register("vailstone_shovel", 
			() -> new ShovelItem(ModToolTiers.VAILSTONE, 0, 0, new Item.Properties()));
	public static final RegistryObject<Item> VAILSTONE_AXE = ITEMS.register("vailstone_axe", 
			() -> new AxeItem(ModToolTiers.VAILSTONE, 5, 1, new Item.Properties()));
	public static final RegistryObject<Item> VAILSTONE_HOE = ITEMS.register("vailstone_hoe", 
			() -> new HoeItem(ModToolTiers.VAILSTONE, 0, 0, new Item.Properties()));
	
	public static final RegistryObject<Item> MOONSTEEL_SWORD = ITEMS.register("moonsteel_sword", 
			() -> new SwordItem(ModToolTiers.MOONSTEEL, 4, 2, new Item.Properties()));
	public static final RegistryObject<Item> MOONSTEEL_PICKAXE = ITEMS.register("moonsteel_pickaxe", 
			() -> new PickaxeItem(ModToolTiers.MOONSTEEL, 2, 1, new Item.Properties()));
	public static final RegistryObject<Item> MOONSTEEL_SHOVEL = ITEMS.register("moonsteel_shovel", 
			() -> new ShovelItem(ModToolTiers.MOONSTEEL, 0, 0, new Item.Properties()));
	public static final RegistryObject<Item> MOONSTEEL_AXE = ITEMS.register("moonsteel_axe", 
			() -> new AxeItem(ModToolTiers.MOONSTEEL, 5, 1, new Item.Properties()));
	public static final RegistryObject<Item> MOONSTEEL_HOE = ITEMS.register("moonsteel_hoe", 
			() -> new HoeItem(ModToolTiers.MOONSTEEL, 0, 0, new Item.Properties()));
	

	public static final RegistryObject<Item> EMOONSTEEL_SWORD = ITEMS.register("emoonsteel_sword", 
			() -> new SwordItem(ModToolTiers.EMOONSTEEL, 4, 2, new Item.Properties()));
	public static final RegistryObject<Item> EMOONSTEEL_PICKAXE = ITEMS.register("emoonsteel_pickaxe", 
			() -> new PickaxeItem(ModToolTiers.EMOONSTEEL, 2, 1, new Item.Properties()));
	public static final RegistryObject<Item> EMOONSTEEL_SHOVEL = ITEMS.register("emoonsteel_shovel", 
			() -> new ShovelItem(ModToolTiers.EMOONSTEEL, 0, 0, new Item.Properties()));
	public static final RegistryObject<Item> EMOONSTEEL_AXE = ITEMS.register("emoonsteel_axe", 
			() -> new AxeItem(ModToolTiers.EMOONSTEEL, 5, 1, new Item.Properties()));
	public static final RegistryObject<Item> EMOONSTEEL_HOE = ITEMS.register("emoonsteel_hoe", 
			() -> new HoeItem(ModToolTiers.EMOONSTEEL, 0, 0, new Item.Properties()));
	

	public static final RegistryObject<Item> LUNARITE_SWORD = ITEMS.register("lunarite_sword", 
			() -> new SwordItem(ModToolTiers.LUNARITE, 4, 2, new Item.Properties()));
	public static final RegistryObject<Item> LUNARITE_PICKAXE = ITEMS.register("lunarite_pickaxe", 
			() -> new PickaxeItem(ModToolTiers.LUNARITE, 2, 1, new Item.Properties()));
	public static final RegistryObject<Item> LUNARITE_SHOVEL = ITEMS.register("lunarite_shovel", 
			() -> new ShovelItem(ModToolTiers.LUNARITE, 0, 0, new Item.Properties()));
	public static final RegistryObject<Item> LUNARITE_AXE = ITEMS.register("lunarite_axe", 
			() -> new AxeItem(ModToolTiers.LUNARITE, 5, 1, new Item.Properties()));
	public static final RegistryObject<Item> LUNARITE_HOE = ITEMS.register("lunarite_hoe", 
			() -> new HoeItem(ModToolTiers.LUNARITE, 0, 0, new Item.Properties()));
	
	//SpawnEggs
	public static final RegistryObject<Item> MOONCOW_SPANW_EGG = ITEMS.register("mooncow_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.MOONCOW, 0x758db3, 0xcffffff, new Item.Properties()));
	public static final RegistryObject<Item> ARCHFISH_SPANW_EGG = ITEMS.register("archfish_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.ARCHFISH, 0x00136f, 0x00648b, new Item.Properties()));
	public static final RegistryObject<Item> MOONSNAIL_SPANW_EGG = ITEMS.register("moonsnail_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.MOONSNAIL, 0x758db3, 0x837650, new Item.Properties()));
	public static final RegistryObject<Item> PHYREX_SPANW_EGG = ITEMS.register("phyrex_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.PHYREX, 0xff6500, 0x001ed3, new Item.Properties()));
	public static final RegistryObject<Item> LUNARSLEEPER_SPANW_EGG = ITEMS.register("lunarsleeper_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.LUNARSLEEPER, 0x5c3d80, 0xe41a3e, new Item.Properties()));
	public static final RegistryObject<Item> HEX_SPANW_EGG = ITEMS.register("hex_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.HEX, 0xff0079, 0xff67cf, new Item.Properties()));
	
	
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
