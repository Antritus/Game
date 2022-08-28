package com.gmail.antcoreservices.games.laura.map.tile.tiles;


import com.gmail.antcoreservices.games.laura.map.tile.Tile;
import com.gmail.antcoreservices.games.laura.map.tile.TileMaterial;
import com.gmail.antcoreservices.games.laura.map.tile.TileTypes;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Beach extends Tile {
    private final BufferedImage image;

    {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/tiles/worldtiles/tiles/sand.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Beach(TileTypes[] tileTypes) {
        super(tileTypes, TileMaterial.WATER_SEA, null, 30.0, 30.0, 0);
        updateTileImage(image);
    }
    public Beach() {
        super(new TileTypes[]{TileTypes.LIQUID}, TileMaterial.WATER_SEA, null, 30.0, 30.0, 0);
        updateTileImage(image);
    }
}
