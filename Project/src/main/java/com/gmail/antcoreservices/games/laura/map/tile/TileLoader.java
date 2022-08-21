package com.gmail.antcoreservices.games.laura.map.tile;

import com.gmail.antcoreservices.games.laura.main.GamePanel;
import com.gmail.antcoreservices.games.laura.map.tile.tiles.Air;
import com.gmail.antcoreservices.games.laura.map.tile.tiles.Grass;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class TileLoader {
    GamePanel gp;
    static List<Tile> tiles = new ArrayList<>();

    public TileLoader(GamePanel gp) {
        this.gp = gp;
    }

    public void loadTiles() {
        List<Tile> tiles = new ArrayList<>();
        tiles.add(new Air());
        tiles.add(new Grass());
    }

    public static void loadTile(Tile tile) {
        tiles.add(tile);
    }

    public static void main(String[] args) {
        loadTile(new Air());
        loadTile(new Grass());
        int i = 0;

        for (Tile tile : tiles) {
            tile.setID(i);
            System.out.println(tile.getName() + "#" + tile.getID());
            i++;
        }
        System.out.println(tiles);

        for (Tile tile : tiles) {
            TileNBT tileNBT = new TileNBT(tile);
            System.out.println(tileNBT.getNBT());
        }

        loadMap("{\"MAP\": \"MAP\", \"IDS\": \"#DEV\", \"DESCRIPTION\": \"SIMPLE 9x9, map formatting menu\", \"COL\": 3, \"ROW\": 3, \"SIZE\": 9, \"DATE\": null, \"FORMAT_SLOT\": \"%COL%_%ROW%\", \"FORMAT_TILE\": \"%TYPE%#%TYPE_ID%\", \"LAYER_1\": {\"0_0\": \"GRASS#0\", \"0_1\": \"GRASS#0\", \"0_2\": \"GRASS#0\", \"1_0\": \"GRASS#0\", \"1_1\": \"GRASS#0\", \"1_2\": \"GRASS#0\", \"2_0\": \"GRASS#0\", \"2_1\": \"GRASS#0\", \"2_2\": \"GRASS#0\"}, \"LAYER_2\": {\"1_1\": \"STONE#0\", \"2_2\": \"TREE#0\"}}");
    }

    public static void loadMap(String nbt) {
        JsonElement jsonElement = JsonParser.parseString(nbt);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        for (int i = 0; i < 3; i++) {
        }
    }
}
