package com.gmail.antcoreservices.games.laura.main.ui.menu;

import com.gmail.antcoreservices.games.laura.main.GamePanel;
import com.gmail.antcoreservices.games.laura.main.settings.ControlSettingAssignment;
import com.gmail.antcoreservices.games.laura.main.settings.ControlSettingTypes;
import com.gmail.antcoreservices.games.laura.main.ui.ButtonInfo;
import com.gmail.antcoreservices.games.laura.main.ui.Menu;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;


public class SettingsMenu extends Menu {

	public SettingsMenu(GamePanel gp) {
		setupScrollbar();
		this.gp = gp;
		arrowDown = gp.getImageUtility().setup("/objects/arrow/down.png", false, false, gp.getDefaultSettings().getTileSize()-6);
		arrowUp = gp.getImageUtility().setup("/objects/arrow/up.png", false, false, gp.getDefaultSettings().getTileSize()-6);
	}

	GamePanel gp;
	public boolean[] isResetting = new boolean[50];
	private int screenX, screenY;
	private double menuX, menuY, menuWidth, menuHeight = 999.0;
	private int menuScrollbarY = 50;
	private int menuScrollbarMaxY = 617;
	private int menuScrollbarMinY = 50;
	private int menuScrollHeight;

	private final void setupScrollbar() {
		menuScrollHeight = 617;
		menuX = screenX;
		menuY = 50;
	}
	private void setMenuY(double y) {
		menuY = menuY * y;
	}
	private double getPercentage(int max) {
		return max*0.1;
	}
	public void updateMenuScrollbarY(double amount){
		if (amount < 0) {
			menuScrollbarY -= menuScrollbarMaxY*0.05;
			if (menuScrollbarY < menuScrollbarMinY) {
				menuScrollbarY = menuScrollbarMinY;
			}
		}
		if (amount > 0) {
			menuScrollbarY += menuScrollbarMaxY*0.05;
			if (menuScrollbarY > menuScrollbarMaxY) {
				menuScrollbarY = menuScrollbarMaxY;
			}
		}
		System.out.println(menuScrollbarY);
	}

	private final Map<Integer, ControlSettingTypes> controlSettingTypes = new HashMap<>();
	public ControlSettingTypes getControlSettingType(int index) {
		return controlSettingTypes.get(index);
	}
	BufferedImage arrowUp;
	BufferedImage arrowDown;


	public void drawScrollbarBackround(Graphics2D g2, int x, int y, int width, int height){
		Color color = g2.getColor();
		g2.setColor(Color.BLACK);
		g2.fillRect(x, y, width, height);
		g2.setColor(color);
	}
	public void drawScrollbar(Graphics2D g2, int x, int y, int width, int height) {
		Color color = g2.getColor();
		g2.setColor(Color.GRAY);
		if (y > menuScrollbarMaxY) {
			y = menuScrollbarMaxY;
		}
		if (y < menuScrollbarMinY) {
			y = menuScrollbarMinY;
		}
		g2.fillRect(x, y, width, height);
		g2.setColor(color);
	}
	public void drawSettingsMenu(Graphics2D g2) {
		if (!gp.isDebuggingOn()) {
//			drawMenuBackround(gp, g2, 0, 0, gp.screenWidth, gp.screenHeight, true);
//			drawScrollbarBackround(g2, 830, 0, 12, gp.screenHeight);
//			drawMenuBackround(gp, g2, 0, -20, gp.screenWidth, gp.tileSize/3*4, false);
			drawMenuBackround(gp, g2, 0, -12, gp.getDefaultSettings().getScreenWidth(), gp.getDefaultSettings().getScreenHeight()+gp.getDefaultSettings().getTileSize(), false);
		}
//		drawScrollbar(g2, 830, menuScrollbarY, 12, 75);
		g2.setColor(Color.LIGHT_GRAY);
		int splitScreen = gp.getDefaultSettings().getScreenWidth()/5;
		if (gp.isDebuggingOn()) {
			Font font = g2.getFont();
			g2.setColor(Color.RED);
			g2.setFont(gp.debugFont);
//			g2.drawLine(830, 50, 830, 690);
//			g2.drawLine(842, 50, 842, 690);
//			g2.drawLine(splitScreen, 0, splitScreen, gp.screenHeight);
//			g2.drawLine(splitScreen * 4, 0, splitScreen * 4, gp.screenHeight);
			g2.drawLine(gp.getDefaultSettings().getScreenWidth() / 2, 0, gp.getDefaultSettings().getScreenWidth()/2, gp.getDefaultSettings().getScreenHeight());
			g2.setFont(font);
		}


		int width = gp.getDefaultSettings().getScreenWidth()/2;
		int y = 70;
		int  widthWButton = ButtonInfo.getButtonSize(gp, ButtonInfo.LARGE)[0]/2;
		drawButton(gp, g2, "Back", width-widthWButton, y, ButtonInfo.LARGE, 0);
		y += ButtonInfo.getButtonSize(gp, ButtonInfo.LARGE)[1]+5;
		drawButton(gp, g2, "Controls", width-widthWButton, y, ButtonInfo.LARGE, 1);
		y += ButtonInfo.getButtonSize(gp, ButtonInfo.LARGE)[1]+5;
		drawButton(gp, g2, "View Settings", width-widthWButton, y, ButtonInfo.LARGE, 2);
	}



	int currentlyChanging;

	public int getActionChangeInteger() {
		return currentlyChanging;
	}
	public void setActionChangeInteger(int index) {
		currentlyChanging = index;
	}
	public void setActionKey(int key, ControlSettingTypes controlSettingType, ControlSettingAssignment controlSettingAssignment) {
		for (int i = 0; i < 50; i++) {
			isResetting[i] = false;
		}
		gp.getControlSettings().setControlSettings(controlSettingType, controlSettingAssignment, key);
	}
}
