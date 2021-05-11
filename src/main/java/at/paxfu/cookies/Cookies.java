package at.paxfu.cookies;

import at.paxfu.cookies.commands.CookiesCMD;
import at.paxfu.cookies.commands.startCMD;
import at.paxfu.cookies.countdowns.LobbyCountdown;
import at.paxfu.cookies.gamestates.GameStates;
import at.paxfu.cookies.inventories.InventoryListener;
import at.paxfu.cookies.inventories.TeamInventory;
import at.paxfu.cookies.listeners.BlockBreakListener;
import at.paxfu.cookies.listeners.BlockPlaceListener;
import at.paxfu.cookies.listeners.PlayerHandlerListener;
import at.paxfu.cookies.listeners.PlayerInteractListener;
import at.paxfu.cookies.managers.ConfigManager;
import at.paxfu.cookies.managers.Messages;
import at.paxfu.cookies.managers.TeamManager;
import at.paxfu.cookies.mapmanager.MapManager;
import at.paxfu.cookies.mapmanager.VoteManager;
import at.paxfu.cookies.scoreboard.Sideboard;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

@Getter
public final class Cookies extends JavaPlugin implements Messages {

    //Colors: &7, &e, &6
    //ERRORS: &c

    //Default values for cookies
    public ArrayList<Player> alivePlayers = new ArrayList<>();
    public ArrayList<Player> buildModePlayers = new ArrayList<>();

    public GameStates gameState;
    public LobbyCountdown lobbyCountdown;
    public TeamInventory teamInventory;
    public TeamManager teamManager;
    public MapManager mapManager;
    public VoteManager voteManager;

    public Sideboard sideboard = new Sideboard();

    //Register Configs
    private ConfigManager settings;
    private ConfigManager locations;
    private ConfigManager messages;
    private ConfigManager maps;

    @Override
    public void onEnable() {
        instance = this;
        init();
        registerEvents();
        registerCommands();
        Bukkit.getConsoleSender().sendMessage(Prefix + " §aPlugin Enabled!");
        lobbyCountdown = new LobbyCountdown();
        teamInventory = new TeamInventory();
        teamManager = new TeamManager();
        mapManager = new MapManager();
    }

    //Set up configs and other stuff
    private void init() {
        settings = new ConfigManager(this, getDataFolder().getAbsolutePath()+"/", "config", "config");
        locations = new ConfigManager(this, getDataFolder().getAbsolutePath()+"/", "locations", "locations");
        messages = new ConfigManager(this, getDataFolder().getAbsolutePath()+"/", "messages", "messages");
        maps = new ConfigManager(this, getDataFolder().getAbsolutePath()+"/", "maps", "maps");

        gameState = GameStates.LOBBY;
    }

    //Set up and register commands
    private void registerCommands() {
        getCommand("cookies").setExecutor(new CookiesCMD());
        getCommand("start").setExecutor(new startCMD());
    }

    //Set up and register events
    private void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new PlayerHandlerListener(), this);
        Bukkit.getPluginManager().registerEvents(new BlockBreakListener(), this);
        Bukkit.getPluginManager().registerEvents(new BlockPlaceListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteractListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryListener(), this);
    }

    @Override
    public void onDisable() {

    }

    //Main instance
    public static Cookies instance;
    public static Cookies getInstance() {
        return instance;
    }
}
