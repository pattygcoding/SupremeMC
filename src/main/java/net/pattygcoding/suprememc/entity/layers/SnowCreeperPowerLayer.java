package net.pattygcoding.suprememc.entity.layers;

import net.minecraft.client.model.CreeperModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EnergySwirlLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.pattygcoding.suprememc.SupremeMC;
import net.pattygcoding.suprememc.entity.custom.SnowCreeperEntity;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class SnowCreeperPowerLayer extends EnergySwirlLayer<SnowCreeperEntity, CreeperModel<SnowCreeperEntity>> {
    private final ResourceLocation powerLocation;
    private final CreeperModel<SnowCreeperEntity> model;
    private String path;

    public SnowCreeperPowerLayer(RenderLayerParent<SnowCreeperEntity, CreeperModel<SnowCreeperEntity>> pRenderer, EntityModelSet pModelSet, String pPath) {
        super(pRenderer);
        this.model = new CreeperModel<>(pModelSet.bakeLayer(ModelLayers.CREEPER_ARMOR));
        this.powerLocation = new ResourceLocation(SupremeMC.MOD_ID, pPath);
    }

    protected float xOffset(float pTickCount) {
        return pTickCount * 0.01F;
    }

    protected @NotNull ResourceLocation getTextureLocation() {
        return this.powerLocation;
    }

    protected @NotNull EntityModel<SnowCreeperEntity> model() {
        return this.model;
    }
}
