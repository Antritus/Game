package com.gmail.antcoreservices.games.laura.map.tile.tiles;

import com.gmail.antcoreservices.games.laura.main.Material;
import com.gmail.antcoreservices.games.laura.map.tile.Tile;
import com.gmail.antcoreservices.games.laura.map.tile.TileTypes;

import java.awt.image.BufferedImage;

public class Air extends Tile {
    public Air(TileTypes[] tileTypes, Material material, BufferedImage tileImage, int tileSize, int worldX, int worldY) {
        super(tileTypes, material, tileImage, 999.999, 999.999, 999, tileSize, worldX, worldY);
    }
}
