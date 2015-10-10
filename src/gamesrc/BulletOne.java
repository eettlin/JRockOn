package gamesrc;

import java.awt.Image;
import java.awt.Point;
import java.util.List;

import jgame.Context;
import jgame.GObject;
import jgame.listener.FrameListener;

public class BulletOne extends Bullet {
	private Point startPosition = null;
	private Point currentPosition = null;

	public BulletOne(Image image, Point p) {
		super(image);
		startPosition = p;
		currentPosition = p;
		this.addListener(new FrameListener() {
			public void invoke(GObject target, Context context) {
              if(getDistanceFromStart() > 200){
            	  target.removeSelf(); //++++++++++++++++++++++++  Causing Crash
              }
			}
		});
		

	}

	public Point getStartPosition() {
		return startPosition;
	}

	public Point getCurrentPosition() {
		currentPosition.setLocation((int) this.getX(), (int) this.getY());
		return currentPosition;
	}

	public double getDistanceFromStart() {
		double dx = startPosition.getX() - getCurrentPosition().getX();
		double dy = startPosition.getY() - getCurrentPosition().getY();
		
	    System.out.println(" spx = " + startPosition.getX() + ",  spy = " + startPosition.getY());
		return Math.sqrt(dx * dx + dy * dy);
	}

}
