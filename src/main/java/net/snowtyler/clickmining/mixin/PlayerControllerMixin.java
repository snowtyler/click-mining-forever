package net.snowtyler.clickmining.mixin;

import net.minecraft.client.player.controller.PlayerController;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.core.util.helper.Side;

@Mixin(value = PlayerController.class, remap = false)
public class PlayerControllerMixin {
	@Shadow
	protected int blockHitDelay;

	@Inject(method = "continueDestroyBlock", at = @At("TAIL"), remap = false)
	private void removeBlockBreakDelay(int x, int y, int z, Side side, double xHit, double yHit, CallbackInfo ci) {
		if (this.blockHitDelay > 0) {
			this.blockHitDelay = 0;
		}
	}
}
