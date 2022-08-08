package object;

import entity.Entity;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Key extends entity.object.Object {
	public OBJ_Key() {
		setName("Key");
		try {
			setImage(ImageIO.read(getClass().getResource("/objects/key02.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
