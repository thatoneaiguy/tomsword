package net.thatoneaiguy.tomsword.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.thatoneaiguy.tomsword.Tomsword;

public class ShatterbladeEntity extends ThrownItemEntity {
    @Override
    protected Item getDefaultItem() {
       return Tomsword.Shatterblade;
    }
    public ShatterbladeEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public ShatterbladeEntity(World world, LivingEntity owner) {
        super(null, owner, world); // null will be changed later
    }

    public ShatterbladeEntity(World world, double x, double y, double z) {
        super(null, x, y, z, world); // null will be changed later
    }


    protected void onEntityHit(EntityHitResult entityHitResult) { // called on entity hit.
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity(); // sets a new Entity instance as the EntityHitResult (victim)
        int i = entity instanceof LivingEntity ? 3 : 0; // sets i to 3 if the Entity instance is an instance of BlazeEntity
        entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), (float)i); // deals damage
        }

    protected void onCollision(HitResult hitResult) { // called on collision with a block
        super.onCollision(hitResult);
        if (!this.world.isClient) { // checks if the world is client
            this.world.sendEntityStatus(this, (byte)3); // particle?
            this.kill(); // kills the projectile
        }

    }
}