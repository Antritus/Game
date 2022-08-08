package object;

import entity.Entity;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Door extends entity.object.Object {
	public OBJ_Door() {
		setName("Door");
		try {
			setImage(ImageIO.read(getClass().getResource("/objects/door.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setHasCollision(true);
	}
}
