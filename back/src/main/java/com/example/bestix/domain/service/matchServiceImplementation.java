package com.example.bestix.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class matchServiceImplementation implements matchService {

    @Override
    public String getAllMatchs() {
        String url = "http://api.football-data.org/v2/competitions/FL1/matches?status=SCHEDULED";
        RestTemplate restTemplate = new RestTemplate();

        String matchLists = restTemplate.getForObject(url, String.class);
        System.out.println(matchLists);
        return matchLists;
    }
    
}
