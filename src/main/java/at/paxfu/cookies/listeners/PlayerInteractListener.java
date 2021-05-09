package at.paxfu.cookies.listeners;

import at.paxfu.cookies.Cookies;
import at.paxfu.cookies.gamestates.GameStates;
import at.paxfu.cookies.inventories.Hotbar;
import at.paxfu.cookies.inventories.TeamInventory;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by paxfu on 09.05.2021.
 */
public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if(Cookies.getInstance().gameState == GameStates.LOBBY) {
            if (event.getMaterial() == Material.RED_BED) {
                Player player = event.getPlayer();
                TeamInventory.openInventory(player);
            }
        }
    }
}
