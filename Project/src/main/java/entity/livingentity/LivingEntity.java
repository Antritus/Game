package entity.livingentity;

import damage.Damage;
import damage.DamageCause;
import damage.DamageElement;
import entity.Entity;
import entity.EntityType;
import main.Direction;
import main.GamePanel;
import org.jetbrains.annotations.NotNull;
import main.tile.Tile;

import java.awt.*;
import java.util.ArrayList;

public abstract class LivingEntity extends Entity {

	protected double fov;// = 90.0; // fov is split to by 2 so it counts from 90.0 to 45.0, due to needing -45.0 angle and +45.0 angle
	protected double fovLength = 75; // length of pixels
	protected double health = 100.0;
	protected double maxHealth = 100.0;
	protected double healthPercentage = 1.0;
	protected double armor = 0.0; // Goes up to 100 / 100
	protected double fireResistance = 0.0; // Add more ice resistance if more fire resistance?
	protected double iceResistance = 0.0;

	protected boolean isInvincible = false;

	protected int damageCooldown;

	protected int attackCooldown;

	protected int level = 0;
	protected int experience = 0;
	protected int experienceBooster = 0;

	protected ArrayList<DamageElement> resistances = new ArrayList<>();

	private DamageCause lastDamageCause;
	private Damage lastDamage;
	private LivingEntity lastAttacker;

	private GamePanel gp;
	
	public LivingEntity(GamePanel gp) {
		super(gp);
		this.gp = gp;
	}


	public double getHealthPercentage() {
		return healthPercentage;
	}
	public double getHealth() {return health;}
	public double getMaxHealth() {
		return maxHealth;
	}
	public void setHealth(double health) {this.health = health;}
	public void setMaxHealth(double maxHealth) {this.maxHealth = maxHealth;}
	public void updateHealthPercentage() {
		healthPercentage = health/maxHealth;
	}

	protected void onDamageReceive(boolean cancelled, Damage damage, LivingEntity attacker) {
		if (cancelled) {
			return;
		}
		if (isInvincible) {
			return;
		}

		lastDamage = damage;
		lastDamageCause = damage.getCause();

		health -= calculateDamage(damage).getDamage();
		damageCooldown = 10;
		if (health <= 0) {
//			attacker.onKill(false, attacker, damage);
//			onDeath(false, attacker, damage);
		}
	}

	private Damage calculateDamage(@NotNull Damage damage) {
		if (damage.isDamageTrue()) {
			return damage;
		}
		damage.addLevelDamageBoost();
		DamageElement element = damage.getElement();
		if (element == DamageElement.NORMAL_ELEMENT) {
			if (armor > damage.getDamage()) {
				damage.setDamage(0);
			}
			damage.setDamage(damage.getDamage() * (1.0-armor/100.0));
		} else if (element == DamageElement.ARMOR_PIERCING_ELEMENT) {
			damage.setDamage((damage.getDamage() * (1.0-(armor-10)/100.0))*0.80);
			if (resistances != null) {
				if (resistances.contains(DamageElement.ARMOR_PIERCING_ELEMENT)) {
					damage.setDamage(0);
				}
			}
		} if (element == DamageElement.FIRE_ELEMENT) {
			damage.setDamage(damage.getDamage() * (1.0-fireResistance/100.0));
			if (resistances != null) {
				if (resistances.contains(DamageElement.FIRE_ELEMENT)) {
					damage.setDamage(0);
				}
			}
		}  else if (element == DamageElement.ICE_ELEMENT) {
			damage.setDamage((damage.getDamage() * (1.0-(iceResistance-10)/100.0))*0.80);
			if (resistances != null) {
				if (resistances.contains(DamageElement.ICE_ELEMENT)) {
					damage.setDamage(0);
				}
			}
		}
		return damage;
	}

