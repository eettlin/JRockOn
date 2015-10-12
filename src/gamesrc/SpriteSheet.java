package gamesrc;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	private BufferedImage spriteSheet;
	
	public SpriteSheet(BufferedImage spriteSheet) {
		this.spriteSheet = spriteSheet;
   	}
	
	public BufferedImage getSprite(int a, int b){
		BufferedImage sprite = spriteSheet.getSubimage(a,  b,  50, 50);
		return sprite;
	}
}
