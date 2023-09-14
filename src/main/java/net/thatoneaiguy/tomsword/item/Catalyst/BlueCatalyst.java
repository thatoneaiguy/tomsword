package net.thatoneaiguy.tomsword.item.Catalyst;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.thatoneaiguy.tomsword.entity.CatalystEntity;
import net.thatoneaiguy.tomsword.item.ModItemGroup;

public class BlueCatalyst extends SwordItem {
    public BlueCatalyst(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    public BlueCatalyst() {
        super(ToolMaterials.NETHERITE, 3, -2.4F,
                new FabricItemSettings().group(ModItemGroup.TOMSWORD).rarity(Rarity.RARE));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        //user.getItemCooldownManager().set(this, 20);
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_RESPAWN_ANCHOR_DEPLETE, SoundCategory.PLAYERS, 0.5F, 1.5F);
        Vec3d vec3d = user.getRotationVec(1.0F);
        double x = user.getX() + vec3d.x;
        double y = user.getEyeY() + vec3d.y;
        double z = user.getZ() + vec3d.z;

        if (!world.isClient) {
            CatalystEntity catalystEntity = new CatalystEntity(world, user, x - user.getX(), y - user.getEyeY(), z - user.getZ());
            catalystEntity.setPosition(x - 0.5, y, z);
            world.spawnEntity(catalystEntity);
        }

        return TypedActionResult.success(itemStack, world.isClient);
    }
}