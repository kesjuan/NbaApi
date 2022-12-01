package com.NbaStats2.Api.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Team {
    @Id
    @Column(name = "team_id", nullable = false)
    private Long id;

    private String abbreviation;

    private String division;

    private String conference;

    private String full_name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
    private Set<Player> players;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
//    private List<Player> players;

    //team has one to many players... need set of players

    public Team() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
    public void addPlayers(Player player){
        players.add(player);
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", abbreviation='" + abbreviation + '\'' +
                ", division='" + division + '\'' +
                ", conference='" + conference + '\'' +
                ", full_name='" + full_name + '\'' +
                '}';
    }
}
