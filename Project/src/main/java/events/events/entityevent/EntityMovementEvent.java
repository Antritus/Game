package events.events.entityevent;

import entity.livingentity.LivingEntity;
import main.Location;

public class EntityMovementEvent extends EntityEvent{
    private Location newLocation, oldLocation;
    public EntityMovementEvent(LivingEntity entity, final Location oldLocation, final Location newLocation) {
        super(entity);
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
