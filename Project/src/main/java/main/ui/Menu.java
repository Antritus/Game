package main.ui;

import main.GamePanel;
import main.settings.ControlSettingAssignment;
import main.settings.ControlSettingTypes;
import util.ImageUtility;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Menu {


	boolean setup = false;
	BufferedImage image = null;
	BufferedImage imageDark = null;
	ImageUtility imageUtility;
	GamePanel gp;
	public void setup(GamePanel gp) {
		if (!setup) {
			imageUtility = new ImageUtility(gp);
			this.gp = gp;
			String location = "/tiles/";
			image = imageUtility.setup(location+"brick.png", false, false);
			imageDark = imageUtility.setup(location+"brick_dark.png", false, false);
			setup = true;
		}
	}
	public void drawButton(GamePanel gp, Graphics2D g2, String button, int x, int y, ButtonInfo size, int currentSlot){
		Color color = g2.getColor();
		setup(gp);
		g2.setColor(Color.WHITE);
		g2.getFont().deriveFont(29f);
		int width = ButtonInfo.getButtonSize(gp, size)[0];
		int height = ButtonInfo.getButtonSize(gp, size)[1];

		UISystem.setSolidArea(currentSlot, new Rectangle(x, y, width, height));
		int centerX = (int) g2.getFontMetrics().getStringBounds(button, g2).getWidth()/2;
		int centerY = (int) ((g2.getFontMetrics().getStringBounds(button, g2).getHeight())/5)*4;
		if (gp.getKeyHandler().hasMouseMoved() && gp.getKeyHandler().isInsideRectangle(x, y, width, height) || !gp.getKeyHandler().hasMouseMoved() && gp.getUISystem().getCurrentSlotIndex() == currentSlot){// || gp.ui.getCurrentSlotIndex() == currentSlot) {
			g2.setColor(Color.RED);
			if (gp.getKeyHandler().hasMouseMoved() && gp.getKeyHandler().isInRectangle()) {
				gp.getUISystem().setCurrentSlotIndex(currentSlot);
			}
		}
		g2.fillRoundRect(x, y, width, height, 22, 22);
//		g2.drawRoundRect(x+3,y+3, width-6, height-6, 22, 22);
		g2.setColor(Color.DARK_GRAY);
		g2.fillRoundRect(x+3,y+3, width-7, height-7, 22, 22);
//		int center = (int) (g2.getFontMetrics().getStringBounds(button, g2).getWidth()/2);
//		center = (width-center);
		g2.setColor(Color.WHITE);
		g2.drawString(button, x+(width/2-centerX), y+centerY);
		g2.setColor(color);
	}
	String lastMenu = "None";
	public void buttonAction(GamePanel gp, int actionIndex){
		if (UISystem.getSolidArea(actionIndex) != null && !gp.getKeyHandler().isInsideRectangle(UISystem.getSolidArea(actionIndex).x, UISystem.getSolidArea(actionIndex).y, UISystem.getSolidArea(actionIndex).width, UISystem.getSolidArea(actionIndex).height)){
			return;
		}
		if (gp.getGameState() == gp.getMainMenuState()){
			if (actionIndex == 0) {
				gp.setGameState(gp.getPlayState());
				//todo: start new save and save it (save games and load)
			}
			if (actionIndex == 1) {
				//todo: load saved games (save games and load)
			}
			if (actionIndex == 2) {
				gp.setGameState(gp.getSettingsMenuState());
				lastMenu = "MainMenu";
			}
			if (actionIndex == 3) {
				System.exit(0);
			}
		} else if (gp.getGameState() == gp.getPauseState()) {
			if (actionIndex == 0) {
				gp.setGameState(gp.getPlayState());
			}
			if (actionIndex == 1) {
				gp.setGameState(gp.getSettingsMenuState());
				lastMenu = "PauseMenu";
			}
			if (actionIndex == 2) {
				// todo: save and quit to main menu (save game)
				gp.setGameState(gp.getMainMenuState());
			}
		}else if (gp.getGameState() == gp.getSettingsMenuState()){
			if (actionIndex == 0) {
				if (lastMenu == "MainMenu"){
					gp.setGameState(gp.getMainMenuState());
				} else if (lastMenu == "PauseMenu") {
					gp.setGameState(gp.getPauseState());
				}
			}
			if (actionIndex == 1) {
				gp.setGameState(gp.getControlSettingsMenuState());
			}
			if (actionIndex == 2) {
				//todo: open settings to change scale of window
			}
		}else if (gp.getGameState() == gp.getControlSettingsMenuState()) {
			if (actionIndex == 250) {
				gp.setGameState(gp.getSettingsMenuState());
			} else if (actionIndex == 249) {
				gp.getControlSettings().resetControls();
			} else if (actionIndex == 248) {
				//todo: add scroll to up
			} else if (actionIndex == 247) {
				//todo: add scroll to down
			}
			else if (actionIndex - 100 > -1){
				ControlSettingAssignment assignment = gp.getControlSettings().getAssignedKeyType(gp.getUISystem().getControlSettingsMenu().getControlSettingType(actionIndex-100));
				ControlSettingTypes type = gp.getUISystem().getControlSettingsMenu().getControlSettingType(actionIndex-100);
				gp.getControlSettings().resetAssignedKey(type);
//				gp.ui.getControlSettingsMenu().setActionKey(actionIndex-100, type, gp.controlSettings.getDefaultAssignment(type));
			} else{
				gp.getUISystem().getControlSettingsMenu().setActionChangeInteger(actionIndex);
				gp.getUISystem().getControlSettingsMenu().isResetting[actionIndex] = true;
			}
		}
	}
	public void drawMenuBackround(GamePanel gp, Graphics2D g2, int x, int y, int width, int height, boolean dark) {
		setup(gp);
		int col = 0;
		int row = 0;
		int maxCol = width/gp.getDefaultSettings().getTileSize();
		int maxRow = height/gp.getDefaultSettings().getTileSize();
		final int startX = x;
		final int startY = y;
		while (col < maxCol && row < maxRow) {

			if (dark) {
				g2.drawImage(imageDark, x, y, null);
			} else{
				g2.drawImage(image, x, y, null);
			}
			col++;


			if (col == maxCol) {
				y += gp.getDefaultSettings().getTileSize();
				row++;
				col = 0;
			}
			x = (col * gp.getDefaultSettings().getTileSize());

		}
	}

	public void drawMenuBackround(GamePanel gp, Graphics2D g2) {
		setup(gp);
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		while (col < gp.getDefaultSettings().getMaxScreenCol() && row < gp.getDefaultSettings().getMaxScreenCol()) {

			g2.drawImage(image, x, y, null);
			col++;


			if (col == gp.getDefaultSettings().getMaxScreenCol()) {
				y += gp.getDefaultSettings().getTileSize();
				row++;
				col = 0;
			}
			x = (col * gp.getDefaultSettings().getTileSize());

		}
	}

	public void drawTooltip(String title, String tooltip, Graphics2D g2, int x, int y) {
		StringBuilder builder = new StringBuilder();
		StringBuilder noSpacesBuilder = new StringBuilder();
		for (String word : tooltip.split(" ")){
			noSpacesBuilder.append(word);
			if (noSpacesBuilder.length() > 25) {
				builder.append("\n"+word);
			} else {
				builder.append(" ").append(word);
			}
		}
	}




}
