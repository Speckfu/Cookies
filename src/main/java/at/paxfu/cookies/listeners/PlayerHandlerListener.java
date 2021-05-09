package at.paxfu.cookies.listeners;

import at.paxfu.cookies.Cookies;
import at.paxfu.cookies.countdowns.JoinTeleport;
import at.paxfu.cookies.countdowns.LobbyCountdown;
import at.paxfu.cookies.inventories.Hotbar;
import at.paxfu.cookies.managers.Messages;
import at.paxfu.cookies.managers.Settings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.concurrent.Callable;

/**
 * Created by paxfu on 07.05.2021.
 */
public class PlayerHandlerListener implements Listener, Messages, Settings {

    //PlayerJoinEvent
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        //Declare Player
        Player player = event.getPlayer();
        //Add Player to ArrayList
        Cookies.getInstance().alivePlayers.add(player);
        //Remove Join Message
        event.setJoinMessage(null);
        //Send new Join Message
        Bukkit.broadcastMessage(Lobby_JoinMSG
                .replace("%PLAYER%", player.getDisplayName())
                .replace("%PLAYERS%", String.valueOf(Cookies.getInstance().alivePlayers.size()))
                .replace("%MAXPLAYERS%", String.valueOf(General_MaxPlayers)));
        //Set up defaults for Player
        player.setGameMode(GameMode.ADVENTURE);
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setExp(0);
        player.setLevel(30);
        //Teleport player
        JoinTeleport.startJoinTeleport(player);
        //Set inventory
        player.getInventory().clear();
        if(Team_Item_Enabled) {
            player.getInventory().setItem(Team_Item_Slot, Hotbar.teams());
        }
        //Check if game starts
        if(Cookies.getInstance().alivePlayers.size() == General_MinPlayers && !Cookies.getInstance().lobbyCountdown.isRunning) {
            //Start Countdown
            Cookies.getInstance().lobbyCountdown.run();
            Cookies.getInstance().lobbyCountdown.isRunning = true;
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        //Declare Player
        Player player = event.getPlayer();
        Cookies.getInstance().alivePlayers.remove(player);
        event.setQuitMessage(null);
        Bukkit.broadcastMessage(Lobby_QuitMSG
                .replace("%PLAYER%", player.getDisplayName())
                .replace("%PLAYERS%", String.valueOf(Cookies.getInstance().alivePlayers.size()))
                .replace("%MAXPLAYERS%", String.valueOf(General_MaxPlayers)));
        if(Cookies.getInstance().alivePlayers.size() < General_MinPlayers && Cookies.getInstance().lobbyCountdown.isRunning) {
            Cookies.getInstance().lobbyCountdown.stop();
            Bukkit.broadcastMessage(Lobby_Countdown_Stopped);
        }
    }
}
