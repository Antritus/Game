package com.gmail.antcoreservices.games.laura.map.tile.tiles;

import com.gmail.antcoreservices.games.laura.main.Material;
import com.gmail.antcoreservices.games.laura.map.tile.Tile;
import com.gmail.antcoreservices.games.laura.map.tile.TileTypes;

import java.awt.image.BufferedImage;

public class Grass extends Tile {
    public Grass(TileTypes[] tileTypes) {
        super(tileTypes, Material.TILE_GRASS, null, 999.999, 999.999, 999);
    }
    public Grass() {
        super(new TileTypes[TileTypes.HOEABLE.ordinal()], Material.TILE_GRASS, null, 999.999, 999.999, 999);
    }

    private void createNBT() {

    }
}
