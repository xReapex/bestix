package com.example.bestix.infrastructure.Entity;

import javax.persistence.*;

@Entity
@Table(name = "favoris")
public class FavoritePlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "favoriteid")
    private int id;

    @Column(name = "userid")
    private int userId;

    @Column(name = "playerid")
    private int playerId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

}
