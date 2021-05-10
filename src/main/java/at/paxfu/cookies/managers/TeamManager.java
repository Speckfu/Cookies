package at.paxfu.cookies.managers;

import at.paxfu.cookies.Cookies;
import at.paxfu.cookies.inventories.TeamInventory;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by paxfu on 09.05.2021.
 */
public class TeamManager implements Messages, Settings, Permissions {

    public HashMap<Player, String> playerTeam = new HashMap<>();
    public ArrayList<Player> team1 = new ArrayList<>();
    public ArrayList<Player> team2 = new ArrayList<>();
    public ArrayList<Player> team3 = new ArrayList<>();
    public ArrayList<Player> team4 = new ArrayList<>();

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

    public void addUserToTeam(Player player, String team) {
        if(team.equalsIgnoreCase("team1")) {
            if(team1.size() < 2) {
                if(isUserInTeam(player)) {
                    removeUserOfTeam(player);
                }
                team1.add(player);
                playerTeam.put(player, "team1");
                player.sendMessage(Team_Join_Success.replace("%TEAM%", Team_Team1_Name));
                player.playSound(player.getEyeLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.1F, 0.1F);

                ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
                LeatherArmorMeta meta = (LeatherArmorMeta) chest.getItemMeta();
                meta.setColor(getTeamColorAsString(Team_Team1_Color));
                meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                meta.addItemFlags(ItemFlag.HIDE_DYE);
                chest.setItemMeta(meta);
                player.getEquipment().setChestplate(chest);
            }else {
                player.sendMessage(Team_Join_Failed_Filled.replace("%TEAM%", Team_Team1_Name));
            }
        }else if(team.equalsIgnoreCase("team2")) {
            if(team2.size() < 2) {
                if(isUserInTeam(player)) {
                    removeUserOfTeam(player);
                }
                team2.add(player);
                playerTeam.put(player, "team2");
                player.sendMessage(Team_Join_Success.replace("%TEAM%", Team_Team2_Name));
                player.playSound(player.getEyeLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.1F, 0.1F);

                ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
                LeatherArmorMeta meta = (LeatherArmorMeta) chest.getItemMeta();
                meta.setColor(getTeamColorAsString(Team_Team2_Color));
                meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                meta.addItemFlags(ItemFlag.HIDE_DYE);
                chest.setItemMeta(meta);
                player.getEquipment().setChestplate(chest);
            }else {
                player.sendMessage(Team_Join_Failed_Filled.replace("%TEAM%", Team_Team2_Name));
            }
        }else if(team.equalsIgnoreCase("team3")) {
            if(team3.size() < 2) {
                if(isUserInTeam(player)) {
                    removeUserOfTeam(player);
                }
                team3.add(player);
                playerTeam.put(player, "team3");
                player.sendMessage(Team_Join_Success.replace("%TEAM%", Team_Team3_Name));
                player.playSound(player.getEyeLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.1F, 0.1F);

                ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
                LeatherArmorMeta meta = (LeatherArmorMeta) chest.getItemMeta();
                meta.setColor(getTeamColorAsString(Team_Team3_Color));
                meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                meta.addItemFlags(ItemFlag.HIDE_DYE);
                chest.setItemMeta(meta);
                player.getEquipment().setChestplate(chest);
            }else {
                player.sendMessage(Team_Join_Failed_Filled.replace("%TEAM%", Team_Team3_Name));
            }
        }else if(team.equalsIgnoreCase("team4")) {
            if(team4.size() < 2) {
                if(isUserInTeam(player)) {
                    removeUserOfTeam(player);
                }
                team4.add(player);
                playerTeam.put(player, "team4");
                player.sendMessage(Team_Join_Success.replace("%TEAM%", Team_Team4_Name));
                player.playSound(player.getEyeLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.1F, 0.1F);

                ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
                LeatherArmorMeta meta = (LeatherArmorMeta) chest.getItemMeta();
                meta.setColor(getTeamColorAsString(Team_Team4_Color));
                meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                meta.addItemFlags(ItemFlag.HIDE_DYE);
                chest.setItemMeta(meta);
                player.getEquipment().setChestplate(chest);
            }else {
                player.sendMessage(Team_Join_Failed_Filled.replace("%TEAM%", Team_Team4_Name));
            }
        }else {
            Bukkit.getConsoleSender().sendMessage(Prefix + " §cEin Fehler im Team Manager ist aufgetreten!");
        }
    }

    public boolean isUserInTeam(Player player) {
        if(playerTeam.containsKey(player)) {
            return true;
        }else {
            return false;
        }
    }

    public void removeUserOfTeam(Player player) {
        if(isUserInTeam(player)) {
            if(team1.contains(player)) {
                team1.remove(player);
                playerTeam.remove(player);
            }else if(team2.contains(player)) {
                team2.remove(player);
                playerTeam.remove(player);
            }else if(team3.contains(player)) {
                team3.remove(player);
                playerTeam.remove(player);
            }else if(team4.contains(player)) {
                team4.remove(player);
                playerTeam.remove(player);
            }else {
                Bukkit.getConsoleSender().sendMessage(Prefix + " §cEin Fehler im Team Manager ist aufgetreten!");
            }
        }else {
            player.sendMessage(Team_Remove_Failed_None);
        }
    }
}
