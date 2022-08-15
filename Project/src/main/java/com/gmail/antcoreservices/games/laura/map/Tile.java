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

	public Tile(TileMaterial tileMaterial, Biome biome){

	}
	public Tile(String tileNBT){

	}
	public Biome getBiome(){
		return new Biome(new int[]{10}, "");
	}

}
