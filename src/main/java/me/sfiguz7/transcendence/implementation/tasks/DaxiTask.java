package me.sfiguz7.transcendence.implementation.tasks;

import me.sfiguz7.transcendence.TranscEndence;
import me.sfiguz7.transcendence.implementation.items.items.Daxi;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public class DaxiTask implements Runnable {

    @Override
    public void run() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.isValid() && !p.isDead()) {
                checkForDaxiEffects(p);
            }
        }
    }

    private void checkForDaxiEffects(Player p) {
        UUID uuid = p.getUniqueId();
        Map activePlayers = TranscEndence.getRegistry().getDaxiEffectPlayers();
        if (activePlayers.containsKey(uuid)) {
            for (Daxi.Type type : (Daxi.Type[]) activePlayers.get(uuid)) {
                Daxi.applyEffect(p, type);
            }
        }
    }
}
