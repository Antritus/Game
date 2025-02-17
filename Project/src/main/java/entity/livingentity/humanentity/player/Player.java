package entity.livingentity.humanentity.player;

import damage.Damage;
import entity.EntityType;
import entity.livingentity.LivingEntity;
import entity.livingentity.humanentity.HumanEntity;
import entity.livingentity.humanentity.player.character.Character;
import entity.livingentity.humanentity.player.character.skills.Skill;
import main.Direction;
import main.GamePanel;
import main.KeyHandler;
import util.ImageUtility;
import main.tile.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends HumanEntity {
	GamePanel gp;
	KeyHandler keyH;
	ImageUtility skinSystem;
	public BufferedImage characterClassImage;
	private Character characterClass;
	private Skill[] skills;
	private boolean isGirl;
	private String skinSelected = "none";
//	private int hasKeys;


	public Player(GamePanel gp, KeyHandler keyH, Character characterClass) {
		super(gp);
		this.gp = gp;
		this.keyH = keyH;
		this.characterClass = characterClass;
		skinSystem = new ImageUtility(gp);


		screenX = gp.getDefaultSettings().getScreenWidth() / 2 - (gp.getDefaultSettings().getTileSize() / 2);
		screenY = gp.getDefaultSettings().getScreenHeight() / 2 - (gp.getDefaultSettings().getTileSize() / 2);

		setDefaultValues();
		getPlayerImage();
	}

	private void setDefaultValues() {
		this.setHealth(100.0);
		this.setMaxHealth(100.0);
		this.setUpsideDown(false);
		this.setHasCollision(true);
		this.entityType = EntityType.PLAYER;
		this.setCollisionOn(Tile.CollisionType.NONE);
		setX(gp.getDefaultSettings().getTileSize() * 1);
		setY(gp.getDefaultSettings().getTileSize() * 1);
		this.setSolidArea(new Rectangle());
		this.getSolidArea().x = 15;
		this.getSolidArea().y = 27;
		this.setSolidAreaDefaultX(getSolidArea().x);
		this.setSolidAreaDefaultY(getSolidArea().y);
		this.getSolidArea().width = 32;
		this.getSolidArea().height = 32;


		isGirl = true;
		this.setUpsideDown(false);
		this.setSpeed(4);
		this.setDirection(Direction.SOUTH);
	}

	private int tick = 0;

	public boolean isGirl() {
		return isGirl;
	}
	public void getPlayerImage() {
		String sex = "_boy";
		if (this.isGirl()) {
			sex = "_girl";
		}
		String path = "/entity/player/";
		String pathEnd = ".png";
		up1 = skinSystem.setup(path+"up"+pathEnd, false, false);
		up2 = skinSystem.setup(path+"up"+pathEnd, true, false);
		down1 = skinSystem.setup(path+"down"+pathEnd, false, false);
		down2 = skinSystem.setup(path+"down"+pathEnd, true, false);
		right1 = skinSystem.setup(path+"side"+sex+pathEnd, false, false);
		right2 = skinSystem.setup(path+"side2"+pathEnd, false, false);
		left1 = skinSystem.setup(path+"side"+sex+pathEnd, true, false);
		left2 = skinSystem.setup(path+"side2"+pathEnd, true, false);
	}

	public void update() {
		superClasses();
		if (gp.getGameState() == gp.getPlayState()) {
			updateHealthPercentage();
		}
		if (keyH.downPressed || keyH.leftPressed || keyH.upPressed || keyH.rightPressed) {
			boolean multiInputMovement = true;
			if (keyH.leftPressed && !keyH.rightPressed) {
				this.setDirection(Direction.WEST);
			}
			if (keyH.rightPressed && !keyH.leftPressed) {
				this.setDirection(Direction.EAST);
			}
			if (keyH.upPressed) {
				this.setDirection(Direction.NORTH);
				if (keyH.leftPressed  && !keyH.rightPressed && multiInputMovement) {
					this.setDirection(Direction.NORTH_EAST);
				} else if (keyH.rightPressed  && !keyH.leftPressed && multiInputMovement) {
					this.setDirection(Direction.NORTH_WEST);
				}
			} else if (keyH.downPressed) {
				this.setDirection(Direction.SOUTH);
				if (keyH.leftPressed  && !keyH.rightPressed && multiInputMovement) {
					this.setDirection(Direction.SOUTH_EAST);
				} else if (keyH.rightPressed  && !keyH.leftPressed && multiInputMovement) {
					this.setDirection(Direction.SOUTH_WEST);
				}
			}


			// Check tile collision
			setCollisionOn(Tile.CollisionType.NONE);
			gp.getCollisionChecker().checkTile(this);

			// Check object collision (object = item)
			int objIndex = gp.getCollisionChecker().checkObject(this, true);
			pickUpObject(objIndex);
			// Check npc collision
			int npcIndex = gp.getCollisionChecker().checkEntity(this, gp.npc);
			interactNPC(npcIndex);

			int hostileIndex = gp.getCollisionChecker().checkEntity(this, gp.hostile);
			interactHostile(hostileIndex);

			move(getSpeed(), multiInputMovement);
		} else {
			this.setIsMoving(false);
		}
		if (isMoving()) {
			this.addSpriteCounter(1);
			if (this.getSpriteCounter() > 12) {
				if (this.getSpriteNum() == 1) {
					this.setSpriteNum(2);
				} else if (this.getSpriteNum() == 2) {
					this.setSpriteNum(1);
				}
				this.setSpriteCounter(0);
			}
		} else {
			this.addStandCounter(1);
			if (this.getStandCounter() == 20) {
				this.setSpriteNum(1);
				this.setStandCounter(0);
			}
		}
		if (this.isRidingBoat()) {
			this.getRiddenBoat().update();
		}
	}

	public void pickUpObject(int index){
		if (index != 999) {
			this.setCollidingObject(true);
		}
	}
	public void interactNPC(int i){
		if (i != 999) {
			this.setCollidingNPC(true);
			keyH.rightPressed = false;
			keyH.downPressed = false;
			keyH.leftPressed = false;
			keyH.upPressed = false;
			this.setIsMoving(false);
			gp.setGameState(gp.getDialogState());
			gp.npc[i].setUUIDOfPlayer(this.getUUID());
			gp.npc[i].speak();
		}
	}
	public void interactHostile(int i) {
		if (i != 999) {
			gp.hostile[i].onPlayerCollision();
		}
	}

	public String getSkinSelected() {
		return skinSelected;
	}

	public void setSkinSelected(String skinSelected) {
		this.skinSelected = skinSelected;
	}

	public Character getCharacterClass() {
		return this.characterClass;
	}



	/*
	public int getHasKeys() {
		return hasKeys;
	}

	public void setHasKeys(int amount) {
		this.hasKeys = amount;
	}
	public void addKeys(int amount) {
		this.hasKeys += amount;
	}
	*/
}
