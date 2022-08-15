package com.gmail.antcoreservices.games.laura.map.tile;

import com.gmail.antcoreservices.games.laura.main.Material;

import java.awt.image.BufferedImage;

public class UpgradableTile{// extends Tile{
    // FIXME: 15/08/2022 §ERRORS
    private final BufferedImage[] upgradeStageImages;
    private final BufferedImage currentImage;
    private final int upgradeStageCount;
    private int currentUpgradeStage;
    public UpgradableTile(String name, TileProperties tileProperties, Material material, int tileSize, int worldX, int worldY, int upgradeStageCount, int currentUpgradeStage, BufferedImage[] upgradeStageImages) {
//        super(name, null, tileProperties, material, 0.0, tileSize, worldX, worldY);
        this.upgradeStageImages = upgradeStageImages;
        this.currentImage = upgradeStageImages[currentUpgradeStage];
        this.currentUpgradeStage = currentUpgradeStage;
        this.upgradeStageCount = upgradeStageCount;
    }

    public int getCurrentUpgradeStage() {
        return currentUpgradeStage;
    }

    public void setCurrentUpgradeStage(int currentUpgradeStage) {
        this.currentUpgradeStage = currentUpgradeStage;
    }

    public BufferedImage getCurrentImage() {
        return currentImage;
    }

    public BufferedImage[] getUpgradeStageImages() {
        return upgradeStageImages;
    }

    public int getUpgradeStageCount() {
        return upgradeStageCount;
    }
}
