package me.sfiguz7.transcendence.implementation.core.commands;

import me.mrCookieSlime.Slimefun.cscorelib2.chat.ChatColors;
import me.sfiguz7.transcendence.TranscEndence;
import me.sfiguz7.transcendence.implementation.listeners.TranscEndenceGuideListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TranscEndenceCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 1 &&
            args[0].equalsIgnoreCase("guide") &&
            sender instanceof Player) {
            Player p = (Player) sender;
            p.getInventory().addItem(TranscEndenceGuideListener.getGuide());
        } else {
            sendHelp(sender);

        }
        return true;
    }

    public void sendHelp(CommandSender sender) {
        sender.sendMessage("");
        sender.sendMessage(ChatColors.color("&aTranscEndence &2v" + TranscEndence.getVersion()));

        sender.sendMessage(ChatColors.color("&3/te guide &b") + "Gives a TranscEndence Guide");
    }

}

