package gamesrc;

import java.awt.Color;
import java.awt.Image;

import jgame.ButtonState;
import jgame.Context;
import jgame.GButton;
import jgame.GMessage;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.ButtonListener;

public class PopUpPanel extends GButton {
	private Image image;
	private int panelNumber;

	public PopUpPanel(Image img, int pn) {
		super();
		image = img;
		setPanelNumber(pn);
        setSize(440, 190);
		setPanel();	
		//addGMessge();
	}

	public void setPanel() {
		GSprite none_img = new GSprite(ImageCache.getImage("panels/pbg.png"));
		GSprite hover_img = new GSprite(ImageCache.getImage("panels/pbg.png"));
		GSprite pressed_img = new GSprite(ImageCache.getImage("panels/pbg.png"));

		setStateSprite(ButtonState.NONE, none_img);
		setStateSprite(ButtonState.HOVERED, hover_img);
		setStateSprite(ButtonState.PRESSED, pressed_img);

		GSprite panel = new GSprite(image);
		panel.setScaleX(1.0);
		panel.setScaleY(1.1);
		addAtCenter(panel); //  adds front
		
		addListener(new ButtonListener(){
			@Override
			public void mouseClicked(Context context){
				removeSelf();
			}		
		});
		
	}

	 public void addGMessge(){
		 GMessage gm = new GMessage();
		 gm.setFontSize(36);
		 gm.setColor(Color.red);
		 gm.setText("" + getPanelNumber());
		 addAtCenter(gm);
	 
	 }
	public int getPanelNumber() {
		return panelNumber;
	}

	public void setPanelNumber(int panelNumber) {
		this.panelNumber = panelNumber;
	}

}
