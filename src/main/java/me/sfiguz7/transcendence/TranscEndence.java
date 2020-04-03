package me.sfiguz7.transcendence;

import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.Research;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import me.sfiguz7.transcendence.Lists.QuirpRecipeType;
import me.sfiguz7.transcendence.Lists.TranscendenceItems;
import me.sfiguz7.transcendence.implementation.quirps.generators.QuirpOscillator;
import me.sfiguz7.transcendence.implementation.quirps.machines.QuirpAnnihilator;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;

import static me.sfiguz7.transcendence.Lists.TranscendenceItems.QUIRP_DOWN;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.QUIRP_LEFT;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.QUIRP_RIGHT;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.QUIRP_UP;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.QUIRP_ANNIHILATOR;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.QUIRP_OSCILLATOR;

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


        new SlimefunItem(transcendence, QUIRP_UP, QuirpRecipeType.QUIRPOSCILLATOR,
                new ItemStack[]{null, null, null, null, null, null, null, null, null}
        ).register(this);
        new SlimefunItem(transcendence, QUIRP_DOWN, QuirpRecipeType.QUIRPOSCILLATOR,
                new ItemStack[]{null, null, null, null, null, null, null, null, null}
        ).register(this);
        new SlimefunItem(transcendence, QUIRP_LEFT, QuirpRecipeType.QUIRPOSCILLATOR,
                new ItemStack[]{null, null, null, null, null, null, null, null, null}
        ).register(this);
        new SlimefunItem(transcendence, QUIRP_RIGHT, QuirpRecipeType.QUIRPOSCILLATOR,
                new ItemStack[]{null, null, null, null, null, null, null, null, null}
        ).register(this);

        new QuirpOscillator(transcendence, QUIRP_OSCILLATOR, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{SlimefunItems.BLISTERING_INGOT_3, SlimefunItems.REINFORCED_PLATE, SlimefunItems.BLISTERING_INGOT_3,
                        SlimefunItems.SYNTHETIC_EMERALD, SlimefunItems.NETHERSTAR_REACTOR, SlimefunItems.SYNTHETIC_EMERALD,
                        SlimefunItems.BLISTERING_INGOT_3, SlimefunItems.REINFORCED_PLATE, SlimefunItems.BLISTERING_INGOT_3}
        ).register(this);

        Slimefun.registerResearch(new Research(new NamespacedKey(this, "quirp_oscillator"),
                        ++researchId,
                        "Quirp_Oscillator",
                        40),
                QUIRP_OSCILLATOR
        );

        new QuirpAnnihilator(transcendence, QUIRP_ANNIHILATOR, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{TranscendenceItems.QUIRP_UP, SlimefunItems.REINFORCED_PLATE, TranscendenceItems.QUIRP_RIGHT,
                        SlimefunItems.ADVANCED_CIRCUIT_BOARD, SlimefunItems.HEATED_PRESSURE_CHAMBER_2, SlimefunItems.ADVANCED_CIRCUIT_BOARD,
                        TranscendenceItems.QUIRP_LEFT, SlimefunItems.REINFORCED_PLATE, TranscendenceItems.QUIRP_DOWN}) {

            @Override
            public int getEnergyConsumption() {
                return 9;
            }

            @Override
            public int getSpeed() {
                return 1;
            }

        }.register(this);

        Slimefun.registerResearch(new Research(new NamespacedKey(this, "quirp_annihilator"),
                        ++researchId,
                        "Quirp_Annihilator",
                        40),
                QUIRP_ANNIHILATOR
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
