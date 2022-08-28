package com.gmail.antcoreservices.games.laura.map.chunksystemprototype;

import com.gmail.antcoreservices.games.laura.map.tile.Tile;

import java.awt.image.BufferedImage;

public class Chunk {

    private final int layers = 5;
    private final double startX;
    private final double startY;
    private final double endX;
    private final double endY;
    private final int startCol;
    private final int maxCol;
    private final int startRow;
    private final int maxRow;
    private BufferedImage image;


    private final Tile[][][] tiles; // LAYER, (CHUNK) COL, (CHUNK) ROW


    public Chunk(double startX, double startY, double endX, double endY, int startCol, int maxCol, int startRow, int maxRow) {
        this.image = null;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.startCol = startCol;
        this.maxCol = maxCol;
        this.startRow = startRow;
        this.maxRow = maxRow;
        tiles = new Tile[16][16][16];
    }
    public Chunk(BufferedImage bufferedImage, double startX, double startY, double endX, double endY, int startCol, int maxCol, int startRow, int maxRow) {
        this.image = bufferedImage;
        this.startX = 0;
        this.startY = 0;
        this.endX = 0;
        this.endY = 0;
        this.startCol = 0;
        this.maxCol = 0;
        this.startRow = 0;
        this.maxRow = 0;
        tiles = new Tile[16][16][16];
    }

    public BufferedImage getImage() {
        return image;
    }

    /*
     * Returns only one tile in the chunk
     */
    public Tile getTile(int l, int x, int y) {
        return tiles[l][x][y];
    }
    /*
     * Returns all tiles in the chunk
     */
    public Tile[][][] getTiles() {
        return tiles;
    }




}
