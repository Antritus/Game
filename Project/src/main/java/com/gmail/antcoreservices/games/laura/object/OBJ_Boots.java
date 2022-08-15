package com.gmail.antcoreservices.games.laura.object;

import com.gmail.antcoreservices.games.laura.main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Boots extends com.gmail.antcoreservices.games.laura.entity.object.Object {
	public OBJ_Boots(GamePanel gp) {
		super(gp);
		setName("Boots");
		try {
			setImage(ImageIO.read(getClass().getResource("/objects/boots.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
