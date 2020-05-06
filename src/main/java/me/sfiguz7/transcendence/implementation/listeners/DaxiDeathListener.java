package me.sfiguz7.transcendence.implementation.listeners;

import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import me.sfiguz7.transcendence.TranscEndence;
import me.sfiguz7.transcendence.implementation.items.items.Daxi;
import me.sfiguz7.transcendence.lists.TEItems;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

import static org.bukkit.event.EventPriority.LOWEST;

public class DaxiDeathListener implements Listener {

    public DaxiDeathListener(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = LOWEST, ignoreCancelled = true)
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        UUID uuid = p.getUniqueId();
        Map<UUID, Set<Daxi.Type>> activePlayers = TranscEndence.getRegistry().getDaxiEffectPlayers();
        if (activePlayers.get(uuid) != null) {
            for (Daxi.Type type : activePlayers.get(uuid)) {
                e.getDrops().add(new CustomItem(TEItems.STABLE_BLOCK, 8));
            }
            activePlayers.remove(uuid);
        }
    }

}