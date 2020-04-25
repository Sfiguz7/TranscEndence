package me.sfiguz7.transcendence.api;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.SlimefunPlugin;
import org.bukkit.entity.Player;

public final class TranscEndence {

    private TranscEndence(){}

    public static boolean isEnabled(Player p, SlimefunItem sfItem, boolean message) {
        if (sfItem.isDisabled()) {
            if (message) {
                SlimefunPlugin.getLocal().sendMessage(p, "messages.disabled-in-world", true);
            }

            return false;
        }
        return true;
    }
}
