package at.paxfu.cookies.countdowns;

import at.paxfu.cookies.Cookies;
import at.paxfu.cookies.gamestates.GameStates;
import at.paxfu.cookies.managers.Messages;
import at.paxfu.cookies.managers.Settings;
import at.paxfu.cookies.managers.TeamManager;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

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
                        Cookies.getInstance().sideboard.setIngameScoreboard(all, 0, 0, "§c", 0);
                    }
                    //cancel task
                    Bukkit.getScheduler().cancelTask(schedulerID);

                    //change gamestate
                    Cookies.getInstance().gameState = GameStates.INGAME;

                    teleportPlayers();
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

    private static Color getTeamColorAsString(String team) {
        if (team.contains("white")) {
            return Color.WHITE;
        } else if (team.contains("black")) {
            return Color.BLACK;
        } else if (team.contains("red")) {
            return Color.RED;
        } else if (team.contains("blue")) {
            return Color.BLUE;
        } else if (team.contains("green")) {
            return Color.GREEN;
        } else if (team.contains("yellow")) {
            return Color.YELLOW;
        } else if (team.contains("pink")) {
            return Color.FUCHSIA;
        } else if (team.contains("purple")) {
            return Color.PURPLE;
        }
        return Color.BLACK;
    }

    public void teleportPlayers() {
        for(Player team1Users : Cookies.getInstance().teamManager.team1) {
            Location teamSpawn = Cookies.getInstance().mapManager.getMapSpawn("cookies", "team1");
            team1Users.teleport(new Location(teamSpawn.getWorld(), teamSpawn.getX(), teamSpawn.getY(), teamSpawn.getZ(), teamSpawn.getYaw(), teamSpawn.getPitch()));

            ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta meta = (LeatherArmorMeta) chest.getItemMeta();
            meta.setColor(getTeamColorAsString(Team_Team1_Color));
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.addItemFlags(ItemFlag.HIDE_DYE);
            chest.setItemMeta(meta);
            team1Users.getEquipment().setChestplate(chest);
        }

        for(Player team2Users : Cookies.getInstance().teamManager.team2) {
            Location teamSpawn = Cookies.getInstance().mapManager.getMapSpawn("cookies", "team2");
            team2Users.teleport(new Location(teamSpawn.getWorld(), teamSpawn.getX(), teamSpawn.getY(), teamSpawn.getZ(), teamSpawn.getYaw(), teamSpawn.getPitch()));

            ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta meta = (LeatherArmorMeta) chest.getItemMeta();
            meta.setColor(getTeamColorAsString(Team_Team2_Color));
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.addItemFlags(ItemFlag.HIDE_DYE);
            chest.setItemMeta(meta);
            team2Users.getEquipment().setChestplate(chest);
        }

        for(Player team3Users : Cookies.getInstance().teamManager.team3) {
            Location teamSpawn = Cookies.getInstance().mapManager.getMapSpawn("cookies", "team3");
            team3Users.teleport(new Location(teamSpawn.getWorld(), teamSpawn.getX(), teamSpawn.getY(), teamSpawn.getZ(), teamSpawn.getYaw(), teamSpawn.getPitch()));

            ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta meta = (LeatherArmorMeta) chest.getItemMeta();
            meta.setColor(getTeamColorAsString(Team_Team3_Color));
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.addItemFlags(ItemFlag.HIDE_DYE);
            chest.setItemMeta(meta);
            team3Users.getEquipment().setChestplate(chest);
        }

        for(Player team4Users : Cookies.getInstance().teamManager.team4) {
            Location teamSpawn = Cookies.getInstance().mapManager.getMapSpawn("cookies", "team4");
            team4Users.teleport(new Location(teamSpawn.getWorld(), teamSpawn.getX(), teamSpawn.getY(), teamSpawn.getZ(), teamSpawn.getYaw(), teamSpawn.getPitch()));

            ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta meta = (LeatherArmorMeta) chest.getItemMeta();
            meta.setColor(getTeamColorAsString(Team_Team4_Color));
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.addItemFlags(ItemFlag.HIDE_DYE);
            chest.setItemMeta(meta);
            team4Users.getEquipment().setChestplate(chest);
        }
    }
}
