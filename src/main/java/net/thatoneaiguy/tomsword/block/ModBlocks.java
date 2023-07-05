package net.thatoneaiguy.tomsword.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.thatoneaiguy.tomsword.Tomsword;
import net.thatoneaiguy.tomsword.block.custom.ChocolateEgg;
import net.thatoneaiguy.tomsword.item.ModItemGroup;

public class ModBlocks {
    public static final Block CHOCOLATE_EGG = registerBlock("chocolate_egg",
            new ChocolateEgg(FabricBlockSettings.of(Material.STONE).breakInstantly().sounds(BlockSoundGroup.TUFF)), ModItemGroup.TOMSWORD);




    public static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(Tomsword.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(Tomsword.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }


    public static void registerModBlocks() {
        Tomsword.LOGGER.debug("Registering blocks for" + Tomsword.MOD_ID);

    }
}
