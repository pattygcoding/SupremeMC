package net.pattygcoding.suprememc.recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.pattygcoding.suprememc.init.SMCBlocks;
import net.pattygcoding.suprememc.init.SMCRecipes;
import org.jetbrains.annotations.NotNull;

public class FreezingRecipe extends AbstractFreezingRecipe {
    public FreezingRecipe(String pGroup, CookingBookCategory pCategory, Ingredient pIngredient, ItemStack pResult, float pExperience, int pCookingTime) {
        super(Type.INSTANCE, pGroup, pCategory, pIngredient, pResult, pExperience, pCookingTime);
    }

    public @NotNull ItemStack getToastSymbol() {
        return new ItemStack(SMCBlocks.FREEZER.get());
    }

    public @NotNull RecipeSerializer<?> getSerializer() {
        return SMCRecipes.FREEZING_SERIALIZER.get();
    }

    public static class Type implements RecipeType<FreezingRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "freezing";
    }
}
