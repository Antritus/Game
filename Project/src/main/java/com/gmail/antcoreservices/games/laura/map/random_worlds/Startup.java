package com.gmail.antcoreservices.games.laura.map.random_worlds;

public class Startup {

    public static void main(String[] args) {
        // WorldGenerator worldgen = new SimplexNoiseGenerator(10, 0.2f, 0.0025f);
        WorldGenerator worldgen = new SimplexNoiseGenerator(3, 0.6f, 0.0065f);
        MapImage mi = new MapImage();

        for (int i = 0; i < 10; i++) {
            double[][] array = worldgen.createWorld(300, 300);
            mi.visualize(array, "generatedMap" + i);
        }
    }
}