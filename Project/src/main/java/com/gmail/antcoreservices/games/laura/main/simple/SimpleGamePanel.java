package com.gmail.antcoreservices.games.laura.main.simple;

import com.gmail.antcoreservices.games.laura.main.DefaultSettings;
import com.gmail.antcoreservices.games.laura.map.TileManager;

import javax.swing.*;
import java.awt.*;

public class SimpleGamePanel extends JPanel implements Runnable {


    // Fps (Movement update)
    int FPS = 60;
    // game time
    public double playTime = 0;

    TileManager tileM;
    private Thread gameThread;

    private DefaultSettings defaultSettings;
    public DefaultSettings getDefaultSettings() {
        return defaultSettings;
    }
    private final SimpleKeyHandler keyHandler;
    //private final ImageGallery imageGallery;
    public Thread getGameThread(){return gameThread;}
    //	public ImageGallery getImageGallery(){return imageGallery;}
    public SimpleKeyHandler getKeyHandler(){return keyHandler;}

    public SimpleGamePanel(DefaultSettings defaultSettings) {
        keyHandler = new SimpleKeyHandler(this);
        this.defaultSettings = defaultSettings;

        this.setPreferredSize(new Dimension(defaultSettings.getScreenWidth(), defaultSettings.getScreenHeight()));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
    }
    public void startFrameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) {
                FPS = drawCount;
                drawCount = 0;
                timer = 0;
            }
        }
    }
    public void update() {

    }
    public Font debugFont = new Font("Ariel", Font.PLAIN, 20);
    private long drawStart = 0;
    private long drawTime = 0;
    public long getDrawTime() {
        return drawTime;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;


    }

}
