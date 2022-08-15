package com.gmail.antcoreservices.games.laura.main.ui.menu;

import com.gmail.antcoreservices.games.laura.main.GamePanel;
import com.gmail.antcoreservices.games.laura.main.ui.ButtonInfo;
import com.gmail.antcoreservices.games.laura.main.ui.Menu;
import com.gmail.antcoreservices.games.laura.main.ui.menu.slots.PauseMenuSlot;

import java.awt.*;

public class PauseMenu extends Menu {
	private final GamePanel gp;
	public PauseMenuSlot pauseMenuSlot;
	public PauseMenu(GamePanel gp) {
		this.gp = gp;
	}
	public void drawPauseMenu(Graphics2D g2) {
		g2.setColor(Color.gray);
		drawMenuBackround(gp, g2);



		int x = gp.getDefaultSettings().getScreenWidth() / 2 - ButtonInfo.getButtonSize(gp, ButtonInfo.MEDIUM)[0]/2;
		int y = gp.getDefaultSettings().getScreenHeight() / 2 - 200;
		g2.setColor(Color.WHITE);
		drawButton(gp, g2, "Continue", x, y, ButtonInfo.MEDIUM,0);
		drawButton(gp, g2, "Settings", x, y+70, ButtonInfo.MEDIUM,1);
		drawButton(gp, g2, "Save", x, y+(70*2), ButtonInfo.MEDIUM,2);
		drawButton(gp, g2, "Save & Quit", x, y+(70*2), ButtonInfo.MEDIUM,2);
//		if ((!gp.keyHandler.hasMouseMoved() && pauseMenuSlot == PauseMenuSlot.NEW_GAME) || (gp.keyHandler.hasMouseMoved() && gp.keyHandler.isInsideRectangle(x, y - height, width, height))) {
//
//			g2.drawString(">", x-gp.tileSize/2, y);
//			pauseMenuSlot = PauseMenuSlot.NEW_GAME;
//		}
	}
	public PauseMenuSlot getPauseMenuSlot(int i){
		if (i == 0) {
			return PauseMenuSlot.CONTINUE;
		}
		if (i == 1) {
			return PauseMenuSlot.SETTINGS;
		}
		if (i == 2) {
			return PauseMenuSlot.QUIT;
		}
		if (i < 0){
			return PauseMenuSlot.QUIT;
		} if (i > 3) {
			return PauseMenuSlot.CONTINUE;
		}
		return PauseMenuSlot.CONTINUE;
	}
	public int getPauseMenuSlot(PauseMenuSlot pauseMenuSlot){
		if (pauseMenuSlot == PauseMenuSlot.CONTINUE) {
			return 0;
		}
		if (pauseMenuSlot == PauseMenuSlot.SETTINGS) {
			return 1;
		}
		if (pauseMenuSlot == PauseMenuSlot.QUIT) {
			return 2;
		}
		return 0;
	}

	public PauseMenuSlot getPauseMenuSlot() {
		return pauseMenuSlot;
	}

	public void setPauseMenuSlot(PauseMenuSlot pauseMenuSlot) {
		this.pauseMenuSlot = pauseMenuSlot;
	}
}