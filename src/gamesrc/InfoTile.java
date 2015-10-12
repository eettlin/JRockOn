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
    private int tileNumber = 0;
	public InfoTile(Image img, int tileNumber) {
		super(img, tileNumber);
		image = img;
		this.tileNumber = tileNumber;
		setInfoTile(tileNumber);
		setMenuTile();
	}

	public void setInfoTile(final int tileNumber) {

		GSprite none_img = new GSprite(
				ImageCache.getImage("buttons/b1.png"));
		GSprite hover_img = new GSprite(
				ImageCache.getImage("buttons/b2.png"));
		GSprite pressed_img = new GSprite(
				ImageCache.getImage("buttons/b3.png"));

		setStateSprite(ButtonState.NONE, none_img);
		setStateSprite(ButtonState.HOVERED, hover_img);
		setStateSprite(ButtonState.PRESSED, pressed_img);
		addListener(new ButtonListener() {

			@Override
			public void mouseClicked(Context context) {
				getFirstAncestorOf(LevelOne.class).playAreaOne.createPanel(tileNumber);
			}
		});

	}

	public void setMenuTile() {
		// Override setMenuTile in super class
	}

}
