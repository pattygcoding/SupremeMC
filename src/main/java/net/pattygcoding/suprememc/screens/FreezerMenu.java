package net.pattygcoding.suprememc.screens;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeBookType;
import net.pattygcoding.suprememc.init.SMCMenus;
import net.pattygcoding.suprememc.init.SMCRecipes;
import net.pattygcoding.suprememc.recipes.FreezingRecipe;

public class FreezerMenu extends AbstractFreezerMenu {
    public FreezerMenu(int pContainerId, Inventory pPlayerInventory, FriendlyByteBuf friendlyByteBuf) {
        super(SMCMenus.FREEZER_MENU.get(), FreezingRecipe.Type.INSTANCE, RecipeBookType.FURNACE, pContainerId, pPlayerInventory);
    }

    public FreezerMenu(int pContainerId, Inventory pPlayerInventory, Container pFurnaceContainer, ContainerData pFurnaceData) {
        super(SMCMenus.FREEZER_MENU.get(), FreezingRecipe.Type.INSTANCE, RecipeBookType.FURNACE, pContainerId, pPlayerInventory, pFurnaceContainer, pFurnaceData);
    }
}

