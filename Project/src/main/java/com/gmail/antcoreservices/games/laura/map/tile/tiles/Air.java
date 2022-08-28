package com.gmail.antcoreservices.games.laura.map.tile.tiles;

import com.gmail.antcoreservices.games.laura.map.tile.Tile;
import com.gmail.antcoreservices.games.laura.map.tile.TileMaterial;
import com.gmail.antcoreservices.games.laura.map.tile.TileTypes;

import java.awt.image.BufferedImage;

public class Air extends Tile {
    private final BufferedImage image;
    {
        image = null;
    }
    public Air(TileTypes[] tileTypes) {
        super(tileTypes, TileMaterial.AIR, null, 999.999, 999.999, 0);
        updateTileImage(image);
    }
    public Air() {
        super(new TileTypes[TileTypes.LIQUID.ordinal()], TileMaterial.AIR, null, 999.999, 999.999, 0);
        updateTileImage(image);
    }
}
