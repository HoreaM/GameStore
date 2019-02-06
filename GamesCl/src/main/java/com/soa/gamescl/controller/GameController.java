package com.soa.gamescl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import com.soa.gamescl.client.Client;
import com.soa.gamescl.model.Game;

@Controller
public class GameController {

    private Client client = new Client();

    @RequestMapping("/")
    public String getGames(Model model,
                           @RequestParam(value = "id", defaultValue = "", required = false) String id) {
        if (id.isEmpty()) {
            List list = client.getAllGames();
            model.addAttribute("list", list);
            return "index";
        } else {
            List list = client.getGameById(id);
            model.addAttribute("list", list);
            return "details";
        }

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addGame(Model model, Game game) {
        client.addGame(game);
        List list = client.getAllGames();
        model.addAttribute("list", list);
        return "index";
    }

}