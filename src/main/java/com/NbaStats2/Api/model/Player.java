package com.NbaStats2.Api.model;

import javax.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id", nullable = false)
    private Long id;

   private String name;

    private String position;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
   // @Column(name = "team_id")
    private Team team;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stats_id")
    private Stats stats;

    public Player() {
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", team=" + team +
                '}';
    }

}
