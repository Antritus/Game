package com.gmail.antcoreservices.games.laura.object;

import com.gmail.antcoreservices.games.laura.main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Boat extends com.gmail.antcoreservices.games.laura.entity.object.Object {
	public OBJ_Boat(GamePanel gp) {
		super(gp);
		setName("Boat");
		try {
			setImage(ImageIO.read(getClass().getResource("/boat/boat_updown.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
