package tv.bytex.bbedwars;

import org.bukkit.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class ResourcenSpawner {

    private final int BRONCE_SPAWN_RATE = 1;
    private final int IRON_SPAWN_RATE = 20;
    private final int GOLD_SPAWN_RATE = 60;

    /**
     * Startet den Spawner für Ressourcen.
     *
     * @param plugin Das Plugin, welches den Spawner verwaltet.
     */
    public void startSpawner(Plugin plugin) {
        // Starte den Spawner
        startItemSpawner(-5, 101, 30, Material.TERRACOTTA, Material.BRICK, BRONCE_SPAWN_RATE, plugin);
        startItemSpawner(0, 100, 0, Material.IRON_BLOCK, Material.IRON_INGOT, IRON_SPAWN_RATE, plugin);
        startItemSpawner(2, 100, 0, Material.GOLD_BLOCK, Material.GOLD_INGOT, GOLD_SPAWN_RATE, plugin);
        startItemSpawner(-2, 100, 0, Material.GOLD_BLOCK, Material.GOLD_INGOT, GOLD_SPAWN_RATE, plugin);
        startItemSpawner(0, 100, 2, Material.GOLD_BLOCK, Material.GOLD_INGOT, GOLD_SPAWN_RATE, plugin);
        startItemSpawner(0, 100, -2, Material.GOLD_BLOCK, Material.GOLD_INGOT, GOLD_SPAWN_RATE, plugin);
    }

    /**
     * Startet einen Item-Spawner an einer bestimmten Position in der Welt. Der Spawner lässt Items fallen,
     * wenn das Material unter der Spawnerposition mit dem angegebenen Blockmaterial übereinstimmt.
     *
     * @param x             Die X-Koordinate der Spawnerposition.
     * @param y             Die Y-Koordinate der Spawnerposition.
     * @param z             Die Z-Koordinate der Spawnerposition.
     * @param blockMaterial Das Material des Blocks, das unter der Spawnerposition liegen muss, damit Items spawnen.
     * @param itemMaterial  Das Material des Items, das vom Spawner erzeugt wird.
     * @param spawnPerMin   Die Zeit in Sekunden, in der ein neues Item vom Spawner erzeugt wird.
     * @param plugin        Das Plugin, welches den Spawner verwaltet.
     */

    private void startItemSpawner(int x, int y, int z, Material blockMaterial, Material itemMaterial, int spawnPerMin, Plugin plugin) {
        // Erzeuge einen neuen BukkitRunnable
        new BukkitRunnable() {
            @Override
            public void run() {
                // Wähle zufällige Position im Spiel
                World world = Bukkit.getWorlds().get(0); // Du kannst dies anpassen, um eine bestimmte Welt auszuwählen
                Location spawnLocation = new Location(world, x, y, z);
                Location blockLocation = new Location(world, x, y - 1, z);
                // Überprüfe, ob die ausgewählte Position ein Goldblock ist
                if (blockLocation.getBlock().getType() == blockMaterial) {
                    // Spawn einen Goldbarren an der Position
                    ItemStack item = new ItemStack(itemMaterial);
                    ItemMeta itemMeta = item.getItemMeta();
                    switch (itemMaterial) {
                        case IRON_INGOT -> itemMeta.setDisplayName(ChatColor.GRAY + "Eisen");
                        case GOLD_INGOT -> itemMeta.setDisplayName(ChatColor.GOLD + "Gold");
                        case BRICK -> itemMeta.setDisplayName(ChatColor.AQUA + "Bronce");
                    }

                    item.setItemMeta(itemMeta);

                    world.dropItemNaturally(spawnLocation, item);
                }

            }
        }.runTaskTimer(plugin, 0, 20 * spawnPerMin); // Alle 60 Sekunden (20 Ticks pro Sekunde) ausführen
    }
}

//enum SpawnRates {
//    GOLD_SPAWN_RATE(60),
//    IRON_SPAWN_RATE(60),
//    BRONCE_SPAWN_RATE(60);
//    int spawnRate;
//
//    private SpawnRates(int spawnRate) {
//        this.spawnRate = spawnRate;
//    }
//
//}
//
