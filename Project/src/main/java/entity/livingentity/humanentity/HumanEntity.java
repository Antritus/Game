package entity.livingentity.humanentity;

import damage.Damage;
import entity.EntityType;
import entity.livingentity.LivingEntity;
import main.GamePanel;
import util.ImageUtility;
import main.tile.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.UUID;

// todo: move draw methods to entity class


public abstract class HumanEntity extends LivingEntity {
	GamePanel gp;
	ImageUtility skinSystem;
	private int actionLockTime = 0;
	private int currentDialogIndex;
	private UUID indexOfPlayer;
	private String[] dialogs = new String[20];
	private String currentDialog;

	public HumanEntity(GamePanel gp){
		super(gp);
		this.skinSystem = new ImageUtility(gp);
		this.gp = gp;
	}
	public void setAction(){}


	public void update() {
		superClasses();
		setAction();
		// Check tile collision
		setCollisionOn(Tile.CollisionType.NONE);
		gp.getCollisionChecker().checkTile(this);
		gp.getCollisionChecker().checkObject(this, false);
		gp.getCollisionChecker().checkEntity(this, gp.npc);
		gp.getCollisionChecker().checkEntity(this, gp.hostile);
		gp.getCollisionChecker().checkPlayer(this);
		move(getSpeed(), false);
	}
	public void draw(Graphics2D g2, GamePanel gp) {
		BufferedImage image = null;
		switch (this.getDirection()) {
			case NORTH_WEST:
			case NORTH_EAST:
			case NORTH:
				if (this.getSpriteNum() == 1) {
					image = up1;
				} else {
					image = up2;
				}
				break;
			case SOUTH_EAST:
			case SOUTH_WEST:
			case SOUTH:
				if (this.getSpriteNum() == 1) {
					image = down1;
				} else {
					image = down2;
				}
				break;
			case WEST:
				if (this.getSpriteNum() == 1) {
					image = left1;
				} else {
					if (!this.isRidingBoat()) {
						image = left2;
					} else {
						image = left1;
					}
				}
				break;

			case EAST:
				if (this.getSpriteNum() == 1) {
					image = right1;
				} else {
					if (!this.isRidingBoat()) {
						image = right2;
					} else {
						image = right1;
					}
				}
				break;
		}
		double screenX = getX() - gp.player.getX() + gp.player.screenX;
		double screenY = getY() - gp.player.getY() + gp.player.screenY;
		if (this.getType() == EntityType.PLAYER) {
			g2.drawImage(image, (int) screenX, (int) screenY, null);
		} else {
			if (getX() + gp.getDefaultSettings().getTileSize() > gp.player.getX() - gp.player.screenX &&
					getX() - gp.getDefaultSettings().getTileSize() < gp.player.getX() + gp.player.screenX &&
					getY() + gp.getDefaultSettings().getTileSize() > gp.player.getY() - gp.player.screenY &&
					getY() - gp.getDefaultSettings().getTileSize() < gp.player.getY() + gp.player.screenY) {
				if (this.isUpsideDown()) {
					image = skinSystem.flipVertically(image);
				}
				g2.drawImage(image, (int) screenX, (int) screenY, gp.getDefaultSettings().getTileSize(), gp.getDefaultSettings().getTileSize(), null);
			}
		}
	}

	public int getActionLockTime() {
		return actionLockTime;
	}

	public void setActionLockTime(int actionLockTime) {
		this.actionLockTime = actionLockTime;
	}

	public String[] getDialogs() {
		return dialogs;
	}
	public String getDialog(int index) {
		return dialogs[index];
	}
	public void setDialogs(String[] dialogs) {
		this.dialogs = dialogs;
	}
	public void setDialog(int index, String dialog){
		this.dialogs[index] = dialog;
	}
	public void speak(){
	}

	public String getCurrentDialog() {
		return currentDialog;
	}

	public void setCurrentDialog(String currentDialog) {
		this.currentDialog = currentDialog;
	}

	public int getCurrentDialogIndex() {
		return currentDialogIndex;
	}

	public void setCurrentDialogIndex(int currentDialogIndex) {
		this.currentDialogIndex = currentDialogIndex;
	}

	public UUID getUUIDOfPlayer() {
		return indexOfPlayer;
	}

	public void setUUIDOfPlayer(UUID indexOfPlayer) {
		this.indexOfPlayer = indexOfPlayer;
	}
}
