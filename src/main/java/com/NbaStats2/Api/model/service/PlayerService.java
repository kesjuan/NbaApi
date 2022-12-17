package com.NbaStats2.Api.model.service;


import com.NbaStats2.Api.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private MapService mapService;

    public ResponseEntity<?> findAllPlayers(){
       return new ResponseEntity<>( mapService.getAllPlayers(), HttpStatus.OK) ;
    }

    public ResponseEntity<?> searchPlayers(String searchParam){
        return new ResponseEntity<>(mapService.searchPlayers(searchParam), HttpStatus.OK);
    }

    public ResponseEntity<?> findPlayerById(Long playerId){
        return new ResponseEntity<>(mapService.findPlayerById(playerId),HttpStatus.OK);
    }

    public ResponseEntity<?> findAllPlayerStats(){
        return new ResponseEntity<>(mapService.getAllPlayersDto1(), HttpStatus.OK);
    }

    public ResponseEntity<?> findPlayerStatsById(Long playerId){
        return new ResponseEntity<>(mapService.findPlayerStatsById(playerId),HttpStatus.OK);
    }
    public ResponseEntity<?> searchPlayersAndGetStats(String searchParam){
        return new ResponseEntity<>(mapService.searchPlayersForStats(searchParam),HttpStatus.OK);
    }
}
