package com.farview.mixin;

import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Options.class)
public abstract class OptionsMixin {
	@Shadow
	private OptionInstance<Integer> renderDistance;

	@Inject(method = "getEffectiveRenderDistance", at = @At("HEAD"), cancellable = true)
	private void farview$useMyDistance(CallbackInfoReturnable<Integer> cir) {
		cir.setReturnValue(this.renderDistance.get());
	}
}
