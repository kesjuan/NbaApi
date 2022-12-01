package com.NbaStats2.Api.dto;


public class PlayerDto1  {
    private String name;
    private String position;
    private TeamDto1 team;
    private StatsDto stats;

    public String getName() {
        return name;
    }

    public PlayerDto1 setName(String name) {
        this.name = name;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public PlayerDto1 setPosition(String position) {
        this.position = position;
        return this;
    }

    public TeamDto1 getTeam() {
        return team;
    }

    public PlayerDto1 setTeam(TeamDto1 team) {
        this.team = team;
        return this;
    }

    public StatsDto getStats() {
        return stats;
    }

    public PlayerDto1 setStats(StatsDto stats) {
        this.stats = stats;
        return this;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "name = " + name + ", " +
                "position = " + position + ", " +
                "team = " + team + ", " +
                "stats = " + stats + ")";
    }


    public static class TeamDto1  {
        private String full_name;

        public String getFull_name() {
            return full_name;
        }

        public TeamDto1 setFull_name(String full_name) {
            this.full_name = full_name;
            return this;
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "full_name = " + full_name + ")";
        }
    }


    public static class StatsDto  {
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

        public String getAvgFieldGoals() {
            return avgFieldGoals;
        }

        public StatsDto setAvgFieldGoals(String avgFieldGoals) {
            this.avgFieldGoals = avgFieldGoals;
            return this;
        }

        public String getAvgFgsAttempts() {
            return avgFgsAttempts;
        }

        public StatsDto setAvgFgsAttempts(String avgFgsAttempts) {
            this.avgFgsAttempts = avgFgsAttempts;
            return this;
        }

        public String getAvgFgPercent() {
            return avgFgPercent;
        }

        public StatsDto setAvgFgPercent(String avgFgPercent) {
            this.avgFgPercent = avgFgPercent;
            return this;
        }

        public String getAvg3Pt() {
            return avg3Pt;
        }

        public StatsDto setAvg3Pt(String avg3Pt) {
            this.avg3Pt = avg3Pt;
            return this;
        }

        public String getAvg3PtAttempts() {
            return avg3PtAttempts;
        }

        public StatsDto setAvg3PtAttempts(String avg3PtAttempts) {
            this.avg3PtAttempts = avg3PtAttempts;
            return this;
        }

        public String getAvg3PtPercentage() {
            return avg3PtPercentage;
        }

        public StatsDto setAvg3PtPercentage(String avg3PtPercentage) {
            this.avg3PtPercentage = avg3PtPercentage;
            return this;
        }

        public String getAvg2Pt() {
            return avg2Pt;
        }

        public StatsDto setAvg2Pt(String avg2Pt) {
            this.avg2Pt = avg2Pt;
            return this;
        }

        public String getAvg2PtAttempts() {
            return avg2PtAttempts;
        }

        public StatsDto setAvg2PtAttempts(String avg2PtAttempts) {
            this.avg2PtAttempts = avg2PtAttempts;
            return this;
        }

        public String getAvg2PtPercentage() {
            return avg2PtPercentage;
        }

        public StatsDto setAvg2PtPercentage(String avg2PtPercentage) {
            this.avg2PtPercentage = avg2PtPercentage;
            return this;
        }

        public String getAvgFreeThrows() {
            return avgFreeThrows;
        }

        public StatsDto setAvgFreeThrows(String avgFreeThrows) {
            this.avgFreeThrows = avgFreeThrows;
            return this;
        }

        public String getAvgFtAttempts() {
            return avgFtAttempts;
        }

        public StatsDto setAvgFtAttempts(String avgFtAttempts) {
            this.avgFtAttempts = avgFtAttempts;
            return this;
        }

        public String getAvgFtPercentage() {
            return avgFtPercentage;
        }

        public StatsDto setAvgFtPercentage(String avgFtPercentage) {
            this.avgFtPercentage = avgFtPercentage;
            return this;
        }

        public String getAvgOffensiveReb() {
            return avgOffensiveReb;
        }

        public StatsDto setAvgOffensiveReb(String avgOffensiveReb) {
            this.avgOffensiveReb = avgOffensiveReb;
            return this;
        }

        public String getAvgDefensiveReb() {
            return avgDefensiveReb;
        }

        public StatsDto setAvgDefensiveReb(String avgDefensiveReb) {
            this.avgDefensiveReb = avgDefensiveReb;
            return this;
        }

        public String getAvgTotalReb() {
            return avgTotalReb;
        }

        public StatsDto setAvgTotalReb(String avgTotalReb) {
            this.avgTotalReb = avgTotalReb;
            return this;
        }

        public String getAvgAssists() {
            return avgAssists;
        }

        public StatsDto setAvgAssists(String avgAssists) {
            this.avgAssists = avgAssists;
            return this;
        }

        public String getAvgSteals() {
            return avgSteals;
        }

        public StatsDto setAvgSteals(String avgSteals) {
            this.avgSteals = avgSteals;
            return this;
        }

        public String getAvgBlocks() {
            return avgBlocks;
        }

        public StatsDto setAvgBlocks(String avgBlocks) {
            this.avgBlocks = avgBlocks;
            return this;
        }

        public String getAvgTurnovers() {
            return avgTurnovers;
        }

        public StatsDto setAvgTurnovers(String avgTurnovers) {
            this.avgTurnovers = avgTurnovers;
            return this;
        }

        public String getAvgPoints() {
            return avgPoints;
        }

        public StatsDto setAvgPoints(String avgPoints) {
            this.avgPoints = avgPoints;
            return this;
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "avgFieldGoals = " + avgFieldGoals + ", " +
                    "avgFgsAttempts = " + avgFgsAttempts + ", " +
                    "avgFgPercent = " + avgFgPercent + ", " +
                    "avg3Pt = " + avg3Pt + ", " +
                    "avg3PtAttempts = " + avg3PtAttempts + ", " +
                    "avg3PtPercentage = " + avg3PtPercentage + ", " +
                    "avg2Pt = " + avg2Pt + ", " +
                    "avg2PtAttempts = " + avg2PtAttempts + ", " +
                    "avg2PtPercentage = " + avg2PtPercentage + ", " +
                    "avgFreeThrows = " + avgFreeThrows + ", " +
                    "avgFtAttempts = " + avgFtAttempts + ", " +
                    "avgFtPercentage = " + avgFtPercentage + ", " +
                    "avgOffensiveReb = " + avgOffensiveReb + ", " +
                    "avgDefensiveReb = " + avgDefensiveReb + ", " +
                    "avgTotalReb = " + avgTotalReb + ", " +
                    "avgAssists = " + avgAssists + ", " +
                    "avgSteals = " + avgSteals + ", " +
                    "avgBlocks = " + avgBlocks + ", " +
                    "avgTurnovers = " + avgTurnovers + ", " +
                    "avgPoints = " + avgPoints + ")";
        }
    }
}