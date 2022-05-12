package com.example.bestix.infrastructure.Entity;

import javax.persistence.*;

@Entity
@Table(name = "bets")
public class BetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idBet")
    private int id;

    @Column(name = "idMatch")
    private int idMatch;

    @Column(name = "idEquipe")
    private int idEquipe;

    @Column(name = "idUser")
    private int idUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
    }

    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }


}

