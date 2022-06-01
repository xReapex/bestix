package com.example.bestix.exposition.controller;

import com.example.bestix.domain.service.BetService;
import com.example.bestix.domain.service.PlayerService;
import com.example.bestix.infrastructure.Entity.BetEntity;
import com.example.bestix.infrastructure.Entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/Favorites")
public class favoritesController {

    PlayerService playerService;

    @Autowired
    public favoritesController(PlayerService playerService) {
        this.playerService = playerService;
    }

    /*Favoris*/
    @GetMapping(value="/userId={userId}")
    public List<Integer> getFavoritesByUserId(@PathVariable("userId") int userId){
        List<Integer> favoritesList = playerService.getFavoritesByUserId(userId);
        return favoritesList;
    }

    @PostMapping(value="/playerId={playerId}&userId={userId}")
    public ResponseEntity saveFavoriteByUserId(@PathVariable("userId") int userId, @PathVariable("playerId")int playerId){
        playerService.saveFavoriteByUserId(playerId, userId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value="/playerId={playerId}&userId={userId}")
    public ResponseEntity deleteFavoriteByUserId(@PathVariable("userId") int userId, @PathVariable("playerId") int playerId){
            playerService.deleteFavoriteByIds(playerId, userId);
            return ResponseEntity.ok().build();
    }

}
