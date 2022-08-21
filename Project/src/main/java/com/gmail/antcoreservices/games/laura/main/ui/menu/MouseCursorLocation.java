package com.gmail.antcoreservices.games.laura.main.ui.menu;

import com.gmail.antcoreservices.games.laura.map.location.Direction;
import com.gmail.antcoreservices.games.laura.main.GamePanel;

import java.awt.*;

public class MouseCursorLocation {
	GamePanel gp;
	double mouseCursorAngle = 0.0;
	double mouseCursorTrueAngle = 0.0;
	Direction direction;
	public MouseCursorLocation(GamePanel gp) {
		this.gp = gp;
	}

	public void draw(Graphics2D g2) {
		String windowSide = "right";
		if (gp.getDefaultSettings().getScreenWidth()/2 >= gp.getKeyHandler().mouseX) {
			windowSide = "right";
		} else {
			windowSide = "left";
		}
		if (gp.isDebuggingOn()) {
			g2.setColor(Color.RED);
			g2.setStroke(new BasicStroke(2));
			g2.drawLine(gp.getDefaultSettings().getScreenWidth() / 2, gp.getDefaultSettings().getScreenHeight() / 2, gp.getKeyHandler().mouseX, gp.getKeyHandler().mouseY);

			g2.drawString("x: " + gp.getKeyHandler().mouseX, gp.getKeyHandler().mouseX, gp.getKeyHandler().mouseY);
			g2.drawString(" y: " + gp.getKeyHandler().mouseY, (float) (gp.getKeyHandler().mouseX + g2.getFontMetrics().getStringBounds("x: " + gp.getKeyHandler().mouseX, g2).getWidth()), gp.getKeyHandler().mouseY);

//			g2.drawLine(gp.screenWidth / 2, 0, gp.screenWidth / 2, gp.screenHeight / 2);
//			g2.drawLine(gp.screenWidth / 2, gp.screenHeight, gp.screenWidth / 2, gp.screenHeight / 2);
			g2.setFont(g2.getFont().deriveFont(50f));

			g2.drawLine(gp.getDefaultSettings().getScreenWidth() / 2 + 50, gp.getDefaultSettings().getScreenHeight() / 2 - 50, gp.getDefaultSettings().getScreenWidth() / 2 + 50, gp.getDefaultSettings().getScreenHeight() / 2);
			g2.drawLine(gp.getDefaultSettings().getScreenWidth() / 2, gp.getDefaultSettings().getScreenHeight() / 2 - 50, gp.getDefaultSettings().getScreenWidth() / 2 + 50, gp.getDefaultSettings().getScreenHeight() / 2 - 50);

			g2.drawLine(gp.getDefaultSettings().getScreenWidth() / 2 - 50, gp.getDefaultSettings().getScreenHeight() / 2 - 50, gp.getDefaultSettings().getScreenWidth() / 2 - 50, gp.getDefaultSettings().getScreenHeight() / 2);
			g2.drawLine(gp.getDefaultSettings().getScreenWidth() / 2, gp.getDefaultSettings().getScreenHeight() / 2 - 50, gp.getDefaultSettings().getScreenWidth() / 2 - 50, gp.getDefaultSettings().getScreenHeight() / 2 - 50);

			g2.drawLine(gp.getDefaultSettings().getScreenWidth() / 2 - 50, gp.getDefaultSettings().getScreenHeight() / 2 + 50, gp.getDefaultSettings().getScreenWidth() / 2 - 50, gp.getDefaultSettings().getScreenHeight() / 2);
			g2.drawLine(gp.getDefaultSettings().getScreenWidth() / 2, gp.getDefaultSettings().getScreenHeight() / 2 + 50, gp.getDefaultSettings().getScreenWidth() / 2 - 50, gp.getDefaultSettings().getScreenHeight() / 2 + 50);

			g2.drawLine(gp.getDefaultSettings().getScreenWidth() / 2 + 50, gp.getDefaultSettings().getScreenHeight() / 2 + 50, gp.getDefaultSettings().getScreenWidth() / 2 + 50, gp.getDefaultSettings().getScreenHeight() / 2);
			g2.drawLine(gp.getDefaultSettings().getScreenWidth() / 2, gp.getDefaultSettings().getScreenHeight() / 2 + 50, gp.getDefaultSettings().getScreenWidth() / 2 + 50, gp.getDefaultSettings().getScreenHeight() / 2 + 50);
		}
		double x = gp.getDefaultSettings().getScreenWidth()/2;
		double y = gp.getDefaultSettings().getScreenHeight()/2;
		double x2 = gp.getKeyHandler().mouseX;
		double y2 = gp.getKeyHandler().mouseY;

		double hypotenuse, adjacent, oposite, radians;
		hypotenuse  = Math.sqrt(Math.pow(x2-x,2) + Math.pow(y2-y,2));
		adjacent    = Math.sqrt(Math.pow(x-x,2) + Math.pow(y+50-y,2));
		oposite     = Math.sqrt(Math.pow(x2-x,2) + Math.pow(y2-(y+50),2));
		radians = Math.acos((Math.pow(adjacent,2) + Math.pow(hypotenuse,2)- Math.pow(oposite,2)) /(2*adjacent*hypotenuse));
		double degrees = Math.toDegrees(radians);

		mouseCursorTrueAngle = degrees;

		if (windowSide == "left") {
			degrees = 180 - degrees;
		} if (windowSide == "right") {
			degrees = 180.0 + degrees;
		}
		mouseCursorAngle = degrees;
		direction = Direction.getDirection(degrees);
	}
	public double getAngle(){
		return mouseCursorAngle;
	}
	public double getTrueAngle() {
		return mouseCursorTrueAngle;
	}
	public Direction getDirection() {
		return direction;
	}
}
