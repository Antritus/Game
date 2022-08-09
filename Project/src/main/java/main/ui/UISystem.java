package main.ui;

import main.GamePanel;
import main.ui.menu.*;
import main.ui.menu.ControlSettingsMenu;

import java.awt.*;
import java.text.DecimalFormat;

public class UISystem {
	GamePanel gp;
	Font arial_40;
	Font messageFont;
	Font titleFont;
	Font subtitleFont;
	Font centeredTextFont;


	private int currentSlotIndex = 0;
	private int currentSlotMaxIndex = 0;

	private int messageTimer;
	private int titleTimer;
	private int subtitleTimer;
	private int centeredTextTimer;
	private boolean messageOn = false;
	public boolean gameFinished = false;
	private boolean centeredTextOn = false;
	private boolean subtitleOn = false;
	private boolean titleOn = false;
	private String currentDialog = "";
	private String message = "";
	private String centeredText = "";
	private String title = "";
	private String subtitle = "";
	private Graphics2D g2;

	private final MainMenu mainMenu;
	private final SkinMenu skinMenu;
	private final CharacterMenu characterMenu;
	private final GameUI gameUI;
	private final MouseCursorLocation mouseCursorLocation;
	private final PauseMenu pauseMenu;
	private final SettingsMenu settingsMenu;
	private final ControlSettingsMenu controlSettingsMenu;

	private static final Rectangle[] solidArea = new Rectangle[999];


	public static Rectangle[] getSolidArea() {
		return UISystem.solidArea;
	}
	public static Rectangle getSolidArea(int solidArea) {
		return UISystem.solidArea[solidArea];
	}
	public static void setSolidArea(int solidArea, Rectangle rectangle) {
		UISystem.solidArea[solidArea] = rectangle;
	}


	DecimalFormat decimalFormat = new DecimalFormat("#0.00");

	//	BufferedImage keyImage;
	public UISystem(GamePanel gp) {
		this.gp = gp;
		//OBJ_Key key = new OBJ_Key();
		//keyImage = key.getImage();

		this.arial_40 = new Font("Arial", Font.PLAIN, 40);
		this.messageFont = new Font("Ariel", Font.PLAIN, 30);
		this.centeredTextFont = new Font("Arial", Font.BOLD, 60);
		this.titleFont = new Font("Arial", Font.BOLD, 60);
		this.subtitleFont = new Font("Arial", Font.BOLD, 40);
		mainMenu = new MainMenu(gp);
		skinMenu = new SkinMenu(gp);
		characterMenu = new CharacterMenu(gp);
		gameUI = new GameUI(gp);
		mouseCursorLocation = new MouseCursorLocation(gp);
		pauseMenu = new PauseMenu(gp);
		settingsMenu = new SettingsMenu(gp);
		controlSettingsMenu = new ControlSettingsMenu(gp);

//		sendCenteredText("Game Over", 60*2);


	}

	public void sendTitle(String title, String subtitle, int time) {
		this.title = title;
		this.subtitle = subtitle;
		this.titleTimer = time;
		this.subtitleTimer = time;
		this.titleOn = true;
		this.subtitleOn = true;
	}

	public void deleteTitle(boolean subtitle) {
		this.titleOn = false;
		this.title = "";
		this.titleTimer = 0;
		if (subtitle) {
			this.subtitle = "";
			this.subtitleOn = false;
			this.subtitleTimer = 0;
		}
	}

	public void sendCenteredText(String message, int centeredTextTimer) {
		deleteTitle(true);
		this.centeredTextOn = true;
		this.centeredText = message;
		this.centeredTextTimer = titleTimer;
	}

