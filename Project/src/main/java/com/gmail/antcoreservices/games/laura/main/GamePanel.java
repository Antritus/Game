package com.gmail.antcoreservices.games.laura.main;

import com.gmail.antcoreservices.games.laura.entity.Entity;
import com.gmail.antcoreservices.games.laura.entity.livingentity.hostile.HostileEntity;
import com.gmail.antcoreservices.games.laura.entity.livingentity.humanentity.HumanEntity;
import com.gmail.antcoreservices.games.laura.entity.livingentity.humanentity.player.Player;
import com.gmail.antcoreservices.games.laura.entity.livingentity.humanentity.player.character.classes.knight.Knight;
import com.gmail.antcoreservices.games.laura.main.settings.ControlSettings;
import com.gmail.antcoreservices.games.laura.main.ui.UISystem;
import com.gmail.antcoreservices.games.laura.map.TileManager;
import com.gmail.antcoreservices.games.laura.util.ImageUtility;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.UUID;

public class GamePanel extends JPanel implements Runnable {


	// Fps (Movement update)
	int FPS = 60;
	// game time
	public double playTime = 0;

	TileManager tileM;
	Sound music = new Sound();
	Sound soundEffect = new Sound();
	private Thread gameThread;

	private final DefaultSettings defaultSettings;
	public DefaultSettings getDefaultSettings(){
		return defaultSettings;
	}

	private CollisionChecker checker;
	private AssetSetter assetSetter;
	private final UISystem ui;
	private final KeyHandler keyHandler;
	private final ControlSettings controlSettings;
	private final ImageUtility imageUtility;
	private final Debug debug;
	//private final ImageGallery imageGallery;
	public Thread getGameThread(){return gameThread;}
	public ControlSettings getControlSettings(){return controlSettings;}
	public ImageUtility getImageUtility(){return imageUtility;}
//	public ImageGallery getImageGallery(){return imageGallery;}
	public UISystem getUISystem(){return ui;}
	public AssetSetter getAssetSetter(){return assetSetter;}
	public CollisionChecker getCollisionChecker(){return checker;}
	public KeyHandler getKeyHandler(){return keyHandler;}
	public Debug getDebugKeyHandler() {return debug;}

	public Account account = new Account("(AC) Antritus", 123, UUID.randomUUID());


	private Entity[] entities = new Entity[1000];

	public Entity[] getEntities(){
		return entities;
	}

	public Player player;
	public static Player staticPlayer;
	public Entity[] obj = new Entity[10];
	public HostileEntity hostile[] = new HostileEntity[50];
	public HumanEntity npc[] = new HumanEntity[10];
	public ArrayList<Entity> entityArrayList = new ArrayList<>();

	// Game state
	private enum GameState{
		MAIN_MENU,
		SKIN_MENU,
		CHARACTER_MENU,
		SETTINGS_MENU,
		CONTROL_SETTINGS_MENU,
		VIEW_SETTINGS_MENU,
		GAME_CREATE_MENU,
		GAME_LOAD_GAMES_MENU,
		GAME_LOAD,
		PAUSED,
		PLAYING,
		DIALOG
	}
	private final GameState mainMenuState = GameState.MAIN_MENU;
	private final GameState skinMenuState = GameState.SKIN_MENU;
	private final GameState characterMenuState = GameState.CHARACTER_MENU;
	private final GameState settingsMenuState = GameState.SETTINGS_MENU;
	private final GameState controlSettingsMenuState = GameState.CONTROL_SETTINGS_MENU;
	private final GameState playState = GameState.PLAYING;
	private final GameState pauseState = GameState.PAUSED;
	private final GameState dialogState = GameState.DIALOG;

	public GameState gameState;
	public GameState getMainMenuState(){
		return mainMenuState;
	}
	public GameState getSkinMenuState(){
		return skinMenuState;
	}
	public GameState getCharacterMenuState(){
		return characterMenuState;
	}
	public GameState getSettingsMenuState(){
		return characterMenuState;
	}
	public GameState getControlSettingsMenuState(){
		return controlSettingsMenuState;
	}
	public GameState getPauseState() {
		return pauseState;
	}
	public GameState getPlayState() {
		return playState;
	}
	public GameState getGameState(){
		return gameState;
	}
	public GameState getDialogState(){
		return dialogState;
	}

	public void setGameState(GameState state) {
		this.gameState = state;
	}


