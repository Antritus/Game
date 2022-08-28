package com.gmail.antcoreservices.games.laura.map.tile.tiles.water;


import com.gmail.antcoreservices.games.laura.map.tile.Tile;
import com.gmail.antcoreservices.games.laura.map.tile.TileMaterial;
import com.gmail.antcoreservices.games.laura.map.tile.TileTypes;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Ocean extends Tile {
    private final BufferedImage image;

    {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/tiles/worldtiles/tiles/ocean.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Ocean(TileTypes[] tileTypes) {
        super(tileTypes, TileMaterial.WATER_OCEAN, null, 30.0, 30.0, 0);
        updateTileImage(image);
    }
    public Ocean() {
        super(new TileTypes[]{TileTypes.LIQUID}, TileMaterial.WATER_OCEAN, null, 30.0, 30.0, 0);
        updateTileImage(image);
    }
}
