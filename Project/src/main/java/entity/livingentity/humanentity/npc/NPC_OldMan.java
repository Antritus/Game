package entity.livingentity.humanentity.npc;

import damage.Damage;
import entity.EntityType;
import entity.livingentity.LivingEntity;
import entity.livingentity.humanentity.HumanEntity;
import main.Direction;
import main.GamePanel;
import util.ImageUtility;

import java.awt.*;
import java.util.Random;

public class NPC_OldMan extends HumanEntity {
	GamePanel gp;
	ImageUtility imageUtility;
	public NPC_OldMan(GamePanel gp) {
		super(gp);
		this.gp = gp;
		imageUtility = new ImageUtility(gp);
		this.setSpeed(1);
		this.setDirection(Direction.SOUTH);
		this.setSolidArea(new Rectangle());
		this.getSolidArea().x = 15;
		this.getSolidArea().y = 27;
//		this.setSolidAreaDefaultX(getSolidArea().x);
//		this.setSolidAreaDefaultY(getSolidArea().y);
		this.getSolidArea().width = 32;
		this.getSolidArea().height = 32;
		getNPCImage();
		setDefaultValues();
	}
	public void getNPCImage() {
		String path = "/entity/npc/oldman/oldman_";
		String pathEnd = ".png";
		up1 = imageUtility.setup(path + "up" + pathEnd, false, false);
		up2 = imageUtility.setup(path + "up" + pathEnd, true, false);
		down1 = imageUtility.setup(path + "down" + pathEnd, false, false);
		down2 = imageUtility.setup(path + "down" + pathEnd, true, false);
		right1 = imageUtility.setup(path + "side1" + pathEnd, true, false);
		right2 = imageUtility.setup(path + "side2" + pathEnd, true, false);
		left1 = imageUtility.setup(path + "side1" + pathEnd, false, false);
		left2 = imageUtility.setup(path + "side2" + pathEnd, false, false);
	}
	public void setDefaultValues() {
		this.setDialog(0, "Hello, how are you\n");
		this.setDialog(1, "Do you need cocaine\nI have some");
		this.setDialog(2, "I have some\nDo you wanto to have it?\nTest");
		this.setDialog(3, "Here");
		this.entityType = EntityType.NPC_OLD_MAN;
	}
	public void setAction() {
		setActionLockTime(getActionLockTime()+1);
		if(getActionLockTime() == 120) {
			Random random = new Random();
			int i = random.nextInt(100)+1;
			if (i < 25){
				this.setDirection(Direction.NORTH);
			} if (i > 25 && i <= 50) {
				this.setDirection(Direction.SOUTH);
			} if (i > 50 && i <= 75){
				this.setDirection(Direction.EAST);
			} if (i > 75 && i <= 100) {
				setDirection(Direction.WEST);
			}
			setActionLockTime(0);
		}
	}
	public void speak() {
		if (this.getDialog(this.getCurrentDialogIndex()) == null) {
			this.setCurrentDialogIndex(0);
		} else {
			gp.getUISystem().setCurrentDialog(this.getDialog(getCurrentDialogIndex()));
			this.setCurrentDialogIndex(1 + this.getCurrentDialogIndex());
			this.setDirection(this.getOppositeDirection(this.getPlayer(this.getUUIDOfPlayer()).getDirection()));
		}
	}

	@Override
	public void onDeath(boolean cancelled, LivingEntity attacker, Damage damage) {
	}
	@Override
	public void onKill(boolean cancelled, LivingEntity attacker, Damage damage){
	}
}

