package com.soa.gamescl.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.HashMap;

@SpringBootApplication
public class GamesclApplication {
    public static void main(String[] args) throws Exception {
        HashMap<String, Object> props = new HashMap<String, Object>();
        props.put("server.port", 8100);
        new SpringApplicationBuilder().sources(GamesclApplication.class).properties(props).run(args);
    }
}

