package me.sfiguz7.transcendence.lists;

import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.sfiguz7.transcendence.TranscEndence;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

public class TERecipeType {

    static final TranscEndence instance = TranscEndence.getInstance();

    public static final RecipeType QUIRP_OSCILLATOR = new RecipeType(new NamespacedKey(instance, "quirp_oscillator"),
        new CustomItemStack(Material.PURPUR_BLOCK, "&9Quirp Oscillator", "&a&oUse a Quirps Oscillator to obtain this Item")
    );
    public static final RecipeType QUIRP_ANNIHILATOR = new RecipeType(new NamespacedKey(instance, "quirp_annihilator"),
        new CustomItemStack(Material.YELLOW_CONCRETE, "&9Quirp Annihilator", "&a&oUse a Quirps Annihilator to obtain this " +
            "Item")
    );
    public static final RecipeType STABILIZER = new RecipeType(new NamespacedKey(instance, "stabilizer"),
        new CustomItemStack(Material.BLACK_CONCRETE, "&9Stabilizer", "&a&oUse a Stabilizer to obtain this Item")
    );
    public static final RecipeType NANOBOT_CRAFTER = new RecipeType(new NamespacedKey(instance, "nanobot_crafter"),
        TEItems.NANOBOT_CRAFTER, new String[0]
    );
    public static final RecipeType ZOT_OVERLOADER = new RecipeType(new NamespacedKey(instance, "zot_overloader"),
        new CustomItemStack(Material.WHITE_CONCRETE, "&9Zot Overloader", "Charge a zot to the maximum", "to obtain this " +
            "Item")
    );
}
