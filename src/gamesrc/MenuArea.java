package gamesrc;

import java.awt.image.BufferedImage;
import java.util.List;
import java.awt.Image;
import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;



public class MenuArea extends GContainer {

	private int MAX_TILES = 7;

	public MenuArea() {
		setSize(1000, 100);
		BufferedImage bg = ImageCache.forClass(TowerGame.class).get("menu2.png");
		GSprite gs = new GSprite(bg);
		setBackgroundSprite(gs);

		for (int i = 0; i < MAX_TILES; i++) {
			setTile(i);
		}
	}

	List<Image> tileImages = ImageCache.getSequentialImages("icons/t", 1, 7, "icon.png");
	
	private void setTile(int i) {
		Tile tile = new Tile(tileImages.get(i), i);
		tile.setAnchorTopLeft();
		tile.setScale(.9);
		tile.setY(5);
		tile.setX(i*145 + 20);
		add(tile);
	}
}
