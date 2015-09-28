package gamesrc;

import java.awt.image.BufferedImage;

import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;

public class InfoArea extends GContainer {
	public InfoArea() {
		setSize(100, 900);
		BufferedImage bg = ImageCache.forClass(TowerGame.class).get("infoarea.png");
		GSprite gs = new GSprite(bg);
		setBackgroundSprite(gs);
	}
}
