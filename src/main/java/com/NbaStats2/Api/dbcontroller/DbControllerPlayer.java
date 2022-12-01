package com.NbaStats2.Api.dbcontroller;


import com.NbaStats2.Api.dbservice.DbPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DbControllerPlayer {

    @Autowired
    private DbPlayerService dbPlayerService;

    @PostMapping("/update/player/{playerId}")
    public void insertPlayerIntoDb(@PathVariable Long playerId){

        dbPlayerService.savePlayer(playerId);
    }
    @PostMapping("/update/players")
    public void insertAllPlayers(){

            dbPlayerService.savePlayersToTeams2();

    }

}
