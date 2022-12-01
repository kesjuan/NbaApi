package com.NbaStats2.Api.dto;

import java.util.Set;


public class TeamDto  {
    private  Long id;
    private  String abbreviation;
    private  String division;
    private  String conference;
    private  String full_name;
    private  Set<PlayerDto> players;

    public TeamDto() {
    }

    public TeamDto(Long id, String abbreviation, String division, String conference, String full_name, Set<PlayerDto> players) {
        this.id = id;
        this.abbreviation = abbreviation;
        this.division = division;
        this.conference = conference;
        this.full_name = full_name;
        this.players = players;
    }

    public Long getId() {
        return id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getDivision() {
        return division;
    }

    public String getConference() {
        return conference;
    }

    public String getFull_name() {
        return full_name;
    }

    public Set<PlayerDto> getPlayers() {
        return players;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setPlayers(Set<PlayerDto> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "TeamDto{" +
                "id=" + id +
                ", abbreviation='" + abbreviation + '\'' +
                ", division='" + division + '\'' +
                ", conference='" + conference + '\'' +
                ", full_name='" + full_name + '\'' +
                ", players=" + players +
                '}';
    }


    public static class PlayerDto {
        private  Long id;
        private  String name;
        private  String position;

        public PlayerDto() {
        }

        public PlayerDto(Long id, String name, String position) {
            this.id = id;
            this.name = name;
            this.position = position;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getPosition() {
            return position;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        @Override
        public String toString() {
            return "PlayerDto{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", position='" + position + '\'' +
                    '}';
        }
    }
    }
