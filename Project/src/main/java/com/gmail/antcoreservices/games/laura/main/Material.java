package com.gmail.antcoreservices.games.laura.main;

public enum Material {
    // todo


    AIR ("AIR"),
    NULL ("AIR"),
    TILE_AIR ("AIR"),
    ITEM_AIR ("AIR"),


    TILE_STONE ("TILE_STONE"),
    TILE_GRASS ("TILE_GRASS");

    private final String name;

    Material(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
}
