package com.gmail.antcoreservices.games.laura.events.events.playerevent;

import com.gmail.antcoreservices.games.laura.entity.livingentity.humanentity.player.Player;

public class PlayerChatEvent extends PlayerEvent {
    private final String realMessage;
    private String message;

    public PlayerChatEvent(Player eventPlayer, final String realMessage) {
        super(eventPlayer);
        this.realMessage = realMessage;
        this.message = realMessage;
    }
}
