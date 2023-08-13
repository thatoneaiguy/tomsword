package net.thatoneaiguy.tomsword;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.thatoneaiguy.tomsword.enchantment.ModEnchantments;
import net.thatoneaiguy.tomsword.entity.ShatterbladeEntity;
import net.thatoneaiguy.tomsword.item.ModItems;
import net.thatoneaiguy.tomsword.packet.C2SUseAndromeda;
import net.thatoneaiguy.tomsword.packet.S2CUseAndromedaPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tomsword implements ModInitializer {
	public static final String MOD_ID = "tomsword";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final EntityType<ShatterbladeEntity> BLADES = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier(MOD_ID, "blades"),
			FabricEntityTypeBuilder.<ShatterbladeEntity>create(SpawnGroup.MISC, ShatterbladeEntity::new)
					.dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
					.trackRangeBlocks(4).trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
					.build() // VERY IMPORTANT DONT DELETE FOR THE LOVE OF GOD PSLSSSSSS
	);
	@Override
	public void onInitialize() {
		ModItems.registerModItems();

		ModEnchantments.registerModEnchantments();

		C2SUseAndromeda.register();
	}
}
