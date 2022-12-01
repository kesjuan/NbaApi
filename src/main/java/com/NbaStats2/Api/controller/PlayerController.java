package com.NbaStats2.Api.controller;


import com.NbaStats2.Api.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/players")
    public ResponseEntity<?> getAllPlayers(){
        return playerService.findAllPlayers();
    }

    @GetMapping("/players/search")
    public ResponseEntity<?> searchPlayers(@RequestParam("query") String query){
        return playerService.searchPlayers(query);
    }
    @GetMapping("/players/{playerId}")
    public ResponseEntity<?> getPlayerById(@PathVariable Long playerId){
        return playerService.findPlayerById(playerId);
    }

    @GetMapping("/players/stats")
    public ResponseEntity<?> getAllPlayersStats(){
        return playerService.findAllPlayerStats();
    }

    @GetMapping("/players/stats/{playerId}")
    public ResponseEntity<?> getPlayersStatsById(@PathVariable Long playerId){
        return playerService.findPlayerStatsById(playerId);
    }

    @GetMapping("/players/stats/search")
    public ResponseEntity<?> getAllPlayersStats(@RequestParam("query") String query){
        return playerService.searchPlayersAndGetStats(query);
    }


}
