package com.desx.rebornworld.entity.Animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;


public class OceanAnimationDefinitions {
    public static final AnimationDefinition IDLE = AnimationDefinition.Builder.withLength(2f).looping()
            .addAnimation("head",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("leg1",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -5f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, -3.75f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 2.5f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 1.56f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(2f, KeyframeAnimations.degreeVec(0f, -5f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("leg2",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 5f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 3.75f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, -1.56f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 5f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("leg3",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(-0.87f, 4.92f, -10.04f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(0.5f, KeyframeAnimations.degreeVec(-0.65f, 3.69f, -10.02f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(0.35f, -2.48f, -8.01f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1.5f, KeyframeAnimations.degreeVec(0.24f, -1.54f, -9f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(2f, KeyframeAnimations.degreeVec(-0.87f, 4.92f, -10.04f),
                                    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("leg4",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(-0.87f, -4.92f, 10.04f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(0.5f, KeyframeAnimations.degreeVec(-0.72f, -3.68f, 11.02f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(0.48f, 2.45f, 11.01f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1.5f, KeyframeAnimations.degreeVec(0.27f, 1.54f, 10f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(2f, KeyframeAnimations.degreeVec(-0.87f, -4.92f, 10.04f),
                                    AnimationChannel.Interpolations.CATMULLROM))).build();
    public static final AnimationDefinition СRAWLING = AnimationDefinition.Builder.withLength(2f).looping()
            .addAnimation("head",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 1.1f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 1f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1f, KeyframeAnimations.posVec(0f, 0.3f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1.55f, KeyframeAnimations.posVec(0f, 0.31f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(2f, KeyframeAnimations.posVec(0f, 1.1f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("leg1",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -5f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(0.5f, KeyframeAnimations.degreeVec(-4f, -3.75f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 2.5f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1.5f, KeyframeAnimations.degreeVec(4f, 1.56f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(2f, KeyframeAnimations.degreeVec(0f, -5f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("leg2",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 5f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(0.5f, KeyframeAnimations.degreeVec(10f, 3.75f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1.5f, KeyframeAnimations.degreeVec(-6f, -1.56f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 5f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("leg3",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(-1.13f, -40.07f, -9.23f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(0.5f, KeyframeAnimations.degreeVec(-0.65f, 3.69f, -10.02f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1.25f, KeyframeAnimations.degreeVec(-0.63f, -2.42f, 14.51f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(2f, KeyframeAnimations.degreeVec(-1.13f, -40.07f, -9.23f),
                                    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("leg4",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(-1.13f, 40.07f, 9.23f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(0.5f, KeyframeAnimations.degreeVec(-0.72f, -3.68f, 11.02f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1.25f, KeyframeAnimations.degreeVec(-0.5f, 2.45f, -11.51f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(2f, KeyframeAnimations.degreeVec(-1.13f, 40.07f, 9.23f),
                                    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("all",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0.3f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 1f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1f, KeyframeAnimations.posVec(0f, 1.6f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(2f, KeyframeAnimations.posVec(0f, 0.3f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("all",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(2f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("body_rotation",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(1f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 1.13f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(-1f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, -1f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(2f, KeyframeAnimations.degreeVec(1f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM))).build();
    public static final AnimationDefinition EATS = AnimationDefinition.Builder.withLength(1f).looping()
            .addAnimation("head",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(0.15f, KeyframeAnimations.degreeVec(15f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(0.4f, KeyframeAnimations.degreeVec(10f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(0.65f, KeyframeAnimations.degreeVec(15f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(0.9f, KeyframeAnimations.degreeVec(10f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("leg1",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, -10f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 7.5f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("leg2",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 10f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, -5f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("leg3",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, -5f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 5f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("leg4",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 5f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, -5f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition FLOATSNORMALLY = AnimationDefinition.Builder.withLength(2f).looping()
.addAnimation("head",
                      new AnimationChannel(AnimationChannel.Targets.POSITION,
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 1.1f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 1f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1f, KeyframeAnimations.posVec(0f, 0.3f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.5f, KeyframeAnimations.posVec(0f, 0.31f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(2f, KeyframeAnimations.posVec(0f, 1.1f, 0f),
    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("head",
                                  new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(-9f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.65f, KeyframeAnimations.degreeVec(-5f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.15f, KeyframeAnimations.degreeVec(16f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(2f, KeyframeAnimations.degreeVec(-9f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("leg1",
                                  new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(-20f, -5f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.5f, KeyframeAnimations.degreeVec(-4f, -3.75f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1f, KeyframeAnimations.degreeVec(7.5f, 2.5f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.5f, KeyframeAnimations.degreeVec(4f, 1.56f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(2f, KeyframeAnimations.degreeVec(-20f, -5f, 0f),
    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("leg2",
                                  new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 5f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.5f, KeyframeAnimations.degreeVec(10f, 3.75f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1f, KeyframeAnimations.degreeVec(-17.5f, -2.5f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.5f, KeyframeAnimations.degreeVec(-6f, -1.56f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 5f, 0f),
    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("leg3",
                                  new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(17.97f, -36.85f, 16.07f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.5f, KeyframeAnimations.degreeVec(24.35f, 3.69f, -10.02f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1f, KeyframeAnimations.degreeVec(-13.8f, 12.79f, -27.71f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.5f, KeyframeAnimations.degreeVec(-8.55f, -13.35f, 13.99f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(2f, KeyframeAnimations.degreeVec(17.97f, -36.85f, 16.07f),
    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("leg4",
                                  new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(14.79f, 37.54f, -13.05f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.5f, KeyframeAnimations.degreeVec(26.78f, -3.68f, 11.02f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1f, KeyframeAnimations.degreeVec(-23.46f, -17.97f, 35.5f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.5f, KeyframeAnimations.degreeVec(-7.22f, 10.71f, -11.93f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(2f, KeyframeAnimations.degreeVec(14.79f, 37.54f, -13.05f),
    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("body_rotation",
                                  new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(1f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 1.13f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1f, KeyframeAnimations.degreeVec(-1f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, -1f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(2f, KeyframeAnimations.degreeVec(1f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("all",
                                  new AnimationChannel(AnimationChannel.Targets.POSITION,
		new Keyframe(0f, KeyframeAnimations.posVec(0f, -0.9f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 1.3f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1f, KeyframeAnimations.posVec(0f, 2.1f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.5f, KeyframeAnimations.posVec(0f, -1.09f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(2f, KeyframeAnimations.posVec(0f, -0.9f, 0f),
    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("all",
                                  new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.5f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1f, KeyframeAnimations.degreeVec(-1.5f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.5f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(2f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM))).build();
    public static final AnimationDefinition FLOATSFAST = AnimationDefinition.Builder.withLength(1.875f).looping()
.addAnimation("head",
                      new AnimationChannel(AnimationChannel.Targets.POSITION,
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 1.1f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.4f, KeyframeAnimations.posVec(0f, 1f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.9f, KeyframeAnimations.posVec(0f, 0.3f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.4f, KeyframeAnimations.posVec(0f, 0.31f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.9f, KeyframeAnimations.posVec(0f, 1.1f, 0f),
    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("head",
                                  new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(-9f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.55f, KeyframeAnimations.degreeVec(-5f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.05f, KeyframeAnimations.degreeVec(16f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.9f, KeyframeAnimations.degreeVec(-9f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("leg1",
                                  new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(22.5f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.5f, KeyframeAnimations.degreeVec(-22.5f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1f, KeyframeAnimations.degreeVec(22.5f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.5f, KeyframeAnimations.degreeVec(-22.5f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.9f, KeyframeAnimations.degreeVec(22.5f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("leg2",
                                  new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(-22.5f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.5f, KeyframeAnimations.degreeVec(22.5f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1f, KeyframeAnimations.degreeVec(-22.5f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.5f, KeyframeAnimations.degreeVec(22.5f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.9f, KeyframeAnimations.degreeVec(-22.5f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("leg3",
                                  new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(17.97f, -36.85f, 16.07f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.35f, KeyframeAnimations.degreeVec(15.95f, 18.99f, -50.63f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.9f, KeyframeAnimations.degreeVec(-13.8f, 12.79f, -27.71f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.4f, KeyframeAnimations.degreeVec(-8.55f, -13.35f, 13.99f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.9f, KeyframeAnimations.degreeVec(17.97f, -36.85f, 16.07f),
    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("leg4",
                                  new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(14.79f, 37.54f, -13.05f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.35f, KeyframeAnimations.degreeVec(16.06f, -22.02f, 56.26f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.9f, KeyframeAnimations.degreeVec(-23.46f, -17.97f, 35.5f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.4f, KeyframeAnimations.degreeVec(-7.22f, 10.71f, -11.93f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.9f, KeyframeAnimations.degreeVec(14.79f, 37.54f, -13.05f),
    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("body_rotation",
                                  new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(1f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.3f, KeyframeAnimations.degreeVec(3.08f, 0.75f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.55f, KeyframeAnimations.degreeVec(0f, 1.13f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.9f, KeyframeAnimations.degreeVec(-1f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.4f, KeyframeAnimations.degreeVec(0f, -1f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.65f, KeyframeAnimations.degreeVec(-2.07f, -0.61f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.9f, KeyframeAnimations.degreeVec(1f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("all",
                                  new AnimationChannel(AnimationChannel.Targets.POSITION,
		new Keyframe(0f, KeyframeAnimations.posVec(0f, -0.9f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.4f, KeyframeAnimations.posVec(0f, 1.3f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.9f, KeyframeAnimations.posVec(0f, 2.1f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.4f, KeyframeAnimations.posVec(0f, -1.09f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.9f, KeyframeAnimations.posVec(0f, -0.9f, 0f),
    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("all",
                                  new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.4f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.9f, KeyframeAnimations.degreeVec(-1.5f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.4f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.9f,KeyframeAnimations.degreeVec(5f, 0f, 0f),
    AnimationChannel.Interpolations.CATMULLROM))).build();

}