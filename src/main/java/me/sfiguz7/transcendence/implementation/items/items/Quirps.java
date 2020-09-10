package me.sfiguz7.transcendence.implementation.items.items;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.sfiguz7.transcendence.lists.TEItems;
import me.sfiguz7.transcendence.lists.TERecipeType;
import org.bukkit.inventory.ItemStack;

public class Quirps extends SlimefunItem {

    public Quirps(Type type) {
        super(TEItems.transcendence, type.slimefunItem,
            type == Type.CONDENSATE ? TERecipeType.QUIRP_ANNIHILATOR : TERecipeType.QUIRP_OSCILLATOR,
            type.recipe);
    }

    public enum Type {
        UP(TEItems.QUIRP_UP
        ),
        DOWN(TEItems.QUIRP_DOWN
        ),
        LEFT(TEItems.QUIRP_LEFT
        ),
        RIGHT(TEItems.QUIRP_RIGHT
        ),
        CONDENSATE(TEItems.QUIRP_CONDENSATE
        );

        private final SlimefunItemStack slimefunItem;
        private final ItemStack[] recipe;

        Type(SlimefunItemStack slimefunItem) {
            this.slimefunItem = slimefunItem;

            this.recipe = new ItemStack[] {
                null, null, null,
                null, null, null,
                null, null, null};
        }
    }
}
