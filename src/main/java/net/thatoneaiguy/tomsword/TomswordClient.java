package net.thatoneaiguy.tomsword;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.util.ModelIdentifier;
import net.thatoneaiguy.tomsword.packet.C2SUseAndromeda;
import net.thatoneaiguy.tomsword.packet.S2CUseAndromedaPacket;

public class TomswordClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModelLoadingRegistry.INSTANCE.registerModelProvider((resources, out) -> out.accept(new ModelIdentifier("tomsword", "smoldia", "inventory")));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((resources, out) -> out.accept(new ModelIdentifier("tomsword", "smolneth", "inventory")));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((resources, out) -> out.accept(new ModelIdentifier("tomsword", "smolblood", "inventory")));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((resources, out) -> out.accept(new ModelIdentifier("tomsword", "smolshatterblade", "inventory")));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((resources, out) -> out.accept(new ModelIdentifier("tomsword", "smolcatalyst", "inventory")));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((resources, out) -> out.accept(new ModelIdentifier("tomsword", "smolclaymore", "inventory")));
        S2CUseAndromedaPacket.register();
        C2SUseAndromeda.register();
        EntityRendererRegistry.register(Tomsword.CatalystEntityType, (context) ->
                new FlyingItemEntityRenderer(context));

    }
}
