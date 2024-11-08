package net.ttttoooo.thelunaris.entity.animations;


import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
public class ModAnimationDefinitions {

	//Hex Animations

public static final AnimationDefinition HEX_IDLE = AnimationDefinition.Builder.withLength(1f).looping()
.addAnimation("limb1",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 360f),
			AnimationChannel.Interpolations.LINEAR))).build();
public static final AnimationDefinition HEX_WALKING = AnimationDefinition.Builder.withLength(1f).build();
public static final AnimationDefinition HEX_ATTACKING = AnimationDefinition.Builder.withLength(1f).build();

	//LunarSleeper Animations
public static final AnimationDefinition LUNARSLEEPER_IDLE = AnimationDefinition.Builder.withLength(1f).looping()
.addAnimation("tail",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -60f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, -60f, -30f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, -60f, 30f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.375f, KeyframeAnimations.degreeVec(0f, -60f, -30f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, -60f, 30f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.625f, KeyframeAnimations.degreeVec(0f, -60f, -30f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, -60f, 30f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, -60f, -30f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, -60f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("seg9",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -60f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("seg7",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -60f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("seg6",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -50f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("seg5",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -50f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("seg4",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -50f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("seg3",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -45f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("seg2",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -45f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("seg1",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 45f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("seg8",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -60f, 0f),
			AnimationChannel.Interpolations.LINEAR))).build();
public static final AnimationDefinition LUNARSLEEPER_WALKING = AnimationDefinition.Builder.withLength(2f).looping()
.addAnimation("torso",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 10f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, -10f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("seg1",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 25f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, -25f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("seg2",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, -25f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 25f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("seg3",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, -25f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 25f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("seg4",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 25f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, -25f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("seg5",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, -25f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 25f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("seg6",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 25f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, -25f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("seg7",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 25f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, -25f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("seg8",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, -25f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 25f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("seg9",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, -45f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 45f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR))).build();
public static final AnimationDefinition LUNARSLEEPER_ATTACKING = AnimationDefinition.Builder.withLength(1f)
.addAnimation("torso",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.25f, KeyframeAnimations.degreeVec(30f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR))).build();

	//Phyrex Animations
public static final AnimationDefinition PHYREX_IDLE = AnimationDefinition.Builder.withLength(2f).looping()
.addAnimation("torso",
	new AnimationChannel(AnimationChannel.Targets.SCALE,
		new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.scaleVec(1.01f, 1.01f, 1.01f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("tail",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 50f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, -50f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR))).build();
public static final AnimationDefinition PHYREX_WALKING = AnimationDefinition.Builder.withLength(2f).looping()
.addAnimation("torso",
	new AnimationChannel(AnimationChannel.Targets.SCALE,
		new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.scaleVec(1.01f, 1.01f, 1.01f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("tail",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 25f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, -25f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("head",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(-35f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(-25f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(-35f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("leftlegbone",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(45f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(-45f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("rightlegbone",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(-45f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(45f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("leftwing",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, -10f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 10f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("rightwing",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 10f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, -10f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("outerwingrightbone",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 10f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("outerwingleftbone",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, -10f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("innerwingrightbone",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, -10f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("innerwingleftbone",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 10f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("neckbone",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 1f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("neckbone",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(35f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(25f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(35f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR))).build();
public static final AnimationDefinition PHYREX_ATTACKING = AnimationDefinition.Builder.withLength(2f)
.addAnimation("torso",
	new AnimationChannel(AnimationChannel.Targets.SCALE,
		new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.scaleVec(1.01f, 1.01f, 1.01f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("tail",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 25f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, -25f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("head",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(-35f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(-25f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(-35f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("leftwing",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.25f, KeyframeAnimations.degreeVec(70f, 50f, -70f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 10f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("rightwing",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.25f, KeyframeAnimations.degreeVec(70f, -50f, 70f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, -10f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("outerwingrightbone",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 90f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 10f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("outerwingleftbone",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, -90f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, -10f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("innerwingrightbone",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, -100f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, -10f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("innerwingleftbone",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 100f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 10f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("neckbone",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 1f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("neckbone",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(35f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(25f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(35f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR))).build();
	
	//Moonsnail Animations
	public static final AnimationDefinition MOONSNAIL_IDLE = AnimationDefinition.Builder.withLength(0f).build();
	public static final AnimationDefinition MOONSNAIL_WALKING = AnimationDefinition.Builder.withLength(4f).looping()
	.addAnimation("head",
		new AnimationChannel(AnimationChannel.Targets.POSITION, 
			new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, -0.5f),
				AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.LINEAR)))
	.addAnimation("mantle",
		new AnimationChannel(AnimationChannel.Targets.SCALE,
			new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
				AnimationChannel.Interpolations.LINEAR),
			new Keyframe(2f, KeyframeAnimations.scaleVec(1f, 1f, 1.2f),
				AnimationChannel.Interpolations.LINEAR),
			new Keyframe(4f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
				AnimationChannel.Interpolations.LINEAR))).build();
	
	//Archfish Animations
public static final AnimationDefinition ARCHFISH_SWIM = AnimationDefinition.Builder.withLength(2f).looping()
.addAnimation("head",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("bodyFront",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(0.5f, KeyframeAnimations.posVec(1f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(1.5f, KeyframeAnimations.posVec(-1f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("bodyFront",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 5f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 10f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 5f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.25f, KeyframeAnimations.degreeVec(0f, -5f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, -10f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.75f, KeyframeAnimations.degreeVec(0f, -5f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("bodyBack",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(0.5f, KeyframeAnimations.posVec(1f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(1.5f, KeyframeAnimations.posVec(-1f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("bodyBack",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, -5f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, -10f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, -5f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.25f, KeyframeAnimations.degreeVec(0f, 5f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 10f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.75f, KeyframeAnimations.degreeVec(0f, 5f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("tailfin",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(0.5f, KeyframeAnimations.posVec(1f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(1.5f, KeyframeAnimations.posVec(-1f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("tailfin",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 5f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 10f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 5f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.25f, KeyframeAnimations.degreeVec(0f, -5f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, -10f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.75f, KeyframeAnimations.degreeVec(0f, -5f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR))).build();

public static final AnimationDefinition ARCHFISH_IDLE = AnimationDefinition.Builder.withLength(2f).looping()
.addAnimation("head",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("bodyFront",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(0.5f, KeyframeAnimations.posVec(0.5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(1.5f, KeyframeAnimations.posVec(-0.5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("bodyFront",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 5f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, -5f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("bodyBack",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(0.5f, KeyframeAnimations.posVec(0.5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(1.5f, KeyframeAnimations.posVec(-0.5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("bodyBack",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, -5f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 5f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("tailfin",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(0.5f, KeyframeAnimations.posVec(0.5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(1.5f, KeyframeAnimations.posVec(-0.5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("tailfin",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 5f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, -5f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR))).build();
	
	//Mooncow Animations
public static final AnimationDefinition MOONCOW_IDLE = AnimationDefinition.Builder.withLength(1.5f).looping()
.addAnimation("torso",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(0.75f, KeyframeAnimations.posVec(0f, -1f, 0f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(1.5f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM)))
.addAnimation("torso",
	new AnimationChannel(AnimationChannel.Targets.SCALE,
		new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.75f, KeyframeAnimations.scaleVec(1.05f, 1.05f, 1.05f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(1.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
			AnimationChannel.Interpolations.CATMULLROM))).build();

public static final AnimationDefinition MOONCOW_WALKING = AnimationDefinition.Builder.withLength(2f).looping()
.addAnimation("right_front_leg",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("left_front_leg",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("left_back_leg",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("right_back_leg",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("torso",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(0.5f, KeyframeAnimations.posVec(0f, -1f, 0f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(1.5f, KeyframeAnimations.posVec(0f, -1f, 0f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM)))
.addAnimation("torso",
	new AnimationChannel(AnimationChannel.Targets.SCALE,
		new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.5f, KeyframeAnimations.scaleVec(1.05f, 1.05f, 1.05f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(1f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(1.5f, KeyframeAnimations.scaleVec(1.05f, 1.05f, 1.05f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(2f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
			AnimationChannel.Interpolations.CATMULLROM))).build();
}
