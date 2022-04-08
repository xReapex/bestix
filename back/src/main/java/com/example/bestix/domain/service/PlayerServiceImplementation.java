package com.example.bestix.domain.service;

import com.example.bestix.infrastructure.Entity.Player;
import com.example.bestix.infrastructure.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImplementation implements PlayerService {

    PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImplementation(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
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

}
