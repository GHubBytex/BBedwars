package tv.bytex.bbedwars;

import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import tv.bytex.bbedwars.commands.HelpCommand;
import tv.bytex.bbedwars.commands.StartCommand;
import tv.bytex.bbedwars.listeners.NoItemStackEvent;
import tv.bytex.bbedwars.listeners.ShopOpenEvent;

public final class BBedwars extends JavaPlugin implements Listener {
    public BBedwars() {
    }

    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new ShopOpenEvent(), this);
        this.getServer().getPluginManager().registerEvents(new NoItemStackEvent(), this);
        this.getServer().getPluginManager().registerEvents(this, this);
        PluginCommand help = this.getCommand("help");
        if (help != null) {
            help.setExecutor(new HelpCommand());
        } else {
            System.err.println("Help command not found!");
        }

        PluginCommand start = this.getCommand("start");
        if (start != null) {
            start.setExecutor(new StartCommand(this));
        } else {
            System.err.println("Start command not found!");
        }

    }

    private void stopGoldBarSpawner() {
        Bukkit.getScheduler().cancelTasks(this);
    }
}
