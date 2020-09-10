package me.sfiguz7.transcendence.implementation.items.items;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.sfiguz7.transcendence.implementation.items.UnstableItem;
import me.sfiguz7.transcendence.lists.TEItems;
import me.sfiguz7.transcendence.lists.TERecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class UnstableIngots extends UnstableItem {

    public UnstableIngots(Type type) {
        super(TEItems.transcendence, type.slimefunItem,
            type == Type.FULL ? TERecipeType.NANOBOT_CRAFTER : TERecipeType.STABILIZER, type.recipe);
    }

    public enum Type {
        FULL(TEItems.UNSTABLE_INGOT,
            new ItemStack[] {SlimefunItems.BLISTERING_INGOT_3, TEItems.QUIRP_UP, SlimefunItems.BLISTERING_INGOT_3,
                TEItems.QUIRP_LEFT, new ItemStack(Material.DIAMOND_BLOCK), TEItems.QUIRP_RIGHT,
                SlimefunItems.BLISTERING_INGOT_3, TEItems.QUIRP_DOWN, SlimefunItems.BLISTERING_INGOT_3
            }
        ),
        SEVENTYFIVE(TEItems.UNSTABLE_INGOT_2, TEItems.UNSTABLE_INGOT
        ),
        FIFTY(TEItems.UNSTABLE_INGOT_3, TEItems.UNSTABLE_INGOT_2
        ),
        TWENTYFIVE(TEItems.UNSTABLE_INGOT_4, TEItems.UNSTABLE_INGOT_3
        );

        private final SlimefunItemStack slimefunItem;
        private final ItemStack[] recipe;

        Type(SlimefunItemStack slimefunItem, ItemStack[] recipe) {
            this.slimefunItem = slimefunItem;
            this.recipe = recipe;
        }

        Type(SlimefunItemStack slimefunItem, ItemStack prevIngot) {
            this(slimefunItem, new ItemStack[] {
                prevIngot, TEItems.QUIRP_CONDENSATE, null,
                null, null, null,
                null, null, null
            });
        }
    }
}