	public GamePanel(DefaultSettings defaultSettings) {
		this.defaultSettings = defaultSettings;
		debug = new Debug(this);
		/*
		 * Load order of classes
		 * defaultSettings must be first to all classes to work
		 * ImageUtility is used in almost every class with image, so it needs to be high in the list
		 * All menus need control settings
		 * TileManager is not needed until the game loads to a com.gmail.antcoreservices.games.laura.map
		 * ControlSettings is needed when playing the game or changing controls in the menu
		 * UI is needed in every class with menu or ui
		 * AssetSetter is used to place npcs, monsters, items
		 * Checker (collision checker) is only needed to check collisions after game loads
		 * debug should always be on the top of all loading ( due to it being used in everywhere
		 */
		imageUtility = new ImageUtility(this);
		ui = new UISystem(this);
		keyHandler = new KeyHandler(this);


		controlSettings = new ControlSettings(this);


//		imageGallery = new ImageGallery(this, imageUtility);


		this.setPreferredSize(new Dimension(getDefaultSettings().getScreenWidth(), getDefaultSettings().getScreenHeight()));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyHandler);
		this.addMouseListener(keyHandler);
		this.addMouseMotionListener(keyHandler);
		this.addMouseWheelListener(keyHandler);
		this.setFocusable(true);
	}
	/*
	public void zoomInOut(int i) {
		int oldWorldWidth = tileSize * maxWorldCol;
		tileSize += i;
		int newWorldWidth = tileSize*maxWorldCol;
		player.setSpeed((double)newWorldWidth/600.0);

		double multiplier = (double) newWorldWidth/oldWorldWidth;


		double newPlayerWorldX = player.getX() * multiplier;
		double newPlayerWorldY = player.getY() * multiplier;

		player.setX(newPlayerWorldX);
		player.setY(newPlayerWorldY);
	}

	 */
	public void startDebugging() {
		this.getDefaultSettings().setDebugging(true);
		Main.updateName(getDefaultSettings().getName() + " (Currently Debugging)");
	}
	public void stopDebugging() {
		getDefaultSettings().setDebugging(false);
		Main.updateName(getDefaultSettings().getName());
	}
	public boolean isDebuggingOn() {
		return this.getDefaultSettings().isDebuggingOn();
	}
	public void startFrameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	public void setupGame() {
		tileM = new TileManager(this);
		assetSetter = new AssetSetter(this);
		checker = new CollisionChecker(this);
		player= new Player(this, keyHandler, new Knight(this));
		staticPlayer = player;
		assetSetter.setObject();
		assetSetter.setNPC();
		assetSetter.setHostile();
		setGameState(GameState.MAIN_MENU);
	}
	private boolean allowPainting = false;
	@Override
	public void run() {
		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		int allowPaitingCount = 0;
		while (gameThread != null) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			if (delta >= 1) {
				update();
				repaint();
				delta--;
				drawCount++;
			}
			if (timer >= 1000000000) {
				FPS = drawCount;
				drawCount = 0;
				timer = 0;
				allowPaitingCount++;
			}
			if (allowPaitingCount == 1) {
				allowPainting =true;
			}
		}
	}
	public void update() {
		if (gameState == playState) {
			// Player
			player.update();
			// NPC
			for (HumanEntity humanEntity : npc) {
				if (humanEntity != null) {
					humanEntity.update();
				}
			}
			for (HostileEntity hostileEntity : hostile) {
				if (hostileEntity != null) {
					hostileEntity.update();
				}
			}
		} if (gameState == pauseState){
			// Do something
		}
	}
	public Font debugFont = new Font("Ariel", Font.PLAIN, 20);
	private long drawStart = 0;
	private long drawTime = 0;
	public long getDrawTime() {
		return drawTime;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		//Debugging
		if (getDefaultSettings().isDebuggingOn()) {
			drawStart = System.nanoTime();
		}
		if (!allowPainting) {
			return;
		}
		ui.draw(g2);
		if (this.getGameState() == getPlayState() || this.getGameState() == getDialogState()){
			//
			tileM.drawWorld(g2);
			entityArrayList.add(player);
			if (player.isRidingBoat()) {
				entityArrayList.add(player.getRiddenBoat());
			}
			for (HumanEntity humanEntity : npc) {
				if (humanEntity == null) {
					continue;
				}
				entityArrayList.add(humanEntity);
			}
			for (Entity entity : hostile) {
				if (entity == null) {
					continue;
				}
				entityArrayList.add(entity);
			}
			for (Entity entity : obj) {
				if (entity == null) {
					continue;
				}
				entityArrayList.add(entity);
			}
			entityArrayList.sort(new Comparator<Entity>() {
				@Override
				public int compare(Entity e1, Entity e2) {
					return Integer.compare(e1.getY(), e2.getY());
				}
			});
			for (Entity entity : entityArrayList) {
				//todo: fix drawing
				entity.draw(g2, this);
			}
			entityArrayList.clear();

			// UI
			ui.draw(g2);
		}
		// Debugging
		if (this.isDebuggingOn()) {
			long drawEnd = System.nanoTime();
			drawTime = drawEnd - drawStart;
			debug.drawDebug(g2);
		}
		g2.dispose();
		keyHandler.hasScrollWheelMoved();
		drawStart = 0;
	}
	public void playMusic(int i){
		music.setFile(i);
		music.play();
		music.loop();
	}
	public void stopMusic() {
		music.stop();
	}
	public void playSoundEffect(int i){
		soundEffect.setFile(i);
		soundEffect.play();
	}
}
