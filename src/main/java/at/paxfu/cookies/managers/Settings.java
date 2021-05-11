package at.paxfu.cookies.managers;

import at.paxfu.cookies.Cookies;
import org.bukkit.ChatColor;

/**
 * Created by paxfu on 07.05.2021.
 */
public interface Settings {
    //Rot Grün Blau Gelb
    //red green blue yellow purple pink black cyan white


    //General Settings
    int General_MinPlayers = Cookies.getInstance().getSettings().getIntOrSetDefault("MinPlayers", 2);
    int General_MaxPlayers = Cookies.getInstance().getSettings().getIntOrSetDefault("MaxPlayers", 8);
    String Scoreboard_Title = ChatColor.translateAlternateColorCodes('&', Cookies.getInstance().getSettings().getStringOrSetDefault("Scoreboard.Title", "&6&lCookies"));

    //Lobby Settings
    int Lobby_CountdownTime = Cookies.getInstance().getSettings().getIntOrSetDefault("Lobby.Countdown.Time.Default", 30);
    int Lobby_CountdownTime_Force = Cookies.getInstance().getSettings().getIntOrSetDefault("Lobby.Countdown.Time.Force.Time", 10);
    boolean Lobby_CountdownTime_Force_Enabled = Cookies.getInstance().getSettings().getBooleanOrSetDefault("Lobby.Countdown.Time.Force.Enabled", true);

    //Ingame Settings
    int Ingame_CookieBlock_Bricks_DropsChance = Cookies.getInstance().getSettings().getIntOrSetDefault("Ingame.CookieBlock.Bricks.DropChance", 20);

    //Teams Settings
    boolean Team_Item_Enabled = Cookies.getInstance().getSettings().getBooleanOrSetDefault("Teams.Item.Enabled", true);
    boolean Team_Inventory_Use_Shoes = Cookies.getInstance().getSettings().getBooleanOrSetDefault("Teams.Inventory.UseShoes", true);
    String Team_Item_Name = ChatColor.translateAlternateColorCodes('&', Cookies.getInstance().getSettings().getStringOrSetDefault("Teams.Item.Name", "&eTeams"));
    int Team_Item_Slot = Cookies.getInstance().getSettings().getIntOrSetDefault("Teams.Item.Slot", 1);
    String Team_GUI_Name = ChatColor.translateAlternateColorCodes('&', Cookies.getInstance().getSettings().getStringOrSetDefault("Teams.GUI.Name", "&eTeams"));
    String Team_Team1_Name = Cookies.getInstance().getSettings().getStringOrSetDefault("Teams.Team1.Name", "Rot");
    String Team_Team1_Color = Cookies.getInstance().getSettings().getStringOrSetDefault("Teams.Team1.Color", "red");
    String Team_Team2_Name = Cookies.getInstance().getSettings().getStringOrSetDefault("Teams.Team2.Name", "Grün");
    String Team_Team2_Color = Cookies.getInstance().getSettings().getStringOrSetDefault("Teams.Team2.Color", "green");
    String Team_Team3_Name = Cookies.getInstance().getSettings().getStringOrSetDefault("Teams.Team3.Name", "Blau");
    String Team_Team3_Color = Cookies.getInstance().getSettings().getStringOrSetDefault("Teams.Team3.Color", "blue");
    String Team_Team4_Name = Cookies.getInstance().getSettings().getStringOrSetDefault("Teams.Team4.Name", "Gelb");
    String Team_Team4_Color = Cookies.getInstance().getSettings().getStringOrSetDefault("Teams.Team4.Color", "yellow");



}
