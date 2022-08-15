package com.gmail.antcoreservices.games.laura.entity.livingentity.humanentity.player.character;

public class CharacterPassivePerk {
	private final String name;
	private final String description;

	public CharacterPassivePerk(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName(){
		return name;
	}
	public String getDescription() {
		return description;
	}

	public void execute(){}

}
