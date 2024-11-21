package net.ttttoooo.thelunaris.block.entitiy;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.ttttoooo.thelunaris.recipe.LunarCraftingRecipe;
import net.ttttoooo.thelunaris.screen.LunarCrafterMenu;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Optional;

public class LunarCrafterEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(10);

    private static final int CATELYST = 0;
    private static final int INPUT_SLOT_1 = 1;
    private static final int INPUT_SLOT_2 = 2;
    private static final int INPUT_SLOT_3 = 3;
    private static final int INPUT_SLOT_4 = 4;
    private static final int INPUT_SLOT_5 = 5;
    private static final int INPUT_SLOT_6 = 6;
    private static final int INPUT_SLOT_7 = 7;
    private static final int INPUT_SLOT_8 = 8;
    private static final int OUTPUT_SLOT = 9;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;

    public LunarCrafterEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.LUNAR_CRAFTING_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int getCount() {
                return 10;
            }

			@Override
			public int get(int p_39284_) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public void set(int p_39285_, int p_39286_) {
				// TODO Auto-generated method stub
				
			}
        };
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for(int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.thelunaris.lunar_crafter");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new LunarCrafterMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
    }

    private void craftItem() {
        Optional<LunarCraftingRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) {
            return;
        }

        LunarCraftingRecipe currentRecipe = recipe.get();
        ItemStack result = currentRecipe.getResultItem(getLevel().registryAccess());

        // Consume catalyst
        itemHandler.extractItem(CATELYST, 1, false);

        // Consume inputs
        for (int i = INPUT_SLOT_1; i <= INPUT_SLOT_8; i++) {
            itemHandler.extractItem(i, 1, false);
        }

        // Place result in output slot
        itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(result.getItem(),
                itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + result.getCount()));
    }


    private boolean hasRecipe() {
        Optional<LunarCraftingRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) {
            return false;
        }

        LunarCraftingRecipe currentRecipe = recipe.get();

        // Check if the catalyst matches
        ItemStack catalystStack = itemHandler.getStackInSlot(CATELYST);
        if (!currentRecipe.getCatalyst().test(catalystStack)) {
            return false;
        }

        // Check if all input items match the pattern
        for (int i = INPUT_SLOT_1; i <= INPUT_SLOT_8; i++) {
            ItemStack inputStack = itemHandler.getStackInSlot(i);
            if (!currentRecipe.isValidInput(i - INPUT_SLOT_1, inputStack)) {
                return false;
            }
        }

        // Check if the output slot can accept the result
        ItemStack result = currentRecipe.getResultItem(getLevel().registryAccess());
        return canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());
    }

    private Optional<LunarCraftingRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());
        for(int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, this.itemHandler.getStackInSlot(i));
        }

        return this.level.getRecipeManager().getRecipeFor(LunarCraftingRecipe.Type.INSTANCE, inventory, level);
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(OUTPUT_SLOT).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + count <= this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
    }
}