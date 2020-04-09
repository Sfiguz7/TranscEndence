package me.sfiguz7.transcendence.Lists;

import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.SlimefunPlugin;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

public class TranscendenceRecipeType extends RecipeType {

    public TranscendenceRecipeType(NamespacedKey key, SlimefunItemStack slimefunItem, String... lore) {
        super(key, slimefunItem, null, lore);
    }


    public static final RecipeType QUIRP_OSCILLATOR = new RecipeType(new NamespacedKey(SlimefunPlugin.instance, "quirp_oscillator"),
            new CustomItem(Material.PURPUR_BLOCK, "&9Quirp Oscillator" , "&a&oUse a Quirp Oscillator to obtain this Item")
    );
    public static final RecipeType QUIRP_ANNIHILATOR = new RecipeType(new NamespacedKey(SlimefunPlugin.instance, "quirp_annihilator"),
            new CustomItem(Material.YELLOW_CONCRETE, "&9Quirp Annihilator" , "&a&oUse a Quirp Annihilator to obtain this Item")
    );
    public static final RecipeType STABILIZER = new RecipeType(new NamespacedKey(SlimefunPlugin.instance, "stabilizer"),
            new CustomItem(Material.BLACK_CONCRETE, "&9Stabilizer" , "&a&oUse a Stabilizer to obtain this Item")
    );
    public static final RecipeType NANOBOT_CRAFTER = new RecipeType(new NamespacedKey(SlimefunPlugin.instance, "nanobot_crafter"),
            TranscendenceItems.NANOBOT_CRAFTER, new String[0]
    );
    public static final RecipeType ZOT_OVERLOADER = new RecipeType(new NamespacedKey(SlimefunPlugin.instance, "zot_overloader"),
            new CustomItem(Material.WHITE_CONCRETE, "&9Zot Overloader" , "Charge a zot to the maximum" , "to obtain this Item")
    );
}
