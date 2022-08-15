package com.gmail.antcoreservices.games.laura.object;

import com.gmail.antcoreservices.games.laura.main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Diamond_Key extends com.gmail.antcoreservices.games.laura.entity.object.Object {
	public OBJ_Diamond_Key(GamePanel gp) {
		super(gp);
		setName("DiamondKey");
		try {
			setImage(ImageIO.read(getClass().getResource("/objects/key03.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
