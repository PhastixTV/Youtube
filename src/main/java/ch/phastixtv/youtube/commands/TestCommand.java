package ch.phastixtv.youtube.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String labels, @NotNull String[] args) {
        sender.sendMessage( ChatColor.RED + "Du hast es §a" + "geschaft :)!");
        return false;
    }
}
