package com.gmail.antcoreservices.games.laura.map.chunksystemprototype;

import com.gmail.antcoreservices.games.laura.main.DefaultSettings;
import com.gmail.antcoreservices.games.laura.main.GamePanel;

import java.awt.*;

public class ChunkLoader {

    GamePanel gp = new GamePanel(new DefaultSettings());
    private final Chunk[] chunks;

    public ChunkLoader(Chunk[] chunks) {
        this.chunks = chunks;
    }

    public void drawWorld(Graphics2D g2) {


        int worldCol = 0;
        int worldRow = 0;
        int worldLayer = 0;
        int maxWorldLayer = 5;
        int tileNum = 0;
        Chunk chunk = chunks[0];
        int chunkNum = 0;
        while ((worldCol < gp.getDefaultSettings().getMaxWorldCol()) && (worldRow < gp.getDefaultSettings().getMaxWorldRow()) && (worldLayer > maxWorldLayer)) {

            if (tileNum > 16) {
                chunkNum++;
                chunk = chunks[chunkNum];
            }

            int worldX = worldCol * gp.getDefaultSettings().getTileSize();
            int worldY = worldRow * gp.getDefaultSettings().getTileSize();
            int screenX = worldX - gp.player.getX() + gp.player.screenX;
            int screenY = worldY - gp.player.getY() + gp.player.screenY;
            if (worldX + gp.getDefaultSettings().getTileSize()> gp.player.getX() - gp.player.screenX &&
                    worldX - gp.getDefaultSettings().getTileSize()< gp.player.getX() + gp.player.screenX &&
                    worldY + gp.getDefaultSettings().getTileSize()> gp.player.getY() - gp.player.screenY &&
                    worldY - gp.getDefaultSettings().getTileSize()< gp.player.getY() + gp.player.screenY) {
                g2.drawImage(

                        chunk.getTile(worldLayer, worldX, worldY).getTileImage(), screenX, screenY, null
                );
            }
            worldCol++;
            if (worldCol == gp.getDefaultSettings().getMaxWorldCol()) {
                chunkNum = 0;
                chunk = chunks[0];
                worldCol = 0;
                worldRow++;
            } if (worldRow == gp.getDefaultSettings().getMaxWorldRow()) {
                chunkNum = 0;
                chunk = chunks[0];
                worldLayer++;
                worldCol = 0;
                worldRow = 0;
            }
        }
    }
}
