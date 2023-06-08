package tv.bytex.bbedwars.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class ShopOpenEvent implements Listener {

    @EventHandler
    public void onVilligerInteraction(PlayerInteractEntityEvent event) {
        Entity entity = event.getRightClicked();
        if (entity instanceof Villager) {
            Player player = event.getPlayer();
            player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Open Shop...");

        }

    }

}
