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

public class StableTask implements Runnable {

    private final Set<PotionEffect> radiationEffects;

    public StableTask() {
        Set<PotionEffect> effects = new HashSet<>();
        effects.add(new PotionEffect(PotionEffectType.WITHER, 400, 2));
        effects.add(new PotionEffect(PotionEffectType.BLINDNESS, 400, 3));
        effects.add(new PotionEffect(PotionEffectType.CONFUSION, 400, 3));
        effects.add(new PotionEffect(PotionEffectType.WEAKNESS, 400, 2));
        effects.add(new PotionEffect(PotionEffectType.SLOW, 400, 1));
        effects.add(new PotionEffect(PotionEffectType.SLOW_DIGGING, 400, 1));
        radiationEffects = Collections.unmodifiableSet(effects);
    }

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
            //Add player so listener can send custom message
            TranscEndencePlugin.getRegistry().getUnstableDeathPlayers().add(p);
            Slimefun.runSync(() -> {
                //Fake explosion
                double x = p.getLocation().getX();
                double y = p.getLocation().getY();
                double z = p.getLocation().getZ();
                p.getWorld().createExplosion(x, y, z, 0F, false, false);
                //Kill player
                p.setHealth(0);
                //Remove player so next death isn't recognized as unstable explosion
                TranscEndencePlugin.getRegistry().getUnstableDeathPlayers().remove(p);

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
