package com.gmail.antcoreservices.games.laura.main;

public class DefaultSettings {
    // Settings
    private int originalTileSize = 16; // 16x16
    private final int scale = 4;

    private int tileSize = originalTileSize * scale; // 48x48
    private int  maxScreenCol = 14;
    private int maxScreenRow = 10;
    private int screenWidth = tileSize *  maxScreenCol;//768
    private int screenHeight = tileSize * maxScreenRow;//576
    // world settings
    private int maxWorldCol = 50;
    private int maxWorldRow = 50;

    private boolean isDebuggingOn = false;

    // App name
    private final boolean isDevelopment = true;
    private String name;
    {
        if (isDevelopment) {
            name = "Laura - Development";
        } else {
            name = "Laura";
            name = "Laura";
        }
    }
    public DefaultSettings() {}

    private void updateTileSize() {this.tileSize = originalTileSize*scale;}
    private void updateWidth() {
        screenWidth = tileSize * maxScreenCol;
    }
    private void updateHeight() {
        screenHeight = tileSize * maxScreenRow;
    }
    private void updateScreenSpecs() {
        updateWidth();
        updateHeight();
    }
    public void setOriginalTileSize(int tileSize) {
        this.originalTileSize = tileSize;
        updateTileSize();
        updateScreenSpecs();
    }
    public void setMaxScreenCol(int maxScreenCol) {
        this.maxScreenCol = maxScreenCol;
        updateScreenSpecs();
    }
    public void setMaxScreenRow(int maxScreenRow) {
        this.maxScreenRow = maxScreenRow;
        updateScreenSpecs();
    }
    public void setMaxWorldCol(int maxWorldCol) {
        this.maxWorldCol = maxWorldCol;
    }
    public void setMaxWorldRow(int maxWorldRow) {
        this.maxWorldRow = maxWorldRow;
    }


    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public int getScreenWidth() {
        return screenWidth;
    }
    public int getMaxScreenCol() {
        return maxScreenCol;
}
    public int getMaxScreenRow() {
        return maxScreenRow;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getMaxWorldCol() {
        return maxWorldCol;
    }

    public int getMaxWorldRow() {
        return maxWorldRow;
    }

    public boolean isDebuggingOn() {
        return isDebuggingOn;
    }

    public void setDebugging(boolean debuggingOn) {
        isDebuggingOn = debuggingOn;
    }
    public String getName() {
        return name;
    }
    public void setName() {
        this.name = name;
    }

    public int getTileSize() {
        return tileSize;
    }
    public int getScale() {
        return scale;
    }
    public int getOriginalTileSize() {
        return originalTileSize;
    }
}
