package me.sfiguz7.transcendence.implementation.items;

import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactive;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.SlimefunPlugin;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.sfiguz7.transcendence.TranscEndencePlugin;
import me.sfiguz7.transcendence.implementation.core.attributes.Instability;
import me.sfiguz7.transcendence.implementation.core.attributes.Unstable;
import org.bukkit.inventory.ItemStack;

public class UnstableItem extends SlimefunItem implements Unstable {

    private final Instability instability;

    /**
     * This will create a new {@link io.github.thebusybiscuit.slimefun4.implementation.items.RadioactiveItem} with the given level of {@link Instability}
     *
     * @param category
     *            The {@link Category} of this {@link SlimefunItem}
     * @ param instability
     *            the level of {@link Instability}
     * @param item
     *            the {@link SlimefunItemStack} this {@link SlimefunItem} represents
     * @param recipeType
     *            The {@link RecipeType} for this item
     * @param recipe
     *            The recipe of how to craft this {@link SlimefunItem}
     */
    public UnstableItem(Category category, Instability instability, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);

        this.instability = instability;
    }

    public Instability getInstability() {
        return instability;
    }

    @Override
    public void postRegister() {
        TranscEndencePlugin.getRegistry().getUnstableItems().add(this);
    }

}

