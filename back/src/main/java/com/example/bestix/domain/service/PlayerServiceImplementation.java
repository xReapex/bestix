package com.example.bestix.domain.service;

import com.example.bestix.infrastructure.Entity.FavoritePlayer;
import com.example.bestix.infrastructure.Entity.Player;
import com.example.bestix.infrastructure.Repository.PlayerRepository;
import com.example.bestix.infrastructure.Repository.FavoritesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImplementation implements PlayerService {

    PlayerRepository playerRepository;
    FavoritesRepository favoritesRepository;

    @Autowired
    public PlayerServiceImplementation(PlayerRepository playerRepository, FavoritesRepository favoritesRepository) {

        this.playerRepository = playerRepository;
        this.favoritesRepository = favoritesRepository;
    }

    @Override
    public void addPlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    public List<Player> getAllPlayers() {
        List<Player> playersList = playerRepository.findAll();
        return playersList;
    }

    @Override
    public Optional<Player> getPlayerById(int id) {
        return playerRepository.findById(id);
    }

    @Override
    public void updatePlayerNameById(String newName, int id) {
        playerRepository.setPlayerName(newName, id);
    }

    @Override
    public void deletePlayerById(int id) {
        playerRepository.deleteById(id);
    }

    @Override
    public List<Integer> getFavoritesByUserId(int userId) {
        System.out.println("Service : " + userId);
        return favoritesRepository.getFavoritesByUserId(userId);
    }

    @Override
    public void saveFavoriteByUserId(int playerId, int userId) {
        FavoritePlayer favoritePlayer = new FavoritePlayer();
        favoritePlayer.setPlayerId(playerId);
        favoritePlayer.setUserId(userId);
        favoritesRepository.save(favoritePlayer);
    }

    @Override
    public void deleteFavoriteByIds(int playerId, int userId) {
        favoritesRepository.deleteByIds(playerId, userId);
    }


}
