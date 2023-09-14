package net.thatoneaiguy.tomsword;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.thatoneaiguy.tomsword.enchantment.ModEnchantments;
//import net.thatoneaiguy.tomsword.entity.ShatterbladeEntity;
//import net.thatoneaiguy.tomsword.entity.ShatterbladeEntity;
import net.thatoneaiguy.tomsword.entity.CatalystEntity;
import net.thatoneaiguy.tomsword.item.ModItems;
import net.thatoneaiguy.tomsword.packet.C2SUseAndromeda;
import net.thatoneaiguy.tomsword.packet.S2CUseAndromedaPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tomsword implements ModInitializer {
	public static final String MOD_ID = "tomsword";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
		public static final Identifier BLOODWEAVER_EFFECT = new Identifier("tomsword:bloodweaver_effect");
	public static SoundEvent BLOODWEAVER_SOUNDS = new SoundEvent(BLOODWEAVER_EFFECT);

	public static final EntityType<CatalystEntity> CatalystEntityType = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier(MOD_ID, "catalystentity"),
			FabricEntityTypeBuilder.<CatalystEntity>create(SpawnGroup.MISC, CatalystEntity::new)
					.dimensions(EntityDimensions.fixed(6F, 0.8F))
					.fireImmune()
					.trackRangeBlocks(4).trackedUpdateRate(10)
					.build()

	);

	public static final DefaultParticleType CATALYST_BUBBLE_1 = FabricParticleTypes.simple();

	@Override
	public void onInitialize() {
		ModItems.registerModItems();

		ModEnchantments.registerModEnchantments();

		C2SUseAndromeda.register();

		Registry.register(Registry.SOUND_EVENT, Tomsword.BLOODWEAVER_EFFECT, BLOODWEAVER_SOUNDS);

		Registry.register(Registry.PARTICLE_TYPE, new Identifier("modid", "catalyst_bubble_1"), CATALYST_BUBBLE_1);

	}
}
