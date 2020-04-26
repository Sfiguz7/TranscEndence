package me.sfiguz7.transcendence.implementation.core.attributes;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


public class TERegistry {

    private final Set<SlimefunItem> unstable = new HashSet<>();
    private final Set<UUID> unstableDeathPlayers = new HashSet<>();

    public Set<SlimefunItem> getUnstableItems() {
        return unstable;
    }

    public Set<UUID> getUnstableDeathPlayers() {
        return unstableDeathPlayers;
    }
}
