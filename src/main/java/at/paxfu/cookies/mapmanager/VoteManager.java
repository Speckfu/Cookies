package at.paxfu.cookies.mapmanager;

import at.paxfu.cookies.Cookies;
import at.paxfu.cookies.managers.Messages;
import at.paxfu.cookies.managers.Settings;
import org.bukkit.Bukkit;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by paxfu on 11.05.2021.
 */
public class VoteManager implements Settings, Messages {

    public static ArrayList<World> maps = new ArrayList<>();
    public static ArrayList<World> randomMaps = new ArrayList<>();

    public static void generateMapPool() {
        for (World world : Bukkit.getWorlds()) {
            if (!world.getName().equals("world") && !world.getName().equals("world_nether") && !world.getName().equals("world_the_end") && !world.getName().equals(Lobby_Name)) {
                if(Cookies.getInstance().mapManager.getEnabled(world.getName())) {
                    maps.add(world);
                    System.out.println("MapsLoad" + maps.size());
                }
            }
        }
    }

    public static void generateRandomMapPool(Integer size) {
        int randomMap = ThreadLocalRandom.current().nextInt(0, maps.size());
        for (int i = 0; i < size; i++) {
            randomMaps.add(maps.get(randomMap));
            Bukkit.broadcastMessage(String.valueOf(randomMaps.size()));
        }
    }
}
