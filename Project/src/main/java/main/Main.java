package main;

import entity.Entity;
import main.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	// todo: login system, launcher, webstie to purchase product from, dlc (more character classes, new map, more entities)
	private static JFrame window;
	public static void main(String[] args) {
		String name = "Laura - Development";
		window = new JFrame(name);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setResizable(false);

		GamePanel gamePanel = new GamePanel(name);
		window.add(gamePanel);
		window.pack();

		window.setLocationRelativeTo(null);
		window.setVisible(true);

		gamePanel.setupGame();


		gamePanel.startFrameThread();

		window.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/entity/player/down.png")));
	}


	public static void updateName(String name) {
		window.setTitle(name);
//		window.pack();
	}
	public static void updateIcon(Image icon) {
		window.setIconImage(icon);
	}
}
