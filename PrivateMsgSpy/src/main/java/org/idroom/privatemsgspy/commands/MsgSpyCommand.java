package org.idroom.privatemsgspy.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.idroom.privatemsgspy.PrivateMsgSpy;

public class MsgSpyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        if (!player.hasPermission("spy.msg")) {
            player.sendMessage("§cYou do not have permission.");
            return true;
        }

        var spies = PrivateMsgSpy.getInstance().getSpies();
        if (spies.contains(player.getUniqueId())) {
            spies.remove(player.getUniqueId());
            player.sendMessage("§7[§bSpy§7] §cYou have disabled message spying.");
        } else {
            spies.add(player.getUniqueId());
            player.sendMessage("§7[§bSpy§7] §aYou have enabled message spying.");
        }
        return true;
    }
}
