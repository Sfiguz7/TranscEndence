package me.sfiguz7.transcendence.implementation.items.generators;

import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AGenerator;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineFuel;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static me.sfiguz7.transcendence.lists.TranscendenceItems.QUIRP_CONDENSATE;
import static me.sfiguz7.transcendence.lists.TranscendenceItems.QUIRP_DOWN;
import static me.sfiguz7.transcendence.lists.TranscendenceItems.QUIRP_LEFT;
import static me.sfiguz7.transcendence.lists.TranscendenceItems.QUIRP_RIGHT;
import static me.sfiguz7.transcendence.lists.TranscendenceItems.QUIRP_UP;

public abstract class QuirpScatterer extends AGenerator {

    public QuirpScatterer(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Override
    protected void registerDefaultFuelTypes() {
        registerFuel(new MachineFuel(8, QUIRP_CONDENSATE));
        registerFuel(new MachineFuel(1, QUIRP_UP));
        registerFuel(new MachineFuel(1, QUIRP_DOWN));
        registerFuel(new MachineFuel(1, QUIRP_LEFT));
        registerFuel(new MachineFuel(1, QUIRP_RIGHT));
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.FLINT_AND_STEEL);
    }

    @Override
    public String getInventoryTitle() {
        return "&cQuirp Scatterer";
    }

}