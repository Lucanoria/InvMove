package me.pieking1215.invmove.module;

import me.pieking1215.invmove.InvMove;
import me.pieking1215.invmove.module.config.ModuleConfig;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public interface Module {
    @SuppressWarnings("SameReturnValue")
    String getId();
    default Component getTitle() {
        return InvMove.instance().translatableComponent("key.invmove.module." + getId());
    }
    Movement shouldAllowMovement(Screen screen);
    Background shouldHideBackground(Screen screen);
    ModuleConfig getMovementConfig();
    ModuleConfig getBackgroundConfig();

    enum Movement {
        /** no suggestion */
        PASS,
        /** suggest allowing, but other modules can override */
        SUGGEST_ENABLE,
        /** suggest disallowing, but other modules can override */
        SUGGEST_DISABLE,
        /** forcefully allow */
        FORCE_ENABLE,
        /** forcefully disallow */
        FORCE_DISABLE,
    }

    enum Background {
        /** no suggestion */
        PASS,
        /** suggest showing, but other modules can override */
        SUGGEST_SHOW,
        /** suggest hiding, but other modules can override */
        SUGGEST_HIDE,
        /** forcefully show */
        FORCE_SHOW,
        /** forcefully hide */
        FORCE_HIDE,
    }
}
