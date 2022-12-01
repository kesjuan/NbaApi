package com.NbaStats2.Api.service;


import com.NbaStats2.Api.dto.PlayerDto;
import com.NbaStats2.Api.dto.PlayerDto1;
import com.NbaStats2.Api.dto.TeamDto;
import com.NbaStats2.Api.dto.TeamDto1;
import com.NbaStats2.Api.model.Player;
import com.NbaStats2.Api.model.Team;
import com.NbaStats2.Api.repository.PlayerRepository;
import com.NbaStats2.Api.repository.StatsRepository;
import com.NbaStats2.Api.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MapService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private StatsRepository statsRepository;

    public List<TeamDto> getAllTeams(){
        return ((List<Team>) teamRepository
                .findAll())
                .stream()
                .map(this::convertToTeamDto)
                .collect(Collectors.toList());
    }
    public List<TeamDto> searchTeams(String searchParam){
      return ((List<Team>) teamRepository.findTeamByNameSearch(searchParam))
              .stream()
              .map(this::convertToTeamDto)
              .collect(Collectors.toList());
    }
    public TeamDto findTeamById(Long teamId){
       return convertToTeamDto(teamRepository.findById(teamId).get());
    }


    private TeamDto convertToTeamDto(Team team){
        TeamDto teamDto = new TeamDto();
        teamDto.setId(team.getId());
        teamDto.setAbbreviation(team.getAbbreviation());
        teamDto.setConference(team.getConference());
        teamDto.setDivision(team.getDivision());
        teamDto.setFull_name(team.getFull_name());
        teamDto.setPlayers(addAllPlayersToTheirTeams(team));
        return teamDto;
    }


    public List<PlayerDto> searchPlayers(String searchParam){
        return ((List<Player>) playerRepository.findPlayerByNameSearch(searchParam))
                .stream()
                .map(this::convertToPlayerDto)
                .collect(Collectors.toList());
    }

    public PlayerDto findPlayerById(Long playerId){
        return convertToPlayerDto(playerRepository.findById(playerId).get());
    }

    public List<PlayerDto> getAllPlayers(){
        return ((List<Player>) playerRepository
                .findAll())
                .stream()
                .map(this::convertToPlayerDto)
                .collect(Collectors.toList());
    }


    private PlayerDto convertToPlayerDto(Player player){
        PlayerDto playerDto = new PlayerDto();
        playerDto.setId(player.getId());
        playerDto.setName(player.getName());
        playerDto.setPosition(player.getPosition());
        playerDto.setTeamAbbreviation(player.getTeam().getAbbreviation());
        playerDto.setTeamFull_name(player.getTeam().getFull_name());

        return playerDto;
    }

    public PlayerDto1 findPlayerStatsById(Long playerId){
        return convertToPlayerDto1(playerRepository.findById(playerId).get());
    }

    public List<PlayerDto1> searchPlayersForStats(String searchParam){
        return ((List<Player>) playerRepository.findPlayerByNameSearch(searchParam))
                .stream()
                .map(this::convertToPlayerDto1)
                .collect(Collectors.toList());
    }

    public List<PlayerDto1> getAllPlayersDto1(){
        return ((List<Player>) playerRepository
                .findAll())
                .stream()
                .map(this::convertToPlayerDto1)
                .collect(Collectors.toList());
    }
    private PlayerDto1 convertToPlayerDto1(Player player){
        PlayerDto1 playerDto1 = new PlayerDto1();
        playerDto1.setName(player.getName());
        playerDto1.setPosition(player.getPosition());
        PlayerDto1.TeamDto1 teamDto1 = new PlayerDto1.TeamDto1();
        teamDto1.setFull_name(player.getTeam().getFull_name());
        playerDto1.setTeam(teamDto1);
        PlayerDto1.StatsDto statsDto = new PlayerDto1.StatsDto();
        statsDto.setAvg2Pt(player.getStats().getAvg2Pt());
        statsDto.setAvg2PtAttempts(player.getStats().getAvg2PtAttempts());
        statsDto.setAvg2PtPercentage(player.getStats().getAvg2PtPercentage());
        statsDto.setAvg3Pt(player.getStats().getAvg3Pt());
        statsDto.setAvg3PtAttempts(player.getStats().getAvg3PtAttempts());
        statsDto.setAvg3PtPercentage(player.getStats().getAvg3PtPercentage());
        statsDto.setAvgAssists(player.getStats().getAvgAssists());
        statsDto.setAvgBlocks(player.getStats().getAvgBlocks());
        statsDto.setAvgFieldGoals(player.getStats().getAvgFieldGoals());
        statsDto.setAvgFgsAttempts(player.getStats().getAvgFgsAttempts());
        statsDto.setAvgFgPercent(player.getStats().getAvgFgPercent());
        statsDto.setAvgDefensiveReb(player.getStats().getAvgDefensiveReb());
        statsDto.setAvgOffensiveReb(player.getStats().getAvgOffensiveReb());
        statsDto.setAvgTotalReb(player.getStats().getAvgTotalReb());
        statsDto.setAvgFreeThrows(player.getStats().getAvgFreeThrows());
        statsDto.setAvgFtAttempts(player.getStats().getAvgFtAttempts());
        statsDto.setAvgFtPercentage(player.getStats().getAvgFtPercentage());
        statsDto.setAvgPoints(player.getStats().getAvgPoints());
        statsDto.setAvgSteals(player.getStats().getAvgSteals());
        statsDto.setAvgTurnovers(player.getStats().getAvgTurnovers());
        playerDto1.setStats(statsDto);
        return playerDto1;
    }
    private TeamDto1 convertToTeamDtoForStats(Team team){
        TeamDto1 teamDto = new TeamDto1();
        teamDto.setAbbreviation(team.getAbbreviation());
        teamDto.setConference(team.getConference());
        teamDto.setFull_name(team.getFull_name());
        teamDto.setPlayers(addAllPlayersToTheirTeamsForStats(team));
        return teamDto;
    }

    public List<TeamDto1> getAllTeamsForStats(){
        return ((List<Team>) teamRepository
                .findAll())
                .stream()
                .map(this::convertToTeamDtoForStats)
                .collect(Collectors.toList());
    }

    public List<TeamDto1> searchTeamsForStats(String searchParam){
        return ((List<Team>) teamRepository.findTeamByNameSearch(searchParam))
                .stream()
                .map(this::convertToTeamDtoForStats)
                .collect(Collectors.toList());
    }
    public TeamDto1 findTeamStatsById(Long teamId){
        return convertToTeamDtoForStats(teamRepository.findById(teamId).get());
    }


    public Set<TeamDto.PlayerDto> addAllPlayersToTheirTeams(Team team){
        Set<TeamDto.PlayerDto> teamsPlayers = new HashSet<>();
       // Iterable<Team> teams = teamRepository.findAll();
        Iterable<Player> players = playerRepository.findAll();
       // for (Team team: teams){
            for (Player player: players){
                if (player.getTeam().getId().equals(team.getId()) ){
                    TeamDto.PlayerDto playerDto = new TeamDto.PlayerDto();
                    playerDto.setId(player.getId());
                    playerDto.setName(player.getName());
                    playerDto.setPosition(player.getPosition());
                    teamsPlayers.add(playerDto);
                  //  team.setPlayers(teamsPlayers);
                }

            }
        //}
        return teamsPlayers;
    }
    public Set<PlayerDto1> addAllPlayersToTheirTeamsForStats(Team team){
        Set<PlayerDto1> teamsPlayers = new HashSet<>();
        // Iterable<Team> teams = teamRepository.findAll();
        Iterable<Player> players = playerRepository.findAll();
        // for (Team team: teams){
        for (Player player: players){
            if (player.getTeam().getId().equals(team.getId()) ){
                PlayerDto1 playerDto1 =convertToPlayerDto1ForStats(player);
//               PlayerDto1 playerDto1 = new PlayerDto1();
//                playerDto1.setName(player.getName());
//                playerDto1.setPosition(player.getPosition());
                teamsPlayers.add(playerDto1);
                //  team.setPlayers(teamsPlayers);
            }

        }
        //}
        return teamsPlayers;
    }
    private PlayerDto1 convertToPlayerDto1ForStats(Player player){
        PlayerDto1 playerDto1 = new PlayerDto1();
        playerDto1.setName(player.getName());
        playerDto1.setPosition(player.getPosition());
        PlayerDto1.TeamDto1 teamDto1 = new PlayerDto1.TeamDto1();
        teamDto1.setFull_name(player.getTeam().getFull_name());
        playerDto1.setTeam(teamDto1);
        PlayerDto1.StatsDto statsDto = new PlayerDto1.StatsDto();
        statsDto.setAvg2Pt(player.getStats().getAvg2Pt());
        statsDto.setAvg2PtAttempts(player.getStats().getAvg2PtAttempts());
        statsDto.setAvg2PtPercentage(player.getStats().getAvg2PtPercentage());
        statsDto.setAvg3Pt(player.getStats().getAvg3Pt());
        statsDto.setAvg3PtAttempts(player.getStats().getAvg3PtAttempts());
        statsDto.setAvg3PtPercentage(player.getStats().getAvg3PtPercentage());
        statsDto.setAvgAssists(player.getStats().getAvgAssists());
        statsDto.setAvgBlocks(player.getStats().getAvgBlocks());
        statsDto.setAvgFieldGoals(player.getStats().getAvgFieldGoals());
        statsDto.setAvgFgsAttempts(player.getStats().getAvgFgsAttempts());
        statsDto.setAvgFgPercent(player.getStats().getAvgFgPercent());
        statsDto.setAvgDefensiveReb(player.getStats().getAvgDefensiveReb());
        statsDto.setAvgOffensiveReb(player.getStats().getAvgOffensiveReb());
        statsDto.setAvgTotalReb(player.getStats().getAvgTotalReb());
        statsDto.setAvgFreeThrows(player.getStats().getAvgFreeThrows());
        statsDto.setAvgFtAttempts(player.getStats().getAvgFtAttempts());
        statsDto.setAvgFtPercentage(player.getStats().getAvgFtPercentage());
        statsDto.setAvgPoints(player.getStats().getAvgPoints());
        statsDto.setAvgSteals(player.getStats().getAvgSteals());
        statsDto.setAvgTurnovers(player.getStats().getAvgTurnovers());
        playerDto1.setStats(statsDto);
        return playerDto1;
    }

}
