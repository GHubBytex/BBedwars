package tv.bytex.bbedwars.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import tv.bytex.bbedwars.model.ShopItem;

public class ShopOpenEvent implements Listener {

    @EventHandler
    public void onVilligerInteraction(PlayerInteractEntityEvent event) {
        Entity entity = event.getRightClicked();
        if (entity instanceof Villager) {

            Player player = event.getPlayer();

            player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Open Shop...");
            openShop(player);
        }

    }

    public void openShop(Player player) {

        Inventory shop = Bukkit.createInventory(player, 36, "Shop");
        shop.setItem(0, new ItemStack(Material.DIAMOND_SWORD));

        player.openInventory(shop);

        PlayerInventory playerInventory = player.getInventory();

        if (playerInventory.contains(Material.BRICK, 1)) {
            ItemStack itemBRICK = new ItemStack(Material.BRICK);
            playerInventory.removeItem(itemBRICK);

        }

    }

    @EventHandler
    public void invincibleVillager(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        if (damager instanceof Player player) {
            if (player.getGameMode() == GameMode.SURVIVAL) {
                event.setCancelled(true);


            }
        }
    }
}
