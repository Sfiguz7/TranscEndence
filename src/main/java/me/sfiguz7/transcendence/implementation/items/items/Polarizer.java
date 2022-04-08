package me.sfiguz7.transcendence.implementation.items.items;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import me.sfiguz7.transcendence.TranscEndence;
import me.sfiguz7.transcendence.lists.TEItems;
import me.sfiguz7.transcendence.lists.TERecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Polarizer extends SlimefunItem {

    public Polarizer(Type type) {
        super(TEItems.transcendence, type.slimefunItem, TERecipeType.NANOBOT_CRAFTER, type.recipe);
    }

    public static int[] getChances(Type type) {
        return type.chances;
    }

    public enum Type {
        VERTICAL(TEItems.VERTICAL_POLARIZER,
            getPolarizedChances(true),
            new ItemStack[] {TEItems.QUIRP_UP, TEItems.QUIRP_DOWN}
        ),
        HORIZONTAL(TEItems.HORIZONTAL_POLARIZER,
            getPolarizedChances(false),
            new ItemStack[] {TEItems.QUIRP_LEFT, TEItems.QUIRP_RIGHT}
        );

        private final SlimefunItemStack slimefunItem;
        private final int[] chances;
        private final ItemStack[] recipe;

        Type(SlimefunItemStack slimefunItem, int[] chances, ItemStack[] quirps) {
            this.slimefunItem = slimefunItem;
            this.chances = chances;
            ItemStack rod = new ItemStack(Material.END_ROD);

            this.recipe = new ItemStack[] {
                quirps[1], quirps[0], quirps[1],
                quirps[0], rod, quirps[0],
                quirps[1], quirps[0], quirps[1]};
        }

        private static int[] getPolarizedChances(boolean vertical) {
            TranscEndence inst = TranscEndence.getInstance();
            int highchance = inst.getHighchance();

            if (vertical) {
                return new int[] {highchance, highchance, 50 - highchance, 50 - highchance};
            }
            return new int[] {50 - highchance, 50 - highchance, highchance, highchance};
        }
    }
}
