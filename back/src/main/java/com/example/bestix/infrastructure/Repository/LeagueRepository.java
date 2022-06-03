package com.example.bestix.infrastructure.Repository;

import com.example.bestix.infrastructure.Entity.FavoritePlayer;
import com.example.bestix.infrastructure.Entity.LeagueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeagueRepository extends JpaRepository<LeagueEntity, Integer> {

    @Query("select l from LeagueEntity l")
    List<LeagueEntity> getLeaguesList();
}
