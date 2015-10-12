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
				if (getDistanceFromStart(startPosition, getCurrentPosition())  > 200) {
					target.removeSelf(); 
				}
			}
		});
	}

	public void setStartPosition(Point p) {
		startPosition = p;
	}

	public Point getCurrentPosition() {
		currentPosition.setLocation((int) this.getX(), (int) this.getY());
		return currentPosition;
	}

}
