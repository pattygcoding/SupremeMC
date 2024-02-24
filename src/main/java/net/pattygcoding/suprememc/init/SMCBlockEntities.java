package net.pattygcoding.suprememc.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pattygcoding.suprememc.SupremeMC;
import net.pattygcoding.suprememc.blocks.freezer.FreezerBlockEntity;

public class SMCBlockEntities
{
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SupremeMC.MOD_ID);

    public static final RegistryObject<BlockEntityType<FreezerBlockEntity>> FREEZER_BE =
            BLOCK_ENTITIES.register("freezer_be", () ->
                    BlockEntityType.Builder.of(FreezerBlockEntity::new,
                            SMCBlocks.FREEZER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
