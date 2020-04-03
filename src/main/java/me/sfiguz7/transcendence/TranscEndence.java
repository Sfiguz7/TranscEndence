package me.sfiguz7.transcendence;

import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.mrCookieSlime.Slimefun.Lists.Categories;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.Research;
import me.mrCookieSlime.Slimefun.SlimefunPlugin;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import me.mrCookieSlime.Slimefun.cscorelib2.skull.SkullItem;
import me.sfiguz7.transcendence.Lists.QuirpRecipeType;
import me.sfiguz7.transcendence.implementation.quirps.generators.QuirpOscillator;
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

import static me.sfiguz7.transcendence.Lists.TranscendenceItems.quirpOscillator;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.quirpdown;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.quirpleft;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.quirpright;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.quirpup;

public class TranscEndence extends JavaPlugin implements SlimefunAddon {

    private int researchId = 7100;

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

        Category transcendence = new Category(new NamespacedKey(this, "transcendence"),
                new CustomItem(Material.PURPUR_BLOCK, "&5TranscEndence", "", "&a> Click to open")
        );


        new SlimefunItem(transcendence, quirpup, QuirpRecipeType.QUIRPOSCILLATOR,
                new ItemStack[]{null, null, null, null, null, null, null, null, null}
        ).register(this);
        new SlimefunItem(transcendence, quirpdown, QuirpRecipeType.QUIRPOSCILLATOR,
                new ItemStack[]{null, null, null, null, null, null, null, null, null}
        ).register(this);
        new SlimefunItem(transcendence, quirpleft, QuirpRecipeType.QUIRPOSCILLATOR,
                new ItemStack[]{null, null, null, null, null, null, null, null, null}
        ).register(this);
        new SlimefunItem(transcendence, quirpright, QuirpRecipeType.QUIRPOSCILLATOR,
                new ItemStack[]{null, null, null, null, null, null, null, null, null}
        ).register(this);

        new QuirpOscillator(transcendence, quirpOscillator, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{SlimefunItems.BLISTERING_INGOT_3, SlimefunItems.REINFORCED_PLATE, SlimefunItems.BLISTERING_INGOT_3,
                        SlimefunItems.SYNTHETIC_EMERALD, SlimefunItems.NETHERSTAR_REACTOR, SlimefunItems.SYNTHETIC_EMERALD,
                        SlimefunItems.BLISTERING_INGOT_3, SlimefunItems.REINFORCED_PLATE, SlimefunItems.BLISTERING_INGOT_3,}
        ).register(this);

        Slimefun.registerResearch(new Research(new NamespacedKey(this, "quirp_oscillator"),
                        ++researchId,
                        "Quirp_Oscillator",
                        40),
                quirpOscillator
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
