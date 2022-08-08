package events.events.entityevent;

import entity.livingentity.LivingEntity;
import main.Location;

public class EntityMovementEvent extends EntityEvent{
    private Location newLocation, oldLocation;
    public EntityMovementEvent(LivingEntity eventPlayer, final Location oldLocation, final Location newLocation) {
        super(eventPlayer);
        this.newLocation = newLocation;
        this.oldLocation = oldLocation;
    }
    public Location getNewLocation(){
        return newLocation;
    }
    public Location getOldLocation() {
        return oldLocation;
    }
}
