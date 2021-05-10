package at.paxfu.cookies.inventories;

import at.paxfu.cookies.Cookies;
import at.paxfu.cookies.managers.Messages;
import at.paxfu.cookies.managers.Settings;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by paxfu on 09.05.2021.
 */
public class TeamInventory implements Settings, Messages {

    private final static Inventory inventory = Bukkit.createInventory(null, 27, Team_GUI_Name);
    public static Inventory getInventory() {
        return inventory;
    }

    public static List<String> team1_lore() {
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7>> -");
        lore.add("§7>> -");
        lore.add(" ");
        lore.add(getTeamColorAsString(Team_Team1_Color) + "§lKlicken §7§lum das Team zu betreten");

        if(Cookies.getInstance().teamManager.team1.isEmpty()) {
            lore.set(1, "§7>> -");
            lore.set(2, "§7>> -");
        }else {
            if (Cookies.getInstance().teamManager.team1.size() == 1) {
                lore.set(1, "§7>> " + getTeamColorAsString(Team_Team1_Color) + Cookies.getInstance().teamManager.team1.get(0).getName());
                lore.set(2, "§7>> -");
            } else if (Cookies.getInstance().teamManager.team1.size() == 2) {
                lore.set(1, "§7>> " + getTeamColorAsString(Team_Team1_Color) + Cookies.getInstance().teamManager.team1.get(0).getName());
                lore.set(2, "§7>> " + getTeamColorAsString(Team_Team1_Color) + Cookies.getInstance().teamManager.team1.get(1).getName());
            } else {
                lore.set(1, "§7>> -");
                lore.set(2, "§7>> -");
            }
        }
        return lore;
    }

    public static List<String> team2_lore() {
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7>> -");
        lore.add("§7>> -");
        lore.add(" ");
        lore.add(getTeamColorAsString(Team_Team2_Color) + "§lKlicken §7§lum das Team zu betreten");

        if(Cookies.getInstance().teamManager.team2.isEmpty()) {
            lore.set(1, "§7>> -");
            lore.set(2, "§7>> -");
        }else {
            if (Cookies.getInstance().teamManager.team2.size() == 1) {
                lore.set(1, "§7>> " + getTeamColorAsString(Team_Team2_Color) + Cookies.getInstance().teamManager.team2.get(0).getName());
                lore.set(2, "§7>> -");
            } else if (Cookies.getInstance().teamManager.team2.size() == 2) {
                lore.set(1, "§7>> " + getTeamColorAsString(Team_Team2_Color) + Cookies.getInstance().teamManager.team2.get(0).getName());
                lore.set(2, "§7>> " + getTeamColorAsString(Team_Team2_Color) + Cookies.getInstance().teamManager.team2.get(1).getName());
            } else {
                lore.set(1, "§7>> -");
                lore.set(2, "§7>> -");
            }
        }
        return lore;
    }

    public static List<String> team3_lore() {
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7>> -");
        lore.add("§7>> -");
        lore.add(" ");
        lore.add(getTeamColorAsString(Team_Team3_Color) + "§lKlicken §7§lum das Team zu betreten");

        if(Cookies.getInstance().teamManager.team3.isEmpty()) {
            lore.set(1, "§7>> -");
            lore.set(2, "§7>> -");
        }else {
            if (Cookies.getInstance().teamManager.team3.size() == 1) {
                lore.set(1, "§7>> " + getTeamColorAsString(Team_Team3_Color) + Cookies.getInstance().teamManager.team3.get(0).getName());
                lore.set(2, "§7>> -");
            } else if (Cookies.getInstance().teamManager.team3.size() == 2) {
                lore.set(1, "§7>> " + getTeamColorAsString(Team_Team3_Color) + Cookies.getInstance().teamManager.team3.get(0).getName());
                lore.set(2, "§7>> " + getTeamColorAsString(Team_Team3_Color) + Cookies.getInstance().teamManager.team3.get(1).getName());
            } else {
                lore.set(1, "§7>> -");
                lore.set(2, "§7>> -");
            }
        }
        return lore;
    }

