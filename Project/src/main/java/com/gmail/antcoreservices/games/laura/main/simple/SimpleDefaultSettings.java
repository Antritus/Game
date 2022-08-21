package com.gmail.antcoreservices.games.laura.main.simple;

public class SimpleDefaultSettings {
    // Settings
    private final int originalTileSize = 16; // 16x16
    private final int scale = 4;

    private int tileSize = originalTileSize * scale; // 48x48
    private int  maxScreenCol = 16;
    private int maxScreenRow = 12;
    private int screenWidth = tileSize *  maxScreenCol;//768
    private int screenHeight = tileSize * maxScreenRow;//576
    // world settings
    private final int maxWorldCol = 50;
    private final int maxWorldRow = 50;

    private boolean isDebuggingOn = false;

    // App name
    private final String name = "Laura";


    public int getOriginalTileSize() {
        return originalTileSize;
    }
    public int getScale() {
        return scale;
    }
    public int getTileSize() {
        return tileSize;
    }
    public int getMaxScreenCol() {
        return maxScreenCol;
    }
    public int getMaxScreenRow() {
        return maxScreenRow;
    }
    public int getMaxWorldCol()  {
        return maxWorldCol;
    }
    public int getMaxWorldRow() {
        return maxWorldRow;
    }

    public boolean isDebuggingOn() {
        return isDebuggingOn;
    }

    public void setDebugging(boolean v) {
        isDebuggingOn = v;
    }

    public String getName() {
        return name;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public int getScreenWidth() {
        return screenWidth;
    }
}
