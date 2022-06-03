package com.example.bestix.domain.service;

import com.example.bestix.infrastructure.Entity.LeagueEntity;
import com.example.bestix.infrastructure.Repository.LeagueRepository;
import org.springframework.stereotype.Service;

@Service
public class LeagueServiceImplementation implements LeagueService {

    LeagueRepository leagueRepository;

    public LeagueServiceImplementation(LeagueRepository leagueRepository) { this.leagueRepository = leagueRepository; }

    @Override
    public void createLeague(String leagueName, int nbPlayers, int champ, String password) {
        LeagueEntity leagueEntity = new LeagueEntity();
        leagueEntity.setName(leagueName);
        leagueEntity.setNbPlayers(nbPlayers);
        leagueEntity.setId_champ(champ);
        leagueEntity.setPassword(password);

        leagueRepository.save(leagueEntity);
    }
}
