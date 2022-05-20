package com.example.bestix.infrastructure.Entity;

import com.example.bestix.infrastructure.Entity.Player;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonToJava {

    public static void main(String[] st) {
        String jsonStr = "{\r\n" +
                "     \"id\":1,\r\n" +
                "      \"playerName\":\"John\",\r\n" +
                "}";

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            Player player = mapper.readValue(jsonStr, Player.class);
            System.out.println("Id: " + player.getId());
            System.out.println(" Player Name: " + player.getPlayerName());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
