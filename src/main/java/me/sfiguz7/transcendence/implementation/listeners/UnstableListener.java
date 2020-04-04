package me.sfiguz7.transcendence.implementation.listeners;

import me.sfiguz7.transcendence.TranscEndencePlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.event.EventPriority.LOWEST;

public class UnstableListener implements Listener {

    public UnstableListener(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = LOWEST, ignoreCancelled = true)
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        if(TranscEndencePlugin.getRegistry().getUnstableDeathPlayers().contains(p)) {
            e.setDeathMessage(p.getName() + " tried to become unstable. They succeeded.");
        }
    }

}
