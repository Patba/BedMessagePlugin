package io.github.patba.bedmessageplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;


public class BedMessagePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Bed Message by Patba is enabled");
        PluginManager pm = getServer().getPluginManager();
        ListenerSleepOn listener = new ListenerSleepOn();
        pm.registerEvents(listener, this);
    }

    public void onDisable() {
        getLogger().info("Bed Message by Patba is disabled");
    }


    public class ListenerSleepOn implements Listener {

        @EventHandler
        public void bedInfo(PlayerBedEnterEvent event) {
            Player p = event.getPlayer();
            Bukkit.broadcastMessage(ChatColor.RED + p.getDisplayName() + ChatColor.GRAY + " is sleeping right now!");
        }
    }
}

