package com.gmail.antcoreservices.games.laura.object;

import com.gmail.antcoreservices.games.laura.main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Chest extends com.gmail.antcoreservices.games.laura.entity.object.Object {
	public OBJ_Chest(GamePanel gp) {
		super(gp);
		setName("Chest");
		try {
			setImage(ImageIO.read(getClass().getResource("/objects/chest.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
