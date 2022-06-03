package com.example.bestix.domain.service;

import com.example.bestix.infrastructure.Entity.LeagueEntity;

import java.util.List;

public interface LeagueService {
    void createLeague(String leagueName, int nbPlayers, int champ, String password);
    List<LeagueEntity> getLeaguesList();
}
