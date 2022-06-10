package com.example.bestix.infrastructure.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bestix.infrastructure.Entity.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {

  @Query("select m from Match m")
  List<Match> getAllMatchs();

}
