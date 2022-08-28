package com.gmail.antcoreservices.games.laura.map.tile;

import com.gmail.antcoreservices.games.laura.main.GamePanel;
import com.gmail.antcoreservices.games.laura.map.tile.tiles.Air;
import com.gmail.antcoreservices.games.laura.map.tile.tiles.Grass;

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

    public void loadTile(Tile tile) {
        tiles.add(tile);
    }

    public List<Tile> getTiles() {
        return tiles;
    }
    public Tile getTile(int index) {
        return tiles.get(index);
    }



}
