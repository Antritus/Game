package com.gmail.antcoreservices.games.laura.damage;

import com.gmail.antcoreservices.games.laura.entity.livingentity.LivingEntity;

public class Damage {
	private final double trueDamage;
	private final DamageElement element;
	private final DamageCause cause;

	private double damage;
	private double level;
	private double levelBoost;

	private boolean damageTrue;

	private final LivingEntity entity;

	public Damage(double trueDamage, DamageElement element, DamageCause cause, boolean dealTrueDamage) {
		this.trueDamage = trueDamage;
		this.damage = trueDamage;
		this.element = element;
		this.cause = cause;
		this.level = -999;
		this.levelBoost = -999;
		this.damageTrue = dealTrueDamage;
		this.entity = null;
	}
	public Damage(LivingEntity entity, double trueDamage, DamageElement element, DamageCause cause, int level, double levelBoost, boolean damageTrue) {
		this.trueDamage = trueDamage;
		this.damage = trueDamage;
		this.element = element;
		this.cause = cause;
		this.level = level;
		this.levelBoost = levelBoost;
		this.damageTrue = damageTrue;
		this.entity = entity;
	}
	public Damage(double trueDamage, DamageElement element, DamageCause cause, int level, double levelBoost, boolean damageTrue) {
		this.trueDamage = trueDamage;
		this.damage = trueDamage;
		this.element = element;
		this.cause = cause;
		this.level = level;
		this.levelBoost = levelBoost;
		this.damageTrue = damageTrue;
		this.entity = null;
	}

	public boolean isDamageTrue() {
		return damageTrue;
	}
	public double getDamage() {
		if (damageTrue) {
			return trueDamage;
		}
		return damage;
	}
	public DamageCause getCause() {
		if (cause == null) {
			return DamageCause.UNKNOWN;
		}
		return cause;
	}
	public DamageElement getElement() {
		if (element == null) {
			return DamageElement.NORMAL_ELEMENT;
		}
		return element;
	}
	public void setLevelBoost(double levelBoost) {
		this.levelBoost = levelBoost;
	}
	public double getLevelBoost(){
		return levelBoost;
	}
	public double getTrueDamage() {
		return trueDamage;
	}

	public void setDamage(double damage) {
		this.damage = damage;
	}
	public void addDamage(double damage) {
		this.damage = this.damage + damage;
	}
	public void removeDamage(double damage) {
		this.damage = this.damage - damage;
	}

	public void setLevel(double level) {
		this.level = level;
	}



	public void addLevelDamageBoost() {
		if (level == 0){
			return;
		}
		if (levelBoost == 0) {
			return;
		}
		damage = damage * (level * levelBoost);
	}


	public LivingEntity getEntity() {
		return entity;
	}
}
