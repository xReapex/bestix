package com.example.bestix.exposition.controller;

import com.example.bestix.exposition.dto.PlayerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RestController
public class BestixController {

    List<String> playerList = new ArrayList<String>();

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping(value = "/getAllSportsList")
    private String getHelloClient() {
        String uri = "https://www.thesportsdb.com/api/v1/json/2/all_sports.php";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        return result;
    }


    @GetMapping(value = "/players/{id}")
    public String getPlayerById(@PathVariable("id") int id){
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
