package me.sfiguz7.transcendence.implementation.tasks;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import me.sfiguz7.transcendence.TranscEndencePlugin;
import me.sfiguz7.transcendence.api.TranscEndence;
import me.sfiguz7.transcendence.implementation.core.attributes.TranscendenceRegistry;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class StableTask implements Runnable {

    @Override
    public void run() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (!p.isValid() || p.isDead()) {
                continue;
            }
            checkForInstability(p);
        }
    }

    private void checkForInstability(Player p) {
        //Flag: we set to true if cycling through we do find unstable items
        boolean instCheck = false;
        for (ItemStack item : p.getInventory()) {
            if (isUnstable(p, item)) {
                // The item is enabled in the world, delete it so it won't drop when we kill the player
                item.setAmount(0);
                instCheck = true;
            }

        }
        if (instCheck) {
            UUID uuid = p.getUniqueId();
            //Add player so listener can send custom message
            TranscEndencePlugin.getRegistry().getUnstableDeathPlayers().add(uuid);
            Slimefun.runSync(() -> {
                //Fake explosion
                double x = p.getLocation().getX();
                double y = p.getLocation().getY();
                double z = p.getLocation().getZ();
                p.getWorld().createExplosion(x, y, z, 0F, false, false);
                //Kill player
                p.setHealth(0);
                //Remove player so next death isn't recognized as unstable explosion
                TranscEndencePlugin.getRegistry().getUnstableDeathPlayers().remove(uuid);

            });
        }
    }

    private boolean isUnstable(Player p, ItemStack item) {
        for (SlimefunItem unstableItem : TranscEndencePlugin.getRegistry().getUnstableItems()) {
            if (unstableItem.isItem(item) &&
                    TranscEndence.isEnabled(p, unstableItem, true)) {
                return true;
            }
        }

        return false;
    }

}
