package com.gmail.antcoreservices.games.laura.util.panelextenions;

import java.awt.*;
import java.util.HashMap;

public class ACString {
	private final ACObjects acObjects = new ACObjects();

	private final HashMap<Integer, Color> colorPositions = new HashMap<>();
	private String string;
	private Color lastColor = null;
	private final Font font;
	private final int x;
	private final int y;



	public void updateColorCodes() {
		StringBuilder colorBuilder = new StringBuilder();
		StringBuilder stringBuilder = new StringBuilder();
		int pos = 0;
		boolean buildingColor = false;
		for (String character : string.split("")){
			if (buildingColor) {
				colorBuilder.append(character);
				if (colorBuilder.toString().length() > acObjects.getColorCodeMaxLength()) {
					colorBuilder = null;
					buildingColor = false;
				}
				if (acObjects.getColorCodes().containsKey(colorBuilder)){
					colorPositions.put(colorBuilder.length(), acObjects.getColorCodes().get(colorBuilder));
					colorBuilder = null;
					buildingColor = false;
					pos++;
					continue;
				}
			} else {
				if (character.equals(acObjects.getColorCode())){
					buildingColor = true;
				}
			}
			stringBuilder.append(character);
			pos++;
		}

	}

	public ACString(String string, int x, int y, Font font){
		this.string = string;
		this.x = x;
		this.y = y;
		this.font = font;
		updateColorCodes();
	}

	public void translateAlternativeColorCodes(String alternativeColorCode) {
		StringBuilder colorBuilder = new StringBuilder();
		StringBuilder stringBuilder = new StringBuilder();
		int pos = 0;
		boolean buildingColor = false;
		for (String character : string.split("")){
			if (buildingColor) {
				assert colorBuilder != null;
				colorBuilder.append(character);
				if (colorBuilder.toString().length() > acObjects.getColorCodeMaxLength()) {
					colorBuilder = null;
					buildingColor = false;
				}
				if (acObjects.getColorCodes().containsKey(colorBuilder.toString())){
					stringBuilder.append(acObjects.getColorCode()).append(colorBuilder);
					colorBuilder = null;
					buildingColor = false;
					pos++;
					continue;
				}
			} else {
				if (character.equals(acObjects.getColorCode())){
					buildingColor = true;
				}
			}
			stringBuilder.append(character);
			pos++;
		}
	}

	public void clearColorCodes(){
		StringBuilder colorBuilder = new StringBuilder();
		StringBuilder stringBuilder = new StringBuilder();
		int pos = 0;
		boolean buildingColor = false;
		for (String character : string.split("")){
			if (buildingColor) {
				colorBuilder.append(character);
				if (colorBuilder.toString().length() > acObjects.getColorCodeMaxLength()) {
					colorBuilder = null;
					buildingColor = false;
				}
				if (acObjects.getColorCodes().containsKey(colorBuilder)){
					colorBuilder = null;
					buildingColor = false;
					pos++;
					continue;
				}
			} else {
				if (character.equals(acObjects.getColorCode())){
					buildingColor = true;
				}
			}
			stringBuilder.append(character);
			pos++;
		}
	}

	public Color getLastColor(){
		return lastColor;
	}

	public void setString(String string) {
		this.string = string;
	}

	public String getString() {
		return string;
	}

	public void draw(Graphics2D g2){
		Font fontO = g2.getFont();
		g2.setFont(font);
		StringBuilder stringBuilder = new StringBuilder();
		StringBuilder newString = new StringBuilder();
		for (String character : string.split("")){
			if (colorPositions.containsKey(stringBuilder.length())) {
				g2.setColor(colorPositions.get(stringBuilder.length()));
				g2.drawString(newString.toString(), x, y);
				newString = null;
			}
			newString.append(character);
			stringBuilder.append(character);
		}
		g2.setFont(fontO);
	}
}
