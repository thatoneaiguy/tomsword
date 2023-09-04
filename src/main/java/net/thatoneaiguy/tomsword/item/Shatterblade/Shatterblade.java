package net.thatoneaiguy.tomsword.item.Shatterblade;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
//import net.thatoneaiguy.tomsword.entity.ShatterbladeEntity;
import net.thatoneaiguy.tomsword.item.ModItemGroup;

public class Shatterblade extends SwordItem {
    private static final int COOLDOWN_DURATION = 20;
    private int cooldownTicks = 0;



    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.getItemCooldownManager().set(this, 20);
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.PLAYERS, 0.5F, 0.5F);

            if (!world.isClient) {
        }
        return TypedActionResult.success(itemStack, world.isClient);
    }

    public Shatterblade() {
        super(ToolMaterials.NETHERITE, 3, -2.4F,
                new FabricItemSettings().group(ModItemGroup.TOMSWORD).rarity(Rarity.RARE));
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {if (cooldownTicks > 0) {cooldownTicks--;
    }
        super.inventoryTick(stack, world, entity, slot, selected);
    }


}




