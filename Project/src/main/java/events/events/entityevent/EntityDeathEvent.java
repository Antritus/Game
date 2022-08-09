package events.events.entityevent;

import damage.Damage;
import damage.DamageCause;
import entity.livingentity.LivingEntity;

public class EntityDeathEvent extends EntityEvent {
    private Damage lastDamage;
    public EntityDeathEvent(LivingEntity entity, final Damage latestDamage) {
        super(entity);
        this.lastDamage = latestDamage;
    }

    public Damage getLastDamage() {
        return lastDamage;
    }
}
