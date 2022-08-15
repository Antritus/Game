package com.gmail.antcoreservices.games.laura.events.events.entityevent;

import com.gmail.antcoreservices.games.laura.damage.Damage;
import com.gmail.antcoreservices.games.laura.entity.livingentity.LivingEntity;

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
