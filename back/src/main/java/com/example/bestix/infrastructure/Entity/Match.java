package com.example.bestix.infrastructure.Entity;

import javax.persistence.*;


@Entity
public class Match {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    
    
    @Column(name = "firstTeamName")
    private String firstTeamName;

    @Column(name = "secondTeamName")
    private String secondTeamName;


    @Column(name = "date")
    private String date;

    public Match(int id, String firstTeamName, String secondTeamName, String date) {
            this.id = id;
            this.firstTeamName = firstTeamName;
            this.secondTeamName = secondTeamName;
            this.date = date;
    }

    public Match(){

    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getFirstTeamName(){

        return firstTeamName;
    }

    public void setFirstTeamName(String firstTeamName){

        this.firstTeamName = firstTeamName;
    }

    public String getsecondTeamName(){

        return secondTeamName;
    }

    public void setSecondTeamName(String secondTeamName){

        this.secondTeamName = secondTeamName;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){

        this.date = date;
    }




}
