package com.NbaStats2.Api.dto;

import java.util.Set;


public class TeamDto1 {
    private String abbreviation;
    private String conference;
    private String full_name;
    private Set<PlayerDto1> players;

    public String getAbbreviation() {
        return abbreviation;
    }

    public TeamDto1 setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
        return this;
    }

    public String getConference() {
        return conference;
    }

    public TeamDto1 setConference(String conference) {
        this.conference = conference;
        return this;
    }

    public String getFull_name() {
        return full_name;
    }

    public TeamDto1 setFull_name(String full_name) {
        this.full_name = full_name;
        return this;
    }

    public Set<PlayerDto1> getPlayers() {
        return players;
    }

    public TeamDto1 setPlayers(Set<PlayerDto1> players) {
        this.players = players;
        return this;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "abbreviation = " + abbreviation + ", " +
                "conference = " + conference + ", " +
                "full_name = " + full_name + ", " +
                "players = " + players + ")";
    }
}