	public void receiveDamage(LivingEntity lastAttacker, Damage damage) { // (attacker, damage amount)
		onDamageReceive(false, damage, lastAttacker);
	}
	public void receiveDamage(LivingEntity lastAttacker, Damage damage, boolean trueDamage) { // (attacker, damage amount)
		if (damageCooldown > 0) {
			return;
		}

		if (lastAttacker.getType() == EntityType.PLAYER) {
			if (getType() == EntityType.PLAYER){
				lastDamageCause = DamageCause.PLAYER_DAMAGE_PLAYER;
			} else{
				lastDamageCause = DamageCause.PLAYER_DAMAGE_ENTITY;
			}
		} else {
			if (getType() == EntityType.PLAYER) {
				lastDamageCause = DamageCause.ENTITY_DAMAGE_PLAYER;
			} else {
				lastDamageCause = DamageCause.ENTITY_DAMAGE_ENTITY;
			}
		}

		// Calculate armor and such before damaging
		damage.setLevel(lastAttacker.getLevel());
		damage.addLevelDamageBoost();
		this.lastAttacker = lastAttacker;

		if (trueDamage) {
			onDamageReceive(false, damage, lastAttacker);
			if (!isInvincible) {
				lastDamage = damage;
			}
		} else {
			onDamageReceive(false, damage, lastAttacker);
		}
	}
	protected void receiveDamage(Damage damage) {
		receiveDamage(null, damage, false);
	}
	public void receiveDamage(Damage damage, boolean ignoreResistances) {
		receiveDamage(null, damage, ignoreResistances);
	}

	public void attack(LivingEntity livingEntity, double damage, DamageElement element, boolean trueDamage){
		if (attackCooldown > 0) {
			return;
		}

		DamageCause cause = null;
		if (getType() == EntityType.PLAYER) {
			if (livingEntity.getType() == EntityType.PLAYER) {
				cause = DamageCause.PLAYER_DAMAGE_PLAYER;
			} else {
				cause = DamageCause.PLAYER_DAMAGE_ENTITY;
			}
		} else {
			if (livingEntity.getType() == EntityType.PLAYER){
				cause = DamageCause.ENTITY_DAMAGE_PLAYER;
			} else {
				cause = DamageCause.PLAYER_DAMAGE_ENTITY;
			}
		}
		livingEntity.receiveDamage(this, new Damage(
				damage, element, cause, this.level, 0, false), trueDamage);
	}
	public void attack(LivingEntity livingEntity, double damage, DamageElement element){
		attack(livingEntity, damage, element, false);
	}
	public void attack(LivingEntity victim, double damage, boolean trueDamage){
		attack(victim, damage, null, trueDamage);
	}
	public void attack(LivingEntity livingEntity, double damage){
		attack(livingEntity, damage, null, false);
	}



	public int getLevel() {
		return level;
	}
	public int getExperience() {
		return experience;
	}
	public int getExperienceBooster() {
		return experienceBooster;
	}

	public void move(Direction direction, int amount) {
		if (direction == Direction.SOUTH_EAST ||
				direction == Direction.SOUTH_WEST ||
				direction == Direction.NORTH_EAST ||
				direction == Direction.NORTH_WEST) {
			return;
		}
		if (direction == Direction.NORTH) {
			this.setY(getY() - amount);
			this.setIsMoving(true);
		}
		if (direction == Direction.SOUTH) {
			this.setY(getY() + amount);
			this.setIsMoving(true);
		}
		if (direction == Direction.WEST) {
			this.setX(getX() - amount);
			this.setIsMoving(true);
		}
		if (direction == Direction.EAST) {
			this.setX(getX() + amount);
			this.setIsMoving(true);
		}
	}

	public void updateCollisions(Direction direction) {
		if (!isColliding(direction, Tile.CollisionType.BLOCKER)) {
			setCollidingTile(true);
		}
		if (!isColliding(direction, Tile.CollisionType.NPC)) {
			setCollidingNPC(true);
		}
		if (!isColliding(direction, Tile.CollisionType.OBJECT)) {
			setCollidingObject(true);
		}
		if (!isColliding(direction, Tile.CollisionType.PLAYER)) {
			setCollidingPlayer(true);
		}
	}

