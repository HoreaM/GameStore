package com.soa.gamesws.repo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.soa.gamesws.model.Game;
import com.soa.gamesws.utils.Server;

public class GameRepository {
    private List<Game> games = new ArrayList<Game>();
    private Server server = new Server();

    public GameRepository() {
        super();
        try {
            loadDataFromServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Game> getAllGames() {
        FileReader fr;
        try {
            fr = new FileReader("games.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            games.clear();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String developer = data[2];
                int userscore = Integer.parseInt(data[3]);
                int initialprice = Integer.parseInt(data[4].replace(".", ""));
                int discount = Integer.parseInt(data[5]);
                int price = Integer.parseInt(data[6].replace(".", ""));
                Game game = new Game(id, name, developer, userscore, initialprice, discount, price);
                games.add(game);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return games;
    }


    private void loadDataFromServer() throws IOException {
        games = server.getAllGamesFromApplicationServer();
        writeFile();
    }


    public Game addGame(Game game) {
        if (game != null) {
            games.add(game);
            writeFile();
            return game;
        }
        return new Game();
    }

    public Game updateGame(Game game) {
        Game g = findGame(game.getId());

        if (g != null) {
            g.setName(game.getName());
            g.setDeveloper(game.getDeveloper());
            g.setUserscore(game.getUserscore());
            g.setInitialprice(game.getInitialprice());
//            g.setInitialprice(Integer.parseInt(game.getInitialprice().replace(".", "")));
            g.setDiscount(game.getDiscount());
//            g.setPrice(Integer.parseInt(game.getPrice().replace(".", "")));
            g.setPrice(game.getPrice());
        }
        writeFile();
        return g;
    }

    private Game findGame(int id) {
        for (Game game : games) {
            if (game.getId() == id) {
                return game;
            }
        }
        return null;
    }

    private void writeFile() {
        PrintWriter printWriter;
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("games.txt");
            printWriter = new PrintWriter(fileWriter);
            for (Game g : games) {
                printWriter.print(g.toString());
                printWriter.print("\n");
            }
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}