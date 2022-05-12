package com.example.bestix.domain.service;

import com.example.bestix.infrastructure.Entity.BetEntity;
import com.example.bestix.infrastructure.Entity.FavoritePlayer;
import com.example.bestix.infrastructure.Repository.BetsRepository;
import com.example.bestix.infrastructure.Repository.FavoritesRepository;
import com.example.bestix.infrastructure.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
