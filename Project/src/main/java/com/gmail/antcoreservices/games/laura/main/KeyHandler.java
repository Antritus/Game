package com.gmail.antcoreservices.games.laura.main;

import com.gmail.antcoreservices.games.laura.main.settings.ControlSettingAssignment;
import com.gmail.antcoreservices.games.laura.main.settings.ControlSettingTypes;

import java.awt.*;
import java.awt.event.*;


public class KeyHandler implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {
	public boolean upPressed, downPressed, leftPressed, rightPressed, paused;
	public boolean upPressedReal, downPressedReal;
	GamePanel gp;
	public void setSolidArea(Rectangle rectangle) {
		this.solidArea = rectangle;
	}
	private Rectangle solidArea;
	public Rectangle getSolidArea() {
		return this.solidArea;
	}

	public KeyHandler(GamePanel gp) {
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
		if (gp.getControlSettings().getAssignedKeyType(ControlSettingTypes.MOVEMENT_NORTH) == ControlSettingAssignment.KEYBOARD && gp.getControlSettings().getAssignedKey(ControlSettingTypes.MOVEMENT_NORTH) == e.getKeyCode()) {
			upPressed = true;
			downPressed = false;
			upPressedReal = true;
		}
		if (gp.getControlSettings().getAssignedKeyType(ControlSettingTypes.MOVEMENT_SOUTH) == ControlSettingAssignment.KEYBOARD && gp.getControlSettings().getAssignedKey(ControlSettingTypes.MOVEMENT_SOUTH) == e.getKeyCode()) {
			downPressed = true;
			upPressed = false;
			downPressedReal = true;
		}
		if (gp.getControlSettings().getAssignedKeyType(ControlSettingTypes.MOVEMENT_WEST) == ControlSettingAssignment.KEYBOARD && gp.getControlSettings().getAssignedKey(ControlSettingTypes.MOVEMENT_WEST) == e.getKeyCode()) {
			leftPressed = true;
			rightPressed = false;
		}
		if (gp.getControlSettings().getAssignedKeyType(ControlSettingTypes.MOVEMENT_EAST) == ControlSettingAssignment.KEYBOARD && gp.getControlSettings().getAssignedKey(ControlSettingTypes.MOVEMENT_EAST) == e.getKeyCode()) {
			rightPressed = true;
			leftPressed = false;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if (gp.getUISystem().getControlSettingsMenu().isResetting[gp.getUISystem().getControlSettingsMenu().getActionChangeInteger()]){
			gp.getUISystem().getControlSettingsMenu().setActionKey(e.getKeyCode(), gp.getUISystem().getControlSettingsMenu().getControlSettingType(gp.getUISystem().getControlSettingsMenu().getActionChangeInteger()), ControlSettingAssignment.KEYBOARD);
			gp.getControlSettings().setAssignmentKey(gp.getUISystem().getControlSettingsMenu().getControlSettingType(gp.getUISystem().getControlSettingsMenu().getActionChangeInteger()), ControlSettingAssignment.KEYBOARD, e.getKeyCode());
//			gp.getUISystem().getControlSettingsMenu().isResetting[gp.getUISystem().getControlSettingsMenu().getActionChangeInteger()] = false;
		}

		int code = e.getKeyCode();
		if (gp.gameState == gp.getMainMenuState()) {
			if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
				gp.getUISystem().setCurrentSlotIndex(gp.getUISystem().getMainMenu().getMainMenuSlot(gp.getUISystem().getMainMenu().getMainMenuSlot()) - 1);
				gp.getUISystem().getMainMenu().setMainMenuSlot(gp.getUISystem().getMainMenu().getMainMenuSlot(gp.getUISystem().getMainMenu().getMainMenuSlot(gp.getUISystem().getMainMenu().getMainMenuSlot())-1));
				if (gp.getUISystem().getCurrentSlotIndex() < 0) {
					gp.getUISystem().setCurrentSlotIndex(0);
					gp.getUISystem().getMainMenu().setMainMenuSlot(gp.getUISystem().getMainMenu().getMainMenuSlot(0));
				}
				hasMouseMoved = false;
			} if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
				gp.getUISystem().setCurrentSlotIndex(gp.getUISystem().getMainMenu().getMainMenuSlot(gp.getUISystem().getMainMenu().getMainMenuSlot()) + 1);
				gp.getUISystem().getMainMenu().setMainMenuSlot(gp.getUISystem().getMainMenu().getMainMenuSlot(gp.getUISystem().getMainMenu().getMainMenuSlot(gp.getUISystem().getMainMenu().getMainMenuSlot()) +1));
				if (gp.getUISystem().getCurrentSlotIndex() == gp.getUISystem().getCurrentSlotMaxIndex()+1) {
					gp.getUISystem().setCurrentSlotIndex(gp.getUISystem().getCurrentSlotMaxIndex());
					gp.getUISystem().getMainMenu().setMainMenuSlot(gp.getUISystem().getMainMenu().getMainMenuSlot(gp.getUISystem().getCurrentSlotMaxIndex()));
				}
				hasMouseMoved = false;
			}
			if (code == KeyEvent.VK_ENTER) {
				gp.getUISystem().buttonAction();
			}
		}
		else if (gp.gameState == gp.getSkinMenuState()){
			if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
				gp.getUISystem().getSkinMenu().setSkinMenuSlot((Integer) gp.getUISystem().getSkinMenu().getSkinMenuSlot(true) - 1);
			} if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
				gp.getUISystem().getSkinMenu().setSkinMenuSlot((Integer) gp.getUISystem().getSkinMenu().getSkinMenuSlot(true) + 1);
			}
		}
		else if (gp.gameState == gp.getPlayState()) {
			if (gp.getControlSettings().getAssignedKeyType(ControlSettingTypes.MOVEMENT_NORTH) == ControlSettingAssignment.KEYBOARD && gp.getControlSettings().getAssignedKey(ControlSettingTypes.MOVEMENT_NORTH) == e.getKeyCode()) {
				upPressed = false;
				upPressedReal = false;
			}
			if (gp.getControlSettings().getAssignedKeyType(ControlSettingTypes.MOVEMENT_SOUTH) == ControlSettingAssignment.KEYBOARD && gp.getControlSettings().getAssignedKey(ControlSettingTypes.MOVEMENT_SOUTH) == e.getKeyCode()) {
				downPressed = false;
				downPressedReal = false;
			}
			if (gp.getControlSettings().getAssignedKeyType(ControlSettingTypes.MOVEMENT_WEST) == ControlSettingAssignment.KEYBOARD && gp.getControlSettings().getAssignedKey(ControlSettingTypes.MOVEMENT_WEST) == e.getKeyCode()) {
				leftPressed = false;
			}
			if (gp.getControlSettings().getAssignedKeyType(ControlSettingTypes.MOVEMENT_EAST) == ControlSettingAssignment.KEYBOARD && gp.getControlSettings().getAssignedKey(ControlSettingTypes.MOVEMENT_EAST) == e.getKeyCode()) {
				rightPressed = false;
			}
			if (code == KeyEvent.VK_ESCAPE) {
				gp.setGameState(gp.getPauseState());
			}
			if (code == KeyEvent.VK_F1) {
				gp.stopMusic();
			}



		}
		else if (gp.getGameState() == gp.getPauseState()) {
			if (code == KeyEvent.VK_ESCAPE) {
				gp.setGameState(gp.getPlayState());
			}
			if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
				gp.getUISystem().setCurrentSlotIndex(gp.getUISystem().getPauseMenu().getPauseMenuSlot(gp.getUISystem().getPauseMenu().getPauseMenuSlot()) - 1);
				gp.getUISystem().getPauseMenu().setPauseMenuSlot(gp.getUISystem().getPauseMenu().getPauseMenuSlot(gp.getUISystem().getPauseMenu().getPauseMenuSlot(gp.getUISystem().getPauseMenu().getPauseMenuSlot())-1));
				if (gp.getUISystem().getCurrentSlotIndex() < 0) {
					gp.getUISystem().setCurrentSlotIndex(0);
					gp.getUISystem().getPauseMenu().setPauseMenuSlot(gp.getUISystem().getPauseMenu().getPauseMenuSlot(0));
				}

				hasMouseMoved = false;
			}
			if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
				gp.getUISystem().setCurrentSlotIndex(gp.getUISystem().getPauseMenu().getPauseMenuSlot(gp.getUISystem().getPauseMenu().getPauseMenuSlot()) + 1);
				gp.getUISystem().getPauseMenu().setPauseMenuSlot(gp.getUISystem().getPauseMenu().getPauseMenuSlot(gp.getUISystem().getPauseMenu().getPauseMenuSlot(gp.getUISystem().getPauseMenu().getPauseMenuSlot()) + 1));
				if (gp.getUISystem().getCurrentSlotIndex() == gp.getUISystem().getCurrentSlotMaxIndex()+1) {
					gp.getUISystem().setCurrentSlotIndex(gp.getUISystem().getCurrentSlotMaxIndex());
					gp.getUISystem().getPauseMenu().setPauseMenuSlot(gp.getUISystem().getPauseMenu().getPauseMenuSlot(gp.getUISystem().getCurrentSlotMaxIndex()));
				}
				hasMouseMoved = false;
			}
			if (code == KeyEvent.VK_ENTER) {
				gp.getUISystem().buttonAction();
			}
		}

		else if (gp.getGameState() == gp.getDialogState()) {
			if (code == KeyEvent.VK_ENTER) {
				gp.setGameState(gp.getPlayState());
			}
		}




		if (code == KeyEvent.VK_K) {
			if (gp.isDebuggingOn()) {
				gp.stopDebugging();
			} else {
				gp.startDebugging();
			}
		}
		if (code == KeyEvent.VK_UP) {
			gp.getUISystem().getControlSettingsMenu().updateMenuScrollbarY(1);
		}
		if (code == KeyEvent.VK_DOWN) {
			gp.getUISystem().getControlSettingsMenu().updateMenuScrollbarY(-1);
		}

	}
	public int mouseX;
	public int mouseY;
	public int mouseScrollAmountMoved;
	public int mouseScrollAmountTotal;
	private boolean hasMouseMoved;
	private boolean hasScrollWheelMoved;
	public boolean isInRectangle;
	private double lastMovementTime;
	private long lastScrollWheelMovementTime;
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			gp.getUISystem().buttonAction();
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		if (gp.getUISystem().getControlSettingsMenu().isResetting[gp.getUISystem().getControlSettingsMenu().getActionChangeInteger()]){
			gp.getControlSettings().setAssignmentKey(gp.getUISystem().getControlSettingsMenu().getControlSettingType(gp.getUISystem().getControlSettingsMenu().getActionChangeInteger()), ControlSettingAssignment.MOUSE, e.getButton());
			gp.getUISystem().getControlSettingsMenu().isResetting[gp.getUISystem().getControlSettingsMenu().getActionChangeInteger()] = false;
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		hasMouseMoved = true;
		lastMovementTime += 1;
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		mouseScrollAmountMoved = e.getWheelRotation();
		mouseScrollAmountTotal += e.getWheelRotation();
		lastScrollWheelMovementTime = System.currentTimeMillis()+(6*100);
	}
	public void resetMouseScrollWheel(){
		mouseScrollAmountMoved = 0;
	}

	public boolean isInsideRectangle(int x, int y, double width, double height) {
		isInRectangle = mouseX > x && mouseX < (x + width) && mouseY > y && mouseY < (y + height);
		return mouseX > x && mouseX < (x + width) && mouseY > y && mouseY < (y + height);
	}
	public boolean hasScrollWheelMoved() {
		if (hasScrollWheelMoved && lastScrollWheelMovementTime < System.currentTimeMillis()){
			hasScrollWheelMoved = false;
			resetMouseScrollWheel();
	}
		return hasMouseMoved;
	}
	public boolean hasMouseMoved() {
		if (hasMouseMoved && lastMovementTime < 60) {
			hasMouseMoved = false;
		}
		return hasMouseMoved;
	}

	public boolean isInRectangle() {
		return isInRectangle;
	}

	public void setInRectangle(boolean inRectangle) {
		this.isInRectangle = inRectangle;
	}
}