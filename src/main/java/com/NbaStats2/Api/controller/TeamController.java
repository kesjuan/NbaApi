package com.NbaStats2.Api.controller;


import com.NbaStats2.Api.model.service.MapService;
import com.NbaStats2.Api.model.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TeamController {
    Logger log = LoggerFactory.getLogger(TeamController.class);
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
        log.info("finding team with id " + teamId);
        return teamService.findTeamStatsById(teamId);

    }
    @GetMapping("/teams/stats/search")
    public ResponseEntity<?> searchTeamsForStats(@RequestParam("query") String query){
        return teamService.searchTeamsForStats(query);
    }
}
