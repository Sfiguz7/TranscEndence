package me.sfiguz7.transcendence.implementation.quirps.machines;

import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.sfiguz7.transcendence.Lists.TranscendenceItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public abstract class Stabilizer extends AContainer implements RecipeDisplayItem {

    public Stabilizer(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Override
    protected void registerDefaultRecipes() {

        registerRecipe(8, new ItemStack[]{TranscendenceItems.UNSTABLE_INGOT, TranscendenceItems.QUIRP_CONDENSATE},
                new ItemStack[]{TranscendenceItems.UNSTABLE_INGOT_2});
        registerRecipe(8, new ItemStack[]{TranscendenceItems.UNSTABLE_INGOT_2, TranscendenceItems.QUIRP_CONDENSATE},
                new ItemStack[]{TranscendenceItems.UNSTABLE_INGOT_3});
        registerRecipe(8, new ItemStack[]{TranscendenceItems.UNSTABLE_INGOT_3, TranscendenceItems.QUIRP_CONDENSATE},
                new ItemStack[]{TranscendenceItems.UNSTABLE_INGOT_4});
        registerRecipe(8, new ItemStack[]{TranscendenceItems.UNSTABLE_INGOT_4, TranscendenceItems.QUIRP_CONDENSATE},
                new ItemStack[]{TranscendenceItems.STABLE_INGOT});

    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.SHIELD);
    }

    @Override
    public String getInventoryTitle() {
        return "&cStabilizer";
    }

    @Override
    public String getMachineIdentifier() {
        return "STABILIZER";
    }

    @Override
    public int getCapacity() {
        return 1024;
    }

}
