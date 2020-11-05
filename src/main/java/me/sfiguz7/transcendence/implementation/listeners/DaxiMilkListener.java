package me.sfiguz7.transcendence.implementation.listeners;

import me.sfiguz7.transcendence.TranscEndence;
import me.sfiguz7.transcendence.implementation.items.items.Daxi;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.event.EventPriority.LOWEST;

public class DaxiMilkListener implements Listener {

    public DaxiMilkListener(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = LOWEST, ignoreCancelled = true)
    public void onMilkEvent(PlayerItemConsumeEvent e) {
        final ItemStack is = e.getItem();
        if (is.getType() != Material.MILK_BUCKET) {
            return;
        }
        final Player p = e.getPlayer();
        Bukkit.getScheduler().runTask(TranscEndence.getInstance(), () -> Daxi.reapplyEffects(p));
    }
}
