package net.thatoneaiguy.tomsword;

import net.fabricmc.api.ModInitializer;
import net.thatoneaiguy.tomsword.enchantment.ModEnchantments;
import net.thatoneaiguy.tomsword.item.ModItems;
import net.thatoneaiguy.tomsword.packet.C2SUseAndromeda;
import net.thatoneaiguy.tomsword.packet.S2CUseAndromedaPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tomsword implements ModInitializer {
	public static final String MOD_ID = "tomsword";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();

		ModEnchantments.registerModEnchantments();

		C2SUseAndromeda.register();
	}
}
