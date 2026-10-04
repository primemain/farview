package com.farview.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientChunkCache;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ClientChunkCache.class)
public abstract class ClientChunkCacheMixin {
	private static int farview$mine(int serverValue) {
		return Math.max(serverValue, Minecraft.getInstance().options.renderDistance().get());
	}

	@ModifyVariable(method = "<init>", at = @At("HEAD"), argsOnly = true, ordinal = 0)
	private static int farview$ctorRadius(int serverRadius) {
		return farview$mine(serverRadius);
	}

	@ModifyVariable(method = "updateViewRadius", at = @At("HEAD"), argsOnly = true, ordinal = 0)
	private int farview$updateRadius(int radius) {
		return farview$mine(radius);
	}
}
