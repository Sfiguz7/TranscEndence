package me.sfiguz7.transcendence.Lists;

import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import me.sfiguz7.transcendence.TranscEndencePlugin;
import me.sfiguz7.transcendence.implementation.core.attributes.Instability;
import me.sfiguz7.transcendence.implementation.utils.TranscendenceLoreBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

public final class TranscendenceItems {

    private TranscendenceItems() {
    }

    /* Category */
    public static final Category transcendence = new Category(new NamespacedKey(TranscEndencePlugin.getInstance(), "transcendence"),
            new CustomItem(Material.PURPUR_BLOCK, "&5TranscEndence", "", "&a> Click to open")
    );

    /* Items */
    public static final SlimefunItemStack QUIRP_UP = new SlimefunItemStack("QUIRP_UP",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2M0ZDdhM2JjM2RlODMzZDMwMzJlODVhMGJmNmYyYmVmNzY4Nzg2MmIzYzZiYzQwY2U3MzEwNjRmNjE1ZGQ5ZCJ9fX0=",
            "&aQuirp Up",
            "&9Fundamental particle of the Universe"
    );
    public static final SlimefunItemStack QUIRP_DOWN = new SlimefunItemStack("QUIRP_DOWN",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjlhMDMwY2EyYjJjNmZlNjdmZTgwOTdkM2NkMjA2OTY5ZmM1YzAwMTdjNjBiNmI0MDk5MGM3NzJhNmYwYWMwYSJ9fX0=",
            "&aQuirp Down",
            "&9Fundamental particle of the Universe"
    );
    public static final SlimefunItemStack QUIRP_LEFT = new SlimefunItemStack("QUIRP_LEFT",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTc2OTVmOTZkZGE2MjZmYWFhMDEwZjRhNWYyOGE1M2NkNjZmNzdkZTBjYzI4MGU3YzU4MjVhZDY1ZWVkYzcyZSJ9fX0=",
            "&aQuirp Left",
            "&9Fundamental particle of the Universe"
    );
    public static final SlimefunItemStack QUIRP_RIGHT = new SlimefunItemStack("QUIRP_RIGHT",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWY4NjkwNDhmMDZkMzE4ZTUwNThiY2EwYTg3NmE1OTg2MDc5ZjQ1YTc2NGQxMmFiMzRhNDkzMWRiNmI4MGFkYyJ9fX0=",
            "&aQuirp Right",
            "&9Fundamental particle of the Universe"
    );
    public static final SlimefunItemStack QUIRP_CONDENSATE = new SlimefunItemStack("QUIRPCONDENSATE",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzFlMWY2MTYyZGI0MjI0NTYzOTYwOWY3MjhhNGUxMzRlZDdiZDdkZTNjMTVhNzc5MmQyMTlhNmUyYTlkYiJ9fX0=",
            "&5Quirp Condensate",
            "&9An energy singularity"
    );
    public static final SlimefunItemStack UNSTABLE_INGOT = new SlimefunItemStack("UNSTABLEINGOT",
            Material.NETHER_BRICK,
            "&4Unstable Ingot",
            "&9Kills you if held for",
            "&9more than a few seconds",
            "",
            TranscendenceLoreBuilder.unstable(Instability.HIGH)
    );
    public static final SlimefunItemStack UNSTABLE_INGOT_2 = new SlimefunItemStack("UNSTABLEINGOT2",
            Material.NETHER_BRICK,
            "&4Unstable Ingot 75%",
            "&9Kills you if held for",
            "&9more than a few seconds",
            "",
            TranscendenceLoreBuilder.unstable(Instability.HIGH)
    );
    public static final SlimefunItemStack UNSTABLE_INGOT_3 = new SlimefunItemStack("UNSTABLEINGOT3",
            Material.NETHER_BRICK,
            "&4Unstable Ingot 50%",
            "&9Kills you if held for",
            "&9more than a few seconds",
            "",
            TranscendenceLoreBuilder.unstable(Instability.HIGH)
    );
    public static final SlimefunItemStack UNSTABLE_INGOT_4 = new SlimefunItemStack("UNSTABLEINGOT4",
            Material.NETHER_BRICK,
            "&4Unstable Ingot 25%",
            "&9Kills you if held for",
            "&9more than a few seconds",
            "",
            TranscendenceLoreBuilder.unstable(Instability.HIGH)
    );
    public static final SlimefunItemStack ZOT_UP = new SlimefunItemStack("ZOT_UP",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWZkZTNiZmNlMmQ4Y2I3MjRkZTg1NTZlNWVjMjFiN2YxNWY1ODQ2ODRhYjc4NTIxNGFkZDE2NGJlNzYyNGIifX19",
            "&aZot Up",
            "&9Concentrated matter",
            "&7Charge: &e0/1000"
    );
    public static final SlimefunItemStack ZOT_DOWN = new SlimefunItemStack("ZOT_DOWN",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzY0MTY4MmY0MzYwNmM1YzlhZDI2YmM3ZWE4YTMwZWU0NzU0N2M5ZGZkM2M2Y2RhNDllMWMxYTI4MTZjZjBiYSJ9fX0=",
            "&aZot Down",
            "&9Concentrated matter",
            "&7Charge: &e0/1000"
    );
    public static final SlimefunItemStack ZOT_LEFT = new SlimefunItemStack("ZOT_LEFT",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDI3Y2E0NmY2YTliYjg5YTI0ZmNhZjRjYzBhY2Y1ZTgyODVhNjZkYjc1MjEzNzhlZDI5MDlhZTQ0OTY5N2YifX19",
            "&aZot Left",
            "&9Concentrated matter",
            "&7Charge: &e0/1000"
    );
    public static final SlimefunItemStack ZOT_RIGHT = new SlimefunItemStack("ZOT_RIGHT",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2RkM2VkZTBhZDUzNzY4YWJkY2U0OTNmYmYzYzIzNTlkYzg3ZWM1NWQyZmNlZWIxNzc1NGVkNTkwZTQxYSJ9fX0=",
            "&aZot Right",
            "&9Concentrated matter",
            "&7Charge: &e0/1000"
    );
    public static final SlimefunItemStack STABLE_INGOT = new SlimefunItemStack("STABLEINGOT",
            Material.BRICK,
            "&cStable Ingot",
            "&9Priceless material"
    );
    public static final SlimefunItemStack STABLE_BLOCK = new SlimefunItemStack("STABLEBLOCK",
            Material.BRICKS,
            "&cStable Block",
            "&9Priceless material"
    );


