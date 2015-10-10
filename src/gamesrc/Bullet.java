package gamesrc;

import java.awt.Image;

import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.listener.BoundaryRemovalListener;
import jgame.listener.FrameListener;

public class Bullet extends GSprite {
	
	private int lifeSpan = 11;
	public Bullet(Image image) {
		super(image);
		addListener(new BoundaryRemovalListener());
		
		FrameListener fl = new FrameListener(){
			public void invoke(GObject target, Context context) {
				lifeSpan--;
				((Bullet) target).setLifeSpan(lifeSpan);
			}	
		};
		addListener(fl);
		if(!lifeLeft()){
			removeListener(fl);
			removeSelf();
		}
		

	}
	
	public boolean lifeLeft(){
		System.out.println("lifeLeft = " +lifeSpan );
		if(getLifeSpan() < 0){
		  return true;
		}
		return false;
	}
	
	public void setLifeSpan(int ls){
		System.out.println("setLifeSpan = " +lifeSpan );
		lifeSpan = ls;
	}
	public int getLifeSpan(){
		return lifeSpan;
	}

}
