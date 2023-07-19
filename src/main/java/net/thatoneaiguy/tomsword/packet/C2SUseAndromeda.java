package net.thatoneaiguy.tomsword.packet;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.PortalParticle;
import net.minecraft.client.particle.ReversePortalParticle;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.thatoneaiguy.tomsword.Tomsword;
import net.thatoneaiguy.tomsword.item.Andromeda.Andromeda;

import java.util.Objects;

public class C2SUseAndromeda {
    public static final Identifier C2SUSE_ANDROMEDA = new Identifier("tomsword", "c2s_use_andromeda");

    public static void register() {
        ServerPlayNetworking.registerGlobalReceiver(C2SUSE_ANDROMEDA, (server, player, handler, buf, responseSender) -> {
            BlockPos blockPos = buf.readBlockPos();
            String name = buf.readString();
            server.execute(() -> {
                PacketByteBuf buffer = PacketByteBufs.create();
                buffer.writeString(name);
                for (PlayerEntity playerEntity : Andromeda.getPlayersWithinRange(new Vec3d(blockPos.getX(), blockPos.getY(), blockPos.getZ()), 12, 12, player.getWorld())) {
                    if (!(Objects.equals(String.valueOf(playerEntity.getName()), String.valueOf(player.getName())))) {
                        playerEntity.teleport(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ());
                    }
                }
            });
        });
    }
}
