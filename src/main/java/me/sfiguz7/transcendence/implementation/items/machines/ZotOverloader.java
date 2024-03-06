package me.sfiguz7.transcendence.implementation.items.machines;

import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.data.persistent.PersistentDataAPI;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.sfiguz7.transcendence.TranscEndence;
import me.sfiguz7.transcendence.implementation.utils.interfaces.TEInventoryBlock;
import me.sfiguz7.transcendence.lists.TEItems;
import me.sfiguz7.transcendence.lists.TERecipeType;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

import static me.sfiguz7.transcendence.lists.TEItems.QUIRP_DOWN;
import static me.sfiguz7.transcendence.lists.TEItems.QUIRP_LEFT;
import static me.sfiguz7.transcendence.lists.TEItems.QUIRP_RIGHT;
import static me.sfiguz7.transcendence.lists.TEItems.QUIRP_UP;
import static me.sfiguz7.transcendence.lists.TEItems.ZOT_DOWN;
import static me.sfiguz7.transcendence.lists.TEItems.ZOT_DOWN_2;
import static me.sfiguz7.transcendence.lists.TEItems.ZOT_LEFT;
import static me.sfiguz7.transcendence.lists.TEItems.ZOT_LEFT_2;
import static me.sfiguz7.transcendence.lists.TEItems.ZOT_RIGHT;
import static me.sfiguz7.transcendence.lists.TEItems.ZOT_RIGHT_2;
import static me.sfiguz7.transcendence.lists.TEItems.ZOT_UP;
import static me.sfiguz7.transcendence.lists.TEItems.ZOT_UP_2;

public class ZotOverloader extends SimpleSlimefunItem<BlockTicker> implements TEInventoryBlock, EnergyNetComponent {

    private static final int ENERGY_CONSUMPTION = 1024;
    private static final int ZOT_SLOT = 25;
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

    public ZotOverloader() {
        super(TEItems.transcendence, TEItems.ZOT_OVERLOADER, TERecipeType.NANOBOT_CRAFTER,
            new ItemStack[] {TEItems.QUIRP_CONDENSATE, TEItems.QUIRP_UP, TEItems.QUIRP_CONDENSATE,
                TEItems.QUIRP_LEFT, TEItems.STABLE_BLOCK, TEItems.QUIRP_RIGHT,
                TEItems.QUIRP_CONDENSATE, TEItems.QUIRP_DOWN, TEItems.QUIRP_CONDENSATE});

        createPreset(this, this::constructMenu);
        addItemHandler(onBreak());
    }

    private void constructMenu(BlockMenuPreset preset) {
        for (int i : border) {
            preset.addItem(i, new CustomItemStack(new ItemStack(Material.GRAY_STAINED_GLASS_PANE), " "),
                ChestMenuUtils.getEmptyClickHandler());
        }
        for (int i : inputBorder) {
            preset.addItem(i, new CustomItemStack(new ItemStack(Material.CYAN_STAINED_GLASS_PANE), " "),
                ChestMenuUtils.getEmptyClickHandler());
        }
        for (int i : slotsBorder) {
            preset.addItem(i, new CustomItemStack(new ItemStack(Material.RED_STAINED_GLASS_PANE), " "),
                ChestMenuUtils.getEmptyClickHandler());
        }
    }

    @Override
    public int[] getInputSlots() {
        return new int[] {
            19, 20, 21, 22};
    }

    @Override
    public int[] getOutputSlots() {
        return new int[] {};
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

                if (getCharge(b.getLocation()) >= ENERGY_CONSUMPTION) {
                    BlockMenu menu = BlockStorage.getInventory(b);
                    ItemStack zot = menu.getItemInSlot(ZOT_SLOT);

                    if (!isValidProduct(zot)) {
                        return;
                    }

                    int requiredCharge = 1000;
                    NamespacedKey chargeKey = new NamespacedKey(TranscEndence.getInstance(), "charge");
                    ItemMeta zotMeta = zot.getItemMeta();
                    int zotCharge = PersistentDataAPI.getInt(zotMeta, chargeKey);

                    if (zotCharge >= requiredCharge) {
                        return;
                    }

                    processInputSlots(b, menu, zot, zotMeta, zotCharge, chargeKey, requiredCharge);
                }
            }

            private boolean isValidProduct(ItemStack zot) {
                return zot != null && isAllowed(zot, allowedSlotsItems) && zot.getAmount() == 1;
            }

            private void processInputSlots(Block b, BlockMenu menu, ItemStack zot, ItemMeta zotMeta, int zotCharge,
                                           NamespacedKey chargeKey, int requiredCharge) {
                for (int inputSlot : getInputSlots()) {
                    ItemStack inputItem = menu.getItemInSlot(inputSlot);

                    if (isValidInput(inputItem)) {
                        String inpSpin = inputItem.getItemMeta().getDisplayName().split(" ")[1];
                        String zotSpin = zot.getItemMeta().getDisplayName().split(" ")[1];
                        int inpToBeRemoved = inpRemoveCalc(inpSpin, zotSpin);

                        if (inputItem.getAmount() >= inpToBeRemoved) {
                            handleInputRemoval(b, menu, zot, zotMeta, zotCharge, chargeKey, requiredCharge, inputSlot, inputItem, inpToBeRemoved);
                        }
                        break;
                    }
                }
            }

            private boolean isValidInput(ItemStack inputItem) {
                return inputItem != null && isAllowed(inputItem, allowedInputItems);
            }

            private void handleInputRemoval(Block b, BlockMenu menu, ItemStack zot, ItemMeta zotMeta, int zotCharge,
                                            NamespacedKey chargeKey, int requiredCharge, int inputSlot, ItemStack inputItem, int inpToBeRemoved) {
                if (zotCharge == requiredCharge - 1) {
                    menu.replaceExistingItem(ZOT_SLOT, getZot(zotMeta.getDisplayName().split(" ")[1]));
                } else {
                    updateZotMeta(zotMeta, zotCharge, requiredCharge);
                }

                PersistentDataAPI.setInt(zotMeta, chargeKey, zotCharge);
                zot.setItemMeta(zotMeta);
                removeCharge(b.getLocation(), ENERGY_CONSUMPTION);

                if (inputItem.getAmount() == inpToBeRemoved) {
                    menu.replaceExistingItem(inputSlot, null);
                } else {
                    inputItem.setAmount(inputItem.getAmount() - inpToBeRemoved);
                }
            }

            private void updateZotMeta(ItemMeta zotMeta, int zotCharge, int requiredCharge) {
                zotMeta.setLore(Arrays.asList(ChatColor.BLUE + "Concentrated matter",
                    ChatColor.GRAY + "Charge: " + ChatColor.YELLOW + ++zotCharge + "/" + requiredCharge));
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

    public BlockBreakHandler onBreak() {
        return new BlockBreakHandler(false, false) {

            @Override
            public void onPlayerBreak(BlockBreakEvent e, ItemStack item, List<ItemStack> drops) {
                Block b = e.getBlock();
                BlockMenu inv = BlockStorage.getInventory(b);

                if (inv != null) {
                    inv.dropItems(b.getLocation(), getInputSlots());
                    inv.dropItems(b.getLocation(), getOutputSlots());
                }
            }
        };
    }

}