    public static List<String> team4_lore() {
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7>> -");
        lore.add("§7>> -");
        lore.add(" ");
        lore.add(getTeamColorAsString(Team_Team4_Color) + "§lKlicken §7§lum das Team zu betreten");

        if(Cookies.getInstance().teamManager.team4.isEmpty()) {
            lore.set(1, "§7>> -");
            lore.set(2, "§7>> -");
        }else {
            if (Cookies.getInstance().teamManager.team4.size() == 1) {
                lore.set(1, "§7>> " + getTeamColorAsString(Team_Team4_Color) + Cookies.getInstance().teamManager.team4.get(0).getName());
                lore.set(2, "§7>> -");
            } else if (Cookies.getInstance().teamManager.team4.size() == 2) {
                lore.set(1, "§7>> " + getTeamColorAsString(Team_Team4_Color) + Cookies.getInstance().teamManager.team4.get(0).getName());
                lore.set(2, "§7>> " + getTeamColorAsString(Team_Team4_Color) + Cookies.getInstance().teamManager.team4.get(1).getName());
            } else {
                lore.set(1, "§7>> -");
                lore.set(2, "§7>> -");
            }
        }
        return lore;
    }

    public static void openInventory(Player player) {
        for (int i = 0; i <= 9; i++) {
            inventory.setItem(i, createItem("§b", Collections.singletonList("§b"), Material.BLACK_STAINED_GLASS_PANE, 1));
        }

        inventory.setItem(10, team1());
        inventory.setItem(11, createItem("§b", Collections.singletonList("§b"), Material.BLACK_STAINED_GLASS_PANE, 1));
        inventory.setItem(12, team2());
        inventory.setItem(13, createItem("§b", Collections.singletonList("§b"), Material.BLACK_STAINED_GLASS_PANE, 1));
        inventory.setItem(14, team3());
        inventory.setItem(15, createItem("§b", Collections.singletonList("§b"), Material.BLACK_STAINED_GLASS_PANE, 1));
        inventory.setItem(16, team4());

        for (int i = 17; i <= 26; i++) {
            inventory.setItem(i, createItem("§b", Collections.singletonList("§b"), Material.BLACK_STAINED_GLASS_PANE, 1));
        }
        player.openInventory(inventory);
    }

    private static Material getTeamColorAsWoolBlock(String team) {
        if (team.contains("white")) {
            return Material.WHITE_WOOL;
        } else if (team.contains("black")) {
            return Material.BLACK_WOOL;
        } else if (team.contains("red")) {
            return Material.RED_WOOL;
        } else if (team.contains("blue")) {
            return Material.BLUE_WOOL;
        } else if (team.contains("green")) {
            return Material.GREEN_WOOL;
        } else if (team.contains("yellow")) {
            return Material.YELLOW_WOOL;
        } else if (team.contains("pink")) {
            return Material.PINK_WOOL;
        } else if (team.contains("purple")) {
            return Material.PURPLE_WOOL;
        }
        return Material.BARRIER;
    }

    private static String getTeamColorAsString(String team) {
        if (team.contains("white")) {
            return "§f";
        } else if (team.contains("black")) {
            return "§0";
        } else if (team.contains("red")) {
            return "§c";
        } else if (team.contains("blue")) {
            return "§9";
        } else if (team.contains("green")) {
            return "§a";
        } else if (team.contains("yellow")) {
            return "§e";
        } else if (team.contains("pink")) {
            return "§d";
        } else if (team.contains("purple")) {
            return "§5";
        }
        return "Invalid Color";
    }