	public void draw(Graphics2D g2) {
		mouseCursorLocation.draw(g2);
		this.g2 = g2;
		drawMessage(g2);
		drawTitle(g2);
		drawCenteredMessage(g2);
		g2.setFont(arial_40);
		g2.setColor(Color.WHITE);
		if (gp.getGameState() == gp.getPlayState()) {

			gp.playTime += (double) 1 / 60;
			gameUI.draw(g2);
		} if (gp.getGameState() == gp.getPauseState()) {
			pauseMenu.drawPauseMenu(g2);
			currentSlotMaxIndex = 2;
		} if (gp.getGameState() == gp.getSettingsMenuState()) {
//			controlSettingsMenu.drawControlSettingsMenu(g2);
			settingsMenu.drawSettingsMenu(g2);
//			currentSlotMaxIndex = 10;
		} if (gp.getGameState() == gp.getControlSettingsMenuState()) {
			controlSettingsMenu.drawControlSettingsMenu(g2);
		} if (gp.getGameState() == gp.getMainMenuState()) {
			mainMenu.drawMainMenu(g2);
			currentSlotMaxIndex = 3;
		} if (gp.getGameState() == gp.getSkinMenuState()) {
			skinMenu.drawSkinMenu(g2);
		} if (gp.getGameState() == gp.getDialogState()) {
			drawDialogScreen();
			return;
		}
		g2.setFont(arial_40);
		g2.setColor(Color.white);
	}
	public void drawDialogScreen() {
		int x = gp.getDefaultSettings().getTileSize()*2;
		int y = gp.getDefaultSettings().getTileSize();
		int width = gp.getDefaultSettings().getScreenWidth() - (gp.getDefaultSettings().getTileSize() * 4);
		int height = gp.getDefaultSettings().getScreenHeight() - (gp.getDefaultSettings().getTileSize() * (9));
		drawDialogWindow(x, y, width, height);
		x += gp.getDefaultSettings().getTileSize();
		y += gp.getDefaultSettings().getTileSize();

		for (String dialogMessage : currentDialog.split("\n")) {
			if (dialogMessage == null) {
				continue;
			}
			if (dialogMessage == currentDialog.replace("\n", "")){continue;}
			g2.drawString(dialogMessage, x - 50, y - 17);
			y += 40;
		}
	}
	public void drawMessage(Graphics2D g2) {
		if (messageOn) {
			g2.setFont(messageFont);
			g2.drawString(message, gp.getDefaultSettings().getTileSize() / 2, gp.getDefaultSettings().getTileSize() * 3);
			g2.setFont(arial_40);
			messageTimer++;
			if (messageTimer == 120) {
				messageTimer = 0;
				setMessageOn(false);
			}
		}
	}
	public void drawCenteredMessage(Graphics2D g2) {
		if (centeredTextOn) {
			g2.setFont(centeredTextFont);
			g2.setColor(Color.RED);

			int textLength;
			int x;
			int y;

			textLength = (int) g2.getFontMetrics().getStringBounds(centeredText, g2).getWidth();

			x = gp.getDefaultSettings().getScreenWidth() / 2 - textLength / 2;
			y = gp.getDefaultSettings().getScreenHeight() / 2 - 62;
			g2.drawString(centeredText, x, y);
			centeredTextTimer--;
			if (centeredTextTimer == 0) {
				centeredTextOn = false;
			}
			g2.setFont(arial_40);
		}
	}
	public void drawTitle(Graphics2D g2) {
		if (titleOn) {
			g2.setFont(titleFont);
			g2.setColor(Color.RED);

			int textLength;
			int x;
			int y;

			textLength = (int) g2.getFontMetrics().getStringBounds(title, g2).getWidth();

			x = gp.getDefaultSettings().getScreenWidth() / 2 - textLength / 2;
			y = gp.getDefaultSettings().getScreenHeight() / 2 - 80;
			g2.drawString(title, x, y);
			titleTimer--;
			if (titleTimer == 0) {
				titleOn = false;
			}
			g2.setFont(arial_40);
		}
		if (subtitleOn) {
			g2.setFont(subtitleFont);
			g2.setColor(Color.RED);

			int textLength;
			int x;
			int y;

			textLength = (int) g2.getFontMetrics().getStringBounds(subtitle, g2).getWidth();

			x = gp.getDefaultSettings().getScreenWidth() / 2 - textLength / 2;
			y = gp.getDefaultSettings().getScreenHeight() / 2 - 50;
			g2.drawString(subtitle, x, y);
			subtitleTimer--;
			if (subtitleTimer == 0) {
				subtitleOn = false;
			}
			g2.setFont(arial_40);
		}
	}
	public void drawDialogWindow(int x, int y, int width, int height) {
		Color color = (new Color(0, 0, 0,210));
		g2.setColor(color);
		g2.fillRoundRect(x, y, width, height, 25, 25);
		color = new Color(255, 255, 255);
		g2.setColor(color);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
	}
	public int getCenteredTextX(String text) {
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		return (gp.getDefaultSettings().getScreenWidth()/2 - length/2);
	}
	public void drawPauseScreen() {
		String text = "Paused";
		int x = getCenteredTextX(text);
		int y = gp.getDefaultSettings().getScreenHeight() / 2 - 62;
		g2.drawString(text, x, y);
	}
	public boolean isMessageOn() {return messageOn;}

	public void setMessageOn(boolean messageOn) {this.messageOn = messageOn;}

	public String getMessage() {return message;}

	public void sendMessage(String message) {this.message = message;this.setMessageOn(true);}

	public String getCurrentDialog() {
		return currentDialog;
	}

	public void setCurrentDialog(String currentDialog) {
		this.currentDialog = currentDialog;
	}

	Menu menu = new Menu();

	public void buttonAction() {
		menu.buttonAction(gp, currentSlotIndex);
	}

	public PauseMenu getPauseMenu() {
		return pauseMenu;
	}
	public SkinMenu getSkinMenu() {
		return skinMenu;
	}
	public MainMenu getMainMenu() {
		return mainMenu;
	}
	public ControlSettingsMenu getControlSettingsMenu() {
		return controlSettingsMenu;
	}
	public GameUI getGameUI() {
		return gameUI;
	}

	public MouseCursorLocation getMouseCursorLocation() {
		return mouseCursorLocation;
	}
	public CharacterMenu getCharacterMenu() {
		return characterMenu;
	}


	public int getCurrentSlotIndex(){
		return currentSlotIndex;
	}
	public void setCurrentSlotIndex(int index) {
		this.currentSlotIndex = index;
	}
	public int getCurrentSlotMaxIndex() {
		return currentSlotMaxIndex;
	}
}
