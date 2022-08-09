package events.events.entityevent;

import damage.Damage;
import entity.livingentity.LivingEntity;

public class EntityDeathToEntityEvent extends EntityDeathEvent{
    private LivingEntity attacker;
    public EntityDeathToEntityEvent(LivingEntity entity, final LivingEntity attacker, Damage latestDamage) {
        super(entity, latestDamage);
        this.entity = attacker;
    }
    public LivingEntity getAttacker() {
        return attacker;
    }
}
