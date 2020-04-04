package me.sfiguz7.transcendence.implementation.core.attributes;

import io.github.thebusybiscuit.slimefun4.core.attributes.ItemAttribute;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;

/**
 * This Interface, when attached to a class that inherits from {@link me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem}, marks
 * the Item as unstable.
 * Carrying such an item will cause the player to explode after few seconds.
 * <p>
 * You can specify a level of {@link Radioactivity} for the severity of the effect.
 *
 * @author TheBusyBiscuit
 */
public interface Unstable extends ItemAttribute {

    /**
     * This method returns the level of {@link Instability} for this {@link Unstable} item.
     * Higher levels not implemented yet.
     *
     * @return The level of {@link Instability} of this item.
     */
    Instability getInstability();

}
