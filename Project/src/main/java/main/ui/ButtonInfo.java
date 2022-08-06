package main.ui;

import main.GamePanel;

public enum ButtonInfo {
	EXTRA_EXTRA_SMALL,
	EXTRA_SMALL,
	SMALL,
	MEDIUM,
	LARGE;

	public static int[] getButtonSize(GamePanel gp, ButtonInfo buttonInfo) {
		int[] returnValues = new int[2];
		returnValues[1] = gp.tileSize -  gp.tileSize/4;
		if (buttonInfo == EXTRA_EXTRA_SMALL) {
			returnValues[0] = gp.tileSize;
			returnValues[1] = gp.tileSize;
		} else if (buttonInfo == EXTRA_SMALL) {
			returnValues[0] = 2 * gp.tileSize;
		} else if (buttonInfo == SMALL) {
			returnValues[0] = 3*gp.tileSize;
		} else if (buttonInfo == MEDIUM) {
			returnValues[0] = 4*gp.tileSize;
		} else if (buttonInfo == LARGE) {
			returnValues[0] = 5*gp.tileSize;
		}
		return returnValues;
	}

}
