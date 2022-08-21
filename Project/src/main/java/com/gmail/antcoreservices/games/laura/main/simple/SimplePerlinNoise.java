package com.gmail.antcoreservices.games.laura.main.simple;

import com.gmail.antcoreservices.games.laura.main.GamePanel;

import java.awt.*;

public class SimplePerlinNoise {
    SimpleGamePanel gp;
    public SimplePerlinNoise(SimpleGamePanel gp) {
        this.gp = gp;
    }
    public void draw(Graphics2D g2) {
        for(int i = 0; i < gp.getWidth()/16; i++) {
            for (int j = 0; j < gp.getHeight(); j++){
            }
        }
    }
}
