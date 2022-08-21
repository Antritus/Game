package com.gmail.antcoreservices.games.laura.main.simple;

import com.gmail.antcoreservices.games.laura.main.GamePanel;
import com.gmail.antcoreservices.games.laura.main.settings.ControlSettingAssignment;
import com.gmail.antcoreservices.games.laura.main.settings.ControlSettingTypes;

import java.awt.*;
import java.awt.event.*;


public class SimpleKeyHandler implements KeyListener {
	public boolean upPressed, downPressed, leftPressed, rightPressed;
	SimpleGamePanel gp;
	public void setSolidArea(Rectangle rectangle) {
		this.solidArea = rectangle;
	}
	private Rectangle solidArea;
	public Rectangle getSolidArea() {
		return this.solidArea;
	}

	public SimpleKeyHandler(SimpleGamePanel gp) {
		this.gp = gp;
		setSolidArea(new Rectangle());
		getSolidArea().x = 0;
		getSolidArea().y = 0;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_W) {
			upPressed = true;
			downPressed = false;
		}
		if (code == KeyEvent.VK_D) {
			downPressed = true;
			upPressed = false;
		}
		if (code == KeyEvent.VK_A) {
			leftPressed = true;
			rightPressed = false;
		}
		if (code == KeyEvent.VK_D) {
			rightPressed = true;
			leftPressed = false;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_W) {
			upPressed = false;
		}
		if (code == KeyEvent.VK_D) {
			downPressed = false;
		}
		if (code == KeyEvent.VK_A) {
			leftPressed = false;
		}
		if (code == KeyEvent.VK_D) {
			rightPressed = false;
		}

	}

}