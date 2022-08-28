package com.gmail.antcoreservices.games.laura.map.tile.tiles;

import com.gmail.antcoreservices.games.laura.map.tile.Tile;
import com.gmail.antcoreservices.games.laura.map.tile.TileMaterial;
import com.gmail.antcoreservices.games.laura.map.tile.TileTypes;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Grass extends Tile {
    private final BufferedImage image;

    {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/tiles/worldtiles/tiles/grass.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Grass(TileTypes[] tileTypes) {
        super(tileTypes, TileMaterial.GRASS, null, 30.0, 30.0, 2);
        updateTileImage(image);
    }
    public Grass() {
        super(new TileTypes[TileTypes.LIQUID.ordinal()], TileMaterial.GRASS, null, 30.0, 30.0, 2);
        updateTileImage(image);
    }
}
