package com.gmail.antcoreservices.games.laura.entity.livingentity.humanentity.player.character;

public class CharacterAbility {
	private final String name;
	private final String description;
	private int cooldown;
	private int cooldownMax;


	public CharacterAbility(String name, String description, int cooldown, int cooldownMax) {
		this.name = name;
		this.description = description;
		this.cooldown = cooldown;
		this.cooldownMax = cooldownMax;
	}

	/**
	 * Returns the name of the ability
	 */
	public String getName() {
		return name;
	}
	/**
	 * Gets the description of the ability
	 */
	public String getDescription(){
		return description;
	}
	/**
	 * Gets the cooldown left of ability, returns 0 if no more cooldown
	 */
	public int getCooldown() {
		return cooldown;
	}
	/**
	 * Gets the maximum cooldown of ability
	 */
	public int getCooldownMax() {
		return cooldownMax;
	}
	/**
	 * Resets the cooldown to the max cooldown
	 */
	public void resetCooldown() {this.cooldown = cooldownMax;}
	/**
	 * Executes the ability of the child class, is blank in com.gmail.antcoreservices.games.laura.main class
	 */
	public void executeAbility() {}
	/**
	 * Sets the cooldown to integer (even above max cooldown) ( integer = seconds)
	 */
	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}
	/**
	 * Resets the cooldown to 0, meaning the cooldown is removed
	 */
	public void removeCooldown() {
		this.cooldown = 0;
	}
	/**
	 * Allows the change of maximum cooldown
	 */
	public void setCooldownMax(int cooldown) {
		cooldownMax = cooldown;
	}

}
