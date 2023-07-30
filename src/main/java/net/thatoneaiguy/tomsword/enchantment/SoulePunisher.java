package net.thatoneaiguy.tomsword.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;

public class SoulePunisher extends Enchantment {
    public SoulePunisher(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);

    }

    private Vec3d applyKnockback(LivingEntity targetPlayer, LivingEntity attacker) {
        // Calculate the knockback vector based on the attacker's position and the target player's position
        double knockbackX = attacker.getX() - targetPlayer.getX();
        double knockbackY = attacker.getY() - targetPlayer.getY();
        double knockbackZ = attacker.getZ() - targetPlayer.getZ();

        // Apply the knockback to the target player's motion
        Vec3d vec3d = new Vec3d(knockbackX, knockbackY+0.5, knockbackZ);
        return vec3d.normalize();
    }
    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        assert target instanceof LivingEntity;
        target.setVelocity(applyKnockback((LivingEntity) target, user).multiply(0.57));

    }

    @Override
    public int getMaxLevel() {
        return 1;
    }
}