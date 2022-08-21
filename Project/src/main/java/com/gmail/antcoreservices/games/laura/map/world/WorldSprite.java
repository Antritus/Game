package com.gmail.antcoreservices.games.laura.map.world;

import java.awt.image.BufferedImage;

public class WorldSprite {
    private BufferedImage image;
    private int height;
    private int width;
    public WorldSprite(BufferedImage image) {
        this.image = image;
        this.height = image.getHeight();
        this.width = image.getWidth();
    }
    public WorldSprite(BufferedImage image, int width, int height) {
        this.image = image;
        this.width = width;
        this.height = height;
    }

    public BufferedImage getImage() {
        return image;
    }
    public BufferedImage getSprite(int col, int row, int width, int height) {
        if (!((col * width) - width <= image.getWidth()) && !((row * height)- height <= image.getHeight())) {
            return null;
        }
        int c = (col * width) - width;
        int r = (row * height) - height;

        if (c - width < 0) {
            c = 0;
        }
        if (row - height < 0) {
            r = 0;
        }
        if (c + width >= image.getWidth() || r + height >= image.getHeight()){
            return null;
        }
        System.out.println(c);
        System.out.println(r);
        System.out.println("");
        return image.getSubimage(c, r, width, height);
    }
}

