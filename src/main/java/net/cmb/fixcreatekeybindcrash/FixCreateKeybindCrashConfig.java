package net.cmb.fixcreatekeybindcrash;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

public class FixCreateKeybindCrashConfig {
    public static final ModConfigSpec.Builder COMMON = new ModConfigSpec.Builder();

    public static ModConfigSpec.BooleanValue VERBOSE_KEYBIND_ERRORS;

    public static void registerCommon(ModContainer container){
        COMMON.comment("Common Config").push("Logging");
        VERBOSE_KEYBIND_ERRORS = COMMON.translation("config.common.fixcreatekeybindcrashconfig.title").define("verbose_keybind_errors",
                false);
        COMMON.pop();
        container.registerConfig(ModConfig.Type.COMMON,COMMON.build());
    }
}
