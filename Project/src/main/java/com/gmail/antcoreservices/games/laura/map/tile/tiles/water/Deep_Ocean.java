package com.gmail.antcoreservices.games.laura.map.tile.tiles.water;


import com.gmail.antcoreservices.games.laura.map.tile.Tile;
import com.gmail.antcoreservices.games.laura.map.tile.TileMaterial;
import com.gmail.antcoreservices.games.laura.map.tile.TileTypes;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Deep_Ocean extends Tile {
    private final BufferedImage image;

    {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/tiles/worldtiles/tiles/ocean_deep.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Deep_Ocean(TileTypes[] tileTypes) {
        super(tileTypes, TileMaterial.WATER_OCEAN_DEEP, null, 30.0, 30.0, 0);
        updateTileImage(image);
    }
    public Deep_Ocean() {
        super(new TileTypes[]{TileTypes.LIQUID}, TileMaterial.WATER_OCEAN_DEEP, null, 30.0, 30.0, 0);
        updateTileImage(image);
    }
}
