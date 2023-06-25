package net.thatoneaiguy.tomsword.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.thatoneaiguy.tomsword.Tomsword;

public class ModItemGroup {
    public static final ItemGroup TOMSWORD = FabricItemGroupBuilder.build(
            new Identifier(Tomsword.MOD_ID, "tomsword"), () -> new ItemStack(ModItems.DIAMOND_LONGSWORD));
}
