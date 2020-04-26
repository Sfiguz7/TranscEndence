package me.sfiguz7.transcendence;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.mrCookieSlime.Slimefun.Objects.Research;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import me.mrCookieSlime.Slimefun.cscorelib2.config.Config;
import me.mrCookieSlime.bstats.bukkit.Metrics;
import me.sfiguz7.transcendence.implementation.core.attributes.TERegistry;
import me.sfiguz7.transcendence.implementation.core.commands.TranscEndenceCommand;
import me.sfiguz7.transcendence.implementation.items.generators.QuirpScatterer;
import me.sfiguz7.transcendence.implementation.items.items.Daxi;
import me.sfiguz7.transcendence.implementation.items.items.Polarizer;
import me.sfiguz7.transcendence.implementation.items.items.Quirps;
import me.sfiguz7.transcendence.implementation.items.items.StabilizedItems;
import me.sfiguz7.transcendence.implementation.items.items.UnstableIngots;
import me.sfiguz7.transcendence.implementation.items.items.Zots;
import me.sfiguz7.transcendence.implementation.items.items.Zots_2;
import me.sfiguz7.transcendence.implementation.items.machines.QuirpAnnihilator;
import me.sfiguz7.transcendence.implementation.items.machines.QuirpCycler;
import me.sfiguz7.transcendence.implementation.items.machines.QuirpOscillator;
import me.sfiguz7.transcendence.implementation.items.machines.Stabilizer;
import me.sfiguz7.transcendence.implementation.items.machines.ZotOverloader;
import me.sfiguz7.transcendence.implementation.items.multiblocks.NanobotCrafter;
import me.sfiguz7.transcendence.implementation.listeners.TranscEndenceGuideListener;
import me.sfiguz7.transcendence.implementation.listeners.UnstableListener;
import me.sfiguz7.transcendence.implementation.tasks.StableTask;
import me.sfiguz7.transcendence.lists.TEItems;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public class TranscEndencePlugin extends JavaPlugin implements SlimefunAddon {

    private static TranscEndencePlugin instance;
    private final TERegistry registry = new TERegistry();
    private int researchId = 7100;

    @Override
    public void onEnable() {

        instance = this;

        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // Auto-Updater TBA
        }

        int bStatsId = -1;
        new Metrics(this, bStatsId);


        // Commands
        getCommand("transcendence").setExecutor(new TranscEndenceCommand());
        // Listeners
        new UnstableListener(this);
        new TranscEndenceGuideListener(this, cfg.getBoolean("options.give-guide-on-first-join"));

        // Instability Update Task
        if (cfg.getBoolean("options.enable-instability-effects")) {
            getServer().getScheduler().runTaskTimerAsynchronously(
                    this,
                    new StableTask(),
                    0L,
                    cfg.getInt("options.instability-update-interval") * 20L
            );
        }




        /* Items */
        for (Quirps.Type type : Quirps.Type.values()){
            new Quirps(type).register(this);
        }

        for (UnstableIngots.Type type : UnstableIngots.Type.values()) {
            new UnstableIngots(type).register(this);
        }

        Slimefun.registerResearch(new Research(new NamespacedKey(this, "unstable"),
                        ++researchId, "Unstable", 23),
                TEItems.UNSTABLE_INGOT,
                TEItems.UNSTABLE_INGOT_2,
                TEItems.UNSTABLE_INGOT_3,
                TEItems.UNSTABLE_INGOT_4
        );

        for (Zots.Type type : Zots.Type.values()){
            new Zots(type).register(this);
        }

        for (StabilizedItems.Type type : StabilizedItems.Type.values()){
            new StabilizedItems(type).register(this);
        }

        Slimefun.registerResearch(new Research(new NamespacedKey(this, "stable"),
                        ++researchId, "Stable", 30),
                TEItems.STABLE_INGOT,
                TEItems.STABLE_BLOCK
        );
        /* More items moved below for aesthetic purposes */


        /* Machines pt. 1 */
        new QuirpScatterer().register(this);

        Slimefun.registerResearch(new Research(new NamespacedKey(this, "quirp_scatterer"),
                ++researchId, "Quirps Scatterer", 20),
                TEItems.QUIRP_SCATTERER
        );

        new NanobotCrafter().register(this);

        Slimefun.registerResearch(new Research(new NamespacedKey(this, "nanobot_crafter"),
                        ++researchId, "Nanobot Crafter", 15),
                TEItems.NANOBOT_CRAFTER
        );

        new QuirpOscillator().register(this);

        Slimefun.registerResearch(new Research(new NamespacedKey(this, "quirp_oscillator"),
                        ++researchId, "Quirps Oscillator", 37),
                TEItems.QUIRP_OSCILLATOR,
                TEItems.QUIRP_UP,
                TEItems.QUIRP_DOWN,
                TEItems.QUIRP_LEFT,
                TEItems.QUIRP_RIGHT,
                TEItems.QUIRP_CONDENSATE
        );


        /* Items pt. 2 */
        for (Zots_2.Type type : Zots_2.Type.values()){
            new Zots_2(type).register(this);
        }
        Slimefun.registerResearch(new Research(new NamespacedKey(this, "zots"),
                        ++researchId, "Zots", 30),
                TEItems.ZOT_UP,
                TEItems.ZOT_DOWN,
                TEItems.ZOT_LEFT,
                TEItems.ZOT_RIGHT,
                TEItems.ZOT_UP_2,
                TEItems.ZOT_DOWN_2,
                TEItems.ZOT_LEFT_2,
                TEItems.ZOT_RIGHT_2
        );

        for (Daxi.Type type : Daxi.Type.values()) {
            new Daxi(type).register(this);
        }

        Slimefun.registerResearch(new Research(new NamespacedKey(this, "daxis"),
                        ++researchId, "Daxis", 30),
                TEItems.DAXI_STRENGTH,
                TEItems.DAXI_ABSORPTION,
                TEItems.DAXI_FORTITUDE,
                TEItems.DAXI_SATURATION,
                TEItems.DAXI_REGENERATION
        );

        for(Polarizer.Type type : Polarizer.Type.values()){
            new Polarizer(type).register(this);
        }

        Slimefun.registerResearch(new Research(new NamespacedKey(this, "polarizers"),
                        ++researchId, "Polarizers", 23),
                TEItems.VERTICAL_POLARIZER,
                TEItems.HORIZONTAL_POLARIZER
        );

        /* Machines pt. 2 */
        new QuirpAnnihilator().register(this);

        new QuirpCycler().register(this);

        new Stabilizer().register(this);

        Slimefun.registerResearch(new Research(new NamespacedKey(this, "quirp_annihilator"),
                        ++researchId, "Quirps Annihilator", 40),
                TEItems.QUIRP_ANNIHILATOR,
                TEItems.QUIRP_CYCLER,
                TEItems.STABILIZER
        );

        new ZotOverloader().register(this);

        Slimefun.registerResearch(new Research(new NamespacedKey(this, "zot_overloader"),
                        ++researchId, "Zot Overloader", 35),
                TEItems.ZOT_OVERLOADER
        );
    }

    @Override
    public void onDisable() {
        instance = null;

        Bukkit.getScheduler().cancelTasks(this);
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/Sfiguz7/TranscEndence/issues";
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    public static TERegistry getRegistry() {
        return instance.registry;
    }

    public static TranscEndencePlugin getInstance() {
        return instance;
    }

    public static String getVersion() {
        return instance.getDescription().getVersion();
    }

}
