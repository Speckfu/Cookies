package at.paxfu.cookies.countdowns;

import at.paxfu.cookies.Cookies;
import at.paxfu.cookies.managers.Messages;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * Created by paxfu on 08.05.2021.
 */
public class JoinTeleport implements Messages {

    public static void startJoinTeleport(Player player) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(Cookies.getInstance(), () -> {
            try {
                Location location = Cookies.getInstance().getLocations().getLocation("Lobby.Spawn");
                player.teleport(location);
            }catch (Exception e) {
                player.sendMessage(Error_LobbySpawn_Not_Found);
            }
        }, 2);
    }
}
