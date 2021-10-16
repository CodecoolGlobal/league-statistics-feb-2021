package com.codecool.leaguestatistics.model;

import com.codecool.leaguestatistics.factory.NamesGenerator;

/**
 * Represents player
 */
public class Player {

    /**
     * Player's name
     */
    private String name;

    /**
     * SkillRate is a percentage chance to score a goal
     */
    private int skillRate;

    /**
     * Amount of scored goals
     */
    private int goals;

    public Player(int skillRate) {
        name = NamesGenerator.getPlayerName();
        this.skillRate = skillRate;
    }

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSkillRate() {
        return skillRate;
    }

    public void setSkillRate(int skillRate) {
        this.skillRate = skillRate;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }
}
