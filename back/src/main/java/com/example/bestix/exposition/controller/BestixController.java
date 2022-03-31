package com.example.bestix.exposition.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(path = "/api")
public class BestixController {

    List<String> playerList = new ArrayList<String>();

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
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

    @GetMapping("/toto")
    public TotoDTO getToto()
    {
        List<String> ls = new ArrayList<>();
        ls.add("v1");
        ls.add("v2");

        return new TotoDTO("Hello", 1, new Date(), ls);
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
