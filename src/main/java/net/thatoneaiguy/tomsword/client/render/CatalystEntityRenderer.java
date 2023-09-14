package net.thatoneaiguy.tomsword.client.render;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;
import net.thatoneaiguy.tomsword.Tomsword;
import net.thatoneaiguy.tomsword.entity.CatalystEntity;

public class CatalystEntityRenderer extends ProjectileEntityRenderer<CatalystEntity> {
    public static final Identifier TEXTURE = new Identifier(Tomsword.MOD_ID, "textures/entity/projectiles/nothing.png");

    public CatalystEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(CatalystEntity entity) {
        return TEXTURE;
    }
}
