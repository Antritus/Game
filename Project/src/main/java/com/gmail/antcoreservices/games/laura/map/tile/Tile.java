package com.gmail.antcoreservices.games.laura.map.tile;

import com.gmail.antcoreservices.games.laura.main.Material;

import java.awt.image.BufferedImage;

public class Tile {
    private TileTypes[] tileTypes;
    private final TileProperties tileProperties;
    private final String name;
    private final Material material;
    private final BufferedImage tileImage;
    private final int tileSize;
    private final int worldX;
    private final int worldY;

    public Tile(TileTypes[] tileTypes, Material material, BufferedImage tileImage, double health, double maxHealth, int toughness, int tileSize, int worldX, int worldY) {
        this.tileTypes = tileTypes;
        boolean isDes = false, isSol = false, isLiq = false, isHoe = false, isPick = false;
        if (tileTypes != null) {
            for (TileTypes tileType : tileTypes) {
                if (tileType == TileTypes.DESTROYABLE) {
                    isDes = true;
                }
                else if (tileType == TileTypes.SOLID) {
                    isSol = true;
                }
                else if (tileType == TileTypes.LIQUID) {
                    isLiq = true;
                }
                else if (tileType == TileTypes.HOEABLE) {
                    isHoe = true;
                }
                else if (tileType == TileTypes.PICKABLE) {
                    isPick = true;
                }
            }
        }
        this.tileProperties = new TileProperties(maxHealth, health, toughness, isDes, isSol, isLiq, isHoe, isPick, new TileDamageProperties());
        this.name = material.toString();
        this.material = material;
        this.tileImage = tileImage;
        this.tileSize = tileSize;
        this.worldX = worldX;
        this.worldY = worldY;
    }

    public Material getMaterial() {
        return material;
    }
    public String getName() {
        return name;
    }
    public int getTileSize() {
        return tileSize;
    }
    // todo: add way to get world x ( NO METHOD CURRENTLY TO UPDATE X)
    public int getWorldX() {
        return worldX;
    }
    public int getWorldY() {
        return worldY;
    }
    public TileProperties getTileProperties() {
        return tileProperties;
    }

    public TileTypes[] getTileTypes() {
        return tileTypes;
    }

    public void setTileTypes(TileTypes[] tileTypes) {
        this.tileTypes = tileTypes;
    }

    public BufferedImage getTileImage() {
        return tileImage;
    }
}
