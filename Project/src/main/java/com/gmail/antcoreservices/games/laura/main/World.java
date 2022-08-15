package com.gmail.antcoreservices.games.laura.main;

import java.util.HashMap;

public class World {
    private String world;
    private int worldMaxCol;
    private int worldMaxRow;
    private HashMap<WorldSetting, Object> worldSettings;

    public World(String world){
        this.world = world;
    }

    public int getWorldMaxCol() {
        return worldMaxCol;
    }
    public int getWorldMaxRow() {
        return worldMaxRow;
    }
}
