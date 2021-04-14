package me.sfiguz7.transcendence.implementation.listeners;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.sfiguz7.transcendence.TranscEndence;
import me.sfiguz7.transcendence.implementation.items.UnstableItem;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.event.EventPriority.LOWEST;

public class UnstableIngotDropListener implements Listener {

    boolean isDroppable;
    TranscEndence instance = TranscEndence.getInstance();

    public UnstableIngotDropListener(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        isDroppable = instance.getConfig().getBoolean("option.droppable-unstable-ingots");
    }

    @EventHandler(priority = LOWEST, ignoreCancelled = true)
    public void onIngotDrop(PlayerDropItemEvent e) {
        if (isDroppable) {
            return;
        }
        SlimefunItem sfItem = SlimefunItem.getByItem(e.getItemDrop().getItemStack());
        if (sfItem instanceof UnstableItem) {
            Player p = e.getPlayer();
            p.sendMessage(ChatColor.LIGHT_PURPLE + "TranscEndence > " + ChatColor.RED +
                instance.getConfig().getString("options.unstable-ingots-message-undroppable"));
            e.setCancelled(true);
        }
    }
}