    /* Machines */

    public static final SlimefunItemStack NANOBOT_CRAFTER = new SlimefunItemStack("NANOBOT_CRAFTER",
            Material.CHISELED_STONE_BRICKS,
            "&cNanobot Crafter",
            "Allows particle manipulation"
    );
    public static final SlimefunItemStack QUIRP_OSCILLATOR = new SlimefunItemStack("QUIRP_OSCILLATOR",
            Material.PURPUR_PILLAR,
            "&9Quirp Oscillator",
            "Harnesses quirps from the void",
            "&cWorks only in the end!",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.powerBuffer(512),
            LoreBuilder.powerPerSecond(256)
    );
    public static final SlimefunItemStack QUIRP_ANNIHILATOR = new SlimefunItemStack("QUIRP_ANNIHILATOR",
            Material.YELLOW_CONCRETE,
            "&cQuirp Annihilator",
            "Condesates opposite quirps",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.powerBuffer(1024),
            LoreBuilder.powerPerSecond(512)
    );
    public static final SlimefunItemStack QUIRP_CYCLER = new SlimefunItemStack("QUIRP_CYCLER",
            Material.BLUE_CONCRETE,
            "&cQuirp Cycler",
            "Rotates quirps",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.powerBuffer(1024),
            LoreBuilder.powerPerSecond(512)
    );
    public static final SlimefunItemStack STABILIZER = new SlimefunItemStack("STABILIZER",
            Material.BLACK_CONCRETE,
            "&cStabilizer",
            "A controlled environment",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.powerBuffer(1024),
            LoreBuilder.powerPerSecond(512)
    );
    public static final SlimefunItemStack ZOT_OVERLOADER = new SlimefunItemStack("ZOT_OVERLOADER",
            Material.WHITE_CONCRETE,
            "&9Zot Overloader",
            "Even higher power concentrations",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.powerBuffer(1024),
            LoreBuilder.powerPerSecond(512)
    );


}
