package entity.other;

import entity.Entity;
import entity.EntityType;
import main.Direction;
import main.GamePanel;
import util.ImageUtility;
import main.tile.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Boat extends Entity {
	GamePanel gp;
	Entity entity;
	ImageUtility skinSystem;

	public Boat(GamePanel gp, Entity entity) {
		super(gp);
		skinSystem = new ImageUtility(gp);
		this.gp  = gp;
		this.entity = entity;
		this.entityType = EntityType.BOAT;

		setDefaultValues();
		this.setUpsideDown(false);
		getPlayerImage();
	}

	public void setDefaultValues() {
		this.setX(entity.getX());
		this.setY(entity.getY());
		setSpeed(6);
		this.setDirection(Direction.SOUTH);
	}
	public void getPlayerImage() {
		try {
			String location = "/boat/";
			up1 = ImageIO.read(getClass().getResourceAsStream(location + "boat_updown.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream(location + "side.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream(location + "side2.png"));
			right1 = skinSystem.flipHorizontally(ImageIO.read(getClass().getResourceAsStream(location + "side.png")));
			right2 = skinSystem.flipHorizontally(ImageIO.read(getClass().getResourceAsStream(location + "side2.png")));
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	boolean addedSpeed = false;
	public void update() {
		boolean multiInputMovement = true;
		if (entity.getRiddenBoat().getUUID() == this.getUUID()) {
			if (entity.isMoving()) {
				setIsMoving(true);
			} else {
				setIsMoving(false);
			}
			if (entity.getDirection() == Direction.NORTH) {
				this.setDirection(Direction.NORTH);
			} else if (entity.getDirection() == Direction.SOUTH) {
				this.setDirection(Direction.SOUTH);
			}
			if (entity.getDirection() == Direction.SOUTH_EAST && multiInputMovement) {
				this.setDirection(Direction.WEST);
			} else if (entity.getDirection() == Direction.SOUTH_WEST && multiInputMovement) {
				this.setDirection(Direction.EAST);
			} else if (entity.getDirection() == Direction.NORTH_EAST && multiInputMovement) {
				this.setDirection(Direction.WEST);
			} else if (entity.getDirection() == Direction.NORTH_WEST && multiInputMovement) {
				this.setDirection(Direction.EAST);
			} else {
				this.setDirection(entity.getDirection());
			}
			if (entity.isCollisionOn(entity.getDirection()) == Tile.CollisionType.LIQUID && !addedSpeed) {
				addedSpeed = true;
				entity.setSpeed(getSpeed() + 2);
			} else {
				addedSpeed = false;
			}
			this.addSpriteCounter(1);
			if (this.getSpriteCounter() > 25) {
				if (this.getSpriteNum() == 1) {
					this.setSpriteNum(2);
				} else if (this.getSpriteNum() == 2) {
					this.setSpriteNum(1);
				}
				this.setSpriteCounter(0);
			}
		}
	}
	public void draw(Graphics2D g2) {
		if (!entity.isRidingBoat() || !(entity.getRiddenBoat().getUUID() == this.getUUID())) {
			return;
		}
		BufferedImage image = null;
		switch(this.getDirection()) {
			case SOUTH:
			case NORTH:
				image = up1;
				break;
			case WEST:
				if (getSpriteNum() == 1) {
					image = left1;
				} else {
					image = left2;
				}
				break;
			case EAST:
				if (getSpriteNum() == 1) {
					image = right1;
				} else {
					image = right2;
				}
				break;
		}
		if (this.isUpsideDown()) {
			image = skinSystem.flipVertically(image);
		}
		g2.drawImage(image, entity.screenX, entity.screenY, gp.tileSize, gp.tileSize, null);
	}
}
