package net.pattygcoding.suprememc.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.event.ForgeEventFactory;
import net.pattygcoding.suprememc.entity.ai.SnowCreeperSwellGoal;
import net.pattygcoding.suprememc.events.explosions.SnowCreeperExplosion;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Collection;

public class SnowCreeperEntity extends Monster implements PowerableMob {
    private static final EntityDataAccessor<Integer> DATA_SWELL_DIR;
    private static final EntityDataAccessor<Boolean> DATA_IS_POWERED;
    private static final EntityDataAccessor<Boolean> DATA_IS_IGNITED;
    private int oldSwell;
    private int swell;
    private int maxSwell = 30;
    private int explosionRadius = 3;
    private int droppedSkulls;

    public SnowCreeperEntity(EntityType<? extends SnowCreeperEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new SnowCreeperSwellGoal(this));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, Ocelot.class, 6.0F, 1.0, 1.2));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, Cat.class, 6.0F, 1.0, 1.2));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0, false));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this, new Class[0]));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, 0.25);
    }

    public int getMaxFallDistance() {
        return this.getTarget() == null ? 3 : 3 + (int)(this.getHealth() - 1.0F);
    }

    public boolean causeFallDamage(float pFallDistance, float pMultiplier, @NotNull DamageSource pSource) {
        boolean $$3 = super.causeFallDamage(pFallDistance, pMultiplier, pSource);
        this.swell += (int)(pFallDistance * 1.5F);
        if (this.swell > this.maxSwell - 5) {
            this.swell = this.maxSwell - 5;
        }

        return $$3;
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_SWELL_DIR, -1);
        this.entityData.define(DATA_IS_POWERED, false);
        this.entityData.define(DATA_IS_IGNITED, false);
    }

    public void addAdditionalSaveData(@NotNull CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        if (this.entityData.get(DATA_IS_POWERED)) {
            pCompound.putBoolean("powered", true);
        }

        pCompound.putShort("Fuse", (short)this.maxSwell);
        pCompound.putByte("ExplosionRadius", (byte)this.explosionRadius);
        pCompound.putBoolean("ignited", this.isIgnited());
    }

    public void readAdditionalSaveData(@NotNull CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.entityData.set(DATA_IS_POWERED, pCompound.getBoolean("powered"));
        if (pCompound.contains("Fuse", 99)) {
            this.maxSwell = pCompound.getShort("Fuse");
        }

        if (pCompound.contains("ExplosionRadius", 99)) {
            this.explosionRadius = pCompound.getByte("ExplosionRadius");
        }

        if (pCompound.getBoolean("ignited")) {
            this.ignite();
        }

    }

    public void tick() {
        if (this.isAlive()) {
            this.oldSwell = this.swell;
            if (this.isIgnited()) {
                this.setSwellDir(1);
            }

            int $$0 = this.getSwellDir();
            if ($$0 > 0 && this.swell == 0) {
                this.playSound(SoundEvents.CREEPER_PRIMED, 1.0F, 0.5F);
                this.gameEvent(GameEvent.PRIME_FUSE);
            }

            this.swell += $$0;
            if (this.swell < 0) {
                this.swell = 0;
            }

            if (this.swell >= this.maxSwell) {
                this.swell = this.maxSwell;
                this.explodeCreeper();
            }
        }

        super.tick();
    }

    public void setTarget(@Nullable LivingEntity pTarget) {
        if (!(pTarget instanceof Goat)) {
            super.setTarget(pTarget);
        }
    }

    protected SoundEvent getHurtSound(@NotNull DamageSource pDamageSource) {
        return SoundEvents.CREEPER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.CREEPER_DEATH;
    }

    protected void dropCustomDeathLoot(@NotNull DamageSource pSource, int pLooting, boolean pRecentlyHit) {
        super.dropCustomDeathLoot(pSource, pLooting, pRecentlyHit);
        Entity $$3 = pSource.getEntity();
        if ($$3 != this && $$3 instanceof SnowCreeperEntity $$4) {
            if ($$4.canDropMobsSkull()) {
                $$4.increaseDroppedSkulls();
                this.spawnAtLocation(Items.CREEPER_HEAD);
            }
        }

    }

    public boolean doHurtTarget(@NotNull Entity pEntity) {
        return true;
    }

    public boolean isPowered() {
        return (Boolean)this.entityData.get(DATA_IS_POWERED);
    }

    public float getSwelling(float pPartialTicks) {
        return Mth.lerp(pPartialTicks, (float)this.oldSwell, (float)this.swell) / (float)(this.maxSwell - 2);
    }

    public int getSwellDir() {
        return (Integer)this.entityData.get(DATA_SWELL_DIR);
    }

    public void setSwellDir(int pState) {
        this.entityData.set(DATA_SWELL_DIR, pState);
    }

    public void thunderHit(@NotNull ServerLevel pLevel, @NotNull LightningBolt pLightning) {
        super.thunderHit(pLevel, pLightning);
        this.entityData.set(DATA_IS_POWERED, true);
    }

    protected @NotNull InteractionResult mobInteract(Player pPlayer, @NotNull InteractionHand pHand) {
        ItemStack $$2 = pPlayer.getItemInHand(pHand);
        if ($$2.is(ItemTags.CREEPER_IGNITERS)) {
            SoundEvent $$3 = $$2.is(Items.FIRE_CHARGE) ? SoundEvents.FIRECHARGE_USE : SoundEvents.FLINTANDSTEEL_USE;
            this.level().playSound(pPlayer, this.getX(), this.getY(), this.getZ(), $$3, this.getSoundSource(), 1.0F, this.random.nextFloat() * 0.4F + 0.8F);
            if (!this.level().isClientSide) {
                this.ignite();
                if (!$$2.isDamageableItem()) {
                    $$2.shrink(1);
                } else {
                    $$2.hurtAndBreak(1, pPlayer, (p_32290_) -> {
                        p_32290_.broadcastBreakEvent(pHand);
                    });
                }
            }

            return InteractionResult.sidedSuccess(this.level().isClientSide);
        } else {
            return super.mobInteract(pPlayer, pHand);
        }
    }

    private void explodeCreeper() {
        if (!this.level().isClientSide) {
            float $$0 = this.isPowered() ? 2.0F : 1.0F;
            this.dead = true;
            this.explode(this, this.getX(), this.getY(), this.getZ(), (float)this.explosionRadius * $$0, true, true);
            this.discard();
            this.spawnLingeringCloud();
        }
    }



    public SnowCreeperExplosion explode(@Nullable Entity pSource, double pX, double pY, double pZ, float pRadius, boolean pFire, boolean pSpawnParticles) {
        SnowCreeperExplosion.BlockInteraction explosion$blockinteraction1 = ForgeEventFactory.getMobGriefingEvent(this.level(), pSource) ? this.getDestroyType() : SnowCreeperExplosion.BlockInteraction.KEEP;;


        SnowCreeperExplosion explosion = new SnowCreeperExplosion(this.level(), pSource, null, pX, pY, pZ, pRadius, pFire, explosion$blockinteraction1);
        if (!ForgeEventFactory.onExplosionStart(this.level(), explosion)) {
            explosion.explode();
            explosion.finalizeExplosion(pSpawnParticles);
        }
        return explosion;
    }

    private Explosion.BlockInteraction getDestroyType() {
        return this.level().getGameRules().getBoolean(GameRules.RULE_MOB_EXPLOSION_DROP_DECAY) ? SnowCreeperExplosion.BlockInteraction.DESTROY_WITH_DECAY : SnowCreeperExplosion.BlockInteraction.DESTROY;
    }

    private void spawnLingeringCloud() {
        Collection<MobEffectInstance> $$0 = this.getActiveEffects();
        if (!$$0.isEmpty()) {
            AreaEffectCloud $$1 = new AreaEffectCloud(this.level(), this.getX(), this.getY(), this.getZ());
            $$1.setRadius(2.5F);
            $$1.setRadiusOnUse(-0.5F);
            $$1.setWaitTime(10);
            $$1.setDuration($$1.getDuration() / 2);
            $$1.setRadiusPerTick(-$$1.getRadius() / (float)$$1.getDuration());

            for (MobEffectInstance $$2 : $$0) {
                $$1.addEffect(new MobEffectInstance($$2));
            }

            this.level().addFreshEntity($$1);
        }

    }

    public boolean isIgnited() {
        return (Boolean)this.entityData.get(DATA_IS_IGNITED);
    }

    public void ignite() {
        this.entityData.set(DATA_IS_IGNITED, true);
    }

    public boolean canDropMobsSkull() {
        return this.isPowered() && this.droppedSkulls < 1;
    }

    public void increaseDroppedSkulls() {
        ++this.droppedSkulls;
    }

    static {
        DATA_SWELL_DIR = SynchedEntityData.defineId(SnowCreeperEntity.class, EntityDataSerializers.INT);
        DATA_IS_POWERED = SynchedEntityData.defineId(SnowCreeperEntity.class, EntityDataSerializers.BOOLEAN);
        DATA_IS_IGNITED = SynchedEntityData.defineId(SnowCreeperEntity.class, EntityDataSerializers.BOOLEAN);
    }
}
