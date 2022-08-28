package com.gmail.antcoreservices.games.laura.map.tile.types;

import com.gmail.antcoreservices.games.laura.map.tile.Tile;
import com.gmail.antcoreservices.games.laura.map.tile.TileMaterial;
import com.gmail.antcoreservices.games.laura.map.tile.TileTypes;

import java.awt.image.BufferedImage;

public class BreakableTile extends Tile {
    private final BufferedImage[] stages;
    private final double[] stageHealths;
    private final int stageCount;
    private int currentStage;
    /*
     * @param tileImage has 0 as the main image and others as stages.
     * Tile stages are set by the image count
     *
     */
    public BreakableTile(TileTypes[] tileTypes, TileMaterial material, BufferedImage[] tileImage, double health, double maxHealth, int toughness) {
        super(tileTypes, material, tileImage[0], health, maxHealth, toughness);
        stages = tileImage;
        stageCount = tileImage.length;
        stageHealths = new double[stageCount];
        currentStage = 0;
        final double hD = maxHealth/stageCount;
        double h = maxHealth-hD;
        if (stageCount == stages.length) {
            stageHealths[0] = 0;
        } else {
            for (int i = stageCount; i > 0; i--) {
                stageHealths[i] = h;
                h -= hD;
            }
        }
    }

    public void damageTile(double damage) {
        if (getTileProperties().isDestructible()){
            getTileProperties().setHealth(getTileProperties().getHealth() - damage);
            if (stageHealths[currentStage] > getTileProperties().getHealth()) {
                if (getTileProperties().getHealth() == 0) {
                    destroyTile();
                }
                nextStage();
            }
        }
    }
    private void nextStage() {
        this.currentStage += 1;
        updateTileImage(stages[currentStage]);
    }
}
