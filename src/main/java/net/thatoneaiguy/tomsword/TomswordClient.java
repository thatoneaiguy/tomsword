package net.thatoneaiguy.tomsword;

import net.fabricmc.api.ClientModInitializer;
import net.thatoneaiguy.tomsword.packet.C2SUseAndromeda;
import net.thatoneaiguy.tomsword.packet.S2CUseAndromedaPacket;

public class TomswordClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        S2CUseAndromedaPacket.register();
        C2SUseAndromeda.register();
    }
}
