package com.NbaStats2.Api.service;


import com.NbaStats2.Api.model.Player;
import com.NbaStats2.Api.model.Team;
import com.NbaStats2.Api.repository.PlayerRepository;
import com.NbaStats2.Api.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private MapService mapService;

    public ResponseEntity<?> findAllTeams(){
      //  addAllPlayersToTheirTeams();

        return new ResponseEntity<>(mapService.getAllTeams(), HttpStatus.OK);
    }

    public ResponseEntity<?> findTeamByName(String searchParam){
        return new ResponseEntity<>(mapService.searchTeams(searchParam), HttpStatus.OK);
    }
    public ResponseEntity<?> findTeamById(Long teamId){
        return new ResponseEntity<>(mapService.findTeamById(teamId),HttpStatus.OK);
    }

    public ResponseEntity<?> findAllTeamsStats(){
        return new ResponseEntity<>(mapService.getAllTeamsForStats(), HttpStatus.OK);
    }

    public ResponseEntity<?> findTeamStatsById( Long teamId){
        return new ResponseEntity<>(mapService.findTeamStatsById(teamId),HttpStatus.OK);
    }

    public ResponseEntity<?> searchTeamsForStats(String query){
        return new ResponseEntity<>(mapService.searchTeamsForStats(query),HttpStatus.OK);
    }


    public void addAllPlayersToTheirTeams(){
        Set<Player> teamsPlayers = new HashSet<>();
        Iterable<Team> teams = teamRepository.findAll();
        Iterable<Player> players = playerRepository.findAll();
        for (Team team: teams){
            for (Player player: players){
                if (player.getTeam().getId().equals(team.getId()) ){
                    teamsPlayers.add(player);
                    team.setPlayers(teamsPlayers);
                }

            }
        }
    }
}
