package com.gmail.antcoreservices.games.laura.main.ui.menu.ui;

import java.awt.*;

public class TitleMessage {
    private int stayTime = 0;
    private int fadeInTime = 0;
    private int fadeOutTime = 0;
    private String message;
    private SubtitleMessage subtitleMessage;
    private boolean isVisible;

    public TitleMessage(String message, String subtitleMessage, boolean isVisible, int fadeInTime, int fadeOutTime, int stayTime) {
        setValues(message, subtitleMessage, isVisible, fadeInTime, fadeOutTime, stayTime);
    }
    public TitleMessage(String message, String subtitleMessage, int fadeInTime, int fadeOutTime, int stayTime) {
        setValues(message, subtitleMessage, true, fadeInTime, fadeOutTime, stayTime);
    }
    public TitleMessage(String message, boolean isVisible, int fadeInTime, int fadeOutTime, int stayTime) {
        setValues(message, null, isVisible, fadeInTime, fadeOutTime, stayTime);

    }
    public TitleMessage(String message, int fadeInTime, int fadeOutTime, int stayTime) {
        setValues(message, null, true, fadeInTime, fadeOutTime, stayTime);

    }
    public TitleMessage(String message, boolean isVisible, int stayTime) {
        setValues(message, null, isVisible, 1, 1, stayTime);
    }
    public TitleMessage(String message, int stayTime) {
        setValues(message, null, true, 1, 1, stayTime);
    }
    public TitleMessage(String message, boolean isVisible) {
        setValues(message, null, true, 1, 1, 1);
    }
    public TitleMessage(String message, String subtitle, boolean isVisible) {
        setValues(message, subtitle, isVisible, 1, 1, 1);
    }
    public TitleMessage(String message, String subtitle) {
        setValues(message, subtitle, true, 1, 1, 1);
    }
    public TitleMessage(String message) {
        setValues(message, null, true, 1, 1, 1);
    }

    private final void setValues(String message, String subtitleMessage, boolean isVisible, int fadeInTime, int fadeOutTime, int stayTime) { // times = seconds!
        this.stayTime = stayTime;
        this.fadeInTime = fadeInTime;
        this.fadeOutTime = fadeOutTime;
        this.message = message;
        this.subtitleMessage = new SubtitleMessage(subtitleMessage);
        this.isVisible = isVisible;
    }

    public void drawTitle(Graphics2D g2) {
        if (titleOn) {
            g2.setFont(titleFont);
            g2.setColor(Color.RED);

            int textLength;
            int x;
            int y;

            textLength = (int) g2.getFontMetrics().getStringBounds(title, g2).getWidth();

            x = gp.getDefaultSettings().getScreenWidth() / 2 - textLength / 2;
            y = gp.getDefaultSettings().getScreenHeight() / 2 - 80;
            g2.drawString(title, x, y);
            titleTimer--;
            if (titleTimer == 0) {
                titleOn = false;
            }
            g2.setFont(arial_40);
        }
        if (subtitleOn) {
            g2.setFont(subtitleFont);
            g2.setColor(Color.RED);

            int textLength;
            int x;
            int y;

            textLength = (int) g2.getFontMetrics().getStringBounds(subtitle, g2).getWidth();

            x = gp.getDefaultSettings().getScreenWidth() / 2 - textLength / 2;
            y = gp.getDefaultSettings().getScreenHeight() / 2 - 50;
            g2.drawString(subtitle, x, y);
            subtitleTimer--;
            if (subtitleTimer == 0) {
                subtitleOn = false;
            }
            g2.setFont(arial_40);
        }
    }
}
