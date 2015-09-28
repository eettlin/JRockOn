package gamesrc;
import gamesrc.TowerGame.Views;
import java.awt.Color;
import jgame.ButtonState;
import jgame.Context;
import jgame.GButton;
import jgame.GContainer;
import jgame.GMessage;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.ButtonListener;

public class Instructions extends GContainer {
	public Instructions() {
		setSize(1100, 900);
		MenuBackground mbg = new MenuBackground();
		addAtCenter(mbg);
		
		GMessage endGame = new GMessage("Don't Die");
		endGame.setAnchorCenter();
		endGame.setFontSize(64);
		endGame.setColor(Color.BLUE);
		endGame.setY(300);
		endGame.setX(300);
		add(endGame);
		
		GSprite none_img = new GSprite(ImageCache.getImage("buttons/btnnone.png"));
		GSprite hover_img = new GSprite(ImageCache.getImage("buttons/btnhover.png"));
		GSprite pressed_img = new GSprite(ImageCache.getImage("buttons/btnpressed.png"));
		GButton backButton = new GButton();

		backButton.setStateSprite(ButtonState.NONE, none_img);
		backButton.setStateSprite(ButtonState.HOVERED, hover_img);
		backButton.setStateSprite(ButtonState.PRESSED, pressed_img);
		addAt(backButton, 400, 500);
		
		ButtonListener quitListener = new ButtonListener() {
			// goto Source --> Override and Implement
			@Override
			public void mouseClicked(Context context) {
				super.mouseClicked(context);
				context.setCurrentGameView(Views.MENU);
			}
		};
		backButton.addListener(quitListener);
	}
}
