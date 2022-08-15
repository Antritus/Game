package com.gmail.antcoreservices.games.laura.events.events.entityevent;

import com.gmail.antcoreservices.games.laura.damage.Damage;
import com.gmail.antcoreservices.games.laura.entity.livingentity.LivingEntity;

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