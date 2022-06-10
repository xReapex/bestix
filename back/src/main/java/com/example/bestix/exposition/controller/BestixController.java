package com.example.bestix.exposition.controller;

import com.example.bestix.domain.service.BetService;
import com.example.bestix.domain.service.PlayerService;
import com.example.bestix.domain.service.matchService;
import com.example.bestix.domain.service.matchServiceImplementation;
import com.example.bestix.infrastructure.Entity.BetEntity;
import com.example.bestix.infrastructure.Entity.FavoritePlayer;
import com.example.bestix.infrastructure.Entity.Match;
import com.example.bestix.infrastructure.Entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path = "/api")
public class BestixController {

    PlayerService playerService;
    matchService match_Service;

    @Autowired
    public BestixController(PlayerService playerService, matchService match_Service) {
        this.playerService = playerService;
        this.match_Service = match_Service;
    }


/*
Players
 */

    @GetMapping("/players/all")
    public List<Player> getPlayers(){
        List<Player> playerList = playerService.getAllPlayers();

        return playerList;
    }
    
    @GetMapping("/matchs/scheduled")
    public List<Match> getScheduledMatchs(){  
       List<Match> matchs = match_Service.getAllMatchs();
       
       System.out.println(matchs);
       return matchs;
    }

    @GetMapping("/players/{id}")
    public Optional<Player> getPlayerById(@PathVariable("id") int id){
        Optional<Player> player = playerService.getPlayerById(id);
        return player;
    }

    @PostMapping("/players/add")
    public ResponseEntity<Player> postBody(@RequestBody Player player) {
        Player newPlayer = new Player(player.getId(), player.getPlayerName());
        playerService.addPlayer(newPlayer);
        return ResponseEntity.ok(newPlayer);
    }

    @DeleteMapping("/players/{id}")
    public ResponseEntity<Player> deleteById(@PathVariable("id") int id) {
        try {
            playerService.deletePlayerById(id);
            return ResponseEntity.ok().build();
        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //Update player name by id
    @PutMapping("/players/{id}")
    public ResponseEntity<Player> putPlayerName(@PathVariable("id") int id, @RequestBody String name) {
        try{
            playerService.updatePlayerNameById(name, id);
            return ResponseEntity.ok().build();
        }catch (NullPointerException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping(value = "/external/players/{id}")
    public String getPlayerByIdFromApi(@PathVariable("id") int id){
        String url = "https://www.thesportsdb.com/api/v1/json/2/lookupplayer.php?id=" + id;
        RestTemplate restTemplate = new RestTemplate();
        //PlayerDTO player = restTemplate.getForObject(url, PlayerDTO.class);

        /* If you want to return the data as a string */
        String playerResults = restTemplate.getForObject(url, String.class);

        return playerResults;
            /* If you want to return the data as a playerDTO
            return player;
             */
    }


}
