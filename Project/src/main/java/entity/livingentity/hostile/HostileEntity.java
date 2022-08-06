package entity.livingentity.hostile;

import damage.Damage;
import entity.EntityType;
import entity.livingentity.LivingEntity;
import main.GamePanel;
import util.ImageUtility;

import java.awt.*;
import java.awt.image.BufferedImage;

public class HostileEntity extends LivingEntity {
	GamePanel gp;
	private int actionLockTime = 0;

	public void setAction() {
	}

	public int getActionLockTime() {
		return actionLockTime;
	}
	public void setActionLockTime(int actionLockTime) {
		this.actionLockTime = actionLockTime;
	}

	public void onPlayerCollision() {}

	@Override
	protected void onKill(boolean cancelled, LivingEntity victim, Damage damage) {

	}

	@Override
	protected void onDeath(boolean cancelled, LivingEntity attacker, Damage damage) {

	}

	public void update() {
		superClasses();
	}

	public void draw(Graphics2D g2, GamePanel gp) {
		ImageUtility skinSystem = new ImageUtility(gp);
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
			if (getX() + gp.tileSize > gp.player.getX() - gp.player.screenX &&
					getX() - gp.tileSize < gp.player.getX() + gp.player.screenX &&
					getY() + gp.tileSize > gp.player.getY() - gp.player.screenY &&
					getY() - gp.tileSize < gp.player.getY() + gp.player.screenY) {
				if (this.isUpsideDown()) {
					image = skinSystem.flipVertically(image);
				}
				g2.drawImage(image, (int) screenX, (int) screenY, gp.tileSize, gp.tileSize, null);
			}
		}
	}
}
