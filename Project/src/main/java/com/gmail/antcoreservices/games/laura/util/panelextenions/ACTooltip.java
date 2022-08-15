package com.gmail.antcoreservices.games.laura.util.panelextenions;

import java.awt.*;

public class ACTooltip {

	private String string;

	private Color centerColor;
	private Color frameColor;
	private Color textColor;
	private int x;
	private int y;
	private int width;
	private int height;


	public ACTooltip() {
		frameColor = new Color(99, 130, 191);
		centerColor = new Color(184, 207, 229);
		textColor = new Color(51, 51, 51);
	}
	public ACTooltip(String string){
		this.string = string;
		frameColor = new Color(99, 130, 191);
		centerColor = new Color(184, 207, 229);
		textColor = new Color(51, 51, 51);
	}
}
