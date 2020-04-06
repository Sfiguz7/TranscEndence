package me.sfiguz7.transcendence.implementation.items.machines;

import com.sun.tools.javac.jvm.Items;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SimpleSlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.interfaces.InventoryBlock;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.api.energy.ChargableBlock;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.cscorelib2.inventory.ItemUtils;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

import static me.sfiguz7.transcendence.Lists.TranscendenceItems.QUIRP_DOWN;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.QUIRP_LEFT;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.QUIRP_RIGHT;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.QUIRP_UP;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.ZOT_DOWN;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.ZOT_LEFT;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.ZOT_RIGHT;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.ZOT_UP;

public class ZotOverloader extends SimpleSlimefunItem<BlockTicker> implements InventoryBlock, EnergyNetComponent {

    private static final int ENERGY_CONSUMPTION = 1024;
    private ItemStack[] quirps = {
    };
    private int[] chances = {25,
            25,
            25,
            25
    };

    private final int[] border = {
            0, 1, 2, 3, 4, 5, 6, 7, 8,
            36, 37, 38, 39, 40, 41, 42, 43, 44
    };
    private final int[] inputBorder = {
            9, 10, 11, 12, 13, 14,
            18, 23,
            27, 28, 29, 30, 31, 32
    };
    private final int[] slotsBorder = {
            15, 16, 17,
            24, 26,
            33, 34, 35,
    };
    private final ItemStack[] allowedSlotsItems = {
            ZOT_UP,
            ZOT_DOWN,
            ZOT_LEFT,
            ZOT_RIGHT
    };
    private final ItemStack[] allowedInputItems = {
            QUIRP_UP,
            QUIRP_DOWN,
            QUIRP_LEFT,
            QUIRP_RIGHT
    };

    public ZotOverloader(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);

        createPreset(this, this::constructMenu);
    }

    private void constructMenu(BlockMenuPreset preset) {
        for (int i : border) {
            preset.addItem(i, new CustomItem(new ItemStack(Material.GRAY_STAINED_GLASS_PANE), " "), ChestMenuUtils.getEmptyClickHandler());
        }
        for (int i : inputBorder) {
            preset.addItem(i, new CustomItem(new ItemStack(Material.CYAN_STAINED_GLASS_PANE), " "), ChestMenuUtils.getEmptyClickHandler());
        }
        for (int i : slotsBorder) {
            preset.addItem(i, new CustomItem(new ItemStack(Material.RED_STAINED_GLASS_PANE), " "), ChestMenuUtils.getEmptyClickHandler());
        }
    }

    @Override
    public int[] getInputSlots() {
        return new int[]{
                19, 20,
                28, 29};
    }

    @Override
    public int[] getOutputSlots() {
        return new int[]{};
    }

    public int getSlot() {
        return 25;
    }

    @Override
    public EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.CONSUMER;
    }

    @Override
    public int getCapacity() {
        return 2048;
    }

    @Override
    public BlockTicker getItemHandler() {
        return new BlockTicker() {

            @Override
            public void tick(Block b, SlimefunItem sf, Config data) {

                if (b.getWorld().getEnvironment() != World.Environment.THE_END) {
                    return;
                }

                if (ChargableBlock.getCharge(b) >= ENERGY_CONSUMPTION) {
                    BlockMenu menu = BlockStorage.getInventory(b);

                    //Check if item in "product" slot is a allowed
                    ItemStack zot = menu.getItemInSlot(getSlot());
                    if (zot == null || !isAllowed(zot, allowedSlotsItems) || zot.getAmount() != 1) {
                            return;
                    }

                    //Check if any item in input slots is allowed
                    for (int i : getInputSlots()) {
                        ItemStack input = menu.getItemInSlot(i);
                        if (input != null && isAllowed(input, allowedInputItems)) {
                            break;
                        }
                        return;
                    }

                    ChargableBlock.addCharge(b, -ENERGY_CONSUMPTION);
                    overloadZot(zot);
                }
            }

            @Override
            public boolean isSynchronized() {
                return true;
            }
        };
    }

    private boolean isAllowed(ItemStack item, ItemStack[] allowed) {
        for (ItemStack i : allowed) {
            if (SlimefunUtils.isItemSimilar(item, i, false)) {
                return true;
            }
        }
        return false;
    }

    private void overloadZot(ItemStack zot) {
        List<String> lore = zot.getItemMeta().getLore();
        System.out.println(lore.size());
        int charge = Integer.parseInt(ChatColor.stripColor(lore.get(0)).split(": ")[1]) + 1;
        int requiredCharge = 3456;

        if (charge < requiredCharge) {
            lore.set(1, ChatColor.translateAlternateColorCodes('&', lore.get(1).split(": ")[0] + ": &e" + charge));
            ItemMeta meta = zot.getItemMeta();
            meta.setLore(lore);
            zot.setItemMeta(meta);
        }
    }

}


