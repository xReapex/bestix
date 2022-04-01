package com.example.bestix.domain.service;

import com.example.bestix.infrastructure.Entity.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {

    void addPlayer(Player player);
    List<Player> getAllPlayers();
    Optional<Player> getPlayerById(int id);
    void updatePlayerNameById(String newName, int id);
    void deletePlayerById(int id);
}
