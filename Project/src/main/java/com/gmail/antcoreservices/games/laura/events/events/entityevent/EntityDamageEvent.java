package com.gmail.antcoreservices.games.laura.events.events.entityevent;

import com.gmail.antcoreservices.games.laura.damage.Damage;
import com.gmail.antcoreservices.games.laura.entity.livingentity.LivingEntity;

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
