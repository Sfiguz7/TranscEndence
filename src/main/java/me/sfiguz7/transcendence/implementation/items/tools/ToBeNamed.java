package me.sfiguz7.transcendence.implementation.items.tools;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockUseHandler;
import me.mrCookieSlime.Slimefun.Objects.handlers.ItemUseHandler;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.sfiguz7.transcendence.implementation.utils.VectorAPI;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.concurrent.ThreadLocalRandom;

import static me.sfiguz7.transcendence.Lists.TranscendenceItems.ZOT_DOWN;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.ZOT_LEFT;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.ZOT_RIGHT;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.ZOT_UP;

public class ToBeNamed extends SlimefunItem {

    public ToBeNamed(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    private static final ItemStack[] zots = {
            ZOT_UP,
            ZOT_DOWN,
            ZOT_LEFT,
            ZOT_RIGHT
    };

    private static final Color[] colors = {
            Color.RED,
            Color.YELLOW,
            Color.LIME,
            Color.AQUA
    };

    @Override
    public void preRegister() {
        BlockUseHandler blockUseHandler = this::onBlockRightClick;
        addItemHandler(blockUseHandler);

        ItemUseHandler itemUseHandler = this::onItemRightClick;
        addItemHandler(itemUseHandler);
    }

    private void onBlockRightClick(PlayerRightClickEvent event) {
        event.cancel();
    }

    private void onItemRightClick(PlayerRightClickEvent event) {
        startAnimation(event.getPlayer());
    }

    public void startAnimation(Player p) {
        Location l = p.getLocation();
        World world = p.getWorld();
        int lasttick = 105;
        Location locas1 = l.clone().add(1, -0.8, 0);
        Location locas2 = l.clone().add(0, -0.8, 1);
        Location locas3 = l.clone().add(-1, -0.8, 0);
        Location locas4 = l.clone().add(0, -0.8, -1);

        ArmorStand as1 = (ArmorStand) p.getWorld().spawnEntity(locas1, EntityType.ARMOR_STAND);
        ArmorStand as2 = (ArmorStand) p.getWorld().spawnEntity(locas2, EntityType.ARMOR_STAND);
        ArmorStand as3 = (ArmorStand) p.getWorld().spawnEntity(locas3, EntityType.ARMOR_STAND);
        ArmorStand as4 = (ArmorStand) p.getWorld().spawnEntity(locas4, EntityType.ARMOR_STAND);

        Vector vas1 = new Vector(1, -0.8, 0);
        Vector vas2 = new Vector(1, -0.8, 1);
        Vector vas3 = new Vector(-1, -0.8, 0);
        Vector vas4 = new Vector(1, -0.8, -1);

        ArmorStand[] armorstands = {as1, as2, as3, as4};
        Vector[] armorstandslocations = {vas1, vas2, vas3, vas4};

        for (int i = 0; i < 4; i++) {
            armorstands[i].getEquipment().setHelmet(zots[i]);
            armorstands[i].setSmall(true);
            armorstands[i].setCanPickupItems(false);
            armorstands[i].setVisible(false);
        }

        for (int i = 0; i < lasttick; i++) {
            Slimefun.runSync(() -> {
                moveArmorStands(armorstands, armorstandslocations, world);
            }, i);
        }

        ThreadLocalRandom random = ThreadLocalRandom.current().current();

        Slimefun.runSync(() -> {
            for (ArmorStand as : armorstands) {
                as.remove();
            }

            for (Color color : colors) {
                for (int i = 0; i < 25; i++) {
                    Float xRand = (random.nextFloat() - 0.5F) * 3.2F;
                    Float yRand = (random.nextFloat() - 0.5F) * 3.2F;
                    Float zRand = (random.nextFloat() - 0.5F) * 3.2F;

                    p.getWorld().spawnParticle(Particle.REDSTONE,
                            l.getX() + (double) xRand,
                            l.getY() + 2.0D + (double) yRand,
                            l.getZ() + (double) zRand,
                            i,
                            new Particle.DustOptions(color, 1));
                }
            }

            p.getWorld().playSound(l, Sound.ENTITY_ZOMBIE_VILLAGER_CURE, 1F, 1F);
        }, lasttick);


    }

    public void moveArmorStands(ArmorStand[] as, Vector[] asv, World world) {
        Vector yIncr = new Vector(0, 0.03, 0);
        for (int i = 0; i < 4; i++) {
            Vector v = asv[i].clone().rotateAroundY(40).add(yIncr).subtract(asv[i]).normalize();
            as[i].setVelocity(v);
            asv[i] = asv[i].add(v);
        }
    }


    /*public Location[] calcNextLocs(Location[] asl) {
        Location[] loc = new Location[4];
        for (int i = 0; i < 4; i++) {
            loc[i] = asl[i].clone();
            System.out.println(loc[i]);


            loc[i].add(0, 0.5, 0);
            loc[i].setYaw(loc[i].getYaw() + 15F);
            System.out.println(loc[i]);
        }
        return loc;
    }*/
}
