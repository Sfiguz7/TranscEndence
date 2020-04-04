package me.sfiguz7.transcendence;

import io.github.thebusybiscuit.slimefun4.implementation.listeners.AncientAltarListener;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.Research;
import me.mrCookieSlime.Slimefun.SlimefunPlugin;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import me.mrCookieSlime.Slimefun.cscorelib2.config.Config;
import me.mrCookieSlime.bstats.bukkit.Metrics;
import me.sfiguz7.transcendence.Lists.TranscendenceRecipeType;
import me.sfiguz7.transcendence.Lists.TranscendenceItems;
import me.sfiguz7.transcendence.implementation.core.attributes.Instability;
import me.sfiguz7.transcendence.implementation.core.attributes.TranscendenceRegistry;
import me.sfiguz7.transcendence.implementation.items.UnstableItem;
import me.sfiguz7.transcendence.implementation.listeners.UnstableListener;
import me.sfiguz7.transcendence.implementation.quirps.generators.QuirpOscillator;
import me.sfiguz7.transcendence.implementation.quirps.machines.QuirpAnnihilator;
import me.sfiguz7.transcendence.implementation.quirps.machines.QuirpCycler;
import me.sfiguz7.transcendence.implementation.tasks.StableTask;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;

import static me.sfiguz7.transcendence.Lists.TranscendenceItems.QUIRP_CYCLER;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.QUIRP_DOWN;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.QUIRP_LEFT;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.QUIRP_RIGHT;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.QUIRP_UP;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.QUIRP_ANNIHILATOR;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.QUIRP_OSCILLATOR;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.UNSTABLE_INGOT;

public class TranscEndencePlugin extends JavaPlugin implements SlimefunAddon {

    public static TranscEndencePlugin instance;
    private final TranscendenceRegistry registry = new TranscendenceRegistry();
    private int researchId = 7100;

    @Override
    public void onEnable() {

        instance = this;

        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        }

        //Listeners
        new UnstableListener(this);

        // Instability Update Task
        if (cfg.getBoolean("options.enable-instability-effects")) {
            getServer().getScheduler().runTaskTimerAsynchronously(
                    this,
                    new StableTask(),
                    0L,
                    cfg.getInt("options.instability-update-interval") * 20L
            );
        }

        int bStatsId = -1;
        new Metrics(this, bStatsId);

        Category transcendence = new Category(new NamespacedKey(this, "transcendence"),
                new CustomItem(Material.PURPUR_BLOCK, "&5TranscEndence", "", "&a> Click to open")
        );


        new SlimefunItem(transcendence, QUIRP_UP, TranscendenceRecipeType.QUIRPOSCILLATOR,
                new ItemStack[]{null, null, null, null, null, null, null, null, null}
        ).register(this);
        new SlimefunItem(transcendence, QUIRP_DOWN, TranscendenceRecipeType.QUIRPOSCILLATOR,
                new ItemStack[]{null, null, null, null, null, null, null, null, null}
        ).register(this);
        new SlimefunItem(transcendence, QUIRP_LEFT, TranscendenceRecipeType.QUIRPOSCILLATOR,
                new ItemStack[]{null, null, null, null, null, null, null, null, null}
        ).register(this);
        new SlimefunItem(transcendence, QUIRP_RIGHT, TranscendenceRecipeType.QUIRPOSCILLATOR,
                new ItemStack[]{null, null, null, null, null, null, null, null, null}
        ).register(this);
        new UnstableItem(transcendence, Instability.HIGH, UNSTABLE_INGOT, TranscendenceRecipeType.MAGIC_WORKBENCH,
                new ItemStack[]{SlimefunItems.BLISTERING_INGOT_3, QUIRP_UP, SlimefunItems.BLISTERING_INGOT_3,
                        QUIRP_LEFT, new ItemStack(Material.DIAMOND_BLOCK), QUIRP_RIGHT,
                        SlimefunItems.BLISTERING_INGOT_3, QUIRP_DOWN, SlimefunItems.BLISTERING_INGOT_3
                }
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
                return 256;
            }

            @Override
            public int getSpeed() {
                return 1;
            }

        }.register(this);

        new QuirpCycler(transcendence, QUIRP_CYCLER, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{TranscendenceItems.QUIRP_UP, TranscendenceItems.QUIRP_CONDENSATE, TranscendenceItems.QUIRP_RIGHT,
                        TranscendenceItems.QUIRP_CONDENSATE, TranscendenceItems.QUIRP_OSCILLATOR, TranscendenceItems.QUIRP_CONDENSATE,
                        TranscendenceItems.QUIRP_LEFT, TranscendenceItems.QUIRP_CONDENSATE, TranscendenceItems.QUIRP_DOWN}) {

            @Override
            public int getEnergyConsumption() {
                return 256;
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
                QUIRP_ANNIHILATOR,
                QUIRP_CYCLER
        );

    }

    @Override
    public void onDisable() {
        // TranscEndencePlugin never loaded successfully, so we don't even bother doing stuff here
        if (instance == null) {
            return;
        }

        Bukkit.getScheduler().cancelTasks(this);
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/Sfiguz7/TranscEndencePlugin/issues";
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    public static TranscendenceRegistry getRegistry() {
        return instance.registry;
    }

}
