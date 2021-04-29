package me.sfiguz7.transcendence.implementation.tasks;

import me.sfiguz7.transcendence.TranscEndence;
import me.sfiguz7.transcendence.implementation.items.items.Daxi;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class RecurrentRefreshTask implements Runnable {

    @Override
    public void run() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.isValid() && !p.isDead()) {
                if (TranscEndence.getRegistry().getToggledPlayers().contains(p.getUniqueId())) {
                    return;
                }
                Bukkit.getScheduler().runTask(TranscEndence.getInstance(), () -> Daxi.reapplyEffects(p));
            }
        }
    }

}

