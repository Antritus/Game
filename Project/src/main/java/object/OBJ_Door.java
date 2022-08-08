package object;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Door extends entity.object.object.Object {
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
