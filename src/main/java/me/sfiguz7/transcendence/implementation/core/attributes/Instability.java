package me.sfiguz7.transcendence.implementation.core.attributes;

import org.bukkit.ChatColor;

/**
 * This enum holds all available levels of {@link Instability}.
 * The higher the level the more severe the effect of instability will be.
 *
 * @author TheBusyBiscuit
 * @see Unstable
 */
public enum Instability {

    /**
     * This represents a normal level of instability.
     * It will cause death faking an explosion and delete all unstable items from the ones dropped.
     */
    HIGH(ChatColor.DARK_GREEN);

    private final ChatColor color;

    Instability(ChatColor color) {
        this.color = color;
    }

    public String getLore() {
        return ChatColor.GRAY + "Instability level: " + color + toString().replace('_', ' ');
    }

    /**
     * This method returns the level for the instability effect to use in conjunction
     * with this level of {@link Unstable}.
     * <p>
     * It is basically the index of this enum constant.
     *
     * @return The level of radiation associated with this constant.
     */
    public int getInstabilityLevel() {
        return ordinal() + 1;
    }

}

