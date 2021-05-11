package at.paxfu.cookies.mapmanager;

import at.paxfu.cookies.Cookies;
import at.paxfu.cookies.managers.Messages;
import at.paxfu.cookies.managers.Settings;
import org.bukkit.Location;



/**
 * Created by paxfu on 10.05.2021.
 */
public class MapManager implements Settings, Messages {

    public void createMap(String mapName, String worldName, String builderName, boolean enabled, boolean setupCompleted) {
        Cookies.getInstance().getMaps().getStringOrSetDefault("Maps." + worldName + ".MapName", mapName);
        Cookies.getInstance().getMaps().getStringOrSetDefault("Maps." + worldName + ".Builder", builderName);
        Cookies.getInstance().getMaps().getBooleanOrSetDefault("Maps." + worldName + ".SetupCompleted", setupCompleted);
        Cookies.getInstance().getMaps().getBooleanOrSetDefault("Maps." + worldName + ".Enabled", enabled);
    }

    public void updateSetupStatus(String worldName, boolean setupCompleted) {
        Cookies.getInstance().getMaps().set("Maps." + worldName + ".SetupCompleted", setupCompleted);
    }

    public String getMapName(String worldName) {
        return Cookies.getInstance().getMaps().getString("Maps." + worldName + ".World");
    }

    public String getBuilder(String worldName) {
        return Cookies.getInstance().getMaps().getString("Maps." + worldName + ".Builder");
    }

    public boolean getSetupStatus(String worldName) {
        return Cookies.getInstance().getMaps().getBoolean("Maps." + worldName + ".SetupCompleted");
    }

    public boolean getEnabled(String worldName) {
        return Cookies.getInstance().getMaps().getBoolean("Maps." + worldName + ".Enabled");
    }

    public void setMapSpawn(String worldName, Location location, String team) {
        Cookies.getInstance().getLocations().addLocation(location, "Maps." + worldName + "." + team);
    }

    public void setMapLocation(String worldName, Location location, String locationName) {
        Cookies.getInstance().getLocations().addLocation(location, "Maps." + worldName + ".Locations." + locationName);
    }

    public Location getMapSpawn(String worldName, String team) {
        return Cookies.getInstance().getLocations().getLocation("Maps." + worldName + "." + team);
    }

    public Location getMapLocation(String worldName, String locationName) {
        return Cookies.getInstance().getLocations().getLocation("Maps." + worldName + ".Locations." + locationName);
    }

}
