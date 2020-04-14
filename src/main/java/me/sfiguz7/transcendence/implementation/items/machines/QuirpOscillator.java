package me.sfiguz7.transcendence.implementation.items.machines;

import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
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
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import me.sfiguz7.transcendence.lists.TranscendenceItems;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.ThreadLocalRandom;

import static me.sfiguz7.transcendence.lists.TranscendenceItems.HORIZONTAL_POLARIZER;
import static me.sfiguz7.transcendence.lists.TranscendenceItems.VERTICAL_POLARIZER;

public class QuirpOscillator extends SimpleSlimefunItem<BlockTicker> implements InventoryBlock, EnergyNetComponent {

    private static final int ENERGY_CONSUMPTION = 128;
    private int decrement = 20;
    private ItemStack[] quirps = {TranscendenceItems.QUIRP_UP,
            TranscendenceItems.QUIRP_DOWN,
            TranscendenceItems.QUIRP_LEFT,
            TranscendenceItems.QUIRP_RIGHT
    };
    private int[] chancesDefault = {25,
            25,
            25,
            25
    };
    private int[] chancesVertical = {40,
            40,
            10,
            10
    };
    private int[] chancesHorizontal = {10,
            10,
            40,
            40
    };
    private final int[] border = {
            0, 1, 2, 3, 4, 5, 6, 7, 8,
            12, 13,
            21, 22,
            30, 31,
            36, 37, 38, 39, 40, 41, 42, 43, 44
    };
    private final int[] inputBorder = {};
    private final int[] outputBorder = {
            14, 15, 16, 17,
            23, 26,
            32, 33, 34, 35
    };
    private final int[] polarizerBorder = {
            9, 10, 11,
            18, 20,
            27, 28, 29
    };

    public QuirpOscillator(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
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
        for (int i : outputBorder) {
            preset.addItem(i, new CustomItem(new ItemStack(Material.ORANGE_STAINED_GLASS_PANE), " "), ChestMenuUtils.getEmptyClickHandler());
        }
        for (int i : polarizerBorder) {
            preset.addItem(i, new CustomItem(new ItemStack(Material.PURPLE_STAINED_GLASS_PANE), " "), ChestMenuUtils.getEmptyClickHandler());
        }

        for (int i : getOutputSlots()) {
            preset.addMenuClickHandler(i, new ChestMenu.AdvancedMenuClickHandler() {

                @Override
                public boolean onClick(Player p, int slot, ItemStack cursor, ClickAction action) {
                    return false;
                }

                @Override
                public boolean onClick(InventoryClickEvent e, Player p, int slot, ItemStack cursor, ClickAction action) {
                    return cursor == null || cursor.getType() == Material.AIR;
                }
            });
        }
    }

    @Override
    public int[] getInputSlots() {
        return new int[]{};
    }

    @Override
    public int[] getOutputSlots() {
        return new int[]{24, 25};
    }

    private int getPolarizerSlot() {
        return 19;
    }

    @Override
    public EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.CONSUMER;
    }

    @Override
    public int getCapacity() {
        return 512;
    }

    @Override
    public BlockTicker getItemHandler() {
        return new BlockTicker() {

            @Override
            public void tick(Block b, SlimefunItem sf, Config data) {

                if (b.getWorld().getEnvironment() != World.Environment.THE_END) {
                    return;
                }

                if (--decrement != 0) {
                    return;
                }
                decrement = 10;

                BlockMenu menu = BlockStorage.getInventory(b);
                ItemStack output = getQuirp(menu);

                if (ChargableBlock.getCharge(b) >= ENERGY_CONSUMPTION) {

                    if (!menu.fits(output, getOutputSlots())) {
                        return;
                    }

                    ChargableBlock.addCharge(b, -ENERGY_CONSUMPTION);
                    menu.pushItem(output, getOutputSlots());
                }
            }

            private ItemStack getQuirp(BlockMenu menu) {
                int index = ThreadLocalRandom.current().nextInt(100);
                int accruedchance = 0;
                int[] chances = getChances(menu);
                for (int i = 0; i < quirps.length; i++) {
                    accruedchance += chances[i];
                    if (index < accruedchance) {
                        return quirps[i];
                    }
                }
                //Never reached
                return new ItemStack(Material.AIR);
            }

            private int[] getChances(BlockMenu menu) {
                ItemStack pol = menu.getItemInSlot(getPolarizerSlot());
                if (SlimefunUtils.isItemSimilar(pol, VERTICAL_POLARIZER, true)) {
                    return chancesVertical;
                }
                if (SlimefunUtils.isItemSimilar(pol, HORIZONTAL_POLARIZER, true)) {
                    return chancesHorizontal;
                }
                return chancesDefault;
            }

            @Override
            public boolean isSynchronized() {
                return true;
            }
        };
    }

}


