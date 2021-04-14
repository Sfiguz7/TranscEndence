package me.sfiguz7.transcendence.implementation.listeners;

import me.sfiguz7.transcendence.TranscEndence;
import me.sfiguz7.transcendence.implementation.items.items.Daxi;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Map;

import static org.bukkit.event.EventPriority.HIGHEST;

public class DaxiEffectModificationListener implements Listener {

    public DaxiEffectModificationListener(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = HIGHEST, ignoreCancelled = true)
    public void onEffectModificationEvent(EntityPotionEffectEvent e) {
        if (e.getEntity() instanceof Player) {
            final PotionEffect newEffect = e.getNewEffect();
            if (newEffect != null) {
                final Daxi.Type daxiType = getEffectDaxiType(e.getModifiedType());
                if (daxiType != null
                    && newEffect.getAmplifier() != daxiType.amplifier) {
                    final Player p = (Player) e.getEntity();
                    Bukkit.getScheduler().runTask(TranscEndence.getInstance(), () -> Daxi.reapplyEffects(p));
                }
            } else {
                final Player p = (Player) e.getEntity();
                Bukkit.getScheduler().runTask(TranscEndence.getInstance(), () -> Daxi.reapplyEffects(p));
            }
        }
    }

    private Daxi.Type getEffectDaxiType(PotionEffectType type) {
        return TranscEndence.getRegistry().getDaxiEffectsMap().getOrDefault(type, null);
    }
}

