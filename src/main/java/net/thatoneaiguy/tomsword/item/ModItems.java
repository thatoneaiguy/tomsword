package net.thatoneaiguy.tomsword.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.thatoneaiguy.tomsword.Tomsword;

public class ModItems {
    public static final Item ECHO = registerItem("echo",
            new SwordItem(ToolMaterials.DIAMOND, 4, -2.8F, new FabricItemSettings().group(ModItemGroup.TOMSWORD)));
    public static final Item DIAMOND_LONGSWORD = registerItem("diamond_longsword",
            new SwordItem(ToolMaterials.DIAMOND, 3, -2.8F, new FabricItemSettings().group(ModItemGroup.TOMSWORD)));
    public static final Item NETHERITE_LONGSWORD = registerItem("netherite_longsword",
            new SwordItem(ToolMaterials.NETHERITE, 3, -2.8F, new FabricItemSettings().group(ModItemGroup.TOMSWORD)));
    public static final Item BLOODWEAVER = registerItem("bloodweaver",
            new SwordItem(ToolMaterials.NETHERITE, 3, -2.4F, new FabricItemSettings().group(ModItemGroup.TOMSWORD)));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Tomsword.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Tomsword.LOGGER.debug("Registering items for" + Tomsword.MOD_ID);
    }
}
