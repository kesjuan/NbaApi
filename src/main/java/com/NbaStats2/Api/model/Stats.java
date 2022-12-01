package com.NbaStats2.Api.model;

import javax.persistence.*;

@Entity
public class Stats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stats_id", nullable = false)
    private Long id;

    @OneToOne(mappedBy = "stats")
    //@JoinColumn(name = "player_id")
    private Player player;

    //fielgoals , fieldgoalsattempted, fg percentage, 3p made, 3p attempted, 3p percentage,
    // 2p made, 2p attempted, 2p percentage, effective fg percentage, freethrows made, ft attempted, ft percentage,
    //offensive rebounds, Defensive rebounds, total rebounds, assists, steals, blocks, turnovers, pts

    private String avgFieldGoals;

    private String avgFgsAttempts;

    private String avgFgPercent;

    private String avg3Pt;

    private String avg3PtAttempts;

    private String avg3PtPercentage;

    private String avg2Pt;

    private String avg2PtAttempts;

    private String avg2PtPercentage;


    private String avgFreeThrows;

    private String avgFtAttempts;

    private String avgFtPercentage;

    private String avgOffensiveReb;

    private String avgDefensiveReb;

    private String avgTotalReb;

    private String avgAssists;

    private String avgSteals;

    private String avgBlocks;

    private String avgTurnovers;

    private String avgPoints;

    public Stats() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getAvgFieldGoals() {
        return avgFieldGoals;
    }

    public void setAvgFieldGoals(String avgFieldGoals) {
        this.avgFieldGoals = avgFieldGoals;
    }

    public String getAvgFgsAttempts() {
        return avgFgsAttempts;
    }

    public void setAvgFgsAttempts(String avgFgsAttempts) {
        this.avgFgsAttempts = avgFgsAttempts;
    }

    public String getAvgFgPercent() {
        return avgFgPercent;
    }

    public void setAvgFgPercent(String avgFgPercent) {
        this.avgFgPercent = avgFgPercent;
    }

    public String getAvg3Pt() {
        return avg3Pt;
    }

    public void setAvg3Pt(String avg3Pt) {
        this.avg3Pt = avg3Pt;
    }

    public String getAvg3PtAttempts() {
        return avg3PtAttempts;
    }

    public void setAvg3PtAttempts(String avg3PtAttempts) {
        this.avg3PtAttempts = avg3PtAttempts;
    }

    public String getAvg3PtPercentage() {
        return avg3PtPercentage;
    }

    public void setAvg3PtPercentage(String avg3PtPercentage) {
        this.avg3PtPercentage = avg3PtPercentage;
    }

    public String getAvg2Pt() {
        return avg2Pt;
    }

    public void setAvg2Pt(String avg2Pt) {
        this.avg2Pt = avg2Pt;
    }

    public String getAvg2PtAttempts() {
        return avg2PtAttempts;
    }

    public void setAvg2PtAttempts(String avg2PtAttempts) {
        this.avg2PtAttempts = avg2PtAttempts;
    }

    public String getAvg2PtPercentage() {
        return avg2PtPercentage;
    }

    public void setAvg2PtPercentage(String avg2PtPercentage) {
        this.avg2PtPercentage = avg2PtPercentage;
    }


    public String getAvgFreeThrows() {
        return avgFreeThrows;
    }

    public void setAvgFreeThrows(String avgFreeThrows) {
        this.avgFreeThrows = avgFreeThrows;
    }

    public String getAvgFtAttempts() {
        return avgFtAttempts;
    }

    public void setAvgFtAttempts(String avgFtAttempts) {
        this.avgFtAttempts = avgFtAttempts;
    }

    public String getAvgFtPercentage() {
        return avgFtPercentage;
    }

    public void setAvgFtPercentage(String avgFtPercentage) {
        this.avgFtPercentage = avgFtPercentage;
    }

    public String getAvgOffensiveReb() {
        return avgOffensiveReb;
    }

    public void setAvgOffensiveReb(String avgOffensiveReb) {
        this.avgOffensiveReb = avgOffensiveReb;
    }

    public String getAvgDefensiveReb() {
        return avgDefensiveReb;
    }

    public void setAvgDefensiveReb(String avgDefensiveReb) {
        this.avgDefensiveReb = avgDefensiveReb;
    }

    public String getAvgTotalReb() {
        return avgTotalReb;
    }

    public void setAvgTotalReb(String avgTotalReb) {
        this.avgTotalReb = avgTotalReb;
    }

    public String getAvgAssists() {
        return avgAssists;
    }

    public void setAvgAssists(String avgAssists) {
        this.avgAssists = avgAssists;
    }

    public String getAvgSteals() {
        return avgSteals;
    }

    public void setAvgSteals(String avgSteals) {
        this.avgSteals = avgSteals;
    }

    public String getAvgBlocks() {
        return avgBlocks;
    }

    public void setAvgBlocks(String avgBlocks) {
        this.avgBlocks = avgBlocks;
    }

    public String getAvgTurnovers() {
        return avgTurnovers;
    }

    public void setAvgTurnovers(String avgTurnovers) {
        this.avgTurnovers = avgTurnovers;
    }

    public String getAvgPoints() {
        return avgPoints;
    }

    public void setAvgPoints(String avgPoints) {
        this.avgPoints = avgPoints;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "id=" + id +
                ", player=" + player +
                ", avgFieldGoals='" + avgFieldGoals + '\'' +
                ", avgFgsAttempts='" + avgFgsAttempts + '\'' +
                ", avgFgPercent='" + avgFgPercent + '\'' +
                ", avg3Pt='" + avg3Pt + '\'' +
                ", avg3PtAttempts='" + avg3PtAttempts + '\'' +
                ", avg3PtPercentage='" + avg3PtPercentage + '\'' +
                ", avg2Pt='" + avg2Pt + '\'' +
                ", avg2PtAttempts='" + avg2PtAttempts + '\'' +
                ", avg2PtPercentage='" + avg2PtPercentage + '\'' +
                ", avgFreeThrows='" + avgFreeThrows + '\'' +
                ", avgFtAttempts='" + avgFtAttempts + '\'' +
                ", avgFtPercentage='" + avgFtPercentage + '\'' +
                ", avgOffensiveReb='" + avgOffensiveReb + '\'' +
                ", avgDefensiveReb='" + avgDefensiveReb + '\'' +
                ", avgTotalReb='" + avgTotalReb + '\'' +
                ", avgAssists='" + avgAssists + '\'' +
                ", avgSteals='" + avgSteals + '\'' +
                ", avgBlocks='" + avgBlocks + '\'' +
                ", avgTurnovers='" + avgTurnovers + '\'' +
                ", avgPoints='" + avgPoints + '\'' +
                '}';
    }
}
