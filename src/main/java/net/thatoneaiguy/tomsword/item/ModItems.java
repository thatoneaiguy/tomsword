package net.thatoneaiguy.tomsword.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.thatoneaiguy.tomsword.Tomsword;

public class ModItems {
    public static final Item ECHO = registerItem("echo",
            new Item(new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item DIAMOND_LONGSWORD = registerItem("diamond_longsword",
            new Item(new FabricItemSettings().group(ItemGroup.COMBAT)));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Tomsword.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Tomsword.LOGGER.debug("Registering items for" + Tomsword.MOD_ID);
    }
}
