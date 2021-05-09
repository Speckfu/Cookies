package at.paxfu.cookies.listeners;

import at.paxfu.cookies.managers.Settings;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by paxfu on 08.05.2021.
 */
public class BlockBreakListener implements Listener, Settings {

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if(event.getBlock().getType() == Material.GOLD_BLOCK) {
            event.setCancelled(true);
            Location loc = event.getBlock().getLocation().add(0, 1, 0);
            loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.COOKIE, 1));
            int random = ThreadLocalRandom.current().nextInt(100);
            if(random <= Ingame_CookieBlock_Bricks_DropsChance) {
                loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.BRICKS, 1));
            }
        }
    }
}
