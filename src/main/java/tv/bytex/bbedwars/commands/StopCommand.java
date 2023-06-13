package tv.bytex.bbedwars.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import tv.bytex.bbedwars.listeners.StopEvent;
import tv.bytex.bbedwars.listeners.WorldProtection;

public class StopCommand implements CommandExecutor {

    private Plugin plugin;

    public StopCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    public void stopBedwars() {
        Bukkit.getScheduler().cancelTasks(plugin);


    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        stopBedwars();
        if (sender instanceof Player player) {

            player.setGameMode(GameMode.CREATIVE);

        }

        sender.sendMessage("Bedwars Stopped!");
        Bukkit.getServer().getPluginManager().registerEvents(new StopEvent(), plugin);

        return false;
    }
}
