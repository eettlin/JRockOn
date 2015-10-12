package gamesrc;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.List;

import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;

public class InfoArea extends GContainer {
	private int MAX_INFO_TILES = 8;
	public InfoArea() {
		super();

		setSize(100, 900);
		BufferedImage bg = ImageCache.forClass(TowerGame.class).get("infoarea.png");
		GSprite gs = new GSprite(bg);
		setBackgroundSprite(gs);

		for (int i = 0; i < MAX_INFO_TILES; i++) {
			setInfoTile(i);
		}
		
		
	
		
	}
	BufferedImage tileImage = ImageCache.getImage("buttons/infotile.png");

	private void setInfoTile(int i) {
		InfoTile infoTile = new InfoTile(tileImage, i);
		infoTile.setAnchorTopLeft();
		infoTile.setScale(.8);
		infoTile.setX(18);
		infoTile.setY(i * 125 + 35);
		add(infoTile);
	}

	
	
}
