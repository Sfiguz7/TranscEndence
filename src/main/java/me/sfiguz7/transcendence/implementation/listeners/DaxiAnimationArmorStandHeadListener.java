package me.sfiguz7.transcendence.implementation.listeners;

import me.sfiguz7.transcendence.TranscEndence;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.event.EventPriority.LOWEST;

public class DaxiAnimationArmorStandHeadListener implements Listener {

    public DaxiAnimationArmorStandHeadListener(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = LOWEST)
    public void onHelmetEvent(PlayerArmorStandManipulateEvent e) {
        if (TranscEndence.getRegistry().getDaxiArmorStands().contains(e.getRightClicked()))
            e.setCancelled(true);
    }
}