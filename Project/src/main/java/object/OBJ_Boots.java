package object;

import entity.Entity;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Boots extends Entity {
	public OBJ_Boots() {
		setName("Boots");
		try {
			setImage(ImageIO.read(getClass().getResource("/objects/boots.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}