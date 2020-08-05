package me.sfiguz7.transcendence.implementation.enchantments;

import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.sfiguz7.transcendence.lists.TEItems;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class ShinyEnchantment extends Enchantment {

    public ShinyEnchantment(NamespacedKey key) {
        super(key);
    }

    @Override
    @Deprecated
    public String getName() {
        return "Shiny";
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getStartLevel() {
        return 1;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.ALL;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    @Deprecated
    public boolean isCursed() {
        return false;
    }

    @Override
    public boolean conflictsWith(Enchantment enchantment) {
        return false;
    }

    @Override
    public boolean canEnchantItem(ItemStack itemStack) {
        return SlimefunUtils.isItemSimilar(itemStack, TEItems.NETHER_ESSENCE, false) ||
            SlimefunUtils.isItemSimilar(itemStack, TEItems.CONDENSED_NETHER_ESSENCE, false) ||
            SlimefunUtils.isItemSimilar(itemStack, TEItems.PURE_NETHER_ESSENCE, false);
    }
}

