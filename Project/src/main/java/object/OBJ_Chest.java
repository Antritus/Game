package object;

import entity.Entity;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Chest extends Entity {
	public OBJ_Chest() {
		setName("Chest");
		try {
			setImage(ImageIO.read(getClass().getResource("/objects/chest.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}