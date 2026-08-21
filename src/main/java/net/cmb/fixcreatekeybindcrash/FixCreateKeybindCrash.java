package net.cmb.fixcreatekeybindcrash;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

@Mod(FixCreateKeybindCrash.MODID)
public class FixCreateKeybindCrash {
    public static final String MODID = "fixcreatekeybindcrash";
    public FixCreateKeybindCrash(IEventBus modEventBus, ModContainer modContainer) {
        FixCreateKeybindCrashConfig.registerCommon(modContainer);
    }
}
