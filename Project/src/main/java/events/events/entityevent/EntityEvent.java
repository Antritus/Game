package events.events.entityevent;

import entity.livingentity.LivingEntity;

public class EntityEvent {
    protected LivingEntity entity;

    public EntityEvent(final LivingEntity entity) {
    }

    public final LivingEntity getEntity() {
        return entity;
    }

}
