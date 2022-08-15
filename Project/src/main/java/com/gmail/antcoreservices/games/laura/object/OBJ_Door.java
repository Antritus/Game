package com.gmail.antcoreservices.games.laura.object;

import com.gmail.antcoreservices.games.laura.main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Door extends com.gmail.antcoreservices.games.laura.entity.object.Object {
	public OBJ_Door(GamePanel gp) {
		super(gp);
		setName("Door");
		try {
			setImage(ImageIO.read(getClass().getResource("/objects/door.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setHasCollision(true);
	}
}
