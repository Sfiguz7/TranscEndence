package me.sfiguz7.transcendence.implementation.core.attributes;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import me.sfiguz7.transcendence.implementation.items.items.Daxi;
import org.bukkit.entity.ArmorStand;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;


public class TERegistry {

    private final Set<SlimefunItem> unstable = new HashSet<>();
    private final Set<UUID> unstableDeathPlayers = new HashSet<>();
    private final Map<UUID, Set<Daxi.Type>> daxiEffectPlayers = new HashMap<>();
    private final Set<UUID> toggledPlayers = new HashSet<>();
    private final Map<PotionEffectType, Daxi.Type> daxiEffectsMap = new HashMap<>();
    private final Set<ArmorStand> daxiArmorStands = new HashSet<>();

    public Set<SlimefunItem> getUnstableItems() {
        return unstable;
    }

    public Set<UUID> getUnstableDeathPlayers() {
        return unstableDeathPlayers;
    }

    public Map<UUID, Set<Daxi.Type>> getDaxiEffectPlayers() {
        return daxiEffectPlayers;
    }

    public Set<UUID> getToggledPlayers() {
        return toggledPlayers;
    }

    public Map<PotionEffectType, Daxi.Type> getDaxiEffectsMap() { return daxiEffectsMap; }

    public Set<ArmorStand> getDaxiArmorStands() { return daxiArmorStands; }
}
