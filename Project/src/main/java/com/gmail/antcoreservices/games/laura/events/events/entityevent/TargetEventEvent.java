package com.gmail.antcoreservices.games.laura.events.events.entityevent;

import com.gmail.antcoreservices.games.laura.entity.Entity;
import com.gmail.antcoreservices.games.laura.entity.livingentity.LivingEntity;

public class TargetEventEvent extends EntityEvent{
    private Entity target;
    public TargetEventEvent(LivingEntity entity, final Entity target) {
        super(entity);
        this.target = target;
    }
    public Entity getTarget() {
        return target;
    }
}
