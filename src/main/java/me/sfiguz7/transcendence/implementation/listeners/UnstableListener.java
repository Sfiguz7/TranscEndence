package me.sfiguz7.transcendence.implementation.listeners;

import me.sfiguz7.transcendence.TranscEndence;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

import static org.bukkit.event.EventPriority.LOWEST;

public class UnstableListener implements Listener {

    public UnstableListener(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = LOWEST, ignoreCancelled = true)
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        UUID uuid = p.getUniqueId();
        if (TranscEndence.getRegistry().getUnstableDeathPlayers().contains(uuid)) {
            TranscEndence instance = TranscEndence.getInstance();
            e.setDeathMessage(p.getName() + instance.getConfig().getString("options.unstable-death-message"));
        }
    }

}
