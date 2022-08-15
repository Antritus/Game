package com.gmail.antcoreservices.games.laura.events.events.entityevent;

import com.gmail.antcoreservices.games.laura.damage.Damage;
import com.gmail.antcoreservices.games.laura.entity.livingentity.LivingEntity;

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
