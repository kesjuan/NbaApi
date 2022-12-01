package com.NbaStats2.Api.dto;


public class PlayerDto  {
    private Long id;
    private String name;
    private String position;
    private String teamAbbreviation;
    private String teamFull_name;

    public Long getId() {
        return id;
    }

    public PlayerDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PlayerDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public PlayerDto setPosition(String position) {
        this.position = position;
        return this;
    }

    public String getTeamAbbreviation() {
        return teamAbbreviation;
    }

    public PlayerDto setTeamAbbreviation(String teamAbbreviation) {
        this.teamAbbreviation = teamAbbreviation;
        return this;
    }

    public String getTeamFull_name() {
        return teamFull_name;
    }

    public PlayerDto setTeamFull_name(String teamFull_name) {
        this.teamFull_name = teamFull_name;
        return this;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "position = " + position + ", " +
                "teamAbbreviation = " + teamAbbreviation + ", " +
                "teamFull_name = " + teamFull_name + ")";
    }
}