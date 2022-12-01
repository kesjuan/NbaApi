package com.NbaStats2.Api.repository;


import com.NbaStats2.Api.model.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {

    @Query(value = "drop table game", nativeQuery = true)
    public void dropGame();
}