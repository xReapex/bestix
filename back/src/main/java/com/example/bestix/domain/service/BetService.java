package com.example.bestix.domain.service;

import com.example.bestix.infrastructure.Entity.BetEntity;

import java.util.List;

public interface BetService {
    List<BetEntity> getBetsByUserId(int userId);
    void saveBetsByUserId(int matchId, int equipeId, int userId);
}
