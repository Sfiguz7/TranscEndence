package me.sfiguz7.transcendence;

import io.github.thebusybiscuit.slimefun4.implementation.items.electric.generators.CoalGenerator;
import me.mrCookieSlime.Slimefun.Lists.Categories;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.Research;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.config.Config;
import me.mrCookieSlime.bstats.bukkit.Metrics;
import me.sfiguz7.transcendence.Lists.TranscendenceRecipeType;
import me.sfiguz7.transcendence.implementation.core.attributes.Instability;
import me.sfiguz7.transcendence.implementation.core.attributes.TranscendenceRegistry;
import me.sfiguz7.transcendence.implementation.items.UnstableItem;
import me.sfiguz7.transcendence.implementation.items.generators.QuirpScatterer;
import me.sfiguz7.transcendence.implementation.items.machines.ZotOverloader;
import me.sfiguz7.transcendence.implementation.items.multiblocks.NanobotCrafter;
import me.sfiguz7.transcendence.implementation.listeners.UnstableListener;
import me.sfiguz7.transcendence.implementation.items.machines.QuirpOscillator;
import me.sfiguz7.transcendence.implementation.items.machines.QuirpAnnihilator;
import me.sfiguz7.transcendence.implementation.items.machines.QuirpCycler;
import me.sfiguz7.transcendence.implementation.items.machines.Stabilizer;
import me.sfiguz7.transcendence.implementation.tasks.StableTask;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;

