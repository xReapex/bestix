package com.example.bestix.infrastructure.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bestix.infrastructure.Entity.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer>{
    

  //  @Query("")
    //List<Match> getAllMatchs(@Param("firstTeamName") String firstTeamName, @Param("secondTeamName") String secondTeamName, @Param("date") String date, @Param("id") int id);
}
