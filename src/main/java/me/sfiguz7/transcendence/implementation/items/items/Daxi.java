package me.sfiguz7.transcendence.implementation.items.items;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.handlers.ItemUseHandler;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.sfiguz7.transcendence.lists.TEItems;
import me.sfiguz7.transcendence.lists.TERecipeType;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.concurrent.ThreadLocalRandom;

public class Daxi extends SlimefunItem {

    private final ItemStack[] zotsAnimation;
    private final Color[] colors;
    private final PotionEffectType effect;
    private final String message;

    public Daxi(Type type) {
        super(TEItems.transcendence, type.slimefunItem, TERecipeType.NANOBOT_CRAFTER, type.recipe);

        this.zotsAnimation = type.zotsAnimation;
        this.colors = type.colors;
        this.effect = type.effect;
        this.message = type.message;
    }


    @Override
    public void preRegister() {
        ItemUseHandler itemUseHandler = this::onItemRightClick;
        addItemHandler(itemUseHandler);
    }

    private void onItemRightClick(PlayerRightClickEvent event) {
        Player p = event.getPlayer();
        startAnimation(p);
        p.addPotionEffect(new PotionEffect(effect, Integer.MAX_VALUE, 0));
        p.sendMessage("You feel power flowing through your veins.\n" + message);
        event.cancel();
        if (event.getHand() == EquipmentSlot.HAND) {
            event.getPlayer().getInventory().setItemInMainHand(null);
        } else {
            event.getPlayer().getInventory().setItemInOffHand(null);
        }
    }

    private void startAnimation(Player p) {
        Location l = p.getLocation();
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
            armorstands[i].getEquipment().setHelmet(zotsAnimation[i]);
            armorstands[i].setSmall(true);
            armorstands[i].setCanPickupItems(false);
            armorstands[i].setVisible(false);
        }

        for (int i = 0; i < lasttick; i++) {
            Slimefun.runSync(() -> {
                moveArmorStands(armorstands, armorstandslocations);
            }, i);
        }

        ThreadLocalRandom random = ThreadLocalRandom.current().current();

        Slimefun.runSync(() -> {
            for (ArmorStand as : armorstands) {
                as.remove();
            }

            for (Color color : colors) {
                for (int i = 0; i < 25; i++) {
                    float xRand = (random.nextFloat() - 0.5F) * 3.2F;
                    float yRand = (random.nextFloat() - 0.5F) * 3.2F;
                    float zRand = (random.nextFloat() - 0.5F) * 3.2F;

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

    private void moveArmorStands(ArmorStand[] as, Vector[] asv) {
        Vector yIncr = new Vector(0, 0.03, 0);
        for (int i = 0; i < 4; i++) {
            Vector v = asv[i].clone().rotateAroundY(40).add(yIncr).subtract(asv[i]).normalize();
            as[i].setVelocity(v);
            asv[i] = asv[i].add(v);
        }
    }

    public enum Type {
        STRENGTH(TEItems.DAXI_STRENGTH,
                new ItemStack[]{TEItems.ZOT_UP_2, TEItems.ZOT_UP_2, TEItems.ZOT_UP_2, TEItems.ZOT_UP_2},
                new ItemStack[]{TEItems.ZOT_UP, TEItems.ZOT_UP, TEItems.ZOT_UP, TEItems.ZOT_UP},
                new Color[]{Color.RED, Color.RED, Color.FUCHSIA, Color.FUCHSIA},
                PotionEffectType.INCREASE_DAMAGE,
                "Your strikes are now more effective."
        ),
        ABSORPTION(TEItems.DAXI_ABSORPTION,
                new ItemStack[]{TEItems.ZOT_DOWN_2, TEItems.ZOT_DOWN_2, TEItems.ZOT_DOWN_2, TEItems.ZOT_DOWN_2},
                new ItemStack[]{TEItems.ZOT_DOWN, TEItems.ZOT_DOWN, TEItems.ZOT_DOWN, TEItems.ZOT_DOWN},
                new Color[]{Color.YELLOW, Color.YELLOW, Color.ORANGE, Color.ORANGE},
                PotionEffectType.ABSORPTION,
                "You feel healthier."
        ),
        FORTITUDE(TEItems.DAXI_FORTITUDE,
                new ItemStack[]{TEItems.ZOT_LEFT_2, TEItems.ZOT_LEFT_2, TEItems.ZOT_LEFT_2, TEItems.ZOT_LEFT_2},
                new ItemStack[]{TEItems.ZOT_LEFT, TEItems.ZOT_LEFT, TEItems.ZOT_LEFT, TEItems.ZOT_LEFT},
                new Color[]{Color.LIME, Color.LIME, Color.GREEN, Color.GREEN},
                PotionEffectType.DAMAGE_RESISTANCE,
                "Enemy strikes are now less effective."
        ),
        SATURATION(TEItems.DAXI_SATURATION,
                new ItemStack[]{TEItems.ZOT_RIGHT_2, TEItems.ZOT_RIGHT_2, TEItems.ZOT_RIGHT_2, TEItems.ZOT_RIGHT_2},
                new ItemStack[]{TEItems.ZOT_RIGHT, TEItems.ZOT_RIGHT, TEItems.ZOT_RIGHT, TEItems.ZOT_RIGHT},
                new Color[]{Color.AQUA, Color.AQUA, Color.TEAL, Color.TEAL},
                PotionEffectType.SATURATION,
                "You won't need food for a while."
        ),
        REGENERATION(TEItems.DAXI_REGENERATION,
                new ItemStack[]{TEItems.ZOT_UP_2, TEItems.ZOT_DOWN_2, TEItems.ZOT_LEFT_2, TEItems.ZOT_RIGHT_2},
                new ItemStack[]{TEItems.ZOT_UP, TEItems.ZOT_DOWN, TEItems.ZOT_LEFT, TEItems.ZOT_RIGHT},
                new Color[]{Color.RED, Color.YELLOW, Color.LIME, Color.AQUA},
                PotionEffectType.REGENERATION,
                "You've acquired permanent self-healing."
        );

        private final SlimefunItemStack slimefunItem;
        private final ItemStack[] zotsAnimation;
        private final Color[] colors;
        private final ItemStack[] recipe;
        private final PotionEffectType effect;
        private final String message;

        Type(SlimefunItemStack itemStack, ItemStack[] zots, ItemStack[] zotsAnimation, Color[] colors,
             PotionEffectType effect, String message) {
            this.slimefunItem = itemStack;
            this.zotsAnimation = zotsAnimation;
            this.colors = colors;
            this.recipe = new ItemStack[]{
                    TEItems.STABLE_BLOCK, zots[0], TEItems.STABLE_BLOCK,
                    zots[1], TEItems.STABLE_BLOCK, zots[2],
                    TEItems.STABLE_BLOCK, zots[3], TEItems.STABLE_BLOCK};
            this.effect = effect;
            this.message = message;
        }
    }
}
