package com.gmail.antcoreservices.games.laura.entity.livingentity.hostile.slime;

import com.gmail.antcoreservices.games.laura.damage.DamageElement;
import com.gmail.antcoreservices.games.laura.entity.livingentity.hostile.HostileEntity;
import com.gmail.antcoreservices.games.laura.main.Direction;
import com.gmail.antcoreservices.games.laura.main.GamePanel;
import com.gmail.antcoreservices.games.laura.map.Tile;

import java.util.Random;

public class SlimeAI extends HostileEntity {
	public GamePanel gp;
	
	public SlimeAI(GamePanel gp) {
		super(gp);
		this.gp = gp;
	}

	public void setAction() {
		setActionLockTime(getActionLockTime() + 1);
		if (getActionLockTime() == 120) {
			Random random = new Random();
			int i = random.nextInt(100) + 1;
			if (i < 25) {
				this.setDirection(Direction.NORTH);
			}
			if (i > 25 && i <= 50) {
				this.setDirection(Direction.SOUTH);
			}
			if (i > 50 && i <= 75) {
				this.setDirection(Direction.EAST);
			}
			if (i > 75 && i <= 100) {
				setDirection(Direction.WEST);
			}
			setActionLockTime(0);
		}
	}

	public void update() {
		superClasses();
		setAction();
		// Check tile collision
		setCollisionOn(Tile.CollisionType.NONE);
		gp.getCollisionChecker().checkTile(this);
		gp.getCollisionChecker().checkObject(this, false);
		gp.getCollisionChecker().checkEntity(this, gp.hostile);
		gp.getCollisionChecker().checkEntity(this, gp.npc);
		if (gp.getCollisionChecker().checkPlayer(this)) {
			onPlayerCollision();
		}
		move(getSpeed(), false);
	}

	public void onPlayerCollision() {
		attack(gp.player, 10.0, DamageElement.ICE_ELEMENT);
	}

}
