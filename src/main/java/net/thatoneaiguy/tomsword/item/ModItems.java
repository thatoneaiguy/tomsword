package net.thatoneaiguy.tomsword.item;

import dev.emi.trinkets.api.TrinketItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.thatoneaiguy.tomsword.Tomsword;
import net.thatoneaiguy.tomsword.item.Andromeda.Andromeda;
import net.thatoneaiguy.tomsword.item.Bloodweaver.Bloodweaver;
import net.thatoneaiguy.tomsword.item.Catalyst.Catalyst;
import net.thatoneaiguy.tomsword.item.Claymore.Cookie_claymore;
import net.thatoneaiguy.tomsword.item.Longswords.Diamond_Longsword;
import net.thatoneaiguy.tomsword.item.Shatterblade.Shatterblade;

public class ModItems {
    public static final Item DIAMOND_LONGSWORD = registerItem("diamond_longsword", new Diamond_Longsword());
    public static final Item NETHERITE_LONGSWORD = registerItem("netherite_longsword",
            new SwordItem(ToolMaterials.DIAMOND, 5, -2.8F, new FabricItemSettings().group(ModItemGroup.TOMSWORD)));
    public static final Item BLOODWEAVER = registerItem("bloodweaver", new Bloodweaver());
    public static final Item SHATTERBLADE = registerItem("shatterblade", new Shatterblade());
    public static final Item ANDROMEDA_CORE = registerItem("andromeda_core",
            new Item(new FabricItemSettings().group(ModItemGroup.TOMSWORD).rarity(Rarity.EPIC)));
    public static final Item ANDROMEDA = registerItem("andromeda", new Andromeda());
    public static final Item STARWEAVER = registerItem("starweaver",
            new SwordItem(ToolMaterials.NETHERITE, 3, -2.4F, new FabricItemSettings().group(ModItemGroup.TOMSWORD).rarity(Rarity.EPIC)));
    public static final Item COOKIE_CLAYMORE = registerItem("cookie_claymore", new Cookie_claymore());
    public static final Item NETHGSWORD = registerItem("nethgsword",
            new SwordItem(ToolMaterials.NETHERITE, 21, -3.5F, new FabricItemSettings().group(ModItemGroup.TOMSWORD)));
    public static final Item CATALYST = registerItem("catalyst", new Catalyst());



    public static final Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Tomsword.MOD_ID, name), item);


    }

    public static void registerModItems() {
        Tomsword.LOGGER.debug("Registering items for" + Tomsword.MOD_ID);
    }
}