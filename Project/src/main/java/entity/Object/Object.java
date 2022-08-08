package entity.object.object;

public class Object extends Entity{
  GamePanel gp;
  public Object(GamePanel gp) {
    super(gp);
    this.gp = gp;
  }
	private BufferedImage  image, image2, image3, image4, image5, image6;


	public BufferedImage getObjectImage() {return image;}
	public BufferedImage getObjectImage2() {
		return image2;
	}
	public BufferedImage getObjectImage3() {
		return image3;
	}
	public BufferedImage getObjectImage4() {
		return image4;
	}
	public BufferedImage getObjectImage5() {
		return image5;
	}
	public BufferedImage getObjectImage6() {
		return image6;
	}

	public void setImage(BufferedImage image) {this.image = image;}
	public void setImage2(BufferedImage image2) {
		this.image2 = image2;
	}
	public void setImage3(BufferedImage image3) {
		this.image3 = image3;
	}
	public void setImage4(BufferedImage image4) {
		this.image4 = image4;
	}
	public void setImage5(BufferedImage image5) {
		this.image5 = image5;
	}
	public void setImage6(BufferedImage image6) {
		this.image6 = image6;
	}


	public void draw(Graphics2D g2, GamePanel gp) {
		double screenX = getX() - gp.player.getX() + gp.player.screenX;
		double screenY = getY() - gp.player.getY() + gp.player.screenY;
		if (getX() + gp.tileSize > gp.player.getX() - gp.player.screenX &&
				getX() - gp.tileSize < gp.player.getX() + gp.player.screenX &&
				getY() + gp.tileSize > gp.player.getY() - gp.player.screenY &&
				getY() - gp.tileSize < gp.player.getY() + gp.player.screenY) {
			g2.drawImage(image, (int) screenX, (int) screenY, gp.tileSize, gp.tileSize, null);
		}
	}
}
