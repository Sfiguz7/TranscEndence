package me.sfiguz7.transcendence.Lists;

import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class TranscendenceItems {

    private TranscendenceItems() {
    }

    /* Items */
    public static final SlimefunItemStack quirpup = new SlimefunItemStack("QUIRPUP",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2M0ZDdhM2JjM2RlODMzZDMwMzJlODVhMGJmNmYyYmVmNzY4Nzg2MmIzYzZiYzQwY2U3MzEwNjRmNjE1ZGQ5ZCJ9fX0=",
            "&aQuirp Up",
            "",
            "&9An energy singularity"
    );
    public static final SlimefunItemStack quirpdown = new SlimefunItemStack("QUIRPDOWN",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjlhMDMwY2EyYjJjNmZlNjdmZTgwOTdkM2NkMjA2OTY5ZmM1YzAwMTdjNjBiNmI0MDk5MGM3NzJhNmYwYWMwYSJ9fX0=",
            "&aQuirp Down",
            "",
            "&9An energy singularity"
    );
    public static final SlimefunItemStack quirpleft = new SlimefunItemStack("QUIRPLEFT",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTc2OTVmOTZkZGE2MjZmYWFhMDEwZjRhNWYyOGE1M2NkNjZmNzdkZTBjYzI4MGU3YzU4MjVhZDY1ZWVkYzcyZSJ9fX0=",
            "&aQuirp Left",
            "",
            "&9An energy singularity"
    );
    public static final SlimefunItemStack quirpright = new SlimefunItemStack("QUIRPRIGHT",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWY4NjkwNDhmMDZkMzE4ZTUwNThiY2EwYTg3NmE1OTg2MDc5ZjQ1YTc2NGQxMmFiMzRhNDkzMWRiNmI4MGFkYyJ9fX0=",
            "&aQuirp Right",
            "",
            "&9An energy singularity"
    );


    /* Machines */

    public static final SlimefunItemStack quirpOscillator = new SlimefunItemStack("QUIRP_OSCILLATOR",
            Material.PURPUR_PILLAR,
            "&9Quirp Oscillator",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.powerBuffer(256),
            LoreBuilder.powerPerSecond(36)
    );

}
