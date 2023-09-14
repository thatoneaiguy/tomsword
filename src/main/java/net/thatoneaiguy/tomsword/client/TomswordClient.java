package net.thatoneaiguy.tomsword.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.util.Identifier;
import net.thatoneaiguy.tomsword.Tomsword;
import net.thatoneaiguy.tomsword.client.render.CatalystEntityRenderer;
import net.thatoneaiguy.tomsword.entity.CatalystEntity;
import net.thatoneaiguy.tomsword.packet.C2SUseAndromeda;
import net.thatoneaiguy.tomsword.packet.S2CUseAndromedaPacket;

public class TomswordClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModelLoadingRegistry.INSTANCE.registerModelProvider((resources, out) -> out.accept(new ModelIdentifier("tomsword", "diamond_longsword_gui", "inventory")));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((resources, out) -> out.accept(new ModelIdentifier("tomsword", "netherite_longsword_gui", "inventory")));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((resources, out) -> out.accept(new ModelIdentifier("tomsword", "bloodweaver_gui", "inventory")));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((resources, out) -> out.accept(new ModelIdentifier("tomsword", "shatterblade_gui", "inventory")));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((resources, out) -> out.accept(new ModelIdentifier("tomsword", "blue_catalyst_gui", "inventory")));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((resources, out) -> out.accept(new ModelIdentifier("tomsword", "cookie_claymore_gui", "inventory")));

        EntityRendererRegistry.register(Tomsword.CatalystEntityType, CatalystEntityRenderer::new);


        S2CUseAndromedaPacket.register();
        C2SUseAndromeda.register();


    }
}
