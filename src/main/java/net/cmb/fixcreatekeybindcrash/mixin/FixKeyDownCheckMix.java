package net.cmb.fixcreatekeybindcrash.mixin;

import com.mojang.blaze3d.platform.InputConstants;
import com.simibubi.create.AllKeys;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AllKeys.class)
@Debug(export = true)
public class FixKeyDownCheckMix {
    @Inject(method = "isKeyDown",at = @At("HEAD"), cancellable = true)
    private static void isKeyDownFix(int key, CallbackInfoReturnable<Boolean> cir){
        if(key <= GLFW.GLFW_KEY_UNKNOWN || !Minecraft.getInstance().isSameThread()){
            cir.setReturnValue(false);
        }
        else{
            cir.setReturnValue(InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), key));
        }
        cir.cancel();
    }
}
