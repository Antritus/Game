package com.gmail.antcoreservices.games.laura.map.tile.tiles;

import com.gmail.antcoreservices.games.laura.main.Material;
import com.gmail.antcoreservices.games.laura.map.tile.Tile;
import com.gmail.antcoreservices.games.laura.map.tile.TileTypes;

import java.awt.image.BufferedImage;

public class Air extends Tile {
    public Air(TileTypes[] tileTypes) {
        super(tileTypes, Material.AIR, null, 999.999, 999.999, 999);
    }
    public Air() {
        super(new TileTypes[TileTypes.LIQUID.ordinal()], Material.AIR, null, 999.999, 999.999, 999);
    }
}
