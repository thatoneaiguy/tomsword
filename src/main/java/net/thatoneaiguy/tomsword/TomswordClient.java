package net.thatoneaiguy.tomsword;

import net.fabricmc.api.ClientModInitializer;
import net.thatoneaiguy.tomsword.packet.C2SUseAndromeda;
import net.thatoneaiguy.tomsword.packet.S2CUseAndromedaPacket;

public class TomswordClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModelLoadingRegistry.INSTANCE.registerModelProvider((resources, out) -> out.accept(new ModelIdentifier("tomsword", "smoldia", "inventory")));
        S2CUseAndromedaPacket.register();
        C2SUseAndromeda.register();
    }
}
