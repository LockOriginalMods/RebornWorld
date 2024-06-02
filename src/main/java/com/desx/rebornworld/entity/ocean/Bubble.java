//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.desx.rebornworld.entity.ocean;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Predicate;
import javax.annotation.Nullable;

import com.desx.rebornworld.block.egg.BubbleEggBlock;
import com.desx.rebornworld.entity.OceanEntities;
import com.desx.rebornworld.init.BlockInit;
import com.desx.rebornworld.init.ItemInit;
import com.google.common.collect.UnmodifiableIterator;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.navigation.AmphibiousPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEvent.Context;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Bubble extends Animal {

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
    private static final EntityDataAccessor<BlockPos> HOME_POS;
    private static final EntityDataAccessor<Boolean> HAS_EGG;
    private static final EntityDataAccessor<Boolean> LAYING_EGG;
    private static final EntityDataAccessor<BlockPos> TRAVEL_POS;
    private static final EntityDataAccessor<Boolean> GOING_HOME;
    private static final EntityDataAccessor<Boolean> TRAVELLING;
    public static final Ingredient FOOD_ITEMS;

    int layEggCounter;
    public static final Predicate<LivingEntity> BABY_ON_LAND_SELECTOR;

    public Bubble(EntityType<? extends Bubble> p_30132_, Level p_30133_) {
        super(p_30132_, p_30133_);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.DOOR_IRON_CLOSED, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.DOOR_WOOD_CLOSED, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.DOOR_OPEN, -1.0F);
        this.moveControl = new Bubble.TurtleMoveControl(this);
        this.setMaxUpStep(1.0F);
    }

    public void setHomePos(BlockPos p_30220_) {
        this.entityData.set(HOME_POS, p_30220_);
    }

    BlockPos getHomePos() {
        return (BlockPos)this.entityData.get(HOME_POS);
    }

    void setTravelPos(BlockPos p_30224_) {
        this.entityData.set(TRAVEL_POS, p_30224_);
    }

    BlockPos getTravelPos() {
        return (BlockPos)this.entityData.get(TRAVEL_POS);
    }

    public boolean hasEgg() {
        return (Boolean)this.entityData.get(HAS_EGG);
    }

    void setHasEgg(boolean p_30235_) {
        this.entityData.set(HAS_EGG, p_30235_);
    }

    public boolean isLayingEgg() {
        return (Boolean)this.entityData.get(LAYING_EGG);
    }

    void setLayingEgg(boolean p_30237_) {
        this.layEggCounter = p_30237_ ? 1 : 0;
        this.entityData.set(LAYING_EGG, p_30237_);
    }

    boolean isGoingHome() {
        return (Boolean)this.entityData.get(GOING_HOME);
    }

    void setGoingHome(boolean p_30239_) {
        this.entityData.set(GOING_HOME, p_30239_);
    }

    boolean isTravelling() {
        return (Boolean)this.entityData.get(TRAVELLING);
    }

    void setTravelling(boolean p_30241_) {
        this.entityData.set(TRAVELLING, p_30241_);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(HOME_POS, BlockPos.ZERO);
        this.entityData.define(HAS_EGG, false);
        this.entityData.define(TRAVEL_POS, BlockPos.ZERO);
        this.entityData.define(GOING_HOME, false);
        this.entityData.define(TRAVELLING, false);
        this.entityData.define(LAYING_EGG, false);
    }

    public void addAdditionalSaveData(CompoundTag p_30176_) {
        super.addAdditionalSaveData(p_30176_);
        p_30176_.putInt("HomePosX", this.getHomePos().getX());
        p_30176_.putInt("HomePosY", this.getHomePos().getY());
        p_30176_.putInt("HomePosZ", this.getHomePos().getZ());
        p_30176_.putBoolean("HasEgg", this.hasEgg());
        p_30176_.putInt("TravelPosX", this.getTravelPos().getX());
        p_30176_.putInt("TravelPosY", this.getTravelPos().getY());
        p_30176_.putInt("TravelPosZ", this.getTravelPos().getZ());
    }

    public void readAdditionalSaveData(CompoundTag p_30162_) {
        int $$1 = p_30162_.getInt("HomePosX");
        int $$2 = p_30162_.getInt("HomePosY");
        int $$3 = p_30162_.getInt("HomePosZ");
        this.setHomePos(new BlockPos($$1, $$2, $$3));
        super.readAdditionalSaveData(p_30162_);
        this.setHasEgg(p_30162_.getBoolean("HasEgg"));
        int $$4 = p_30162_.getInt("TravelPosX");
        int $$5 = p_30162_.getInt("TravelPosY");
        int $$6 = p_30162_.getInt("TravelPosZ");
        this.setTravelPos(new BlockPos($$4, $$5, $$6));
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_30153_, DifficultyInstance p_30154_, MobSpawnType p_30155_, @Nullable SpawnGroupData p_30156_, @Nullable CompoundTag p_30157_) {
        this.setHomePos(this.blockPosition());
        this.setTravelPos(BlockPos.ZERO);
        return super.finalizeSpawn(p_30153_, p_30154_, p_30155_, p_30156_, p_30157_);
    }



    protected void registerGoals() {
        this.goalSelector.addGoal(0, new Bubble.TurtlePanicGoal(this, 1.2));
        this.goalSelector.addGoal(1, new Bubble.TurtleBreedGoal(this, 1.0));
        this.goalSelector.addGoal(1, new Bubble.TurtleLayEggGoal(this, 1.0));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.2D, Ingredient.of(Blocks.DRIED_KELP_BLOCK), false));
        this.goalSelector.addGoal(3, new Bubble.TurtleGoToWaterGoal(this, 1.0));
        this.goalSelector.addGoal(4, new Bubble.TurtleGoHomeGoal(this, 1.0));
        this.goalSelector.addGoal(7, new Bubble.TurtleTravelGoal(this, 1.0));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(9, new Bubble.TurtleRandomStrollGoal(this, 1.0, 100));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 30.0).add(Attributes.MOVEMENT_SPEED, 0.25);
    }

    public boolean isPushedByFluid() {
        return false;
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    public MobType getMobType() {
        return MobType.WATER;
    }

    public int getAmbientSoundInterval() {
        return 200;
    }

    @Nullable
    protected SoundEvent getAmbientSound() {
        return !this.isInWater() && this.onGround() && !this.isBaby() ? SoundEvents.TURTLE_AMBIENT_LAND : super.getAmbientSound();
    }

    protected void playSwimSound(float p_30192_) {
        super.playSwimSound(p_30192_ * 1.5F);
    }

    protected SoundEvent getSwimSound() {
        return SoundEvents.TURTLE_SWIM;
    }

    @Nullable
    protected SoundEvent getHurtSound(DamageSource p_30202_) {
        return this.isBaby() ? SoundEvents.TURTLE_HURT_BABY : SoundEvents.TURTLE_HURT;
    }

    @Nullable
    protected SoundEvent getDeathSound() {
        return this.isBaby() ? SoundEvents.TURTLE_DEATH_BABY : SoundEvents.TURTLE_DEATH;
    }

    protected void playStepSound(BlockPos p_30173_, BlockState p_30174_) {
        SoundEvent $$2 = this.isBaby() ? SoundEvents.TURTLE_SHAMBLE_BABY : SoundEvents.TURTLE_SHAMBLE;
        this.playSound($$2, 0.15F, 1.0F);
    }

    public boolean canFallInLove() {
        return super.canFallInLove() && !this.hasEgg();
    }

    protected float nextStep() {
        return this.moveDist + 0.15F;
    }

    public float getScale() {
        return this.isBaby() ? 0.3F : 1.0F;
    }

    protected PathNavigation createNavigation(Level p_30171_) {
        return new Bubble.TurtlePathNavigation(this, p_30171_);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return OceanEntities.BUBLEA.get().create(pLevel);
    }

    public boolean isFood(ItemStack p_30231_) {
        return p_30231_.is(Blocks.SEAGRASS.asItem());
    }

    public float getWalkTargetValue(BlockPos p_30159_, LevelReader p_30160_) {
        if (!this.isGoingHome() && p_30160_.getFluidState(p_30159_).is(FluidTags.WATER)) {
            return 10.0F;
        } else {
            return BubbleEggBlock.onSand(p_30160_, p_30159_) ? 10.0F : p_30160_.getPathfindingCostFromLightLevels(p_30159_);
        }
    }

    public void aiStep() {
        super.aiStep();
        if (this.isAlive() && this.isLayingEgg() && this.layEggCounter >= 1 && this.layEggCounter % 5 == 0) {
            BlockPos $$0 = this.blockPosition();
            if (BubbleEggBlock.onSand(this.level(), $$0)) {
                this.level().levelEvent(2001, $$0, Block.getId(this.level().getBlockState($$0.below())));
            }
        }

    }

    protected void ageBoundaryReached() {
        super.ageBoundaryReached();
        if (!this.isBaby() && this.level().getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
            this.spawnAtLocation( ItemInit.Bubble_Turtle_Shield.get(), 1);
            this.spawnAtLocation( ItemInit.Bubble_Spike.get(), 1);
        }

    }

    public void travel(Vec3 p_30218_) {
        if (this.isControlledByLocalInstance() && this.isInWater()) {
            this.moveRelative(0.1F, p_30218_);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9));
            if (this.getTarget() == null && (!this.isGoingHome() || !this.getHomePos().closerToCenterThan(this.position(), 20.0))) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0, -0.005, 0.0));
            }
        } else {
            super.travel(p_30218_);
        }

    }

    public boolean canBeLeashed(Player p_30151_) {
        return false;
    }

    public void thunderHit(ServerLevel p_30140_, LightningBolt p_30141_) {
        this.hurt(this.damageSources().lightningBolt(), Float.MAX_VALUE);
    }

    static {
        HOME_POS = SynchedEntityData.defineId( Bubble.class, EntityDataSerializers.BLOCK_POS);
        HAS_EGG = SynchedEntityData.defineId( Bubble.class, EntityDataSerializers.BOOLEAN);
        LAYING_EGG = SynchedEntityData.defineId( Bubble.class, EntityDataSerializers.BOOLEAN);
        TRAVEL_POS = SynchedEntityData.defineId( Bubble.class, EntityDataSerializers.BLOCK_POS);
        GOING_HOME = SynchedEntityData.defineId( Bubble.class, EntityDataSerializers.BOOLEAN);
        TRAVELLING = SynchedEntityData.defineId( Bubble.class, EntityDataSerializers.BOOLEAN);
        FOOD_ITEMS = Ingredient.of(new ItemLike[]{Blocks.SEAGRASS.asItem()});
        BABY_ON_LAND_SELECTOR = (p_289447_) -> {
            return p_289447_.isBaby() && !p_289447_.isInWater();
        };
    }

    private static class TurtleMoveControl extends MoveControl {
        private final Bubble turtle;

        TurtleMoveControl(Bubble p_30286_) {
            super(p_30286_);
            this.turtle = p_30286_;
        }

        private void updateSpeed() {
            if (this.turtle.isInWater()) {
                this.turtle.setDeltaMovement(this.turtle.getDeltaMovement().add(0.0, 0.005, 0.0));
                if (!this.turtle.getHomePos().closerToCenterThan(this.turtle.position(), 16.0)) {
                    this.turtle.setSpeed(Math.max(this.turtle.getSpeed() / 2.0F, 0.08F));
                }

                if (this.turtle.isBaby()) {
                    this.turtle.setSpeed(Math.max(this.turtle.getSpeed() / 3.0F, 0.06F));
                }
            } else if (this.turtle.onGround()) {
                this.turtle.setSpeed(Math.max(this.turtle.getSpeed() / 2.0F, 0.06F));
            }

        }

        public void tick() {
            this.updateSpeed();
            if (this.operation == Operation.MOVE_TO && !this.turtle.getNavigation().isDone()) {
                double $$0 = this.wantedX - this.turtle.getX();
                double $$1 = this.wantedY - this.turtle.getY();
                double $$2 = this.wantedZ - this.turtle.getZ();
                double $$3 = Math.sqrt($$0 * $$0 + $$1 * $$1 + $$2 * $$2);
                if ($$3 < 9.999999747378752E-6) {
                    this.mob.setSpeed(0.0F);
                } else {
                    $$1 /= $$3;
                    float $$4 = (float)(Mth.atan2($$2, $$0) * 57.2957763671875) - 90.0F;
                    this.turtle.setYRot(this.rotlerp(this.turtle.getYRot(), $$4, 90.0F));
                    this.turtle.yBodyRot = this.turtle.getYRot();
                    float $$5 = (float)(this.speedModifier * this.turtle.getAttributeValue(Attributes.MOVEMENT_SPEED));
                    this.turtle.setSpeed(Mth.lerp(0.125F, this.turtle.getSpeed(), $$5));
                    this.turtle.setDeltaMovement(this.turtle.getDeltaMovement().add(0.0, (double)this.turtle.getSpeed() * $$1 * 0.1, 0.0));
                }
            } else {
                this.turtle.setSpeed(0.0F);
            }
        }
    }

    static class TurtlePanicGoal extends PanicGoal {
        TurtlePanicGoal(Bubble p_30290_, double p_30291_) {
            super(p_30290_, p_30291_);
        }

        public boolean canUse() {
            if (!this.shouldPanic()) {
                return false;
            } else {
                BlockPos $$0 = this.lookForWater(this.mob.level(), this.mob, 7);
                if ($$0 != null) {
                    this.posX = (double)$$0.getX();
                    this.posY = (double)$$0.getY();
                    this.posZ = (double)$$0.getZ();
                    return true;
                } else {
                    return this.findRandomPosition();
                }
            }
        }
    }

    private static class TurtleBreedGoal extends BreedGoal {
        private final Bubble turtle;

        TurtleBreedGoal(Bubble p_30244_, double p_30245_) {
            super(p_30244_, p_30245_);
            this.turtle = p_30244_;
        }

        public boolean canUse() {
            return super.canUse() && !this.turtle.hasEgg();
        }

        protected void breed() {
            ServerPlayer $$0 = this.animal.getLoveCause();
            if ($$0 == null && this.partner.getLoveCause() != null) {
                $$0 = this.partner.getLoveCause();
            }

            if ($$0 != null) {
                $$0.awardStat(Stats.ANIMALS_BRED);
                CriteriaTriggers.BRED_ANIMALS.trigger($$0, this.animal, this.partner, (AgeableMob)null);
            }

            this.turtle.setHasEgg(true);
            this.animal.setAge(6000);
            this.partner.setAge(6000);
            this.animal.resetLove();
            this.partner.resetLove();
            RandomSource $$1 = this.animal.getRandom();
            if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
                this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), $$1.nextInt(7) + 1));
            }

        }
    }

    static class TurtleLayEggGoal extends MoveToBlockGoal {
        private final Bubble turtle;

        TurtleLayEggGoal(Bubble p_30276_, double p_30277_) {
            super(p_30276_, p_30277_, 16);
            this.turtle = p_30276_;
        }

        public boolean canUse() {
            return this.turtle.hasEgg() && this.turtle.getHomePos().closerToCenterThan( this.turtle.position(), 9.0 ) && super.canUse();
        }

        public boolean canContinueToUse() {
            return super.canContinueToUse() && this.turtle.hasEgg() && this.turtle.getHomePos().closerToCenterThan(this.turtle.position(), 9.0);
        }

        public void tick() {
            super.tick();
            BlockPos $$0 = this.turtle.blockPosition();
            if (!this.turtle.isInWater() && this.isReachedTarget()) {
                if (this.turtle.layEggCounter < 1) {
                    this.turtle.setLayingEgg(true);
                } else if (this.turtle.layEggCounter > this.adjustedTickDelay(200)) {
                    Level $$1 = this.turtle.level();
                    $$1.playSound((Player)null, $$0, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + $$1.random.nextFloat() * 0.2F);
                    BlockPos $$2 = this.blockPos.above();
                    BlockState $$3 = (BlockState) BlockInit.BUBBLE_EGG_BLOCK.get().defaultBlockState().setValue( BubbleEggBlock.EGGS, this.turtle.random.nextInt(4) + 1);
                    $$1.setBlock($$2, $$3, 3);
                    $$1.gameEvent(GameEvent.BLOCK_PLACE, $$2, Context.of(this.turtle, $$3));
                    this.turtle.setHasEgg(false);
                    this.turtle.setLayingEgg(false);
                    this.turtle.setInLoveTime(600);
                }

                if (this.turtle.isLayingEgg()) {
                    ++this.turtle.layEggCounter;
                }
            }

        }

        protected boolean isValidTarget(LevelReader p_30280_, BlockPos p_30281_) {
            return p_30280_.isEmptyBlock( p_30281_.above() ) && BubbleEggBlock.isSand( p_30280_, p_30281_ );
        }
    }

    static class TurtleGoToWaterGoal extends MoveToBlockGoal {
        private static final int GIVE_UP_TICKS = 1200;
        private final Bubble turtle;

        TurtleGoToWaterGoal(Bubble p_30262_, double p_30263_) {
            super(p_30262_, p_30262_.isBaby() ? 2.0 : p_30263_, 24);
            this.turtle = p_30262_;
            this.verticalSearchStart = -1;
        }

        public boolean canContinueToUse() {
            return !this.turtle.isInWater() && this.tryTicks <= 1200 && this.isValidTarget(this.turtle.level(), this.blockPos);
        }

        public boolean canUse() {
            if (this.turtle.isBaby() && !this.turtle.isInWater()) {
                return super.canUse();
            } else {
                return !this.turtle.isGoingHome() && !this.turtle.isInWater() && !this.turtle.hasEgg() && super.canUse();
            }
        }

        public boolean shouldRecalculatePath() {
            return this.tryTicks % 160 == 0;
        }

        protected boolean isValidTarget(LevelReader p_30270_, BlockPos p_30271_) {
            return p_30270_.getBlockState(p_30271_).is(Blocks.WATER);
        }
    }

    static class TurtleGoHomeGoal extends Goal {
        private final Bubble turtle;
        private final double speedModifier;
        private boolean stuck;
        private int closeToHomeTryTicks;
        private static final int GIVE_UP_TICKS = 600;

        TurtleGoHomeGoal(Bubble p_30253_, double p_30254_) {
            this.turtle = p_30253_;
            this.speedModifier = p_30254_;
        }

        public boolean canUse() {
            if (this.turtle.isBaby()) {
                return false;
            } else if (this.turtle.hasEgg()) {
                return true;
            } else if (this.turtle.getRandom().nextInt(reducedTickDelay(700)) != 0) {
                return false;
            } else {
                return !this.turtle.getHomePos().closerToCenterThan(this.turtle.position(), 64.0);
            }
        }

        public void start() {
            this.turtle.setGoingHome(true);
            this.stuck = false;
            this.closeToHomeTryTicks = 0;
        }

        public void stop() {
            this.turtle.setGoingHome(false);
        }

        public boolean canContinueToUse() {
            return !this.turtle.getHomePos().closerToCenterThan(this.turtle.position(), 7.0) && !this.stuck && this.closeToHomeTryTicks <= this.adjustedTickDelay(600);
        }

        public void tick() {
            BlockPos $$0 = this.turtle.getHomePos();
            boolean $$1 = $$0.closerToCenterThan(this.turtle.position(), 16.0);
            if ($$1) {
                ++this.closeToHomeTryTicks;
            }

            if (this.turtle.getNavigation().isDone()) {
                Vec3 $$2 = Vec3.atBottomCenterOf($$0);
                Vec3 $$3 = DefaultRandomPos.getPosTowards(this.turtle, 16, 3, $$2, 0.3141592741012573);
                if ($$3 == null) {
                    $$3 = DefaultRandomPos.getPosTowards(this.turtle, 8, 7, $$2, 1.5707963705062866);
                }

                if ($$3 != null && !$$1 && !this.turtle.level().getBlockState(BlockPos.containing($$3)).is(Blocks.WATER)) {
                    $$3 = DefaultRandomPos.getPosTowards(this.turtle, 16, 5, $$2, 1.5707963705062866);
                }

                if ($$3 == null) {
                    this.stuck = true;
                    return;
                }

                this.turtle.getNavigation().moveTo($$3.x, $$3.y, $$3.z, this.speedModifier);
            }

        }
    }

    static class TurtleTravelGoal extends Goal {
        private final Bubble turtle;
        private final double speedModifier;
        private boolean stuck;

        TurtleTravelGoal(Bubble p_30333_, double p_30334_) {
            this.turtle = p_30333_;
            this.speedModifier = p_30334_;
        }

        public boolean canUse() {
            return !this.turtle.isGoingHome() && !this.turtle.hasEgg() && this.turtle.isInWater();
        }

        public void start() {
            boolean $$0 = true;
            boolean $$1 = true;
            RandomSource $$2 = this.turtle.random;
            int $$3 = $$2.nextInt(1025) - 512;
            int $$4 = $$2.nextInt(9) - 4;
            int $$5 = $$2.nextInt(1025) - 512;
            if ((double)$$4 + this.turtle.getY() > (double)(this.turtle.level().getSeaLevel() - 1)) {
                $$4 = 0;
            }

            BlockPos $$6 = BlockPos.containing((double)$$3 + this.turtle.getX(), (double)$$4 + this.turtle.getY(), (double)$$5 + this.turtle.getZ());
            this.turtle.setTravelPos($$6);
            this.turtle.setTravelling(true);
            this.stuck = false;
        }

        public void tick() {
            if (this.turtle.getNavigation().isDone()) {
                Vec3 $$0 = Vec3.atBottomCenterOf(this.turtle.getTravelPos());
                Vec3 $$1 = DefaultRandomPos.getPosTowards(this.turtle, 16, 3, $$0, 0.3141592741012573);
                if ($$1 == null) {
                    $$1 = DefaultRandomPos.getPosTowards(this.turtle, 8, 7, $$0, 1.5707963705062866);
                }

                if ($$1 != null) {
                    int $$2 = Mth.floor($$1.x);
                    int $$3 = Mth.floor($$1.z);
                    boolean $$4 = true;
                    if (!this.turtle.level().hasChunksAt($$2 - 34, $$3 - 34, $$2 + 34, $$3 + 34)) {
                        $$1 = null;
                    }
                }

                if ($$1 == null) {
                    this.stuck = true;
                    return;
                }

                this.turtle.getNavigation().moveTo($$1.x, $$1.y, $$1.z, this.speedModifier);
            }

        }

        public boolean canContinueToUse() {
            return !this.turtle.getNavigation().isDone() && !this.stuck && !this.turtle.isGoingHome() && !this.turtle.isInLove() && !this.turtle.hasEgg();
        }

        public void stop() {
            this.turtle.setTravelling(false);
            super.stop();
        }
    }

    private static class TurtleRandomStrollGoal extends RandomStrollGoal {
        private final Bubble turtle;

        TurtleRandomStrollGoal(Bubble p_30303_, double p_30304_, int p_30305_) {
            super(p_30303_, p_30304_, p_30305_);
            this.turtle = p_30303_;
        }

        public boolean canUse() {
            return !this.mob.isInWater() && !this.turtle.isGoingHome() && !this.turtle.hasEgg() && super.canUse();
        }
    }

    private static class TurtlePathNavigation extends AmphibiousPathNavigation {
        TurtlePathNavigation(Bubble p_30294_, Level p_30295_) {
            super(p_30294_, p_30295_);
        }

        public boolean isStableDestination(BlockPos p_30300_) {
            Mob var3 = this.mob;
            if (var3 instanceof Turtle $$1) {
                if ($$1.isFreezing()) {
                    return this.level.getBlockState(p_30300_).is(Blocks.WATER);
                }
            }

            return !this.level.getBlockState(p_30300_.below()).isAir();
        }
    }

    public InteractionResult mobInteract(Player p_29489_, InteractionHand p_29490_) {
        boolean flag = this.isFood(p_29489_.getItemInHand(p_29490_));
        if (!flag && this.isSaddled() && !this.isVehicle() && !p_29489_.isSecondaryUseActive()) {
            if (!this.level().isClientSide) {
                p_29489_.startRiding(this);

            }

            return InteractionResult.sidedSuccess(this.level().isClientSide);
        } else {
            InteractionResult interactionresult = super.mobInteract(p_29489_, p_29490_);
            if (!interactionresult.consumesAction()) {
                ItemStack itemstack = p_29489_.getItemInHand(p_29490_);
                return itemstack.is(Items.SADDLE) ? itemstack.interactLivingEntity(p_29489_, this, p_29490_) : InteractionResult.PASS;

            } else {
                return interactionresult;

            }

        }

    }

    private boolean isSaddled() {  return this.isAlive() && !this.isBaby();
    }

    @Nullable
    public LivingEntity getControllingPassenger() {
        if (this.isSaddled()) {
            Entity entity = this.getFirstPassenger();
            if (entity instanceof Player) {
                Player player = (Player)entity;
                if (player.getMainHandItem().is(Items.CARROT_ON_A_STICK) || player.getOffhandItem().is(Items.CARROT_ON_A_STICK)) {
                    return player;
                }
            }
        }

        return null;
    }
    public Vec3 getDismountLocationForPassenger(LivingEntity p_29487_) {
        Direction direction = this.getMotionDirection();
        if (direction.getAxis() == Direction.Axis.Y) {
            return super.getDismountLocationForPassenger(p_29487_);
        } else {
            int[][] aint = DismountHelper.offsetsForDirection(direction);
            BlockPos blockpos = this.blockPosition();
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
            UnmodifiableIterator var6 = p_29487_.getDismountPoses().iterator();

            while(var6.hasNext()) {
                Pose pose = (Pose)var6.next();
                AABB aabb = p_29487_.getLocalBoundsForPose(pose);
                int[][] var9 = aint;
                int var10 = aint.length;

                for(int var11 = 0; var11 < var10; ++var11) {
                    int[] aint1 = var9[var11];
                    blockpos$mutableblockpos.set(blockpos.getX() + aint1[0], blockpos.getY(), blockpos.getZ() + aint1[1]);
                    double d0 = this.level().getBlockFloorHeight(blockpos$mutableblockpos);
                    if (DismountHelper.isBlockFloorValid(d0)) {
                        Vec3 vec3 = Vec3.upFromBottomCenterOf(blockpos$mutableblockpos, d0);
                        if (DismountHelper.canDismountTo(this.level(), p_29487_, aabb.move(vec3))) {
                            p_29487_.setPose(pose);
                            return vec3;
                        }
                    }
                }
            }

            return super.getDismountLocationForPassenger(p_29487_);
        }
    }

    protected void tickRidden(Player p_278330_, Vec3 p_278267_) {
        super.tickRidden(p_278330_, p_278267_);
        this.setRot(p_278330_.getYRot(), p_278330_.getXRot() * 0.5F);
        this.yRotO = this.yBodyRot = this.yHeadRot = this.getYRot();

    }

    protected Vec3 getRiddenInput(Player p_278309_, Vec3 p_275479_) {
        return new Vec3(0.0, 0.0, 1.0);

    }



}