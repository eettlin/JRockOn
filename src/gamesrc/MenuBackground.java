package gamesrc;

import java.awt.image.BufferedImage;

import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;

public class MenuBackground extends GSprite {
	
	
	public MenuBackground() {
		super(ImageCache.getImage("bg88.png"));
		
		BufferedImage image = ImageCache.forClass(TowerGame.class).getImage("panels/marq.png");
		GSprite gs = new GSprite(image);
		gs.setScale(.75);
		gs.setX(500);
		gs.setY(150);
		add(gs);
		GSprite marquee = new GSprite(image);
		
	}
}
