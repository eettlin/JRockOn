package gamesrc;

import java.awt.Color;
import java.awt.Point;

import jgame.GRootContainer;
import jgame.Game;
import jgame.ImageCache;

public class TowerGame extends Game {

	public static void main(String[] args) {
		ImageCache.create(TowerGame.class, "/rsc/");
        TowerGame tg = new TowerGame();
        tg.startGame();
	}

	public TowerGame() {
		GRootContainer root  = new GRootContainer(Color.BLACK);
		setRootContainer(root);
		
		Menu menu = new Menu();
		root.addView(Views.MENU, menu);
		
		Instructions instructions = new Instructions();
		root.addView(Views.INSTRUCT, instructions);
		
		LevelOne levelOne = new LevelOne();
		root.addView(Views.LEVEL_ONE, levelOne);
		
		GameOver gameOver = new GameOver();
		root.addView(Views.GAME_OVER, gameOver);
	}

	public enum Views {
		INSTRUCT, MENU, LEVEL_ONE, GAME_OVER
	}
}
