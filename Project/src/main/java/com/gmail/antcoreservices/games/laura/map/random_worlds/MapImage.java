package com.gmail.antcoreservices.games.laura.map.random_worlds;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MapImage {
    private BufferedImage image = null;

    private final int PIXEL_SCALE = 10;

    /**
     * Creates a 2D PNG Image from a two dimensional array.
     *
     * @param array
     */
    public void visualize(double[][] array) {
        createImage(array, "generatedMap");
    }

    /**
     * Creates an amount of 2D PNG Images from a two dimensional array.
     *
     * @param array
     */
    public void visualize(double[][] array, int amount) {
        for (int i = 0; i < amount; i++) {
            createImage(array, "generatedMap" + i);
        }
    }

    /**
     * Creates an amount of 2D PNG Images from a two dimensional array.
     *
     * @param array
     */
    public void visualize(double[][] array, String filename) {
        createImage(array, filename);
    }

    /**
     * Private Method to create a Buffered Image and save the result in a file.
     *
     * @param array
     * @param filename
     */
    private void createImage(double[][] array, String filename) {


        int IMAGE_HEIGHT = array.length * PIXEL_SCALE;
        int IMAGE_WIDTH = array[0].length * PIXEL_SCALE;


        // Constructs a BufferedImage of one of the predefined image types.
        BufferedImage bufferedImage = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
        // Create a graphics which can be used to draw into the buffered image
        Graphics2D g2d = bufferedImage.createGraphics();

        // fill all the image with white
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);

        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array[x].length; y++) {

                if (array[x][y] < -0.5) { // Deep Ocean
                    g2d.setColor(new Color(1, 38, 119));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);

                } else if (array[x][y] < -0.4) { // Ocean
                    g2d.setColor(new Color(0, 91, 197));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);

                } else if (array[x][y] < -0.2) { // Sea
                    g2d.setColor(new Color(0, 180, 252));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);

                } else if (array[x][y] < 0.0) { // Beach
                    g2d.setColor(new Color(175, 209, 62));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);

                } else if (array[x][y] < 0.2) { // Plain
                    g2d.setColor(new Color(113, 174, 78));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);

                } else if (array[x][y] < 0.3) { // Forest
                    g2d.setColor(new Color(113, 134, 78));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);

                } else if (array[x][y] < 0.4) { // Deep Forest
                    g2d.setColor(new Color(62, 102, 23));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);

                } else if (array[x][y] < 0.5) { // Hills
                    g2d.setColor(new Color(166, 140, 105));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);

                } else if (array[x][y] < 0.6) { // Cliffs
                    g2d.setColor(new Color(168, 149, 143));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);

                } else if (array[x][y] < 0.7) { // Mountains
                    g2d.setColor(new Color(150, 129, 122));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);

                } else if (array[x][y] < 0.8) { // High Mountain
                    g2d.setColor(new Color(84, 106, 107));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);
                } else if (array[x][y] < 0.9) { // Icy Mountain
                    g2d.setColor(new Color(44, 97, 89));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);
                } else if (array[x][y] >= 1) { // Ice
                    g2d.setColor(Color.WHITE);
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);
                }
            }
        }
        // Disposes of this graphics context and releases any system resources
        // that it is using.
        g2d.dispose();

        // Save as PNG
        File file = new File(filename + ".png");
        try {
            ImageIO.write(bufferedImage, "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.image = bufferedImage;
    }
    public void createImage(double[][] array, boolean drawDebugLines) {

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

                } else if (array[x][y] < -0.4) { // Ocean
                    g2d.setColor(new Color(0, 91, 197));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);

                } else if (array[x][y] < -0.2) { // Sea
                    g2d.setColor(new Color(0, 180, 252));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);

                } else if (array[x][y] < 0.0) { // Beach
                    g2d.setColor(new Color(175, 209, 62));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);

                } else if (array[x][y] < 0.2) { // Plain
                    g2d.setColor(new Color(113, 174, 78));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);

                } else if (array[x][y] < 0.3) { // Forest
                    g2d.setColor(new Color(113, 134, 78));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);

                } else if (array[x][y] < 0.4) { // Deep Forest
                    g2d.setColor(new Color(62, 102, 23));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);

                } else if (array[x][y] < 0.5) { // Hills
                    g2d.setColor(new Color(166, 140, 105));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);

                } else if (array[x][y] < 0.6) { // Cliffs
                    g2d.setColor(new Color(168, 149, 143));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);

                } else if (array[x][y] < 0.7) { // Mountains
                    g2d.setColor(new Color(150, 129, 122));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);

                } else if (array[x][y] < 0.8) { // High Mountain
                    g2d.setColor(new Color(84, 106, 107));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);
                } else if (array[x][y] < 0.9) { // Icy Mountain
                    g2d.setColor(new Color(44, 97, 89));
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);
                } else if (array[x][y] >= 1) { // Ice
                    g2d.setColor(Color.WHITE);
                    g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);
                }
            }
        }
        if (drawDebugLines) {
            g2d.setColor(new Color(55, 0, 0));
            g2d.fillRect(IMAGE_WIDTH/2-10, 0, 20, IMAGE_HEIGHT);
            g2d.fillRect(0, IMAGE_HEIGHT/2-10, IMAGE_WIDTH, 20);
            g2d.setColor(Color.WHITE);
            g2d.fillRect(IMAGE_WIDTH/2-2, 0, 4, IMAGE_HEIGHT);
            g2d.fillRect(0, IMAGE_HEIGHT/2-2, IMAGE_WIDTH, 4);
        }
        g2d.dispose();
        this.image = bufferedImage;
    }

    public void createImage(double[][] array) {
        createImage(array, false);
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
        visualize("AUTO_GENERATED_MAP_IMAGE");
    }
}