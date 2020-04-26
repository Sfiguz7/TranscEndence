package me.sfiguz7.transcendence.implementation.items.machines;

import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.sfiguz7.transcendence.lists.TEItems;
import me.sfiguz7.transcendence.lists.TERecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Stabilizer extends AContainer implements RecipeDisplayItem {

    public Stabilizer() {
        super(TEItems.transcendence, TEItems.STABILIZER, TERecipeType.NANOBOT_CRAFTER,
                new ItemStack[]{TEItems.QUIRP_CONDENSATE, TEItems.QUIRP_UP, TEItems.QUIRP_CONDENSATE,
                        TEItems.QUIRP_LEFT, TEItems.UNSTABLE_INGOT, TEItems.QUIRP_RIGHT,
                        TEItems.QUIRP_CONDENSATE, TEItems.QUIRP_DOWN, TEItems.QUIRP_CONDENSATE});
    }

    @Override
    protected void registerDefaultRecipes() {

        registerRecipe(8, new ItemStack[]{TEItems.UNSTABLE_INGOT, TEItems.QUIRP_CONDENSATE},
                new ItemStack[]{TEItems.UNSTABLE_INGOT_2});
        registerRecipe(8, new ItemStack[]{TEItems.UNSTABLE_INGOT_2, TEItems.QUIRP_CONDENSATE},
                new ItemStack[]{TEItems.UNSTABLE_INGOT_3});
        registerRecipe(8, new ItemStack[]{TEItems.UNSTABLE_INGOT_3, TEItems.QUIRP_CONDENSATE},
                new ItemStack[]{TEItems.UNSTABLE_INGOT_4});
        registerRecipe(8, new ItemStack[]{TEItems.UNSTABLE_INGOT_4, TEItems.QUIRP_CONDENSATE},
                new ItemStack[]{TEItems.STABLE_INGOT});

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

    @Override
    public int getEnergyConsumption() {
        return 256;
    }

    @Override
    public int getSpeed() {
        return 1;
    }

}
