package gamesrc;

import java.awt.Image;
import java.awt.Point;

import jgame.Context;
import jgame.GObject;
import jgame.controller.ConstantRotationController;
import jgame.listener.FrameListener;

public class BulletTwo extends Bullet {
	private Point startPosition = null;
	private Point currentPosition = null;

	public BulletTwo(Image image, Point p) {
		super(image);
		startPosition = p;
		currentPosition = p;
		this.addListener(new FrameListener() {
			public void invoke(GObject target, Context context) {
				if (getDistanceFromStart(startPosition, getCurrentPosition()) > 300) {
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
