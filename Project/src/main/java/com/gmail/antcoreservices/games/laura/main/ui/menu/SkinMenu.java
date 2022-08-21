package com.gmail.antcoreservices.games.laura.main.ui.menu;

import com.gmail.antcoreservices.games.laura.map.location.Direction;
import com.gmail.antcoreservices.games.laura.main.GamePanel;
import com.gmail.antcoreservices.games.laura.main.ui.menu.slots.SkinMenuSlot;
import com.gmail.antcoreservices.games.laura.util.ImageUtility;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SkinMenu {
	private SkinMenuSlot skinMenuSlot;
	private GamePanel gp;
	ImageUtility skinSystem;
	public SkinMenu(GamePanel gp) {
		this.gp = gp;
		skinSystem = new ImageUtility(gp);
		skinMenuSlot = SkinMenuSlot.MAIN_MENU;
		getPlayerImage();
	}

	public void setup() {
		this.skinMenuSlot = SkinMenuSlot.MAIN_MENU;
		setup();
	}
	public Object getSkinMenuSlot(boolean index) {
		if (index) {
			return skinMenuSlot.ordinal();
		}
		return skinMenuSlot;
	}

	public SkinMenuSlot getSkinMenuSlot(int index) {
		if (index == -1) {
			index = SkinMenuSlot.values().length;
		}
		for (SkinMenuSlot slot : SkinMenuSlot.values()) {
			if (slot.ordinal() == index) {
				return slot;
			}
		}
		return SkinMenuSlot.MAIN_MENU;
	}

	public void setSkinMenuSlot(int index) {
		if (index > 5) {
			index = 0;
		} else if (index < 0) {

			index = 5;
		}
		for (SkinMenuSlot slot : SkinMenuSlot.values()) {
			if (slot.ordinal() == index) {
				skinMenuSlot = slot;
			}
		}
	}
	private BufferedImage up1, up2, down1, down2, right1, right2, left1, left2;
	public void getPlayerImage() {
		String sex = "_boy";
//		if (this.isGirl()) {
//			sex = "_girl";
//		}
	}
	private Direction direction = Direction.NORTH;
	private BufferedImage image = up1;
	private int changeModelTime = 0;
	private int getSpriteNum = 1;
	public BufferedImage getSkin(){
		BufferedImage image = null;
		switch (this.direction) {
			case NORTH_WEST:
			case NORTH_EAST:
			case NORTH:
				if (this.getSpriteNum() == 1) {
					getSpriteNum++;
					image = up1;
				} else {
					image = up2;
					getSpriteNum--;
				}
				break;
			case SOUTH_EAST:
			case SOUTH_WEST:
			case SOUTH:
				if (this.getSpriteNum() == 1) {
					getSpriteNum++;
					image = down1;
				} else {
					image = down2;
					getSpriteNum--;
				}
				break;
			case WEST:
				if (this.getSpriteNum() == 1) {
					getSpriteNum++;
					image = left1;
				} else {
					image = left2;
					getSpriteNum--;
				}
				break;

			case EAST:
				if (this.getSpriteNum() == 1) {
					getSpriteNum++;
					image = right1;
				} else {
					getSpriteNum--;
					image = right2;
				}
				break;
		}
		return image;
	}
	public int r = 0;
	public int b = 0;
	public int g = 0;
	public void drawSkinMenu(Graphics2D g2) {
		g2.setColor(Color.gray);
		g2.fillRect(0, 0, gp.getDefaultSettings().getScreenWidth(), gp.getDefaultSettings().getScreenHeight());

		int x;
		int y;


		int xPic = gp.getDefaultSettings().getScreenWidth() / 2 + 50;
		int yPic = gp.getDefaultSettings().getScreenHeight() / 2 - 200;

		changeModelTime++;
		if (changeModelTime == 120) {
			image = getSkin();
			changeModelTime = 0;
		}

		String text = "Skin Selection";
		x = gp.getDefaultSettings().getScreenWidth() / 2 - 500;
		y = gp.getDefaultSettings().getScreenHeight() / 2 - 200;
		g2.setColor(Color.DARK_GRAY);
		g2.setColor(new Color(42, 0, 0));
		g2.drawString(text, x + 2, y + 2);
		g2.setColor(new Color(170, 0, 0));
		g2.drawString(text, x, y);

		text = "Main Menu";
		x = gp.getDefaultSettings().getScreenWidth() / 2 - 450;
		y = gp.getDefaultSettings().getScreenHeight() / 2 - 30;
		g2.drawString(text, x, y);
		if (skinMenuSlot.ordinal() == 0) {
			g2.drawString(">", x-gp.getDefaultSettings().getTileSize()/2, y);
		}
		g2.setColor(Color.BLACK);
		int width = gp.getDefaultSettings().getTileSize()/2;
		int height = gp.getDefaultSettings().getTileSize()/2;
		y += 90;
		g2.fillRect(x, y, width*3, height);
		g2.setColor(Color.WHITE);
		g2.fillRect(x+5, y+5, width-10, height-10);
		g2.fillRect(x+5+(width*2), y+5, width-10, height-10);
		g2.fillRect(x+5+(width), y+5, width-10, height-10);
		g2.setColor(Color.GRAY);
		g2.fillRect(x+5, y+12, width-10, height-24);
		g2.fillRect(x+12, y+5, width-24, height-10);
//		g2.fillRect(x+(width*2)+12, y+5, width-24, height-10);
		g2.fillRect(x+(width*2)+5, y+12, width-10, height-24);
	}

	public int getSpriteNum() {
		return getSpriteNum;
	}
}
