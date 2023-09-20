package net.thatoneaiguy.tomsword.item.Claymore;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
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
import net.minecraft.world.World;
import net.thatoneaiguy.tomsword.item.ModItemGroup;

public class Cookie_claymore extends SwordItem {
    public Cookie_claymore(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    public Cookie_claymore() {
        super(ToolMaterials.NETHERITE, 3, -2.4F,
                new FabricItemSettings().group(ModItemGroup.TOMSWORD).rarity(Rarity.RARE).fireproof());
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.getItemCooldownManager().set(this, 200);
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_BEACON_DEACTIVATE, SoundCategory.PLAYERS, 0.5F, 2F);


        if (user instanceof LivingEntity) {
            ((LivingEntity) user).addStatusEffect((new StatusEffectInstance(StatusEffects.REGENERATION, 100, 3)));
            ((LivingEntity) user).addStatusEffect((new StatusEffectInstance(StatusEffects.WEAKNESS, 100, 50)));



        }
        return TypedActionResult.success(itemStack, world.isClient);
    }
}

