package com.example.bestix.exposition.controller;

import com.example.bestix.domain.service.BetService;
import com.example.bestix.domain.service.LeagueService;
import com.example.bestix.infrastructure.Entity.LeagueEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/league")
public class LeagueController {

    LeagueService leagueService;

    @Autowired
    public LeagueController(LeagueService leagueService) {
        this.leagueService =  leagueService;
    }

    //Enregistre une ligue
    @PostMapping(value="/name={leagueName}&nbPlayers={nbPlayers}&championnat={champ}&password={password}")
    public ResponseEntity createLeague(@PathVariable("leagueName") String leagueName, @PathVariable("nbPlayers") int nbPlayers, @PathVariable("champ") int champ, @PathVariable("password") String password){
        //BY DEFAULT, FOR TEST
        champ = 0;
        leagueService.createLeague(leagueName, nbPlayers, champ, password);
        return ResponseEntity.ok().build();
    }

    //Retourne la liste des ligues crées
    @GetMapping(value = "/list")
    public List<LeagueEntity> getLeaguesList()
    {
        List<LeagueEntity> leagueList = leagueService.getLeaguesList();
        return leagueList;
    }
}
