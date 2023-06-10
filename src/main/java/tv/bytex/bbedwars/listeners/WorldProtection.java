package tv.bytex.bbedwars.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.Listener;


public class WorldProtection implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        Player player = event.getPlayer();

        Block block = event.getBlock();

        if (!block.getType().equals(Material.CUT_SANDSTONE)) {
            event.setCancelled(true);
            player.sendMessage("You can't break that!");
        }
    }
}
