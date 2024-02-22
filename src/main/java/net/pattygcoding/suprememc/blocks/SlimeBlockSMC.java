package net.pattygcoding.suprememc.blocks;

import com.google.common.collect.ImmutableList;
import net.pattygcoding.suprememc.init.SMCBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class SlimeBlockSMC extends HalfTransparentBlock {
    public SlimeBlockSMC(DyeColor color)
    {
        super(BlockBehaviour.Properties.copy(Blocks.SLIME_BLOCK).mapColor(color).sound(SoundType.SLIME_BLOCK));
    }


    @Override
    public boolean isSlimeBlock(BlockState state)
    {
        return true;
    }

    @Override
    public boolean isStickyBlock(BlockState state) {
        return true;
    }

    @Override
    public boolean canStickTo(BlockState state, BlockState other)
    {
        if (state.getBlock() == this)
        {
            ImmutableList<Block> slimeBlocks = ImmutableList.of
                    (
                            SMCBlocks.RED_SLIME_BLOCK.get(), SMCBlocks.ORANGE_SLIME_BLOCK.get(), SMCBlocks.YELLOW_SLIME_BLOCK.get(), SMCBlocks.LIME_SLIME_BLOCK.get(),
                            SMCBlocks.GREEN_SLIME_BLOCK.get(), SMCBlocks.LIGHT_BLUE_SLIME_BLOCK.get(), SMCBlocks.CYAN_SLIME_BLOCK.get(), SMCBlocks.BLUE_SLIME_BLOCK.get(),
                            SMCBlocks.PURPLE_SLIME_BLOCK.get(), SMCBlocks.MAGENTA_SLIME_BLOCK.get(), SMCBlocks.PINK_SLIME_BLOCK.get(), SMCBlocks.WHITE_SLIME_BLOCK.get(),
                            SMCBlocks.LIGHT_GRAY_SLIME_BLOCK.get(), SMCBlocks.GRAY_SLIME_BLOCK.get(), SMCBlocks.BLACK_SLIME_BLOCK.get(), SMCBlocks.BROWN_SLIME_BLOCK.get(),
                            Blocks.SLIME_BLOCK, Blocks.HONEY_BLOCK
                    );
            for(Block block : slimeBlocks)
            {
                if(block != this && block == other.getBlock()) return false;
            }
        }
        return state.isStickyBlock() || other.isStickyBlock();
    }

    @Override
    public void fallOn(Level pLevel, BlockState pState, BlockPos pPos, Entity pEntity, float pFallDistance) {
        if (pEntity.isSuppressingBounce()) {
            super.fallOn(pLevel, pState, pPos, pEntity, pFallDistance);
        } else {
            pEntity.causeFallDamage(pFallDistance, 0.0F, pLevel.damageSources().fall());
        }

    }

    @Override
    public void updateEntityAfterFallOn(BlockGetter pLevel, Entity pEntity) {
        if (pEntity.isSuppressingBounce()) {
            super.updateEntityAfterFallOn(pLevel, pEntity);
        } else {
            this.bounceUp(pEntity);
        }

    }

    private void bounceUp(Entity pEntity) {
        Vec3 $$1 = pEntity.getDeltaMovement();
        if ($$1.y < 0.0) {
            double $$2 = pEntity instanceof LivingEntity ? 1.0 : 0.8;
            pEntity.setDeltaMovement($$1.x, -$$1.y * $$2, $$1.z);
        }

    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        double $$4 = Math.abs(pEntity.getDeltaMovement().y);
        if ($$4 < 0.1 && !pEntity.isSteppingCarefully()) {
            double $$5 = 0.4 + $$4 * 0.2;
            pEntity.setDeltaMovement(pEntity.getDeltaMovement().multiply($$5, 1.0, $$5));
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }



}
