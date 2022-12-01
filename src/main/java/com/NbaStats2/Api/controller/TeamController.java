package com.NbaStats2.Api.controller;


import com.NbaStats2.Api.service.MapService;
import com.NbaStats2.Api.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {
    @Autowired
    private TeamService teamService;

    @Autowired
    private MapService mapService;

    @GetMapping("/teams")
    public ResponseEntity<?> getAllTeams(){
           return teamService.findAllTeams();
    }

    @GetMapping("/teams/search")
    public ResponseEntity<?> getTeamsWithSearch(@RequestParam("query") String query){
        return teamService.findTeamByName(query);
    }
    @GetMapping("/teams/{teamId}")
    public ResponseEntity<?> getTeamById(@PathVariable Long teamId){
        return teamService.findTeamById(teamId);
    }
    @GetMapping("/teams/stats")
    public ResponseEntity<?> getAllTeamsStats(){
        return teamService.findAllTeamsStats();
    }
    @GetMapping("/teams/stats/{teamId}")
    public ResponseEntity<?> getTeamStatsById(@PathVariable Long teamId){
        return teamService.findTeamStatsById(teamId);
    }
    @GetMapping("/teams/stats/search")
    public ResponseEntity<?> searchTeamsForStats(@RequestParam("query") String query){
        return teamService.searchTeamsForStats(query);
    }
}
