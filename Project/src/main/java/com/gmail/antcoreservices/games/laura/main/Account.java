package com.gmail.antcoreservices.games.laura.main;

import java.util.UUID;

public class Account {
	private final String name;
	private final int level;
	private final UUID uuid;

	public Account(String name, int level, UUID uuid) {
		this.name = name;
		this.level = level;
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public UUID getUuid() {
		return uuid;
	}

	public int getLevel() {
		return level;
	}
}
