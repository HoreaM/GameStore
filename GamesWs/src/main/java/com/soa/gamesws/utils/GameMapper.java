package com.soa.gamesws.utils;

import org.json.JSONObject;

import com.soa.gamesws.model.Game;


public class GameMapper {
    private static final String ID = "appid";
    private static final String NAME = "name";
    private static final String DEVELOPER = "developer";
    private static final String USERSCORE = "userscore";
    private static final String INITIALPRICE = "initialprice";
    private static final String DISCOUNT = "discount";
    private static final String PRICE = "price";

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

            game = new Game(id, name, developer, userscore, initialprice, discount, price);
        }
        return game;
    }

}
