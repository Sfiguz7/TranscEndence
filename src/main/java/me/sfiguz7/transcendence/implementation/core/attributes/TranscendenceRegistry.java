package me.sfiguz7.transcendence.implementation.core.attributes;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * This class houses a lot of instances of {@link Map} and {@link List} that hold
 * various mappings and collections related to {@link SlimefunItem}.
 *
 * @author TheBusyBiscuit
 */
public class TranscendenceRegistry {

    private final Set<SlimefunItem> unstable = new HashSet<>();
    private final Set<UUID> unstableDeathPlayers = new HashSet<>();

    public Set<SlimefunItem> getUnstableItems() {
        return unstable;
    }

    public Set<UUID> getUnstableDeathPlayers() {
        return unstableDeathPlayers;
    }
}
