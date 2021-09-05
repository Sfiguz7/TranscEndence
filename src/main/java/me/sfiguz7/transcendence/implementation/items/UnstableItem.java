package me.sfiguz7.transcendence.implementation.items;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.sfiguz7.transcendence.TranscEndence;
import org.bukkit.inventory.ItemStack;

public class UnstableItem extends SlimefunItem {

    public UnstableItem(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Override
    public void postRegister() {
        TranscEndence.getRegistry().getUnstableItems().add(this);
    }

}

