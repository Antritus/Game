package main.ui.menu;

import main.GamePanel;
import main.settings.ControlSettingAssignment;
import main.settings.ControlSettingTypes;
import main.ui.ButtonInfo;
import main.ui.Menu;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;


public class ControlSettingsMenu extends Menu {
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

	public ControlSettingsMenu(GamePanel gp) {
		setupScrollbar();
		this.gp = gp;
		arrowDown = gp.getImageUtility().setup("/objects/arrow/down.png", false, false, gp.tileSize-6);
		arrowUp = gp.getImageUtility().setup("/objects/arrow/up.png", false, false, gp.tileSize-6);
	}

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
	public void drawControlSettingsMenu(Graphics2D g2) {
		boolean drawSettings = true;
		if (!gp.isDebuggingOn()) {
			drawMenuBackround(gp, g2, 0, 0, gp.screenWidth, gp.screenHeight, true);
			drawScrollbarBackround(g2, 830, 0, 12, gp.screenHeight);
			drawMenuBackround(gp, g2, 0, -20, gp.screenWidth, gp.tileSize/3*4, false);
			drawMenuBackround(gp, g2, 0, 700, gp.screenWidth, 650, false);
		}
		drawScrollbar(g2, 830, menuScrollbarY, 12, 75);
		g2.setColor(Color.LIGHT_GRAY);
		int splitScreen = gp.screenWidth/5;
		int y = -20 + gp.tileSize/3*4-15;
		if (gp.isDebuggingOn()) {
			g2.setColor(Color.RED);
			g2.setFont(gp.debugFont);
			g2.drawLine(830, 50, 830, 690);
			g2.drawLine(842, 50, 842, 690);
			g2.drawLine(splitScreen, 0, splitScreen, gp.screenHeight);
			g2.drawLine(splitScreen * 4, 0, splitScreen * 4, gp.screenHeight);
			g2.drawLine(gp.screenWidth / 2, 0, gp.screenWidth/2, gp.screenHeight);
		}

		menuX = 0;
		menuY = 0;
		menuWidth = gp.screenWidth/5;
		menuHeight = gp.tileSize*12;

		//y = -20 + gp.tileSize/3*4-15;
		int width = gp.screenWidth/2;
		drawButton(gp, g2, "Done", width - ButtonInfo.getButtonSize(gp, ButtonInfo.SMALL)[0]-15, 710, ButtonInfo.SMALL, 250);
		drawButton(gp, g2, "Reset All", width + 15, 710, ButtonInfo.SMALL, 249);
//		drawButton(gp, g2, "Reset To Defaults", 10, 15+ ButtonInfo.getButtonSize(gp, ButtonInfo.SMALL)[1], ButtonInfo.SMALL, 249);
		drawButton(gp, g2, "", 880, y, ButtonInfo.EXTRA_EXTRA_SMALL, 248);
		y = ((700-gp.tileSize)-3);
		drawButton(gp, g2, "", 880, y, ButtonInfo.EXTRA_EXTRA_SMALL, 247);
		g2.drawImage(arrowUp, 882, 58, null);
		g2.drawImage(arrowDown, 882, 626, null);
		if (drawSettings) {
			int w = (int) (g2.getFontMetrics().getStringBounds("Movement Settings", g2).getWidth()/2);
			int h = (int) (g2.getFontMetrics().getStringBounds("Movement Settings", g2).getHeight()/2);
			g2.drawString("Movement Settings", (float) (gp.screenWidth/2 - w), (float) (60 + h));
			drawSetting(g2, "Move North", 255, 65+h, 1, ControlSettingTypes.MOVEMENT_NORTH);
			drawSetting(g2, "Move West", 255, 120+h, 2, ControlSettingTypes.MOVEMENT_WEST);
			drawSetting(g2, "Move South", 255, 175+h, 3, ControlSettingTypes.MOVEMENT_SOUTH);
			drawSetting(g2, "Move East", 255, 230+h, 4, ControlSettingTypes.MOVEMENT_EAST);

			w = (int) (g2.getFontMetrics().getStringBounds("Gameplay Controls", g2).getWidth()/2);
			h = (int) (g2.getFontMetrics().getStringBounds("Gameplay Controls", g2).getHeight()/2);
			g2.drawString("Gameplay Controls", (float) (gp.screenWidth/2 - w), (float) (310 + h));

			drawSetting(g2, "Attack", 255, 315+h, 5, ControlSettingTypes.ATTACK);
			drawSetting(g2, "Use Item", 255, 370+h, 6, ControlSettingTypes.USE_ITEM);
			drawSetting(g2, "Pickup Item", 255, 425+h, 7, ControlSettingTypes.PICKUP_ITEM);
			drawSetting(g2, "Interact NPC", 255, 480+h, 8, ControlSettingTypes.INTERACT_NPC);
		}
	}
	public void drawSettingMenu(Graphics2D g2, String name, int x, int y,  int settingIndex, ControlSettingTypes controlSettingType) {// Menu x, Menu y

		if (menuY < y && y < menuHeight) {
			return;
		}

		int splitScreen = gp.screenWidth / 5;
		int splitHeight = ButtonInfo.getButtonSize(gp, ButtonInfo.EXTRA_SMALL)[1]/3;

//		if (menuY < y) {
//			return;
//		}
		g2.setColor(Color.WHITE);
		g2.drawString(name, 205, (int) (y - (g2.getFontMetrics().getStringBounds(name, g2).getCenterY() * 3)));
		String keyName = KeyEvent.getKeyText(gp.getControlSettings().getAssignedKey(controlSettingType));
		if (gp.getControlSettings().getAssignedKeyType(controlSettingType) == ControlSettingAssignment.MOUSE) {
			keyName = gp.getControlSettings().translateMouseButton(gp.getControlSettings().getAssignedKey(controlSettingType));
		}
		int xCord = splitScreen * 4 - ButtonInfo.getButtonSize(gp, ButtonInfo.EXTRA_SMALL)[0] * 3 + (ButtonInfo.getButtonSize(gp, ButtonInfo.EXTRA_SMALL)[0] / 2) - 5;
		if (!isResetting[settingIndex]) {
			drawButton(gp, g2, keyName, xCord, y, ButtonInfo.SMALL, settingIndex);
		} else {
			drawButton(gp, g2, "", xCord, y, ButtonInfo.SMALL, settingIndex);
		}
		drawButton(gp, g2, "Reset", splitScreen * 4 - ButtonInfo.getButtonSize(gp, ButtonInfo.EXTRA_SMALL)[0], y, ButtonInfo.EXTRA_SMALL, settingIndex + 100);
		if (!controlSettingTypes.containsKey(controlSettingType)) {
			controlSettingTypes.put(settingIndex, controlSettingType);
		}
		final Font font = g2.getFont();
		if (gp.isDebuggingOn()) {
			g2.setColor(Color.RED);
			g2.setFont(gp.debugFont);
			g2.drawLine(splitScreen, 0, splitScreen, gp.screenHeight);
			g2.drawLine(splitScreen * 4, 0, splitScreen * 4, gp.screenHeight);
			g2.drawString("Default A: " + gp.getControlSettings().getDefaultAssignment(controlSettingType), splitScreen * 4, y+splitHeight);
			g2.drawString("Default K" + gp.getControlSettings().getDefaultControl(controlSettingType), splitScreen * 4, y+splitHeight*2);
		}
		g2.setFont(font);
	}
	public void drawSetting(Graphics2D g2, String name, int x, int y,  int settingIndex, ControlSettingTypes controlSettingType) {//
		int splitScreen = gp.screenWidth / 5;
		int splitHeight = ButtonInfo.getButtonSize(gp, ButtonInfo.EXTRA_SMALL)[1]/3;

//		if (menuY < y) {
//			return;
//		}
		g2.setColor(Color.WHITE);
		g2.drawString(name, 205, (int) (y - (g2.getFontMetrics().getStringBounds(name, g2).getCenterY() * 3)));
		String keyName = KeyEvent.getKeyText(gp.getControlSettings().getAssignedKey(controlSettingType));
		if (gp.getControlSettings().getAssignedKeyType(controlSettingType) == ControlSettingAssignment.MOUSE) {
			keyName = gp.getControlSettings().translateMouseButton(gp.getControlSettings().getAssignedKey(controlSettingType));
		}
		int xCord = splitScreen * 4 - ButtonInfo.getButtonSize(gp, ButtonInfo.EXTRA_SMALL)[0] * 3 + (ButtonInfo.getButtonSize(gp, ButtonInfo.EXTRA_SMALL)[0] / 2) - 5;
		if (!isResetting[settingIndex]) {
			drawButton(gp, g2, keyName, xCord, y, ButtonInfo.SMALL, settingIndex);
		} else {
			drawButton(gp, g2, "", xCord, y, ButtonInfo.SMALL, settingIndex);
		}
		drawButton(gp, g2, "Reset", splitScreen * 4 - ButtonInfo.getButtonSize(gp, ButtonInfo.EXTRA_SMALL)[0], y, ButtonInfo.EXTRA_SMALL, settingIndex + 100);
		if (!controlSettingTypes.containsKey(controlSettingType)) {
			controlSettingTypes.put(settingIndex, controlSettingType);
		}
		final Font font = g2.getFont();
		if (gp.isDebuggingOn()) {
			g2.setColor(Color.RED);
			g2.setFont(gp.debugFont);
			g2.drawLine(splitScreen, 0, splitScreen, gp.screenHeight);
			g2.drawLine(splitScreen * 4, 0, splitScreen * 4, gp.screenHeight);
			g2.drawString("Default A: " + gp.getControlSettings().getDefaultAssignment(controlSettingType), splitScreen * 4, y+splitHeight);
			g2.drawString("Default K" + gp.getControlSettings().getDefaultControl(controlSettingType), splitScreen * 4, y+splitHeight*2);
		}
		g2.setFont(font);
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
