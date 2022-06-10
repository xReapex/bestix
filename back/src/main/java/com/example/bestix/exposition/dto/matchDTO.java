package com.example.bestix.exposition.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class matchDTO {

    private int id;

    private int firstTeamID;
    private String firstTeamName;

    private int secondTeamID;
    private String secondTeamName;
    
    private String place;
    private String date;

    

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

    public int getSecondTeamID(){
        return secondTeamID;
    }

    public void setSecondTeamID(int secondTeamID) {
        this.secondTeamID = secondTeamID;
    }

    public String getSecondTeamName() {
        return secondTeamName;
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

    @SuppressWarnings("unchecked")
    @JsonProperty("players")
    private void unpackNested(Map<String, Object> matchs) {
        this.id = (int) matchs.get("key");
        this.firstTeamName = (String) matchs.get("homeTeam");
        this.secondTeamName = (String) matchs.get("awayTeam");
    }

}
