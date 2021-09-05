package me.sfiguz7.transcendence.implementation.listeners;

import io.github.thebusybiscuit.slimefun4.libraries.dough.common.ChatColors;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;
import java.util.List;

public class TranscEndenceGuideListener implements Listener {

    private final boolean giveOnFirstJoin;

    public TranscEndenceGuideListener(boolean giveOnFirstJoin) {
        this.giveOnFirstJoin = giveOnFirstJoin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (giveOnFirstJoin && !e.getPlayer().hasPlayedBefore()) {
            Player p = e.getPlayer();

            p.getInventory().addItem(getGuide());
        }
    }

    public static ItemStack getGuide() {
        List<String> pages = new ArrayList<>();
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta meta = (BookMeta) book.getItemMeta();
        meta.setTitle("TranscEndence Guide");
        meta.setAuthor("Sfiguz7");
        //Page 3 has an extra space after "Polarizer" otherwise "in" gets cut
        pages.add(ChatColors.color("Hello! This is a quick guide on how TranscEndence works.\n\n" +
            "&aQuirps &rare the main resource and can only be obtained by using a &9Quirp Oscillator " +
            "&r(which only works in the end!)."));
        pages.add(ChatColors.color("You'll get 4 different quirps based on their &9spin: &rup, down, left, " +
            "right.\n\n" +
            "You can force the Quirps Oscillator to spawn more Quirps of vertical or horizontal spin" +
            " by using the respective &dPolarizer  &rin the purple slot."));
        pages.add(ChatColors.color("&4Unstable ingots &rare the basic material to craft all end game items:" +
            " be careful, they will &ckill &ryou and disappear if you hold them for more than a few instants.\n\n" +
            "It is recommended you use cargo to move them instead."));
        pages.add(ChatColors.color("&aZots &rcan only be filled using a Zot Overloader, where Quirps are" +
            " consumed to charge the Zots.\n\n" +
            "The ratio is 1:1 for quirps with the same spin as the zot, 16:1 if they have different spin."));
        pages.add(ChatColors.color("&aDaxis &rare the end goal of this journey: each type will give you a" +
            " different potion effect which will last until you die.\n" +
            "These are respectively:\n" +
            "(S) - Strength 3\n" +
            "(A) - Absorption 5\n" +
            "(F) - Resistance 4\n" +
            "(H) - Saturation\n" +
            "(R) - Regeneration 2\n"));
        pages.add(ChatColors.color("On death you drop 8 Stable Blocks for each effect you had meaning you only need 1" +
            " extra nether star" +
            " each to craft the Daxi once again"));
        meta.setPages(pages);
        book.setItemMeta(meta);
        return book;

    }
}
