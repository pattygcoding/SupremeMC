package net.pattygcoding.suprememc.events.explosions;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.ProtectionEnchantment;
import net.minecraft.world.level.EntityBasedExplosionDamageCalculator;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class SnowCreeperExplosion extends Explosion
{
    private static final ExplosionDamageCalculator EXPLOSION_DAMAGE_CALCULATOR = new ExplosionDamageCalculator();
    private final double x;
    private final double y;
    private final double z;
    private final Level level;
    private final float radius;
    private final ObjectArrayList<BlockPos> toBlow;
    private final BlockInteraction blockInteraction;
    private final boolean fire;
    @Nullable
    private final Entity source;
    private final Map<Player, Vec3> hitPlayers;
    private final ExplosionDamageCalculator damageCalculator;

    public SnowCreeperExplosion(Level pLevel, @Nullable Entity pSource, @Nullable ExplosionDamageCalculator pDamageCalculator, double pToBlowX, double pToBlowY, double pToBlowZ, float pRadius, boolean pFire, BlockInteraction pBlockInteraction) {

        super(pLevel, pSource, pToBlowX, pToBlowY, pToBlowZ, pRadius, pFire, pBlockInteraction);
        this.x = pToBlowX;
        this.y = pToBlowY;
        this.z = pToBlowZ;
        this.level = pLevel;
        this.radius = pRadius;
        this.toBlow = new ObjectArrayList<>();
        this.blockInteraction = pBlockInteraction;
        this.fire = pFire;
        this.source = pSource;
        this.hitPlayers = Maps.newHashMap();
        this.damageCalculator = pDamageCalculator == null ? this.makeDamageCalculator(pSource) : pDamageCalculator;

    }

    @Override
    public void explode() {
        this.level.gameEvent(this.source, GameEvent.EXPLODE, new Vec3(this.x, this.y, this.z));
        Set<BlockPos> set = Sets.newHashSet();

        int k;
        int l;
        for(int j = 0; j < 16; ++j) {
            for(k = 0; k < 16; ++k) {
                for(l = 0; l < 16; ++l) {
                    if (j == 0 || j == 15 || k == 0 || k == 15 || l == 0 || l == 15) {
                        double d0 = (double)((float)j / 15.0F * 2.0F - 1.0F);
                        double d1 = (double)((float)k / 15.0F * 2.0F - 1.0F);
                        double d2 = (double)((float)l / 15.0F * 2.0F - 1.0F);
                        double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                        d0 /= d3;
                        d1 /= d3;
                        d2 /= d3;
                        float f = this.radius * (0.7F + this.level.random.nextFloat() * 0.6F);
                        double d4 = this.x;
                        double d6 = this.y;
                        double d8 = this.z;

                        for(; f > 0.0F; f -= 0.22500001F) {
                            BlockPos blockpos = BlockPos.containing(d4, d6, d8);
                            BlockState blockstate = this.level.getBlockState(blockpos);
                            FluidState fluidstate = this.level.getFluidState(blockpos);
                            if (!this.level.isInWorldBounds(blockpos)) {
                                break;
                            }

                            Optional<Float> optional = this.damageCalculator.getBlockExplosionResistance(this, this.level, blockpos, blockstate, fluidstate);
                            if (optional.isPresent()) {
                                f -= ((Float)optional.get() + 0.3F) * 0.3F;
                            }

                            if (f > 0.0F && this.damageCalculator.shouldBlockExplode(this, this.level, blockpos, blockstate, f)) {
                                set.add(blockpos);
                            }

                            d4 += d0 * 0.30000001192092896;
                            d6 += d1 * 0.30000001192092896;
                            d8 += d2 * 0.30000001192092896;
                        }
                    }
                }
            }
        }

        this.toBlow.addAll(set);
        float f2 = this.radius * 2.0F;
        k = Mth.floor(this.x - (double)f2 - 1.0);
        l = Mth.floor(this.x + (double)f2 + 1.0);
        int i2 = Mth.floor(this.y - (double)f2 - 1.0);
        int i1 = Mth.floor(this.y + (double)f2 + 1.0);
        int j2 = Mth.floor(this.z - (double)f2 - 1.0);
        int j1 = Mth.floor(this.z + (double)f2 + 1.0);
        List<Entity> list = this.level.getEntities(this.source, new AABB((double)k, (double)i2, (double)j2, (double)l, (double)i1, (double)j1));
        ForgeEventFactory.onExplosionDetonate(this.level, this, list, (double)f2);
        Vec3 vec3 = new Vec3(this.x, this.y, this.z);
        Iterator<Entity> var36 = list.iterator();

        while(true) {
            Player player;
            Vec3 vec31;
            do {
                do {
                    Entity entity;
                    do {
                        double d5;
                        double d7;
                        double d9;
                        double d12;
                        double d13;
                        do {
                            do {
                                do {
                                    if (!var36.hasNext()) {
                                        return;
                                    }

                                    entity = (Entity)var36.next();
                                } while(entity.ignoreExplosion());

                                d12 = Math.sqrt(entity.distanceToSqr(vec3)) / (double)f2;
                            } while(!(d12 <= 1.0));

                            d5 = entity.getX() - this.x;
                            d7 = (entity instanceof PrimedTnt ? entity.getY() : entity.getEyeY()) - this.y;
                            d9 = entity.getZ() - this.z;
                            d13 = Math.sqrt(d5 * d5 + d7 * d7 + d9 * d9);
                        } while(d13 == 0.0);

                        d5 /= d13;
                        d7 /= d13;
                        d9 /= d13;
                        double d14 = (double)getSeenPercent(vec3, entity);
                        double d10 = (1.0 - d12) * d14;
                        entity.hurt(this.getDamageSource(), (float)((int)((d10 * d10 + d10) / 2.0 * 7.0 * (double)f2 + 1.0)));
                        double d11;
                        if (entity instanceof LivingEntity livingentity) {
                            d11 = ProtectionEnchantment.getExplosionKnockbackAfterDampener(livingentity, d10);
                        } else {
                            d11 = d10;
                        }

                        d5 *= d11;
                        d7 *= d11;
                        d9 *= d11;
                        vec31 = new Vec3(d5, d7, d9);
                        entity.setDeltaMovement(entity.getDeltaMovement().add(vec31));
                    } while(!(entity instanceof Player));

                    player = (Player)entity;
                } while(player.isSpectator());
            } while(player.isCreative() && player.getAbilities().flying);

            this.hitPlayers.put(player, vec31);
        }
    }

    @Override
    public void finalizeExplosion(boolean pSpawnParticles) {
        if (this.level.isClientSide) {
            this.level.playLocalSound(this.x, this.y, this.z, SoundEvents.GENERIC_EXPLODE, SoundSource.BLOCKS, 4.0F, (1.0F + (this.level.random.nextFloat() - this.level.random.nextFloat()) * 0.2F) * 0.7F, false);
        }

        boolean flag = this.interactsWithBlocks();
        if (pSpawnParticles) {
            if (!(this.radius < 2.0F) && flag) {
                this.level.addParticle(ParticleTypes.EXPLOSION_EMITTER, this.x, this.y, this.z, 1.0, 0.0, 0.0);
            } else {
                this.level.addParticle(ParticleTypes.EXPLOSION, this.x, this.y, this.z, 1.0, 0.0, 0.0);
            }
        }

        if (flag) {
            ObjectArrayList<Pair<ItemStack, BlockPos>> objectarraylist = new ObjectArrayList<>();
            boolean flag1 = this.getIndirectSourceEntity() instanceof Player;
            Util.shuffle(this.toBlow, this.level.random);
            ObjectListIterator var5 = this.toBlow.iterator();

            while(var5.hasNext()) {
                BlockPos blockpos = (BlockPos)var5.next();
                BlockState blockstate = this.level.getBlockState(blockpos);
                net.minecraft.world.level.block.Block block = blockstate.getBlock();
                if (!blockstate.isAir()) {
                    BlockPos blockpos1 = blockpos.immutable();
                    this.level.getProfiler().push("explosion_blocks");
                    if (blockstate.canDropFromExplosion(this.level, blockpos, this)) {
                        if (this.level instanceof ServerLevel serverlevel) {
                            BlockEntity blockentity = blockstate.hasBlockEntity() ? this.level.getBlockEntity(blockpos) : null;
                            LootParams.Builder lootparams$builder = (new LootParams.Builder(serverlevel)).withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(blockpos)).withParameter(LootContextParams.TOOL, ItemStack.EMPTY).withOptionalParameter(LootContextParams.BLOCK_ENTITY, blockentity).withOptionalParameter(LootContextParams.THIS_ENTITY, this.source);
                            if (this.blockInteraction == SnowCreeperExplosion.BlockInteraction.DESTROY_WITH_DECAY) {
                                lootparams$builder.withParameter(LootContextParams.EXPLOSION_RADIUS, this.radius);
                            }

                            blockstate.spawnAfterBreak(serverlevel, blockpos, ItemStack.EMPTY, flag1);
                            blockstate.getDrops(lootparams$builder).forEach((p_46074_) -> {
                                addBlockDrops(objectarraylist, p_46074_, blockpos1);
                            });
                        }
                    }

                    blockstate.onBlockExploded(this.level, blockpos, this);
                    this.level.getProfiler().pop();
                }
            }

            var5 = objectarraylist.iterator();

            while(var5.hasNext()) {
                Pair pair = (Pair)var5.next();
                net.minecraft.world.level.block.Block.popResource(this.level, (BlockPos)pair.getSecond(), (ItemStack)pair.getFirst());
            }
        }

        if (this.fire) {

            for (BlockPos blockpos2 : this.toBlow) {
                if (this.level.getBlockState(blockpos2).isAir()) {
                    this.level.setBlockAndUpdate(blockpos2, Blocks.POWDER_SNOW.defaultBlockState());
                }
            }
        }
    }

    private static void addBlockDrops(ObjectArrayList<Pair<ItemStack, BlockPos>> pDropPositionArray, ItemStack pStack, BlockPos pPos) {
        int i = pDropPositionArray.size();

        for(int j = 0; j < i; ++j) {
            Pair pair = pDropPositionArray.get(j);
            ItemStack itemstack = (ItemStack)pair.getFirst();
            if (ItemEntity.areMergable(itemstack, pStack)) {
                ItemStack itemstack1 = ItemEntity.merge(itemstack, pStack, 16);
                pDropPositionArray.set(j, Pair.of(itemstack1, (BlockPos)pair.getSecond()));
                if (pStack.isEmpty()) {
                    return;
                }
            }
        }

        pDropPositionArray.add(Pair.of(pStack, pPos));
    }

    private ExplosionDamageCalculator makeDamageCalculator(@javax.annotation.Nullable Entity pEntity) {
        return pEntity == null ? EXPLOSION_DAMAGE_CALCULATOR : new EntityBasedExplosionDamageCalculator(pEntity);
    }

    @Nullable @Override
    public Entity getDirectSourceEntity() {
        return this.source;
    }

    @Override
    public void clearToBlow() {
        this.toBlow.clear();
    }

    @Override
    public List<BlockPos> getToBlow() {
        return this.toBlow;
    }

    @Nullable @Override
    public Entity getExploder() {
        return this.source;
    }

}
