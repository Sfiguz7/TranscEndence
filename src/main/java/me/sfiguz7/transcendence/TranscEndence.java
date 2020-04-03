package me.sfiguz7.transcendence;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.bstats.bukkit.Metrics;
import me.mrCookieSlime.Slimefun.cscorelib2.config.Config;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;

public class TranscEndence extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        /*
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        }

        int bStatsId = -1;
        new Metrics(this, bStatsId);
        */

        Category category = new Category(new NamespacedKey(this, "transendence"),
                new CustomItem(Material.PURPUR_BLOCK, "&5TranscEndence, ", "", "&a> Click to open")
        );



    }

    @Override
    public void onDisable() {
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/Sfiguz7/TranscEndence/issues";
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

}
