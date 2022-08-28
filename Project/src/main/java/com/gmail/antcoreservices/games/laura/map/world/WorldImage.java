package com.gmail.antcoreservices.games.laura.map.world;


import com.gmail.antcoreservices.games.laura.map.tile.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WorldImage {
    private BufferedImage image = null;

    private final int PIXEL_SCALE = 10;
    private Tile[][] tiles;

    public void visualize(double[][] array) {
        createImage(array, "generatedMap");
    }


    public void visualize(double[][] array, int amount) {
        for (int i = 0; i < amount; i++) {
            createImage(array, "generatedMap" + i);
        }
    }


    public void visualize(double[][] array, String filename) {
        createImage(array, filename);
    }


    private void createImage(double[][] array, String filename) {
        Tile[][] tile = new Tile[999][999];

        System.out.println("Creating world...");

        int IMAGE_HEIGHT = array.length * PIXEL_SCALE;
        int IMAGE_WIDTH = array[0].length * PIXEL_SCALE;

        BufferedImage bufferedImage = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();

        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);

        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array[x].length; y++) {

                if (array[x][y] < -0.5) { // Deep Ocean
                    g2d.setColor(new Color(1, 38, 119));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);
//                    tile[y][x] = new Deep_Ocean();
                } else if (array[x][y] < -0.4) { // Ocean
                    g2d.setColor(new Color(0, 91, 197));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);
//                    tile[y][x] = new Ocean();
                } else if (array[x][y] < -0.2) { // Sea
                    g2d.setColor(new Color(0, 180, 252));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);
  //                  tile[y][x] = new Sea();
                } else if (array[x][y] < 0.0) { // Beach
                    g2d.setColor(new Color(175, 209, 62));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);
    //                tile[y][x] = new Beach();
                } else if (array[x][y] < 0.2) { // Plain
                    g2d.setColor(new Color(113, 174, 78));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);
                    //                   tile[y][x] = new Grass();
                } else if (array[x][y] < 0.3) { // Forest
                    g2d.setColor(new Color(113, 134, 78));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);
                    //              tile[y][x] = new Tree();
                } else if (array[x][y] < 0.4) { // Deep Forest
                    g2d.setColor(new Color(62, 102, 23));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);
                    //             tile[y][x] = new Tree();
                } else if (array[x][y] < 0.5) { // Hills
                    g2d.setColor(new Color(166, 140, 105));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);
                    //          tile[y][x] = new Air();
                } else if (array[x][y] < 0.6) { // Cliffs
                    g2d.setColor(new Color(168, 149, 143));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);
                    //        tile[y][x] = new Air();
                } else if (array[x][y] < 0.7) { // Mountains
                    g2d.setColor(new Color(150, 129, 122));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);
                    //      tile[y][x] = new Air();
                } else if (array[x][y] < 0.8) { // High Mountain
                    g2d.setColor(new Color(84, 106, 107));
                    //        g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);
                } else if (array[x][y] < 0.9) { // Icy Mountain
                    g2d.setColor(new Color(44, 97, 89));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);
                    //     tile[y][x] = new Air();
                } else if (array[x][y] >= 1) { // Ice
                    g2d.setColor(Color.WHITE);
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);
                    //        tile[y][x] = new Air();
                }
            }
        }

        g2d.dispose();

        File file = new File(filename + ".png");
        try {
            ImageIO.write(bufferedImage, "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        tiles = tile;
        this.image = bufferedImage;
        System.out.println("SAVED");
    }

    public void createImage(double[][] array) {
        createImage(array, "default");
    }

    public BufferedImage getImage() {
        return image;
    }
    public int getPixelScale() {
        return PIXEL_SCALE;
    }

    public void visualize(String name) {
        if (image == null) {
            return;
        }
        File file = new File(name + ".png");
        try {
            ImageIO.write(image, "png", file);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void visualize(BufferedImage image, String name) {
        if (image == null) {
            return;
        }
        File file = new File(name + ".png");
        try {
            ImageIO.write(image, "png", file);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void visualize() {
        visualize("AUTO_GENERATED_BIOME_IMAGE");
    }

    public Tile[][] getTiles() {
        return tiles;
    }
}