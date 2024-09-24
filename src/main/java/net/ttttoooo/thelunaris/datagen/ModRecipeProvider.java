package net.ttttoooo.thelunaris.datagen;

import java.util.function.Consumer;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder{

	public ModRecipeProvider(PackOutput pOutput) {
		super(pOutput);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
		// TODO Auto-generated method stub
		
	}

}
