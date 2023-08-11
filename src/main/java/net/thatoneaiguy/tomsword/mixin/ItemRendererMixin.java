package net.thatoneaiguy.tomsword.mixin;

import net.minecraft.client.render.model.json.ModelTransformation.Mode;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemModels;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.thatoneaiguy.tomsword.item.ModItems;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {
    private static final ModelIdentifier DIA_INVENTORY_MODEL = new ModelIdentifier("tomsword:smoldia#inventory");
    private static final ModelIdentifier NETH_INVENTORY_MODEL = new ModelIdentifier("tomsword:smolneth#inventory");
    private static final ModelIdentifier BLOOD_INVENTORY_MODEL = new ModelIdentifier("tomsword:smolblood#inventory");

    @Shadow
    private @Final ItemModels models;

    @ModifyVariable(method = "renderItem", at = @At("HEAD"), argsOnly = true)
    private BakedModel tomsword_guiModel(BakedModel model, ItemStack stack, Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, BakedModel modelAgain) {
        boolean bl = renderMode == Mode.GUI || renderMode == Mode.GROUND || renderMode == Mode.FIXED;
        if (bl) {
            if (stack.isOf(ModItems.DIAMOND_LONGSWORD)) {
                return models.getModelManager().getModel(DIA_INVENTORY_MODEL);
            }
        }
        if (bl) {
            if (stack.isOf(ModItems.NETHERITE_LONGSWORD)) {
                return models.getModelManager().getModel(NETH_INVENTORY_MODEL);
            }
        }
        if (bl) {
            if (stack.isOf(ModItems.BLOODWEAVER)) {
                return models.getModelManager().getModel(BLOOD_INVENTORY_MODEL);
            }
        }


        return model;
    }
}

