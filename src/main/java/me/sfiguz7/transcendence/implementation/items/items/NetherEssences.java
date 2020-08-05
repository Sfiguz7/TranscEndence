package me.sfiguz7.transcendence.implementation.items.items;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.sfiguz7.transcendence.lists.Constants;
import me.sfiguz7.transcendence.lists.TEItems;
import me.sfiguz7.transcendence.lists.TERecipeType;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class NetherEssences extends SlimefunItem {

    public NetherEssences(Type type) {
        super(TEItems.transcendence, type.slimefunItem, TERecipeType.NANOBOT_CRAFTER, type.recipe);
    }

    public enum Type {
        NORMAL(TEItems.NETHER_ESSENCE, new ItemStack(Material.NETHER_STAR)
        ),
        CONDENSED(TEItems.CONDENSED_NETHER_ESSENCE, TEItems.NETHER_ESSENCE
        ),
        PURE(TEItems.PURE_NETHER_ESSENCE, TEItems.CONDENSED_NETHER_ESSENCE
        );

        private final SlimefunItemStack slimefunItem;
        private final ItemStack[] recipe;

        Type(SlimefunItemStack slimefunItem, ItemStack ingredient) {
            slimefunItem.addUnsafeEnchantment(Enchantment.getByKey(Constants.SHINY_ENCHANTMENT), 1);
            this.slimefunItem = slimefunItem;
            this.recipe = new ItemStack[] {
                ingredient, ingredient, ingredient,
                ingredient, ingredient, ingredient,
                ingredient, ingredient, ingredient
            };
        }
    }
}