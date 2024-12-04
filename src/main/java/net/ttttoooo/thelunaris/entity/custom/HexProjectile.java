package net.ttttoooo.thelunaris.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.ttttoooo.thelunaris.entity.ModEntities;
import net.ttttoooo.thelunaris.item.ModItems;

public class HexProjectile extends Fireball{
	private static final EntityDataAccessor<ItemStack> DATA_ITEM_STACK = SynchedEntityData.defineId(Fireball.class, EntityDataSerializers.ITEM_STACK);
	
	public HexProjectile(EntityType<? extends HexProjectile> p_37364_, Level p_37365_) {
		super(p_37364_, p_37365_);
	}

	public HexProjectile(Level p_37375_, LivingEntity p_37376_, double p_37377_, double p_37378_, double p_37379_) {
		super(ModEntities.HEX_PROJECTILE.get(), p_37376_, p_37377_, p_37378_, p_37379_, p_37375_);
	}

	public HexProjectile(Level p_37367_, double p_37368_, double p_37369_, double p_37370_, double p_37371_, double p_37372_, double p_37373_) {
		super(ModEntities.HEX_PROJECTILE.get(), p_37368_, p_37369_, p_37370_, p_37371_, p_37372_, p_37373_, p_37367_);
	}

	protected void onHitEntity(EntityHitResult p_37386_) {
		super.onHitEntity(p_37386_);
			if (!this.level().isClientSide) {
		         Entity entity = p_37386_.getEntity();
		         Entity entity1 = this.getOwner();
		         int i = entity.getRemainingFireTicks();
		         entity.setSecondsOnFire(5);
		         if (!entity.hurt(this.damageSources().fireball(this, entity1), 5.0F)) {
		            entity.setRemainingFireTicks(i);
		         } else if (entity1 instanceof LivingEntity) {
		            this.doEnchantDamageEffects((LivingEntity)entity1, entity);
		         }
			}
	}

	protected void onHitBlock(BlockHitResult p_37384_) {
		super.onHitBlock(p_37384_);
		if (!this.level().isClientSide) {
	         this.discard();
		}
	}

	protected void onHit(HitResult p_37388_) {
		super.onHit(p_37388_);
		if (!this.level().isClientSide) {
			this.discard();
		}
	}
	
	public void setItem(ItemStack p_37011_) {
		if (!p_37011_.is(ModItems.HEXCHARGE.get()) || p_37011_.hasTag()) {
	         this.getEntityData().set(DATA_ITEM_STACK, p_37011_.copyWithCount(1));
		}
	}

	public ItemStack getItem() {
		ItemStack itemstack = this.getItemRaw();
		return itemstack.isEmpty() ? new ItemStack(ModItems.HEXCHARGE.get()) : itemstack;
	}

	public boolean isPickable() {
		return false;
	}

	public boolean hurt(DamageSource p_37381_, float p_37382_) {
		return false;
	}
}
