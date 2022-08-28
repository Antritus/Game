package com.gmail.antcoreservices.games.laura.map.tile;

public enum TileMaterial {
    AIR ("AIR"),
    GRASS ("GRASS"),
    GRASS_UP ("GRASS"),
    GRASS_DOWN ("GRASS"),
    GRASS_LEFT ("GRASS"),
    GRASS_RIGHT ("GRASS"),


    WATER_OCEAN_DEEP ("WATER"),
    WATER_OCEAN ("WATER"),
    WATER_SEA ("WATER"),
    WATER_RIVER ("WATER"),
    WATER ("WATER"),


    SAND_BEACH ("SAND"),
    SAND_RIVER ("SAND"),
    SAND ("SAND"),

    TREE ("TREE"),

    ;
    private final String name;

    TileMaterial(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
