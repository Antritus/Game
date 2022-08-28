package com.gmail.antcoreservices.games.laura.main.ui.menu;

import com.gmail.antcoreservices.games.laura.main.GamePanel;
import com.gmail.antcoreservices.games.laura.main.ui.ButtonInfo;
import com.gmail.antcoreservices.games.laura.main.ui.Menu;
import com.gmail.antcoreservices.games.laura.main.ui.menu.slots.MainMenuSlot;

import java.awt.*;

public class MainMenu extends Menu {
	private final GamePanel gp;
	public MainMenuSlot mainMenuSlot;
	public MainMenu(GamePanel gp) {
		this.gp = gp;

	}
	public void drawMainMenu(Graphics2D g2) {
		g2.setColor(Color.gray);
		drawMenuBackround(gp, g2);



		int textLength;
		int x;
		int y;

		String text = gp.getDefaultSettings().getName();

		textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();

		x = gp.getDefaultSettings().getScreenWidth() / 2 - textLength / 2;
		y = 150;
		g2.setColor(Color.DARK_GRAY);
		g2.setColor(new Color(42, 0, 0));
		g2.drawString(text, x + 4, y + 4);
		g2.setColor(new Color(170, 0, 0));
		g2.drawString(text, x, y);

		x = gp.getDefaultSettings().getScreenWidth() / 2 - 450;
		y = gp.getDefaultSettings().getScreenHeight() / 2 - 30;
		y = gp.getDefaultSettings().getScreenHeight();
		int h = 80;
		drawButton(gp, g2, "Quit", 40, y-h, ButtonInfo.MEDIUM,3);
		drawButton(gp, g2, "Settings", 40, y-(h)-70, ButtonInfo.MEDIUM,2);
		drawButton(gp, g2, "Load Game", 40, y-(h)-70*2, ButtonInfo.MEDIUM,1);
		drawButton(gp, g2, "New Game", 40, y-(h)-70*3, ButtonInfo.MEDIUM,0);
		g2.setColor(Color.RED);
		drawButton(gp, g2, "Network test #Debug#Error", gp.getDefaultSettings().getScreenWidth()-40-ButtonInfo.getButtonSize(gp, ButtonInfo.EXTRA_LARGE)[0], y-h, ButtonInfo.EXTRA_LARGE,998);


		/*
		x = gp.getDefaultSettings().getScreenWidth() - 270;
		y = 85;
		int width = gp.getDefaultSettings().getScreenWidth() - x+20;
		int height = 50;
		g2.setColor(Color.BLACK);
		Color color = (new Color(0, 0, 0,210));
		g2.setColor(color);
		g2.fillRoundRect(x, y, width, height, 5, 5);
		color = new Color(255, 255, 255);
		g2.setColor(color);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x+1, y+1, width-2, height-2, 5, 5);
		g2.drawImage(gp.player.getCharacterClass().getClassIcon(), x+(270-gp.player.getCharacterClass().getClassIcon().getWidth()), y+4, null);
		g2.setFont(g2.getFont().deriveFont(25f));
		text = gp.account.getName() + " " + "(" + gp.account.getLevel() + ")";
		g2.drawString(text, x+7 ,y+24);
		g2.setFont(g2.getFont().deriveFont(20f));
		text = "Class: " + gp.player.getCharacterClass().getCharacterClassName() + " " + gp.player.getLevel();
		g2.drawString(text, x+7 ,y+40);

		 */

//		if ((!gp.keyHandler.hasMouseMoved() && mainMenuSlot == MainMenuSlot.NEW_GAME) || (gp.keyHandler.hasMouseMoved() && gp.keyHandler.isInsideRectangle(x, y - height, width, height))) {
//
//			g2.drawString(">", x-gp.tileSize/2, y);
//			mainMenuSlot = MainMenuSlot.NEW_GAME;
//		}
	}
	public MainMenuSlot getMainMenuSlot(int i){
		if (i == 0) {
			return MainMenuSlot.NEW_GAME;
		}
		if (i == 1) {
			return MainMenuSlot.LOAD_GAME;
		}
		if (i == 2) {
			return MainMenuSlot.SETTINGS;
		}
		if (i == 3) {
			return MainMenuSlot.QUIT;
		}
		return MainMenuSlot.NEW_GAME;
	}
	public int getMainMenuSlot(MainMenuSlot mainMenuSlot){
		if (mainMenuSlot == MainMenuSlot.NEW_GAME) {
			return 0;
		}
		if (mainMenuSlot == MainMenuSlot.LOAD_GAME) {
			return 1;
		}
		if (mainMenuSlot == MainMenuSlot.SETTINGS) {
			return 2;
		}
		if (mainMenuSlot == MainMenuSlot.QUIT) {
			return 3;
		}
		return 0;
	}
	public MainMenuSlot getMainMenuSlot() {
		return mainMenuSlot;
	}

	public void setMainMenuSlot(MainMenuSlot mainMenuSlot) {
		this.mainMenuSlot = mainMenuSlot;
	}

}
