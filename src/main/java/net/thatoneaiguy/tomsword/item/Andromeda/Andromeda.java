package net.thatoneaiguy.tomsword.item.Andromeda;

import dev.emi.trinkets.api.TrinketsApi;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.thatoneaiguy.tomsword.Tomsword;
import net.thatoneaiguy.tomsword.item.ModItemGroup;
import net.thatoneaiguy.tomsword.packet.C2SUseAndromeda;
import net.thatoneaiguy.tomsword.packet.S2CUseAndromedaPacket;

import java.util.ArrayList;
import java.util.List;

public class Andromeda extends SwordItem {
    private static final int COOLDOWN_DURATION = 110;
    private int cooldownTicks = 0;

    public Andromeda() {
        super(ToolMaterials.NETHERITE,
                -5,
                -2.4F,
                new FabricItemSettings().group(ModItemGroup.TOMSWORD).rarity(Rarity.EPIC));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world,
                                            PlayerEntity user,
                                            Hand hand) {
        if (cooldownTicks <= 0) {
            cooldownTicks = COOLDOWN_DURATION;
            Vec3d cameraPos = user.getCameraPosVec(1.0F);
            Vec3d cameraDirection = user.getRotationVec(1.0F);

            double raycastDistance = 20.0;
            Vec3d endPos = cameraPos.add(cameraDirection.multiply(raycastDistance));

            BlockHitResult hitResult = user.world.raycast(new RaycastContext(cameraPos,
                    endPos,
                    RaycastContext.ShapeType.OUTLINE,
                    RaycastContext.FluidHandling.NONE,
                    user));
            if (hitResult.getType() == BlockHitResult.Type.BLOCK) {
                double blockX = hitResult.getBlockPos().getX();
                double blockY = hitResult.getBlockPos().getY();
                double blockZ = hitResult.getBlockPos().getZ();
                PacketByteBuf buffer = PacketByteBufs.create();
                buffer.writeBlockPos(new BlockPos(new Vec3d(blockX, blockY, blockZ)));
                buffer.writeString(String.valueOf(user.getName()));
                ClientPlayNetworking.send(C2SUseAndromeda.C2SUSE_ANDROMEDA, buffer);
            }
            return TypedActionResult.success(user.getStackInHand(hand));
        }
        return TypedActionResult.fail(user.getStackInHand(hand));
    }

    @Override
    public void inventoryTick(ItemStack stack,
                              World world,
                              Entity entity,
                              int slot,
                              boolean selected) {
        if (cooldownTicks > 0) {
            cooldownTicks--;
        }
        super.inventoryTick(stack,
                world,
                entity,
                slot,
                selected);
    }

    public static List<PlayerEntity> getPlayersWithinRange(Vec3d areaCenter,
                                                           double range,
                                                           double height,
                                                           World world) {
        List<PlayerEntity> playersWithinRange = new ArrayList<>();

        for (PlayerEntity player : world.getPlayers()) {
            Vec3d playerPos = player.getPos();
            if (isWithinCylinder(playerPos,
                    areaCenter,
                    range,
                    height)) {
                playersWithinRange.add(player);
            }
        }

        return playersWithinRange;
    }
    private static boolean isWithinCylinder(Vec3d point,
                                            Vec3d center,
                                            double radius,
                                            double height) {
        double dx = point.x - center.x;
        double dz = point.z - center.z;
        double distanceSquared = dx * dx + dz * dz;
        return distanceSquared < (radius * radius) && Math.abs(point.y - center.y) < (height / 2.0);
    }
}
