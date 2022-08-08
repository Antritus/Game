package main.ui.menu;

import entity.Entity;
import entity.object.Object;
import main.GamePanel;
import object.OBJ_Heart;
import util.ImageUtility;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameUI {
	private int imageWidth = 16;
	private int imageHeight = 16;
	private BufferedImage redHeartImage100;
	private BufferedImage redHeartImage80;
	private BufferedImage redHeartImage60;
	private BufferedImage redHeartImage40;
	private BufferedImage redHeartImage20;
	private BufferedImage redHeartImage0;
	private BufferedImage shieldImage100;
	private BufferedImage shieldImage75;
	private BufferedImage shieldImage50;
	private BufferedImage shieldImage25;
	private BufferedImage shieldImage0;
	GamePanel gp;
	ImageUtility imageUtility;
	public GameUI(GamePanel gp) {
		this.gp = gp;
		imageUtility = new ImageUtility(gp);
		getImage();
	}


	public void getImage() {
			OBJ_Heart heart = new OBJ_Heart(gp);
			redHeartImage100 = heart.getObjectImage();
			redHeartImage80 = heart.getObjectImage2();
			redHeartImage60 = heart.getObjectImage3();
			redHeartImage40 = heart.getObjectImage4();
			redHeartImage20 = heart.getObjectImage5();
			redHeartImage0 = heart.getObjectImage6();
	}

	public BufferedImage[] getHeart(double stage) {
		BufferedImage[] images = new BufferedImage[5];
		double realDiff = gp.player.getHealth()/5.0;
		if (stage == 1.0) {
			images[0] = redHeartImage100;
			images[1] = redHeartImage100;
			images[2] = redHeartImage100;
			images[3] = redHeartImage100;
			images[4] = redHeartImage100;
		}
		else if (stage >= 0.8 && stage < 1.0) {
			images[0] = redHeartImage100;
			images[1] = redHeartImage100;
			images[2] = redHeartImage100;
			images[3] = redHeartImage100;
			if (stage < 0.85) {
				images[4] = redHeartImage0;
			} else if (stage < 0.89) {
				images[4] = redHeartImage20;
			} else if (stage < 0.93) {
				images[4] = redHeartImage40;
			} else if (stage < 0.97) {
				images[4] = redHeartImage60;
			} else {
				images[4] = redHeartImage80;
			}

		}
		else if (stage >= 0.6 && stage < 0.8) {
			images[0] = redHeartImage100;
			images[1] = redHeartImage100;
			images[2] = redHeartImage100;
			if (stage < 0.65) {
				images[3] = redHeartImage0;
			} else if (stage < 0.69) {
				images[3] = redHeartImage20;
			} else if (stage < 0.73) {
				images[3] = redHeartImage40;
			} else if (stage < 0.77) {
				images[3] = redHeartImage60;
			} else {
				images[3] = redHeartImage80;
			}
			images[4] = redHeartImage0;
		}
		else if (stage >= 0.4 && stage < 0.6) {
			images[0] = redHeartImage100;
			images[1] = redHeartImage100;
			if (stage < 0.45) {
				images[2] = redHeartImage0;
			} else if (stage < 0.49) {
				images[2] = redHeartImage20;
			} else if (stage < 0.53) {
				images[2] = redHeartImage40;
			} else if (stage < 0.57) {
				images[2] = redHeartImage60;
			} else {
				images[2] = redHeartImage80;
			}
			images[3] = redHeartImage0;
			images[4] = redHeartImage0;
		}
		else if (stage >= 0.2 && stage < 0.4) {
			images[0] = redHeartImage100;
			if (stage < 0.25) {
				images[1] = redHeartImage0;
			} else if (stage < 0.29) {
				images[1] = redHeartImage20;
			} else if (stage < 0.33) {
				images[1] = redHeartImage40;
			} else if (stage < 0.37) {
				images[1] = redHeartImage60;
			} else {
				images[1] = redHeartImage80;
			}
			images[2] = redHeartImage0;
			images[3] = redHeartImage0;
			images[4] = redHeartImage0;
		} else {
			if (stage < 0.05) {
				images[0] = redHeartImage0;
			} else if (stage < 0.09) {
				images[0] = redHeartImage20;
			} else if (stage < 0.13) {
				images[0] = redHeartImage40;
			} else if (stage < 0.17) {
				images[0] = redHeartImage60;
			} else {
				images[0] = redHeartImage80;
			}
			images[1] = redHeartImage0;
			images[2] = redHeartImage0;
			images[3] = redHeartImage0;
			images[4] = redHeartImage0;
		}
		return images;
	}
	public void updateHearts() {
		this.drawHearts();
	}
	public void drawHearts() {
		int x = 15;
		int y = 15;
		int scale = gp.tileSize;
		if (g2 == null) {
			return;
		}
		for (BufferedImage image : getHeart((gp.player.getHealthPercentage()))){
				g2.drawImage(image, x, y, scale, scale, null);
				x+=scale;
			}
		}
	int x;
	int y;
	int scale;
	Graphics2D g2;
	public void draw(Graphics2D g2){
		this.g2 = g2;
		scale = gp.tileSize;
		x = 15;
		y = 15;
		int scale = gp.tileSize;
		if (!gp.isDebuggingOn()) {
			drawHearts();
		}
	}

}
