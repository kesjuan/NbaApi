package com.NbaStats2.Api.dbcontroller;


import com.NbaStats2.Api.dbservice.DbStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DbStatController {
    @Autowired
    private DbStatService dbStatService;


    @PostMapping("update/players/stats")
    public ResponseEntity<?> updatePlayers(){
        dbStatService.updateStatsForPlayers();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
