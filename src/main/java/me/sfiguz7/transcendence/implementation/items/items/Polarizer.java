package me.sfiguz7.transcendence.implementation.items.items;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.sfiguz7.transcendence.lists.TEItems;
import me.sfiguz7.transcendence.lists.TERecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Polarizer extends SlimefunItem {

    public Polarizer(Type type) {
        super(TEItems.transcendence, type.slimefunItem, TERecipeType.NANOBOT_CRAFTER, type.recipe);
    }

    public enum Type {
        HORIZONTAL(TEItems.HORIZONTAL_POLARIZER,
                new int[]{10, 10, 40, 40},
                new ItemStack[]{TEItems.QUIRP_LEFT, TEItems.QUIRP_RIGHT}
        ),
        VERTICAL(TEItems.VERTICAL_POLARIZER,
                new int[]{40, 40, 10, 10},
                new ItemStack[]{TEItems.QUIRP_UP, TEItems.QUIRP_DOWN}
        );

        private final SlimefunItemStack slimefunItem;
        private final int[] chances;
        private final ItemStack[] recipe;

        Type(SlimefunItemStack slimefunItem, int[] chances, ItemStack[] quirps) {
            this.slimefunItem = slimefunItem;
            this.chances = chances;
            ItemStack rod = new ItemStack(Material.END_ROD);

            this.recipe = new ItemStack[]{
                    quirps[1], quirps[0], quirps[1],
                    quirps[0], rod, quirps[0],
                    quirps[1], quirps[0], quirps[1]};
        }
    }

    public static int[] getChances(Type type) {
        return type.chances;
    }
}