    private static Color getTeamColorAsColor(String team) {
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

    private static ItemStack createItem(String name, List<String> lore, Material mat, Integer amount) {
        ItemStack is = new ItemStack(mat, amount);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(name);
        im.setLore(lore);
        is.setItemMeta(im);

        return is;
    }
    public static ItemStack team1() {
        if(!Team_Inventory_Use_Shoes) {
            ItemStack is = new ItemStack(getTeamColorAsWoolBlock(Team_Team1_Color), 1);
            ItemMeta im = is.getItemMeta();
            im.setDisplayName(getTeamColorAsString(Team_Team1_Color) + Team_Team1_Name);


            im.setLore(team1_lore());
            im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            im.addItemFlags(ItemFlag.HIDE_DYE);
            is.setItemMeta(im);
            return is;
        } else {
            ItemStack is = new ItemStack(Material.LEATHER_BOOTS, 1);
            LeatherArmorMeta im = (LeatherArmorMeta) is.getItemMeta();
            im.setColor(getTeamColorAsColor(Team_Team1_Color));
            im.setDisplayName(getTeamColorAsString(Team_Team1_Color) + Team_Team1_Name);


            im.setLore(team1_lore());
            is.setItemMeta(im);
            return is;
        }
    }
    public static ItemStack team2() {
        if(!Team_Inventory_Use_Shoes) {
            ItemStack is = new ItemStack(getTeamColorAsWoolBlock(Team_Team2_Color), 1);
            ItemMeta im = is.getItemMeta();
            im.setDisplayName(getTeamColorAsString(Team_Team2_Color) + Team_Team2_Name);


            im.setLore(team2_lore());
            im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            im.addItemFlags(ItemFlag.HIDE_DYE);
            is.setItemMeta(im);
            return is;
        } else {
            ItemStack is = new ItemStack(Material.LEATHER_BOOTS, 1);
            LeatherArmorMeta im = (LeatherArmorMeta) is.getItemMeta();
            im.setColor(getTeamColorAsColor(Team_Team2_Color));
            im.setDisplayName(getTeamColorAsString(Team_Team2_Color) + Team_Team2_Name);


            im.setLore(team2_lore());
            is.setItemMeta(im);
            return is;
        }
    }
    public static ItemStack team3() {
        if(!Team_Inventory_Use_Shoes) {
            ItemStack is = new ItemStack(getTeamColorAsWoolBlock(Team_Team3_Color), 1);
            ItemMeta im = is.getItemMeta();
            im.setDisplayName(getTeamColorAsString(Team_Team3_Color) + Team_Team3_Name);


            im.setLore(team3_lore());
            im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            im.addItemFlags(ItemFlag.HIDE_DYE);
            is.setItemMeta(im);
            return is;
        } else {
            ItemStack is = new ItemStack(Material.LEATHER_BOOTS, 1);
            LeatherArmorMeta im = (LeatherArmorMeta) is.getItemMeta();
            im.setColor(getTeamColorAsColor(Team_Team3_Color));
            im.setDisplayName(getTeamColorAsString(Team_Team3_Color) + Team_Team3_Name);


            im.setLore(team3_lore());
            is.setItemMeta(im);
            return is;
        }
    }
    public static ItemStack team4() {
        if(!Team_Inventory_Use_Shoes) {
            ItemStack is = new ItemStack(getTeamColorAsWoolBlock(Team_Team4_Color), 1);
            ItemMeta im = is.getItemMeta();
            im.setDisplayName(getTeamColorAsString(Team_Team4_Color) + Team_Team4_Name);


            im.setLore(team4_lore());
            im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            im.addItemFlags(ItemFlag.HIDE_DYE);
            is.setItemMeta(im);
            return is;
        } else {
            ItemStack is = new ItemStack(Material.LEATHER_BOOTS, 1);
            LeatherArmorMeta im = (LeatherArmorMeta) is.getItemMeta();
            im.setColor(getTeamColorAsColor(Team_Team4_Color));
            im.setDisplayName(getTeamColorAsString(Team_Team4_Color) + Team_Team4_Name);


            im.setLore(team4_lore());
            is.setItemMeta(im);
            return is;
        }
    }
}
