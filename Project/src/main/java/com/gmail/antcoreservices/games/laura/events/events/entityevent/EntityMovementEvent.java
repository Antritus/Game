package com.gmail.antcoreservices.games.laura.events.events.entityevent;

import com.gmail.antcoreservices.games.laura.entity.livingentity.LivingEntity;
import com.gmail.antcoreservices.games.laura.map.Location;

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
