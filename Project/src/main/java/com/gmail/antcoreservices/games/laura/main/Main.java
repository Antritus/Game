package com.gmail.antcoreservices.games.laura.main;

import javax.swing.*;
import java.awt.*;

public class Main {
	// todo: login system, launcher, webstie to purchase product from, dlc (more character classes, new com.gmail.antcoreservices.games.laura.map, more entities)
	private static JFrame window;
	private static DefaultSettings defaultSettings;

	public static void main(String[] args) {
		String name = "Laura - Development";
		window = new JFrame(name);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setResizable(false);

		GamePanel gamePanel = new GamePanel(new DefaultSettings());
		window.add(gamePanel);
		window.pack();

		window.setLocationRelativeTo(null);
		window.setVisible(true);

		gamePanel.setupGame();
		defaultSettings = gamePanel.getDefaultSettings();


		gamePanel.startFrameThread();

		window.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/entity/player/down.png")));
	}


	public static void updateName(String name) {
		window.setTitle(name);
//		window.pack();
	}
	public static DefaultSettings getDefaultSettings() {
		return defaultSettings;
	}
}
