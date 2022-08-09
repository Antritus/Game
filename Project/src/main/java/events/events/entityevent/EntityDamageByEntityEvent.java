package events.events.entityevent;

import damage.Damage;
import entity.livingentity.LivingEntity;

public class EntityDamageByEntityEvent extends EntityDamageEvent{
    private LivingEntity attacker;
    public EntityDamageByEntityEvent(LivingEntity entity, final LivingEntity attacker, final Damage damage) {
        super(entity, damage);
        this.attacker = attacker;
    }
    public LivingEntity getAttacker() {
        return attacker;
    }
}