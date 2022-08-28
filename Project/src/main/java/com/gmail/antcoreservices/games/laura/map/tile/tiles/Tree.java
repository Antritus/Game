package com.gmail.antcoreservices.games.laura.map.tile.tiles;


import com.gmail.antcoreservices.games.laura.map.tile.Tile;
import com.gmail.antcoreservices.games.laura.map.tile.TileMaterial;
import com.gmail.antcoreservices.games.laura.map.tile.TileTypes;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Tree extends Tile {
    private final BufferedImage image;

    {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/tiles/worldtiles/tiles/tree.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Tree(TileTypes[] tileTypes) {
        super(tileTypes, TileMaterial.TREE, null, 30.0, 30.0, 2);
        updateTileImage(image);
    }
    public Tree() {
        super(new TileTypes[]{TileTypes.SOLID, TileTypes.BREAKABLE, TileTypes.PLANTABLE}, TileMaterial.TREE, null, 30.0, 30.0, 2);
        updateTileImage(image);
    }
}
