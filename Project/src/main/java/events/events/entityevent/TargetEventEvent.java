package events.events.entityevent;

import entity.Entity;
import entity.livingentity.LivingEntity;

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
