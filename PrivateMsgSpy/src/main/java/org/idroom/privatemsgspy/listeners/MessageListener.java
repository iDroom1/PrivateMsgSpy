package org.idroom.privatemsgspy.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.idroom.privatemsgspy.PrivateMsgSpy;

public class MessageListener implements Listener {

    @EventHandler
    public void onPrivateMessage(PlayerCommandPreprocessEvent event) {
        String message = event.getMessage();
        if (message.toLowerCase().startsWith("/msg ") || message.toLowerCase().startsWith("/tell ")
                || message.toLowerCase().startsWith("/whisper ") || message.toLowerCase().startsWith("/w ")) {
            Player sender = event.getPlayer();

            for (Player spy : Bukkit.getOnlinePlayers()) {
                if (spy.equals(sender)) continue;
                if (PrivateMsgSpy.getInstance().getSpies().contains(spy.getUniqueId())) {
                    spy.sendMessage(ChatColor.GRAY + "[Spy] " + ChatColor.YELLOW + sender.getName() + ": " + ChatColor.WHITE + message);
                }
            }
        }
    }
}
