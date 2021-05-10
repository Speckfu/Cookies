package at.paxfu.cookies.listeners;

import at.paxfu.cookies.Cookies;
import at.paxfu.cookies.countdowns.JoinTeleport;
import at.paxfu.cookies.countdowns.LobbyCountdown;
import at.paxfu.cookies.gamestates.GameStates;
import at.paxfu.cookies.inventories.Hotbar;
import at.paxfu.cookies.managers.Messages;
import at.paxfu.cookies.managers.Settings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by paxfu on 07.05.2021.
 */
public class PlayerHandlerListener implements Listener, Messages, Settings {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if(Cookies.getInstance().gameState == GameStates.LOBBY) {
            Cookies.getInstance().alivePlayers.add(player);
            event.setJoinMessage(null);
            Bukkit.broadcastMessage(Lobby_JoinMSG
                    .replace("%PLAYER%", player.getDisplayName())
                    .replace("%PLAYERS%", String.valueOf(Cookies.getInstance().alivePlayers.size()))
                    .replace("%MAXPLAYERS%", String.valueOf(General_MaxPlayers)));
            player.setGameMode(GameMode.ADVENTURE);
            player.setHealth(20);
            player.setFoodLevel(20);
            player.setExp(0);
            player.setLevel(Lobby_CountdownTime);
            JoinTeleport.startJoinTeleport(player);
            player.getInventory().clear();
            if(Team_Item_Enabled) {
                player.getInventory().setItem(Team_Item_Slot, Hotbar.teams());
            }
            if(Cookies.getInstance().alivePlayers.size() == General_MinPlayers) {
                Cookies.getInstance().lobbyCountdown.run();
            }

        }else if(Cookies.getInstance().gameState == GameStates.INGAME) {
            event.setJoinMessage("Ingame Join");
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if(Cookies.getInstance().gameState == GameStates.LOBBY) {
            Cookies.getInstance().alivePlayers.remove(player);
            event.setQuitMessage(null);
            Bukkit.broadcastMessage(Lobby_QuitMSG
                    .replace("%PLAYER%", player.getDisplayName())
                    .replace("%PLAYERS%", String.valueOf(Cookies.getInstance().alivePlayers.size()))
                    .replace("%MAXPLAYERS%", String.valueOf(General_MaxPlayers)));
            if(Cookies.getInstance().teamManager.isUserInTeam(player)) {
                Cookies.getInstance().teamManager.removeUserOfTeam(player);
            }
            if(Cookies.getInstance().alivePlayers.size() < General_MinPlayers) {
                Cookies.getInstance().lobbyCountdown.stop();
                Bukkit.broadcastMessage(Lobby_Countdown_Stopped);
            }

        }else if(Cookies.getInstance().gameState == GameStates.INGAME) {
            event.setQuitMessage("Ingame Quit");
        }
    }


    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if(Cookies.getInstance().gameState == GameStates.LOBBY) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onHunger(FoodLevelChangeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPickUp(EntityPickupItemEvent event) {
        if(Cookies.getInstance().gameState == GameStates.LOBBY) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        if(Cookies.getInstance().gameState == GameStates.LOBBY) {
            event.setCancelled(true);
        }
    }
}
