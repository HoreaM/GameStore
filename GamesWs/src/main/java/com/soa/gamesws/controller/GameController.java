package com.soa.gamesws.controller;

import java.io.IOException;
import java.util.List;

import com.soa.gamesws.utils.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soa.gamesws.model.Game;
import com.soa.gamesws.repo.GameRepository;

@RestController
@RequestMapping("/games")
public class GameController {

    private GameRepository repo = new GameRepository();
    private Server server = new Server();

    @RequestMapping(method = RequestMethod.GET)
    public List<Game> getGames(@RequestParam(value = "id", defaultValue = "") String id) throws IOException {
        if (id == null || id.isEmpty()) {
            return repo.getAllGames();
        } else {
            return server.getGameFromApplicationServerById(id);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Game addGame(@RequestBody Game g) {
        Game game = new Game();
        if (g != null) {
            game = repo.addGame(g);
        }

        return game;
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public Game updateGame(@RequestBody Game g) {
        Game game = new Game();
        if (g != null) {
            game = repo.updateGame(g);
        }

        return game;

    }
}