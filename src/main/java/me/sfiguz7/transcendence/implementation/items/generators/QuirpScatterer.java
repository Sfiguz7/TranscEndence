package me.sfiguz7.transcendence.implementation.items.generators;

import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetProvider;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AGenerator;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineFuel;
import me.sfiguz7.transcendence.lists.TEItems;
import me.sfiguz7.transcendence.lists.TERecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class QuirpScatterer extends AGenerator implements EnergyNetProvider {

    public QuirpScatterer() {
        super(TEItems.transcendence, TEItems.QUIRP_SCATTERER, TERecipeType.NANOBOT_CRAFTER,
                new ItemStack[]{
                        TEItems.QUIRP_CONDENSATE, TEItems.QUIRP_UP, TEItems.QUIRP_CONDENSATE,
                        TEItems.QUIRP_LEFT, TEItems.QUIRP_CONDENSATE, TEItems.QUIRP_RIGHT,
                        TEItems.QUIRP_CONDENSATE, TEItems.QUIRP_DOWN, TEItems.QUIRP_CONDENSATE}
        );
    }

    @Override
    protected void registerDefaultFuelTypes() {
        registerFuel(new MachineFuel(8, TEItems.QUIRP_CONDENSATE));
        registerFuel(new MachineFuel(1, TEItems.QUIRP_UP));
        registerFuel(new MachineFuel(1, TEItems.QUIRP_DOWN));
        registerFuel(new MachineFuel(1, TEItems.QUIRP_LEFT));
        registerFuel(new MachineFuel(1, TEItems.QUIRP_RIGHT));
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.FLINT_AND_STEEL);
    }

    @Override
    public String getInventoryTitle() {
        return "&cQuirp Scatterer";
    }

    @Override
    public int getEnergyProduction() {
        return 678;
    }

    @Override
    public int getCapacity() {
        return 65536;
    }

}