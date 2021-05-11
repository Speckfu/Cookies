package at.paxfu.cookies.commands;

import at.paxfu.cookies.Cookies;
import at.paxfu.cookies.managers.Messages;
import at.paxfu.cookies.managers.Permissions;
import at.paxfu.cookies.managers.Settings;
import at.paxfu.cookies.mapmanager.MapManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Objects;

/**
 * Created by paxfu on 08.05.2021.
 */
public class CookiesCMD implements CommandExecutor, Messages, Settings, Permissions {

    //cookies help
    //cookies setlobby
    //cookies createmap <NAME> <BUILDER> <WORLDNAME>
    //cookies setspawn <map> <team>
    //cookies setspectator <map>

    int cl = 1;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(args.length == 0) {

            }else if(args.length == 1) {
                if(args[0].equalsIgnoreCase("setlobby")) {
                    if(player.hasPermission(PERM_setup)) {
                        Location loc = player.getLocation();
                        Cookies.getInstance().getLocations().addLocation(loc, "Lobby.Spawn");
                        player.sendMessage(Lobby_Spawn_Set);
                    }else {
                        player.sendMessage(Error_NoPerm);
                    }
                }
            }else if(args.length == 2) {
                if(args[0].equalsIgnoreCase("setspectator")) {
                    if(player.hasPermission(PERM_setup)) {
                        Cookies.getInstance().mapManager.setMapLocation(player.getWorld().getName(), player.getLocation(), "spectator");
                        player.sendMessage(Setup_Spectator_Spawn_Created);
                    }else {
                        player.sendMessage(Error_NoPerm);
                    }
                }
            }else if(args.length == 3) {
                if(args[0].equalsIgnoreCase("setspawn")) {
                    if(player.hasPermission(PERM_setup)) {
                        String worldName = player.getWorld().getName();
                        try {
                            int teamNumber = Integer.parseInt(args[2]);
                            String teamName = "";
                            if(teamNumber >= 1 && teamNumber <= 4) {
                                if(teamNumber == 1) teamName = "team1";
                                if(teamNumber == 2) teamName = "team2";
                                if(teamNumber == 3) teamName = "team3";
                                if(teamNumber == 4) teamName = "team4";
                                Cookies.getInstance().mapManager.setMapSpawn(worldName, player.getLocation(), teamName);
                                player.sendMessage(Setup_Team_Spawn_Created.replace("%TEAM%", String.valueOf(teamNumber)));
                            }else {
                                player.sendMessage(Error_Setup_Team_NotExists);
                            }
                        }catch (NumberFormatException e) {
                            player.sendMessage(Error_Setup_Team_NotExists);
                        }

                    }else {
                        player.sendMessage(Error_NoPerm);
                    }
                }
            }else if(args.length == 4) {
                if(args[0].equalsIgnoreCase("createmap")) {
                    if(player.hasPermission(PERM_setup)) {
                        String name = args[1];
                        String builder = args[2];
                        String worldname = args[3];

                        if(Bukkit.getWorld(worldname) != null) {
                            Cookies.getInstance().mapManager.createMap(name, worldname, builder, true, false);
                            player.sendMessage(Setup_Map_Created.replace("%MAP%", name));
                        }else {
                            player.sendMessage(Error_Setup_World_NotExists.replace("%WORLD%", worldname));
                        }
                    }else {
                        player.sendMessage(Error_NoPerm);
                    }
                }
            }
        }
        return false;
    }
}
