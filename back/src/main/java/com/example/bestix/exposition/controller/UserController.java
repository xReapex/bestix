package com.example.bestix.exposition.controller;

import com.example.bestix.domain.service.UserService;
import com.example.bestix.infrastructure.Entity.Player;
import com.example.bestix.infrastructure.Entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/user")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> changeUserPasswordById(@PathVariable("id") int userId, @RequestBody String password) {
        try{
            this.userService.changeUserPasswordById(userId, password);
            return ResponseEntity.ok().build();
        }catch (NullPointerException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
