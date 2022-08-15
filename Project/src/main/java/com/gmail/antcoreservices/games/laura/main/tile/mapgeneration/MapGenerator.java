package com.gmail.antcoreservices.games.laura.main.tile.mapgeneration;

import com.gmail.antcoreservices.games.laura.main.GamePanel;

import java.util.Random;

public class MapGenerator {
	public static void main(String[] args){
		generateBiomeTile(50, 50);
	}
	private final GamePanel gp;
	public MapGenerator(String tileFormat, GamePanel gp){
		this.gp = gp;
	}

	public static void generateBiomeTile(int maxX, int maxY) {
		int tile;
		int prevTile = -100;
		int waterLength = 0;

		for (int y = 0; y < maxY; y++) {
			for (int x = 0; x < maxX; x++) {
				tile = 4;
				if (prevTile == 5){
					
				}
				System.out.print((new Random().nextInt(2)) + " ");
			}
			System.out.println();
		}

	}
}
