package net.thatoneaiguy.tomsword.item.Longswords;

import com.google.common.collect.ImmutableMultimap;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Rarity;
import net.thatoneaiguy.tomsword.item.ModItemGroup;

import java.util.UUID;


public class Diamond_Longsword extends SwordItem {
    public static final UUID ATTACK_RANGE_MODIFIER_ID = UUID.fromString("05869d86-c861-4954-9079-68c380ad063c");
    public Diamond_Longsword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    public Diamond_Longsword() {
        super(ToolMaterials.DIAMOND, 2, -2.4F,
                new FabricItemSettings().group(ModItemGroup.TOMSWORD));
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();

        builder.put(ReachEntityAttributes.ATTACK_RANGE, new EntityAttributeModifier(ATTACK_RANGE_MODIFIER_ID, "Weapon modifier", 6.0, EntityAttributeModifier.Operation.ADDITION));
    }
}
