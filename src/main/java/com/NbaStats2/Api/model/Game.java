package com.NbaStats2.Api.model;

import javax.persistence.*;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id", nullable = false)
    private Long id;

    @ManyToOne
    private Team homeTeam;

    private String homeScore;

    @ManyToOne
    private Team visitorTeam;

    private String visitorScore;

    private String startTime;

    private String date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(String homeScore) {
        this.homeScore = homeScore;
    }

    public Team getVisitorTeam() {
        return visitorTeam;
    }

    public void setVisitorTeam(Team visitorTeam) {
        this.visitorTeam = visitorTeam;
    }

    public String getVisitorScore() {
        return visitorScore;
    }

    public void setVisitorScore(String visitorScore) {
        this.visitorScore = visitorScore;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", homeTeam=" + homeTeam +
                ", homeScore='" + homeScore + '\'' +
                ", visitorTeam=" + visitorTeam +
                ", visitorScore='" + visitorScore + '\'' +
                ", startTime='" + startTime + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}