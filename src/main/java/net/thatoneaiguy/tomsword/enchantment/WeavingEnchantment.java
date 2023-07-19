package net.thatoneaiguy.tomsword.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;

public class WeavingEnchantment extends Enchantment {
    public WeavingEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);

    }

    private Vec3d applyKnockback(LivingEntity targetPlayer, LivingEntity attacker) {
        // Calculate the knockback vector based on the attacker's position and the target player's position
        double knockbackX = targetPlayer.getX() - attacker.getX();
        double knockbackY = targetPlayer.getY() - attacker.getY();
        double knockbackZ = targetPlayer.getZ() - attacker.getZ();

        // Apply the knockback to the target player's motion
        return new Vec3d(-1.3, knockbackY, -1.3);
    }
    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        assert target instanceof LivingEntity;
        target.setVelocity(applyKnockback((LivingEntity) target, user));
        //super.onTargetDamaged(user, target, level);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }
}
