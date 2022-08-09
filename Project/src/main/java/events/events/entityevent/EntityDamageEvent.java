package events.events.entityevent;

import damage.Damage;
import entity.livingentity.LivingEntity;

public class EntityDamageEvent extends EntityEvent{
    private Damage damage;
    public EntityDamageEvent(LivingEntity entity, final Damage damage) {
        super(entity);
        this.damage = damage;
    }

    public Damage getDamage() {
        return damage;
    }
}
