package net.ttttoooo.thelunaris.entity.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class MoonsnailEntity extends WaterAnimal{

	public MoonsnailEntity(EntityType<? extends MoonsnailEntity> p_27523_, Level p_27524_) {
		super(p_27523_, p_27524_);
	}
	public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;


    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()) {
            setupAnimationStates();
        }
    }
	
    private void setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if(this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6F, 1f);
        } else {
            f = 0f;
        }

        this.walkAnimation.update(f, 0.2f);
    }
    
    @Override
	protected void registerGoals() {
        this.goalSelector.addGoal(0, new PanicGoal(this, 2.0D));
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));

    }

	public static AttributeSupplier.Builder createAttributes(){
		return createLivingAttributes()
				.add(Attributes.MAX_HEALTH, 3.0D)
				.add(Attributes.MOVEMENT_SPEED, (double)0.05F)
				.add(Attributes.FOLLOW_RANGE, 24D);
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.RABBIT_DEATH;
	}

	protected SoundEvent getHurtSound(DamageSource p_29795_) {
		return SoundEvents.DOLPHIN_HURT;
	}
}
