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
        double knockbackX = (targetPlayer.getX() - attacker.getX());
        double knockbackY = (targetPlayer.getY() - attacker.getY());
        double knockbackZ = (targetPlayer.getZ() - attacker.getZ());

        return new Vec3d(-knockbackX, knockbackY, -knockbackZ).normalize();
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        assert target instanceof LivingEntity;
        if (!user.isOnGround()) {
            target.setVelocity(applyKnockback((LivingEntity) target, user).multiply(0.6));
            target.addVelocity(0, 0.5, 0);
        }
        //super.onTargetDamaged(user, target, level);
    }


    @Override
    public int getMaxLevel() {
        return 1;
    }
}