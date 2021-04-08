package me.sfiguz7.transcendence.implementation.tasks;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import me.sfiguz7.transcendence.TranscEndence;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class StableTask implements Runnable {

    TranscEndence instance = TranscEndence.getInstance();

    @Override
    public void run() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.isValid() && !p.isDead() && p.getGameMode().equals(GameMode.SURVIVAL)) {
                checkForInstability(p);
            }
        }
    }

    private void checkForInstability(Player p) {
        //Flag: we set to true if cycling through we do find unstable items
        boolean instCheck = false;
        for (ItemStack item : p.getInventory()) {
            if (isUnstable(item)) {
                // The item is enabled in the world, delete it so it won't drop when we kill the player
                item.setAmount(0);
                instCheck = true;
            }

        }
        if (instCheck) {
            UUID uuid = p.getUniqueId();
            //Add player so listener can send custom message
            TranscEndence.getRegistry().getUnstableDeathPlayers().add(uuid);
            instance.getServer().getScheduler().runTask(instance, () -> {
                //Fake explosion
                double x = p.getLocation().getX();
                double y = p.getLocation().getY();
                double z = p.getLocation().getZ();
                p.getWorld().createExplosion(x, y, z, 0F, false, false);
                //Kill player
                p.setHealth(0);
                //Remove player so next death isn't recognized as unstable explosion
                TranscEndence.getRegistry().getUnstableDeathPlayers().remove(uuid);

            });
        }
    }

    private boolean isUnstable(ItemStack item) {
        for (SlimefunItem unstableItem : TranscEndence.getRegistry().getUnstableItems()) {
            if (unstableItem.isItem(item)) {
                return true;
            }
        }

        return false;
    }

}
