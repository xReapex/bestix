package com.example.bestix.domain.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.bestix.infrastructure.Entity.Match;
import com.example.bestix.infrastructure.Repository.MatchRepository;

@Service
public class matchServiceImplementation implements matchService {

    MatchRepository matchRepository;

    public matchServiceImplementation(MatchRepository matchRepository)
    {
        this.matchRepository = matchRepository;
    }

    @Override
    public List<Match> getAllMatchs() {

        List<Match> matchList = matchRepository.getAllMatchs();
        System.out.println("Retour: " + matchList);
        return matchList;
    }
    
}
