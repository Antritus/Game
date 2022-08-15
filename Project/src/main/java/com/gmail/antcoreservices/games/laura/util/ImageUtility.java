package com.gmail.antcoreservices.games.laura.util;

import com.gmail.antcoreservices.games.laura.entity.livingentity.humanentity.player.Player;
import com.gmail.antcoreservices.games.laura.main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ImageUtility {
	private Player player;
	private static GamePanel gp;

	public ImageUtility(GamePanel gp) {
		this.gp = gp;
		generateSkinColors();
	}

	int skin[][][] = new int[256][256][256];
	HashMap<String, ArrayList<Color>> skinStorage = new HashMap<String, ArrayList<Color>>();
	ArrayList<Integer> original = new ArrayList<>();

	public void generateSkinColors() {
		int color = new Color(90, 183, 255).getRGB();
		int color1 = new Color(48, 172, 255).getRGB();
		int color2 = new Color(73, 143, 255).getRGB();
		original.clear();
		original.add(color);
		original.add(color1);
		original.add(color2);
		ArrayList<Color> colorList = new ArrayList<>(50);
		colorList.add(new Color(90, 183, 255));
		colorList.add(new Color(3, 231, 0));
		colorList.add(new Color(183, 0, 0));
		skinStorage.put("SKIN_1", colorList);
		ArrayList<Color> colorList2 = new ArrayList<>(50);
		colorList2.add(new Color(0, 124, 0));
		colorList2.add(new Color(3, 0, 213));
		colorList2.add(new Color(183, 211, 0));
		skinStorage.put("SKIN_2", colorList2);
		ArrayList<Color> colorList3 = new ArrayList<>(50);
		colorList3.add(new Color(12, 124, 10));
		colorList3.add(new Color(123, 0, 2));
		colorList3.add(new Color(18, 0, 0));
		skinStorage.put("SKIN_3", colorList3);
		ArrayList<Color> colorList4 = new ArrayList<>(50);
		colorList4.add(new Color(0, 0, 0));
		colorList4.add(new Color(0, 0, 0));
		colorList4.add(new Color(0, 0, 0));
		skinStorage.put("SKIN_4", colorList4);
		ArrayList<Color> colorList5 = new ArrayList<>(50);
		colorList5.add(new Color(0, 124, 0));
		colorList5.add(new Color(3, 0, 213));
		colorList5.add(new Color(183, 211, 0));
		skinStorage.put("SKIN_5", colorList5);
	}

	public BufferedImage changeSkin(String skin, BufferedImage bufferedImage) {
		if (skin == "none") {
			return bufferedImage;
		}
		if (!skinStorage.containsKey(skin.toUpperCase())) {
			return bufferedImage;
		}
		ArrayList<Color> rgb = new ArrayList<>(skinStorage.get(skin.toUpperCase()));
//		rgb = skinStorage.get(skin);
		if (rgb == null) {
			return bufferedImage;
		}
		if (skin.equalsIgnoreCase("none")) {
			return bufferedImage;
		}
		for (int i = 0; i < rgb.size(); i++) {
			bufferedImage = convertBufferedColor(bufferedImage, original.get(i), rgb.get(i));
		}
		return bufferedImage;
	}

	public BufferedImage changeImageBrightness(BufferedImage image, int darkness){
		RescaleOp op = new RescaleOp((float) darkness/100, 0, null);
		return image = op.filter(image, null);
	}

	public BufferedImage convertBufferedColor(BufferedImage image, int oldRGB, Color newRGB) {
		final int match = oldRGB;

		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
				final int irgb = image.getRGB(x, y);
				if (irgb == match) {
					image.setRGB(x, y, newRGB.getRGB());
				}
			}
		}
		return image;
	}

	public BufferedImage convertBufferedColor(BufferedImage image, int oldR, int oldG, int oldB, int newR, int newG, int newB) {
		final int match = new Color(oldR, oldG, oldB).getRGB();

		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
				final int irgb = image.getRGB(x, y);
				if (irgb == match) {
					image.setRGB(x, y, new Color(newR, newG, newB).getRGB());
				}
			}
		}
		return image;
	}

	public static BufferedImage flipHorizontally(BufferedImage image) {
		AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		tx.translate(-image.getWidth(null), 0);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		image = op.filter(image, null);
		return image;
	}
	public static BufferedImage flipVertically(BufferedImage image) {
		AffineTransform tx = AffineTransform.getScaleInstance(-1, -1);
		tx.translate(-image.getWidth(null), -image.getHeight(null));
		AffineTransformOp op = new AffineTransformOp(tx,
				AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		image = op.filter(image, null);
		return image;
	}


	public static BufferedImage scale(BufferedImage img, int newW, int newH) {
		Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
		BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = dimg.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();

		return dimg;
	}
	public BufferedImage setup(String imagePath) {
		try {
			BufferedImage image = ImageIO.read(this.getClass().getResourceAsStream(imagePath));
			return image;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static BufferedImage setup(String imagePath, boolean turnHorizontally, boolean upsideDown) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(ImageUtility.class.getResourceAsStream(imagePath));
			if (upsideDown) {
				image = flipVertically(image);
			} if (turnHorizontally) {
				image = flipHorizontally(image);
			}
			image = scale(image, gp.getDefaultSettings().getTileSize(), gp.getDefaultSettings().getTileSize());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	public static BufferedImage setup(String imagePath, boolean turnHorizontally, boolean upsideDown, int size) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(ImageUtility.class.getResourceAsStream(imagePath));
			if (upsideDown) {
				image = flipVertically(image);
			} if (turnHorizontally) {
				image = flipHorizontally(image);
			}
			image = scale(image, size, size);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

	public BufferedImage[] getImageSheetImages(BufferedImage sheet, int width, int height, int rows, int cols){

		BufferedImage[] sprites = new BufferedImage[rows * cols];

		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				sprites[(i * cols) + j] = sheet.getSubimage(
						j * width,
						i * height,
						width,
						height
				);
			}
		}
		return sprites;
	}
	public BufferedImage getImageSheetImage(BufferedImage sheet, int width, int height, int rows, int cols, int imageNumber){
		final int widthU = width;
		final int heightU = height;
		final int rowsU = rows;
		final int colsU = cols;
		BufferedImage[] sprites = new BufferedImage[rowsU * colsU];

		for (int i = 0; i < rowsU; i++)
		{
			for (int j = 0; j < colsU; j++)
			{
				sprites[(i * colsU) + j] = sheet.getSubimage(
						j * widthU,
						i * heightU,
						widthU,
						heightU
				);
			}
		}
		return sprites[imageNumber];
	}
}
