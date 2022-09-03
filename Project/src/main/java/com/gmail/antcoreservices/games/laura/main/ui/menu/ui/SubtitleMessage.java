package com.gmail.antcoreservices.games.laura.main.ui.menu.ui;

public class SubtitleMessage{

    public SubtitleMessage(String message, String subtitleMessage, boolean isVisible, int fadeInTime, int fadeOutTime, int stayTime) {
        setValues(message, subtitleMessage, isVisible, fadeInTime, fadeOutTime, stayTime);
    }
    public SubtitleMessage(String message, String subtitleMessage, int fadeInTime, int fadeOutTime, int stayTime) {
        setValues(message, subtitleMessage, true, fadeInTime, fadeOutTime, stayTime);
    }
    public SubtitleMessage(String message, boolean isVisible, int fadeInTime, int fadeOutTime, int stayTime) {
        setValues(message, null, isVisible, fadeInTime, fadeOutTime, stayTime);

    }
    public SubtitleMessage(String message, int fadeInTime, int fadeOutTime, int stayTime) {
        setValues(message, null, true, fadeInTime, fadeOutTime, stayTime);

    }
    public SubtitleMessage(String message, boolean isVisible, int stayTime) {
        setValues(message, null, isVisible, 1, 1, stayTime);
    }
    public SubtitleMessage(String message, int stayTime) {
        setValues(message, null, true, 1, 1, stayTime);
    }
    public SubtitleMessage(String message, boolean isVisible) {
        setValues(message, null, true, 1, 1, 1);
    }
    public SubtitleMessage(String message, String subtitle, boolean isVisible) {
        setValues(message, subtitle, isVisible, 1, 1, 1);
    }
    public SubtitleMessage(String message, String subtitle) {
        setValues(message, subtitle, true, 1, 1, 1);
    }
    public SubtitleMessage(String message) {
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
}
