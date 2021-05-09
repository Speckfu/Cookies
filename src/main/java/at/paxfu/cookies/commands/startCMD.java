package at.paxfu.cookies.commands;

import at.paxfu.cookies.Cookies;
import at.paxfu.cookies.managers.Messages;
import at.paxfu.cookies.managers.Permissions;
import at.paxfu.cookies.managers.Settings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by paxfu on 09.05.2021.
 */
public class startCMD implements CommandExecutor, Settings, Messages, Permissions {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(Lobby_CountdownTime_Force_Enabled) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if(player.hasPermission(PERM_forceStart)) {
                    if(Cookies.getInstance().lobbyCountdown.isRunning) {
                        if(Cookies.getInstance().lobbyCountdown.count > Lobby_CountdownTime_Force) {
                            Cookies.getInstance().lobbyCountdown.count = Lobby_CountdownTime_Force;
                            player.sendMessage(Lobby_Countdown_Forced_MSG);
                        }else {
                            player.sendMessage(Lobby_Countdown_Force_Too_Late);
                        }
                    }else {
                        player.sendMessage(Lobby_Countdown_Force_Not_Running);
                    }
                }else {
                    player.sendMessage(Error_NoPerm);
                }
            }else {
                sender.sendMessage(Error_Console_Sender);
            }
        }
        return false;
    }
}
