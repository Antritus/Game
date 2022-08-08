package events.events;

import entity.livingentity.humanentity.player.Player;
import events.event.Event;

public class PlayerEvent extends Event {
    protected Player player;

    public PlayerEvent(final Player eventPlayer) {
    }

    public final Player getPlayer() {
        return player;
    }
}
