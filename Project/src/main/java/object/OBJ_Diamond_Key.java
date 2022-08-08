package object;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Diamond_Key extends entity.object.Object {
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
