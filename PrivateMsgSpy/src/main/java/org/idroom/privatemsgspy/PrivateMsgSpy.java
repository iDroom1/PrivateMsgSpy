package org.idroom.privatemsgspy;

import org.bukkit.plugin.java.JavaPlugin;
import org.idroom.privatemsgspy.listeners.MessageListener;
import org.idroom.privatemsgspy.commands.MsgSpyCommand;
import java.util.HashSet;
import java.util.UUID;

public class PrivateMsgSpy extends JavaPlugin {

    private static PrivateMsgSpy instance;
    private final HashSet<UUID> spies = new HashSet<>();

    @Override
    public void onEnable() {
        instance = this;
        getCommand("msgspy").setExecutor(new MsgSpyCommand());
        getServer().getPluginManager().registerEvents(new MessageListener(), this);
        getLogger().info("PrivateMsgSpy enabled.");
    }

    @Override
    public void onDisable() {
        spies.clear();
        getLogger().info("PrivateMsgSpy disabled.");
    }

    public static PrivateMsgSpy getInstance() {
        return instance;
    }

    public HashSet<UUID> getSpies() {
        return spies;
    }
}
