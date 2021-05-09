package at.paxfu.cookies.commands;

import at.paxfu.cookies.Cookies;
import at.paxfu.cookies.managers.Messages;
import at.paxfu.cookies.managers.Settings;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by paxfu on 08.05.2021.
 */
public class CookiesCMD implements CommandExecutor, Messages, Settings {

    //cookies help
    //cookies setlobby
    //cookies set <map> <team> <point>
    //cookies set <map> spectator

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(args.length == 0) {

            }else if(args.length == 1) {
                if(args[0].equalsIgnoreCase("setlobby")) {
                    if(player.hasPermission("cookies.setup")) {
                        Location loc = player.getLocation();
                        Cookies.getInstance().getLocations().addLocation(loc, "Lobby.Spawn");
                        player.sendMessage(Lobby_Spawn_Set);
                    }else {
                        player.sendMessage(Error_NoPerm);
                    }
                }
            }else if(args.length == 2) {

            }
        }
        return false;
    }
}
