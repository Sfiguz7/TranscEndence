package me.sfiguz7.transcendence.implementation.items.machines;

import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.sfiguz7.transcendence.lists.TEItems;
import me.sfiguz7.transcendence.lists.TERecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class QuirpAnnihilator extends AContainer implements RecipeDisplayItem {

    public QuirpAnnihilator() {
        super(TEItems.transcendence, TEItems.QUIRP_OSCILLATOR, TERecipeType.NANOBOT_CRAFTER,
                new ItemStack[]{SlimefunItems.ADVANCED_CIRCUIT_BOARD, TEItems.QUIRP_UP, SlimefunItems.ADVANCED_CIRCUIT_BOARD,
                        TEItems.QUIRP_LEFT, SlimefunItems.HEATED_PRESSURE_CHAMBER_2, TEItems.QUIRP_RIGHT,
                        SlimefunItems.REINFORCED_PLATE, TEItems.QUIRP_DOWN, SlimefunItems.REINFORCED_PLATE});
    }

    @Override
    protected void registerDefaultRecipes() {

        registerRecipe(8, new ItemStack[]{TEItems.QUIRP_UP, TEItems.QUIRP_DOWN},
                new ItemStack[]{TEItems.QUIRP_CONDENSATE});
        registerRecipe(8, new ItemStack[]{TEItems.QUIRP_LEFT, TEItems.QUIRP_RIGHT},
                new ItemStack[]{TEItems.QUIRP_CONDENSATE});

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

    @Override
    public int getEnergyConsumption() {
        return 256;
    }

    @Override
    public int getSpeed() {
        return 1;
    }

}


