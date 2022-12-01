package com.NbaStats2.Api.dbservice;

import com.NbaStats2.Api.model.Team;
import com.NbaStats2.Api.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DbTeamService {
    @Autowired
    private TeamRepository teamRepository;
Logger log = LoggerFactory.getLogger(DbTeamService.class);
    public void saveTeam(Long teamId){
        String url = "https://balldontlie.io/api/v1/teams/"+ teamId;
        RestTemplate restTemplate = new RestTemplate();
        Team team = restTemplate.getForObject(url, Team.class);
        teamRepository.save(team);
    }
    public void ManualSave(Long teamId, Team team){
        team.setId(teamId);
        teamRepository.save(team);
    }

    public void saveAllTeams(){
        RestTemplate restTemplate = new RestTemplate();
    int numberOfTeams = 31;
        for (int i = 1; i < numberOfTeams ; i++) {
            String url = "https://balldontlie.io/api/v1/teams/" + i;
            Team team = restTemplate.getForObject(url, Team.class);
            log.info(url);
            teamRepository.save(team);
        }
    }

    public ResponseEntity<?> findAllTeams(){
        return new ResponseEntity<>(teamRepository.findAll(), HttpStatus.OK);
    }
}
