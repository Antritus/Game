package object;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Chest extends entity.object.object.Object {
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
