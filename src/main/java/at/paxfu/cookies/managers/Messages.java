package at.paxfu.cookies.managers;

import at.paxfu.cookies.Cookies;
import at.paxfu.cookies.countdowns.LobbyCountdown;
import org.bukkit.ChatColor;

/**
 * Created by paxfu on 07.05.2021.
 */
public interface Messages {

    //General Messages
    String Prefix = ChatColor.translateAlternateColorCodes('&', Cookies.getInstance().getMessages().getStringOrSetDefault("Prefix", "&f[&6Cookies&f]"));

    //Error Messages
    String Error_NoPerm = Prefix + " " + ChatColor.translateAlternateColorCodes('&', Cookies.getInstance().getMessages().getStringOrSetDefault("General.NoPermMessage", "&cDafür hast du keine Rechte!"));
    String Error_LobbySpawn_Not_Found = Prefix + " " + ChatColor.translateAlternateColorCodes('&', Cookies.getInstance().getMessages().getStringOrSetDefault("General.NoLobbySpawn", "&cDer Lobby - Spawn existiert noch nicht!"));
    String Error_Console_Sender = Prefix + " " + ChatColor.translateAlternateColorCodes('&', Cookies.getInstance().getMessages().getStringOrSetDefault("General.NoConsoleSender", "&cNur ein Spieler kann dies ausführen!"));

    String Error_Setup_World_NotExists = Prefix + " " + ChatColor.translateAlternateColorCodes('&', Cookies.getInstance().getMessages().getStringOrSetDefault("General.Setup.WorldNotExists", "&cDiese Welt gibt es nicht!"));

    //Setup Messages
    String Setup_Map_Created = Prefix + " " + ChatColor.translateAlternateColorCodes('&', Cookies.getInstance().getMessages().getStringOrSetDefault("General.Setup.MapCreated", "&7Du hast erfolgreich die Map &e%MAP% &7erstellt!"));

    //Lobby Messages
    String Lobby_JoinMSG = ChatColor.translateAlternateColorCodes('&', Cookies.getInstance().getMessages().getStringOrSetDefault("Lobby.JoinMessage", "&e%PLAYER% &7hat das Spiel betreten! [&e%PLAYERS%&7/&e%MAXPLAYERS%&7]"));
    String Lobby_QuitMSG = ChatColor.translateAlternateColorCodes('&', Cookies.getInstance().getMessages().getStringOrSetDefault("Lobby.QuitMessage", "&e%PLAYER% &7hat das Spiel verlassen! [&e%PLAYERS%&7/&e%MAXPLAYERS%&7]"));
    String Lobby_Spawn_Set = Prefix + " " + ChatColor.translateAlternateColorCodes('&', Cookies.getInstance().getMessages().getStringOrSetDefault("Command.SetLobby.Success", "&7Du hast &eerfolgreich &7den Spawn gesetzt!"));
    String Lobby_CountdownTime_MSG = Prefix + " " + ChatColor.translateAlternateColorCodes('&', Cookies.getInstance().getMessages().getStringOrSetDefault("Lobby.Countdown.Time.Message", "&7Das Spiel startet in &e%SECONDS% Sekunden&7!"));
    String Lobby_Countdown_Forced_MSG = Prefix + " " + ChatColor.translateAlternateColorCodes('&', Cookies.getInstance().getMessages().getStringOrSetDefault("Lobby.Countdown.Time.Forced", "&7Du hast die &eWartezeit &7verkürzt!"));
    String Lobby_Countdown_Force_Not_Running = Prefix + " " + ChatColor.translateAlternateColorCodes('&', Cookies.getInstance().getMessages().getStringOrSetDefault("Lobby.Countdown.Time.NotRunning", "&7Der Countdown hat noch nicht begonnen!"));
    String Lobby_Countdown_Force_Too_Late = Prefix + " " + ChatColor.translateAlternateColorCodes('&', Cookies.getInstance().getMessages().getStringOrSetDefault("Lobby.Countdown.Time.TooLate", "&7Du kannst die &eWartezeit &7nicht mehr verkürzen!"));
    String Lobby_Countdown_Stopped = Prefix + " " + ChatColor.translateAlternateColorCodes('&', Cookies.getInstance().getMessages().getStringOrSetDefault("Lobby.Countdown.Stopped", "&7Der Countdown wurde &eabgebrochen&7!"));
    String Lobby_GameStarted_MSG = Prefix + " " + ChatColor.translateAlternateColorCodes('&', Cookies.getInstance().getMessages().getStringOrSetDefault("Lobby.Countdown.GameStarted", "&7Das Spiel &estartet &7nun!"));

    //Team Messages
    String Team_Join_Success = Prefix + " " + ChatColor.translateAlternateColorCodes('&', Cookies.getInstance().getMessages().getStringOrSetDefault("Teams.Join.Success", "&7Du bist nun im Team &e%TEAM%&7!"));
    String Team_Join_Failed_Filled = Prefix + " " + ChatColor.translateAlternateColorCodes('&', Cookies.getInstance().getMessages().getStringOrSetDefault("Teams.Join.Failed.Full", "&7Team &e%TEAM% &7ist bereits voll!"));
    String Team_Remove_Failed_None = Prefix + " " + ChatColor.translateAlternateColorCodes('&', Cookies.getInstance().getMessages().getStringOrSetDefault("Teams.Remove.Failed.None", "&7Du bist in keinen Team!"));
}
