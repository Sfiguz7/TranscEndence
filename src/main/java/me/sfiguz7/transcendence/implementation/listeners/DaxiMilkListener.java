package me.sfiguz7.transcendence.implementation.listeners;

import me.sfiguz7.transcendence.TranscEndence;
import me.sfiguz7.transcendence.implementation.items.items.Daxi;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

import static org.bukkit.event.EventPriority.LOWEST;

public class DaxiMilkListener implements Listener {

    public DaxiMilkListener(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = LOWEST, ignoreCancelled = true)
    public void onMilkEvent(PlayerItemConsumeEvent e) {
        ItemStack is = e.getItem();
        if (is.getType() == Material.MILK_BUCKET) {
            e.setCancelled(true);
            Player p = e.getPlayer();
            UUID uuid = p.getUniqueId();
            final Map<UUID, Set<Daxi.Type>> activePlayers = TranscEndence.getRegistry().getDaxiEffectPlayers();
            final Set<Daxi.Type> types = activePlayers.get(uuid);
            if (types != null) {
                for (Daxi.Type type : types) {
                    Daxi.applyEffect(p, type);
                }
            }
        }
    }

}