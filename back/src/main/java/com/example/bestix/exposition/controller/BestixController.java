package com.example.bestix.exposition.controller;

import com.example.bestix.domain.service.PlayerService;
import com.example.bestix.infrastructure.Entity.FavoritePlayer;
import com.example.bestix.infrastructure.Entity.Player;
import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api")
public class BestixController {

    PlayerService playerService;

    @Autowired
    public BestixController(PlayerService playerService) {
        this.playerService = playerService;
    }


    /*
    Tests calls
     */

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/toto")
    public TotoDTO getToto()
    {
        List<String> ls = new ArrayList<>();
        ls.add("v1");
        ls.add("v2");

        return new TotoDTO("Hello", 1, new Date(), ls);
    }

    @PostMapping("/toto")
    public ResponseEntity<TotoDTO> postBody(@RequestBody TotoDTO toto) {
        TotoDTO newToto = new TotoDTO(toto.message, toto.value, toto.date, toto.stringList);
        return ResponseEntity.ok(newToto);
    }

    public static class TotoDTO
    {
        public String message;
        public int value;
        public Date date;
        public List<String> stringList;


        public TotoDTO(String message, int value, Date date, List<String> stringList) {
            this.message = message;
            this.value = value;
            this.date = date;
            this.stringList = stringList;
        }
    }

    /*Favoris*/
    @GetMapping(value="/Favorites/userId={userId}")
    public List<Integer> getFavoritesByUserId(@PathVariable("userId") int userId){
        System.out.println("Controller : " + userId);
        List<Integer> favoritesList = playerService.getFavoritesByUserId(userId);
        System.out.println("Controller favs : " + favoritesList);
        return favoritesList;
    }

    @PostMapping(value="/Favorites/playerId={playerId}&userId={userId}")
    public ResponseEntity saveFavoriteByUserId(@PathVariable("userId") int userId, @PathVariable("playerId")int playerId){
        playerService.saveFavoriteByUserId(playerId, userId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value="/Favorites/playerId={playerId}&userId={userId}")
    public ResponseEntity deleteFavoriteByUserId(@PathVariable("userId") int userId, @PathVariable("playerId") int playerId){
            playerService.deleteFavoriteByIds(playerId, userId);
            return ResponseEntity.ok().build();
    }

    /*Players*/

    @GetMapping(value = "/getAllSportsList")
    private String getHelloClient() {
        String uri = "https://www.thesportsdb.com/api/v1/json/2/all_sports.php";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        return result;
    }


/*
Players
 */

    @GetMapping("/players/helloPlayer")
    public String helloPlayer() {
        System.out.println("helloPlayer called"); return "Hello World Player";
    }

    @GetMapping("/players/all")
    public List<Player> getPlayers(){
        List<Player> playerList = playerService.getAllPlayers();

        return playerList;
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
