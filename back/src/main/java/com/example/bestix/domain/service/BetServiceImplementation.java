package com.example.bestix.domain.service;

import com.example.bestix.infrastructure.Entity.BetEntity;
import com.example.bestix.infrastructure.Entity.FavoritePlayer;
import com.example.bestix.infrastructure.Repository.BetsRepository;
import com.example.bestix.infrastructure.Repository.FavoritesRepository;
import com.example.bestix.infrastructure.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class BetServiceImplementation implements BetService {
    BetsRepository betsRepository;

    @Autowired
    public BetServiceImplementation(BetsRepository betsRepository) {
        this.betsRepository = betsRepository;
    }

    @Override
    public List<BetEntity> getBetsByUserId(int userId) {
        System.out.println("Bet Service : " + userId);
        return betsRepository.getBetsByUserId(userId);
    }

    @Override
    public void saveBetsByUserId(int matchId, int equipeId, int userId) {
        BetEntity betEntity = new BetEntity();
        betEntity.setIdUser(userId);
        betEntity.setIdMatch(matchId);
        betEntity.setIdEquipe(equipeId);

        betsRepository.save(betEntity);
    }

    @Override
    public List<Object> getBetsOnMatchesByUserId(int userId) {
        List<Integer> matchesIdList = new ArrayList<>();
        List<Object> matchesInfoList = new ArrayList<>();

        matchesIdList = betsRepository.getMatchesIdByUserId(userId);

        for(int i = 0; i < matchesIdList.size(); i++)
        {
            String url = "http://api.football-data.org/v2/matches/" + matchesIdList.get(i);
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.set("X-Auth-Token", "ea75194eaa4840feae08c118e3e14ec0");
            HttpEntity entity = new HttpEntity(headers);

            matchesInfoList.add(restTemplate.exchange(url, HttpMethod.GET, entity, Object.class).getBody());
        }

        return matchesInfoList;
    }
}
