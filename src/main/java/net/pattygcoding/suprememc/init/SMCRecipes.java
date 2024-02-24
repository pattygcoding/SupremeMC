package net.pattygcoding.suprememc.init;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pattygcoding.suprememc.SupremeMC;
import net.pattygcoding.suprememc.recipes.FreezingRecipe;
import net.pattygcoding.suprememc.recipes.FreezingSerializer;

public class SMCRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, SupremeMC.MOD_ID);

    public static final RegistryObject<RecipeSerializer<FreezingRecipe>> FREEZING_SERIALIZER =
            SERIALIZERS.register("freezing", () -> new FreezingSerializer<>(FreezingRecipe::new, 200));

    public static void registerSerializers(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}