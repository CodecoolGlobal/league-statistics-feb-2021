package com.codecool.leaguestatistics.model;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Provides all necessary statistics of played season.
 */
public class LeagueStatistics {

    /**
     * Gets all teams with highest points order, if points are equal next deciding parameter is sum of goals of the team.
     */
    public static List<Team> getAllTeamsSorted(List<Team> teams) {
        return teams.stream()
                .sorted(Comparator.comparingInt(Team::getCurrentPoints)
                        .thenComparing(team -> team.getPlayers()
                                .stream()
                                .mapToInt(Player::getGoals)
                                .sum())
                        .reversed())
                .collect(Collectors.toList());
    }

    /**
     * Gets all players from each team in one collection.
     */
    public static List<Player> getAllPlayers(List<Team> teams) {
        return teams.stream()
                .flatMap(team -> team.getPlayers().stream())
                .collect(Collectors.toList());
    }

    /**
     * Gets team with the longest name
     */
    public static Team getTeamWithTheLongestName(List<Team> teams) {
        Optional<Team> longestTeam = teams.stream()
                .max(Comparator.comparingInt(team -> team.getName().length()));

        return longestTeam.orElseThrow(() -> new IllegalStateException("No teams to compare"));
    }

    /**
     * Gets top teams with least number of lost matches.
     * If the amount of lost matches is equal, next deciding parameter is team's current points value.
     *
     * @param teamsNumber The number of Teams to select.
     * @return Collection of selected Teams.
     */
    public static List<Team> getTopTeamsWithLeastLoses(List<Team> teams, int teamsNumber) {
        return teams.stream()
                .sorted(Comparator.comparingInt(Team::getLoses).reversed()
                        .thenComparingInt(Team::getCurrentPoints).reversed())
                .limit(teamsNumber)
                .collect(Collectors.toList());
    }

    /**
     * Gets a player with the biggest goals number from each team.
     */
    public static List<Player> getTopPlayersFromEachTeam(List<Team> teams) {
        return teams.stream()
                .map(Team::getBestPlayer)
                .collect(Collectors.toList());
    }

    /**
     * Gets all teams, where there are players with no scored goals.
     */
    public static List<Team> getTeamsWithPlayersWithoutGoals(List<Team> teams) {
        System.out.println(teams);
        return teams.stream()
                .filter(team -> team.getPlayers()
                        .stream()
                        .anyMatch(player -> player.getGoals() == 0))
                .collect(Collectors.toList());
    }

    /**
     * Gets players with given or higher number of goals scored.
     *
     * @param goals The minimal number of goals scored.
     * @return Collection of Players with given or higher number of goals scored.
     */
    public static List<Player> getPlayersWithAtLeastXGoals(List<Team> teams, int goals) {
        return teams.stream()
                .flatMap(team -> team.getPlayers().stream())
                .filter(player -> player.getGoals() >= goals)
                .collect(Collectors.toList());
    }

    /**
     * Gets the player with the highest skill rate for given Division.
     */
    public static Player getMostTalentedPlayerInDivision(List<Team> teams, Division division) {
        return teams.stream()
                .filter(team -> team.getDivision() == division)
                .flatMap(team -> team.getPlayers().stream())
                .max(Comparator.comparing(Player::getSkillRate))
                .orElseThrow();
    }

    /**
     * OPTIONAL
     * Returns the division with greatest amount of points.
     * If there is more than one division with the same amount current points, then check the amounts of wins.
     */
    public static Division getStrongestDivision(List<Team> teams) {


/*
        Map<Division, List<Team>> grouped = new HashMap<>();
        for (Team team : teams) {
            List<Team> teamsInThisDivision = grouped.getOrDefault(team.getDivision(), new ArrayList<>());
            teamsInThisDivision.add(team);
            grouped.put(team.getDivision(), teamsInThisDivision);
        }
*/

        Map<Division, List<Team>> grouped = teams.stream()
                .collect(Collectors.groupingBy(Team::getDivision));

        return grouped
                .entrySet()
                .stream()
                .map(entry -> new DivisionData(entry.getKey(), entry.getValue()))
                .max(Comparator.comparing(DivisionData::getAllPoints).thenComparing(DivisionData::getAllWins))
                .map(divisionData -> divisionData.division)
                .orElseThrow();
    }

    public static class DivisionData {
        private final Division division;
        private final List<Team> teams;

        public DivisionData(Division division, List<Team> teams) {
            this.division = division;
            this.teams = teams;
        }

        public int getAllPoints() {
            return teams.stream().mapToInt(Team::getCurrentPoints).sum();
        }

        public int getAllWins() {
            return teams.stream().mapToInt(Team::getWins).sum();
        }

        public Division getDivision() {
            return division;
        }

        public List<Team> getTeams() {
            return teams;
        }

    }


}
