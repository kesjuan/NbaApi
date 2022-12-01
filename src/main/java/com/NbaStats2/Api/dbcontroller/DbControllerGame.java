package com.NbaStats2.Api.dbcontroller;


import com.NbaStats2.Api.dbservice.DbGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DbControllerGame {

    @Autowired
    private DbGameService dbGameService;

    @PostMapping("/update/games")
    public ResponseEntity<?> saveGamesForMonth(){
        dbGameService.saveGamesForMonth();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
