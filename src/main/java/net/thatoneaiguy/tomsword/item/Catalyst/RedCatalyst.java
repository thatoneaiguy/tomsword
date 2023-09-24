package net.thatoneaiguy.tomsword.item.Catalyst;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.thatoneaiguy.tomsword.item.ModItemGroup;

public class RedCatalyst extends SwordItem {
    public RedCatalyst(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    public RedCatalyst() {
        super(ToolMaterials.NETHERITE, 3, -2.4F,
                new FabricItemSettings().group(ModItemGroup.TOMSWORD).rarity(Rarity.RARE).fireproof());
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return super.postHit(stack, target, attacker);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.getItemCooldownManager().set(this, 90);
        Vec3d vec3d = user.getRotationVec(1.0F);
        double f = user.getX() + vec3d.x * 4.0; // Adjusted this line
        double g = user.getEyeY() + vec3d.y * 4.0; // Adjusted this line
        double h = user.getZ() + vec3d.z * 4.0; // Adjusted this line

        FireballEntity fireballEntity = new FireballEntity(world, user, f - user.getX(), g - user.getEyeY(), h - user.getZ(), 2);
        fireballEntity.setPosition(f, g, h);
        world.spawnEntity(fireballEntity);

        return super.use(world, user, hand);
    }
}

