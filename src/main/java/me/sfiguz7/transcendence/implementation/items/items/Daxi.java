package me.sfiguz7.transcendence.implementation.items.items;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.sfiguz7.transcendence.TranscEndence;
import me.sfiguz7.transcendence.lists.TEItems;
import me.sfiguz7.transcendence.lists.TERecipeType;
import org.bukkit.ChatColor;
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

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Daxi extends SlimefunItem {

    private final Daxi.Type type;
    TranscEndence instance = TranscEndence.getInstance();

    public Daxi(Type type) {
        super(TEItems.transcendence, type.slimefunItem, TERecipeType.NANOBOT_CRAFTER, type.recipe);

        this.type = type;
    }


    @Override
    public void preRegister() {
        ItemUseHandler itemUseHandler = this::onItemRightClick;
        addItemHandler(itemUseHandler);
    }

    private void onItemRightClick(PlayerRightClickEvent event) {
        Player p = event.getPlayer();
        UUID uuid = p.getUniqueId();
        Map<UUID, Set<Daxi.Type>> activePlayers = TranscEndence.getRegistry().getDaxiEffectPlayers();


        activePlayers.computeIfAbsent(uuid, k -> {
            final Set<Daxi.Type> set = new HashSet<>();
            return set;
        });
        Set<Daxi.Type> effects = activePlayers.get(uuid);
        if (effects.contains(type)) {
            p.sendMessage(ChatColor.LIGHT_PURPLE +
                TranscEndence.getInstance().getConfig().getString("options.already-have-daxi-effect"));
            return;
        } else {
            effects.add(type);
        }

        startAnimation(p);
        applyEffect(p, type);
        p.sendMessage(ChatColor.LIGHT_PURPLE +
            TranscEndence.getInstance().getConfig().getString("options.daxi-message-intro") + "\n" + type.message);
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

        //Adding to registry to be able to check and cancel Manipulation events
        for (ArmorStand as : armorstands) {
            TranscEndence.getRegistry().getDaxiArmorStands().add(as);
        }


        for (int i = 0; i < 4; i++) {
            armorstands[i].getEquipment().setHelmet(type.zotsAnimation[i]);
            armorstands[i].setSmall(true);
            armorstands[i].setCanPickupItems(false);
            armorstands[i].setVisible(false);
        }

        for (int i = 0; i < lasttick; i++) {
            instance.getServer().getScheduler().runTaskLater(instance, () -> moveArmorStands(armorstands, armorstandslocations), i);
        }

        ThreadLocalRandom random = ThreadLocalRandom.current();

        instance.getServer().getScheduler().runTaskLater(instance, () -> {
            for (ArmorStand as : armorstands) {
                //Clearing from registry as they won't exist anymore
                TranscEndence.getRegistry().getDaxiArmorStands().remove(as);
                as.remove();
            }

            for (Color color : type.colors) {
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

    public static void applyEffect(Player p, Type type) {
        p.addPotionEffect(new PotionEffect(type.effect, Integer.MAX_VALUE, type.amplifier));
    }

    public static void reapplyEffects(Player p) {
        final Map<UUID, Set<Daxi.Type>> activePlayers = TranscEndence.getRegistry().getDaxiEffectPlayers();
        final UUID uuid = p.getUniqueId();
        final Set<Daxi.Type> types = activePlayers.get(uuid);
        if (types != null) {
            for (Daxi.Type type : types) {
                Daxi.applyEffect(p, type);
            }
        }
    }

    public enum Type {
        STRENGTH(TEItems.DAXI_STRENGTH,
            new ItemStack[] {TEItems.ZOT_UP_2, TEItems.ZOT_UP_2, TEItems.ZOT_UP_2, TEItems.ZOT_UP_2},
            new ItemStack[] {TEItems.ZOT_UP, TEItems.ZOT_UP, TEItems.ZOT_UP, TEItems.ZOT_UP},
            new Color[] {Color.RED, Color.RED, Color.FUCHSIA, Color.FUCHSIA},
            PotionEffectType.INCREASE_DAMAGE,
            3,
            TranscEndence.getInstance().getConfig().getString("options.daxi-message-strength")
        ),
        ABSORPTION(TEItems.DAXI_ABSORPTION,
            new ItemStack[] {TEItems.ZOT_DOWN_2, TEItems.ZOT_DOWN_2, TEItems.ZOT_DOWN_2, TEItems.ZOT_DOWN_2},
            new ItemStack[] {TEItems.ZOT_DOWN, TEItems.ZOT_DOWN, TEItems.ZOT_DOWN, TEItems.ZOT_DOWN},
            new Color[] {Color.YELLOW, Color.YELLOW, Color.ORANGE, Color.ORANGE},
            PotionEffectType.ABSORPTION,
            5,
            TranscEndence.getInstance().getConfig().getString("options.daxi-message-absorption")
        ),
        FORTITUDE(TEItems.DAXI_FORTITUDE,
            new ItemStack[] {TEItems.ZOT_LEFT_2, TEItems.ZOT_LEFT_2, TEItems.ZOT_LEFT_2, TEItems.ZOT_LEFT_2},
            new ItemStack[] {TEItems.ZOT_LEFT, TEItems.ZOT_LEFT, TEItems.ZOT_LEFT, TEItems.ZOT_LEFT},
            new Color[] {Color.LIME, Color.LIME, Color.GREEN, Color.GREEN},
            PotionEffectType.DAMAGE_RESISTANCE,
            4,
            TranscEndence.getInstance().getConfig().getString("options.daxi-message-fortitude")
        ),
        SATURATION(TEItems.DAXI_SATURATION,
            new ItemStack[] {TEItems.ZOT_RIGHT_2, TEItems.ZOT_RIGHT_2, TEItems.ZOT_RIGHT_2, TEItems.ZOT_RIGHT_2},
            new ItemStack[] {TEItems.ZOT_RIGHT, TEItems.ZOT_RIGHT, TEItems.ZOT_RIGHT, TEItems.ZOT_RIGHT},
            new Color[] {Color.AQUA, Color.AQUA, Color.TEAL, Color.TEAL},
            PotionEffectType.SATURATION,
            1,
            TranscEndence.getInstance().getConfig().getString("options.daxi-message-saturation")
        ),
        REGENERATION(TEItems.DAXI_REGENERATION,
            new ItemStack[] {TEItems.ZOT_UP_2, TEItems.ZOT_LEFT_2, TEItems.ZOT_RIGHT_2, TEItems.ZOT_DOWN_2},
            new ItemStack[] {TEItems.ZOT_UP, TEItems.ZOT_LEFT, TEItems.ZOT_RIGHT, TEItems.ZOT_DOWN},
            new Color[] {Color.RED, Color.YELLOW, Color.LIME, Color.AQUA},
            PotionEffectType.REGENERATION,
            2,
            TranscEndence.getInstance().getConfig().getString("options.daxi-message-regeneration")
        );

        private final SlimefunItemStack slimefunItem;
        private final ItemStack[] zotsAnimation;
        private final Color[] colors;
        private final ItemStack[] recipe;
        private final PotionEffectType effect;
        private final int amplifier;
        private final String message;

        Type(SlimefunItemStack itemStack, ItemStack[] zots, ItemStack[] zotsAnimation, Color[] colors,
             PotionEffectType effect, int level, String message) {
            this.slimefunItem = itemStack;
            this.zotsAnimation = zotsAnimation;
            this.colors = colors;
            this.recipe = new ItemStack[] {
                TEItems.STABLE_BLOCK, zots[0], TEItems.STABLE_BLOCK,
                zots[1], TEItems.STABLE_INGOT, zots[2],
                TEItems.STABLE_BLOCK, zots[3], TEItems.STABLE_BLOCK};
            this.effect = effect;
            this.amplifier = level - 1;
            this.message = message;
        }

        public int getTypeEffectAmplifier() {
            return this.amplifier;
        }
    }
}
