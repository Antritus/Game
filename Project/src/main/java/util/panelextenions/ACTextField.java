package util.panelextenions;

import java.awt.*;
import java.awt.image.BufferedImage;

@SuppressWarnings("unused")
public class ACTextField {
	private String textFieldText;
	private String backroundText;
	private String tooltipText;
	private BufferedImage frameImage;
	private BufferedImage centerImage;
	private BufferedImage cursorImage;
	private BufferedImage tooltipFrameImage;
	private BufferedImage tooltipCenterImage;
	private Shape frameShape; // Only applied when using colors and not images.
	private Shape centerShape;
	private Shape cursorShape;
	private Shape tooltipShape;
	private Shape tooltipBackroundShape;
	private Color backroundTextColor;
	private Color cursorColor;
	private Color textColor;
	private Color frameColor;
	private Color centerColor;
	private Color tooltipFrameColor;
	private Color tooltipBackroundColor;
	private Color tooltipTextColor;
	private int maxRows;
	private int rows;
	private boolean isColliding;
	private boolean isFocusable;
	private boolean isFocused;
	private boolean isVisible;
	private boolean isCursorBlinking;
	private boolean canCursorBlink;
	private boolean hasCursorShape;
	private boolean hasFrameImage, hasCenterImage, hasTooltipFrameImage, hasTooltipBackgroundImage;
	private boolean fillFrameShape, fillCenterShape, fillCursorShape, fillTooltipFrameShape, fillToolTipCenterShape;
	private float updateTime;
	private float cursorBlinkUpdateTime;
	private int textFieldX;
	private int textFieldY;
	private int textFieldWidth;
	private int textFieldHeight;
	private int cursorX;
	private int cursorY;
	private int cursorWidth;
	private int cursorHeight;
	private int tooltipX;
	private int tooltipY;
	private int tooltipWidth;
	private int tooltipHeight;

	private Thread thread;

	public ACTextField(String textFieldText, String textFieldBackroundText, String textFieldTooltipText, int textFieldX, int textFieldY, int textFieldWidth, int textFieldHeight) {
		this.textFieldText = textFieldText;
		this.backroundText = textFieldBackroundText;
		this.tooltipText = textFieldTooltipText;
		this.textFieldX = textFieldX;
		this.textFieldY = textFieldY;
		this.textFieldWidth = textFieldWidth;
		this.textFieldHeight = textFieldHeight;
		this.isVisible = true;
	}

	public void setDefaults() {
		this.centerShape = new Rectangle();
	}

	public void setBackgroundString(String string) {
		this.backroundText = string;
	}
	public void removeBackroundString(){
		this.backroundText = null;
	}
	public void setVisible(boolean v) {
		this.isVisible = v;
	}

	public Color getBackroundTextColor() {
		return backroundTextColor;
	}

	public void setBackroundTextColor(Color backroundTextColor) {
		this.backroundTextColor = backroundTextColor;
	}

	public Color getCursorColor() {
		return cursorColor;
	}

	public void setCursorColor(Color cursorColor) {
		this.cursorColor = cursorColor;
	}

	public Color getTextColor() {
		return textColor;
	}

	public void setTextColor(Color textColor) {
		this.textColor = textColor;
	}

	public Color getFrameColor() {
		return frameColor;
	}

	public void setFrameColor(Color frameColor) {
		this.frameColor = frameColor;
	}

	public Color getCenterColor() {
		return centerColor;
	}

	public void setCenterColor(Color centerColor) {
		this.centerColor = centerColor;
	}

	public Color getTooltipFrameColor() {
		return tooltipFrameColor;
	}

	public void setTooltipFrameColor(Color tooltipFrameColor) {
		this.tooltipFrameColor = tooltipFrameColor;
	}

	public Color getTooltipBackroundColor() {
		return tooltipBackroundColor;
	}

	public void setTooltipBackroundColor(Color tooltipBackroundColor) {
		this.tooltipBackroundColor = tooltipBackroundColor;
	}

	public Color getTooltipTextColor() {
		return tooltipTextColor;
	}

	public void setTooltipTextColor(Color tooltipTextColor) {
		this.tooltipTextColor = tooltipTextColor;
	}

	public int getMaxRows() {
		return maxRows;
	}

	public void setMaxRows(int maxRows) {
		this.maxRows = maxRows;
	}

	public int getRows() {
		return rows;
	}

	public boolean isColliding() {
		return isColliding;
	}

	public boolean isFocusable() {
		return isFocusable;
	}

	public void setFocusable(boolean focusable) {
		isFocusable = focusable;
	}

	public boolean isFocused() {
		return isFocused;
	}

	public boolean isCursorBlinking() {
		return isCursorBlinking;
	}

	public boolean isCanCursorBlink() {
		return canCursorBlink;
	}

	public void setCanCursorBlink(boolean canCursorBlink) {
		this.canCursorBlink = canCursorBlink;
	}

	public boolean isHasFrameImage() {
		return hasFrameImage;
	}

	public boolean isHasCenterImage() {
		return hasCenterImage;
	}

	public boolean isHasTooltipFrameImage() {
		return hasTooltipFrameImage;
	}

	public boolean isHasTooltipBackgroundImage() {
		return hasTooltipBackgroundImage;
	}

	public float getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(float updateTime) {
		this.updateTime = updateTime;
	}

	public float getCursorBlinkUpdateTime() {
		return cursorBlinkUpdateTime;
	}

	public void setCursorBlinkUpdateTime(float cursorBlinkUpdateTime) {
		this.cursorBlinkUpdateTime = cursorBlinkUpdateTime;
	}

	public int getTextFieldX() {
		return textFieldX;
	}

	public void setTextFieldX(int textFieldX) {
		this.textFieldX = textFieldX;
	}

	public int getTextFieldY() {
		return textFieldY;
	}

	public void setTextFieldY(int textFieldY) {
		this.textFieldY = textFieldY;
	}

	public int getTextFieldWidth() {
		return textFieldWidth;
	}

	public void setTextFieldWidth(int textFieldWidth) {
		this.textFieldWidth = textFieldWidth;
	}

	public int getTextFieldHeight() {
		return textFieldHeight;
	}

	public void setTextFieldHeight(int textFieldHeight) {
		this.textFieldHeight = textFieldHeight;
	}


	public void draw(Graphics2D g2) {
		if (!isVisible) {
			return;
		}
		if (hasFrameImage) {
			g2.drawImage(frameImage, textFieldX, textFieldY, textFieldWidth, textFieldHeight, null);
		} else{
			if (fillFrameShape) {
				g2.fill(frameShape);
			} else {
				g2.draw(frameShape);
			}
		}
		if (hasCenterImage) {
			g2.drawImage(centerImage, textFieldX+2, textFieldY+2, textFieldWidth-2, textFieldHeight-2, null);
		} else {
			if (fillCenterShape) {
				g2.fill(centerShape);
			} else {
				g2.draw(centerShape);
			}
		}
		if (hasCursorShape) {
			g2.drawImage(cursorImage, cursorX, cursorY, cursorWidth, cursorHeight, null);
		} else{
			if (fillCursorShape) {
				g2.fill(cursorShape);
			} else {
				g2.draw(cursorShape);
			}
		}
	}

	private void setup(){
		frameColor = new Color(122, 138, 153);
		centerColor = new Color(255, 255, 255);
		cursorColor = new Color(51, 51, 51);
		textColor = new Color(51, 51, 51);
		backroundTextColor = new Color(137, 137, 137);
	}
}
