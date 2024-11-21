package net.ttttoooo.thelunaris.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.ttttoooo.thelunaris.TheLunaris;

import org.jetbrains.annotations.Nullable;

public class LunarCraftingRecipe implements Recipe<SimpleContainer> {
    private final NonNullList<Ingredient> inputItems;
    private final Ingredient catalyst; // New field for catalyst
    private final ItemStack output;
    private final ResourceLocation id;

    public LunarCraftingRecipe(NonNullList<Ingredient> inputItems, ItemStack output, Ingredient catalyst, ResourceLocation id) {
        this.inputItems = inputItems;
        this.output = output;
        this.catalyst = catalyst;
        this.id = id;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if (pLevel.isClientSide()) {
            return false;
        }

        // Validate catalyst
        if (!catalyst.test(pContainer.getItem(0))) { // Assuming catalyst is in slot 0
            return false;
        }

        // Validate inputs (slots 1–8 in the crafting grid)
        for (int i = 1; i < pContainer.getContainerSize(); i++) {
            if (!inputItems.get(i - 1).test(pContainer.getItem(i))) {
                return false;
            }
        }

        return true;
    }
    
    public boolean isValidInput(int index, ItemStack stack) {
        if (index < 0 || index >= inputItems.size()) {
            return false; // Invalid index
        }
        return inputItems.get(index).test(stack); // Check if the ingredient matches
    }


    @Override
    public ItemStack assemble(SimpleContainer pContainer, RegistryAccess pRegistryAccess) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    public Ingredient getCatalyst() {
        return catalyst;
    }
    
    @Override
    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<LunarCraftingRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "lunar_crafting";
    }

    public static class Serializer implements RecipeSerializer<LunarCraftingRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(TheLunaris.MODID, "lunar_crafting");

        @Override
        public LunarCraftingRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));

            // Parse ingredients
            JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(ingredients.size(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            // Parse catalyst
            Ingredient catalyst = Ingredient.fromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "catalyst"));

            return new LunarCraftingRecipe(inputs, output, catalyst, pRecipeId);
        }


        @Override
        public LunarCraftingRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(pBuffer));
            }

            Ingredient catalyst = Ingredient.fromNetwork(pBuffer); // Read catalyst
            ItemStack output = pBuffer.readItem();

            return new LunarCraftingRecipe(inputs, output, catalyst, pRecipeId);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, LunarCraftingRecipe pRecipe) {
            pBuffer.writeInt(pRecipe.inputItems.size());

            for (Ingredient ingredient : pRecipe.inputItems) {
                ingredient.toNetwork(pBuffer);
            }

            pRecipe.catalyst.toNetwork(pBuffer); // Write catalyst
            pBuffer.writeItemStack(pRecipe.output, false);
        }
    }
}