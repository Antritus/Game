package util;

import main.GamePanel;

import java.awt.image.BufferedImage;

public class ImageGallery {
	private GamePanel gp;
	private ImageUtility imageUtility;
	public ImageGallery(GamePanel gp, ImageUtility imageUtility) {
		this.gp = gp;
		this.imageUtility = imageUtility;
	}

	private final BufferedImage player_up_1 = imageUtility.setup("/entity/player/up.png", false, false);

	private final BufferedImage player_up_2 = imageUtility.setup("/entity/player/up.png", true ,false);
	private final BufferedImage player_down_1 = imageUtility.setup("/entity/player/down.png", false ,false);
	private final BufferedImage player_down_2 = imageUtility.setup("/entity/player/down.png", true ,false);
	private final BufferedImage player_right_1 = imageUtility.setup("/entity/player/side.png", false ,false);
	private final BufferedImage player_right_2 = imageUtility.setup("/entity/player/side2.png", false ,false);
	private final BufferedImage player_left_1 = imageUtility.setup("/entity/player/side.png", true ,false);
	private final BufferedImage player_left_2 = imageUtility.setup("/entity/player/side2.png", true ,false);

	private final BufferedImage player_class_icon_knight = imageUtility.setup("/entity/player/knight_class/icon.png", false, false);
	private final BufferedImage player_class_icon_archer = imageUtility.setup("/entity/player/archer_class/icon.png", false, false);
	private final BufferedImage player_class_icon_timewarp = imageUtility.setup("/entity/player/timewarp_class/icon.png", false, false);

	private final BufferedImage slime_up = imageUtility.setup("/entity/hostile/slime/up.png", false, false);
	private final BufferedImage slime_down = imageUtility.setup("/entity/hostile/slime/down.png", false, false);

	private final BufferedImage old_man_up_1 = imageUtility.setup("/entity/npc/oldman/up.png", false, false);
	private final BufferedImage old_man_up_2 = imageUtility.setup("/entity/npc/oldman/up.png", true, false);
	private final BufferedImage old_man_down_1 = imageUtility.setup("/entity/npc/oldman/down.png", false, false);
	private final BufferedImage old_man_down_2 = imageUtility.setup("/entity/npc/oldman/down.png", true, false);
	private final BufferedImage old_man_right_1 = imageUtility.setup("/entity/npc/oldman/side.png", false, false);
	private final BufferedImage old_man_right_2 = imageUtility.setup("/entity/npc/oldman/side2.png", false, false);
	private final BufferedImage old_man_left_1 = imageUtility.setup("/entity/npc/oldman/side.png", true, false);
	private final BufferedImage old_man_left_2 = imageUtility.setup("/entity/npc/oldman/side2.png", true, false);

	private final BufferedImage object_hearts = imageUtility.setup("/objects/health/hearts.png", false, false);
	private final BufferedImage object_heart_0 = ImageUtility.scale(new SpriteSheet(object_hearts).getSprite(0, 0, 16, 16), gp.tileSize, gp.tileSize);
	private final BufferedImage object_heart_20 = ImageUtility.scale(new SpriteSheet(object_hearts).getSprite(1, 0, 16, 16), gp.tileSize, gp.tileSize);
	private final BufferedImage object_heart_40 = ImageUtility.scale(new SpriteSheet(object_hearts).getSprite(2, 0, 16, 16), gp.tileSize, gp.tileSize);
	private final BufferedImage object_heart_60 = ImageUtility.scale(new SpriteSheet(object_hearts).getSprite(0, 0, 16, 16), gp.tileSize, gp.tileSize);
	private final BufferedImage object_heart_80 = ImageUtility.scale(new SpriteSheet(object_hearts).getSprite(1, 1, 16, 16), gp.tileSize, gp.tileSize);
	private final BufferedImage object_heart_100 = ImageUtility.scale(new SpriteSheet(object_hearts).getSprite(2, 1, 16, 16), gp.tileSize, gp.tileSize);

	private final BufferedImage object_arrow_up = imageUtility.setup("/objects/arrow/up.png", true, false);
	private final BufferedImage object_arrow_down = imageUtility.setup("/objects/arrow/down.png", true, false);
	private final BufferedImage object_arrow_left = imageUtility.setup("/objects/arrow/left.png", true, false);
	private final BufferedImage object_arrow_right = imageUtility.setup("/objects/arrow/right.png", true, false);


	public BufferedImage getPlayer_up_1() {
		return player_up_1;
	}

	public BufferedImage getPlayer_up_2() {
		return player_up_2;
	}

	public BufferedImage getPlayer_down_1() {
		return player_down_1;
	}

	public BufferedImage getPlayer_down_2() {
		return player_down_2;
	}

	public BufferedImage getPlayer_right_1() {
		return player_right_1;
	}

	public BufferedImage getPlayer_right_2() {
		return player_right_2;
	}

	public BufferedImage getPlayer_left_1() {
		return player_left_1;
	}

	public BufferedImage getPlayer_left_2() {
		return player_left_2;
	}

	public BufferedImage getPlayer_class_icon_knight() {
		return player_class_icon_knight;
	}

	public BufferedImage getPlayer_class_icon_archer() {
		return player_class_icon_archer;
	}

	public BufferedImage getPlayer_class_icon_timewarp() {
		return player_class_icon_timewarp;
	}

	public BufferedImage getSlime_up() {
		return slime_up;
	}

	public BufferedImage getSlime_down() {
		return slime_down;
	}

	public BufferedImage getOld_man_up_1() {
		return old_man_up_1;
	}

	public BufferedImage getOld_man_up_2() {
		return old_man_up_2;
	}

	public BufferedImage getOld_man_down_1() {
		return old_man_down_1;
	}

	public BufferedImage getOld_man_down_2() {
		return old_man_down_2;
	}

	public BufferedImage getOld_man_right_1() {
		return old_man_right_1;
	}

	public BufferedImage getOld_man_right_2() {
		return old_man_right_2;
	}

	public BufferedImage getOld_man_left_1() {
		return old_man_left_1;
	}

	public BufferedImage getOld_man_left_2() {
		return old_man_left_2;
	}

	public BufferedImage getObject_heart_0() {
		return object_heart_0;
	}

	public BufferedImage getObject_heart_20() {
		return object_heart_20;
	}

	public BufferedImage getObject_heart_40() {
		return object_heart_40;
	}

	public BufferedImage getObject_heart_60() {
		return object_heart_60;
	}

	public BufferedImage getObject_heart_80() {
		return object_heart_80;
	}

	public BufferedImage getObject_heart_100() {
		return object_heart_100;
	}

	public BufferedImage getObject_arrow_up() {
		return object_arrow_up;
	}

	public BufferedImage getObject_arrow_left() {
		return object_arrow_left;
	}

	public BufferedImage getObject_arrow_down() {
		return object_arrow_down;
	}

	public BufferedImage getObject_arrow_right() {
		return object_arrow_right;
	}
}