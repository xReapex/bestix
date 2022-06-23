package com.example.bestix.infrastructure.Entity;

import javax.persistence.*;

@Entity
@Table(name = "match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "firstTeamName")
    private String firstTeamName;

    
    @Column(name = "firstTeamID")
    private int firstTeamID;
    
    @Column(name = "secondTeamID")
    private int secondTeamID;

    @Column(name = "secondTeamName")
    private String secondTeamName;
    
    @Column(name = "place")
    private String place;

    @Column(name = "date")
    private String date;


    public Match(int id, String firstTeamName, int firstTeamID, String secondTeamName, int secondTeamID, String place,
            String date) {
        this.id = id;
        this.firstTeamName = firstTeamName;
        this.firstTeamID = firstTeamID;
        this.secondTeamName = secondTeamName;
        this.secondTeamID = secondTeamID;
        this.place = place;
        this.date = date;
    }

    public Match() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFirstTeamID() {
        return firstTeamID;
    }

    public void setFirstTeamID(int firstTeamID) {
        this.firstTeamID = firstTeamID;
    }

    public String getFirstTeamName() {

        return firstTeamName;
    }

    public void setFirstTeamName(String firstTeamName) {

        this.firstTeamName = firstTeamName;
    }

    public int getSecondTeamID() {
        return secondTeamID;
    }

    public void setSecondTeamID(int secondTeamID) {
        this.secondTeamID = secondTeamID;
    }

    public String getsecondTeamName() {

        return secondTeamName;
    }

    public void setSecondTeamName(String secondTeamName) {

        this.secondTeamName = secondTeamName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {

        this.date = date;
    }

}
