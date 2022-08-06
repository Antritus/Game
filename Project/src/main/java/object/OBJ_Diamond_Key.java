package object;

import entity.Entity;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Diamond_Key extends Entity {
	public OBJ_Diamond_Key() {
		setName("DiamondKey");
		try {
			setImage(ImageIO.read(getClass().getResource("/objects/key03.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}