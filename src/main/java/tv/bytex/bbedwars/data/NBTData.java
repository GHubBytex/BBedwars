package tv.bytex.bbedwars.data;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import tv.bytex.bbedwars.model.ShopItem;

import java.util.ArrayList;
import java.util.List;

public class NBTData {


    public List<ShopItem> getShopItems() {
        List<ShopItem> list = new ArrayList<>();
        list.add(new ShopItem(
                new ItemStack(Material.CUT_SANDSTONE, 4),
                new ItemStack(Material.BRICK, 1)
        ));

        list.add(new ShopItem(
                new ItemStack(Material.GOLDEN_APPLE, 1),
                new ItemStack(Material.BRICK, 1)
        ));

        list.add(new ShopItem(
                new ItemStack(Material.GOLDEN_APPLE, 1),
                new ItemStack(Material.BRICK, 1)
        ));

        list.add(new ShopItem(
                new ItemStack(Material.GOLDEN_APPLE, 1),
                new ItemStack(Material.BRICK, 1)
        ));

        list.add(new ShopItem(
                new ItemStack(Material.GOLDEN_APPLE, 1),
                new ItemStack(Material.BRICK, 1)
        ));
    return list;
    }

}
