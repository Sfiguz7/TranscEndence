package me.sfiguz7.transcendence.implementation.items.machines;

import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.sfiguz7.transcendence.lists.TEItems;
import me.sfiguz7.transcendence.lists.TERecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class QuirpCycler extends AContainer implements RecipeDisplayItem {

    public QuirpCycler() {
        super(TEItems.transcendence, TEItems.QUIRP_CYCLER, TERecipeType.NANOBOT_CRAFTER,
                new ItemStack[]{TEItems.QUIRP_CONDENSATE, TEItems.QUIRP_UP, TEItems.QUIRP_CONDENSATE,
                        TEItems.QUIRP_LEFT, TEItems.QUIRP_OSCILLATOR, TEItems.QUIRP_RIGHT,
                        TEItems.QUIRP_CONDENSATE, TEItems.QUIRP_DOWN, TEItems.QUIRP_CONDENSATE});
    }

    @Override
    protected void registerDefaultRecipes() {

        registerRecipe(8, new ItemStack[]{TEItems.QUIRP_UP},
                new ItemStack[]{TEItems.QUIRP_RIGHT});
        registerRecipe(8, new ItemStack[]{TEItems.QUIRP_RIGHT},
                new ItemStack[]{TEItems.QUIRP_DOWN});
        registerRecipe(8, new ItemStack[]{TEItems.QUIRP_DOWN},
                new ItemStack[]{TEItems.QUIRP_LEFT});
        registerRecipe(8, new ItemStack[]{TEItems.QUIRP_LEFT},
                new ItemStack[]{TEItems.QUIRP_UP});

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

    @Override
    public int getEnergyConsumption() {
        return 256;
    }

    @Override
    public int getSpeed() {
        return 1;
    }

}
