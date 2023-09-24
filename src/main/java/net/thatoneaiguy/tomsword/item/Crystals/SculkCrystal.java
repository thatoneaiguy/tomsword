package net.thatoneaiguy.tomsword.item.Crystals;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SculkCrystal extends Item {
    public SculkCrystal(Settings settings) {
        super(settings);
    }

    public boolean hasGlint(ItemStack stack){
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.literal("Many years ago, ancient guardians forged this").formatted(Formatting.DARK_BLUE));
            tooltip.add(Text.literal("crystal of sculk to tame the warden,").formatted(Formatting.DARK_BLUE));
            tooltip.add(Text.literal("but were not able to before ").formatted(Formatting.DARK_BLUE));
            tooltip.add(Text.literal("mass extinction, leading to the crystals to").formatted(Formatting.DARK_BLUE));
            tooltip.add(Text.literal("sit down here unattended, getting more").formatted(Formatting.DARK_BLUE));
            tooltip.add(Text.literal("and more unstable through the years").formatted(Formatting.DARK_BLUE));
        } else {
            tooltip.add(Text.literal("Press [Sneak] to show lore").formatted(Formatting.DARK_GRAY));
        }
        super.appendTooltip(stack, world, tooltip, context);

    }
}

