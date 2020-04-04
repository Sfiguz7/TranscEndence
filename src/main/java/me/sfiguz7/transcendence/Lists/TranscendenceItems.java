package me.sfiguz7.transcendence.Lists;

import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.sfiguz7.transcendence.implementation.core.attributes.Instability;
import me.sfiguz7.transcendence.implementation.utils.TranscendenceLoreBuilder;
import org.bukkit.Material;

public final class TranscendenceItems {

    private TranscendenceItems() {
    }

    /* Items */
    public static final SlimefunItemStack QUIRP_UP = new SlimefunItemStack("QUIRP_UP",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2M0ZDdhM2JjM2RlODMzZDMwMzJlODVhMGJmNmYyYmVmNzY4Nzg2MmIzYzZiYzQwY2U3MzEwNjRmNjE1ZGQ5ZCJ9fX0=",
            "&aQuirp Up",
            "",
            "&9Fundamental particle of the Universe"
    );
    public static final SlimefunItemStack QUIRP_DOWN = new SlimefunItemStack("QUIRP_DOWN",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjlhMDMwY2EyYjJjNmZlNjdmZTgwOTdkM2NkMjA2OTY5ZmM1YzAwMTdjNjBiNmI0MDk5MGM3NzJhNmYwYWMwYSJ9fX0=",
            "&aQuirp Down",
            "",
            "&9Fundamental particle of the Universe"
    );
    public static final SlimefunItemStack QUIRP_LEFT = new SlimefunItemStack("QUIRP_LEFT",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTc2OTVmOTZkZGE2MjZmYWFhMDEwZjRhNWYyOGE1M2NkNjZmNzdkZTBjYzI4MGU3YzU4MjVhZDY1ZWVkYzcyZSJ9fX0=",
            "&aQuirp Left",
            "",
            "&9Fundamental particle of the Universe"
    );
    public static final SlimefunItemStack QUIRP_RIGHT = new SlimefunItemStack("QUIRP_RIGHT",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWY4NjkwNDhmMDZkMzE4ZTUwNThiY2EwYTg3NmE1OTg2MDc5ZjQ1YTc2NGQxMmFiMzRhNDkzMWRiNmI4MGFkYyJ9fX0=",
            "&aQuirp Right",
            "",
            "&9Fundamental particle of the Universe"
    );
    public static final SlimefunItemStack QUIRP_CONDENSATE = new SlimefunItemStack("QUIRPCONDENSATE",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzFlMWY2MTYyZGI0MjI0NTYzOTYwOWY3MjhhNGUxMzRlZDdiZDdkZTNjMTVhNzc5MmQyMTlhNmUyYTlkYiJ9fX0=",
            "&5Quirp Condensate",
            "",
            "&9An energy singularity"
    );
    public static final SlimefunItemStack UNSTABLE_INGOT = new SlimefunItemStack("UNSTABLEINGOT",
            Material.NETHER_BRICK,
            "&4Unstable Ingot",
            "",
            "&9Don't mess with this",
            TranscendenceLoreBuilder.unstable(Instability.HIGH)
    );


    /* Machines */

    public static final SlimefunItemStack QUIRP_OSCILLATOR = new SlimefunItemStack("QUIRP_OSCILLATOR",
            Material.PURPUR_PILLAR,
            "&9Quirp Oscillator",
            "Harnesses quirps from the void",
            "",
            "&cWorks only in the end!",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.powerBuffer(512),
            LoreBuilder.powerPerSecond(256)
    );
    public static final SlimefunItemStack QUIRP_ANNIHILATOR = new SlimefunItemStack("QUIRP_ANNIHILATOR",
            Material.SPONGE,
            "&cQuirp Annihilator",
            "",
            "Condesates opposite quirps",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.powerBuffer(1024),
            LoreBuilder.powerPerSecond(512)
    );
    public static final SlimefunItemStack QUIRP_CYCLER = new SlimefunItemStack("QUIRP_CYCLER",
            Material.END_STONE_BRICKS,
            "&cQuirp Cycler",
            "",
            "Rotates quirps",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.powerBuffer(1024),
            LoreBuilder.powerPerSecond(512)
    );

}
