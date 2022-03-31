package com.example.bestix.exposition.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class PlayerDTO {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("players")
    private void unpackNested(Map<String,Object> players) {
        this.id = (int)players.get("idPlayer");
        this.name = (String)players.get("strPlayer");
    }

}
