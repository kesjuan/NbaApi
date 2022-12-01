package com.NbaStats2.Api.repository;


import com.NbaStats2.Api.model.Stats;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatsRepository extends CrudRepository<Stats, Long> {
}