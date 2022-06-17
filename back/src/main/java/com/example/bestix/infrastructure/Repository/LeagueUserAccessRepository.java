package com.example.bestix.infrastructure.Repository;

import com.example.bestix.infrastructure.Entity.LeagueEntity;
import com.example.bestix.infrastructure.Entity.LeagueUserAccessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeagueUserAccessRepository extends JpaRepository<LeagueUserAccessEntity, Integer> {
}