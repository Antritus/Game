package com.gmail.antcoreservices.games.laura.map.world;


import com.gmail.antcoreservices.games.laura.main.GamePanel;
import com.gmail.antcoreservices.games.laura.map.chunksystemprototype.Chunk;
import com.gmail.antcoreservices.games.laura.map.tile.Tile;

import java.awt.*;

public class WorldLoader {

    private final WorldProperties worldProperties;
    private int loadedCol;
    private int loadedMaxCol;
    private int loadedRow;
    private int loadedMaxRow;
    private int loadedX;
    private int loadedMaxX;
    private int loadedY;
    private int loadedMaxY;

    private final GamePanel gp;
    private final World world;
    private final Tile[][][] tile = new Tile[5][16*6][16*6];
    private final Chunk[][] chunks = new Chunk[4][4];

    private boolean isLoaded;

    public WorldLoader(GamePanel gp, World world){
        this.world = world;
        this.gp = gp;
        this.worldProperties = world.getWorldProperties();
        loadMap();
    }
    public World getWorld(){
        return world;
    }
    private void loadMap() {
    }

    public void drawWorld(Graphics2D g2){
    }

    private void updateWorldProperties() {
        worldProperties.setLoadedCol(loadedCol);
        worldProperties.setLoadedMaxCol(loadedMaxCol);
        worldProperties.setLoadedRow(loadedRow);
        worldProperties.setLoadedMaxRow(loadedMaxRow);
        worldProperties.setLoadedX(loadedX);
        worldProperties.setLoadedMaxX(loadedMaxX);
        worldProperties.setLoadedY(loadedY);
        worldProperties.setLoadedMaxY(loadedMaxY);
        worldProperties.setLoaded(isLoaded);
        int c = loadedCol;
        int r = loadedRow;
        for (int l = 0; l < 5; l++){
            for (int y = 0; y < 16*4; y++) {
                for (int x = 0; x < 16*4; x++) {
                    if (tile[l][x][y] == null) {
                        continue;
                    }
                    worldProperties.setTile(l, c, r, tile[l][x][y]);
                    c++;
                }
                r++;
            }
        }
    }
    private void updateWorldLoaderFromWorldProperties() {
        loadedCol = worldProperties.getLoadedCol();
        loadedMaxCol = worldProperties.getLoadedMaxCol();
        loadedRow = worldProperties.getLoadedRow();
        loadedMaxRow = worldProperties.getLoadedMaxRow();
        loadedX = worldProperties.getLoadedX();
        loadedMaxX = worldProperties.getLoadedMaxX();
        loadedY = worldProperties.getLoadedY();
        loadedMaxY = worldProperties.getLoadedMaxY();
        isLoaded = worldProperties.isLoaded();
        int c = loadedCol;
        int r = loadedRow;
        for (int l = 0; l < 5; l++){
            for (int y = 0; y < 16*4; y++) {
                for (int x = 0; x < 16*4; x++) {
                    tile[l][x][y] = worldProperties.getTile(l, c, r);
                    c++;
                }
                r++;
            }
        }

    }

    public void drawWorldFullWorld(Graphics2D g2) {
        loadedCol = 0;
        loadedMaxCol = worldProperties.getMaxCol();
        loadedRow = 0;
        loadedMaxRow = worldProperties.getMaxRow();
        updateWorldProperties();


        int worldCol = 0;
        int worldRow = 0;

        int worldHeight = 0;//todo world height

        while (worldCol < gp.getDefaultSettings().getMaxWorldCol() && worldRow < gp.getDefaultSettings().getMaxWorldRow()) {
            int worldX = worldCol * gp.getDefaultSettings().getTileSize();
            int worldY = worldRow * gp.getDefaultSettings().getTileSize();
            int screenX = worldX - gp.player.getX() + gp.player.screenX;
            int screenY = worldY - gp.player.getY() + gp.player.screenY;
            if (worldX + gp.getDefaultSettings().getTileSize()> gp.player.getX() - gp.player.screenX &&
                    worldX - gp.getDefaultSettings().getTileSize()< gp.player.getX() + gp.player.screenX &&
                    worldY + gp.getDefaultSettings().getTileSize()> gp.player.getY() - gp.player.screenY &&
                    worldY - gp.getDefaultSettings().getTileSize()< gp.player.getY() + gp.player.screenY) {
                g2.drawImage(tile[0][worldCol][worldRow].getImage(), screenX, screenY, null);
            }
            worldCol++;
            if (worldCol == gp.getDefaultSettings().getMaxWorldCol()) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
    public void loadChunk(Chunk chunk){
    }

    /*
     * Only returns the loaded chunks in the world due to making the world less laggy to play
     * Getting all the chunks would lag the world more due to having to load all the chunks (apx 10 minutes to load the 6400x6400px world with all chunks)
     */
    public Chunk[][] getChunks() {
        return chunks;
    }

    public Tile[][][] getTiles() {
        return tile;
    }
    public Tile getTile(int layer, int col, int row){
        return tile[layer][col][row];
    }
}
