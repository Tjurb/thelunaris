package net.ttttoooo.thelunaris.datagen;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.ttttoooo.thelunaris.TheLunaris;
import net.ttttoooo.thelunaris.entity.ModEntities;

public class ModEntityTagProvider extends EntityTypeTagsProvider{
	public ModEntityTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, @Nullable ExistingFileHelper helper) {
        super(output, registries, TheLunaris.MODID, helper);
    }
	
	@Override
	protected void addTags(HolderLookup.Provider pProvider) {	
		this.tag(EntityTypeTags.FALL_DAMAGE_IMMUNE)
			.add(ModEntities.HEX.get());
		
		this.tag(EntityTypeTags.IMPACT_PROJECTILES)
			.add(ModEntities.HEX_PROJECTILE.get());
	}

}
