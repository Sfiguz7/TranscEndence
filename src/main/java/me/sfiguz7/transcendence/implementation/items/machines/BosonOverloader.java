package me.sfiguz7.transcendence.implementation.items.machines;

import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
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
import me.sfiguz7.transcendence.Lists.TranscendenceItems;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.ThreadLocalRandom;

public class BosonOverloader extends SimpleSlimefunItem<BlockTicker> implements InventoryBlock, EnergyNetComponent {

    private static final int ENERGY_CONSUMPTION = 1024;
    private int decrement = 20;
    private ItemStack[] quirps = {TranscendenceItems.QUIRP_UP,
            TranscendenceItems.QUIRP_DOWN,
            TranscendenceItems.QUIRP_LEFT,
            TranscendenceItems.QUIRP_RIGHT
    };
    private int[] chances = {25,
            25,
            25,
            25
    };

    private final int[] border = {
            0, 1, 2, 3, 4, 8,
            13, 14, 16, 17,
            22, 23, 25, 26,
            31, 32, 34, 35,
            40, 41, 43, 44,
            45, 46, 47, 48, 49, 53
    };
    private final int[] inputBorder = {
            9, 10, 11, 12,
            18, 21,
            27, 30,
            36, 37, 38, 39
    };
    private final int[] slotsBorder = {
            5, 6, 7,
            14, 16,
            23, 25,
            32, 34,
            41, 43,
            50, 51, 52
    };

    public BosonOverloader(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
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
                9, 10, 11, 12,
                18, 21,
                27, 30,
                36, 37, 38, 39};
    }

    @Override
    public int[] getOutputSlots() {
        return new int[]{};
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

                if (--decrement != 0) {
                    return;
                }

                decrement = 10;
                ItemStack output = getQuirp();

                if (ChargableBlock.getCharge(b) >= ENERGY_CONSUMPTION) {
                    BlockMenu menu = BlockStorage.getInventory(b);

                    if (!menu.fits(output, getOutputSlots())) {
                        return;
                    }

                    ChargableBlock.addCharge(b, -ENERGY_CONSUMPTION);
                    //menu.pushItem(output, getOutputSlots());
                }
            }

            public ItemStack getQuirp() {
                int index = ThreadLocalRandom.current().nextInt(100);
                int accruedchance = 0;
                for (int i = 0; i < quirps.length; i++) {
                    accruedchance += chances[i];
                    if (index < accruedchance) {
                        return quirps[i];
                    }
                }
                //Never reached
                return new ItemStack(Material.AIR);
            }

            @Override
            public boolean isSynchronized() {
                return true;
            }
        };
    }

}


