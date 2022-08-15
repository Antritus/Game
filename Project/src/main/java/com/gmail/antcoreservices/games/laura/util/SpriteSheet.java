package com.gmail.antcoreservices.games.laura.util;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	private BufferedImage image;
	private int height;
	private int width;
	/**
	 * Sets the image to selected image with images height and width.
	 */
	public SpriteSheet(BufferedImage image) {
		this.image = image;
		this.height = image.getHeight();
		this.width = image.getWidth();
	}
	/**
	 * Sets the image to selected image with selected width and height.
	 */
	public SpriteSheet(BufferedImage image, int width, int height) {
		this.image = image;
		this.width = width;
		this.height = height;
	}

	/**
	 * @return Returns the original photo used.
	 */
	public BufferedImage getImage() {
		return image;
	}
	/**
	 * @return Returns the sprite of selected col and row.
	 */
	public BufferedImage getSprite(int col, int row, int width, int height) {
		return image.getSubimage((col * width) - width, (row * height) - height, width, height);
	}
}
