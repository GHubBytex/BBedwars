package tv.bytex.bbedwars.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemMergeEvent;


public class NoItemStackEvent implements Listener {

    @EventHandler
    public void onItemMerge(ItemMergeEvent event) {
        event.setCancelled(true);

    }
}

