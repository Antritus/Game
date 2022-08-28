package com.gmail.antcoreservices.games.laura.map.world;

import com.gmail.antcoreservices.games.laura.main.DefaultSettings;
import com.gmail.antcoreservices.games.laura.main.GamePanel;
import com.gmail.antcoreservices.games.laura.map.chunksystemprototype.Chunk;
import com.gmail.antcoreservices.games.laura.map.random_worlds.SimplexNoiseGenerator;
import com.gmail.antcoreservices.games.laura.map.random_worlds.WorldGenerator;

import java.awt.*;
import java.awt.image.BufferedImage;

public class World {
    private final WorldProperties worldProperties;
    private final WorldLoader worldLoader;
    private WorldSprite worldSprite;
    private BufferedImage worldFull;
    private BufferedImage worldLoaded;


    private final String name;

    private final WorldGenerator worldGenerator = new SimplexNoiseGenerator(3, 0.6f, 0.0065f); // randomized worlds
    private Chunk[][] chunks;
    private final WorldImage mapImage;
    private final GamePanel gp;
    private boolean isWorldLoading = false;


    public World(GamePanel gp, String name, boolean visualize) {
        this.gp = gp;
        worldProperties = new WorldProperties(10,10,0, null,true);
        this.mapImage = new WorldImage();
        this.name = name;
        isWorldLoading = true;
        createNewWorld(visualize, false);
        loadWorldChunks(false);
        this.worldLoader = new WorldLoader(gp, this);
        isWorldLoading = false;

    }
    public World(GamePanel gp, String name, WorldProperties worldProperties, WorldImage mapImage,boolean visualize){
        this.gp = gp;
        this.worldProperties = worldProperties;
        this.mapImage = mapImage;
        this.name = name;
        isWorldLoading = true;
        loadWorldChunks(false);
        this.worldLoader = new WorldLoader(gp, this);
        isWorldLoading = false;

    }
    public World(GamePanel gp, String name, WorldProperties worldProperties, boolean visualize) {
        this.gp = gp;
        this.worldProperties = worldProperties;
        this.mapImage = new WorldImage();
        this.name = name;
        isWorldLoading = true;
        createNewWorld(visualize, false);
        loadWorldChunks(false);
        this.worldLoader = new WorldLoader(gp, this);
        isWorldLoading = false;
    }

    private void createNewWorld(boolean visualize) {
        createNewWorld(visualize, true);
    }
    private void createNewWorld(boolean visualize, boolean isLoading) {
        if (isLoading) {
            this.isWorldLoading = true;
        }
        double[][] array = worldGenerator.createWorld(worldProperties.getMaxCol()*gp.getDefaultSettings().getTileSize(),worldProperties.getMaxRow()*gp.getDefaultSettings().getTileSize());
        mapImage.createImage(array);
        if (visualize) {
            mapImage.visualize(name);
        }
        if (isLoading) {
            this.isWorldLoading = false;
        }    }
    private void visualizeWorld() {
        visualizeWorld(true);
    }
    private void visualizeWorld(boolean isLoading) {
        if (isLoading) {
            this.isWorldLoading = true;
        }
        mapImage.visualize(name);
        if (isLoading) {
            this.isWorldLoading = false;
        }
    }
    private void loadWorldChunks() {
        loadWorldChunks(true);
    }
    private void loadWorldChunks(boolean isLoading) {
        if (isLoading) {
            this.isWorldLoading = true;
        }
        chunks = new Chunk[999][999];
        int pixel_scale = mapImage.getPixelScale();
        int cu = 0;
        int c = 0;
        int r = 0;
        int col = 0;
        int row = 0;
        for (int ro = 0; ro < 400; ro++) {
            for (int co = 0; co < 400; co++) {
                worldSprite = new WorldSprite(mapImage.getImage());
                //todo x, y
                chunks[ro][co] = new Chunk(worldSprite.getSprite(c, r, pixel_scale * 16, pixel_scale * 16), 0, 0, 0, 0, col, col + 16, row, row + 16);

                cu += pixel_scale * 16;
                c++;
                col += 16;
                if (worldSprite.getSprite(c, r, pixel_scale * 16, pixel_scale * 16) == null) {
                    c = 0;
                    col = 0;
                    r++;
                    row++;
                }
            }
        }
        mapImage.visualize(chunks[0][0].getImage(), "chunk" + 1);
        mapImage.visualize(chunks[1][1].getImage(), "chunk" + 2);
        mapImage.visualize(chunks[2][2].getImage(), "chunk" + 3);
        mapImage.visualize(chunks[3][3].getImage(), "chunk"+ 4);
        if (isLoading) {
            this.isWorldLoading = false;
        }
    }
    public void reloadWorldChunks(){

    }
    public WorldProperties getWorldProperties() {
        return worldProperties;
    }

    public static void main(String[] a) {
        System.out.println("LOADING");
        World world = new World(new GamePanel(new DefaultSettings()), "Default", true);
        System.out.println("DONE");
    }

    public boolean isWorldLoading() {
        return isWorldLoading;
    }

    public BufferedImage getWorldFull() {
        return worldFull;
    }

    public BufferedImage getWorldLoaded() {
        return worldLoaded;
    }

    public void tick(Graphics2D g2) {
        worldLoader.drawWorld(g2);
        g2.drawImage(chunks[0][0].getTile(0,0,0).getImage(), 0, 0, null);
    }
}
