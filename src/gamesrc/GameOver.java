package gamesrc;

import java.awt.Color;

import jgame.GContainer;
import jgame.GMessage;

public class GameOver extends GContainer {
	public GameOver() {
		setSize(1100, 900);
		MenuBackground mbg = new MenuBackground();
		addAtCenter(mbg);
		
		GMessage endGame = new GMessage("Game Over");
		endGame.setAnchorCenter();
		endGame.setFontSize(48);
		endGame.setColor(Color.BLUE);
		endGame.setY(300);
		endGame.setX(300);
		add(endGame);
	}
}
