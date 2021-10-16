package com.codecool.leaguestatistics.controller;

import com.codecool.leaguestatistics.factory.LeagueFactory;
import com.codecool.leaguestatistics.model.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides all necessary methods for season simulation
 */
public class Season {

    private List<Team> league;

    public Season() {
        league = new ArrayList<>();
    }

    /**
     * Fills league with new teams and simulates all games in season.
     * After all games played calls table to be displayed.
     */
    public void run() {
        this.league = LeagueFactory.createLeague(6);
        playAllGames();
        // Call Display methods below

    }

    /**
     * Playing whole round. Everyone with everyone one time. Number of teams in league should be even.
     * Following solution represents the robin-round tournament.
     */
    private void playAllGames() {
        throw new RuntimeException("playAllGames method not implemented");
    }

    /**
     * Plays single game between two teams and displays result after.
     */
    private void playMatch(Team team1, Team team2) {
        throw new RuntimeException("playMatch method not implemented");
    }

    /**
     * Checks for each player of given team chance to score based on skillrate.
     * Adds scored goals to player's and team's statistics.
     * @return All goals scored by the team in current game
     */
    private int getScoredGoals(Team team) {
        throw new RuntimeException("getScoredGoals method not implemented");
    }
}
