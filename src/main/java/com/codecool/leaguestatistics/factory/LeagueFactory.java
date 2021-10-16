package com.codecool.leaguestatistics.factory;

import com.codecool.leaguestatistics.Utils;
import com.codecool.leaguestatistics.model.Player;
import com.codecool.leaguestatistics.model.Team;


import java.util.List;

/**
 * Provides full set of teams with players
 */
public class LeagueFactory {

    /**
     * For each division, creates given amount of teams. Each team gets a newly created collection of players.
     * The amount of players should be taken from Utils.TEAM_SIZE
     * @param teamsInDivision Indicates number of teams are in division
     * @return Full set of teams with players
     */
    public static List<Team> createLeague(int teamsInDivision) {
        throw new RuntimeException("createLeague method not implemented");
    }

    /**
     * Returns a collection with a given amount of newly created players
     */
    private static List<Player> getPlayers(int amount) {
        throw new RuntimeException("getPlayers method not implemented");
    }

    private static int getPlayerSkillRate() {
        return Utils.getRandomValue(5, 21);
    }
}
