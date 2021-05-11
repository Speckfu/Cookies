package at.paxfu.cookies.scoreboard;

import at.paxfu.cookies.managers.Settings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

/**
 * Created by paxfu on 11.05.2021.
 */
public class Sideboard implements Settings {

    public void setLobbyScoreboard(Player player, String mapName) {
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = board.registerNewObjective("lobbyboard", "dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(Scoreboard_Title);

        Team map = board.registerNewTeam("map");

        obj.getScore("§1").setScore(5);
        obj.getScore("§fMap:").setScore(4);
        obj.getScore("§2").setScore(3);
        obj.getScore("§3").setScore(2);
        obj.getScore("§fSpieler").setScore(1);
        obj.getScore("§e4§7x§e2").setScore(0);

        map.addEntry("§2");
        map.setPrefix("§e" + mapName);

        player.setScoreboard(board);
    }

    public void setIngameScoreboard(Player player, Integer konto, Integer team, String towerColor, Integer towerPercent) {
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = board.registerNewObjective("ingameboard", "dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(Scoreboard_Title);

        Team kontoTeam = board.registerNewTeam("konto");
        Team teamKontoTeam = board.registerNewTeam("teamkonto");
        Team turmPercentTeam = board.registerNewTeam("turmpercent");

        obj.getScore("§1").setScore(8);
        obj.getScore("§fDein Konto:").setScore(7);
        obj.getScore("§2").setScore(6);
        obj.getScore("§3").setScore(5);
        obj.getScore("§fTeamkonto:").setScore(4);
        obj.getScore("§4").setScore(3);
        obj.getScore("§5").setScore(2);
        obj.getScore("§fTurm:").setScore(1);
        obj.getScore("§6").setScore(0);

        kontoTeam.addEntry("§2");
        kontoTeam.setPrefix("§6" + konto + " Cookies");

        teamKontoTeam.addEntry("§4");
        teamKontoTeam.setPrefix("§e" + team + " Cookies");

        turmPercentTeam.addEntry("§6");
        turmPercentTeam.setPrefix(towerColor + towerPercent + " %");

        player.setScoreboard(board);
    }
}
