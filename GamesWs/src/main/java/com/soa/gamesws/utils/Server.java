package com.soa.gamesws.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.soa.gamesws.model.Game;


public class Server {

    private static final String URL = "http://steamspy.com/api.php?request=top100in2weeks";
    private static final String URLBYID = "http://steamspy.com/api.php?request=appdetails&appid=";
    private GameMapper mapper = new GameMapper();
    private GameDetailsMapper detailsMapper = new GameDetailsMapper();


    public List<Game> getAllGamesFromApplicationServer() throws IOException {
        List<Game> games = new ArrayList<Game>();

        URL url = new URL(URL);
        String json = getJsonAll(url);
        json = json.replace("\n", "").replace("\r", "");
        json = "[" + json.substring(0, json.length() - 1) + "]";
        JSONArray array = new JSONArray(json);

        for (int i = 0; i < array.length(); i++) {
            JSONObject game = array.getJSONObject(i);
            Game c = mapper.convertFromJSONObjectToGameObject(game);
            games.add(c);
        }
        return games;
    }


    public List<Game> getGameFromApplicationServerById(String id) throws IOException {
        List<Game> games = new ArrayList<Game>();
        URL url = new URL(URLBYID + id);
        String json = getJson(url);
        JSONObject gamejs = new JSONObject(json);
        games.add(detailsMapper.convertFromJSONObjectToGameObject(gamejs));
        return games;
    }


    @SuppressWarnings("Duplicates")
    private String getJsonAll(URL url) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        InputStream is = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuilder jsonBuilder = new StringBuilder();
        while ((line = br.readLine()) != null) {
            jsonBuilder.append(line.substring(line.indexOf(":") + 1));
        }
        return jsonBuilder.toString();
    }


    @SuppressWarnings("Duplicates")
    private String getJson(URL url) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        InputStream is = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuilder jsonBuilder = new StringBuilder();
        while ((line = br.readLine()) != null) {
            jsonBuilder.append(line);
        }
        return jsonBuilder.toString();
    }
}
