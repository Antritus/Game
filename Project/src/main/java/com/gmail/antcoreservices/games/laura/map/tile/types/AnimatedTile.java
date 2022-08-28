package com.gmail.antcoreservices.games.laura.map.tile.types;

import com.gmail.antcoreservices.games.laura.map.tile.Tile;
import com.gmail.antcoreservices.games.laura.map.tile.TileMaterial;
import com.gmail.antcoreservices.games.laura.map.tile.TileTypes;

import java.awt.image.BufferedImage;

public class AnimatedTile extends Tile {
    public AnimatedTile(TileTypes[] tileTypes, TileMaterial material, BufferedImage tileImage, double health, double maxHealth, int toughness) {
        super(tileTypes, material, tileImage, health, maxHealth, toughness);
    }
}
