package main.settings;

import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.lang.constant.Constable;
import java.util.HashMap;

public class ControlSettings extends Setting{
	GamePanel gp;

	private final HashMap<ControlSettingTypes, ControlSettingAssignment> assignmentType = new HashMap<>();
	private final HashMap<ControlSettingTypes, ControlSettingAssignment> defaultAssignmentType = new HashMap<>();
	private final HashMap<ControlSettingTypes, Integer> keyboardSettingValue = new HashMap<>();
	private final HashMap<ControlSettingTypes, Integer> defaultSettingValue = new HashMap<>();
	private final HashMap<ControlSettingTypes, Integer> mouseSettingValue = new HashMap<>();

	public ControlSettings(GamePanel gp) {
		this.gp = gp;
		setupDefaultValues();
	}


	public final void setupDefaultValues() {
		setControlSettings(ControlSettingTypes.MOVEMENT_NORTH, ControlSettingAssignment.KEYBOARD, KeyEvent.VK_W);
		setControlSettings(ControlSettingTypes.MOVEMENT_EAST, ControlSettingAssignment.KEYBOARD, KeyEvent.VK_D);
		setControlSettings(ControlSettingTypes.MOVEMENT_SOUTH, ControlSettingAssignment.KEYBOARD, KeyEvent.VK_S);
		setControlSettings(ControlSettingTypes.MOVEMENT_WEST, ControlSettingAssignment.KEYBOARD, KeyEvent.VK_A);
		setControlSettings(ControlSettingTypes.PICKUP_ITEM, ControlSettingAssignment.KEYBOARD, KeyEvent.VK_E);
		setControlSettings(ControlSettingTypes.INTERACT_NPC, ControlSettingAssignment.KEYBOARD, KeyEvent.VK_E);
		setControlSettings(ControlSettingTypes.USE_ITEM, ControlSettingAssignment.KEYBOARD, KeyEvent.VK_E);

		setControlSettings(ControlSettingTypes.ATTACK, ControlSettingAssignment.MOUSE, MouseEvent.BUTTON1);
//		setControlSettings(ControlSettingTypes.USE_ITEM, ControlSettingAssignment.MOUSE, MouseEvent.BUTTON2);

		defaultsSet = true;
	}

	public ControlSettingAssignment getAssignedKeyType(ControlSettingTypes controlSettingType) {
		return assignmentType.get(controlSettingType);
	}
	public int getAssignedKey(ControlSettingTypes controlSettingType) {
		if (assignmentType.get(controlSettingType) == ControlSettingAssignment.MOUSE) {
			return mouseSettingValue.get(controlSettingType);
		} else if (assignmentType.get(controlSettingType) == ControlSettingAssignment.KEYBOARD) {
			return keyboardSettingValue.get(controlSettingType);
		}
		return 0;
	}
	public String translateMouseButton(int index) {
		if (index == 1) {
			return "Button 1";
		}
		if (index == 2) {
			return "Button 2";
		}
		if (index == 3) {
			return "Button 3";
		}
		if (index == 4) {
			return "Button 4";
		}
		if (index == 5) {
			return "Button 5";
		}
		return "UNKNOWN_BUTTON";
	}
	public void resetAssignedKey(ControlSettingTypes controlSettingType) {
		setAssignmentKey(controlSettingType, defaultAssignmentType.get(controlSettingType), defaultSettingValue.get(controlSettingType));
	}
	public void setAssignmentKey(ControlSettingTypes controlName, ControlSettingAssignment controlSettingType, int controlSettingValue) {
		if (assignmentType.get(controlName) == ControlSettingAssignment.KEYBOARD){
			keyboardSettingValue.remove(controlName);
		} else if (assignmentType.get(controlName) == ControlSettingAssignment.MOUSE) {
			mouseSettingValue.remove(controlName);
		}
		assignmentType.remove(controlName);
		assignmentType.put(controlName, controlSettingType);
		if (controlSettingType == ControlSettingAssignment.KEYBOARD) {
			keyboardSettingValue.put(controlName, controlSettingValue);
		} else if (controlSettingType == ControlSettingAssignment.MOUSE){
			mouseSettingValue.put(controlName, controlSettingValue);
		}
	}
	boolean defaultsSet = false;
	public void resetControls() {
		defaultsSet = false;
		defaultSettingValue.clear();
		defaultAssignmentType.clear();
		keyboardSettingValue.clear();
		mouseSettingValue.clear();
		assignmentType.clear();
		setupDefaultValues();
	}
	public void setControlSettings(ControlSettingTypes controlSetting, ControlSettingAssignment defaultAssignmentType, int controlCode) {
		if (defaultsSet) {
			return;
		}
		this.assignmentType.put(controlSetting, defaultAssignmentType);
		this.defaultAssignmentType.put(controlSetting, defaultAssignmentType);
		this.defaultSettingValue.put(controlSetting, controlCode);
		if (defaultAssignmentType == ControlSettingAssignment.MOUSE) {
			this.mouseSettingValue.put(controlSetting, controlCode);
		} else if (defaultAssignmentType == ControlSettingAssignment.KEYBOARD) {
			this.keyboardSettingValue.put(controlSetting, controlCode);
		}
	}

	public int getDefaultControl(ControlSettingTypes controlSettingTypes) {
		return defaultSettingValue.get(controlSettingTypes);
	}
	public ControlSettingAssignment getDefaultAssignment(ControlSettingTypes controlSettingType) {
		return defaultAssignmentType.get(controlSettingType);
	}
}
