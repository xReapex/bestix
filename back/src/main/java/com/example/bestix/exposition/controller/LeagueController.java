package com.example.bestix.exposition.controller;

import com.example.bestix.domain.service.BetService;
import com.example.bestix.domain.service.LeagueService;
import com.example.bestix.domain.service.UserService;
import com.example.bestix.infrastructure.Entity.LeagueEntity;
import com.example.bestix.infrastructure.Entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/league")
public class LeagueController {

    LeagueService leagueService;
    UserService userService;

    @Autowired
    public LeagueController(LeagueService leagueService, UserService userService)
    {
        this.leagueService =  leagueService;
        this.userService = userService;
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

    //Demande l'accès à une league par un utilisateur
    @PostMapping(value="/{leagueId}/{password}/{userId}")
    public boolean requestLeagueAccess(@PathVariable("leagueId") int leagueId, @PathVariable("password") String password, @PathVariable("userId") int userId){

        boolean state = leagueService.requestLeagueAccess(leagueId, password);
        if(state) {
            leagueService.grantLeagueAccessToUser(leagueId, userId);
        }

        return leagueService.requestLeagueAccess(leagueId, password);
    }

    //Vérifie les leagues déjà rejoins
    @GetMapping(value = "/{userId}")
    public List<Integer> checkJoinedLeaguesByUserId(@PathVariable("userId") int userId)
    {
        return leagueService.checkJoinedLeaguesByUserId(userId);
    }

    //Retourne la liste des utilisateurs inscrits à une ligue
    @GetMapping(value = "/{leagueId}/users")
    public List<String> getLeagueUserList(@PathVariable("leagueId") int leagueId)
    {
        //TODO Return DTO instead of Array of string !!
        
        //Récupère la liste des identifiants des utilisateurs
        List<Integer> userIdList = leagueService.getLeaguesUserList(leagueId);

        System.out.println("userIdList :");
        System.out.println(userIdList);

        //Récupère les données des utilisateurs selon leur id
        List<String> userList = new ArrayList<>();

        for(int i = 0; i < userIdList.size(); i++)
        {
            String user = userService.getUserData(userIdList.get(i));
            userList.add(user);
        }

        return userList;
    }
}
