package gamesrc;

import java.awt.Image;

import jgame.ButtonState;
import jgame.Context;
import jgame.GButton;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.ButtonListener;

public class Tile extends GButton {
	public Tile(Image image, final int tn) {
		setSize(90,90);
		
		GSprite none_img = new GSprite(ImageCache.getImage("buttons/btnnone_turret.png"));
		GSprite hover_img = new GSprite(ImageCache.getImage("buttons/btnhover_turret.png"));
		GSprite pressed_img = new GSprite(ImageCache.getImage("buttons/btnpressed_turret.png"));

		setStateSprite(ButtonState.NONE, none_img);
		setStateSprite(ButtonState.HOVERED, hover_img);
		setStateSprite(ButtonState.PRESSED, pressed_img);

		GSprite tileIcon = new GSprite(image);
		tileIcon.setScale(.8);
		addAtCenter(tileIcon);
		
		addListener(new ButtonListener(){
			@Override
			public void mouseClicked(Context context){
				getFirstAncestorOf(LevelOne.class ).initializeTurret(tn);
			}
			
		});
	}
}
