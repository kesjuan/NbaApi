package com.NbaStats2.Api.repository;


import com.NbaStats2.Api.model.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
    @Query(value = "select * from team where team.abbreviation = ?1",nativeQuery = true)
    public Optional<Team> findTeamWithAbbreviation(String abbreviation);

    @Query(value = "select * from team where team.full_name like %?1%", nativeQuery = true)
    public Optional<Team> findTeamByName(String teamName);

    @Query(value = "select * from team where team.full_name like %?1%", nativeQuery = true)
    public Iterable<Team> findTeamByNameSearch(String teamName);

}