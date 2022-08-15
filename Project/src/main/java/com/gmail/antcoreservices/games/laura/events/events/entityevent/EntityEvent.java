package com.gmail.antcoreservices.games.laura.events.events.entityevent;

import com.gmail.antcoreservices.games.laura.entity.livingentity.LivingEntity;

public class EntityEvent {
    protected LivingEntity entity;

    public EntityEvent(final LivingEntity entity) {
    }

    public final LivingEntity getEntity() {
        return entity;
    }

}