	public void move(int amount, boolean multiInputMovement) {
		if (multiInputMovement) {
			if (getDirection() == Direction.NORTH_EAST || getDirection() == Direction.NORTH_WEST) {
				if (isColliding(Direction.NORTH, Tile.CollisionType.BLOCKER) && isColliding(Direction.NORTH, Tile.CollisionType.NPC) &&
						isColliding(Direction.NORTH, Tile.CollisionType.OBJECT) && isColliding(Direction.NORTH, Tile.CollisionType.PLAYER)) {
					this.setCollidingTile(false);
					this.setCollidingPlayer(false);
					this.setCollidingNPC(false);
					this.setCollidingObject(false);

					move(Direction.NORTH, amount/2);
				} else {
					updateCollisions(Direction.NORTH);
				}
				Direction directionNew = null;
				if (getDirection() == Direction.NORTH_WEST) {
					directionNew = Direction.EAST;
				}
				if (getDirection() == Direction.NORTH_EAST) {
					directionNew = Direction.WEST;
				}
				if (isColliding(directionNew, Tile.CollisionType.BLOCKER) &&
						isColliding(directionNew, Tile.CollisionType.NPC) &&
						isColliding(directionNew, Tile.CollisionType.OBJECT)
						&& isColliding(directionNew, Tile.CollisionType.PLAYER)) {
					this.setCollidingTile(false);
					this.setCollidingPlayer(false);
					this.setCollidingNPC(false);
					this.setCollidingObject(false);

					move(directionNew, amount/2);
				} else {
					updateCollisions(directionNew);
				}

			}
			if (getDirection() == Direction.SOUTH_EAST || getDirection() == Direction.SOUTH_WEST) {
				if (isColliding(Direction.SOUTH, Tile.CollisionType.BLOCKER) && isColliding(Direction.SOUTH, Tile.CollisionType.NPC) &&
						isColliding(Direction.SOUTH, Tile.CollisionType.OBJECT) && isColliding(Direction.SOUTH, Tile.CollisionType.PLAYER)) {
					this.setCollidingTile(false);
					this.setCollidingPlayer(false);
					this.setCollidingNPC(false);
					this.setCollidingObject(false);

					move(Direction.SOUTH, amount/2);
				} else {
					updateCollisions(Direction.SOUTH);
				}
				Direction directionNew = null;
				if (getDirection() == Direction.SOUTH_WEST) {
					directionNew = Direction.EAST;
				}
				if (getDirection() == Direction.SOUTH_EAST) {
					directionNew = Direction.WEST;
				}
				if (isColliding(directionNew, Tile.CollisionType.BLOCKER) &&
						isColliding(directionNew, Tile.CollisionType.NPC) &&
						isColliding(directionNew, Tile.CollisionType.OBJECT)
						&& isColliding(directionNew, Tile.CollisionType.PLAYER)) {
					this.setCollidingTile(false);
					this.setCollidingPlayer(false);
					this.setCollidingNPC(false);
					this.setCollidingObject(false);
					move(directionNew, amount/2);
				} else {
					updateCollisions(directionNew);
				}
			}
		}
		if (isColliding(getDirection(), Tile.CollisionType.BLOCKER) && isColliding(getDirection(), Tile.CollisionType.NPC) &&
				isColliding(getDirection(), Tile.CollisionType.OBJECT) && isColliding(getDirection(), Tile.CollisionType.PLAYER)) {
			this.setCollidingTile(false);
			this.setCollidingPlayer(false);
			this.setCollidingNPC(false);
			this.setCollidingObject(false);
			move(getDirection(), amount);
		} else {
			updateCollisions(getDirection());
		}
	}

	public int getAttackCooldown() {
		return attackCooldown;
	}

	public void setAttackCooldown(int attackCooldown) {
		this.attackCooldown = attackCooldown;
	}
	public void superClasses(){
		if (damageCooldown > 0) {
			damageCooldown-=1;
		}
	}
	public void update() {
		superClasses();
	}

	public void setFieldOfView(double fov){
		this.fov = fov;
	}
	public double getFieldOfView() {
		return fov;
	}
	public void setFOV(double fov){
		this.fov = fov;
	}
	public double getFOV() {
		return fov;
	}

	public void getLengthOfFieldOfView(double fov){
		this.fov = fov;
	}
	public double getFieldOfViewLength() {
		return fov;
	}
	public void setFOVLength(double fov){
		this.fov = fov;
	}
	public double getFOVLength() {
		return fov;
	}

	public void drawFOV(Graphics2D g2) {
	}

}
