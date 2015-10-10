package gamesrc;

import java.awt.Image;
import java.awt.image.BufferedImage;

import jgame.ButtonState;
import jgame.Context;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.ButtonListener;

public class InfoTile extends Tile {
    private Image image = null;
	public InfoTile(Image img, int tileNumber) {
		super(img, tileNumber);
		image = img;
		setInfoTile(tileNumber);
	}

	public void setInfoTile(int tileNumber) {

		GSprite none_img = new GSprite(
				ImageCache.getImage("buttons/infotile.png"));
		GSprite hover_img = new GSprite(
				ImageCache.getImage("buttons/infotile.png"));
		GSprite pressed_img = new GSprite(
				ImageCache.getImage("buttons/infotile.png"));

		setStateSprite(ButtonState.NONE, none_img);
		setStateSprite(ButtonState.HOVERED, hover_img);
		setStateSprite(ButtonState.PRESSED, pressed_img);

		GSprite tileIcon = new GSprite(image);
		tileIcon.setScale(.8);
		addAtCenter(tileIcon);

/*		addListener(new ButtonListener() {
			@Override
			public void mouseClicked(Context context) {
				System.out.print(true);
			}
		});*/
	}

}
