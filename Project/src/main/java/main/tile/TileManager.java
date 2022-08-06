package main.tile;

import main.GamePanel;
import util.ImageUtility;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
		tile = new Tile[101];
		mapTile = new BufferedImage[gp.maxWorldCol][gp.maxWorldRow];

		mapTileNumber = new int[gp.maxWorldCol][gp.maxWorldRow];

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
		setup(0, "brick", false, false);
		setup(1, "dirt", false, false);
		setup(2, "grass", false, false);
		setup(3, "sand", false, false);
		setup(4, "tree", false, false);
		setup(5, "water/water", false, true);

	}
	public void setup(int i, String image, boolean collision, boolean liquid) {
		try {
			String location = "/tiles/";
			tile[i] = new Tile("");
			tile[i].image = ImageIO.read(getClass().getResourceAsStream(location + image + ".png"));
			tile[i].image = imageUtility.scale(tile[i].image, gp.tileSize, gp.tileSize);
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
			returnImage = imageUtility.scale(returnImage, gp.tileSize, gp.tileSize);
			return returnImage;
		}catch (IOException e){
			e.printStackTrace();
		}
		return null;
	}
	public void loadMap(String map) {
		try {
			InputStream is = getClass().getResourceAsStream("/maps/" + map + ".txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			int col = 0;
			int row = 0;
			while (col < gp.maxWorldCol && row < gp.maxWorldRow){
				String line = br.readLine();
				while (col<gp.maxWorldCol) {
					String numbers[] = line.split(" ");

					int num = Integer.parseInt(numbers[col]);
					mapTileNumber[col][row] = num;
					col++;
				}
				if (col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void loadWater() { // Doesnt seem to work drawing debug tile when not supposed to draw..?
		int worldCol = 0;
		int worldRow = 0;
		while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
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
				if (worldRow + 1 < gp.maxWorldRow) {
					int tileNumDown = mapTileNumber[worldCol][worldRow + 1];
					down = tile[tileNumDown].liquid;
				}if (worldCol + 1 < gp.maxWorldCol){
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
			if (worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow++;
			}
		}
	}
	public void drawWorld(Graphics2D g2) {

		int worldCol = 0;
		int worldRow = 0;

		while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

			int tileNum = mapTileNumber[worldCol][worldRow];

			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
					int screenX = worldX - gp.player.getX() + gp.player.screenX;
					int screenY = worldY - gp.player.getY() + gp.player.screenY;
					if (worldX + gp.tileSize> gp.player.getX() - gp.player.screenX &&
							worldX - gp.tileSize< gp.player.getX() + gp.player.screenX &&
							worldY + gp.tileSize> gp.player.getY() - gp.player.screenY &&
							worldY - gp.tileSize< gp.player.getY() + gp.player.screenY) {
						g2.drawImage(tile[tileNum].image, screenX, screenY, null);
			}			worldCol++;
			if (worldCol == gp.maxWorldCol) {
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
		while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
			int tileNum = mapTileNumber[col][row];
			g2.drawImage(tile[tileNum].image, x, y, null);
			col++;
			x += gp.tileSize;
			if (col == gp.maxScreenCol) {
				col = 0;
				x = 0;
				row++;
				y += gp.tileSize;
			}
		}
	}
}
