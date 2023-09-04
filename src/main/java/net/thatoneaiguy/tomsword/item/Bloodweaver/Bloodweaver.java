package net.thatoneaiguy.tomsword.item.Bloodweaver;

import ladysnake.pickyourpoison.common.PickYourPoison;
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
import net.thatoneaiguy.tomsword.Tomsword;
import net.thatoneaiguy.tomsword.item.ModItemGroup;


public class Bloodweaver extends SwordItem {
    public Bloodweaver(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    public Bloodweaver() {
        super(ToolMaterials.NETHERITE, 3, -2.4F,
                new FabricItemSettings().group(ModItemGroup.TOMSWORD).rarity(Rarity.RARE));
    }

   @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        user.getItemCooldownManager().set(this, 1200);
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_RESPAWN_ANCHOR_SET_SPAWN, SoundCategory.PLAYERS, 1F, 1F);

        if (user instanceof LivingEntity) {
            ((LivingEntity) user).addStatusEffect((new StatusEffectInstance(PickYourPoison.BATRACHOTOXIN, 600, 2)));
            ((LivingEntity) user).addStatusEffect((new StatusEffectInstance(PickYourPoison.TORPOR, 600, 1)));
            ((LivingEntity) user).addStatusEffect((new StatusEffectInstance(PickYourPoison.VULNERABILITY, 600, 1)));
            world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_RESPAWN_ANCHOR_DEPLETE, SoundCategory.PLAYERS, 0.5F, 1);

        }
        return TypedActionResult.success(itemStack, world.isClient);
    }
}
