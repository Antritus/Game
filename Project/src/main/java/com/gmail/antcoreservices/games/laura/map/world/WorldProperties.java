package com.gmail.antcoreservices.games.laura.map.world;

import com.gmail.antcoreservices.games.laura.map.Tile;

public class WorldProperties {
    private int maxCol;
    private int maxRow;
    private int maxLayers;
    private int entityCount;
    private int npcCount;
    private int hostileCount;
    private int objectCount;
    private int tileCount;
    private boolean isLoaded;

    private void loadWorld(int world) {
        //todo
    }

    private Tile[][][] tiles = new Tile[10][10][10]; // layer, col, row
    private void loadWorld(String world) {
        //todo
    }

    public WorldProperties(int maxCol, int maxRow, int maxLayers, int entityCount, int npcCount, int hostileCount, int objectCount, int tileCount, boolean isLoaded) {
        this.maxCol = maxCol;
        this.maxRow = maxRow;
        this.maxLayers = maxLayers;
        this.entityCount = entityCount;
        this.npcCount = npcCount;
        this.hostileCount = hostileCount;
        this.objectCount = objectCount;
        this.tileCount = tileCount;
        this.isLoaded = isLoaded;
    }

    public int getMaxCol() {
        return maxCol;
    }

    public void setMaxCol(int maxCol) {
        this.maxCol = maxCol;
    }

    public int getMaxRow() {
        return maxRow;
    }

    public void setMaxRow(int maxRow) {
        this.maxRow = maxRow;
    }

    public int getMaxLayers() {
        return maxLayers;
    }

    public void setMaxLayers(int maxLayers) {
        this.maxLayers = maxLayers;
    }

    public int getEntityCount() {
        return entityCount;
    }

    public void setEntityCount(int entityCount) {
        this.entityCount = entityCount;
    }

    public int getNPCCount() {
        return npcCount;
    }

    public void setNPCCount(int npcCount) {
        this.npcCount = npcCount;
    }

    public int getHostileCount() {
        return hostileCount;
    }

    public void setHostileCount(int hostileCount) {
        this.hostileCount = hostileCount;
    }

    public int getObjectCount() {
        return objectCount;
    }

    public void setObjectCount(int objectCount) {
        this.objectCount = objectCount;
    }

    public int getTileCount() {
        return tileCount;
    }

    public void setTileCount(int tileCount) {
        this.tileCount = tileCount;
    }

    public boolean isLoaded() {
        return isLoaded;
    }

    public void setLoaded(boolean loaded) {
        isLoaded = loaded;
    }

    public Tile[][][] getTiles() {
        return tiles;
    }
    public void setTiles(Tile[][][] tiles) {
        this.tiles = tiles;
    }
    public void setTile(int layer, int col, int row, Tile tile) {
        this.tiles[layer][col][row] = tile;
    }
    public Tile getTile(int layer, int col, int row) {
        return this.tiles[layer][col][row];
    }
}
