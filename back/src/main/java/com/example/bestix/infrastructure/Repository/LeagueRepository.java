package com.example.bestix.infrastructure.Repository;

import com.example.bestix.infrastructure.Entity.FavoritePlayer;
import com.example.bestix.infrastructure.Entity.LeagueEntity;
import com.example.bestix.infrastructure.Entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeagueRepository extends JpaRepository<LeagueEntity, Integer> {

    @Query("select l from LeagueEntity l")
    List<LeagueEntity> getLeaguesList();

    @Query("select l.password from LeagueEntity l where l.id= :leagueIdentifier")
    String requestLeagueAccess(@Param("leagueIdentifier") int leagueId);

    @Query("select l.leagueId from LeagueUserAccessEntity l where l.userId= :userIdentifier")
    List<Integer> checkJoinedLeaguesByUserId(@Param("userIdentifier") int userId);

    @Query("select l.userId from LeagueUserAccessEntity l where l.leagueId= :leagueIdentifier")
    List<Integer> getLeaguesUserList(@Param("leagueIdentifier") int leagueId);
}
