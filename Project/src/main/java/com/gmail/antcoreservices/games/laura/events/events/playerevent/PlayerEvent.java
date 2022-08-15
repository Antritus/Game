package com.gmail.antcoreservices.games.laura.events.events.playerevent;

import com.gmail.antcoreservices.games.laura.entity.livingentity.humanentity.player.Player;
import com.gmail.antcoreservices.games.laura.events.event.Event;

public class PlayerEvent extends Event {
    protected Player player;

    public PlayerEvent(final Player eventPlayer) {
    }

    public final Player getPlayer() {
        return player;
    }
}
