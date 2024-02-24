package net.pattygcoding.suprememc.recipes;

import com.mojang.datafixers.Products;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Objects;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import org.jetbrains.annotations.NotNull;

public class FreezingSerializer<T extends AbstractFreezingRecipe> implements RecipeSerializer<T> {
    private final FreezingSerializer.CookieBaker<T> factory;
    private final Codec<T> codec;

    public FreezingSerializer(FreezingSerializer.CookieBaker<T> pFactory, int pDefaultCookingTime) {
        this.factory = pFactory;
        this.codec = RecordCodecBuilder.create((p_296927_) -> {
            Products.P6<RecordCodecBuilder.Mu<T>, String, CookingBookCategory, Ingredient, ItemStack, Float, Integer> var10000 = p_296927_.group(ExtraCodecs.strictOptionalField(Codec.STRING, "group", "").forGetter((p_296921_) -> {
                return p_296921_.group;
            }), CookingBookCategory.CODEC.fieldOf("category").orElse(CookingBookCategory.MISC).forGetter((p_296924_) -> {
                return p_296924_.category;
            }), Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter((p_296920_) -> {
                return p_296920_.ingredient;
            }), BuiltInRegistries.ITEM.byNameCodec().xmap(ItemStack::new, ItemStack::getItem).fieldOf("result").forGetter((p_296923_) -> {
                return p_296923_.result;
            }), Codec.FLOAT.fieldOf("experience").orElse(0.0F).forGetter((p_296922_) -> {
                return p_296922_.experience;
            }), Codec.INT.fieldOf("cookingtime").orElse(pDefaultCookingTime).forGetter((p_296919_) -> {
                return p_296919_.cookingTime;
            }));
            Objects.requireNonNull(pFactory);
            return var10000.apply(p_296927_, pFactory::create);
        });
    }

    public @NotNull Codec<T> codec() {
        return this.codec;
    }

    public T fromNetwork(FriendlyByteBuf pBuffer) {
        String $$1 = pBuffer.readUtf();
        CookingBookCategory $$2 = (CookingBookCategory)pBuffer.readEnum(CookingBookCategory.class);
        Ingredient $$3 = Ingredient.fromNetwork(pBuffer);
        ItemStack $$4 = pBuffer.readItem();
        float $$5 = pBuffer.readFloat();
        int $$6 = pBuffer.readVarInt();
        return this.factory.create($$1, $$2, $$3, $$4, $$5, $$6);
    }

    public void toNetwork(FriendlyByteBuf pBuffer, T pRecipe) {
        pBuffer.writeUtf(pRecipe.group);
        pBuffer.writeEnum(pRecipe.category());
        pRecipe.ingredient.toNetwork(pBuffer);
        pBuffer.writeItem(pRecipe.result);
        pBuffer.writeFloat(pRecipe.experience);
        pBuffer.writeVarInt(pRecipe.cookingTime);
    }

    public interface CookieBaker<T extends AbstractFreezingRecipe> {
        T create(String var1, CookingBookCategory var2, Ingredient var3, ItemStack var4, float var5, int var6);
    }
}