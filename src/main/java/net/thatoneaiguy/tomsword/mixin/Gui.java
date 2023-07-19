/*package net.thatoneaiguy.tomsword.mixin;

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
    private static final ModelIdentifier INVENTORY_MODEL = new ModelIdentifier("tomsword", "item/smoldia", "inventory");
    @Shadow
    private @Final ItemModels models;

    @ModifyVariable(method = "renderItem", at = @At("HEAD"), argsOnly = true)
    private BakedModel modid_guiModel(BakedModel model, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, BakedModel modelAgain) {
        boolean bl = renderMode == ModelTransformationMode.GUI || renderMode == ModelTransformationMode.GROUND || renderMode == ModelTransformationMode.FIXED;
        if (bl) {
            if (stack.isOf(ModItems.DIAMOND_LONGSWORD)) {
                return models.getModelManager().getModel(INVENTORY_MODEL);
            }
        }
        return model;
    }
}*/