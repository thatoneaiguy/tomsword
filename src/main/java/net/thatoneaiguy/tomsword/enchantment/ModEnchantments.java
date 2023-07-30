package net.thatoneaiguy.tomsword.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.thatoneaiguy.tomsword.Tomsword;

public class ModEnchantments {
//    public static Enchantment WEAVING = register("weaving",
//           new WeavingEnchantment(Enchantment.Rarity.UNCOMMON,
//                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));
    public static Enchantment SOULE_PUNISHER = register("soule_punisher",
            new WeavingEnchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new Identifier(Tomsword.MOD_ID, name ), enchantment);
    }

    public static void registerModEnchantments() {
        System.out.println("Registering enchants for" + Tomsword.MOD_ID);
    }
}
