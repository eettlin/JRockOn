package gamesrc;

import java.awt.Image;
import java.awt.Point;

import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.listener.BoundaryRemovalListener;
import jgame.listener.FrameListener;

public abstract class Bullet extends GSprite {

	public Bullet(Image image) {
		super(image);
		addListener(new BoundaryRemovalListener());
		FrameListener fl = new FrameListener(){
			public void invoke(GObject target, Context context) {
				//((Bullet) target).setLifeSpan(lifeSpan);
			}	
		};
		addListener(fl);
	}
	// abstract methods
	public abstract void setStartPosition(Point p);
	public abstract Point getCurrentPosition();//  we don't need this
	public double getDistanceFromStart(Point p1, Point p2) {
		double dx = p1.getX() - p2.getX();
		double dy = p1.getY() - p2.getY();

		double d = Math.sqrt(dx * dx + dy * dy);
		return d;
	}

}
