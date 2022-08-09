package main;

import entity.Entity;
import main.tile.Tile;

import java.util.HashMap;

public class CollisionChecker {
	GamePanel gp;
	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}

	public void checkTile(Entity entity) {
		if (!entity.hasCollision()) {
			return;
		}

		int entityLeftWorldX = entity.getX()-(gp.getDefaultSettings().getScale()) + entity.getSolidArea().x;
		int entityRightWorldX = entity.getX()-(gp.getDefaultSettings().getScale()) + entity.getSolidArea().x + entity.getSolidArea().width;
		int entityTopWorldY = entity.getY()-(gp.getDefaultSettings().getScale()) + entity.getSolidArea().y;
		int entityBottomWorldY = entity.getY()-(gp.getDefaultSettings().getScale()) + entity.getSolidArea().y + entity.getSolidArea().height;

		int entityLeftCol = entityLeftWorldX/gp.getDefaultSettings().getTileSize();
		int entityRightCol = entityRightWorldX/gp.getDefaultSettings().getTileSize();
		int entityTopRow = entityTopWorldY/gp.getDefaultSettings().getTileSize();
		int entityBottomRow = entityBottomWorldY/gp.getDefaultSettings().getTileSize();
		int tileNum1, tileNum2;
		HashMap<Direction, Boolean> directions = new HashMap<>();

		{
			directions.put(Direction.NORTH, false);
			directions.put(Direction.SOUTH, false);
			directions.put(Direction.WEST, false);
			directions.put(Direction.EAST, false);
			switch (entity.getDirection()) {
				case SOUTH -> directions.put(Direction.SOUTH, true);
				case NORTH -> directions.put(Direction.NORTH, true);
				case EAST -> directions.put(Direction.EAST, true);
				case WEST -> directions.put(Direction.WEST, true);
				case NORTH_EAST -> {directions.put(Direction.NORTH, true);directions.put(Direction.WEST, true);}
				case NORTH_WEST -> {directions.put(Direction.NORTH, true);directions.put(Direction.EAST, true);}
				case SOUTH_EAST -> {directions.put(Direction.SOUTH, true);directions.put(Direction.WEST, true);}
				case SOUTH_WEST -> {directions.put(Direction.SOUTH, true);directions.put(Direction.EAST, true);}
			}
		}
		entity.setColliding(false);
		if (!entity.isColliding()) {
			if (directions.get(Direction.NORTH)) {
				entityTopRow = (entityTopWorldY - entity.getSpeed()) / gp.getDefaultSettings().getTileSize();
				if (gp.tileM.mapTileNumber[entityLeftCol][entityTopRow] < 0 || gp.tileM.mapTileNumber[entityRightCol][entityTopRow] > gp.getDefaultSettings().getMaxWorldCol()) {
					entity.setColliding(true);
					entity.setCollisionOn(Direction.NORTH, Tile.CollisionType.BLOCKER);
				}
				tileNum1 = gp.tileM.mapTileNumber[entityLeftCol][entityTopRow];
				tileNum2 = gp.tileM.mapTileNumber[entityRightCol][entityTopRow];
				if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
					entity.setCollisionOn(Direction.NORTH, Tile.CollisionType.BLOCKER);
					entity.setColliding(true);

				} else if (gp.tileM.tile[tileNum1].liquid || gp.tileM.tile[tileNum2].liquid) {
					entity.setCollisionOn(Direction.SOUTH, Tile.CollisionType.LIQUID);
				}

			} else if (directions.get(Direction.SOUTH)) {
				if (gp.tileM.mapTileNumber[entityLeftCol][entityBottomRow] < 0 || gp.tileM.mapTileNumber[entityRightCol][entityBottomRow] > gp.getDefaultSettings().getMaxWorldCol()) {
					entity.setColliding(true);
					entity.setCollisionOn(Direction.SOUTH, Tile.CollisionType.BLOCKER);
				}
				entityBottomRow = (entityBottomWorldY + entity.getSpeed()) / gp.getDefaultSettings().getTileSize();
				tileNum1 = gp.tileM.mapTileNumber[entityLeftCol][entityBottomRow];
				tileNum2 = gp.tileM.mapTileNumber[entityRightCol][entityBottomRow];
				if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
					entity.setCollisionOn(Direction.SOUTH, Tile.CollisionType.BLOCKER);
					entity.setColliding(true);

				} else if (gp.tileM.tile[tileNum1].liquid || gp.tileM.tile[tileNum2].liquid) {
					entity.setCollisionOn(Direction.SOUTH, Tile.CollisionType.LIQUID);
				}
			}
			if (directions.get(Direction.WEST)) {
				if (gp.tileM.mapTileNumber[entityLeftCol][entityTopRow] < 0 || gp.tileM.mapTileNumber[entityLeftCol][entityBottomRow] > gp.getDefaultSettings().getMaxWorldCol()) {
					entity.setColliding(true);
					entity.setCollisionOn(Direction.WEST, Tile.CollisionType.BLOCKER);
				}
				entityLeftCol = (entityLeftWorldX - entity.getSpeed()) / gp.getDefaultSettings().getTileSize();
				tileNum1 = gp.tileM.mapTileNumber[entityLeftCol][entityTopRow];
				tileNum2 = gp.tileM.mapTileNumber[entityLeftCol][entityBottomRow];
				if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
					entity.setCollisionOn(Direction.WEST, Tile.CollisionType.BLOCKER);
					entity.setColliding(true);

				} else if (gp.tileM.tile[tileNum1].liquid || gp.tileM.tile[tileNum2].liquid) {
					entity.setCollisionOn(Direction.SOUTH, Tile.CollisionType.LIQUID);
				}

			}
			if (directions.get(Direction.EAST)) {
				if (gp.tileM.mapTileNumber[entityRightCol][entityTopRow] < 0 || gp.tileM.mapTileNumber[entityRightCol][entityBottomRow] > gp.getDefaultSettings().getMaxWorldCol()) {
					entity.setColliding(true);
					entity.setCollisionOn(Direction.WEST, Tile.CollisionType.BLOCKER);
				}
				entityRightCol = (entityRightWorldX + entity.getSpeed()) / gp.getDefaultSettings().getTileSize();
				tileNum1 = gp.tileM.mapTileNumber[entityRightCol][entityTopRow];
				tileNum2 = gp.tileM.mapTileNumber[entityRightCol][entityBottomRow];
				if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
					entity.setCollisionOn(Direction.EAST, Tile.CollisionType.BLOCKER);
					entity.setColliding(true);

				} else if (gp.tileM.tile[tileNum1].liquid || gp.tileM.tile[tileNum2].liquid) {
					entity.setCollisionOn(Direction.SOUTH, Tile.CollisionType.LIQUID);
				}
			}
		}
	}
	public int checkObject(Entity entity, boolean player){
		int index = 999;
		for (int i = 0; i < gp.obj.length; i++) {
			if (gp.obj[i] != null) {
				// get ent solid area pos
				entity.getSolidArea().x = entity.getX() + entity.getSolidArea().x;
				entity.getSolidArea().y = entity.getY() + entity.getSolidArea().y;
				gp.obj[i].getSolidArea().x = gp.obj[i].getX() + gp.obj[i].getSolidArea().x;
				gp.obj[i].getSolidArea().y = gp.obj[i].getY() + gp.obj[i].getSolidArea().y;
				// get obj solid area pos
				switch (entity.getDirection()) {
					case NORTH -> entity.getSolidArea().y -= entity.getSpeed();
					case SOUTH -> entity.getSolidArea().y += entity.getSpeed();
					case WEST -> entity.getSolidArea().x -= entity.getSpeed();
					case EAST -> entity.getSolidArea().x += entity.getSpeed();
					case NORTH_EAST -> {
						entity.getSolidArea().y -= entity.getSpeed();
						entity.getSolidArea().x -= entity.getSpeed();
					}
					case NORTH_WEST -> {
						entity.getSolidArea().y -= entity.getSpeed();
						entity.getSolidArea().x += entity.getSpeed();
					}
					case SOUTH_EAST -> {
						entity.getSolidArea().y += entity.getSpeed();
						entity.getSolidArea().x -= entity.getSpeed();
					}
					case SOUTH_WEST -> {
						entity.getSolidArea().y += entity.getSpeed();
						entity.getSolidArea().x += entity.getSpeed();
					}
				}
				if (entity.getSolidArea().intersects(gp.obj[i].getSolidArea())){
					if (gp.obj[i].hasCollision()) {
						entity.setCollisionOn(Tile.CollisionType.OBJECT);
					} if (player) {
						index = i;
					}
				}				entity.getSolidArea().x = entity.getSolidAreaDefaultX();
				entity.getSolidArea().y = entity.getSolidAreaDefaultY();
				gp.obj[i].getSolidArea().x = gp.obj[i].getSolidAreaDefaultX();
				gp.obj[i].getSolidArea().y = gp.obj[i].getSolidAreaDefaultY();
			}
		}
		return index;
	}
	// npc / monster collision
	public int checkEntity(Entity entity, Entity[] target){
		int index = 999;
		for (int i = 0; i < target.length; i++) {
			if (target[i] == entity) {
				continue;
			}
			if (target[i] != null) {
				// get ent solid area pos
				entity.getSolidArea().x = entity.getX() + entity.getSolidArea().x;
				entity.getSolidArea().y = entity.getY() + entity.getSolidArea().y;
				target[i].getSolidArea().x = target[i].getX() + target[i].getSolidArea().x;
				target[i].getSolidArea().y = target[i].getY() + target[i].getSolidArea().y;
				// get obj solid area pos
				switch (entity.getDirection()) {
					case NORTH -> entity.getSolidArea().y -= entity.getSpeed();
					case SOUTH -> entity.getSolidArea().y += entity.getSpeed();
					case WEST -> entity.getSolidArea().x -= entity.getSpeed();
					case EAST -> entity.getSolidArea().x += entity.getSpeed();
					case NORTH_EAST -> {
						entity.getSolidArea().y -= entity.getSpeed();
						entity.getSolidArea().x -= entity.getSpeed();
					}
					case NORTH_WEST -> {
						entity.getSolidArea().y -= entity.getSpeed();
						entity.getSolidArea().x += entity.getSpeed();
					}
					case SOUTH_EAST -> {
						entity.getSolidArea().y += entity.getSpeed();
						entity.getSolidArea().x -= entity.getSpeed();
					}
					case SOUTH_WEST -> {
						entity.getSolidArea().y += entity.getSpeed();
						entity.getSolidArea().x += entity.getSpeed();
					}
				}
				if (entity.getSolidArea().intersects(target[i].getSolidArea())){
					if (target[i] == entity){
						continue;
					}
					if (target[i].hasCollision()) {
						entity.setCollisionOn(Tile.CollisionType.NPC);
						index = i;
					}
				}				entity.getSolidArea().x = entity.getSolidAreaDefaultX();
				entity.getSolidArea().y = entity.getSolidAreaDefaultY();
				target[i].getSolidArea().x = target[i].getSolidAreaDefaultX();
				target[i].getSolidArea().y = target[i].getSolidAreaDefaultY();
			}
		}
		return index;
	}
	// player
	public boolean checkPlayer(Entity entity){
		int index = 999;
		// get ent solid area pos
		entity.getSolidArea().x = entity.getX() + entity.getSolidArea().x;
		entity.getSolidArea().y = entity.getY() + entity.getSolidArea().y;
		gp.player.getSolidArea().x = gp.player.getX() + gp.player.getSolidArea().x;
		gp.player.getSolidArea().y = gp.player.getY() + gp.player.getSolidArea().y;
		// get obj solid area pos
		switch (entity.getDirection()) {
			case NORTH -> entity.getSolidArea().y -= entity.getSpeed();
			case SOUTH -> entity.getSolidArea().y += entity.getSpeed();
			case WEST -> entity.getSolidArea().x -= entity.getSpeed();
			case EAST -> entity.getSolidArea().x += entity.getSpeed();
			case NORTH_EAST -> {
				entity.getSolidArea().y -= entity.getSpeed();
				entity.getSolidArea().x -= entity.getSpeed();
			}
			case NORTH_WEST -> {
				entity.getSolidArea().y -= entity.getSpeed();
				entity.getSolidArea().x += entity.getSpeed();
			}
			case SOUTH_EAST -> {
				entity.getSolidArea().y += entity.getSpeed();
				entity.getSolidArea().x -= entity.getSpeed();
			}
			case SOUTH_WEST -> {
				entity.getSolidArea().y += entity.getSpeed();
				entity.getSolidArea().x += entity.getSpeed();
			}
		}
		boolean collabs = false;
		if (entity.getSolidArea().intersects(gp.player.getSolidArea())){
			if (gp.player.hasCollision()) {
				entity.setCollisionOn(Tile.CollisionType.PLAYER);
				collabs =  true;
			}
		}
		entity.getSolidArea().x = entity.getSolidAreaDefaultX();
		entity.getSolidArea().y = entity.getSolidAreaDefaultY();
		gp.player.getSolidArea().x = gp.player.getSolidAreaDefaultX();
		gp.player.getSolidArea().y = gp.player.getSolidAreaDefaultY();
		return collabs;
	}
}