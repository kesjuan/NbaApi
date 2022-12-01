package com.NbaStats2.Api.dbcontroller;


import com.NbaStats2.Api.dbservice.DbTeamService;
import com.NbaStats2.Api.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DbControllerTeam {
    @Autowired
    private DbTeamService dbTeamService;

    @PostMapping("/update/team/{teamId}")
    public void insertTeamIntoDb(@PathVariable Long teamId){
        dbTeamService.saveTeam(teamId);
    }
    @PostMapping("/update/allTeams")
    public void insertAllTeamsIntoDB(){
        dbTeamService.saveAllTeams();
    }
    @PutMapping("/manupdate/team/{teamId}")
    public ResponseEntity<?> manuallyUpdateTeam(@PathVariable Long teamId, @RequestBody Team team){
        dbTeamService.ManualSave(teamId,team);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//    @GetMapping("/teams")
//    public ResponseEntity<?> getAllTeams(){
//       return dbTeamService.findAllTeams();
//    }
}
