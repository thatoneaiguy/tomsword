package net.thatoneaiguy.tomsword.packet;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.particle.Particle;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.thatoneaiguy.tomsword.Tomsword;
import net.thatoneaiguy.tomsword.item.Andromeda.Andromeda;

import java.util.Objects;

public class S2CUseAndromedaPacket {
    public static final Identifier USE_ANDROMEDA = new Identifier("tomsword", "use_andromeda");

    public static void send(ServerPlayerEntity player, Identifier channelName, PacketByteBuf buf) {

    }

    public static void register() {
        ClientPlayNetworking.registerGlobalReceiver(S2CUseAndromedaPacket.USE_ANDROMEDA, (client, handler, buf, responseSender) -> {
            BlockPos blockPos = buf.readBlockPos();
            String name = buf.readString();
            client.execute(() -> {
                // Everything in this lambda is run on the render thread
                double blockX = blockPos.getX();
                double blockY = blockPos.getY();
                double blockZ = blockPos.getZ();

                System.out.println(name + "" + String.valueOf(client.player.getName()));
                if (Objects.equals(name, String.valueOf(client.player.getName()))) return;
                client.world.addParticle(ParticleTypes.REVERSE_PORTAL, client.player.getX(), client.player.getY() + 2.0, client.player.getZ(), 0.0, 0.0, 0.0);
                client.player.setPos(blockX, blockY, blockZ);
                client.world.addParticle(ParticleTypes.REVERSE_PORTAL, client.player.getX(), client.player.getY() + 2.0, client.player.getZ(), 0.0, 0.0, 0.0);
            });
        });
    }
}
