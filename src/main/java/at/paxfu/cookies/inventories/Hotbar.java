package at.paxfu.cookies.inventories;

import at.paxfu.cookies.managers.Settings;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

/**
 * Created by paxfu on 09.05.2021.
 */
public class Hotbar implements Settings {

    public static ItemStack teams() {
        ItemStack is = new ItemStack(Material.RED_BED, 1);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(Team_Item_Name);
        is.setItemMeta(im);
        return is;
    }
}
