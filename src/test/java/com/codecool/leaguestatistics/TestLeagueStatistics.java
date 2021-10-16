package com.codecool.leaguestatistics;

import com.codecool.leaguestatistics.model.Division;
import com.codecool.leaguestatistics.model.LeagueStatistics;
import com.codecool.leaguestatistics.model.Player;
import com.codecool.leaguestatistics.model.Team;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestLeagueStatistics {

    public static List<Team> teams;
    public static List<Player> allPlayers;

    @BeforeAll
    static void init() {
        Team team1 = new Team();
        team1.setName("team1");
        team1.setDivision(Division.Central);
        team1.setWins(3);
        team1.setDraws(3);
        team1.setLoses(3);

        Team team2 = new Team();
        team2.setName("team2");
        team2.setDivision(Division.West);
        team2.setWins(0);
        team2.setDraws(4);
        team2.setLoses(5);

        Team team3 = new Team();
        team3.setName("Super team3");
        team3.setDivision(Division.East);
        team3.setWins(4);
        team3.setDraws(0);
        team3.setLoses(5);

        Player player1 = new Player();
        player1.setName("John Wick");
        player1.setGoals(2);
        player1.setSkillRate(11);

        Player player2 = new Player();
        player2.setName("Chris Griffin");
        player2.setGoals(4);
        player2.setSkillRate(17);

        Player player3 = new Player();
        player3.setName("Bruce Wayne");
        player3.setGoals(0);
        player3.setSkillRate(6);

        Player player4 = new Player();
        player4.setName("Bilbo Baggins");
        player4.setGoals(3);
        player4.setSkillRate(13);

        Player player5 = new Player();
        player5.setName("Tsubasa Ozora");
        player5.setGoals(0);
        player5.setSkillRate(7);

        Player player6 = new Player();
        player6.setName("Willy Wonka");
        player6.setGoals(3);
        player6.setSkillRate(18);

        Player player7 = new Player();
        player7.setName("Han Solo");
        player7.setGoals(5);
        player7.setSkillRate(19);

        team1.setPlayers(Arrays.asList(player1, player2, player3));
        team2.setPlayers(Arrays.asList(player4, player5));
        team3.setPlayers(Arrays.asList(player6, player7));

        allPlayers = Arrays.asList(player1, player2, player3, player4, player5, player6, player7);
        teams = Arrays.asList(team1, team2, team3);
    }

    @Test
    public void testGetAllTeamsSorted() {
        List<Team> expectedOrder =  Arrays.asList(teams.get(2), teams.get(0), teams.get(1));
        List<Team> result = LeagueStatistics.getAllTeamsSorted(teams);
        assertEquals(expectedOrder, result);
    }

    @Test
    public void testGetAllPlayers() {
        List<Player> expected = allPlayers;
        List<Player> result = LeagueStatistics.getAllPlayers(teams);
        assertEquals(expected, result);
    }

    @Test
    public void testGetTopTeamsWithLeastLoses() {
        List<Team> expected = Arrays.asList(teams.get(0), teams.get(2));
        List<Team> result = LeagueStatistics.getTopTeamsWithLeastLoses(teams, 2);
        assertEquals(expected, result);
    }

    @Test
    public void testGetTopTeamsWithLeastLosesOutOfBoundaries() {
        List<Team> expected = Arrays.asList(teams.get(0), teams.get(2), teams.get(1));
        List<Team> result = LeagueStatistics.getTopTeamsWithLeastLoses(teams, 5);
        assertEquals(expected, result);
    }

    @Test
    public void testGetTopScorersEachTeam() {
        List<Player> expected = Arrays.asList(allPlayers.get(1), allPlayers.get(3), allPlayers.get(6));
        List<Player> result = LeagueStatistics.getTopPlayersFromEachTeam(teams);
        assertEquals(expected, result);
    }

    @Test
    public void testGetStrongestDivision() {
        Division expected = Division.East;
        Division result = LeagueStatistics.getStrongestDivision(teams);
        assertEquals(expected, result);
    }

    @Test
    public void testGetTeamsWithPlayersWithoutGoal() {
        List<Team> expected = Arrays.asList(teams.get(0), teams.get(1));
        List<Team> result = LeagueStatistics.getTeamsWithPlayersWithoutGoals(teams);
        assertEquals(expected, result);
    }

    @Test
    public void testGetPlayersWithAtLeastXGoals() {
        List<Player> expected = Arrays.asList(allPlayers.get(1), allPlayers.get(6));
        List<Player> result = LeagueStatistics.getPlayersWithAtLeastXGoals(teams,4);
        assertEquals(expected, result);
    }

    @Test
    public void testGetTeamWithTheLongestName() {
        Team expected = teams.get(2);
        Team result = LeagueStatistics.getTeamWithTheLongestName(teams);
        assertEquals(expected, result);
    }

    @Test
    public void testGetMostTalentedPlayerInDivision() {
        Player expected = allPlayers.get(3);
        Player result = LeagueStatistics.getMostTalentedPlayerInDivision(teams, Division.West);
        assertEquals(expected, result);
    }
}
