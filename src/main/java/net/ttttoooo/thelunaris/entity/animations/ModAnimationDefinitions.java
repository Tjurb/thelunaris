package net.ttttoooo.thelunaris.entity.animations;


import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
public class ModAnimationDefinitions {

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
