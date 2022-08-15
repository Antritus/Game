package com.gmail.antcoreservices.games.laura.main.ui;

import com.gmail.antcoreservices.games.laura.main.GamePanel;

public enum ButtonInfo {
	EXTRA_EXTRA_SMALL,
	EXTRA_SMALL,
	SMALL,
	MEDIUM,
	LARGE;

	public static int[] getButtonSize(GamePanel gp, ButtonInfo buttonInfo) {
		int[] returnValues = new int[2];
		returnValues[1] = gp.getDefaultSettings().getTileSize() -  gp.getDefaultSettings().getTileSize()/4;
		if (buttonInfo == EXTRA_EXTRA_SMALL) {
			returnValues[0] = gp.getDefaultSettings().getTileSize();
			returnValues[1] = gp.getDefaultSettings().getTileSize();
		} else if (buttonInfo == EXTRA_SMALL) {
			returnValues[0] = 2 * gp.getDefaultSettings().getTileSize();
		} else if (buttonInfo == SMALL) {
			returnValues[0] = 3*gp.getDefaultSettings().getTileSize();
		} else if (buttonInfo == MEDIUM) {
			returnValues[0] = 4*gp.getDefaultSettings().getTileSize();
		} else if (buttonInfo == LARGE) {
			returnValues[0] = 5*gp.getDefaultSettings().getTileSize();
		}
		return returnValues;
	}

}
