package com.farview.mixin;

import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.protocol.game.ClientboundForgetLevelChunkPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPacketListener.class)
public abstract class ClientPacketListenerMixin {
	@Inject(method = "handleForgetLevelChunk", at = @At("HEAD"), cancellable = true)
	private void farview$keepChunk(ClientboundForgetLevelChunkPacket packet, CallbackInfo ci) {
		ci.cancel();
	}
}
