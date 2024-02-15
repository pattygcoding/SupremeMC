package net.pattygcoding.suprememc.init;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pattygcoding.suprememc.SupremeMC;
import net.pattygcoding.suprememc.entity.custom.FireCreeperEntity;
import net.pattygcoding.suprememc.entity.custom.SnowCreeperEntity;

public class SMCEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SupremeMC.MOD_ID);

    public static final RegistryObject<EntityType<FireCreeperEntity>> FIRE_CREEPER =
            ENTITY_TYPES.register("fire_creeper", () -> EntityType.Builder.of(FireCreeperEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.7f).build("fire_creeper"));

    public static final RegistryObject<EntityType<SnowCreeperEntity>> SNOW_CREEPER =
            ENTITY_TYPES.register("snow_creeper", () -> EntityType.Builder.of(SnowCreeperEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.7f).build("snow_creeper"));

    public static final RegistryObject<EntityType<FireCreeperEntity>> SOUL_CREEPER =
            ENTITY_TYPES.register("soul_creeper", () -> EntityType.Builder.of(FireCreeperEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.7f).build("soul_creeper"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
