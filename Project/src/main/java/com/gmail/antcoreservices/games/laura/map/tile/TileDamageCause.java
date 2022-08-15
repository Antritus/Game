package com.gmail.antcoreservices.games.laura.map.tile;

public enum TileDamageCause {
    ENVIRONMENT("ENVIRONMENT_DAMAGE"),
    PLAYER("PLAYER_DAMAGE"),
    ENTITY("ENTITY_DAMAGE"),
    EXPLOSION("EXPLOSION_DAMAGE"),
    ;


    private String name;

    TileDamageCause(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        if (this.name == null) {
            this.name = "UNKNOWN_ERROR_CAUGHT | ERROR (#MT/TDC(X00001))";
        }
        return name;
    }
}
