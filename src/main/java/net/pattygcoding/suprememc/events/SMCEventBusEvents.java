package net.pattygcoding.suprememc.events;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.pattygcoding.suprememc.SupremeMC;
import net.pattygcoding.suprememc.entity.custom.FireCreeperEntity;
import net.pattygcoding.suprememc.entity.custom.SnowCreeperEntity;
import net.pattygcoding.suprememc.init.SMCEntities;

@Mod.EventBusSubscriber(modid = SupremeMC.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SMCEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(SMCEntities.FIRE_CREEPER.get(), FireCreeperEntity.createAttributes().build());
        event.put(SMCEntities.SNOW_CREEPER.get(), SnowCreeperEntity.createAttributes().build());
        event.put(SMCEntities.SOUL_CREEPER.get(), FireCreeperEntity.createAttributes().build());
    }
}
