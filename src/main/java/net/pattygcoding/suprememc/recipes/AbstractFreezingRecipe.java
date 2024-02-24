//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.pattygcoding.suprememc.recipes;

import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractFreezingRecipe implements Recipe<Container> {
    protected final RecipeType<?> type;
    protected final CookingBookCategory category;
    protected final String group;
    protected final Ingredient ingredient;
    protected final ItemStack result;
    protected final float experience;
    protected final int cookingTime;

    public AbstractFreezingRecipe(RecipeType<?> pType, String pGroup, CookingBookCategory pCategory, Ingredient pIngredient, ItemStack pResult, float pExperience, int pCookingTime) {
        this.type = pType;
        this.category = pCategory;
        this.group = pGroup;
        this.ingredient = pIngredient;
        this.result = pResult;
        this.experience = pExperience;
        this.cookingTime = pCookingTime;
    }

    public boolean matches(Container pInv, @NotNull Level pLevel) {
        return this.ingredient.test(pInv.getItem(0));
    }

    public @NotNull ItemStack assemble(@NotNull Container pContainer, @NotNull RegistryAccess pRegistryAccess) {
        return this.result.copy();
    }

    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    public @NotNull NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> $$0 = NonNullList.create();
        $$0.add(this.ingredient);
        return $$0;
    }

    public float getExperience() {
        return this.experience;
    }

    public @NotNull ItemStack getResultItem(@NotNull RegistryAccess pRegistryAccess) {
        return this.result;
    }

    public @NotNull String getGroup() {
        return this.group;
    }

    public int getCookingTime() {
        return this.cookingTime;
    }

    public @NotNull RecipeType<?> getType() {
        return this.type;
    }

    public CookingBookCategory category() {
        return this.category;
    }
}
