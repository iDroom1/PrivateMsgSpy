package org.idroom;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlateouKillAura extends JavaPlugin implements Listener {

    private LuckPerms luckPerms;

    @Override
    public void onEnable() {
        // Hook into LuckPerms
        luckPerms = LuckPermsProvider.get();

        // Register events
        getServer().getPluginManager().registerEvents(this, this);

        getLogger().info("PlateouKillAura has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("PlateouKillAura has been disabled!");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // Check if the player has the permission
        if (player.hasPermission("plateoukillaura.notify")) {
            // Send a message to all players with the permission
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                if (onlinePlayer.hasPermission("plateoukillaura.notify")) {
                    onlinePlayer.sendMessage("PlateouKillAura: " + player.getName() + " might be using KillAura");
                }
            }
        }
    }
}