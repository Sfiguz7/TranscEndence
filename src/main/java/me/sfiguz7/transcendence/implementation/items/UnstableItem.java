package me.sfiguz7.transcendence.implementation.items;

import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.sfiguz7.transcendence.TranscEndence;
import org.bukkit.inventory.ItemStack;

public class UnstableItem extends SlimefunItem {

    public UnstableItem(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Override
    public void postRegister() {
        TranscEndence.getRegistry().getUnstableItems().add(this);
    }

}

