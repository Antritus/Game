package com.gmail.antcoreservices.games.laura.map.tile;

import com.gmail.antcoreservices.games.laura.main.Material;

import java.awt.image.BufferedImage;

public class Tile {
    private TileTypes[] tileTypes;
    private final TileProperties tileProperties;
    private final String name;
    private final Material material;
    private final BufferedImage tileImage;
    private int id;
    private boolean isIDSet = false;
    public Tile(TileTypes[] tileTypes, Material material, BufferedImage tileImage, double health, double maxHealth, int toughness) {
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

    }
    protected void setID(int id){
        if (isIDSet) {
            return;
        }
        this.id = id;
    }
    public Material getMaterial() {
        return material;
    }
    public String getName() {
        return name;
    }
    public int getID(){
        return id;
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
