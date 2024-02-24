package net.pattygcoding.suprememc.blocks.freezer;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.FurnaceMenu;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.pattygcoding.suprememc.screens.FreezerMenu;
import org.jetbrains.annotations.NotNull;

public class FreezerBlockEntity extends AbstractFurnaceBlockEntity {
    public FreezerBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityType.FURNACE, pPos, pBlockState, RecipeType.SMELTING);
    }

    protected @NotNull Component getDefaultName() {
        return Component.translatable("container.suprememc.freezer");
    }

    protected @NotNull AbstractContainerMenu createMenu(int pId, Inventory pPlayer) {
        return new FreezerMenu(pId, pPlayer, this, this.dataAccess);
    }
}
