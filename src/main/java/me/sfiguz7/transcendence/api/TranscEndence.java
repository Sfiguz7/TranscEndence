package me.sfiguz7.transcendence.api;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.SlimefunPlugin;
import org.bukkit.entity.Player;

public class TranscEndence {

    public static boolean isEnabled(Player p, SlimefunItem sfItem, boolean message) {
        if (sfItem.isDisabled()) {
            if (message) {
                SlimefunPlugin.getLocal().sendMessage(p, "messages.disabled-in-world", true);
            }

            return false;
        }/* else {
            String world = p.getWorld().getName();
            if (SlimefunPlugin.getWhitelist().contains(world + ".enabled")) {
                if (SlimefunPlugin.getWhitelist().getBoolean(world + ".enabled")) {
                    if (!SlimefunPlugin.getWhitelist().contains(world + ".enabled-items." + sfItem.getID())) {
                        SlimefunPlugin.getWhitelist().setDefaultValue(world + ".enabled-items." + sfItem.getID(), true);
                    }

                    if (SlimefunPlugin.getWhitelist().getBoolean(world + ".enabled-items." + sfItem.getID())) {
                        return true;
                    } else {
                        if (message) {
                            SlimefunPlugin.getLocal().sendMessage(p, "messages.disabled-in-world", true);
                        }

                        return false;
                    }
                } else {
                    if (message) {
                        SlimefunPlugin.getLocal().sendMessage(p, "messages.disabled-in-world", true);
                    }

                    return false;
                }
            } else {
                return true;
            }
        }*/
        return true;
    }
}
