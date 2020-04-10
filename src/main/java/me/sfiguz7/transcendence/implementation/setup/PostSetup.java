package me.sfiguz7.transcendence.implementation.setup;

import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItemSerializer;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.sfiguz7.transcendence.Lists.TranscendenceItems;
import me.sfiguz7.transcendence.TranscEndencePlugin;
import me.sfiguz7.transcendence.implementation.items.machines.AutomaticNanobotCrafter;
import me.sfiguz7.transcendence.implementation.items.multiblocks.NanobotCrafter;
import org.bukkit.inventory.ItemStack;

public class PostSetup {

    private PostSetup() {
    }

    public static void loadItems() {

        loadAutomaticNanobotCrafter();
    }

    private static void loadAutomaticNanobotCrafter() {
        AutomaticNanobotCrafter crafter = (AutomaticNanobotCrafter) TranscendenceItems.AUTOMATIC_NANOBOT_CRAFTER.getItem();

        if (crafter != null) {
            NanobotCrafter machine = (NanobotCrafter) TranscendenceItems.NANOBOT_CRAFTER.getItem();

            for (ItemStack[] inputs : RecipeType.getRecipeInputList(machine)) {
                StringBuilder builder = new StringBuilder();
                int i = 0;

                for (ItemStack item : inputs) {
                    if (i > 0) {
                        builder.append(" </slot> ");
                    }

                    builder.append(CustomItemSerializer.serialize(item, CustomItemSerializer.ItemFlag.MATERIAL,
                            CustomItemSerializer.ItemFlag.ITEMMETA_DISPLAY_NAME, CustomItemSerializer.ItemFlag.ITEMMETA_LORE));

                    i++;
                }

                TranscEndencePlugin.getRegistry().getAutomaticNanobotCrafterRecipes().put(builder.toString(),
                        RecipeType.getRecipeOutputList(machine, inputs));
            }

        }
    }
}
