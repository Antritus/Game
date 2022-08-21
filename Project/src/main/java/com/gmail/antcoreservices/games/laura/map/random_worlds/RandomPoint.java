package com.gmail.antcoreservices.games.laura.map.random_worlds;

import java.util.Random;

public class RandomPoint implements WorldGenerator {

    @Override
    public double[][] createWorld(int width, int height) {
        double[][] map = new double[width][height];

        Random r = new Random();

        for(int x = 0; x<map.length; x++) {
            for(int y = 0; y < map[x].length; y++) {
                map[x][y] = r.nextInt(2); //Random value between 0 and 1;
            }
        }
        return map;
    }
}
