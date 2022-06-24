package com.example.bestix.exposition.controller;

import com.example.bestix.domain.service.BetService;
import com.example.bestix.domain.service.PlayerService;
import com.example.bestix.domain.service.matchService;
import com.example.bestix.infrastructure.Entity.BetEntity;
import com.example.bestix.infrastructure.Entity.BetResult;
import com.example.bestix.infrastructure.Entity.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/bet")
public class betsController {

    BetService betService;
    matchService MatchService;

    @Autowired
    public betsController(BetService betService, matchService MatchService) {

        this.betService =  betService;
        this.MatchService = MatchService;
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

    @GetMapping(value = "/userId={userId}/results")
    public List<BetResult> getBetsResultsByUserId(@PathVariable("userId") int userId)
    {
        List<Match> matchList = this.MatchService.getAllMatchs();
        List<BetEntity> betList = this.betService.getBetsByUserId(userId);
        List<BetResult> betResultList = new ArrayList<>();

        System.out.println(matchList.get(0));
        System.out.println(betList.get(0));

        for(int i = 0; i < matchList.size(); i++)
        {
            for(int j = 0; j < betList.size(); j++)
            {
                if(betList.get(j).getIdMatch() == matchList.get(i).getId())
                {
                    int scoreEquipe1 = matchList.get(i).getFirstTeamScore();
                    int scoreEquipe2 = matchList.get(i).getSecondTeamScore();
                    int idEquipeChoisie = betList.get(j).getIdEquipe();
                    int idEquipeGagnante = -1;

                    if(scoreEquipe1 < scoreEquipe2)
                        idEquipeGagnante = matchList.get(i).getSecondTeamID();
                    else if(scoreEquipe1 > scoreEquipe2)
                        idEquipeGagnante = matchList.get(i).getFirstTeamID();
                    else if(scoreEquipe1 == scoreEquipe2)
                        idEquipeGagnante = -1;

                    //S'il n'y a pas égalité
                    if(idEquipeGagnante != -1)
                    {
                        if(idEquipeChoisie == idEquipeGagnante)
                        {
                            BetResult betResult = new BetResult(matchList.get(i).getId(), 1);
                            betResultList.add(betResult);
                        }
                        else
                        {
                            BetResult betResult = new BetResult(matchList.get(i).getId(), 0);
                            betResultList.add(betResult);
                        }
                    }
                    else
                    {
                        BetResult betResult = new BetResult(matchList.get(i).getId(), -1);
                        betResultList.add(betResult);
                    }
                }
            }

        }

        return betResultList;
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
