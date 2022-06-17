package com.example.bestix.domain.service;

import com.example.bestix.infrastructure.Entity.LeagueEntity;
import com.example.bestix.infrastructure.Entity.UserEntity;

import java.util.List;

public interface LeagueService {
    void createLeague(String leagueName, int nbPlayers, int champ, String password);
    List<LeagueEntity> getLeaguesList();
    boolean requestLeagueAccess(int leagueId, String password);
    List<Integer> checkJoinedLeaguesByUserId(int userId);
    void grantLeagueAccessToUser(int leagueId, int userId);
    List<Integer> getLeaguesUserList(int leagueId);
}
