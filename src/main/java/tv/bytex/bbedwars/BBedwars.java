package tv.bytex.bbedwars;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import tv.bytex.bbedwars.commands.HelpCommand;
import tv.bytex.bbedwars.commands.StartCommand;
import tv.bytex.bbedwars.commands.StopCommand;
import tv.bytex.bbedwars.listeners.NoItemStackEvent;
import tv.bytex.bbedwars.listeners.ShopOpenEvent;

public final class BBedwars extends JavaPlugin implements Listener {
    public BBedwars() {
    }

    public void onEnable() {
        spawnVillager();
        activateListeners();
        activateCommands();

    }

    public void activateListeners() {
        this.getServer().getPluginManager().registerEvents(new ShopOpenEvent(), this);
        this.getServer().getPluginManager().registerEvents(new NoItemStackEvent(), this);
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    public void activateCommands() {

        PluginCommand help = this.getCommand("help");
        if (help != null) {
            help.setExecutor(new HelpCommand());
        } else {
            System.err.println("Help command not found!");
        }

        PluginCommand stop = this.getCommand("stop");
        if (stop != null) {
            stop.setExecutor(new StopCommand(this));
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

    public void spawnVillager() {

        World world = Bukkit.getWorlds().get(0);

        Entity entity = world.spawnEntity(new Location(world, 4.5, 101, 30.5, 90, 0), EntityType.VILLAGER);

        if (entity instanceof org.bukkit.entity.Villager villager) {
            villager.setVillagerType(Villager.Type.PLAINS);
            villager.setAI(false);
            villager.setGravity(false);
            villager.setCanPickupItems(false);
            villager.setCustomName(ChatColor.AQUA + "" + ChatColor.BOLD + "SHOP");
        }
    }

}
