package eventtodo;

import main.Direction;
import main.GamePanel;

import java.awt.*;

public class EventHandler {

	GamePanel gp;
	private Rectangle eventRect;
	private int eventRectDefaultX, eventRectDefaultY;

	public EventHandler(GamePanel gp) {
		this.gp = gp;

		eventRect = new Rectangle();
		eventRect.x = 23;
		eventRect.y = 23;
		eventRect.width = 2;
		eventRect.height = 2;
		eventRectDefaultX = eventRect.x;
		eventRectDefaultY = eventRect.y;
	}

	public void checkEvent() {

	}

	public boolean hit(int eventCol, int eventRow, Direction direction) {
		boolean hit = false;

		gp.player.getSolidArea().x = gp.player.getX() + gp.player.getSolidArea().x;
		gp.player.getSolidArea().y = gp.player.getY() + gp.player.getSolidArea().y;

		eventRect.x = eventCol*gp.tileSize + eventRect.x;
		eventRect.y = eventRow*gp.tileSize + eventRect.y;

		if (gp.player.getSolidArea().intersects(eventRect)) {
			if (gp.player.getDirection() == direction || direction == Direction.ALL) {
				hit = true;
			}
		}

		gp.player.getSolidArea().x = gp.player.getSolidAreaDefaultX();
		gp.player.getSolidArea().y = gp.player.getSolidAreaDefaultY();
		eventRect.x = eventRectDefaultX;
		eventRect.y = eventRectDefaultY;

		return hit;
	}
}
