package com.gmail.antcoreservices.games.laura.map;

import com.gmail.antcoreservices.games.laura.main.DefaultSettings;
import com.gmail.antcoreservices.games.laura.main.GamePanel;
import com.gmail.antcoreservices.games.laura.util.ImageUtility;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class TileManager {

	GamePanel gp;
	ImageUtility imageUtility;
	public Tile[] tile;
	public int mapTileNumber[][];
	private BufferedImage[][] mapTile;

	public int[][] getMapTileNumber() {
		return mapTileNumber;
	}

	public TileManager(GamePanel gp){
		this.gp = gp;
		this.imageUtility = new ImageUtility(gp);
		tile = new Tile[1000];
//		mapTile = new BufferedImage[gp.getDefaultSettings().getMaxWorldCol()][gp.getDefaultSettings().getMaxWorldRow()];
		mapTile = new BufferedImage[5000][5000];
//		TileManager tileManager = new TileManager(new GamePanel(new DefaultSettings()));
		loadImageMap("/mapimage/generatedMap1", 10);


//		mapTileNumber = new int[gp.getDefaultSettings().getMaxWorldCol()][gp.getDefaultSettings().getMaxWorldRow()];

		getTileImage();

		loadMap("map_dev_random_generation/random_map_debug_01");


		loadWater();
	}
	public boolean isSolid(int tile) {
		return this.tile[tile].collision;
	}
	public boolean isLiquid(int tile) {
		return this.tile[tile].liquid;
	}
	public void getTileImage() {
		setup(0, "water/water", false, true);
		setup(1, "water/water", false, true);
		setup(2, "water/water", false, true);
		setup(3, "sand", false, true);
		setup(4, "grass", false, true);
		setup(5, "grass", false, false);
		setup(6, "dirt", false, false);
		setup(7, "grass", false, false);
		setup(8, "sand", false, false);
		setup(9, "tree", false, false);
		setup(10, "water/water", false, true);
		setup(11, "water/water", false, true);
		setup(12, "water/water", false, true);
		setup(999, "water/water", false, true);



	}
	public void setup(int i, String image, boolean collision, boolean liquid) {
		try {
			String location = "/tiles/";
			tile[i] = new Tile(image);
			tile[i].image = ImageIO.read(getClass().getResourceAsStream(location + image + ".png"));
			tile[i].image = imageUtility.scale(tile[i].image, gp.getDefaultSettings().getTileSize(), gp.getDefaultSettings().getTileSize());
			tile[i].liquid = liquid;
			tile[i].collision = collision;
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	public BufferedImage setupWater(String image) {
		try {
			String location = "/tiles/water/";
			BufferedImage returnImage;
			returnImage = ImageIO.read(getClass().getResourceAsStream(location + image + ".png"));
			returnImage = imageUtility.scale(returnImage, gp.getDefaultSettings().getTileSize(), gp.getDefaultSettings().getTileSize());
			return returnImage;
		}catch (IOException e){
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] a) {
		TileManager tileManager = new TileManager(new GamePanel(new DefaultSettings()));
		tileManager.loadImageMap("/mapimage/generatedMap1", 10);
	}
	public void loadImageMap(String map, int pixelSize) {
		System.out.println(" 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0");
		try {
			BufferedImage imBuff = ImageIO.read(getClass().getResourceAsStream("/maps/" + map + ".png"));
			int col = 0;
			int row = 0;
			mapTileNumber = new int[imBuff.getHeight()/pixelSize][imBuff.getWidth()/pixelSize];
			mapTileNumber = new int[9999][9999];
			ArrayList<Integer> v = new ArrayList<>();
			HashMap<Integer, ArrayList<Integer>> values = new HashMap<>();
			int maxCol = imBuff.getWidth();
//			maxCol /= pixelSize;
			int maxRow = imBuff.getHeight();
//			maxRow /= pixelSize;
			gp.getDefaultSettings().setMaxWorldCol(30005/10);
			gp.getDefaultSettings().setMaxWorldRow(30006/10);
			System.out.printf("LOADING MAP: %s, PIXELS W: %s2, PIXEL H: %s3, PIXEL S: %s4, PIXEL W/SIZE: %s5, PIXEL H/SIZE: %s6", map, maxCol, maxRow, pixelSize, maxCol, maxRow);
			System.out.println("");
			while (col < maxCol && row < maxRow){
				while (col<maxCol) {
					System.out.println(row + "" + col);
					Color c = new Color(imBuff.getRGB(col, row));
					int tileID;
					if (c.equals(new Color(1, 38, 119))){//Deep Ocean
						tileID = 1;
					}else if (c.equals(new Color(0, 91, 197))){//Ocean
						tileID = 2;
					}else if (c.equals(new Color(0, 180, 252))){//Sea
						tileID = 3;
					}else if (c.equals(new Color(175, 209, 62))){//Beach
						tileID = 4;
					}else if (c.equals(new Color(113, 174, 78))){//Plain
						tileID = 5;
					}else if (c.equals(new Color(113, 134, 78))){//Forest
						tileID = 6;
					}else if (c.equals(new Color(62, 102, 23))){//Deep Forest
						tileID = 7;
					}else if (c.equals(new Color(166, 140, 105))){//Hills
						tileID = 8;
					}else if (c.equals(new Color(168, 149, 143))){//Cliffs
						tileID = 9;
					}else if (c.equals(new Color(150, 129, 122))){//Mountains
						tileID = 10;
					}else if (c.equals(new Color(84, 106, 107))){//High Mountains
						tileID = 11;
					}else if (c.equals(new Color(44, 97, 89))){//Icy Mountain
						tileID = 12;
					}else if (c.equals(Color.WHITE)){//Ice
						tileID = 13;
					}else { //null
						tileID = 999;
					}
					v.add(tileID);
					mapTileNumber[col/pixelSize][row/pixelSize] = tileID;
//					mapTileNumber[row/][col] = tileID;
					col+=pixelSize;
				}
				System.out.println(row - 10 + "" + v);
				if (row/pixelSize <= -1) {
					values.put(0, v);
				} else {
					values.put(row/pixelSize, v);
				}
				v.clear();
				col = 0;
				row+=pixelSize;
			}
			System.out.println(values.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(map);
	}

	public void loadMap(String map) {
		if (true) {
			return;
		}
		try {
			InputStream is = getClass().getResourceAsStream("/maps/" + map + ".txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			int col = 0;
			int row = 0;
			while (col < gp.getDefaultSettings().getMaxScreenCol() && row < gp.getDefaultSettings().getMaxWorldRow()){
				String line = br.readLine();
				while (col<gp.getDefaultSettings().getMaxScreenCol()) {
					String numbers[] = line.split(" ");

					int num = Integer.parseInt(numbers[col]);
					mapTileNumber[col][row] = num;
					col++;
				}
				if (col == gp.getDefaultSettings().getMaxScreenCol()) {
					col = 0;
					row++;
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void loadWater() { // Doesn't seem to work drawing debug tile when not supposed to draw..?
		if (true) {
			return;
		}
		int worldCol = 0;
		int worldRow = 0;
		while (worldCol < gp.getDefaultSettings().getMaxWorldCol() && worldRow < gp.getDefaultSettings().getMaxWorldRow()) {
			int tileNum = mapTileNumber[worldCol][worldRow];
			if (tile[tileNum].liquid) {
				boolean up, down, right, left;
				up = false;
				down = false;
				left = false;
				right = false;
				if (worldRow - 1 >= 0) {
					int tileNumUp = mapTileNumber[worldCol][worldRow - 1];
					up = tile[tileNumUp].liquid;
				}
				if (worldRow + 1 < gp.getDefaultSettings().getMaxWorldRow()) {
					int tileNumDown = mapTileNumber[worldCol][worldRow + 1];
					down = tile[tileNumDown].liquid;
				}if (worldCol + 1 < gp.getDefaultSettings().getMaxWorldCol()){
					int tileNumRight = mapTileNumber[worldCol +1 ][worldRow];
					right = tile[tileNumRight].liquid;
				} if (worldCol - 1 >= 0) {
					int tileNumLeft = mapTileNumber[worldCol - 1][worldRow];
					left = tile[tileNumLeft].liquid;
				}
				System.out.println("\nTile Col: " + worldCol + "Tile Row: " + worldRow + "\nUp: " + up + " Down: " + down + " Right: " + right + " Left: " + left);
				String value = (up + " "+ down + " " + right + " "+ left);
				System.out.println(value);
//				if (up == true) {
//					tile[tileNum].image = setupWater("/debug/up");
//				}
			}
			worldCol++;
			if (worldCol == gp.getDefaultSettings().getMaxWorldCol()) {
				worldCol = 0;
				worldRow++;
			}
		}
	}
	public void drawWorld(Graphics2D g2) {
		int worldCol = 0;
		int worldRow = 0;

		while (worldCol < gp.getDefaultSettings().getMaxWorldCol() && worldRow < gp.getDefaultSettings().getMaxWorldRow()) {

			int tileNum = mapTileNumber[worldCol][worldRow];
				int worldX = worldCol * gp.getDefaultSettings().getTileSize();
				int worldY = worldRow * gp.getDefaultSettings().getTileSize();
				int screenX = worldX - gp.player.getX() + gp.player.screenX;
				int screenY = worldY - gp.player.getY() + gp.player.screenY;
				if (worldX + gp.getDefaultSettings().getTileSize()> gp.player.getX() - gp.player.screenX &&
						worldX - gp.getDefaultSettings().getTileSize()< gp.player.getX() + gp.player.screenX &&
						worldY + gp.getDefaultSettings().getTileSize()> gp.player.getY() - gp.player.screenY &&
						worldY - gp.getDefaultSettings().getTileSize()< gp.player.getY() + gp.player.screenY) {
					g2.drawImage(tile[tileNum].image, screenX, screenY, null);
//					System.out.println(tile[tileNum].getName() + " | " + tileNum);
//					System.out.println(worldCol + " | " + worldRow);
				}
				worldCol++;
			if (worldCol == gp.getDefaultSettings().getMaxWorldCol()) {
				worldCol = 0;
				worldRow++;
			}

		}
	}
	public void drawMap(Graphics2D g2) { // smaller maps only, the size of players screen
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		while (col < gp.getDefaultSettings().getMaxScreenCol() && row < gp.getDefaultSettings().getMaxScreenCol()) {
			int tileNum = mapTileNumber[col][row];
			g2.drawImage(tile[tileNum].image, x, y, null);
			col++;
			x += gp.getDefaultSettings().getTileSize();
			if (col == gp.getDefaultSettings().getMaxScreenCol()) {
				col = 0;
				x = 0;
				row++;
				y += gp.getDefaultSettings().getTileSize();
			}
		}
	}
}
