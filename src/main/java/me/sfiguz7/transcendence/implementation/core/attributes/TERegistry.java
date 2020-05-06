package me.sfiguz7.transcendence.implementation.core.attributes;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.sfiguz7.transcendence.implementation.items.items.Daxi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;


public class TERegistry {

    private final Set<SlimefunItem> unstable = new HashSet<>();
    private final Set<UUID> unstableDeathPlayers = new HashSet<>();
    private final Map<UUID, Set<Daxi.Type>> daxiEffectPlayers = new HashMap<>();

    public Set<SlimefunItem> getUnstableItems() {
        return unstable;
    }

    public Set<UUID> getUnstableDeathPlayers() {
        return unstableDeathPlayers;
    }
    public Map<UUID, Set<Daxi.Type>> getDaxiEffectPlayers() {
        return daxiEffectPlayers;
    }
}
