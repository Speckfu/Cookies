package at.paxfu.cookies.listeners;

import at.paxfu.cookies.Cookies;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by paxfu on 08.05.2021.
 */
public class BlockPlaceListener implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if(event.getBlock().getType() == Material.STONE) {
            Location startLoc = event.getBlock().getLocation();
            startLoc.getBlock().setType(Material.AIR);

            Location loc1 = startLoc.clone().subtract(0, 1, 0);
            loc1.getWorld().getBlockAt(loc1.clone().add(1, 0, 0)).setType(Material.OBSIDIAN);
            loc1.getWorld().getBlockAt(loc1.clone().add(0, 0, 1)).setType(Material.OBSIDIAN);
            loc1.getWorld().getBlockAt(loc1.clone().add(1, 0, 1)).setType(Material.OBSIDIAN);
            loc1.getWorld().getBlockAt(loc1.clone().add(-1, 0, 1)).setType(Material.OBSIDIAN);
            loc1.getWorld().getBlockAt(loc1.clone().subtract(1, 0, 0)).setType(Material.OBSIDIAN);
            loc1.getWorld().getBlockAt(loc1.clone().subtract(0, 0, 1)).setType(Material.OBSIDIAN);
            loc1.getWorld().getBlockAt(loc1.clone().subtract(1, 0, 1)).setType(Material.OBSIDIAN);
            loc1.getWorld().getBlockAt(loc1.clone().subtract(-1, 0, 1)).setType(Material.OBSIDIAN);
        }
    }
}