import static me.sfiguz7.transcendence.Lists.TranscendenceItems.QUIRP_CONDENSATE;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.QUIRP_CYCLER;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.QUIRP_DOWN;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.QUIRP_LEFT;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.QUIRP_RIGHT;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.QUIRP_SCATTERER;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.QUIRP_UP;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.QUIRP_ANNIHILATOR;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.QUIRP_OSCILLATOR;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.STABILIZER;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.STABLE_BLOCK;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.STABLE_INGOT;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.UNSTABLE_INGOT;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.UNSTABLE_INGOT_2;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.UNSTABLE_INGOT_3;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.UNSTABLE_INGOT_4;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.ZOT_DOWN;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.ZOT_LEFT;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.ZOT_OVERLOADER;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.ZOT_RIGHT;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.ZOT_UP;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.transcendence;
import static me.sfiguz7.transcendence.Lists.TranscendenceRecipeType.NANOBOT_CRAFTER;

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


        /* Items */
        new SlimefunItem(transcendence, QUIRP_UP, TranscendenceRecipeType.QUIRP_OSCILLATOR,
                new ItemStack[]{null, null, null, null, null, null, null, null, null}
        ).register(this);
        new SlimefunItem(transcendence, QUIRP_DOWN, TranscendenceRecipeType.QUIRP_OSCILLATOR,
                new ItemStack[]{null, null, null, null, null, null, null, null, null}
        ).register(this);
        new SlimefunItem(transcendence, QUIRP_LEFT, TranscendenceRecipeType.QUIRP_OSCILLATOR,
                new ItemStack[]{null, null, null, null, null, null, null, null, null}
        ).register(this);
        new SlimefunItem(transcendence, QUIRP_RIGHT, TranscendenceRecipeType.QUIRP_OSCILLATOR,
                new ItemStack[]{null, null, null, null, null, null, null, null, null}
        ).register(this);
        new SlimefunItem(transcendence, QUIRP_CONDENSATE, TranscendenceRecipeType.QUIRP_ANNIHILATOR,
                new ItemStack[]{null, null, null, null, null, null, null, null, null}
        ).register(this);
        new UnstableItem(transcendence, Instability.HIGH, UNSTABLE_INGOT, NANOBOT_CRAFTER,
                new ItemStack[]{SlimefunItems.BLISTERING_INGOT_3, QUIRP_UP, SlimefunItems.BLISTERING_INGOT_3,
                        QUIRP_LEFT, new ItemStack(Material.DIAMOND_BLOCK), QUIRP_RIGHT,
                        SlimefunItems.BLISTERING_INGOT_3, QUIRP_DOWN, SlimefunItems.BLISTERING_INGOT_3
                }
        ).register(this);
        new UnstableItem(transcendence, Instability.HIGH, UNSTABLE_INGOT_2, TranscendenceRecipeType.STABILIZER,
                new ItemStack[]{UNSTABLE_INGOT, QUIRP_CONDENSATE, null,
                        null, null, null,
                        null, null, null
                }
        ).register(this);
        new UnstableItem(transcendence, Instability.HIGH, UNSTABLE_INGOT_3, TranscendenceRecipeType.STABILIZER,
                new ItemStack[]{UNSTABLE_INGOT_2, QUIRP_CONDENSATE, null,
                        null, null, null,
                        null, null, null
                }
        ).register(this);
        new UnstableItem(transcendence, Instability.HIGH, UNSTABLE_INGOT_4, TranscendenceRecipeType.STABILIZER,
                new ItemStack[]{UNSTABLE_INGOT_3, QUIRP_CONDENSATE, null,
                        null, null, null,
                        null, null, null
                }
        ).register(this);
        new SlimefunItem(transcendence, ZOT_UP, TranscendenceRecipeType.NANOBOT_CRAFTER,
                new ItemStack[]{QUIRP_UP, QUIRP_UP, QUIRP_UP,
                        QUIRP_UP, STABLE_BLOCK, QUIRP_UP,
                        QUIRP_UP, QUIRP_UP, QUIRP_UP}
        ).register(this);
        new SlimefunItem(transcendence, ZOT_DOWN, TranscendenceRecipeType.NANOBOT_CRAFTER,
                new ItemStack[]{QUIRP_DOWN, QUIRP_DOWN, QUIRP_DOWN,
                        QUIRP_DOWN, STABLE_BLOCK, QUIRP_DOWN,
                        QUIRP_DOWN, QUIRP_DOWN, QUIRP_DOWN}
        ).register(this);
        new SlimefunItem(transcendence, ZOT_LEFT, TranscendenceRecipeType.NANOBOT_CRAFTER,
                new ItemStack[]{QUIRP_LEFT, QUIRP_LEFT, QUIRP_LEFT,
                        QUIRP_LEFT, STABLE_BLOCK, QUIRP_LEFT,
                        QUIRP_LEFT, QUIRP_LEFT, QUIRP_LEFT}
        ).register(this);
        new SlimefunItem(transcendence, ZOT_RIGHT, TranscendenceRecipeType.NANOBOT_CRAFTER,
                new ItemStack[]{QUIRP_RIGHT, QUIRP_RIGHT, QUIRP_RIGHT,
                        QUIRP_RIGHT, STABLE_BLOCK, QUIRP_RIGHT,
                        QUIRP_RIGHT, QUIRP_RIGHT, QUIRP_RIGHT}
        ).register(this);
        new SlimefunItem(transcendence, STABLE_INGOT, TranscendenceRecipeType.STABILIZER,
                new ItemStack[]{UNSTABLE_INGOT_4, QUIRP_CONDENSATE, null,
                        null, null, null,
                        null, null, null
                }
        ).register(this);
        new SlimefunItem(transcendence, STABLE_BLOCK, NANOBOT_CRAFTER,
                new ItemStack[]{STABLE_INGOT, STABLE_INGOT, STABLE_INGOT,
                        STABLE_INGOT, STABLE_INGOT, STABLE_INGOT,
                        STABLE_INGOT, STABLE_INGOT, STABLE_INGOT
                }
        ).register(this);

        /* Machines */
        new NanobotCrafter().register(this);
        new QuirpOscillator(transcendence, QUIRP_OSCILLATOR, NANOBOT_CRAFTER,
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

        new QuirpAnnihilator(transcendence, QUIRP_ANNIHILATOR, NANOBOT_CRAFTER,
                new ItemStack[]{SlimefunItems.ADVANCED_CIRCUIT_BOARD, QUIRP_UP, SlimefunItems.ADVANCED_CIRCUIT_BOARD,
                        QUIRP_LEFT, SlimefunItems.HEATED_PRESSURE_CHAMBER_2, QUIRP_RIGHT,
                        SlimefunItems.REINFORCED_PLATE, QUIRP_DOWN, SlimefunItems.REINFORCED_PLATE}) {

            @Override
            public int getEnergyConsumption() {
                return 256;
            }

            @Override
            public int getSpeed() {
                return 1;
            }

        }.register(this);

        new QuirpCycler(transcendence, QUIRP_CYCLER, NANOBOT_CRAFTER,
                new ItemStack[]{QUIRP_CONDENSATE, QUIRP_UP, QUIRP_CONDENSATE,
                        QUIRP_LEFT, QUIRP_OSCILLATOR,QUIRP_RIGHT,
                        QUIRP_CONDENSATE, QUIRP_DOWN, QUIRP_CONDENSATE}) {

            @Override
            public int getEnergyConsumption() {
                return 256;
            }

            @Override
            public int getSpeed() {
                return 1;
            }

        }.register(this);

        new Stabilizer(transcendence, STABILIZER, NANOBOT_CRAFTER,
                new ItemStack[]{QUIRP_CONDENSATE, QUIRP_UP, QUIRP_CONDENSATE,
                        QUIRP_LEFT, UNSTABLE_INGOT, QUIRP_RIGHT,
                        QUIRP_CONDENSATE, QUIRP_DOWN, QUIRP_CONDENSATE}) {

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
                QUIRP_CYCLER,
                STABILIZER
        );

        new QuirpScatterer(transcendence, QUIRP_SCATTERER, TranscendenceRecipeType.NANOBOT_CRAFTER,
                new ItemStack[]{QUIRP_CONDENSATE, QUIRP_UP, QUIRP_CONDENSATE,
                QUIRP_LEFT, UNSTABLE_INGOT,QUIRP_RIGHT,
                QUIRP_CONDENSATE, QUIRP_DOWN, QUIRP_CONDENSATE}) {

            @Override
            public int getEnergyProduction() {
                return 678;
            }

            @Override
            public int getCapacity() {
                return 65536;
            }

        }.register(this);

        new ZotOverloader(transcendence, ZOT_OVERLOADER, NANOBOT_CRAFTER,
                new ItemStack[]{null, null, null, null, null, null, null, null, null}
        ).register(this);

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

    public static TranscEndencePlugin getInstance() {
        return instance;
    }

}
