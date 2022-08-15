package com.gmail.antcoreservices.games.laura.object;

import com.gmail.antcoreservices.games.laura.main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Key extends com.gmail.antcoreservices.games.laura.entity.object.Object {
	public OBJ_Key(GamePanel gp) {
		super(gp);
		setName("Key");
		try {
			setImage(ImageIO.read(getClass().getResource("/objects/key02.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
