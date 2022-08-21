package com.gmail.antcoreservices.games.laura.main;

import com.gmail.antcoreservices.games.laura.util.panelextenions.ACAlert;

import java.awt.*;
import java.util.ArrayList;

public class Debug {
	GamePanel gp;
	ACAlert acAlert = new ACAlert();
	public Debug(GamePanel gp) {
		this.gp = gp;
	}

	public void drawDebug(Graphics2D g2) {
		Color color = g2.getColor();
		g2.setColor(Color.RED);
		g2.setFont(gp.debugFont);
		ArrayList<String> list = new ArrayList<>();
		list.add("Drawing Time: " + gp.getDrawTime());
		list.add("FPS: " + gp.FPS);
		list.add("Game State: " + gp.gameState);
		list.add("");

		list.add("Mouse Cursor X: " + gp.getKeyHandler().mouseX);
		list.add("Mouse Cursor Y: " + gp.getKeyHandler().mouseY);
		list.add("Mouse Cursor Direction: " + gp.getUISystem().getMouseCursorLocation().getDirection());
		list.add("Mouse Cursor Angle: " + gp.getUISystem().getMouseCursorLocation().getAngle());
		list.add("Mouse Cursor True Angle: " + gp.getUISystem().getMouseCursorLocation().getTrueAngle());
		list.add("Mouse Scroll Wheel: " + gp.getKeyHandler().mouseScrollAmountMoved);
		list.add("Mouse Scroll Wheel Total: " + gp.getKeyHandler().mouseScrollAmountTotal);
		list.add("");

		list.add("Player Health: " + gp.player.getHealth());
		list.add("Player Max Health: " + gp.player.getMaxHealth());
		list.add("Player Health Percentage: " + gp.player.getHealthPercentage());
		list.add("Player Colliding Tile: " + gp.player.isCollidingTile());
		list.add("Player Colliding Object: " + gp.player.isCollidingObject());
		list.add("Player Colliding Entity: " + gp.player.isCollidingNPC());
		list.add("Player Colliding Player: " + gp.player.isCollidingPlayer());
		list.add("Player X: " + gp.player.getX());
		list.add("Player Y: " + gp.player.getY());
		list.add("Player Col: Todo");
		list.add("Player Row: Todo");
		list.add("");
		int x = 5;
		int y = 20;
		int add = 20;
		for (String v : list) {
			g2.drawString(v, x, y);
			y+=add;
		}
		g2.setColor(color);

	}
}
