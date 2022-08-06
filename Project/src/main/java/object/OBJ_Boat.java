package object;

import entity.Entity;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Boat extends Entity {
	public OBJ_Boat() {
		setName("Boat");
		try {
			setImage(ImageIO.read(getClass().getResource("/boat/boat_updown.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}