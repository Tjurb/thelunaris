package net.ttttoooo.thelunaris.entity.custom;

import java.util.EnumSet;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class HexEntity extends Monster {
	private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(HexEntity.class, EntityDataSerializers.BOOLEAN);
    
	public HexEntity(EntityType<? extends Monster> p_27557_, Level p_27558_) {
		super(p_27557_, p_27558_);
		  this.checkSlowFallDistance();;
	      this.xpReward = 10;
	}
	
	public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;
    
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

        if(this.isAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 80; // Length in ticks of your animation
            attackAnimationState.start(this.tickCount);
        } else {
            --this.attackAnimationTimeout;
        }

        if(!this.isAttacking()) {
            attackAnimationState.stop();
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
        this.goalSelector.addGoal(0, new FloatGoal(this));
        
        this.goalSelector.addGoal(1, new HexAttackGoal(this));

        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.1D));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));

    }
	
	public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
    }

	public static AttributeSupplier.Builder createAttributes(){
		return createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 20D)
				.add(Attributes.MOVEMENT_SPEED, (double)0.2F)
				.add(Attributes.FOLLOW_RANGE, 48D)
                .add(Attributes.ARMOR_TOUGHNESS, 0.1f)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5f)
                .add(Attributes.ATTACK_DAMAGE, 2f);
	}
	
	public void aiStep() {
	      if (!this.onGround() && this.getDeltaMovement().y < 0.0D) {
	         this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.6D, 1.0D));
	      }

	      if (this.level().isClientSide) {
	         if (this.random.nextInt(24) == 0 && !this.isSilent()) {
	            this.level().playLocalSound(this.getX() + 0.5D, this.getY() + 0.5D, this.getZ() + 0.5D, SoundEvents.ENDERMAN_AMBIENT, this.getSoundSource(), 1.0F + this.random.nextFloat(), this.random.nextFloat() * 0.7F + 0.3F, false);
	         }

	         for(int i = 0; i < 2; ++i) {
	            this.level().addParticle(ParticleTypes.ENCHANT, this.getRandomX(0.5D), this.getRandomY(), this.getRandomZ(0.5D), 0.0D, 0.0D, 0.0D);
	         }
	      }

	      super.aiStep();
	}
	
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.BLAZE_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.BLAZE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BLAZE_DEATH;
    }
    
    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }

     static class HexAttackGoal extends Goal {
        private final HexEntity hex;
        private int attackStep;
        private int attackTime;
        private int lastSeen;

        public HexAttackGoal(HexEntity p_32247_) {
           this.hex = p_32247_;
           this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        public boolean canUse() {
           LivingEntity livingentity = this.hex.getTarget();
           return livingentity != null && livingentity.isAlive() && this.hex.canAttack(livingentity);
        }

        public void start() {
           this.attackStep = 0;
        }

        public void stop() {
           this.lastSeen = 0;
        }

        public boolean requiresUpdateEveryTick() {
           return true;
        }

        public void tick() {
           --this.attackTime;
           LivingEntity livingentity = this.hex.getTarget();
           if (livingentity != null) {
              boolean flag = this.hex.getSensing().hasLineOfSight(livingentity);
              if (flag) {
                 this.lastSeen = 0;
              } else {
                 ++this.lastSeen;
              }

              double d0 = this.hex.distanceToSqr(livingentity);
              if (d0 < 4.0D) {
                 if (!flag) {
                    return;
                 }

                 if (this.attackTime <= 0) {
                    this.attackTime = 20;
                    this.hex.doHurtTarget(livingentity);
                 }

                 this.hex.getMoveControl().setWantedPosition(livingentity.getX(), livingentity.getY(), livingentity.getZ(), 1.0D);
              } else if (d0 < this.getFollowDistance() * this.getFollowDistance() && flag) {
                 double d1 = livingentity.getX() - this.hex.getX();
                 double d2 = livingentity.getY(0.5D) - this.hex.getY(0.5D);
                 double d3 = livingentity.getZ() - this.hex.getZ();
                 if (this.attackTime <= 0) {
                    ++this.attackStep;
                    if (this.attackStep == 1) {
                       this.attackTime = 60;
                    } else if (this.attackStep <= 4) {
                       this.attackTime = 6;
                    } else {
                       this.attackTime = 100;
                       this.attackStep = 0;
                    }

                    if (this.attackStep > 1) {
                       double d4 = Math.sqrt(Math.sqrt(d0)) * 0.5D;
                       if (!this.hex.isSilent()) {
                          this.hex.level().levelEvent((Player)null, 1018, this.hex.blockPosition(), 0);
                       }

                       for(int i = 0; i < 1; ++i) {
                    	  HexProjectile hexProjectile = new HexProjectile(this.hex.level(), this.hex, this.hex.getRandom().triangle(d1, 2.297D * d4), d2, this.hex.getRandom().triangle(d3, 2.297D * d4));
                    	  hexProjectile.setPos(hexProjectile.getX(), this.hex.getY(0.5D) + 0.5D, hexProjectile.getZ());
                          this.hex.level().addFreshEntity(hexProjectile);
                       }
                    }
                 }

                 this.hex.getLookControl().setLookAt(livingentity, 10.0F, 10.0F);
              } else if (this.lastSeen < 5) {
                 this.hex.getMoveControl().setWantedPosition(livingentity.getX(), livingentity.getY(), livingentity.getZ(), 1.0D);
              }

              super.tick();
           }
        }

        private double getFollowDistance() {
           return this.hex.getAttributeValue(Attributes.FOLLOW_RANGE);
        }
     }
  }