package org.idroom;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class PlateouTabCompleter extends JavaPlugin implements Listener, TabCompleter {
    private FileConfiguration config;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        loadConfig();
    }

    private void loadConfig() {
        File configFile = new File(getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            saveDefaultConfig();
        }
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    @EventHandler
    public void onCommandPreProcess(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String command = event.getMessage().toLowerCase().split(" ")[0].substring(1); // Get the base command

        Set<String> allowedCommands = config.getStringList("allowed-commands").stream()
                .map(String::toLowerCase)
                .collect(java.util.stream.Collectors.toSet());

        if (!allowedCommands.contains(command)) {
            event.setCancelled(true);
            player.sendMessage(config.getString("no-access-message", "§cYou do not have access to this command."));
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        Set<String> allowedCommands = config.getStringList("allowed-commands").stream()
                .map(String::toLowerCase)
                .collect(java.util.stream.Collectors.toSet());

        if (!allowedCommands.contains(alias.toLowerCase())) {
            return Collections.emptyList(); // Prevent tab completion
        }
        return null; // Allow normal tab completion for allowed commands
    }
}
