package com.NbaStats2.Api.repository;

import com.NbaStats2.Api.model.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

    // find id by player name
    @Query(value = "select player_id from player where player.name = ?1", nativeQuery = true)
    public Optional<Long> getPlayerIdFromPlayerName(String playerName);

    @Query(value = "select * from player where player.name like %?1%", nativeQuery = true)
    public Iterable<Player> findPlayerByNameSearch(String player);

}