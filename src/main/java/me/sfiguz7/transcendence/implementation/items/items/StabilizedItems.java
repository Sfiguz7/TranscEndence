package me.sfiguz7.transcendence.implementation.items.items;

import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.sfiguz7.transcendence.lists.TEItems;
import me.sfiguz7.transcendence.lists.TERecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class StabilizedItems extends SlimefunItem {

    public StabilizedItems(Type type) {
        super(TEItems.transcendence, type.slimefunItem, type.recipeType, type.recipe);
    }

    public enum Type {
        INGOT(TEItems.STABLE_INGOT,
                new ItemStack[]{SlimefunItems.BLISTERING_INGOT_3, TEItems.QUIRP_UP, SlimefunItems.BLISTERING_INGOT_3,
                        TEItems.QUIRP_LEFT, new ItemStack(Material.DIAMOND_BLOCK), TEItems.QUIRP_RIGHT,
                        SlimefunItems.BLISTERING_INGOT_3, TEItems.QUIRP_DOWN, SlimefunItems.BLISTERING_INGOT_3
                },
                TERecipeType.STABILIZER
        ),
        BLOCK(TEItems.STABLE_BLOCK,
                new ItemStack[]{TEItems.STABLE_INGOT, TEItems.STABLE_INGOT, TEItems.STABLE_INGOT,
                        TEItems.STABLE_INGOT, TEItems.STABLE_INGOT, TEItems.STABLE_INGOT,
                        TEItems.STABLE_INGOT, TEItems.STABLE_INGOT, TEItems.STABLE_INGOT
                },
                TERecipeType.NANOBOT_CRAFTER
        );

        private final SlimefunItemStack slimefunItem;
        private final ItemStack[] recipe;
        private final RecipeType recipeType;

        Type(SlimefunItemStack slimefunItem, ItemStack[] recipe, RecipeType recipeType) {
            this.slimefunItem = slimefunItem;
            this.recipe = recipe;
            this.recipeType = recipeType;
        }
    }
}
