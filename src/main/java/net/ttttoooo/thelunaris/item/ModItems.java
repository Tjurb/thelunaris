package net.ttttoooo.thelunaris.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ttttoooo.thelunaris.TheLunaris;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS =
			DeferredRegister.create(ForgeRegistries.ITEMS, TheLunaris.MODID);
	
	public static final RegistryObject<Item> MOONDIAL = ITEMS.register("moondial", 
			() -> new Item(new Item.Properties()));
	
	//materials
	public static final RegistryObject<Item> MOONSTEEL = ITEMS.register("moonsteel", 
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> EMOONSTEEL = ITEMS.register("emoonsteel", 
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> LUNARITE = ITEMS.register("lunarite", 
			() -> new Item(new Item.Properties()));
	
	//tools
	
	
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
