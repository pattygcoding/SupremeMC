//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.pattygcoding.suprememc.blocks.freezer;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import net.minecraft.SharedConstants;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeCraftingHolder;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;
import net.pattygcoding.suprememc.recipes.AbstractFreezingRecipe;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractFreezerBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer, RecipeCraftingHolder, StackedContentsCompatible {
    protected static final int SLOT_INPUT = 0;
    protected static final int SLOT_FUEL = 1;
    protected static final int SLOT_RESULT = 2;
    public static final int DATA_LIT_TIME = 0;
    private static final int[] SLOTS_FOR_UP = new int[]{0};
    private static final int[] SLOTS_FOR_DOWN = new int[]{2, 1};
    private static final int[] SLOTS_FOR_SIDES = new int[]{1};
    public static final int DATA_LIT_DURATION = 1;
    public static final int DATA_COOKING_PROGRESS = 2;
    public static final int DATA_COOKING_TOTAL_TIME = 3;
    public static final int NUM_DATA_VALUES = 4;
    public static final int BURN_TIME_STANDARD = 200;
    public static final int BURN_COOL_SPEED = 2;
    private final RecipeType<? extends AbstractFreezingRecipe> recipeType;
    protected NonNullList<ItemStack> items;
    int litTime;
    int litDuration;
    int cookingProgress;
    int cookingTotalTime;
    protected final ContainerData dataAccess;
    private final Object2IntOpenHashMap<ResourceLocation> recipesUsed;
    private final RecipeManager.CachedCheck<Container, ? extends AbstractFreezingRecipe> quickCheck;
    LazyOptional<? extends IItemHandler>[] handlers;

    protected AbstractFreezerBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState, RecipeType<? extends AbstractFreezingRecipe> pRecipeType) {
        super(pType, pPos, pBlockState);
        this.items = NonNullList.withSize(3, ItemStack.EMPTY);
        this.dataAccess = new ContainerData() {
            public int get(int p_58431_) {
                return switch (p_58431_) {
                    case 0 -> AbstractFreezerBlockEntity.this.litTime;
                    case 1 -> AbstractFreezerBlockEntity.this.litDuration;
                    case 2 -> AbstractFreezerBlockEntity.this.cookingProgress;
                    case 3 -> AbstractFreezerBlockEntity.this.cookingTotalTime;
                    default -> 0;
                };
            }

            public void set(int p_58433_, int p_58434_) {
                switch (p_58433_) {
                    case 0:
                        AbstractFreezerBlockEntity.this.litTime = p_58434_;
                        break;
                    case 1:
                        AbstractFreezerBlockEntity.this.litDuration = p_58434_;
                        break;
                    case 2:
                        AbstractFreezerBlockEntity.this.cookingProgress = p_58434_;
                        break;
                    case 3:
                        AbstractFreezerBlockEntity.this.cookingTotalTime = p_58434_;
                }

            }

            public int getCount() {
                return 4;
            }
        };
        this.recipesUsed = new Object2IntOpenHashMap<>();
        this.handlers = SidedInvWrapper.create(this, new Direction[]{Direction.UP, Direction.DOWN, Direction.NORTH});
        this.quickCheck = RecipeManager.createCheck(pRecipeType);
        this.recipeType = pRecipeType;
    }

    /** @deprecated */
    @Deprecated
    public static Map<Item, Integer> getFuel() {
        Map<Item, Integer> map = Maps.newLinkedHashMap();
        add(map, Items.COAL, 1600);
        return map;
    }

    private static boolean isNeverAFurnaceFuel(Item pItem) {
        return pItem.builtInRegistryHolder().is(ItemTags.NON_FLAMMABLE_WOOD);
    }

    private static void add(Map<Item, Integer> pMap, TagKey<Item> pItemTag, int pBurnTime) {

        for (Holder<Item> itemHolder : BuiltInRegistries.ITEM.getTagOrEmpty(pItemTag)) {
            if (!isNeverAFurnaceFuel(itemHolder.value())) {
                pMap.put(itemHolder.value(), pBurnTime);
            }
        }

    }

    private static void add(Map<Item, Integer> pMap, ItemLike pItem, int pBurnTime) {
        Item item = pItem.asItem();
        if (isNeverAFurnaceFuel(item)) {
            if (SharedConstants.IS_RUNNING_IN_IDE) {
                throw Util.pauseInIde(new IllegalStateException("A developer tried to explicitly make fire resistant item " + item.getName((ItemStack)null).getString() + " a furnace fuel. That will not work!"));
            }
        } else {
            pMap.put(item, pBurnTime);
        }

    }

    private boolean isLit() {
        return this.litTime > 0;
    }

    public void load(@NotNull CompoundTag pTag) {
        super.load(pTag);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(pTag, this.items);
        this.litTime = pTag.getInt("BurnTime");
        this.cookingProgress = pTag.getInt("CookTime");
        this.cookingTotalTime = pTag.getInt("CookTimeTotal");
        this.litDuration = this.getBurnDuration((ItemStack)this.items.get(1));
        CompoundTag compoundtag = pTag.getCompound("RecipesUsed");

        for (String s : compoundtag.getAllKeys()) {
            this.recipesUsed.put(new ResourceLocation(s), compoundtag.getInt(s));
        }

    }

    protected void saveAdditional(@NotNull CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.putInt("BurnTime", this.litTime);
        pTag.putInt("CookTime", this.cookingProgress);
        pTag.putInt("CookTimeTotal", this.cookingTotalTime);
        ContainerHelper.saveAllItems(pTag, this.items);
        CompoundTag compoundtag = new CompoundTag();
        this.recipesUsed.forEach((p_187449_, p_187450_) -> {
            compoundtag.putInt(p_187449_.toString(), p_187450_);
        });
        pTag.put("RecipesUsed", compoundtag);
    }

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, AbstractFreezerBlockEntity pBlockEntity) {
        boolean flag = pBlockEntity.isLit();
        boolean flag1 = false;
        if (pBlockEntity.isLit()) {
            --pBlockEntity.litTime;
        }

        ItemStack itemstack = pBlockEntity.items.get(1);
        boolean flag2 = !pBlockEntity.items.get(0).isEmpty();
        boolean flag3 = !itemstack.isEmpty();
        if (!pBlockEntity.isLit() && (!flag3 || !flag2)) {
            if (!pBlockEntity.isLit() && pBlockEntity.cookingProgress > 0) {
                pBlockEntity.cookingProgress = Mth.clamp(pBlockEntity.cookingProgress - 2, 0, pBlockEntity.cookingTotalTime);
            }
        } else {
            RecipeHolder recipeholder;
            if (flag2) {
                recipeholder = pBlockEntity.quickCheck.getRecipeFor(pBlockEntity, pLevel).orElse(null);
            } else {
                recipeholder = null;
            }

            int i = pBlockEntity.getMaxStackSize();
            if (!pBlockEntity.isLit() && pBlockEntity.canBurn(pLevel.registryAccess(), recipeholder, pBlockEntity.items, i)) {
                pBlockEntity.litTime = pBlockEntity.getBurnDuration(itemstack);
                pBlockEntity.litDuration = pBlockEntity.litTime;
                if (pBlockEntity.isLit()) {
                    flag1 = true;
                    if (itemstack.hasCraftingRemainingItem()) {
                        pBlockEntity.items.set(1, itemstack.getCraftingRemainingItem());
                    } else if (flag3) {
                        Item item = itemstack.getItem();
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            pBlockEntity.items.set(1, itemstack.getCraftingRemainingItem());
                        }
                    }
                }
            }

            if (pBlockEntity.isLit() && pBlockEntity.canBurn(pLevel.registryAccess(), recipeholder, pBlockEntity.items, i)) {
                ++pBlockEntity.cookingProgress;
                if (pBlockEntity.cookingProgress == pBlockEntity.cookingTotalTime) {
                    pBlockEntity.cookingProgress = 0;
                    pBlockEntity.cookingTotalTime = getTotalCookTime(pLevel, pBlockEntity);
                    if (pBlockEntity.burn(pLevel.registryAccess(), recipeholder, pBlockEntity.items, i)) {
                        pBlockEntity.setRecipeUsed(recipeholder);
                    }

                    flag1 = true;
                }
            } else {
                pBlockEntity.cookingProgress = 0;
            }
        }

        if (flag != pBlockEntity.isLit()) {
            flag1 = true;
            pState = (BlockState)pState.setValue(AbstractFreezerBlock.LIT, pBlockEntity.isLit());
            pLevel.setBlock(pPos, pState, 3);
        }

        if (flag1) {
            setChanged(pLevel, pPos, pState);
        }

    }

    private boolean canBurn(RegistryAccess pRegistryAccess, @Nullable RecipeHolder<?> pRecipe, NonNullList<ItemStack> pInventory, int pMaxStackSize) {
        if (!pInventory.get(0).isEmpty() && pRecipe != null) {
            ItemStack itemstack = pRecipe.value().getResultItem(pRegistryAccess);
            if (itemstack.isEmpty()) {
                return false;
            } else {
                ItemStack itemstack1 = pInventory.get(2);
                if (itemstack1.isEmpty()) {
                    return true;
                } else if (!ItemStack.isSameItem(itemstack1, itemstack)) {
                    return false;
                } else if (itemstack1.getCount() + itemstack.getCount() <= pMaxStackSize && itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize()) {
                    return true;
                } else {
                    return itemstack1.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize();
                }
            }
        } else {
            return false;
        }
    }

    private boolean burn(RegistryAccess pRegistryAccess, @Nullable RecipeHolder<?> pRecipe, NonNullList<ItemStack> pInventory, int pMaxStackSize) {
        if (pRecipe != null && this.canBurn(pRegistryAccess, pRecipe, pInventory, pMaxStackSize)) {
            ItemStack itemstack = pInventory.get(0);
            ItemStack itemstack1 = pRecipe.value().getResultItem(pRegistryAccess);
            ItemStack itemstack2 = pInventory.get(2);
            if (itemstack2.isEmpty()) {
                pInventory.set(2, itemstack1.copy());
            } else if (itemstack2.is(itemstack1.getItem())) {
                itemstack2.grow(itemstack1.getCount());
            }

            if (itemstack.is(Blocks.WET_SPONGE.asItem()) && !((ItemStack)pInventory.get(1)).isEmpty() && ((ItemStack)pInventory.get(1)).is(Items.BUCKET)) {
                pInventory.set(1, new ItemStack(Items.WATER_BUCKET));
            }

            itemstack.shrink(1);
            return true;
        } else {
            return false;
        }
    }

    protected int getBurnDuration(ItemStack pFuel) {
        if (pFuel.isEmpty()) {
            return 0;
        } else {
            Item item = pFuel.getItem();
            return ForgeHooks.getBurnTime(pFuel, this.recipeType);
        }
    }

    private static int getTotalCookTime(Level pLevel, AbstractFreezerBlockEntity pBlockEntity) {
        return pBlockEntity.quickCheck.getRecipeFor(pBlockEntity, pLevel).map((p_296950_) -> {
            return p_296950_.value().getCookingTime();
        }).orElse(200);
    }

    public static boolean isFuel(ItemStack pStack) {
        return ForgeHooks.getBurnTime(pStack, (RecipeType)null) > 0;
    }

    public int @NotNull [] getSlotsForFace(@NotNull Direction pSide) {
        if (pSide == Direction.DOWN) {
            return SLOTS_FOR_DOWN;
        } else {
            return pSide == Direction.UP ? SLOTS_FOR_UP : SLOTS_FOR_SIDES;
        }
    }

    public boolean canPlaceItemThroughFace(int pIndex, @NotNull ItemStack pItemStack, @Nullable Direction pDirection) {
        return this.canPlaceItem(pIndex, pItemStack);
    }

    public boolean canTakeItemThroughFace(int pIndex, @NotNull ItemStack pStack, @NotNull Direction pDirection) {
        if (pDirection == Direction.DOWN && pIndex == 1) {
            return pStack.is(Items.WATER_BUCKET) || pStack.is(Items.BUCKET);
        } else {
            return true;
        }
    }

    public int getContainerSize() {
        return this.items.size();
    }

    public boolean isEmpty() {
        Iterator<ItemStack> var1 = this.items.iterator();

        ItemStack itemstack;
        do {
            if (!var1.hasNext()) {
                return true;
            }

            itemstack = (ItemStack)var1.next();
        } while(itemstack.isEmpty());

        return false;
    }

    public @NotNull ItemStack getItem(int pIndex) {
        return (ItemStack)this.items.get(pIndex);
    }

    public @NotNull ItemStack removeItem(int pIndex, int pCount) {
        return ContainerHelper.removeItem(this.items, pIndex, pCount);
    }

    public @NotNull ItemStack removeItemNoUpdate(int pIndex) {
        return ContainerHelper.takeItem(this.items, pIndex);
    }

    public void setItem(int pIndex, ItemStack pStack) {
        ItemStack itemstack = (ItemStack)this.items.get(pIndex);
        boolean flag = !pStack.isEmpty() && ItemStack.isSameItemSameTags(itemstack, pStack);
        this.items.set(pIndex, pStack);
        if (pStack.getCount() > this.getMaxStackSize()) {
            pStack.setCount(this.getMaxStackSize());
        }

        if (pIndex == 0 && !flag) {
            this.cookingTotalTime = getTotalCookTime(this.level, this);
            this.cookingProgress = 0;
            this.setChanged();
        }

    }

    public boolean stillValid(@NotNull Player pPlayer) {
        return Container.stillValidBlockEntity(this, pPlayer);
    }

    public boolean canPlaceItem(int pIndex, @NotNull ItemStack pStack) {
        if (pIndex == 2) {
            return false;
        } else if (pIndex != 1) {
            return true;
        } else {
            ItemStack itemstack = (ItemStack)this.items.get(1);
            return ForgeHooks.getBurnTime(pStack, this.recipeType) > 0 || pStack.is(Items.BUCKET) && !itemstack.is(Items.BUCKET);
        }
    }

    public void clearContent() {
        this.items.clear();
    }

    public void setRecipeUsed(@Nullable RecipeHolder<?> pRecipe) {
        if (pRecipe != null) {
            ResourceLocation resourcelocation = pRecipe.id();
            this.recipesUsed.addTo(resourcelocation, 1);
        }

    }

    @Nullable
    public RecipeHolder<?> getRecipeUsed() {
        return null;
    }

    public void awardUsedRecipes(@NotNull Player pPlayer, @NotNull List<ItemStack> pItems) {
    }

    public void awardUsedRecipesAndPopExperience(ServerPlayer pPlayer) {
        List<RecipeHolder<?>> list = this.getRecipesToAwardAndPopExperience(pPlayer.serverLevel(), pPlayer.position());
        pPlayer.awardRecipes(list);

        for (RecipeHolder<?> recipeHolder : list) {
            if (recipeHolder != null) {
                pPlayer.triggerRecipeCrafted(recipeHolder, this.items);
            }
        }

        this.recipesUsed.clear();
    }

    public List<RecipeHolder<?>> getRecipesToAwardAndPopExperience(ServerLevel pLevel, Vec3 pPopVec) {
        List<RecipeHolder<?>> list = Lists.newArrayList();

        for (Object2IntMap.Entry<ResourceLocation> resourceLocationEntry : this.recipesUsed.object2IntEntrySet()) {
            Object2IntMap.Entry entry = resourceLocationEntry;
            pLevel.getRecipeManager().byKey((ResourceLocation) entry.getKey()).ifPresent((p_296949_) -> {
                list.add(p_296949_);
                createExperience(pLevel, pPopVec, entry.getIntValue(), ((AbstractFreezingRecipe) p_296949_.value()).getExperience());
            });
        }

        return list;
    }

    private static void createExperience(ServerLevel pLevel, Vec3 pPopVec, int pRecipeIndex, float pExperience) {
        int i = Mth.floor((float)pRecipeIndex * pExperience);
        float f = Mth.frac((float)pRecipeIndex * pExperience);
        if (f != 0.0F && Math.random() < (double)f) {
            ++i;
        }

        ExperienceOrb.award(pLevel, pPopVec, i);
    }

    public void fillStackedContents(@NotNull StackedContents pHelper) {

        for (ItemStack itemstack : this.items) {
            pHelper.accountStack(itemstack);
        }

    }

    public <T> @NotNull LazyOptional<T> getCapability(@NotNull Capability<T> capability, @Nullable Direction facing) {
        if (!this.remove && facing != null && capability == ForgeCapabilities.ITEM_HANDLER) {
            if (facing == Direction.UP) {
                return this.handlers[0].cast();
            } else {
                return facing == Direction.DOWN ? this.handlers[1].cast() : this.handlers[2].cast();
            }
        } else {
            return super.getCapability(capability, facing);
        }
    }

    public void invalidateCaps() {
        super.invalidateCaps();

        for (LazyOptional<? extends IItemHandler> handler : this.handlers) {
            handler.invalidate();
        }

    }

    public void reviveCaps() {
        super.reviveCaps();
        this.handlers = SidedInvWrapper.create(this, new Direction[]{Direction.UP, Direction.DOWN, Direction.NORTH});
    }
}
