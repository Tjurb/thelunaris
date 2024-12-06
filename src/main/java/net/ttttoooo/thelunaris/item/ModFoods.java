package net.ttttoooo.thelunaris.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
	public static final FoodProperties LOONBERRY = new FoodProperties.Builder().fast()
			.nutrition(1).saturationMod(0.1f).build();
	public static final FoodProperties SARROT = new FoodProperties.Builder().fast()
			.nutrition(1).saturationMod(0.1f).build();
	public static final FoodProperties ARCHFISH = new FoodProperties.Builder().fast()
			.nutrition(2).saturationMod(0.2f).build();
	public static final FoodProperties COOKED_ARCHFISH = new FoodProperties.Builder().fast()
			.nutrition(3).saturationMod(0.2f).build();
	public static final FoodProperties LUN_BREAD = new FoodProperties.Builder().fast()
			.nutrition(5).saturationMod(0.2f).build();
	public static final FoodProperties LOONBERRY_PIE = new FoodProperties.Builder().fast()
			.nutrition(8).saturationMod(0.4f).build();
	public static final FoodProperties SPICY_ARCHFISH = new FoodProperties.Builder().fast()
			.nutrition(8).saturationMod(0.5f).build();
}
