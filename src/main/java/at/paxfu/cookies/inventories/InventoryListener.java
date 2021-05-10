package at.paxfu.cookies.inventories;

import at.paxfu.cookies.Cookies;
import at.paxfu.cookies.gamestates.GameStates;
import at.paxfu.cookies.managers.TeamManager;
import lombok.val;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

/**
 * Created by paxfu on 09.05.2021.
 */
public class InventoryListener implements Listener {

    @EventHandler
    public void onDrag(InventoryDragEvent event) {
        if(Cookies.getInstance().gameState == GameStates.LOBBY) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if(Cookies.getInstance().gameState == GameStates.LOBBY) {
            event.setCancelled(true);
            if (event.getInventory() == TeamInventory.getInventory()) {
                event.setCancelled(true);
                int slot = event.getRawSlot();
                Player player = (Player) event.getWhoClicked();

                switch (slot) {
                    case 10:
                        if (!Cookies.getInstance().teamManager.team1.contains(player)) {
                            Cookies.getInstance().teamManager.addUserToTeam(player, "team1");
                            player.getOpenInventory().close();
                            TeamInventory.getInventory().setItem(10, TeamInventory.team1());
                        }
                        break;
                    case 12:
                        if (!Cookies.getInstance().teamManager.team2.contains(player)) {
                            Cookies.getInstance().teamManager.addUserToTeam(player, "team2");
                            player.getOpenInventory().close();
                            TeamInventory.getInventory().setItem(12, TeamInventory.team2());
                        }
                        break;
                    case 14:
                        if (!Cookies.getInstance().teamManager.team3.contains(player)) {
                            Cookies.getInstance().teamManager.addUserToTeam(player, "team3");
                            player.getOpenInventory().close();
                            TeamInventory.getInventory().setItem(14, TeamInventory.team3());
                        }
                        break;
                    case 16:
                        if (!Cookies.getInstance().teamManager.team4.contains(player)) {
                            Cookies.getInstance().teamManager.addUserToTeam(player, "team4");
                            player.getOpenInventory().close();
                            TeamInventory.getInventory().setItem(16, TeamInventory.team4());
                        }
                        break;
                }
            }
        }
    }
}
