package com.gmail.antcoreservices.games.laura.object;

import com.gmail.antcoreservices.games.laura.main.GamePanel;
import com.gmail.antcoreservices.games.laura.util.ImageUtility;
import com.gmail.antcoreservices.games.laura.util.SpriteSheet;

import java.awt.image.BufferedImage;

public class OBJ_Heart extends com.gmail.antcoreservices.games.laura.entity.object.Object {
	public OBJ_Heart(GamePanel gp) {
		super(gp);
		setName("Heart");
		BufferedImage ImageSheet = null;
		ImageUtility imageUtility = new ImageUtility(gp);
		ImageSheet = imageUtility.setup("/objects/health/hearts.png");
		SpriteSheet spriteSheet = new SpriteSheet(ImageSheet);
		setImage(spriteSheet.getSprite(3,2, 16, 16));
		setImage2(spriteSheet.getSprite(2,2, 16, 16));
		setImage3(spriteSheet.getSprite(1,2, 16, 16));
		setImage4(spriteSheet.getSprite(3,1, 16, 16));
		setImage5(spriteSheet.getSprite(2,1, 16, 16));
		setImage6(spriteSheet.getSprite(1,1, 16, 16));
	}

}
