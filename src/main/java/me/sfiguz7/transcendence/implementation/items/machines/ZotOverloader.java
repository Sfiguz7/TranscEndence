package me.sfiguz7.transcendence.implementation.items.machines;

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
import me.mrCookieSlime.Slimefun.cscorelib2.data.PersistentDataAPI;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import me.sfiguz7.transcendence.TranscEndencePlugin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
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
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.ZOT_DOWN_2;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.ZOT_LEFT;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.ZOT_LEFT_2;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.ZOT_RIGHT;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.ZOT_RIGHT_2;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.ZOT_UP;
import static me.sfiguz7.transcendence.Lists.TranscendenceItems.ZOT_UP_2;

public class ZotOverloader extends SimpleSlimefunItem<BlockTicker> implements InventoryBlock, EnergyNetComponent {

    private static final int ENERGY_CONSUMPTION = 1024;

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
                19, 20, 21, 22};
    }

    @Override
    public int[] getOutputSlots() {
        return new int[]{};
    }

    private int getSlot() {
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

                    //Check if zot in "product" slot is fully charged
                    //We only act if zot isn't fully charged
                    int requiredCharge = 1000;
                    NamespacedKey chargeKey = new NamespacedKey(TranscEndencePlugin.getInstance(), "charge");
                    ItemMeta zotMeta = zot.getItemMeta();
                    if (!PersistentDataAPI.hasInt(zotMeta, chargeKey)) {
                        PersistentDataAPI.setInt(zotMeta, chargeKey, 0);
                    }
                    int zotCharge = PersistentDataAPI.getInt(zotMeta, chargeKey);
                    if (zotCharge >= requiredCharge) {
                        return;
                    }

                    //Check if any item in input slots is allowed
                    ItemStack[] input = new ItemStack[4];
                    int j = 0;
                    for (int i : getInputSlots()) {
                        input[j] = menu.getItemInSlot(i);
                        if (input[j] == null) {
                            j++;
                            continue;
                        }

                        NamespacedKey slotKey = new NamespacedKey(TranscEndencePlugin.getInstance(), "slot");
                        ItemMeta itemMeta = input[j].getItemMeta();
                        PersistentDataAPI.setInt(itemMeta, slotKey, i);
                        input[j].setItemMeta(itemMeta);
                        j++;
                    }

                    for (ItemStack inp : input) {
                        if (inp != null && isAllowed(inp, allowedInputItems)) {
                            //Same spin count 1:1, different spin count 16:1
                            //We need to check which case it is and if we have enough
                            String inpSpin = inp.getItemMeta().getDisplayName().split(" ")[1];
                            String zotSpin = zot.getItemMeta().getDisplayName().split(" ")[1];
                            int inpToBeRemoved = inpRemoveCalc(inpSpin, zotSpin);
                            //Not enough inputs
                            if (inp.getAmount() < inpToBeRemoved) {
                                continue;
                            }

                            //All bad scenarios explored: we can overload!
                            NamespacedKey slotKey = new NamespacedKey(TranscEndencePlugin.getInstance(), "slot");
                            ItemMeta inpMeta = inp.getItemMeta();
                            int slot = PersistentDataAPI.getInt(inpMeta, slotKey);
                            List lore = zot.getItemMeta().getLore();
                            if (zotCharge == requiredCharge - 1) {
                                menu.replaceExistingItem(getSlot(), getZot(zotSpin));
                            } else {
                                lore.set(1, lore.get(1).toString()
                                        .split(": ")[0] + ": " + ChatColor.YELLOW + ++zotCharge + "/" + requiredCharge);
                                zotMeta.setLore(lore);
                            }

                            PersistentDataAPI.setInt(zotMeta, chargeKey, zotCharge);
                            zot.setItemMeta(zotMeta);
                            ChargableBlock.addCharge(b, -ENERGY_CONSUMPTION);
                            if (inp.getAmount() == inpToBeRemoved) {
                                menu.replaceExistingItem(slot, null);
                            } else {
                                inp.setAmount(inp.getAmount() - inpToBeRemoved);
                            }
                            break;


                        }


                    }
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

    private ItemStack getZot(String zotSpin) {
        if (zotSpin.compareTo("Up") == 0) {
            return ZOT_UP_2;
        } else if (zotSpin.compareTo("Down") == 0) {
            return ZOT_DOWN_2;
        } else if (zotSpin.compareTo("Left") == 0) {
            return ZOT_LEFT_2;
        }
        return ZOT_RIGHT_2;

    }

    //This method will return how many inps must be removed (16:1 different spin, 1:1 same spin)
    private int inpRemoveCalc(String inpSpin, String zotSpin) {
        int inpToBeRemoved = 1;
        if (inpSpin.compareTo(zotSpin) != 0) {
            inpToBeRemoved = 16;
        }
        return inpToBeRemoved;
    }

}


