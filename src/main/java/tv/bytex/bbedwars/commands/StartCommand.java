package tv.bytex.bbedwars.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import tv.bytex.bbedwars.ResourcenSpawner;

public class StartCommand implements CommandExecutor {
    private Plugin plugin;

    public StartCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender instanceof Player player) {

            player.setGameMode(GameMode.SURVIVAL);
            
        }


        Bukkit.getServer().getPluginManager().registerEvents(new WorldProtection(), plugin);

        sender.sendMessage("Start wird Ausgefuehrt!");
        createSpawnPoints(30, 100, 0);
        createSpawnPoints(-30, 100, 0);
        createSpawnPoints(0, 100, 30);
        createSpawnPoints(0, 100, -30);
        ResourcenSpawner startSpawning = new ResourcenSpawner();
        startSpawning.startSpawner(plugin);
        return true;
    }

    /**
     * Erstellt Spawn-Punkte an den angegebenen Koordinaten.
     *
     * @param x Die X-Koordinate des Spawn-Punkts.
     * @param y Die Y-Koordinate des Spawn-Punkts.
     * @param z Die Z-Koordinate des Spawn-Punkts.
     */
    public void createSpawnPoints(int x, int y, int z) {
        World world = Bukkit.getWorlds().get(0);
        Location location = new Location(world, x, y, z);
        location.getBlock().setType(Material.BEDROCK);
    }

}
