package me.sfiguz7.transcendence.lists;

import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import me.sfiguz7.transcendence.TranscEndence;
import me.sfiguz7.transcendence.implementation.utils.TranscendenceLoreBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

public final class TEItems {

    private TEItems() {
    }

    /* Category */
    public static final Category transcendence = new Category(new NamespacedKey(TranscEndence.getInstance(), "transcendence"),
            new CustomItem(Material.PURPUR_BLOCK, "&5TranscEndence")
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
            TranscendenceLoreBuilder.unstable()
    );
    public static final SlimefunItemStack UNSTABLE_INGOT_2 = new SlimefunItemStack("UNSTABLEINGOT2",
            Material.NETHER_BRICK,
            "&4Unstable Ingot 75%",
            "&9Kills you if held for",
            "&9more than a few seconds",
            "",
            TranscendenceLoreBuilder.unstable()
    );
    public static final SlimefunItemStack UNSTABLE_INGOT_3 = new SlimefunItemStack("UNSTABLEINGOT3",
            Material.NETHER_BRICK,
            "&4Unstable Ingot 50%",
            "&9Kills you if held for",
            "&9more than a few seconds",
            "",
            TranscendenceLoreBuilder.unstable()
    );
    public static final SlimefunItemStack UNSTABLE_INGOT_4 = new SlimefunItemStack("UNSTABLEINGOT4",
            Material.NETHER_BRICK,
            "&4Unstable Ingot 25%",
            "&9Kills you if held for",
            "&9more than a few seconds",
            "",
            TranscendenceLoreBuilder.unstable()
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
    public static final SlimefunItemStack ZOT_UP_2 = new SlimefunItemStack("ZOT_UP_2",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWZkZTNiZmNlMmQ4Y2I3MjRkZTg1NTZlNWVjMjFiN2YxNWY1ODQ2ODRhYjc4NTIxNGFkZDE2NGJlNzYyNGIifX19",
            "&cZot Up",
            "&9Concentrated matter",
            "&7Charge: &c1000/1000"
    );
    public static final SlimefunItemStack ZOT_DOWN_2 = new SlimefunItemStack("ZOT_DOWN_2",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzY0MTY4MmY0MzYwNmM1YzlhZDI2YmM3ZWE4YTMwZWU0NzU0N2M5ZGZkM2M2Y2RhNDllMWMxYTI4MTZjZjBiYSJ9fX0=",
            "&cZot Down",
            "&9Concentrated matter",
            "&7Charge: &c1000/1000"
    );
    public static final SlimefunItemStack ZOT_LEFT_2 = new SlimefunItemStack("ZOT_LEFT_2",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDI3Y2E0NmY2YTliYjg5YTI0ZmNhZjRjYzBhY2Y1ZTgyODVhNjZkYjc1MjEzNzhlZDI5MDlhZTQ0OTY5N2YifX19",
            "&cZot Left",
            "&9Concentrated matter",
            "&7Charge: &c1000/1000"
    );
    public static final SlimefunItemStack ZOT_RIGHT_2 = new SlimefunItemStack("ZOT_RIGHT_2",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2RkM2VkZTBhZDUzNzY4YWJkY2U0OTNmYmYzYzIzNTlkYzg3ZWM1NWQyZmNlZWIxNzc1NGVkNTkwZTQxYSJ9fX0=",
            "&cZot Right",
            "&9Concentrated matter",
            "&7Charge: &c1000/1000"
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
    public static final SlimefunItemStack DAXI_STRENGTH = new SlimefunItemStack("DAXI_STRENGTH",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2ZmYzk3N2NjN2UxMGU1NjRhMDk2MzhhNTNiYmM0YzU0YzljOGRhYzc0NTBiYTNkZmEzYzkwOTlkOTRmNSJ9fX0=",
            "&aDaxi (S)",
            "&9Right click to unleash its power",
            "&9F5 mode recommended!"
    );
    public static final SlimefunItemStack DAXI_ABSORPTION = new SlimefunItemStack("DAXI_ABSORPTION",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2ZmYzk3N2NjN2UxMGU1NjRhMDk2MzhhNTNiYmM0YzU0YzljOGRhYzc0NTBiYTNkZmEzYzkwOTlkOTRmNSJ9fX0=",
            "&aDaxi (A)",
            "&9Right click to unleash its power",
            "&9F5 mode recommended!"
    );
    public static final SlimefunItemStack DAXI_FORTITUDE = new SlimefunItemStack("DAXI_FORTITUDE",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2ZmYzk3N2NjN2UxMGU1NjRhMDk2MzhhNTNiYmM0YzU0YzljOGRhYzc0NTBiYTNkZmEzYzkwOTlkOTRmNSJ9fX0=",
            "&aDaxi (F)",
            "&9Right click to unleash its power",
            "&9F5 mode recommended!"
    );
    public static final SlimefunItemStack DAXI_SATURATION = new SlimefunItemStack("DAXI_SATURATION",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2ZmYzk3N2NjN2UxMGU1NjRhMDk2MzhhNTNiYmM0YzU0YzljOGRhYzc0NTBiYTNkZmEzYzkwOTlkOTRmNSJ9fX0=",
            "&aDaxi (H)",
            "&9Right click to unleash its power",
            "&9F5 mode recommended!"
    );
    public static final SlimefunItemStack DAXI_REGENERATION = new SlimefunItemStack("DAXI_REGENERATION",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2ZmYzk3N2NjN2UxMGU1NjRhMDk2MzhhNTNiYmM0YzU0YzljOGRhYzc0NTBiYTNkZmEzYzkwOTlkOTRmNSJ9fX0=",
            "&aDaxi (R)",
            "&9Right click to unleash its power",
            "&9F5 mode recommended!"
    );
    public static final SlimefunItemStack VERTICAL_POLARIZER = new SlimefunItemStack("VERTICAL_POLARIZER",
            Material.END_ROD,
            "&5Vertical Polarizer",
            "&9Focuses Oscillator on vertical spins",
            "&cIncreased chance for vertical spin quirps"
    );
    public static final SlimefunItemStack HORIZONTAL_POLARIZER = new SlimefunItemStack("HORIZONTAL_POLARIZER",
            Material.END_ROD,
            "&5Horizontal Polarizer",
            "&9Focuses Oscillator on horizontal spins",
            "&cIncreased chance for horizontal spin quirps"
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
            "Harnesses Quirps from the void",
            "&cWorks only in the end!",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.powerBuffer(512),
            LoreBuilder.powerPerSecond(256)
    );
    public static final SlimefunItemStack QUIRP_ANNIHILATOR = new SlimefunItemStack("QUIRP_ANNIHILATOR",
            Material.YELLOW_CONCRETE,
            "&cQuirp Annihilator",
            "Condesates opposite Quirps",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.powerBuffer(1024),
            LoreBuilder.powerPerSecond(512)
    );
    public static final SlimefunItemStack QUIRP_CYCLER = new SlimefunItemStack("QUIRP_CYCLER",
            Material.BLUE_CONCRETE,
            "&cQuirp Cycler",
            "Rotates Quirps",
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
    public static final SlimefunItemStack QUIRP_SCATTERER = new SlimefunItemStack("QUIRP_SCATTERER",
            "9343ce58da54c79924a2c9331cfc417fe8ccbbea9be45a7ac85860a6c730",
            "&cQuirp Scatterer",
            "Einstein anyone?",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR),
            LoreBuilder.powerBuffer(65536),
            LoreBuilder.powerPerSecond(1536)
    );
    public static final SlimefunItemStack ZOT_OVERLOADER = new SlimefunItemStack("ZOT_OVERLOADER",
            Material.WHITE_CONCRETE,
            "&9Zot Overloader",
            "Even higher power concentrations",
            "&cWorks only in the end!",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.powerBuffer(1024),
            LoreBuilder.powerPerSecond(512)
    );
}
