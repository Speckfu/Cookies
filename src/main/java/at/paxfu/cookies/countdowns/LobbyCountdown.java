package at.paxfu.cookies.countdowns;

import at.paxfu.cookies.Cookies;
import at.paxfu.cookies.gamestates.GameStates;
import at.paxfu.cookies.managers.Messages;
import at.paxfu.cookies.managers.Settings;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

/**
 * Created by paxfu on 07.05.2021.
 */

public class LobbyCountdown implements Settings, Messages {

    //Values for lobby countdown
    public int count = Lobby_CountdownTime;
    private static int schedulerID = 1;

    // Start method
    public void run() {
        //start a new scheduler
        schedulerID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Cookies.getInstance(), () -> {
                //update level for all online players
                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.setLevel(count);
                }

                //send messages for x seconds
                if(count == 30) {
                    Bukkit.broadcastMessage(Lobby_CountdownTime_MSG.replace("%SECONDS%", String.valueOf(30)));
                }else if (count == 15) {
                    Bukkit.broadcastMessage(Lobby_CountdownTime_MSG.replace("%SECONDS%", String.valueOf(count)));
                } else if (count == 10) {
                    Bukkit.broadcastMessage(Lobby_CountdownTime_MSG.replace("%SECONDS%", String.valueOf(count)));
                } else if (count == 5 || count == 4 || count == 3 || count == 2 || count == 1) {
                    Bukkit.broadcastMessage(Lobby_CountdownTime_MSG.replace("%SECONDS%", String.valueOf(count)));
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.playSound(all.getEyeLocation(), Sound.BLOCK_NOTE_BLOCK_GUITAR, 0.1F, 0.1F);
                    }
                }else if(count == 0) {
                    Bukkit.broadcastMessage(Lobby_GameStarted_MSG);
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.playSound(all.getEyeLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.1F, 0.1F);
                        all.getInventory().clear();
                        all.setGameMode(GameMode.SURVIVAL);
                    }
                    //cancel task
                    Bukkit.getScheduler().cancelTask(schedulerID);

                    //change gamestate
                    Cookies.getInstance().gameState = GameStates.INGAME;
                }

                //count down
                count--;
        },0, 20L);
    }

    public void stop() {
            Bukkit.getScheduler().cancelTask(schedulerID);
            count = Lobby_CountdownTime;
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.setLevel(count);
            }
    }
}
