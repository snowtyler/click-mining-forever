package net.fabricmc.example.mixin;

import net.minecraft.SingleplayerInteractionManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SingleplayerInteractionManager.class)
public class SingleplayerInteractionManagerMixin {
	@Shadow
	private int field_2187;

	@Inject(method = "method_1721", at = @At("TAIL"))
	private void removeBlockBreakDelay(int i, int j, int k, int l, CallbackInfo ci) {
		if (this.field_2187 > 0) {
			this.field_2187 = 0;
		}
	}
}
