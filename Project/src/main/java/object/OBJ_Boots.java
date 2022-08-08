package object;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Boots extends entity.object.Object {
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
