package com.example.bestix.exposition.controller;

import com.example.bestix.domain.service.BetService;
import com.example.bestix.domain.service.PlayerService;
import com.example.bestix.infrastructure.Entity.BetEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/bet")
public class betsController {

    BetService betService;

    @Autowired
    public betsController(BetService betService) {
        this.betService =  betService;
    }

    /* Paris */
    //Récupérer tous les paris effectués pour un user donné
    @GetMapping(value = "/userId={userId}")
    public List<BetEntity> getBetsByUserId(@PathVariable("userId") int userId)
    {
        System.out.println("Bets - UserId : " + userId);
        List<BetEntity> betList = betService.getBetsByUserId(userId);
        System.out.println("Bets list : " + betList);
        return betList;
    }

    //Enregistre un paris pour un user donné
    @PostMapping(value="/matchId={matchId}&teamId={teamId}&userId={userId}")
    public ResponseEntity saveBetByUserId(@PathVariable("matchId")int matchId, @PathVariable("teamId")int teamId, @PathVariable("userId") int userId){
        betService.saveBetsByUserId(matchId, teamId, userId);
        return ResponseEntity.ok().build();
    }

    //Récupérer les infos des matchs sur lesquels un joueur a parié
    @GetMapping(value="/matchs/userId={userId}")
    public List<Object> getDoneMatches(@PathVariable("userId")int userId){
        return betService.getBetsOnMatchesByUserId(userId);
    }

}
