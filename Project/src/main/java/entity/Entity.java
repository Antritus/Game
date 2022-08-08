package entity;

import entity.livingentity.humanentity.player.Player;
import entity.other.Boat;
import main.Direction;
import main.GamePanel;
import main.tile.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.UUID;

public class Entity {
	private int tick = 0;
	private void tick() {}
	GamePanel gp;
	
	public Entity(GamePanel gp) {
		this.gp = gp;
	}



	/*
	 * Main entity
	 */

	protected EntityType entityType;
	private final UUID uuid = UUID.randomUUID();
	private Direction direction;
	public BufferedImage up1, up2, down1, down2, right1, right2, left1, left2;
	private boolean isMoving = false;
	private int worldX;
	private int worldY;
	private int speed = 3;
	public int screenX;
	public int screenY;


	private boolean showCustomDisplayName = false;
	private String customDisplayName = null;
	private String name = null;

	private boolean upsideDown = false; // this is only to have fun!


	public EntityType getType() {
		return entityType;
	}
	public boolean isUpsideDown() {
		return upsideDown;
	}
	public UUID getUUID() {
		return uuid;
	}
	public Direction getDirection() {
		return direction;
	}
	public int getX() {
		return worldX;
	}
	public int getY() {
		return worldY;
	}
	public int getSpeed() {
		return speed;
	}
	public boolean isMoving() {
		return isMoving;
	}

	public void setUpsideDown(boolean isUpsideDown) {
		this.upsideDown = isUpsideDown;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public void setX(int x) {
		this.worldX = x;
	}
	public void setY(int y) {
		this.worldY = y;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void setIsMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}

	public void showCustomDisplayName(boolean v){
		showCustomDisplayName = v;
	}
	public void setCustomDisplayName(String customDisplayName) {
		this.customDisplayName = customDisplayName;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isCustomNameShowing() {
		return showCustomDisplayName;
	}
	public String getCustomDisplayName(){
		return customDisplayName;
	}
	public String getName(){
		return name;
	}

	/*
	 * Boat Riding
	 */
	private Boat boat = null;
	private boolean isRidingBoat = false;

	public Boat getRiddenBoat() {
		return boat;
	}

	public boolean isRidingBoat() {
		return isRidingBoat;
	}

	public void setRiding(Boat boat) {
		this.boat = boat;
		this.isRidingBoat = true;
	}

	/*
	 * Movement animation of entity, goes up to 2
	 */
	private int standCounter = 0;
	private int spriteCounter = 0;
	private int spriteNum = 1;

	public int getStandCounter() {
		return standCounter;
	}

	public int getSpriteCounter() {
		return spriteCounter;
	}

	public int getSpriteNum() {
		return spriteNum;
	}


	public void setStandCounter(int standCounter) {
		this.standCounter = standCounter;
	}

	public void setSpriteCounter(int spriteCounter) {
		this.spriteCounter = spriteCounter;
	}

	public void addSpriteCounter(int spriteCounter) {
		this.spriteCounter = this.spriteCounter + spriteCounter;
	}

	public void setSpriteNum(int spriteNum) {
		this.spriteNum = spriteNum;
	}

	public void addSpriteNum(int spriteNum) {
		this.spriteNum = this.spriteNum + spriteNum;
	}

	public void addStandCounter(int standCounter) {
		this.standCounter = this.standCounter + standCounter;
	}

	/*
	 * Collisions
	 */

	private int solidAreaDefaultX, solidAreaDefaultY;
	private boolean hasCollision = true;
	private boolean isCollidingTile = false;
	private boolean isCollidingObject = false;
	private boolean isCollidingNPC = false;
	private boolean isCollidingPlayer = false;
	private boolean isColliding = false;

	public boolean isColliding() {
		return isColliding;
	}
	public void setColliding(boolean v){
		this.isColliding = v;
	}

	private Rectangle solidArea;
	private final HashMap<Direction, Tile.CollisionType> collision = new HashMap<>();

	public Tile.CollisionType isCollisionOn(Direction direction) {
		return collision.get(direction);
	}

	public Rectangle getSolidArea() {
		return this.solidArea;
	}

	public boolean hasCollision() {
		return hasCollision;
	}

	public int getSolidAreaDefaultX() {
		return solidAreaDefaultX;
	}

	public int getSolidAreaDefaultY() {
		return solidAreaDefaultY;
	}

	public void setSolidAreaDefaultX(int solidAreaDefaultX) {
		this.solidAreaDefaultX = solidAreaDefaultX;
	}

	public void setSolidAreaDefaultY(int solidAreaDefaultY) {
		this.solidAreaDefaultY = solidAreaDefaultY;
	}

	public void setHasCollision(boolean hasCollision) {
		this.hasCollision = hasCollision;
	}

	public void setCollisionOn(Direction direction, Tile.CollisionType collision) {
		this.collision.put(direction, collision);
	}

	public void setCollisionOn(Tile.CollisionType collision) {
		this.collision.put(Direction.NORTH, collision);
		this.collision.put(Direction.SOUTH, collision);
		this.collision.put(Direction.SOUTH_EAST, collision);
		this.collision.put(Direction.SOUTH_WEST, collision);
		this.collision.put(Direction.WEST, collision);
		this.collision.put(Direction.EAST, collision);
	}

	protected void setSolidArea(Rectangle rectangle) {
		this.solidArea = rectangle;
	}


	protected void setCollidingNPC(boolean collidingNPC) {
		isCollidingNPC = collidingNPC;
	}

	protected void setCollidingObject(boolean collidingObject) {
		isCollidingObject = collidingObject;
	}

	protected void setCollidingTile(boolean collidingTile) {
		isCollidingTile = collidingTile;
	}

	protected void setCollidingPlayer(boolean collidingPlayer) {
		isCollidingPlayer = collidingPlayer;
	}

	public boolean isCollidingNPC() {
		return isCollidingNPC;
	}

	public boolean isCollidingObject() {
		return isCollidingObject;
	}

	public boolean isCollidingTile() {
		return isCollidingTile;
	}

	public boolean isCollidingPlayer() {
		return isCollidingPlayer;
	}


	public boolean isColliding(Direction direction, Tile.CollisionType collisionType) {
		return isCollisionOn(direction) != collisionType;
	}



	public Direction getOppositeDirection(Direction direction) {
		if (direction == Direction.NORTH) {
			return Direction.SOUTH;
		}
		if (direction == Direction.SOUTH) {
			return Direction.NORTH;
		}
		if (direction == Direction.WEST) {
			return Direction.EAST;
		}
		if (direction == Direction.EAST) {
			return Direction.WEST;
		}
		if (direction == Direction.NORTH_EAST) {
			return Direction.SOUTH_WEST;
		}
		if (direction == Direction.NORTH_WEST) {
			return Direction.SOUTH_EAST;
		}
		if (direction == Direction.SOUTH_EAST) {
			return Direction.NORTH_WEST;
		}
		if (direction == Direction.SOUTH_WEST) {
			return Direction.NORTH_EAST;
		}
		return null;
	}



}
