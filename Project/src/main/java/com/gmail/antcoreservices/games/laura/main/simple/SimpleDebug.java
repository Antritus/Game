package com.gmail.antcoreservices.games.laura.main.simple;

import com.gmail.antcoreservices.games.laura.util.panelextenions.ACAlert;

import java.awt.*;
import java.util.ArrayList;

public class SimpleDebug {
    SimpleGamePanel gp;
    ACAlert acAlert = new ACAlert();
    public SimpleDebug(SimpleGamePanel gp) {
        this.gp = gp;
    }

    public void drawDebug(Graphics2D g2) {
        Color color = g2.getColor();
        g2.setColor(Color.RED);
        g2.setFont(gp.debugFont);
        ArrayList<String> list = new ArrayList<>();
        list.add("Drawing Time: " + gp.getDrawTime());
        list.add("FPS: " + gp.FPS);
        list.add("");
        list.add("SIMPLE_GAME_PANEL_ENABLED");
        int x = 5;
        int y = 20;
        int add = 20;
        for (String v : list) {
            g2.drawString(v, x, y);
            y+=add;
        }
        g2.setColor(color);

    }
}
