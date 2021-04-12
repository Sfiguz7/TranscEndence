package me.sfiguz7.transcendence.implementation.core.commands;

import me.mrCookieSlime.Slimefun.cscorelib2.chat.ChatColors;
import me.sfiguz7.transcendence.TranscEndence;
import me.sfiguz7.transcendence.implementation.items.items.Daxi;
import me.sfiguz7.transcendence.implementation.listeners.TranscEndenceGuideListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Set;

public class TranscEndenceCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("guide")
                && sender instanceof Player) {
                Player p = (Player) sender;
                p.getInventory().addItem(TranscEndenceGuideListener.getGuide());
            } else if (args[0].equalsIgnoreCase("walkthrough")) {
                sender.sendMessage(ChatColor.LIGHT_PURPLE + "TranscEndence > " + ChatColor.GRAY +
                    "https://github.com/Sfiguz7/TranscEndence/wiki/Walkthrough-guide-thingy");
            } else {
                sendHelp(sender);
            }
        } else if (args.length == 2
            && args[0].equalsIgnoreCase("reapply")) {
            if (sender.hasPermission("te.command.reapply")) {
                Player p = Bukkit.getPlayer(args[1]);
                if (p != null) {
                    Set<Daxi.Type> effects = TranscEndence.getRegistry().getDaxiEffectPlayers().get(p.getUniqueId());
                    if (!effects.isEmpty()) {
                        StringBuilder message = new StringBuilder("Reapplied: ");
                        for (Daxi.Type t : effects) {
                            message.append(" ").append(t);
                        }
                        Bukkit.getScheduler().runTask(TranscEndence.getInstance(), () -> Daxi.reapplyEffects(p));
                        sender.sendMessage(ChatColor.LIGHT_PURPLE + "TranscEndence > " + ChatColor.RED +
                            message);

                    } else {
                        sender.sendMessage(ChatColor.LIGHT_PURPLE + "TranscEndence > " + ChatColor.RED +
                            "The chosen player has no active Daxi!");
                    }
                }
            } else {
                sender.sendMessage(ChatColor.LIGHT_PURPLE + "TranscEndence > " + ChatColor.RED +
                    "Insufficient permissions!");
            }
            sender.sendMessage(ChatColor.LIGHT_PURPLE + "TranscEndence > " + ChatColor.RED + "The chosen player does" +
                " not exist!");
        } else {
            sendHelp(sender);
        }
        return true;
    }

    public void sendHelp(CommandSender sender) {
        sender.sendMessage("");
        sender.sendMessage(ChatColors.color("&aTranscEndence &2v" + TranscEndence.getVersion()));

        sender.sendMessage(ChatColors.color("&3/te guide &b") + "Gives a TranscEndence Guide");
        sender.sendMessage(ChatColors.color("&3/te walkthrough &b") + "Gives a Walkthrough link");
    }

}

