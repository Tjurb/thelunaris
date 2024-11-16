package net.ttttoooo.thelunaris.recipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ttttoooo.thelunaris.TheLunaris;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, TheLunaris.MODID);

    public static final RegistryObject<RecipeSerializer<LunarCraftingRecipe>> LUNAR_CRAFTING_SERIALIZER =
            SERIALIZERS.register("lunar_crafting", () -> LunarCraftingRecipe.Serializer.INSTANCE);
    
    public static final RegistryObject<RecipeSerializer<MoonSteelEnrichingRecipe>> MOONSTEEL_ENRICHING_SERIALIZER =
            SERIALIZERS.register("moonsteel_enriching", () -> MoonSteelEnrichingRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}