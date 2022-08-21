package com.gmail.antcoreservices.games.laura.map.tile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class TileNBT {
    private final Tile tile;
    public TileNBT(Tile tile) {
        this.tile = tile;
    }
    public String getNBT() {
        JsonObject object = new JsonObject();
        object.addProperty("NAME", tile.getName());
        object.addProperty("ID", tile.getID());

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(object);
    }
}
