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

public class Menu extends GContainer {
	
	public Menu() {
		setSize(1100, 900);
		MenuBackground mbg = new MenuBackground();
		addAtCenter(mbg);
		
		GSprite none_img = new GSprite(ImageCache.getImage("buttons/btn.png"));
		GSprite hover_img = new GSprite(ImageCache.getImage("buttons/bhb.png"));
		GSprite pressed_img = new GSprite(ImageCache.getImage("buttons/bpb.png"));
		GButton playButton = new GButton();
		GButton intructButton = new GButton();
		GButton quitButton = new GButton();
		
		playButton.setStateSprite(ButtonState.NONE, none_img);
		playButton.setStateSprite(ButtonState.HOVERED, hover_img);
		playButton.setStateSprite(ButtonState.PRESSED, pressed_img);
		playButton.setScale(.9);
		addAt(playButton, 100, 800);

		quitButton.setStateSprite(ButtonState.NONE, none_img);
		quitButton.setStateSprite(ButtonState.HOVERED, hover_img);
		quitButton.setStateSprite(ButtonState.PRESSED, pressed_img);
		quitButton.setScale(.9);
		addAt(quitButton, 400, 800);
		
		intructButton.setStateSprite(ButtonState.NONE, none_img);
		intructButton.setStateSprite(ButtonState.HOVERED, hover_img);
		intructButton.setStateSprite(ButtonState.PRESSED, pressed_img);
		intructButton.setScale(.9);
		addAt(intructButton, 700, 800);	
		
		
		ButtonListener playListener = new ButtonListener() {
			// goto Source --> Override and Implement
			@Override
			public void mouseClicked(Context context) {
				super.mouseClicked(context);
				context.setCurrentGameView(Views.LEVEL_ONE);
			}
		};
		playButton.addListener(playListener);
		
		ButtonListener instListener = new ButtonListener() {
			// goto Source --> Override and Implement
			@Override
			public void mouseClicked(Context context) {
				super.mouseClicked(context);
				context.setCurrentGameView(Views.INSTRUCT);
			}
		};
		intructButton.addListener(instListener);
		
		ButtonListener quitListener = new ButtonListener() {
			// goto Source --> Override and Implement
			@Override
			public void mouseClicked(Context context) {
				super.mouseClicked(context);
				context.setCurrentGameView(Views.GAME_OVER);
			}
		};
		quitButton.addListener(quitListener);
		
		GMessage msg_play= new GMessage("Play");
		msg_play.setAnchorCenter();
		msg_play.setFontSize(18);
		msg_play.setColor(Color.yellow);
		msg_play.setY(840);
		msg_play.setX(200);
		add(msg_play);
		
		GMessage msgInstructions = new GMessage("Instructions");
		msgInstructions.setAnchorCenter();
		msgInstructions.setFontSize(18);
		msgInstructions.setColor(Color.yellow);
		msgInstructions.setY(840);
		msgInstructions.setX(500);
		add(msgInstructions);
		
		GMessage msgQuit = new GMessage("Quit");
		msgQuit.setAnchorCenter();
		msgQuit.setFontSize(18);
		msgQuit.setColor(Color.yellow);
		msgQuit.setY(840);
		msgQuit.setX(800);
		add(msgQuit);
	}
	
	
}
