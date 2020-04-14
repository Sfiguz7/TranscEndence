package me.sfiguz7.transcendence.implementation.items.machines;

import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.sfiguz7.transcendence.lists.TranscendenceItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public abstract class QuirpAnnihilator extends AContainer implements RecipeDisplayItem {

    public QuirpAnnihilator(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Override
    protected void registerDefaultRecipes() {

        registerRecipe(8, new ItemStack[]{TranscendenceItems.QUIRP_UP, TranscendenceItems.QUIRP_DOWN},
                new ItemStack[]{TranscendenceItems.QUIRP_CONDENSATE});
        registerRecipe(8, new ItemStack[]{TranscendenceItems.QUIRP_LEFT, TranscendenceItems.QUIRP_RIGHT},
                new ItemStack[]{TranscendenceItems.QUIRP_CONDENSATE});

    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.SHIELD);
    }

    @Override
    public String getInventoryTitle() {
        return "&cQuirp Annihilator";
    }

    @Override
    public String getMachineIdentifier() {
        return "QUIRP_ANNIHILATOR";
    }

    @Override
    public int getCapacity() {
        return 1024;
    }

}


