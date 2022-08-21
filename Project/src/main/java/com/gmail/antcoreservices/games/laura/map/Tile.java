package com.gmail.antcoreservices.games.laura.map;

import com.gmail.antcoreservices.games.laura.main.tile.TileMaterial;
import com.gmail.antcoreservices.games.laura.main.tile.mapgeneration.Biome;

import java.awt.image.BufferedImage;

public class Tile {

	public enum CollisionType {
		NONE,
		LIQUID,
		BLOCKER,
		OBJECT,
		NPC,
		PLAYER,
	}
	public BufferedImage image;
	public boolean collision = false;
	public boolean liquid = false;
	public boolean solid = false;
	private String name = null;
	public Tile(String name) {
		this.name = name;
	}
	public Tile(TileMaterial tileMaterial, Biome biome){

	}
	public String getName(){
		return name;
	}
	public Biome getBiome(){
		return new Biome(new int[]{10}, "");
	}

}
