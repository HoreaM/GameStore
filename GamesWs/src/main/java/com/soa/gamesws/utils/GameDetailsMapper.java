package com.soa.gamesws.utils;

import org.json.JSONObject;

import com.soa.gamesws.model.Game;


public class GameDetailsMapper {
    private static final String ID = "appid";
    private static final String NAME = "name";
    private static final String DEVELOPER = "developer";
    private static final String USERSCORE = "userscore";
    private static final String INITIALPRICE = "initialprice";
    private static final String DISCOUNT = "discount";
    private static final String PRICE = "price";
    private static final String GENRE = "genre";
    private static final String POSITIVEREVIEWS = "positive";
    private static final String NEGATIVEREVIEWS = "negative";


    public Game convertFromJSONObjectToGameObject(JSONObject object) {
        Game game = null;

        if (null != object) {
            int id = object.getInt(ID);
            String name = object.getString(NAME);
            String developer = object.getString(DEVELOPER);
            int userscore = object.getInt(USERSCORE);
            int initialprice = object.getInt(INITIALPRICE);
            int discount = object.getInt(DISCOUNT);
            int price = object.getInt(PRICE);
            String genre = object.getString(GENRE);
            int positivereviews = object.getInt(POSITIVEREVIEWS);
            int negativereviews = object.getInt(NEGATIVEREVIEWS);

            game = new Game(id, name, developer, userscore, initialprice, discount, price, genre, positivereviews, negativereviews);
        }
        return game;
    }

}
