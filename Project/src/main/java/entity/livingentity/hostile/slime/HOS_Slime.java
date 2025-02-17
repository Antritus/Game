package entity.livingentity.hostile.slime;

import main.Direction;
import main.GamePanel;
import util.ImageUtility;

import java.awt.*;

public class HOS_Slime extends SlimeAI {
	ImageUtility imageUtility;
	public HOS_Slime(GamePanel gp) {
		super(gp);
		this.gp = gp;
		imageUtility = new ImageUtility(gp);
		this.setName("Slime");
		this.setSpeed(1);
		this.setMaxHealth(100);
		this.setHealth(100);

		this.setDirection(Direction.SOUTH);

		this.setSolidArea(new Rectangle());
		this.getSolidArea().x = 9;
		this.getSolidArea().width = 46;
		this.getSolidArea().y = 46;
		this.getSolidArea().height = 18;
		getImage();
	}
	public void getImage() {
		up1 = imageUtility.setup("/entity/hostile/slime/down.png", false ,false);
		up2 = imageUtility.setup("/entity/hostile/slime/down.png", false ,false);
		down1 = imageUtility.setup("/entity/hostile/slime/down.png", false ,false);
		down2 = imageUtility.setup("/entity/hostile/slime/down.png", false ,false);
		left1 = imageUtility.setup("/entity/hostile/slime/down.png", false ,false);
		left2 = imageUtility.setup("/entity/hostile/slime/down.png", false ,false);
		right1 = imageUtility.setup("/entity/hostile/slime/down.png", false ,false);
		right2 = imageUtility.setup("/entity/hostile/slime/down.png", false ,false);
	}
}
