package me.sfiguz7.transcendence.implementation.quirps.machines;

import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.sfiguz7.transcendence.Lists.TranscendenceItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public abstract class QuirpCycler extends AContainer implements RecipeDisplayItem {

    public QuirpCycler(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Override
    protected void registerDefaultRecipes() {

        registerRecipe(8, new ItemStack[]{TranscendenceItems.QUIRP_UP},
                new ItemStack[]{TranscendenceItems.QUIRP_RIGHT});
        registerRecipe(8, new ItemStack[]{TranscendenceItems.QUIRP_RIGHT},
                new ItemStack[]{TranscendenceItems.QUIRP_DOWN});
        registerRecipe(8, new ItemStack[]{TranscendenceItems.QUIRP_DOWN},
                new ItemStack[]{TranscendenceItems.QUIRP_LEFT});
        registerRecipe(8, new ItemStack[]{TranscendenceItems.QUIRP_LEFT},
                new ItemStack[]{TranscendenceItems.QUIRP_UP});

    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.SHIELD);
    }

    @Override
    public String getInventoryTitle() {
        return "&cQuirp Cycler";
    }

    @Override
    public String getMachineIdentifier() {
        return "QUIRP_CYCLER";
    }

    @Override
    public int getCapacity() {
        return 1024;
    }

}
