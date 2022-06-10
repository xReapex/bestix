package com.example.bestix.domain.service;

import com.example.bestix.infrastructure.Entity.LeagueEntity;
import com.example.bestix.infrastructure.Entity.LeagueUserAccessEntity;
import com.example.bestix.infrastructure.Entity.UserEntity;
import com.example.bestix.infrastructure.Repository.LeagueRepository;
import com.example.bestix.infrastructure.Repository.LeagueUserAccessRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueServiceImplementation implements LeagueService {

    LeagueRepository leagueRepository;
    LeagueUserAccessRepository leagueUserAccessRepository;

    public LeagueServiceImplementation(LeagueRepository leagueRepository, LeagueUserAccessRepository leagueUserAccessRepository)
    {
        this.leagueRepository = leagueRepository;
        this.leagueUserAccessRepository = leagueUserAccessRepository;
    }

    @Override
    public void createLeague(String leagueName, int nbPlayers, int champ, String password) {
        LeagueEntity leagueEntity = new LeagueEntity();
        leagueEntity.setName(leagueName);
        leagueEntity.setNbPlayers(nbPlayers);
        leagueEntity.setId_champ(champ);
        leagueEntity.setPassword(password);

        leagueRepository.save(leagueEntity);
    }

    @Override
    public List<LeagueEntity> getLeaguesList() {
        return leagueRepository.getLeaguesList();
    }

    @Override
    public boolean requestLeagueAccess(int leagueId, String requestPassword) {
        String bddPassword = leagueRepository.requestLeagueAccess(leagueId);
        System.out.println("Password : " + requestPassword + " bddPassword = " + bddPassword);

        if(requestPassword.equals(bddPassword)) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public List<Integer> checkJoinedLeaguesByUserId(int userId) {
        return leagueRepository.checkJoinedLeaguesByUserId(userId);
    }

    @Override
    public void grantLeagueAccessToUser(int leagueId, int userId) {
        LeagueUserAccessEntity userAccess = new LeagueUserAccessEntity();
        userAccess.setLeagueId(leagueId);
        userAccess.setUserId(userId);
        leagueUserAccessRepository.save(userAccess);
    }

    @Override
    public List<Integer> getLeaguesUserList(int leagueId) {
        return leagueRepository.getLeaguesUserList(leagueId);
    }
}
