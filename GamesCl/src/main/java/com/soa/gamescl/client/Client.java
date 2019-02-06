package com.soa.gamescl.client;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.soa.gamescl.model.Game;

public class Client {
    private static final String URL = "http://localhost:8090/games";
    private RestTemplate rest = new RestTemplate();

    public List getAllGames() {
        return rest.getForObject(URL, List.class);
    }

    public List getGameById(String id) {
        return rest.getForObject(URL + "?id=" + id, List.class);
    }

    public Game addGame(Game game) {
        return rest.postForObject(URL, game, Game.class);
    }

    public void updateGame(Game game) {
        rest.put(URL, game);
    }
}
