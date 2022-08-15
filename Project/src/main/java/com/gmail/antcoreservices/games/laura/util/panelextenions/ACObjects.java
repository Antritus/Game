package com.gmail.antcoreservices.games.laura.util.panelextenions;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ACObjects {

	private final HashMap<Integer, ACPasswordField> passwordFieldIDs = new HashMap<>();
	private final HashMap<Integer, ACTextField> textFieldIDs = new HashMap<>();
	private final HashMap<Integer, ACButton> buttonIDs = new HashMap<>();
	private final HashMap<String, Color> colorCodes = new HashMap<>();

	private final ArrayList<String> codes = new ArrayList<>();
	private final ArrayList<Color> colors = new ArrayList<>();
	private final String colorCode = "§";
	private int colorCodeMaxLength;

	public ACObjects(){
		setupColorCodes();
	}

	public void setupColorCodes() {
		colors.add(Color.BLACK);
		colors.add(Color.RED);
		colors.add(Color.ORANGE);
		colors.add(Color.YELLOW);
		colors.add(Color.GREEN);
		colors.add(Color.cyan);
		codes.add("0");
		codes.add("1");
		codes.add("2");
		codes.add("3");
		codes.add("4");
		codes.add("5");
//		codes.add("6");
		for (int i = 0; i < colors.size(); i++){
			colorCodes.put(codes.get(i), colors.get(i));
		}
		for (String key : colorCodes.keySet()){
			if (key.length() > colorCodeMaxLength) {
				colorCodeMaxLength = key.length();
			}
		}
	}
	public int getColorCodeMaxLength() {
		return colorCodeMaxLength;
	}
	public HashMap<String, Color> getColorCodes() {
		return colorCodes;
	}
	public String getColorCode() {
		return colorCode;
	}

	public HashMap<Integer, ACPasswordField> getPasswordFieldIDs() {
		return passwordFieldIDs;
	}

	public HashMap<Integer, ACTextField> getTextFieldIDs() {
		return textFieldIDs;
	}

	public HashMap<Integer, ACButton> getButtonIDs() {
		return buttonIDs;
	}
}
